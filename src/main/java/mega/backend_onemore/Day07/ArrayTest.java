package mega.backend_onemore.Day07;

import java.util.Arrays;

public class ArrayTest {

  public static void main(String[] args) {
    int[] a = new int[5];
//    int b[] = new int[5]; //이렇게도 출력 가능하다는 뜻.
    int[] kor = new int[100]; // [0] ~ [99]

    System.out.println("배열의 길이는 : " + kor.length);

    System.out.println("===========");

    for(int i =0;i<100;i++) {
      kor[i] = i + 1;
    }

    System.out.println("1부터 100까지 차례대로 출력함");
    for(int i=0;i<100;i++) {
      System.out.println(kor[i]);
    }
    System.out.println("==============");

    System.out.println("100번째 요소의 값을 출력함.");
    System.out.println(kor[99]);

    System.out.println("==============");

    a[0] = 10;
    a[1] = 20;
    a[2] = 30;
    a[3] = 40;
    a[4] = 50;

    System.out.println("값을 직접 넣어서 차례대로 출력함.");
    for(int i = 0;i<5;i++) {
      System.out.println(a[i]);
    }
    System.out.println("=========");
    System.out.println("또는");
    // 또는
    System.out.println(Arrays.toString(a)); // 이거 가능
  }

}
