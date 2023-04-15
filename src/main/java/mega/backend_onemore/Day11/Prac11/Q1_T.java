package mega.backend_onemore.Day11.Prac11;

import java.util.Scanner;
// 최대공약수, 최소공배수 찍기 문제

public class Q1_T {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);

    System.out.print("숫자 1 입력 : ");
    int num1 = sc.nextInt();
    System.out.print("숫자 2 입력 : ");
    int num2 = sc.nextInt();

    int a = num1; // 입력받은 수를 a에 대입
    int b = num2; // 입력받은 수를 b에 대입

    int gcd = 0; //최대공약수
    int lcm = 0; //최소공배수

    int temp = 1;

    while(temp>0) {
      temp = a % b; // 120 % 36 temp = 12 // 36 % 12 temp = 0
      a = b; // a = 36 // a = 12
      b = temp; // b = 12 //  b = 0
    }

    gcd = a; // 12

    lcm = num1 * num2 / gcd; // 120 * 36 / 12

    System.out.println("최대공약수 : "+gcd);
    System.out.println("최소공배수 : "+lcm);

  }

}


