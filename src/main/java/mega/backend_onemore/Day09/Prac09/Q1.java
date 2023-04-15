package mega.backend_onemore.Day09.Prac09;
/*
배열의 크기가 5인 배열이 있습니다.
랜덤으로 1 ~ 9 값을 각 배열에 저장합니다.
단 중복은 제거해야 합니다.
각각 다른 값으로 배열 다섯 개의 값을 랜덤으로 채워주세요.
그리고 나서 오름차순으로 정렬해주세요.
 */

import java.util.Random;

//1. 초기화 작업
//2. 랜덤 값 받기
//3. 정렬 전 랜덤 값 출력하기(비교를 위해)
//4. 정렬하기
//5. 정렬 후 랜덤값 출력하기
public class Q1 {

  public static void main(String[] args) {
    //1. 초기화 작업
    Random r = new Random();
    int[] a = new int[5];

    //2.랜덤값 받기
    for(int i = 0; i<a.length; i++) {
      a[i] = r.nextInt(9) + 1;
      for (int j = 0; j<i; j++) {
        if(a[i] == a[j]) { // 중복값이 들어오면
          i--; // 횟수에서 제외
          break;
        }
      }
    }
    //3. 랜덤값 정렬 전에 먼저 출력하기
    for (int i = 0; i<a.length; i++) {
      System.out.println("a[" + i + "] : " + a[i]);
    }
    System.out.println();

    //4.정렬하기
    for (int i = 0; i<a.length - 1; i++) { // 자신은 빼고 돈다.
      // 그래서 length - 1
      for (int j = i+1; j<a.length; j++) {
        if (a[i] > a[j]) {
          int temp = a[j];
          a[j] = a[i];
          a[i] = temp;
        }
      }

      // 번외 : 경우의 수 출력
      System.out.print((i+1) + "번째 - ");
      // i+1이라고 하는 이유는 배열의 특성.
      for (int k = 0; k<a.length; k++) {
        System.out.print("a["+k+"] : " + a[k] + " ");
      }
      System.out.println();
    }

    System.out.println();

    //5.정렬 후 랜덤 값 출력하기
    for (int i = 0; i<a.length; i++) {
      System.out.println("a["+i+"] : " + a[i]);
    }


  }

}
