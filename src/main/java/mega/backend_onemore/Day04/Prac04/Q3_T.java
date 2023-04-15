package mega.backend_onemore.Day04.Prac04;

// 성적 출력 프로그램 만들기

/*
1. 국어점수, 영어점수, 수학점수 입력 + 잘못된 문자열 저장할 빈 String 하나 생성
2, 학점 출력
1) if
2-1. 조건은 점수가 모두 0점 이상 100점 이하인 경우
2-2. 평균은 세 과목 더해서 3.0으로 나누는 경우
2-3. 평균점수와 학점 분기(printf  사용)
2) else
3. 잘못된 점수 입력 문자열에 저장 후 출력
3-1 wrongSubject += "과목" 식으로 if-else if문
3-2. 점수가 잘 못 입력되었습니다.

 */

import java.util.Scanner;

public class Q3_T {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.print("국어 점수 : ");
    int kor = sc.nextInt();

    System.out.print("영어 점수 : ");
    int eng = sc.nextInt();

    System.out.print("수학 점수 : ");
    int math = sc.nextInt();

    String wrongSubject = "";

    //3. 학점출력
    if(kor>=0 && kor<=100 && eng>=0 && eng<=100 && math>=0 && math<=100) {

      //2. 평균 구하기
      double avg = ((kor+eng+math)/3.0); // 평균값 : 굳이 과목명에(double) 안 붙여줘도 됨. 3.0으로 나누고 있잖아.
      //System.out.print(avg); //평균값 확인하기

      if(avg>=95){ // 범위는 윗 부분에 포함되는 것이 있으니, 이렇게 절삭해도 무방하다.
        System.out.printf("평균 점수는 %.1f, 학점은 A+ 입니다.",avg);
      }
      else if(avg>=90){
        System.out.printf("평균 점수는 %.1f, 학점은 A 입니다.",avg);
      }
      else if(avg>= 85) {
        System.out.printf("평균 점수는 %.1f, 학점은 B+ 입니다.",avg);
      }
      else if(avg>=80) {
        System.out.printf("평균 점수는 %.1f, 학점은 B 입니다.",avg);
      }
      else if(avg>=75) {
        System.out.printf("평균 점수는 %.1f, 학점은 C+ 입니다.",avg);
      }
      else if(avg>=70) {
        System.out.printf("평균 점수는 %.1f, 학점은 C 입니다.",avg);
      }
      else if(avg>=65) {
        System.out.printf("평균 점수는 %.1f, 학점은 D 입니다.",avg);
      } else {
        System.out.printf("평균 점수는 %.1f, 학점은 F 입니다.",avg);
      }
    }

    //4.잘못된 과목 이름 출력

    else {
      if(kor<0 || kor>100) {
        wrongSubject += "국어 ";
      }
      if(eng<0 || eng>100) {
        wrongSubject += "영어 ";
      }
      if(math<0 || math>100) {
        wrongSubject += "수학 ";
      }
      System.out.println(wrongSubject+" 점수가 잘못 입력되었습니다.");
    }
  }
}
