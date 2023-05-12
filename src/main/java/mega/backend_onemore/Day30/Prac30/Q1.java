package mega.backend_onemore.Day30.Prac30;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Phone {
  String name;
  String phoneNumber;
  String address;

  Phone(String name, String phoneNumber, String address){
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.address = address;
  }
}

class  Controller{
  //전화번호 리스트
  //입력
  ArrayList<Phone> tel;
  Scanner sc;

  Controller(){
    tel = new ArrayList<>();
    sc = new Scanner(System.in);
  }

  //1. 입력
  // main의 파일을 읽고 Controller있는 리스트를 완성
  // 에 따라서 이 입력이 달라질 것이다.
  // 아예 비어있으면 처음부터 다 채우는 것이므로, 사이즈가 0인지 아닌지 확인이 필요하다.

  void input(FileWriter fw) throws IOException { //main에서 FileWriter를 받아오는게 더 효율적이라고 판단.
    if(tel.size() == 0) { //0이면, 채워넣어준다.
      // 출력  양식 지정 (여기 기준 : tab)
      String openning = "이름"+"\t\t"+"전화번호"+"\t\t"+"주소"+"\r\n";
      tel.add(new Phone("이름", "전화번호", "주소"));
      fw.write(openning);
    }
    System.out.print("이름 : ");
    String name = sc.next();
    System.out.print("전화번호 : ");
    String number = sc.next();
    System.out.print("주소 : ");
    String address = sc.next();

    // 받은 값들을 추가
    tel.add(new Phone(name, number, address));

    String total = name+"\t\t"+number+"\t\t"+address+"\r\n";
    fw.write(total); // 예외처리 필요.
    fw.close();
  }

  //2. 삭제
  void delete() throws IOException { // 삭제할 이름이 있을때만 동작하게 만들면 된다.
    System.out.print("검색할 이름을 넣어주세요 : ");
    String search = sc.next();

    //검색을 어떻게 할 거냐, 그냥 하려고 해도 파일에서 이름을 따로 뺀다음에 번거롭다.
    // 이걸 편리하게 만들기 위해서 아까 ArrayList를 따로 만들어뒀던 것.
    int index = -1;

    for(int i = 0;i<tel.size();i++) {
      if(tel.get(i).name.equals(search)) {
        index = i;
        break;
      }
    }
    /*
    for문 안에서 index = i를 사용하는 이유는
    검색한 이름과 일치하는 이름을 가진 객체를 찾았을 때,
    그 객체의 인덱스를 저장하기 위해서입니다.
    tel.get(i)는 리스트에서 i번째 요소를 반환합니다.
    이때, tel.get(i).name은 i번째 요소의 이름을 나타냅니다.
    검색한 이름과 일치하는 이름을 가진 객체를 찾으면,
    해당 객체의 인덱스를 index 변수에 저장합니다. 그리고 for문을 빠져나옵니다
     */

    if(index == -1) {
      System.out.println("삭제할 이름이 없습니다.");
    }
    else {
      FileWriter fw = new FileWriter("phone.txt",false);
      //새로 만들기 // 덮어쓰기

      tel.remove(index); // 해당 인덱스의 내용을 지우고 다시 써야지

      for(int i = 0;i<tel.size();i++) { // 다시 새로 써주기
        String total = tel.get(i).name+"\t\t"+tel.get(i).phoneNumber+"\t\t"
            +tel.get(i).address+"\r\n";
        fw.write(total);
      }
      fw.close(); // 다 끝나면 종료.
    }
  }


  //3. 전체출력

  void allPrint() throws IOException {
		/*
		쉽게 찾는 방법~!
		if(tel.size() == 0) {
			System.out.println("없습니다.");
		}
		else {
			for(int i = 0;i<tel.size();i++) {
				System.out.println(tel.get(i).name
				                  +","+tel.get(i).phoneNumber+","+tel.get(i).address );
			}
		}
		*/

    tel.clear();

    FileReader fr = new FileReader("phone.txt");
    BufferedReader reader = new BufferedReader(fr);
    String line;
    String[] splitLine; // split을 하면 자른 만큼 문자열 배열에 들어가게 하려고

    while((line = reader.readLine()) != null) {
      splitLine = line.split("\t\t"); // 탭 단위로 자름. 잘려서 알아서 들어간다.

      //자른 것을 다시 넣어줌 [0]이름 [1]전화번호 [2]주소
      tel.add(new Phone(splitLine[0], splitLine[1], splitLine[2]));
    }

    if(tel.size() == 0) {
      System.out.println("없습니다.");
    }
    else {
      for(int i = 0;i<tel.size();i++) {
        System.out.println(tel.get(i).name +","+tel.get(i).phoneNumber
                            +","+tel.get(i).address );
      }
    }

  }


  //4. 검색 // 삭제랑 매커니즘 동일
  void search() {
    System.out.print("검색할 이름을 넣어주세요 : ");
    String search = sc.next();

    int index = -1; // 못찾은 경우 대비

    for(int i = 0;i<tel.size();i++) {
      if(tel.get(i).name.equals(search)) {
        index = i;
        break;
      }
    }

    if(index == -1) {
      System.out.println("검색 결과가 없습니다.");
    }
    else {
      System.out.println(tel.get(index).name +", "
                        + tel.get(index).phoneNumber+", "+ tel.get(index).address );
    }

  }

}



public class Q1 {

  public static void main(String[] args) throws IOException {
    // 파일을 읽고 Controller있는 리스트를 완성
    Controller ct = new Controller();
    Scanner sc = new Scanner(System.in);

    //1. 파일 존재여부 확인
    File f = new File("phone.txt");
    if(f.exists()) { // 존재하면 => Controller의 ArrayList에 넣어주기만 하면 됨.
      ct.tel.clear(); // 안전장치

      FileReader fr = new FileReader("phone.txt");
      BufferedReader reader = new BufferedReader(fr);
      String line;
      String[] splitLine = null;

      // 있으면.
      while((line = reader.readLine()) != null) {
        splitLine = line.split("\t\t");
        ct.tel.add(new Phone(splitLine[0], splitLine[1], splitLine[2]));
      }
    }

    //2. 사용자 입력에 따라 동작
    while(true) {
      System.out.print("1.입력 2.검색 3.삭제 4.출력 5.종료 : ");
      int num = sc.nextInt();

      FileWriter fw; // 파일 만들기

      // 파일이 없는 경우가 문제.
      if(ct.tel.size() == 0) {
        fw = new FileWriter("phone.txt",false);
        // 새로쓰기 => 파일 새로 작성해줌.
      }
      else { // 내용이 있으면.
        fw = new FileWriter("phone.txt",true); // 이어쓰기
      }

      // 동작시키기

      if(num == 1) {
        ct.input(fw);
      }
      else if(num == 2) {
        ct.search();
      }
      else if(num == 3) {
        ct.delete();
      }
      else if(num == 4) {
        ct.allPrint();
      }
      else if(num == 5) {
        System.out.println("프로그램을 종료합니다.");
        break;
      }
      else {
        System.out.println("잘못된 입력입니다.");
      }

    }


  }

}
