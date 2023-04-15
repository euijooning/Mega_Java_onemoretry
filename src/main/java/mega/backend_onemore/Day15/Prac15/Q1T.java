package mega.backend_onemore.Day15.Prac15;

import java.util.Scanner;

/*
1. 좌석 입력 메서드 / 주고 받고
- 좌석 수와 스캐너 매개변수로 받고
- 입력값을 저장할 select 1차원배열 생성
- 입력 받고, 그 결과값을 [0] [1]에 저장
- select를 리턴

2. 잘못된 입력  메서드 / 주고 받고
- int[] select, int count, int[][] seat 를 매개변수로 받고
- 범위를 벋어나면
  (select[0]<1 || select[0] >9 || select[1] >2 || select[1]<1), 잘못된 입력
- 그렇지 않으면,
  return seatCheck(count, seat, select);
- 바깥에서는 작업이 안 이루어진 상태므로
  count를 그대로 리턴(받은 값 그대로)

3. 좌석 체크 메서드 / 주고 받고
- 똑같이 (int count, int[][] seat,int[] select)를 매개변수로 받고
- 그 자리가 비어있으면, 예약을 받고 그 실행 결과를 리턴하고
(메서드로 따로 분리. reservationRun(count,seat,select);)
- 차있으면, 빈좌석 프린트한다음에(역시 메서드 emptyPrint(seat);)
  받은 count를 그대로 리턴

4. 예약 하기 메서드 / 주고 받고
- 좌석을 채우고, count를 하나 줄여서 리턴
seat[select[0]-1][select[1]-1]++

5. 비어있는 좌석 출력 메서드 / 안주고 받고
- 이중 for문 돌면서 자리가 없으면 seat[i][j] == 0
- 행과 열에 +1 씩 해서 출력해줌.

6. main문
- 스캐너, 카운트, 9/2의 좌석 배열seat[][] 생성
- while(count > 0) 일 때
-- 선택한 좌석은 입력을 받아서 select 배열에 저장하고,
-- count에는 wrongcheck()의 결과값을 저장한다.
-- 그리고 System.out.println("모든 자리가 예약됐습니다."); 출력.

 */

public class Q1T {
  static int[] input(int count, Scanner sc) {
    int[] select = new int[2];
    System.out.println("예약하실 좌석을 입력해주세요(총"+count+"석)");
    System.out.print("행 : ");
    select[0]= sc.nextInt();
    System.out.print("열 : ");
    select[1] = sc.nextInt();
    return select;

  }
  static int wrongCheck(int[] select, int count, int[][] seat) {
    if(select[0]<1 || select[0] >9 || select[1] >2 || select[1]<1) {
      System.out.println("잘못된 입력입니다.");
    }
    else {
      return seatCheck(count, seat, select); // 올바른 입력이면, 좌석 체크
    }
    return count; // 전달받은 count 그대로 리턴
  }
  static int seatCheck(int count, int[][] seat,int[] select) {
    if(seat[select[0]-1][select[1]-1] == 0) { // 배열의 index 차이 때문에 -1 해준 것.
      return reservationRun(count,seat,select);
    }
    else {
      emptyPrint(seat); // 비어있는 좌석 출력
      return count;  // 받은 count 그대로 리턴
    }
  }
  static int reservationRun(int count, int[][] seat,int[] select) {
    System.out.println("예약이 완료 됐습니다.");
    seat[select[0]-1][select[1]-1]++; // 좌석 예약 하나 증가
    return --count; // 잔여석의 수는 감소.
  }
  static void emptyPrint(int[][] seat) {
    System.out.println("비어있는 좌석 ");
    for(int i = 0;i<seat.length;i++) {
      for(int j = 0;j<seat[i].length;j++) {
        if(seat[i][j] == 0) {
          System.out.println("행 : "+(i+1)+"열 : "+(j+1));
        }
      }
    }
  }

  public static void main(String[] args) {

    int[][] seat = new int[9][2];  //[8][1]
    Scanner sc = new Scanner(System.in);
    int count = 18;
    while(count > 0) {
      int[] select = input(count, sc);
      count = wrongCheck(select, count, seat);
    }
    System.out.println("모든 자리가 예약됐습니다.");
  /*
  이 부분은 while loop를 사용하여 입력한 좌석이 예약 가능한지 확인하고,
  예약이 완료될 때마다 count 값을 감소시켜
  최대 좌석 수를 넘지 않는 범위 내에서 예약을 진행하는 코드입니다.

  while loop는 count 값이 0보다 큰 동안 계속해서 실행됩니다.
  input 메소드를 통해 좌석을 입력받고,
  wrongCheck 메소드를 통해 좌석이 유효한지 확인합니다.
  만약 유효한 좌석이면 seatCheck 메소드를 호출하여
  해당 좌석이 예약 가능한지 확인하고,

  예약 가능하면 reservationRun 메소드를 호출하여
  예약을 완료하고 count 값을 1 감소시킵니다.

  이렇게 while loop를 통해
  입력받은 좌석이 예약 가능한지 확인하고 예약을 진행하는 과정을 반복하다가,
  count 값이 0이 되면 while loop를 빠져나와
  "모든 자리가 예약됐습니다." 라는 메시지를 출력합니다.
   */
  }

}
