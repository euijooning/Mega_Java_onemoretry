package mega.backend_onemore.Day24;

class Country{
  String hello(String name) {
    System.out.println("Con");
    return "Con"+name;
  }
}
class Eng extends Country{
  String hello(String name) {
    System.out.println("Eng");
    return "Eng"+name;
  }
}
class Kor extends Country {
  String hello(String name) {
    System.out.println("Kor");
    return "Kor"+name;
  }
}
class Jpn extends Country {
  String hello(String name) {
    System.out.println("Jpn");
    return "Jpn"+name;
  }
}

public class OverridingTest {

  public static void main(String[] args) {

    Country c = new Kor();
//    System.out.println(c.hello("한국"));
    // 이건 이렇게 분리 가능
    String result = c.hello("한국");
    System.out.println(result);
    /*
    지금 보면 hello()에도 print가 있다.
    Kor로 객체를 만들었기 때문에(다형성의 묘미)
    print 한 번 불려서 Kor 이 한 번 출력되고,
    리턴값인 Kor + name(한국) 이 출력되는 것임.
     */

  }
}
