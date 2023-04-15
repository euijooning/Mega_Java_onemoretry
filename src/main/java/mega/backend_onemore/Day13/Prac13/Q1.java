package mega.backend_onemore.Day13.Prac13;

import java.util.Scanner;

/*
1. 입력 메서드 주고 안받고
- 스캐너 만들고 1차원 배열 생성해서
- score 배열을 리턴

2. 평균 구하기 메서드 / 주고 받고
- int[] 배열을 받아서(점수)
- 평균 계산 식을 그대로 리턴(결과값)
- 여기서는 score[x] 뭐 요런 식으로 바로 씀. 그 자체가 정수니까

3. 학점 구하기 메서드 / 주고 받고
- 평균점수를 받아서
- 학점을 저장할 String 문자열 hak 하나 생성
- 등급 나누기 분기(if문)
- 다 끝내고 hak을 리턴해줌

4. 잘못된 입력 메서드 안주고 안받고
System.out.println("잘못된 입력입니다.");

5. 학점 출력 메서드 / 안주고 받고
- 평균(int)과 학점(String)을 받고
- 평균 계산해서 출력
System.out.printf
("평균 점수는 %.1f, 학점은 %s 입니다.",avg,hak);

6. 전체 돌아가는 메서드 / 안주고 받고
- 전체 입력받은 점수를 매개변수로 받고
- 점수 조건이 맞는지 안 맞는지 if문 분기
- 점수 조건이 맞으면 평균 계산(결과값 변수 저장)
- 학점도 출력(매개변수: (avg,gradeOP(avg))
- 그렇지 않으면 잘못된 입력 출력

7. main
checkRun(input()); 이것만 있으면 됨.


 */

public class Q1 {

  static int[] input() {
    Scanner sc = new Scanner(System.in);
    int[] score = new int[3];
    System.out.print("국어 : ");
    score[0]= sc.nextInt();

    System.out.print("영어 : ");
    score[1] = sc.nextInt();

    System.out.print("수학 : ");
    score[2] = sc.nextInt();

    return score;
  }

  static double avgOP(int[] score) {
    return (score[0]+score[1]+score[2])/3.0; // 평균값
  }

  static String gradeOP(double avg) {
    String hak = "";
    if(avg>=95){
      hak = "A+";
    }
    else if(avg>=90){
      hak = "A";
    }
    else if(avg>= 85) {
      hak = "B+";
    }
    else if(avg>=80) {
      hak = "B";
    }
    else if(avg>=75) {
      hak = "C+";
    }
    else if(avg>=70) {
      hak = "C";
    }
    else if(avg>=65) {
      hak = "D";
    }
    else {
      hak = "F";
    }
    return hak;

  }

  static void checkRun(int[] score) {
    if(score[0]>=0 && score[0]<=100 && score[1]>=0 && score[1]<=100
        && score[2]>=0 && score[2]<=100) {

      double avg = avgOP(score);
      hakJumPrint(avg,gradeOP(avg));
    }
    else {
      wrongPrint();
    }
  }

  static void wrongPrint() {
    System.out.println("잘못된 입력입니다.");
  }

  static void hakJumPrint(double avg, String hak) {
    System.out.printf("평균 점수는 %.1f, 학점은 %s 입니다.",avg,hak);
  }

  public static void main(String[] args) {

    checkRun(input());
  }

}