public class Node {

  int totalNum;
  int id;
  boolean isMaster;

  Node(int totalNum, int id) {
    this.totalNum = totalNum;
    this.id = id;
    int BASE_PORT = 12345;
    StatusManager statusManager = StatusManager.getInstance();
    statusManager.setId(id);
    statusManager.setTotalNum(totalNum);
    statusManager.setBASE_PORT(BASE_PORT);
    PrintThread printThread = new PrintThread();
    printThread.start();
    Thread serverThread = new Thread(new ServerThread(BASE_PORT + id));
    serverThread.start();
  }


}
