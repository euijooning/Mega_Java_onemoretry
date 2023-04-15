package mega.backend_onemore.Day01;

public class VariableTest2 {

  public static void main(String[] args) {
    int a = 10; // 변수의 초기화 선언
    int b; // 정답은 b에 쓰레기 값
    System.out.println(a);

    a = 20;
    System.out.println(a);
    // a = 1.8; // 에러 더블타입
    a = '가';
    System.out.println(a);
  }
}


