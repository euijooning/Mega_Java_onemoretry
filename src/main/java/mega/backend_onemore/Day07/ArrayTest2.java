package mega.backend_onemore.Day07;

public class ArrayTest2 {

  public static void main(String[] args) {

    int[] a = new int[10]; // 이게 사라짐. 가비지 컬랙션
    a = new int[20];

    for(int i = 0;i<10;i++) {
      a[i]  = i + 1;
    }

    System.out.println("1부터 10까지만 값이 차있고, 나머지 10개는 0으로 나온다.");
    for(int i = 0;i<a.length;i++) {
      System.out.println(a[i]);
    }

  }
}
