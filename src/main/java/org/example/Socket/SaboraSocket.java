package org.example.Socket;
import org.example.Instruction.Instruction;
import org.example.Instruction.InstructionFactory;
import org.example.Instruction.InstructionTypes;
import org.example.Main;
import org.example.Message.Message;
import org.example.Message.MessageTypes;
import org.example.Utils.MACAddress;
import org.example.Utils.PublicIPAddress;
import org.zeromq.SocketType;
import org.zeromq.ZMQ;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SaboraSocket {
    private ZMQ.Context ctx = ZMQ.context(1);
    private ZMQ.Socket socket;
    private String socketID = Main.deviceID;
     private List message = new ArrayList<>();

    public SaboraSocket(SocketType type, String[] directions, int devicePort){
        try {
            socket = ctx.socket(type);
            socket.bind("tcp://*:" + devicePort);
            message.add(socketID);
            message.add(directions[0]); // En la posición 0 del array tendrá que ir siempre la direccion IP pública
            message.add(directions[1]); // En la posicion 1 del array irá la dirección MAC del adaptador por si acaso

        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void closeSocket(){
        this.ctx.close();
        this.socket.close();
    }

    public static String generateID(){
        int[] asciiTotal = new int[10 + 26 + 26]; int index = 0;
        String res = "";
        Random r = new Random();
        for (int i = 0; i < 10; i++) asciiTotal[index++] = '0' + i;
        for (int i = 0; i < 26; i++) asciiTotal[index++] = 'A' + i;
        for (int i = 0; i < 26; i++) asciiTotal[index++] = 'a' + i;

        for(int i = 0; i < 64;i++) res += (char) asciiTotal[r.nextInt(0,asciiTotal.length)];
        return res;
    }

    public void sendMessage(Message message){
        this.message.add(message.getStringType());
        Instruction ins = message.getInstruction();
        this.message.add(ins);
        System.out.println(this.message);
        this.socket.send(this.message.toString());
        this.message.remove(message.getStringType());
        this.message.remove(ins);
        }



    public static void main(String[] arg){
        String myIP = PublicIPAddress.getMyIP();
        String myMAC = MACAddress.getMACAddress();
        SocketFactory sf = new SocketFactory();
        SaboraSocket s = sf.createPubSocket(new String[]{myIP, myMAC},11434);
        InstructionFactory InsF = new InstructionFactory();
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(InsF.createControlInstruction(InstructionTypes.START_EXPERIENCE,null));
        instructions.add(InsF.createSoundInstruction(InstructionTypes.FULL_VOLUME,null));
        instructions.add(InsF.createScenarioInstruction(InstructionTypes.BACK_TO_MENU,null));
        instructions.add(InsF.createSoundInstruction(InstructionTypes.INCREASE_VOLUME,20));
        for(Instruction ins : instructions){
            Message msg = new Message(MessageTypes.ACTION,ins);
            s.sendMessage(msg);
        }

    }




}