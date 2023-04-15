package mega.backend_onemore.Day11;

public class MethodTest2 {
  static int a = 10; //전역변수

  static void abc() {
    int a = 30;
    a = 20;
    // 4. 안주고 안받고 인데, 이 메소드 내부에 출력문 자체가 없으므로 아예 무출력
  }

  static void kor() {
    System.out.println(a);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int a = 20;
    abc(); // 별 의미가 없음. 리턴값이 없으니 출력 자체도 안 됨.
    System.out.println(a);
    kor();
  }

}