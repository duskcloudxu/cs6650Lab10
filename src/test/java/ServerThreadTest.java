import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThreadTest {

  @org.junit.Test
  public void run() throws IOException {
    Socket socket = new Socket("127.0.0.1", 12345);
    System.out.println("Connected");
    BufferedReader sin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    String line;
    out.writeUTF("12");
    line = sin.readLine();
    System.out.println(line);

  }
}
