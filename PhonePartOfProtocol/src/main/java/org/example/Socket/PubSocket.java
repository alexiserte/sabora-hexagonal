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
import java.util.HashMap;
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




    public void sendMessage(Message m){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(m);
            System.out.println(json);
            Thread.sleep(250);
            this.socket.send(json);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] arg) throws InterruptedException {
        InstructionFactory InsF = new InstructionFactory();

        PubSocket prueba = new PubSocket(11434);
        Message m = new Message(prueba.socketID, PublicIPAddress.getMyIP(),MACAddress.getMACAddress(), Message.DeviceType.MOBILE,MessageTypes.SEARCH,new HashMap<>(),null);
        prueba.sendMessage(m);
        int i = 0;




    }




}