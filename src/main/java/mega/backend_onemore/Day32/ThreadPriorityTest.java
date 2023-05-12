package mega.backend_onemore.Day32;

class PriTest extends Thread {

  PriTest(String str){
    setName(str);
  }

  public void run() {
    for(int i = 0;i<5;i++) {
      System.out.println(i+getName()+"순위 : "+getPriority());
    }
  }

}


public class ThreadPriorityTest {

  public static void main(String[] args) {

    PriTest p1 = new PriTest("1번");
    PriTest p2 = new PriTest("2번");
    PriTest p3 = new PriTest("3번");

    p1.setPriority(Thread.MAX_PRIORITY); // 1등
    p2.setPriority(Thread.NORM_PRIORITY); // 2등
    p3.setPriority(Thread.MIN_PRIORITY);//3등

    p1.start();
    p2.start();
    p3.start();
  }

}