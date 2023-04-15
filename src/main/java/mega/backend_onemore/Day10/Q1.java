package mega.backend_onemore.Day10;

import java.util.Scanner;

// 비행기 좌석 예약 퀴즈
// 좌석 총 18자리
// 행과 열 입력 => 예약 좌석 0 되면 프로그램 종료
// 해당 행 열에 아무도 예약 없을 시 "예약이 완료되었습니다." 출력
// 그 자리가 예약 된 자리라면 "다시 예약해주세요" 출력 후
// 비어있는 좌석을 출격해서 알려준다.
// 비어있는 좌석은 1 1 입니다. 이렇게

//(행과 열을 입력 시 행은 8보다 크거나 0보다 작거나
// / 열은 1보다 크거나 0보다 작으면 "잘못된 입력입니다." 출력)

public class Q1 {

  public static void main(String[] args) {

    // 1. 좌석 배열 생성 + 입력 받기
    // 좌석은 총 18 / 9행 2열
    int[][] seat = new int[9][2];  //[8][1]
    Scanner sc = new Scanner(System.in);
    int count = 18;

    while(count > 0) {
      System.out.println("예약하실 좌석을 입력해주세요(총" + count + "석)");
      System.out.print("예약하실 행 : ");
      int h = sc.nextInt();
      System.out.print("예약하실 열 : ");
      int y = sc.nextInt();

    //2. 잘못된 입력 처리 + 예약 여부 확인
      if(h<1 || h >9 || y >2 || y<1) {
        System.out.println("잘못된 입력입니다.");
      }
      else {
        if(seat[h-1][y-1] == 0) { //입력받은 좌석과 배열의 인덱스의 차이를 줄이기 위한 -1
          System.out.println("예약이 완료 됐습니다.");
          count--; // 예약되었으니까 남아있는 좌석을 줄여주기 위함.
          seat[h-1][y-1]++;
          /*
          seat[h-1][y-1]++;는 선택된 좌석의 예약 상태를 1로 업데이트하는 코드입니다.
          여기서, seat[h-1][y-1]은 선택된 좌석의 예약 상태를 나타내는 변수이며,
          ++ 연산자를 사용하여 이 변수의 값을 1 증가시킵니다.
          이렇게 하면, 선택된 좌석의 예약 상태를 1로 변경하게 되며,
          나중에 같은 좌석이 다시 선택되었을 때 예약이 불가능하도록 처리됩니다.
          즉, 이 코드는 선택된 좌석을 예약 상태로 변경하는 역할을 수행합니다.
           */
        }
       else{
         System.out.println("비어있는 좌석은 다음과 같습니다. ");
          for(int i = 0;i<seat.length;i++) {
            for(int j = 0;j<seat[i].length;j++) {
              if(seat[i][j] == 0) {
                System.out.println("행 : "+(i+1)+"열 : "+(j+1));
              }
            }
          }
        }
      }
    }
    System.out.println("모든 자리가 예약됐습니다.");
  }
}
