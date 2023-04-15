package mega.backend_onemore.Day03.Prac03;
/*
String id = “korea”
String passwd = “1234”


Id 입력 : XXXX
패스워드 입력 : XXXXX

Id와 패스워드가 맞으면  -> “환영합니다. Korea님”

Id와 또는 패스워드가 틀리면
  id가 틀린경우 패스워드 맞고 -> id가 올바르지 않습니다.
  id가 맞고 패스워드가 틀린경우 -> 패스워드가 올바르지 않습니다.
  id 패스워드 모두 틀린경우 -> id와 패스워드가 올바르지 않습니다.
 */

import java.util.Scanner;

public class Q01 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String id = "korea";
    String passwd = "1234";

    System.out.print("아이디를 입력하세요. : ");
    String checkId = sc.next();

    System.out.print("비밀번호를 입력하세요. : ");
    String checkPasswd = sc.next();

    if (id.equals(checkId) && passwd.equals(checkPasswd)) {
      System.out.println("환영합니다. korea님.");
    } else if (!(id.equals(checkId)) && passwd.equals(checkPasswd)) {
      System.out.println("Id가 올바르지 않습니다.");
    } else if (id.equals(checkId) && !(passwd.equals(checkPasswd))) {
      System.out.println("비밀번호가 틀렸습니다.");
    } else {
      System.out.println("Id와 비밀번호가 모두 올바르지 않습니다.");
    }

  }

}
