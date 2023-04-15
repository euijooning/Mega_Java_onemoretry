package megait.backend_lecture.Day16;


class C {
  int a;
  D d;
}

class D {
  String str;
}

public class HasTest {

  public static void main(String[] args) {
    C c = new C();
    c.d = new D();
    c.d.str = "안녕하세요~~~";
    c.a = 10;

//    System.out.println(c.c + );
  }

}
