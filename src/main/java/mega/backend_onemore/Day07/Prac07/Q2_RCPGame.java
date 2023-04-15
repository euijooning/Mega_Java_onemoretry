package mega.backend_onemore.Day07.Prac07;
import java.util.Random;
import java.util.Scanner;

public class Q2_RCPGame {
  // 가위바위보 게임
  // 1> 1. 게임시작 2. 종료 입력

  //2> 1. 입력 시
  //2-1> 컴퓨터는 랜덤 수
  //2-2> 사용자는  1. 가위 2. 바위, 3. 보 중에서 선택

  //2-3>  user 1 / user 2 / user 3 선택 시 => com 1/com2/com3 매치 여부에 따라 승부 결과 출력
  //2-4> 2 입력 시 "프로그램을 종료합니다" 출력 후 반복문 탈출

  //3> 1 또는 2도 아닌 경우 "잘못된 입력입니다." 출력

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in); // 입력
    Random r = new Random(); // 랜덤

    while (true) {

      // 메뉴선택
      System.out.print("1.게임시작 2.종료 : ");
      int num = sc.nextInt();

      // 게임시작
      if (num == 1) {
        // com 랜덤 수 생성
        int com = r.nextInt(3) + 1;
        System.out.print("1.가위, 2바위 3.보를 선택해주세요 : ");

        // 유저 가위바위보 선택
        int user = sc.nextInt();
        System.out.println("User : " + user + "Com : " + com);

        /*
        //User1 - Com3 -> -2
        //User2 - Com1 -> 1
        //User3 - Com2 -> 1
        if (user > 0 && user < 4) {
          int result = user - com;

          if (result == -2 || result == 1) {
            System.out.println("User승");
          } else if (result == 0) {
            System.out.println("무승부");
          } else {
            System.out.println("Com승");
          }
        } else {
          System.out.println("잘못된 입력입니다.");
        }

         */




				if(user == 1) { // 가위
					if(com == 1) { // 가위
						System.out.println("무승부");
					}
					else if(com == 2) { //바위
						System.out.println("Com승");
					}
					else { // 보
						System.out.println("User승");
					}
				}
				else if(user == 2) { //바위
					if(com == 1) { // 가위
						System.out.println("User승");
					}
					else if(com == 2) {//바위
						System.out.println("무승부");
					}
					else { // 보
						System.out.println("Com승");
					}
				}
				else if(user == 3) {//보
					if(com == 1) { // 가위
						System.out.println("Com승");
					}
					else if(com == 2) {//바위
						System.out.println("User승");
					}
					else { // 보
						System.out.println("무승부");
					}
				}
				else {
					System.out.println("잘못된 입력입니다.");
				}


      } else if (num == 2) {
        System.out.println("프로그램을 종료합니다.");
        break;


      } else {
        System.out.println("잘못된 입력입니다.");
      }
    }
  }

}

