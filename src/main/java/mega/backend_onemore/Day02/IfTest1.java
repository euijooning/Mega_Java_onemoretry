package mega.backend_onemore.Day02;

import java.util.Scanner;

// 성적 출력 프로그램
// 성적 입력 후 90~100점 : 합격
// 0~89점 : 불합격
// 이외는 잘못된 입격

public class IfTest1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("성적을 입력하세요 : ");
    int grade = sc.nextInt();

    //합격 100~90
    if(grade >= 90 && grade <=100) {
      System.out.println("축하합니다. 합격입니다.");
      System.out.println("대단하시네요.");
    }
    //불합격 89~0
    else if(grade < 90 && grade >=0) {
      System.out.println("아쉽지만 불합격입니다.");
      System.out.println("공부하셨나요?");
    }
    //이외는 잘못된 입력
    else {
      System.out.println("잘못된 입력입니다.");
    }
  }

}
