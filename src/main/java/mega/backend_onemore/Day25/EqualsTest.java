package mega.backend_onemore.Day25;

public class EqualsTest {

  public static void main(String[] args) {

    C c = new C();
    C c1 = new C();
    C c2 = c1;
    if(c == c1) {
      System.out.println("c == c1"); // 출력 안 됨 객체가 달라
    }
    if(c.equals(c1)) {
      System.out.println("c.equals(c1)"); // 출력 안 됨.
    }
    if(c1 == c2) {
      System.out.println("c1 == c2");
    }


    String str = "하이";

    if(str == "하이") {
      System.out.println("str == 하이");
    }
    if(str.equals("하이")) {
      System.out.println("str.equals(\"하이\")");
    }
  }

}