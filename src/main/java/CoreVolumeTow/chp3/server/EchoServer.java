package CoreVolumeTow.chp3.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) {
        // establish server socket
        try {
            ServerSocket s = new ServerSocket(8189);
            Socket incoming = s.accept();
            InputStream inStream = incoming.getInputStream();
            OutputStream outStream = incoming.getOutputStream();

            Scanner inSc = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream, true);

            out.println("Hello! Enter BYE to exit.");

            // echo client input
            boolean done = false;
            while (!done && inSc.hasNextLine()){
                String line = inSc.nextLine();
                out.println("Echo: " + line);
                if (line.trim().equals("BYE")) done = true;
            }
            incoming.close();
            s.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
