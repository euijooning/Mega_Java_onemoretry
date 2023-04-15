package mega.backend_onemore.Day02;

public class CastingTest {

  public static void main(String[] args) {
    // 자동형변환
    System.out.println(7+1.5); //8.5 출력
    System.out.println("안녕하세요." + 5 + 3); // 안녕하세요.53 출력
    System.out.println("안녕하세요." + (5 + 3)); // 안녕하세요.8 출력

    // 강제형변환
    System.out.println((int)37.7); // 37 출력

    // 하지만 형변환 쓰는 건 최대한 지양하도록 하자.
  }
}
