package mega.backend_onemore.Day19.HT1;

class B{

}
class C{
  B[] b = new B[5]; // 멤버변수 has 관계
}

class D{
  //has 관계?? 말할 수 없다.

}
class E{
  D[][] d = new D[3][3];

  D[]sendD(D[][] d, int i, int j) {
    d[i][j] = new D();
    return d[0];
  }
}

public class HasTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    C c = new C();
    D d = new D();
    D[][] d1 = new D[3][3];



//				B b =d.make(c.b);
    E e = new E();

    D[] d2 =e.sendD(d1, 0, 2);

    if(d2[2] == null) {
      System.out.println("null입니다.");
    }
    else {
      System.out.println("객체가 있습니다.");
    }

    //d1[0][2]은 객체가 있을까요? 없을 까요?
    //1. 있다 2. 없다 3. 물어보지마라 4. 말을 할 수 없다. 5. 비밀이다.
  }

}

