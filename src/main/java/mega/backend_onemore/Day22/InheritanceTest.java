package mega.backend_onemore.Day22;

class C{
  C(){
    System.out.println("C생성");
  }
}
class D extends C{
  D(){
    System.out.println("D생성");
  }
}
public class InheritanceTest {
  public static void main(String[] args) {

    D d = new D(); // C생성 D생성 순으로 나온다. // 부모클래스의 생성자가 먼저 호출되기 때문에
  }

}