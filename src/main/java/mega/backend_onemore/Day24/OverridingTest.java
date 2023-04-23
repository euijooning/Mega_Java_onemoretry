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
    c.hello("대한민국");
//    System.out.print(c.hello("한국"));
    // Con한국이 나올 거라고 생각하지만, Kor한국이 나온다.
  }

}
/*
이유는 hello 메소드가 문자열을 반환하기 때문입니다.
c.hello("한국") 코드는 hello 메소드를 호출하고,
그 반환값인 "Kor한국" 문자열을 출력하는 것입니다.
따라서 출력 결과는 Kor한국이 됩니다.

반면, 이전 질문에서는 c.hello("한국")을 호출한 후
반환값을 출력하지 않았기 때문에,
"Kor한국" 문자열이 반환되었지만 출력되지 않았습니다.
대신 hello 메소드 내부에서 println 메소드가 호출되어서
"Kor" 문자열이 출력되었을 뿐입니다.
 */
