package mega.backend_onemore.Day13;

public class CallByValueTest {

  // 정수형 매개변수 a를 받아 5를 대입하고 반환하는 정적 메서드 abc를 정의합니다.
  static int abc(int a) {
    a = 5;
    return a;
  }

  public static void main(String[] args) {
    // 변수 a에 10을 대입합니다.
    int a = 10;
    // abc 메서드를 호출하고, a 값을 인자로 전달합니다.
    // abc 메서드는 매개변수로 전달받은 값을 5로 대입하고 반환합니다.
    // 하지만 반환값을 받지 않았으므로, a 값은 그대로 10입니다.

    abc(a);
    // a 값을 출력합니다. 출력 결과는 10입니다.
    System.out.println(a);
  }
}
/*
위 코드는 자바에서 Call by Value(값에 의한 호출)이 적용된 예제입니다.

1. main 메서드에서 int a = 10으로 초기화된 변수 a를 선언합니다.

2. abc(a)를 호출합니다.
이때, a의 값인 10이 abc 메서드의 매개변수 int a에 복사됩니다.

3. abc 메서드에서 a = 5를 수행합니다.
이때, a는 main 메서드에서 전달된 값 10의 복사본이므로,
main 메서드에서 선언된 변수 a의 값에는 영향을 주지 않습니다.

4. abc 메서드는 5를 반환합니다.
하지만, 반환값을 main 메서드에서 받지 않았으므로, 반환값은 무시됩니다.

5. System.out.println(a)를 호출하여 변수 a의 값을 출력합니다.
a는 main 메서드에서 초기화된 값인 10이 유지되어 있으므로, 출력 결과는 10입니다.
 */