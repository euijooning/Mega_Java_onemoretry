package mega.backend_onemore.Day02;

// 연산자 예제
public class OPTest {

  public static void main(String[] args) {
    System.out.println(5 > 3  &&  4 == 7  || 3 != 7); // true 출력

    // 산술 연산자
    int a = 10;
    System.out.println(a++); // 전치 10 출력
    System.out.println(++a); // 후치 11 출력 아니고 12 출력되더라

    // 관계연산자
    int b = 10;
    int c = 12;
    int d = 10;

    System.out.println(b = c); // false 출력
    System.out.println(b !=c); // true 출력
    System.out.println(b >= c); // false 출력
    System.out.println(d <= c); // false 출력
    System.out.println(c < b); // false 출력

    // 논리연산자
    System.out.println(5 > 3  &&  4 == 7  || 3 != 7); // true 출력

    // 단축연산자
    int e = 10;
    int f = 5;
    e += f; // e = e+f // 15 출력
    System.out.println(e);
    e -= f; // e = e-f // 10 출력
    System.out.println(e);

    // 삼항연산자
    int x = e == 10 ? 1 : 0;
    System.out.println(x); // 1 출력
  }
}
