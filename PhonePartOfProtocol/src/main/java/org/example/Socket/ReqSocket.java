package org.example.Socket;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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


public class ReqSocket {
    private static ZMQ.Context ctx = ZMQ.context(1);
    private ZMQ.Socket socket = ctx.socket(SocketType.REQ);
    private String socketID = Main.deviceID;

    public ReqSocket(int devicePort){
        try {
            socket.connect("tcp://127.0.0.1:" + devicePort);
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


    public void sendMessage(Message m){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(m);
            System.out.println(json);
            Thread.sleep(250);
            this.socket.send(json);
            String message = this.socket.recvStr();
            System.out.println("Mensaje recibido: " + message);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
        ReqSocket reqSocket = new ReqSocket(11434);
        Message m = new Message(reqSocket.socketID, PublicIPAddress.getMyIP(),MACAddress.getMACAddress(), Message.DeviceType.MOBILE,MessageTypes.CONNECTION,null);
        reqSocket.sendMessage(m);
    }


}