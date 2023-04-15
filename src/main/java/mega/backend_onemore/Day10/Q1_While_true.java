package mega.backend_onemore.Day10;

import java.util.Scanner;

public class Q1_While_true {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // 좌석은 총 18 / 9행 2열
    int[][] seat = new int[9][2];  //[8][1]

    //입력
    Scanner sc = new Scanner(System.in);

    int count = 18;

    while(true) {
      System.out.println("예약하실 좌석을 입력해주세요(총"+count+"석)");
      System.out.print("행 : ");
      int h = sc.nextInt();
      System.out.print("열 : ");
      int y = sc.nextInt();

      //잘못된 입력
      if(h<1 || h >9 || y >2 || y<1) {
        System.out.println("잘못된 입력입니다.");
      }
      else {
        //예약 여부확인
        if (seat[h-1][y-1] == 0) {
          System.out.println("예약이 완료 됐습니다.");
          count--;
          seat[h-1][y-1]++;
        }
        else {
          System.out.println("비어있는 좌석 ");
          for(int i = 0;i<seat.length;i++) {
            for(int j = 0;j<seat[i].length;j++) {
              if(seat[i][j] == 0) {
                System.out.println("행 : "+(i+1)+"열 : "+(j+1));
              }
            }
          }
        }
      }

      if(count == 0) {
        break;
      }
    }
    System.out.println("모든 자리가 예약됐습니다.");

  }

}