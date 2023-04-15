package mega.backend_onemore.Day02;

import java.util.Scanner;

// 스캐너 만들기 예제
public class ScannerTest {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); // 스캐너 사용하는 객체를 생성함.

    System.out.print("숫자를 입력하세요 : ");
    int a = sc.nextInt();
    System.out.println("입력한 숫자는: " + a);
  }
}
