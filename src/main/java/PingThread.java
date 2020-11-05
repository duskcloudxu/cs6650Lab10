import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class PingThread implements Runnable {

  @Override
  public void run() {
    StatusManager sm = StatusManager.getInstance();
    int id =  sm.getId();
    int totalNum = sm.getTotalNum();
    int BASE_PORT = sm.getBASE_PORT();
    boolean responsed = false;

    for(int i = id+1;i<totalNum;i++){
      if(ping(BASE_PORT + i)){
        responsed = true;
      }
    }

    if(responsed){
      sm.resignMaster();
    }
    else{
      sm.claimMaster();
    }
  }
  boolean ping(int port){
    try{
      Socket socket = new Socket("127.0.0.1", port);
      socket.setSoTimeout(5000);
      BufferedReader sin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());
      String line = "";
      out.writeUTF("Ping");
      line = sin.readLine();
      if(line.equals("Ok")){
        return true;
      }
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }
}
