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
    private static HashMap<String,String> currentConnections = new HashMap<>();
    private ZMQ.Socket socket = ctx.socket(SocketType.REP);


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
            // Espera mensajes de los clientes (dispositivos)
            byte[] request = this.socket.recv(0);
            String message = new String(request, ZMQ.CHARSET);
            newConnection(message);
            System.out.println("Recibido: " + message);

            // Procesa el mensaje y responde
            String reply = "Respuesta para " + message;
            this.socket.send(reply.getBytes(ZMQ.CHARSET), 0);
        }
    }

    public static void newConnection(String data){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Message msg = objectMapper.readValue(data, Message.class);
            String userID = msg.getUserID();
            String userIP = msg.getUserIP();
            if(!currentConnections.containsKey(userIP)){
                currentConnections.put(userIP,userID);
            }
            System.out.println(currentConnections.toString());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        RepSocket socket = new RepSocket(11434);
        System.out.println(currentConnections.toString());
        socket.answerMessage();
    }









}