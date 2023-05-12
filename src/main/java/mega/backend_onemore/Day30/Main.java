package mega.backend_onemore.Day30;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class MyRunnable implements Runnable {
  public void run() {
    for(int i=0; i<10; i++) {
      log.info("abcd");
      log.info("hello");
    }
  }
}

public class Main {
  public static void main(String[] args) {
    MyRunnable runnable = new MyRunnable();
    Thread thread = new Thread(runnable);
    thread.start();
  }
}
