package mega.backend_onemore.Day03.Prac03;

 /*
내것과의 차이점
: !을 전체 괄호로 쓰지 않고, id와 passwd 앞에만 !를 사용한다.
 */
  /*
  Id 입력 : XXXX
  패스워드 입력 : XXXXX

  Id와 패스워드가 맞으면  -> “환영합니다. Korea님”

  Id와 또는 패스워드가 틀리면
  id가 틀린경우 패스워드 맞고 -> id가 올바르지 않습니다.
  id가 맞고 패스워드가 틀린경우 -> 패스워드가 올바르지 않습니다.
  id 패스워드 모두 틀린경우 -> id와 패스워드가 올바르지 않습니다.
  */

  /*
  1. 입력 스캐너 생성
  2. 주어진 입력값 입력
  3. 아이디, 패스워드 받기
  4. 경우의 수 나누기
  4-1. 아이디, 패스워드가 모두 일치하는 경우
  4-2. id가 올바르지 않습니다.
  4-3. 패스워드가 올바르지 않습니다.
  4-4. 아이디와 패스워드가 일치하지 않습니다.
   */


import java.util.Scanner;

public class Q01_T {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String id = "korea";
    String passwd = "1234";

    System.out.print("ID 입력 : "); // ID 입력 : 출력
    String user_id = sc.next();
    System.out.print("패스워드 입력 : ");
    String user_pw = sc.next();

    if(id.equals(user_id) && passwd.equals(user_pw)) {
      System.out.println("환영합니다." + user_id+"님");
    }
    else if(!id.equals(user_id) && passwd.equals(user_pw)) {
      System.out.println("id가 올바르지 않습니다.");
    }
    else if(id.equals(user_id) && !passwd.equals(user_pw)) {
      System.out.println("패스워드가 올바르지 않습니다.");
    }
    else {
      System.out.println("id와 패스워드가 올바르지 않습니다.");
    }
  }

}
