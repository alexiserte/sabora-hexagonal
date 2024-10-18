package org.example.Socket;

import org.zeromq.SocketType;
import org.zeromq.ZMQ;

public class SocketFactory {

    public SocketFactory(){}
    public SaboraSocket createPubSocket(String[] directions, int devicePort){
        return new SaboraSocket(SocketType.PUB,directions,devicePort);
    }
    public SaboraSocket createSubSocket(String[] directions, int devicePort){
        return new SaboraSocket(SocketType.SUB,directions,devicePort);
    }

    public SaboraSocket createReqSocket(String[] directions, int devicePort){
        return new SaboraSocket(SocketType.REQ,directions,devicePort);
    }

    public SaboraSocket createRepSocket(String[] directions, int devicePort){
        return new SaboraSocket(SocketType.REP,directions,devicePort);
    }

    public SaboraSocket createRouterSocket(String[] directions, int devicePort){
        return new SaboraSocket(SocketType.ROUTER,directions,devicePort);
    }

    public SaboraSocket createDealerSocket(String[] directions, int devicePort){
        return new SaboraSocket(SocketType.DEALER,directions,devicePort);
    }

}
