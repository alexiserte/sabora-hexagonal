package com.sabora.server.ConnectionBeta;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

@RestController
public class ConnectionController {

    private static final int PORT = 3938;

    @GetMapping("/connection/{name}")
    public String connection(@PathVariable String name, HttpServletRequest request){
            createConnection(request.getRemoteAddr());
            System.out.println(request.getRemoteAddr());
            return "Connection created";
    }


    // Método para crear una conexión
    public void createConnection(String ip){
        try (DatagramSocket socket = new DatagramSocket()) {
            String message = "TUS MUERTOS PISAOS";
            byte[] buffer = message.getBytes();
            socket.setBroadcast(true);
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ip),PORT);

            // Enviar mensaje a todos los dispositivos en la red
            socket.send(packet);
            System.out.println("Enviado: " + message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
