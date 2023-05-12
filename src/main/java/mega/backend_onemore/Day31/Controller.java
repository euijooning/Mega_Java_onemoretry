package mega.backend_onemore.Day31;

public class Controller {

  public static void main(String[] args) {
    System.out.println(Thread.currentThread().getName());
  }
}

class MyNewThread extends Thread {

  @Override
  public void run() {
  }
}
