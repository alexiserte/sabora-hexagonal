package org.example.Socket;

import org.zeromq.SocketType;
import org.zeromq.ZMQ;

public class SocketFactory {

    public SocketFactory(){}

    public static Socket createPubSocket(String[] directions, int devicePort){
        return new Socket(SocketType.PUB,directions,devicePort);
    }
    public static Socket createSubSocket(String[] directions, int devicePort){
        return new Socket(SocketType.SUB,directions,devicePort);
    }

    public static Socket createReqSocket(String[] directions, int devicePort){
        return new Socket(SocketType.REQ,directions,devicePort);
    }

    public static Socket createRepSocket(String[] directions, int devicePort){
        return new Socket(SocketType.REP,directions,devicePort);
    }

    public static Socket createRouterSocket(String[] directions, int devicePort){
        return new Socket(SocketType.ROUTER,directions,devicePort);
    }

    public static Socket createDealerSocket(String[] directions, int devicePort){
        return new Socket(SocketType.DEALER,directions,devicePort);
    }

}
