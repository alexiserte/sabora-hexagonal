package org.example.Utils;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
public class MACAddress {
    public static String getMACAddress(){
            try {
                InetAddress localHost = InetAddress.getLocalHost();
                NetworkInterface network = NetworkInterface.getByInetAddress(localHost);
                if (network == null) {
                    return "No se pudo obtener la interfaz de red.";

                }

                byte[] mac = network.getHardwareAddress();
                if (mac == null) {
                    return "No se pudo obtener la dirección MAC.";

                }

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < mac.length; i++) {
                    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                }
                return sb.toString();
            } catch (UnknownHostException | SocketException e) {
                e.printStackTrace();
            }

        return null;
    }
        public static void main(String[] args) throws UnknownHostException {
            System.out.println(getMACAddress());
    }
}


