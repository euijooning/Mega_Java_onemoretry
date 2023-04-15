package mega.backend_onemore.Day13;

public class CallByReferenceTest {

  // 배열을 매개변수로 받아서 첫번째 요소를 10,
  // 두번째 요소를 20으로 변경하는 정적 메서드 abc를 정의합니다.
  static void abc(int[] a) {
    a[0] = 10;
    a[1] = 20;
  }

  public static void main(String[] args) {
    // 크기가 3인 int형 배열을 생성합니다.
    int[] a= new int[3];
    // abc 메서드를 호출하고, 배열 a를 인자로 전달합니다.
    // abc 메서드에서는 배열의 첫 번째 요소를 10,
    // 두 번째 요소를 20으로 변경합니다.
    abc(a);
    // 배열 a의 각 요소값을 출력합니다. 출력 결과는 10, 20, 0입니다.
    System.out.println(a[0] + ", " + a[1] + ", " + a[2]);

    String str = "kjlsadjflkasdjlfkjfklasjdlfdsfjks";

    // str의 길이를 반환하는 length 메서드를 호출합니다.
    str.length();

    // str의 첫 번째 문자를 반환하는 charAt 메서드를 호출합니다.
    // 반환된 문자는 사용되지 않으므로, 무시됩니다.
    str.charAt(0); // k

  }

}
/*
위 코드는 자바에서 Call by Reference(참조에 의한 호출)가 적용된 예제입니다.

1. main 메서드에서 int[] a= new int[3]으로
크기가 3인 int형 배열 a를 생성합니다.

2. abc(a)를 호출합니다.
이때, 배열 a의 주소가 abc 메서드의 매개변수 int[] a에 전달됩니다.

3. abc 메서드에서 a[0] = 10과 a[1] = 20을 수행합니다.
이때, a는 main 메서드에서 선언된 배열 a와
같은 배열을 참조하고 있으므로,
main 메서드에서 선언된 배열 a의 첫 번째 요소와 두 번째 요소에
각각 10과 20이 대입됩니다.

4 System.out.println(a[0] + ", " + a[1] + ", " + a[2])를 호출하여
배열 a의 요소값을 출력합니다.
a는 main 메서드에서 선언된 배열 a와 같은 배열을 참조하고 있으므로,
출력 결과는 10, 20, 0입니다.

5. str.length()와 str.charAt(0)를 호출합니다.
str.length()는 str 문자열의 길이를 반환하고,
str.charAt(0)은 str 문자열의 첫 번째 문자를 반환합니다.
하지만, 이 두 메서드의 반환값은 사용되지 않으므로, 무시됩니다.
 */
