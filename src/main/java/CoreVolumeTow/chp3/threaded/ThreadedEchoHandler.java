package CoreVolumeTow.chp3.threaded;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * ThreadedEchoHandler类实现了Runnable接口，
 * 而且在它的run方法中包含了与客户端循环通信的代码。
 */
public class ThreadedEchoHandler implements Runnable{
    private Socket incoming;
    public ThreadedEchoHandler(Socket incoming){
        this.incoming = incoming;
    }
    @Override
    public void run() {
        try {
            InputStream inStream = incoming.getInputStream();
            OutputStream outStream = incoming.getOutputStream();

            Scanner inSc = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream, true);

            out.println("Hello! Enter BYE to exit.");

            boolean done = false;
            while (!done && inSc.hasNextLine()){
                String line = inSc.nextLine();
                out.println("Echo: " + line);
                if (line.trim().equals("BYE"))
                    done = true;
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                incoming.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
