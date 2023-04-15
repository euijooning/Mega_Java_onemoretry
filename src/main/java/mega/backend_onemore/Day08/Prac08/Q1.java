package mega.backend_onemore.Day08.Prac08;

// 랜덤값 추출하여 최댓값 찍는 문제
  /*
  배열의 크기가 10인 것을 만드세요.
  값이 0~10인 랜덤수를 추출하여 저장합니다.
  배열 안의 값 중에 최댓값이 몇 번째 인덱스에 있는지 함께 출력해주세요.
   */
//1.랜덤값 받기
//2.최댓값 찾기
//3.모든 인덱스 출력
//4.최댓값 출력

import java.util.Random;

public class Q1 {

  public static void main(String[] args) {
    //1.랜덤값 받기
    Random r = new Random();
    int[] array = new int[10];
    int max = 0;
    int maxIndex = 0; // 최댓값과 배열 요소를 한꺼번에 출력하기 위한 조치.

    //2. 입력 받고 최댓값 찾기
    for (int i = 0; i<array.length; i++) {
      array[i] =r.nextInt(11);
    }
    //입력을 받고

    for (int i = 0; i<array.length; i++) {
      if (max < array[i]) {
        max = array[i];
      }
      // 최댓값과 비교해서 배열의 값이 더 크면
      // 이렇게 두 개로 쪼개서 볼 수 있다.
    }

    // 3. 4. 모든 배열 요소 출력 및 최댓값 출력
      for (int i = 0; i < array.length; i++) {
        System.out.println("index[" + i + "] : " + array[i]);
      }
      System.out.print("최댓값 : [" + maxIndex + "] " );

  }
}
