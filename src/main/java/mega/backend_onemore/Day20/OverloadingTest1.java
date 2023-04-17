package mega.backend_onemore.Day20;

public class OverloadingTest1 {

  static void add(int a, int b) {
    System.out.println(a + b);
  }

  static void add(double a, double b) {
    System.out.println(a + b);
  }

  static void add(double a, int b) {
    System.out.println(a + b);
  }

  static void add(int a, double b) {
    System.out.println(a + b);
  }

  public static void main(String[] args) {

    add(5, 10);
    add(0.5, 0.7);
    add(1, 0.7);
    add(5.6, 7);
    // 값을 넣으면 동일한 매개변수 형태에 맞춰서 알아서 값이 들어가게 된다.
  }

}
