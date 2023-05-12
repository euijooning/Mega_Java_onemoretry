package mega.backend_onemore.Day28.Prac28;
// 객체 사용하여 전화번호부 만들기
// ArrayList 사용하여 만들면 된다.

import java.util.ArrayList;
import java.util.Scanner;

/*
요소 : 이름, 전화번호, 주소, 나이
메뉴 선택하면 기능이 작동되도록.
1. 추가  2. 삭제  3. 전체 조회  4. 이름 검색  5. 종료
 */
class CallList {
  String name;
  String phoneNumber;
  String address;
  int age;

  CallList(String name, String phoneNumber, String address, int age) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.age = age;

  }

  void print() {
    System.out.println("이름 : " + name + ", 전화번호 : " + phoneNumber + ", 주소 : " + address + ", 나이 : " + age);
  }
}


public class Q1_My {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    ArrayList<CallList> phoneList = new ArrayList();

    while (true) {
      System.out.println("<전화번호부>");
      System.out.println("메뉴입력 : 1.추가, 2.삭제, 3.전체 조회, 4.이름 검색, 5.종료 > ");
      int num = sc.nextInt();

      if (num == 1) {
        System.out.println("<추가>");
        System.out.print("이름 : ");
        String name = sc.next();

        System.out.print("전화번호 : ");
        String phoneNumber = sc.next();

        System.out.print("주소 : ");
        String address = sc.next();

        System.out.print("나이 : ");
        int age = sc.nextInt();

        phoneList.add(new CallList(name, phoneNumber, address, age));

      } else if (num == 2) {
        System.out.println("<삭제>");
        System.out.print("이름 : ");
        String removeName = sc.next();

        for (int i = 0; i < phoneList.size(); i++) {
          if (phoneList.get(i).name.equals(removeName)) {
            phoneList.remove(i);
            break;
          } else {
            if (i == phoneList.size()) {
              System.out.println("목록에 없는 사용자입니다.");
            }
          }
        }

      } else if (num == 3) {
        System.out.println("전체 목록을 출력합니다.");

        if (phoneList.isEmpty()) {
          System.out.println("전화번호부가 완전히 비어있습니다.");
        }
        else {
          for (int i = 0; i < phoneList.size(); i++) {
            phoneList.get(i).print();;
          }

        }

      } else if (num == 4) {
        System.out.println("이름을 검색합니다.");
        System.out.print("이름 : ");
        String searchName = sc.next();

        for(int i = 0; i<phoneList.size(); i++) {
          if(phoneList.get(i).equals(searchName)) {
            phoneList.remove(i);
          }
          else {
            System.out.println("해당하는 이름이 존재하지 않습니다.");
          }
        }

      } else if (num == 5) {
        System.out.println("프로그램을 종료합니다.");
        break;
      }

    }

  }
}