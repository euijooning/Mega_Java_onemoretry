package mega.backend_onemore.Day08;

import java.util.Scanner;

public class ArrayTest3 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("배열 b의 크기 입력 : ");
    int num = sc.nextInt();
    int[] b = new int[num];
    int[] a = new int[10];


// 배열 b의 모든 요소 출력
    System.out.print("배열 b : ");
    for (int i =0; i<b.length; i++) {
      System.out.print(b[i] + " ");
    }
    System.out.println(); // 줄바꿔서 a 출력하게


    // 배열 a의 모든 요소 출력
    System.out.print("배열 a : ");
    for (int i = 0; i<a.length; i++) {
      System.out.print(a[i] + " ");
    }





  }

}
