package mega.backend_onemore.Day14;

public class MethodTest {
  static int abc(int a) {
    if(a==0) {
      return 0;
    }
    else {
      return abc(a-1) + a;
    }
  }

  public static void main(String[] args) {

    System.out.println(abc(5));
  }

}
/*
코드 설명:

이 코드는 재귀함수를 사용하여 1부터 n까지의 합을 구하는 예제입니다.
abc() 메소드는 인자로 받은 값이 0인 경우 0을 반환하고,
그렇지 않은 경우 자기 자신을 호출하면서
인자로 받은 값보다 1 작은 값을 넘겨줍니다.
이 과정을 인자가 0이 될 때까지 반복하다가,
마지막에는 각 호출에서 반환된 값들을 더하여 최종 결과값을 반환합니다.

실행 흐름:

main() 메소드에서 abc(5)를 호출합니다.
abc() 메소드가 호출됩니다. 인자로 5를 받았기 때문에 else 블록이 실행됩니다.
abc(4)를 호출하면서 인자로 4를 넘겨줍니다.
abc(3)을 호출하면서 인자로 3을 넘겨줍니다.
abc(2)를 호출하면서 인자로 2를 넘겨줍니다.
abc(1)을 호출하면서 인자로 1을 넘겨줍니다.
abc(0)을 호출하면서 인자로 0을 넘겨줍니다.
abc(0)은 0을 반환하고, 이 값을 abc(1)에서 받아서 1과 더하여 1을 반환합니다.
이 값을 abc(2)에서 받아서 3과 더하여 4를 반환합니다.
이 값을 abc(3)에서 받아서 6과 더하여 10을 반환합니다.
이 값을 abc(4)에서 받아서 10과 더하여 20을 반환합니다.
최종적으로 abc(5)에서는 20을 반환합니다.
main() 메소드에서는 abc(5)가 반환한 값을 출력합니다. 결과값은 20입니다.
 */