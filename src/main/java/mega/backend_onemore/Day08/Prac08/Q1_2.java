package mega.backend_onemore.Day08.Prac08;

import java.util.Random;

public class Q1_2 {

  public static void main(String[] args) {
    Random r = new Random();
    int[] array = new int[10];
    int max = 0;
    int maxIndex = 0;

    for (int i = 0; i < array.length; i++) {
      array[i] = r.nextInt(11);
      if (max < array[i]) { // 배열 인덱스에 들어있는 값이 최댓값에 저장되어 있는 수보다 크면
        max = array[i];  // 최댓값 변수에 이 값을 저장한다. => update
        maxIndex = i;
      }
    }
    for (int i = 0; i < array.length; i++) {
      System.out.println("index[" + i + "] : " + array[i]);
    }
    System.out.print("최댓값 : [" + maxIndex + "] " );
  }

}
