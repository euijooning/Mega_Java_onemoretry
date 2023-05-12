package mega.backend_onemore.Day31;
/*
<사람 5명 기부 문제 - 쓰레드>
- 5명이 기부를 1000원씩 함.
- 총 성금이 500,000원이 되면 프로그램을 종료함.
- 그런데 이제 문제는, 줄 한 번 서면 정보를 정확하게 알 수가 없어서
- 프로그램 종료 시에는 항상 504,000원이 출력될 것.
 */

class Account {
  int money = 0;

  synchronized void sendMoney() { // 돈내기 메서드
    money += 1000;
  }
}

class Contributor extends Thread { // 얘가 각자 송금을 할 거니까 thread를 받는다.
// 또한 Account 실객체를 하나 만들어서 돌려쓸 거니까, Account는 보유하고 있어야.
// Account도 main문에서 받아온 거 하나를 넣어줄거란 말이죠.
  Account ac;

  Contributor(Account ac, String name) { // name은 성금자 이름
    this.ac = ac;
    setName(name); // 이 메서드는 싱크로나이즈드 안의 기본 제공 메서드
  } // 이렇게 완성해주고 run() 만 해주면 됨.

  public void run() { // 얘는 무한히 돌면서 Account에 있는 돈이 50만원이 넘어가면 종료.
    int count = 0; // 횟수
    while (true) {
      // 이 getName도 Thread클래스의 기본 제공 메서드
      System.out.println(getName() + " -> " + count++ + "번째 성금.");
      // 돈을 내는 기능
      ac.sendMoney();
      // 탈출조건 : 돈이 50만원 이상이면 탈출
      if (ac.money >= 500000) {
        break; // 50만원이 아닐 때 출서있었을 것이므로 4천원이 초과될 것.
      }
    }
  }
}


public class Q1 {

  public static void main(String[] args) throws InterruptedException {
    Account ac = new Account(); // 성금계좌 객체 생성
    Contributor[] con = new Contributor[5]; // 기부자 다섯명 배열 생성

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
