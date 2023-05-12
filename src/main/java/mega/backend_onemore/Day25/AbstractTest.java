package mega.backend_onemore.Day25;

class C {

  void cmethod() {

  }
}

abstract class  A extends C{ // 추상화
  // 내가 추상클래스인데 부모클래스를 상속받는 것 당연히 가능. 근본이 클래스
  int a;
  void abc() {
    System.out.println("AAAAA");
  }
  abstract void def(); // 추상 메서드
  abstract void kor(); // 추상 메서드
}

class B extends A{ // 오버라이딩 안하면 처음에 빨간줄

  @Override
  void def() { // 오버라이딩
    System.out.println("def");
  }

  @Override
  void kor() {
    System.out.println("kor");
  }
}

public class AbstractTest {

  public static void main(String[] args) {

    //A a = new A(); 에러 : 추상 클래스기 때문에 객체 생성 직접 못함!
    B b = new B();
    A a = new B(); // 객체는 자식이고 껍데기만 부모이기 때문에 가능
    b.cmethod(); // 다 넘겼을 뿐이므로 조부모 것 가져올 수 있다.
    b.a = 10; // 부모에 있는 a에 10을 대입하는 것 가능.
    b.abc(); // 이게 자식이 오버라이딩 해버리면 부모 것도 못나옴.
    // 그래서 사실상 부모 메서드도 별 필요가 없어지게 되는 것.
    // 그래서 추상메서드로 만드는 것이 더 좋음

  }

}