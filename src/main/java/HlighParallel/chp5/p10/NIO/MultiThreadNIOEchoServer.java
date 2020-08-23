package HlighParallel.chp5.p10.NIO;

import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MultiThreadNIOEchoServer {

    public static Map<Socket, Long> time_stat = new HashMap<Socket, Long>(10210);

    class EchoClient{
        private LinkedList<ByteBuffer> outq;
        EchoClient(){
            outq = new LinkedList<ByteBuffer>();
        }

        public LinkedList<ByteBuffer> getOutputQueue(){
            return outq;
        }

        public void enqueue(ByteBuffer bb){
            outq.addFirst(bb);
        }
    }



}
