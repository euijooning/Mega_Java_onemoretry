package mega.backend_onemore.Day31;

class Factory{
  private int value;
  private boolean check = false; // 처음엔 false로 시작

  synchronized void send(int value) {
    while(check == true) { // false부터 시작하므로 처음에 얘는 안 돈다.
      // check == true는 보낸 상태인데 아직 수신이 안 된 상태
      try { // true여서 여기로 들어올 수 있고
        wait(); // 대기하게 됨.
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    //check이 false가 됨 => 수신완료를 의미
    this.value = value;
    System.out.println("만드는 사람 : 만든다"+this.value); // 받았으니까 만듦
    notify(); // 얘가 여기서 깨웠지만 아직 true로 바뀐 게 아니기 때문에(얘가 깨우는순간 wait는 깨진다)->
    check = true; // 아래로 와서 이 작업들을 다 하고 true로 바꾸니까,
  }
  synchronized int get() {
    while(check == false) { // 발신이 안 된 상태
      // 아직 안 보낸 거니까 얘도 들어와서 잠드는 거고
      try { // 원래 처음이 false였으니까 사는 사람은 여기에 들어와 있었을 것.
        wait(); // 얘가 기다리고 있었는데, / -> 여기서 돌고 있다. // 위에서 true로 바뀌면 얘도 나와서
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    // 발신이 완료된 이후
    System.out.println("사는 사람 : 산다"+this.value);
    notify(); // 자고있는 만드는 메서드(발신자)를 깨워주고
    check = false; // 얘는 일을 다 했으니까 다시 false로 바꿔서 들어가서 또 잔다.
    return this.value;
    // 요러한 작업들을 계속 반복...
  }
}

class P extends Thread{
  Factory f;
  P(Factory f){
    this.f = f;
  }

  public void run() {
    for(int i = 0;i<10;i++) { // 10번동안 send
      f.send(i); // 얘(P)는 send에 접근하고(총 10번)
    }
  }
}

class C extends Thread{
  Factory f;
  C(Factory f){
    this.f = f;
  }

  public void run() {
    int temp = 0;
    for(int i = 0;i<10;i++) { // 10번동안 get
      temp = f.get(); // 얘(C)는 get에 접근한다. 총 10번
    }
  }
}


public class ThreadEX1 {

  public static void main(String[] args) {

    Factory f = new Factory(); // 얘가 임계영역을 들고 있고
    P p = new P(f); // 이것과 (보내는 애)
    C c = new C(f); // 이것 두 개가 경쟁 (받는 애)

    p.start(); //start가 내부적으로 run()을 호출함.
    c.start();
  }

}


