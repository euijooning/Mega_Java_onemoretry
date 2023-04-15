package mega.backend_onemore.MakeStar;
// 3. 역직삼각형
// 공백도 문자일 수 있다는 idea!
// 공백을 네개 찍고 별 / 세개 찍고 별별 / ...

public class Star03 {
  public static void main(String[] args) {
    int N = 5;
    // k 0 1 2 3 4
    // x 4 3 2 1 0
    // x를 k 가지고 표현이 가능한가?
    // 4 4-0 / 3 4-1 / 2 4- 2 / 1 4-3 / 0 4-4 형태이다.
    // 그러면 x = N-1-k(현재 N = 5로 주어짐) => 4-k

    // k 0 1 2 3 4
    // y 1 2 3 4 5
    // y를 k 가지고 표현이 가능한가?
    // 1 0+1 / 2 1+1 / 3 2+1 / 4 3+1 / 5 4+1
    // 그러면 y = k+1

    for (int k = 0; k<5; k++) {
      // 변하는 값을 일단 x와 y로 치환해서 기다리고 있다.
      for(int i = 0; i<N-1-k; i++) { // N을 그냥 5로 적으면, i<4-k 라고 표현 가능
        System.out.print(" "); // 공백 개수
      }
      for(int j = 0; j<k+1; j++) {
        System.out.print("*"); // 별 개수
      }
      System.out.println(); // 줄바꿈이 필요하다.
    }

// 시작: 피라미드는 일단 별 찍히는 개수만 정확하게 인지하면 된다. 두 배씩 찍히면 됨.
    // 두 배씩 찍히면 된다. 홀수개로 늘면 되지 라고 하셨음. 53분부터 다시 듣기
    /*
    for (int k = 0; k<5; k++) {
      // 변하는 값을 일단 x와 y로 치환해서 기다리고 있다.
      for(int i = 0; i<x; i++) {
        System.out.print(" "); // 공백 네 개
      }
      for(int j = 0; j<y; j++) {
        System.out.print("*"); // 별 한 개
      }
    }

     */

    // 변하는 값은? 공백의 수와 별의 수(i와 j의)

    /*

    // 첫번째 줄
    for(int i = 0; i<4; i++) {
      System.out.print(" "); // 공백 네 개
    }
    for(int j = 0; j<1; j++) {
      System.out.print("*"); // 별 한 개
    }
    System.out.println();


    // 두번째 줄
    for(int i = 0; i<3; i++) {
      System.out.print(" "); // 공백 세 개
    }
    for(int j = 0; j<2; j++) {
      System.out.print("*"); // 별 두 개
    }
    System.out.println();


    // 세번째 줄
    for(int i = 0; i<2; i++) {
      System.out.print(" "); // 공백 두 개
    }
    for(int j = 0; j<3; j++) {
      System.out.print("*"); // 별 세 개
    }
    System.out.println();


    // 네번째 줄
    for(int i = 0; i<1; i++) {
      System.out.print(" "); // 공백 한 개
    }
    for(int j = 0; j<4; j++) {
      System.out.print("*"); // 별 네 개
    }
    System.out.println();

    // 다섯번째 줄
    for(int i = 0; i<0; i++) {
      System.out.print(" "); // 공백 제로
    }
    for(int j = 0; j<5; j++) {
      System.out.print("*"); // 별 다섯 개
    }
    System.out.println();
     */
  }

}

