package mega.backend_onemore.Day31.Q1Prac;

/*
먼저 검사를 하고
돈을 내버리면 50만원 채울 수 있다.
 */

class Account { // 후원을 모금하는 공용 계좌
  int money = 0;

  synchronized void sendMoney() { // 돈내기 메서드
    if (money<500000) {
      money += 1000;
    }
  }
}

class Contributor extends Thread { // 얘가 각자 송금을 할 거니까 thread를 받는다.

 Account ac;

  Contributor(Account ac, String name) { // name은 성금자 이름
    this.ac = ac;
    setName(name);
  }

  public void run() { // 얘는 무한히 돌면서 Account에 있는 돈이 50만원이 넘어가면 종료.
    int count = 0; // 횟수
    while (true) {
      System.out.println(getName() + " -> " + count++ + "번째 성금.");
      // 탈출조건 : 돈이 50만원 이상이면 탈출
      if (ac.money >= 500000) {
        break;
      }
      // 돈을 내는 기능
      ac.sendMoney(); // 먼저 내고 그다음에 조건 보고 탈출
    }
  }
}


public class Q1Prac {

  public static void main(String[] args) throws InterruptedException {
    Account ac = new Account();
    Contributor[] con = new Contributor[5];

    // 객체 넣어주기
    for (int i = 0; i< con.length; i++) {
      con[i] = new Contributor(ac, (i+1) + "번째 기부자");
      con[i].start(); // 기부 시작
    }

    // 일부러 조인
    for (int i = 0; i<con.length; i++) {
      con[i].join();
    }

    // 총액 출력
    System.out.println("총 기부 금액 : " + ac.money);

  }
}
