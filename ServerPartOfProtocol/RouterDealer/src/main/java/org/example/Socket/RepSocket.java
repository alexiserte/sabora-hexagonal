package org.example.Socket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Main;
import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import zmq.socket.reqrep.Rep;

import java.util.Random;


public class RepSocket {
    private static ZMQ.Context ctx = ZMQ.context(1);
    private ZMQ.Socket socket = ctx.socket(SocketType.REQ);


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


    public void answerMessage(){
        while (!Thread.currentThread().isInterrupted()) {
            // Espera mensajes de los clientes (dispositivos)
            byte[] request = this.socket.recv(0);
            String message = new String(request, ZMQ.CHARSET);
            System.out.println("Recibido: " + message);

            // Procesa el mensaje y responde
            String reply = "Respuesta para " + message;
            this.socket.send(reply.getBytes(ZMQ.CHARSET), 0);
        }
    }

    public static void main(String[] args){
        RepSocket socket = new RepSocket(11434);
        socket.answerMessage();
    }









}