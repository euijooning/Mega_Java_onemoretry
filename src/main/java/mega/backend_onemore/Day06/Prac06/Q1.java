package mega.backend_onemore.Day06.Prac06;

public class Q1 {

  // 별찍기 문제
  public static void main(String[] args) {
    //1. 직사각형
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        System.out.print("*");
      }
      System.out.println();
    }

    // 2. 정직삼각형
    for (int i = 0; i <= 5; i++) {
      for (int j = 0; j < i; j++) { // 지금 i만큼 반복한다는 것을 확인할 수가 있지.0->4까지 깔끔하게 변하므로
        System.out.print("*");
      }
      System.out.println();
    }

    System.out.println();

    // 3. 역직삼각형
    for (int k = 0; k < 5; k++) {
      // 변하는 값을 일단 x와 y로 치환해서 기다리고 있다.
      for (int i = 0; i < 4 - k; i++) { // N을 그냥 5로 적으면, i<4-k 라고 표현 가능
        System.out.print(" "); // 공백 개수
      }
      for (int j = 0; j < k + 1; j++) {
        System.out.print("*"); // 별 개수
      }
      System.out.println(); // 줄바꿈이 필요하다.
    }

    //4. 피라미드
    for (int i = 0; i < 5; i++) {  // 0 1 2 3 4
      for (int j = 4; j > i; j--) { // 4 3 2 1 // 4 3 2 // 4 3 // 4
        System.out.print(" ");
      }
      for (int j = 0; j <= i * 2; j++) { // 0 // 0 1 2 // 0 1 2 3 4 // 0 1 2 3 4 5 6 // 0 1 2 3 4 5 6 7 8
        System.out.print("*");
      }
      System.out.println();
    }

    // 5. 다이아몬드
    for (int i = 0; i < 3; i++) {  // 0 1 2 3 4
      for (int j = 2; j > i; j--) { // 4 3 2 1 // 4 3 2 // 4 3 // 4
        System.out.print(" ");
      }
      for (int j = 0; j <= i * 2; j++) { // 0 // 0 1 2 // 0 1 2 3 4 // 0 1 2 3 4 5 6 // 0 1 2 3 4 5 6 7 8
        System.out.print("*");
      }
      System.out.println();
    }

    for (int i = 0; i<2; i++) {
      for (int j = 0; j<=i; j++) {
        System.out.print(" ");
      }
      for (int j = 3; j>i*2; j--) { // 줄어드는 것도 두 배씩 줄어드므로.
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
