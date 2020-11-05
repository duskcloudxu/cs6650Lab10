import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ServerThread implements Runnable {

  int port;

  ServerThread(int port) {
    this.port = port;
  }

  public void run() {
    ServerSocket s1 = null;
    try {
      s1 = new ServerSocket(port);
      while(true) {
        Socket ss = null;
        ss = s1.accept();
        DataInputStream in = new DataInputStream(new BufferedInputStream(ss.getInputStream()));
        String line = in.readUTF();
        System.out.println(line);
        PrintStream p = new PrintStream(ss.getOutputStream());
        p.print("Ok");
        p.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
