package mega.backend_onemore.Day05.Prac05;
// 구구단 출력하기
public class Q01 {

  public static void main(String[] args) {

    int multiple = 0;

    for(int i = 2; i<10; i++) {
      System.out.println(i + "단");
      for (int j=1; j<10; j++) {
        multiple = i * j;
        System.out.println(i + " * " + j + " = " + multiple);
      }
    }
  }

}
