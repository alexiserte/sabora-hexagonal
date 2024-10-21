package com.sabora.server.Socket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import zmq.socket.reqrep.Rep;

import java.util.HashMap;
import java.util.Random;


public class RepSocket {
    private static ZMQ.Context ctx = ZMQ.context(1);
    private static HashMap<String,String> currentGlassesConnections = new HashMap<>();
    private ZMQ.Socket socket = ctx.socket(SocketType.REP);
    private static ObjectMapper objectMapper = new ObjectMapper();


    public RepSocket(int devicePort){
        try {
            socket.bind("tcp://*:" + devicePort);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void closeSocket(){
        this.ctx.close();
        this.socket.close();
    }



    public void answerMessage(){
        while (true) {
            try {
                byte[] request = this.socket.recv(0);
                String message = new String(request, ZMQ.CHARSET);
                Message msg = objectMapper.readValue(message, Message.class);
                switch(msg.getType()){
                    case "CONNECTION":
                        newConnection(msg);
                        break;
                    default:
                        System.out.println("FUNCIONALIDADES NO IMPLEMENTADAS");
                }
                System.out.println("Recibido: " + message);

                // Procesa el mensaje y responde
                String reply = "Respuesta para " + message;
                this.socket.send(reply.getBytes(ZMQ.CHARSET), 0);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void newConnection(Message msg){
        try {
            String userIP = msg.getUserIP();
            if(msg.getDeviceType().equals("VR_GLASSES")) {
                String userID = msg.getUserID();
                if (!currentGlassesConnections.containsKey(userIP)) {
                    currentGlassesConnections.put(userIP, userID);
                }
            }
            else if(msg.getDeviceType().equals("MOBILE")){


            }
            System.out.println(currentGlassesConnections.toString());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        RepSocket socket = new RepSocket(11434);
        System.out.println(currentGlassesConnections.toString());
        socket.answerMessage();
    }









}