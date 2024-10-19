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


public class PubSocket {
    private static ZMQ.Context ctx = ZMQ.context(1);
    private ZMQ.Socket socket = ctx.socket(SocketType.PUB);
    private String socketID = Main.deviceID;

    public PubSocket(int devicePort){
        try {
            socket.bind("tcp://127.0.0.1:" + devicePort);
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





    public static void main(String[] arg) throws InterruptedException {
        InstructionFactory InsF = new InstructionFactory();
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(InsF.createControlInstruction(InstructionTypes.START_EXPERIENCE,"null"));
        instructions.add(InsF.createSoundInstruction(InstructionTypes.FULL_VOLUME,"null"));
        instructions.add(InsF.createScenarioInstruction(InstructionTypes.BACK_TO_MENU,"null"));
        instructions.add(InsF.createSoundInstruction(InstructionTypes.INCREASE_VOLUME,20));

        PubSocket prueba = new PubSocket(11434);
        Message m = new Message(prueba.socketID, PublicIPAddress.getMyIP(),MACAddress.getMACAddress(),MessageTypes.ACTION,null);
        int i = 0;

        while(true){
            if(i == 0) prueba.socket.send("¡NUEVAS INSTRUCCIONES!");
                if (i < instructions.size()) {
                    Thread.sleep(250);
                    m.setInstruction(instructions.get(i));
                    prueba.socket.send(m.toString());
                    // Simulación de espera, puede bloquear la ejecución
                    i++;
                }
                else{break;}


        }


    }




}