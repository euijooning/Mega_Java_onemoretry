package mega.backend_onemore.Day23.Super1;


class A{
  int k; // 여기에 5가 들어감. super로 불렀으니까.

  A(int a){
    this.k = a;
  }

  void print() {
    System.out.println("A");
  }
}

class B extends A{
  int k; // 그러면 여기에 5가 들어간다.
  B(){
    super(5); // 이건 int a를 받는 부모 생성자가 있기 때문.
  }

  void print() {
    System.out.println(super.k); // 부모 클래스 A의 k 필드에 접근하기 위해 super.k 사용
  }
}


public class TestSuper {

  public static void main(String[] args) {

    B b = new B();
    b.print(); // A출력 -> 5 출력 : 메서드 오버라이딩 한 게 되므로.
    // 만약에 b에 print 메서드가 없었다면, A가 출력 되었을 것임.
    // 지금 내가 의도적으로 print 메서드를 설정해놨음. 차이를 확인하기 위해서.

  }
}