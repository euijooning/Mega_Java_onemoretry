package mega.backend_onemore.Day15;

class A {
  int a;
  void print() {
    System.out.println("a는 " + a + "입니다.");
  }
}

public class ClassTest {

  public static void main(String[] args) {
    //객체 생성
    A a1 = new A();
    a1.a = 10; // a1에 10 대입
    a1.print(); // a는 10입니다. 출력

    A a2 = new A();
    a2.print(); // a는 0입니다. 출력
    a2.a = 30;
    a2.print();// a는 30입니다. 출력

    A a3 = a1;
    a3.print(); // a는 10입니다 출력

    a3.a = 40;
    a1.print(); // a는 40입니다 출력
  }

}
