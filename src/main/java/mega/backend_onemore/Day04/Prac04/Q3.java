package mega.backend_onemore.Day04.Prac04;
// 성적 출력 프로그램 만들기
// 나의 답안

import java.util.Scanner;

public class Q3 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.print("국어 점수를 입력하세요 : ");
    int a = sc.nextInt();

    System.out.print("수학 점수를 입력하세요 : ");
    int b = sc.nextInt();

    System.out.print("영어 점수를 입력하세요 : ");
    int c = sc.nextInt();

    String x = "국어";
    String y = "영어";
    String z = "수학";
    String inputError = "";

    if(!(a >= 0 && a <= 100) || !(a >= 0 && a <= 100) || !(a >= 0 && a <= 100)) {
      if(a<0 || a>100) {
        inputError += "국어 ";
      }
      if (b<0 || b>100) {
        inputError += "수학 ";
      }
      if (c<0 || c>100) {
        inputError += "영어 ";
      }
      System.out.println(inputError + " 점수 입력이 잘못 되었습니다.");
    }


    double avg = 0;
    avg = (double)(a+b+c) / 3 ;


    if(avg >= 95 && avg == 100) {
      System.out.println("A+");
    } else if(avg >= 90 && avg < 95) {
      System.out.println("A");
    } else if(avg >= 85 && avg < 90) {
      System.out.println("B+");
    } else if(avg >= 80 && avg < 85) {
      System.out.println("B");
    } else if (avg >= 75 && avg < 80) {
      System.out.println("C+");
    } else if (avg >= 70 && avg < 75) {
      System.out.println("C");
    } else if (avg >= 65 && avg < 70) {
      System.out.println("D");
    } else {
      System.out.println("F");
    }
  }
}
