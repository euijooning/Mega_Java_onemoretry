package mega.backend_onemore.Day30;

class A{
  synchronized void plus(int i){
    for(int j = 0;j<5;j++) {
      System.out.println(j*i);
      try {
        Thread.sleep(800);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}

class B extends Thread{
  A a; //has 관계
  int i;
  B(A a, int i){
    this.a = a;
    this.i = i;
  }

  public void run() {
    a.plus(i);
  }
}

public class EXThread2 {

  public static void main(String[] args) {

    A a = new A();
    B b1 = new B(a,3);
    B b2 = new B(a,7);
    b1.start();
    b2.start();
  }

}
