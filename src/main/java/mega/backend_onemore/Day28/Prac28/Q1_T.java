package mega.backend_onemore.Day28.Prac28;

import java.util.ArrayList;
import java.util.Scanner;

// 전화번호부 기본 예제
class PhoneData{
  String name;
  String tel;
  String address;
  int age;

  PhoneData(String name, String tel, String address, int age) {
    this.name = name;
    this.tel = tel;
    this.address = address;
    this.age = age;
  }
}



public class Q1_T {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    ArrayList<PhoneData> telList = new ArrayList<PhoneData>();

    while(true) {
      System.out.print("1.추가 2.삭제 3.전체출력 4.이름검색 5.종료 ");
      int num = sc.nextInt();
      if(num == 1) { // 추가
        System.out.print("이름 : ");
        String name = sc.next();
        System.out.print("전화번호 : ");
        String tel = sc.next();
        System.out.print("주소 : ");
        String address = sc.next();
        System.out.print("나이 : ");
        int age = sc.nextInt();

        telList.add(new PhoneData(name,tel,address,age)); // 전부 객체 안에 집어넣어서 만듦

      }
      else if(num ==2) { // 삭제
        System.out.print("이름 : ");
        String name = sc.next();
        int i;
        for(i = 0;i<telList.size();i++) {
          if(telList.get(i).name.equals(name)) { // tellist의 name이 입력받은 name과 같으면
            telList.remove(i); // 삭제
            System.out.println(name+"을 삭제 했습니다.");
            break;
          }
        }
        if(i == telList.size()) { // 크기만큼 다 돌았는데도 안 걸리면
          System.out.println("찾는 이름이 없습니다."); // 없는 것임.
        }

      }
      else if(num ==3) { // 전체 출력
        for(int i = 0;i<telList.size();i++) {
          System.out.println("이름 : "+telList.get(i).name+
              ", 전화번호 : "+telList.get(i).tel+
              ", 주소 : "+telList.get(i).address+
              ", 나이 : "+telList.get(i).age);
        }
      }
      else if(num == 4) { // 이름 검색
        System.out.print("이름 : ");
        String name = sc.next();
        int i;
        for(i = 0;i<telList.size();i++) {
          if(telList.get(i).name.equals(name)) { // tellist의 name이 입력받은 name과 같으면
            System.out.println("이름 : "+telList.get(i).name+
                ", 전화번호 : " + telList.get(i).tel+
                ", 주소 : " + telList.get(i).address+
                ", 나이 : " + telList.get(i).age); // 요소 전부 출력
            break;
          }
        }
        if(i == telList.size()) {
          System.out.println("찾는 이름이 없습니다.");
        }
      }
      else if(num == 5) {
        System.out.println("종료합니다.");
        break;
      }
      else {
        System.out.println("잘못된 입력입니다.");
      }

    }

  }
}

