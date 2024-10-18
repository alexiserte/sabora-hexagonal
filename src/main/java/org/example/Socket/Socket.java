package org.example.Socket;
import org.example.Message.Message;
import org.zeromq.SocketType;
import org.zeromq.ZMQ;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Socket {
    private ZMQ.Context ctx = ZMQ.context(1);
    private ZMQ.Socket socket;
    private String socketID = generateID();
     private List message = new ArrayList<>();

    public Socket(SocketType type, String[] directions, int devicePort){
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

    private static String generateID(){
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
        this.message.add(message);

    }




}