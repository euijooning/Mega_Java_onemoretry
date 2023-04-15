package mega.backend_onemore.Day09;

public class SortTest {
// 두 값 임시변수에 담아서 치환
  public static void main(String[] args) {
    int a = 10;
    int b = 20;

    int temp;

    temp = a;
    a = b;
    b = temp;

    System.out.println(a+", "+b);
  }

}
