package mega.backend_onemore.Day03.Prac03;

/*
아이디어

1. 입력받기
2. 올바르게 입력했는지 확인
- 중첩 if문 필요
2-1. 공통적으로 해당하는 달, 온도 모두 해당
2-2. 달이 봄인지(다른 계절인지) if문
2-3. 해당 달의 온도가 맞는지 체크하고, 계절 + 온도 출력
2-4. 아니면 계절과 온도가 맞지 않습니다 출력
2-5. 이걸 if/elseif 반복
 */

import java.util.Scanner;

public class Q02_T_2 {

  // 계절과 온도를 한 번에 합쳐서 더욱 간략하게 표현하기
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    //1. 입력
    System.out.print("월 입력 : ");
    int month = sc.nextInt();
    System.out.print("온도 입력 : ");
    int temp = sc.nextInt();

    //하나로 합치기
    if (month >= 1 && month <= 12 && temp >= -15 && temp <= 37) {
      if ((month >= 3 && month <= 5) && (temp >= 3 && temp <= 15)) {
        System.out.println("계절은 봄입니다. 온도는 " + temp + " 입니다.");
      } else if ((month >= 6 && month <= 8) && (temp >= 17 && temp <= 35)) {
        System.out.println("계절은 여름입니다. 온도는 " + temp + " 입니다.");
      } else if ((month >= 9 && month <= 11) && (temp >= 3 && temp <= 15)) {
        System.out.println("계절은 가을입니다. 온도는 " + temp + " 입니다.");
      } else if ((month == 12 || month == 1 || month == 2) && (temp >= -15 && temp <= 2)) {
        System.out.println("계절은 겨울입니다. 온도는 " + temp + "입니다."); // 12, 1, 2월은 한번에 못하니까.
      } else {
        System.out.println("계절과 온도가 맞지 않습니다.");
      }
    }
  }
}

