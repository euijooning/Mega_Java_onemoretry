package mega.backend_onemore._230317;

import java.util.Scanner;

public class Login2 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String inputId = sc.next();
    String inputPw = sc.next();

    String id = "hello";
    String pw = "world";

    login(id, pw, inputId, inputPw); // 메인 메서드에서 로그인 실행

  }
  public static boolean login(String id, String pw, String inputId, String inputPw) {
    // if -> equals 비교 -> return값 true/false
    if (id.equals(inputId)) { // id값이 입력한 아이디와 같은 경우
      if (!pw.equals(inputPw)) {
        return false; // 비밀번호가 일치하지 않으면 로그인 실패
      } else {
        return true; // 로그인 성공(id == inputId
      }
    } else {
      return false; // id가 입력한 아이디와 다른 경우 로그인 실패
    }
  }

}
