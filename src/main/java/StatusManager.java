import java.util.concurrent.atomic.AtomicBoolean;

public class StatusManager {
  private int totalNum;
  private int id;



  private int BASE_PORT;

  private long INTERVAL = 5000;
  private static StatusManager instance = new StatusManager();
  private AtomicBoolean isMaster = new AtomicBoolean(true);

  private StatusManager(){

  }

  public int getBASE_PORT() {
    return BASE_PORT;
  }

  public void setBASE_PORT(int BASE_PORT) {
    this.BASE_PORT = BASE_PORT;
  }

  public long getINTERVAL() {
    return INTERVAL;
  }

  public int getTotalNum() {
    return totalNum;
  }

  public void setTotalNum(int totalNum) {
    this.totalNum = totalNum;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public static StatusManager getInstance(){
    return instance;
  }

  synchronized public void claimMaster(){
    isMaster.set(true);
  }

  synchronized public void resignMaster(){
    isMaster.set(false);
  }

  synchronized public boolean getStatus(){
    return isMaster.get();
  }

}
