package mega.backend_onemore.Day25;

public class EqualsTest {

  public static void main(String[] args) {

    C c = new C();
    C c1 = new C();
    C c2 = c1; // 하나의 물리적 주소를 두 개가 동시에 바라보게 되는 것.
    if(c == c1) {
      System.out.println("c == c1"); // 출력 안 됨 객체가 달라
    }
    if(c.equals(c1)) {
      System.out.println("c.equals(c1)"); // 출력 안 됨.
    }
    if(c1 == c2) { // c1과 c2는 참조변수가 가지고 있는 값이 같다.
      System.out.println("c1 == c2");
    }

    // c와 c1은 물리적으론 다르지만
    // equals를 정상적으로 구현했다면 출력이 될 수도.


    String str = "하이";

    if(str == "하이") {
      System.out.println("str == 하이");
    }
    if(str.equals("하이")) {
      System.out.println("str.equals(\"하이\")");
    }
  }

}