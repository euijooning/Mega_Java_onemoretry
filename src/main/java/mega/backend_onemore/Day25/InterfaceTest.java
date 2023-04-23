package mega.backend_onemore.Day25;

interface K{
  void abc();
}
interface R{
  void xxx();
}

class RR{

}

// 인터페이스는
class YOU extends RR implements K, R{
  public void abc() { // void abc() 면 무조건 에러.
    // 즉, 인터페이스는 무조건 오버라이딩 할 때 public을 붙여야 한다.
  }
  public void xxx() {

  }
/*
  여기서 class YOU는 RR 클래스를 상속받고, K와 R 인터페이스를 구현합니다.
  extends 키워드는 클래스 상속을 나타내며,
  implements 키워드는 인터페이스 구현을 나타냅니다.
  따라서 class YOU는 RR 클래스를 상속받고, K와 R 인터페이스를 구현한 것입니다.
  인터페이스 구현은 다중 상속이 가능하므로,
  class YOU는 K와 R 인터페이스에서 정의된 모든 추상 메서드를 구현해야 합니다.
  여기서는 abc()와 xxx() 메서드를 구현하였습니다.
  abc() 메서드에서 public 키워드를 사용하는 것은
  인터페이스에서 정의된 메서드를 구현할 때
  반드시 접근 제어자를 public으로 명시해야 한다는 규칙에 따른 것입니다.
*/
}


interface X extends K { // 인터페이스간의 상속은 extends
  void def();
}

abstract class Y implements X { //구현 가능

  // 오버라이딩 매우 가능
  // * 추상화클래스에서는 일반 메서드 생성 가능하므로.
  public void abc() {

  }
  abstract void kor();
}

class KOR extends Y{
  public void def() { // X에 있는 추상메서드와.
  // 인터페이스니까 public
  }
  void kor() { // Y에 있는 추상메서드를 오버라이딩 마저 해줘야 정상작동할 수 있다.
    // 즉 마지막 손자 클래스에서는 미 구현된 추상화 부분을 최종적으로 구현 완료해주어야 한다.

  }
  //* 여기서 abc() 재정의도 가능
}

public class InterfaceTest {

  public static void main(String[] args) {

  }

}
