package mega.backend_onemore.Day24;

class A{
  int a;
}
class B extends A{
  int b;
}
class C extends A{
  int c;
}
class D extends A{
  int d;
}
public class ClassCastingTest1 {

  public static void main(String[] args) {

    A a = new B(); //업캐스팅
    B b = (B)a; // 다운캐스팅

    B[] listB = new B[10];
    C[] listC = new C[10];
    D[] listD = new D[10];
    // 이렇게 세 번 수고할 필요가 없이
    // 아래처럼 한방에 만들고 집어넣으면 된다!
    A[] listA = new A[10];

    listA[0] = new C();
    listA[1] = new D();
    listA[2] = new B();

    // listA[2].b = 10;
    // 이건 안 보인다. 부모 자체가 A이니까.
    // 그래서 b로 형변환 해서 써줘야 한다는 것.
    ((B)listA[2]).b = 10;

    B b1 = (B)listA[2];


    if(listA[1] instanceof D) {
      D d1 = (D)listA[1];
    }
    /*
    이 코드는 instanceof 연산자를 사용하여 listA[1]이 D 클래스의 인스턴스인지 확인하고,
    그렇다면 listA[1]을 D 클래스의 인스턴스로 다운캐스팅하고 d1 변수에 할당합니다.
    즉,, listA[1]이 D 클래스의 인스턴스가 아니면 다운캐스팅을 시도하지 않습니다.
    따라서 이 부분의 코드는 D 클래스의 인스턴스가 아닌 경우를 대비한 안전장치 역할을 합니다.

      instanceof 연산자는 객체가 지정된 클래스 또는
      해당 클래스의 하위 클래스의 인스턴스인 경우 true를 반환하고,
      그렇지 않은 경우 false를 반환합니다.
      따라서 이 코드는
      listA[1]이 D 클래스 또는 D 클래스의 하위 클래스의 인스턴스인지 확인하고,
      그렇다면 listA[1]을 D 클래스의 인스턴스로 다운캐스팅합니다.
     */
    System.out.println(b1.b); //10 츨력 (형변환 전에는 0나왔을 터)

  }

}

