package mega.backend_onemore._230317;

public class OperatorExample {
  public static void main(String[] args) {
    // 전위 연산자와 후위 연산자
    // x++  vs  ++x

    // 일단 연산자가 앞에 붙든, 뒤에 붙은 x의 값을 1 증가시키는 얘라는 건 동일
    // 증가하는 시점이 언제인지가 다른 것임.

    // 먼저 전위 연산자
    int x = 0;
    System.out.println(++x); // 1 출력. 사용되는 시점에 "즉시" 값이 증가된 다음에 출력된다.
    System.out.println(x); // 1 출력. 증가된 값 그대로 출력할 것이므로

    // 후위 연산자
    x = 0;
    System.out.println(x++); // 0 출력. 더하기를 하는 시점에는 값이 바뀌지 않는다! 그리고 얘가 나온 이후부터 값이 증가가 된다.
    System.out.println(x); // 1 출력. 이후이므로, 여기서 값이 증가되어서 나온다.
  }
}

