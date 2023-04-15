package mega.backend_onemore.Day04.Prac04;
// 8의 약수 출력하는 프로그램 만들기

/*
1. 약수 구할 수 입력
2. 기본 출력문 System.out.print( num + "의 약수 : ");
3. for문 돌면서 약수 구하기 식,
3-1. 문자열 " ," 첨가해서 출력
4. 최종적으로 System.out.print(num + "입니다."); 하면
   num의 약수는 x, x, x ... 요런   형태가 나옴.
 */

import java.util.Scanner;

public class Q2_T {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.print("약수 입력 : ");

    int num = sc.nextInt();
    System.out.print( num + "의 약수 : "); // 기본 출력 값이고,


    for(int i = 1; i < num; i++) {
      if(num % i == 0) {
        System.out.print(i+", "); // 문자열 더하기는 여기서 해줬고
      }
    }
    System.out.print(num + "입니다.");
  }

}
