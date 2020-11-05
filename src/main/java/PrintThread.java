public class PrintThread extends Thread {

  public void run() {
    while (true) {
      StatusManager sm = StatusManager.getInstance();
      boolean isMaster = sm.getStatus();
      int id = sm.getId();
      if (!isMaster) {
        System.out.printf("%d: I am a follower\n",id);
      }
      else{
        System.out.printf("%d: I am Leader\n",id);
      }
      try {
        Thread.sleep(sm.getINTERVAL());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
