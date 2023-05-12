package mega.backend_onemore.Day30;

class DThread extends Thread{
  DThread(String str){
    setName(str);
  }

  public void run() {
    for(int i = 1;i<=10;i++) {
      System.out.println(getName() + i);
    }

    System.out.println("완료 !!!!"+getName());
  }
}

public class ExDoubleThread1 {

  public static void main(String[] args) {

    DThread t1 = new DThread("자바");
    DThread t2 = new DThread("스프링");
    t1.start();
    t2.start();
    System.out.println("바바바이!!!");
  }

}
