package mega.backend_onemore.Day23.Super2;

class Z { // 조부모 클래스를 추가함.

  String str;

  Z(String str) {
    this.str = str;
  }
}

class A extends Z {

  int k;

  A(int a) { // 이 상태면 에러, 조부모(부모) 요소 찾아와야.
    super("hello");
    this.k = a;
  }

  void print() {
    System.out.println("A");
  }
}

class B extends A {

  String str; // 여기에 hi가 들어가는 것.
  int k; // 그러면 여기에 5가 들어간다.

  B() {
    super(5); // 이건 int a를 받는 부모 생성자가 있기 때문.
  }

  void changeString() {
    super.k = 5; // 부모꺼
    this.k = 10; // 내꺼
  }


  public class TestSuper {

    public static void main(String[] args) {

      B b = new B();
      b.print();
      b.str = "hi";

    }
  }

}