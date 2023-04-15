package mega.backend_onemore.Day05.Prac05;

import java.util.Scanner;

// 구구단 출력 심화
public class Q03 {
  public static void main(String[] args) {

    while(true) {
      Scanner sc = new Scanner(System.in);
      System.out.print("원하는 메뉴를 선택하세요 - \n 1. 원하는 구구단 출력 \n 2. 전체 구구단 출력 \n 3. 프로그램 종료 \n : " );
      int selectNum = sc.nextInt();

      if(selectNum == 1) {
        System.out.println(" 원하는 단 수를 입력하세요: ");

        int num1 = sc.nextInt();
        int multiple = 0;

        for (int j=1; j<10; j++) { //원하는 단만 출력하면 되므로, 곱해지는 수만 가져오면 되지.
          multiple = num1*j;
          System.out.println(num1 + "*" + j + " = " + multiple);
        }
      }

      else if (selectNum == 2) {
        int multiple = 0;
        for(int i = 2; i<10; i++) {
          for (int j=1; j<10; j++) {
            multiple = i*j;
            System.out.println(i + " * " + j + " = " + multiple);
          }
        }
      }

      else if(selectNum == 3) {
        System.out.println("프로그램 종료");
        break;
      }

      else {
        System.out.println("잘못된 입력입니다.");
      }
    }
  }

}
