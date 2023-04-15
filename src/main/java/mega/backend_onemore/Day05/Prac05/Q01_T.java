package mega.backend_onemore.Day05.Prac05;

// 선생님 풀이
  /*
  이중 for문 사용
  1) 바깥쪽 : 단 (i+"단") 출력
  2) 안쪽 : 곱해지는 수 (i+"*"+j+"="+(i*j)) 출력
   */

public class Q01_T {

  public static void main(String[] args) {

    for(int i =2; i<10; i++) {
      System.out.println(i+"단");

      for(int j =1;j<10;j++) {
        System.out.println(i + "*" + j + "=" + (i*j)); // 따로 변수 선언하지 않고 바로 쓰심.
      }
    }
  }
}
