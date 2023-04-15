package mega.backend_onemore._230317;

import java.util.Scanner;

/**
 아이디가 틀리면 -> "존재하지 않는 회원입니다." 출력
 비밀번호가 틀리면 -> "비밀번호 틀립니다." 출력
 로그인에 성공하면 -> "로그인되었습니다." 출력
 */

public class Login1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("아이디를 입력하세요 : ");
    String inputId = sc.next();
    System.out.print("비밀번호를 입력하세요 : ");
    String inputPw = sc.next();

    String id = "hello";
    String pw = "world";


    if (id.equals(inputId)) {
      if (!pw.equals(inputPw)) {
        System.out.println("비밀번호가 틀립니다.");
      } else {
        System.out.println("로그인 되었습니다.");
      }
    }
    else {
      System.out.println("존재하지 않는 회원입니다.");
    }

    /*
    //또는 if / else if 로도 표현이 가능하더라 => 내가 처음에  짰던 코드. 이게 더 단순할수도

    if (id.equals(inputId)) {
      System.out.println("존재하지 않는 회원입니다.");
    } else if (pw.equals(inputPw)) {
      System.out.println("비밀번호가 틀립니다.");
    } else {
      System.out.println("로그인 성공하였습니다.");
    }

     */

  }

}
