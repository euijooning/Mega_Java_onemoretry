package mega.backend_onemore.Day25.Prac25;
/*
마트게임 상속으로 변경 => 배열 10개만 담게끔 바꾸시면 됩니다.
 */
/*
이 경우를 보고 언제 클래스를 쓰고, 언제 인터페이스를 쓰면 좋을 지 판단 가능
여기서는 필드까지 대부분 중복이 되므로,
일일이 구현 다 해줘야 하는 인터페이스 대신에
클래스로 두고 필드도 상속받아 쓰는 게 더 나은 선택.
 */

import java.util.Scanner;

interface Product {
  void use();
}

class Computer implements Product{

  String menu;
  String cpu;
  int price;

  Computer(String menu, String cpu, int price) {
    this.menu = menu;
    this.cpu = cpu;
    this.price = price;
  }

  public void use() {
    System.out.println("제조사가 " + menu + "인 " + cpu + " 스펙의 컴퓨터를 사용합니다.");
    // 가격은 여기 가지고 있는 게 아니라 사람이 사면 차감시키려고 하는 것이기 때문에,
    // 여기 굳이 넣어줄 필요가 없다.
  }
}

class Airconditioner implements Product {

  String menu;
  String type;
  int price;

  Airconditioner(String menu, String type, int price) {
    this.menu = menu;
    this.type = type;
    this.price = price;
  }

  public void use() {
    System.out.println("제조사가 " + menu + "인 " + type + " 에어컨을 사용합니다.");
  }
}

class Ref implements Product {

  String menu;
  String type;
  String size;
  int price;

  Ref(String menu, String type, String size, int price) {
    this.menu = menu;
    this.type = type;
    this.size = size;
    this.price = price;
  }

  public void use() {
    System.out.println("제조사가 " + menu + "인 " + type + "형 " + size + " 냉장고가 식품을 관리합니다.");
  }
}

class AirCleaner implements Product  {

  String menu;
  int price;

  AirCleaner(String menu, int price) {
    this.menu = menu;
    this.price = price;
  }

  public void use() {
    System.out.println("제조사가 " + menu + "인 " + "공기청정기가 공기를 깨끗하게 합니다.");
  }
}

class Mart {

  // 10개씩 전부 가지고 있어야 함.
  Computer[] com = new Computer[10];
  Airconditioner[] ac = new Airconditioner[10];
  Ref[] ref = new Ref[10];
  AirCleaner[] air = new AirCleaner[10];

  int index; //null 바꿈을 용이하게 하기 위한 변수 선언.

  Mart() {
    for (int i = 0; i < 10; i++) { // 아예 마트가 생성될 때 객체 넣어주기
      if (i < 5) { //0~4
        com[i] = new Computer("삼성", "i7", 200);
        ac[i] = new Airconditioner("삼성", "벽걸이", 100);
        ref[i] = new Ref("삼성", "양문", "600L", 200);
        air[i] = new AirCleaner("다이슨", 60);
      } else { // 5~9
        com[i] = new Computer("LG", "i5", 150);
        ac[i] = new Airconditioner("LG", "스탠드형", 250);
        ref[i] = new Ref("LG", "4도어", "800L", 350);
        air[i] = new AirCleaner("LG", 80);
        // 헷갈림 방지를 위해 LG랑 다이슨 순서 바꿨음.
      }
    }
  }

  // 소비자에게 전달하는 기능
  // 전달하고 null로 바꿔주는 것 필요.
  // 얘들만 신경쓰면 나머지는 바깥에서 해결을 해 줄것이다.

  // 시작점과 끝점을 받아서, 객체가 있는지 체크를 한 후
  // 객체가 있으면 소비자에게 주고, 없으면 null을 보냄(못 사는 것)

  // 여기서는 객체가 넘어가야 하니까, 자료형이 Computer
  Computer sendComputer(int start, int end) { // 시작점과 끝점을 받아서
    // 삼성: start 0 , end 5(작다니까) // LG: start 5 , end 10
    for (int i = start; i < end; i++) { //이렇게 하면, 삼성send, LGsend 따로 만들 필요가 없음.
      if (com[i] != null) { // null이 아니면
        index = i; // null로 나중에 바꿔줘야하는데, 이걸 체크 안하면 어디 인덱스가 팔렸는지를 파악하기 어렵다.
        // 마트에서 바로 체크하기 위해서 편리하게
        return com[i]; //컴퓨터를 소비자에게 주면 됨.
      }
    }
    return null; //for문을 돌았는데 객체가 없을 때.(다 팔린 것)
  }

  Airconditioner sendAircon(int start, int end) {
    for (int i = start; i < end; i++) {
      if (ac[i] != null) {
        index = i;
        return ac[i];
      }
    }
    return null;
  }

  Ref sendRef(int start, int end) {
    for (int i = start; i < end; i++) {
      if (ref[i] != null) {
        index = i;
        return ref[i];
      }
    }
    return null;
  }

  AirCleaner sendAirCleaner(int start, int end) {
    for (int i = start; i < end; i++) {
      if (air[i] != null) {
        index = i;
        return air[i];
      }
    }
    return null;
  }


  // 소비자에게 전달된 객체를 null로 바꾸는 기능
  void changeComputerNull() {
    com[index] = null; // 위에서 인덱스를 받았으므로, 편리하게 사용 가능.
  }

  void changeAirconditionerNull() {
    ac[index] = null;
  }

  void changeRefNull() {
    ref[index] = null;
  }

  void changeAirCleanerNull() {
    air[index] = null;
  }
}


class Human {

  // 일단 객체가 없는 장바구니를 만들어서 가지고 있으면 됨.
  // 뭘 살 지 모르니까 전부 가지고 있게 만드는 것(일단 조금 비효율적)
  Product[] pro = new Product[10];
  int money;


  // 마트에서 산 객체를 담아주는 기능
  void receiveProduct(Product product) { // 컴퓨터를 받아와서
    for (int i = 0; i < pro.length; i++) {
      if (pro[i] == null) { // 그 공간이 null이면
        pro[i] = product; // 구매한 컴퓨터를 채워준다(장바구니에)
        break;
      }
    }
  }


  // 내가 산 물품 출력
  void allPrint() {
    for (int i = 0; i < 10; i++) {
      if (pro[i] != null) {
      }
    }
  }

  //이제 main에서 연결만 시켜주면 된다.
  public class Q2 {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      Mart mart = new Mart();
      Human[] hum = new Human[3];

      // 소비자 돈 입력
      for (int i = 0; i < hum.length; i++) {
        hum[i] = new Human(); // Human 객체 생성
        System.out.print((i + 1) + "번째 소비자가 최초로 보유할 금액 입력 : "); // 인덱스 맞춰주기
        hum[i].money = sc.nextInt(); // Human의 money에 돈 입력
      }

      // 상품 구입 시작(공통조건 돈이 60원 이상)
      while (hum[0].money >= 60 || hum[1].money >= 60 || hum[2].money >= 60) {
        System.out.println("==========================================");
        for (int i = 0; i < hum.length; i++) {
          System.out.println((i + 1) + "번째 소비자 남은 금액 : " + hum[i].money);
          System.out.println();

          if (hum[i].money >= 60) { // 구입할 수 있는 조건을 먼저 적어줌. 해당 안 되면 넘어감.
            System.out.print(
                (i + 1) + "번째 소비자 상품을 선택해주세요 :  \n 1. 컴퓨터, 2. 에어컨, 3. 냉장고, 4. 공기청정기 > ");
            int item = sc.nextInt();

            if (item == 1) { // 컴퓨터 구매 시
              System.out.print("<컴퓨터 브랜드> 1. 삼성 2. LG : ");
              int brand = sc.nextInt();

              if (brand == 1) { // <브랜드> 삼성 컴퓨터 선택
                if (hum[i].money >= 200) { // 금액이 충분한 경우
                  Computer computer = mart.sendComputer(0, 5);
                  if (computer == null) { // 객체가 없는 경우
                    System.out.println("삼성 컴퓨터가 모두 팔린 상태입니다.");
                  } else { // 물건(객체)도 있고 돈도 충분한 경우
                    hum[i].money -= computer.price; // 소비자가 보유한 금액 - 삼성 컴퓨터 가격
                    hum[i].receiveProduct(computer); // 컴퓨터를 소비자가 보유하게 하기
                    mart.changeComputerNull(); // null로 바꿔줌.
                  }
                } else { // 돈이 부족한 경우
                  System.out.println("삼성 컴퓨터 구매하기에는 돈이 부족합니다.");
                  System.out.println();
                }

              } else if (brand == 2) {// <브랜드> LG 컴퓨터 선택
                if (hum[i].money >= 150) { // 금액이 충분한 경우
                  Computer computer = mart.sendComputer(5, 10);
                  if (computer == null) { // 객체가 없는 경우
                    System.out.println("LG 컴퓨터가 모두 팔린 상태입니다.");
                  } else { // 물건(객체)도 있고 돈도 충분한 경우
                    hum[i].money -= computer.price; // 소비자가 보유한 금액 - LG 컴퓨터 가격
                    hum[i].receiveProduct(computer); // 컴퓨터를 소비자가 보유하게 하기
                    mart.changeComputerNull(); // null로 바꿔줌.
                  }
                } else { // 돈이 부족한 경우
                  System.out.println("LG 컴퓨터 구매하기에는 돈이 부족합니다.");
                  System.out.println();
                }
              } else {
                System.out.println("컴퓨터 브랜드를 잘못 선택했습니다.");
              }


            } else if (item == 2) { // 에어컨 구매 시
              System.out.print("<에어컨 브랜드> 1. 삼성 2. LG : ");
              int brand = sc.nextInt();

              if (brand == 1) { // <브랜드> 삼성 에어컨 선택
                if (hum[i].money >= 100) { // 금액이 충분한 경우
                  Airconditioner aircon = mart.sendAircon(0, 5);
                  if (aircon == null) { // 객체가 없는 경우
                    System.out.println("삼성 에어컨이 모두 팔린 상태입니다.");
                  } else { // 물건(객체)도 있고 돈도 충분한 경우
                    hum[i].money -= aircon.price; // 소비자가 보유한 금액 - 삼성 에어컨 가격
                    hum[i].receiveProduct(aircon); // 에어컨을 소비자가 보유하게 하기
                    mart.changeAirconditionerNull(); // null로 바꿔줌.
                  }
                } else { // 돈이 부족한 경우
                  System.out.println("삼성 에어컨 구매하기에는 돈이 부족합니다.");
                  System.out.println();
                }

              } else if (brand == 2) {// <브랜드> LG 에어컨 선택
                if (hum[i].money >= 250) { // 금액이 충분한 경우
                  Airconditioner aircon = mart.sendAircon(5, 10);
                  if (aircon == null) { // 객체가 없는 경우
                    System.out.println("LG 에어컨이 모두 팔린 상태입니다.");
                  } else { // 물건(객체)도 있고 돈도 충분한 경우
                    hum[i].money -= aircon.price; // 소비자가 보유한 금액 - LG 에어컨 가격
                    hum[i].receiveProduct(aircon); // 에어컨을 소비자가 보유하게 하기
                    mart.changeAirconditionerNull(); // null로 바꿔줌.
                  }
                } else { // 돈이 부족한 경우
                  System.out.println("LG 컴퓨터 구매하기에는 돈이 부족합니다.");
                  System.out.println();
                }
              } else {
                System.out.println("컴퓨터 브랜드를 잘못 선택했습니다.");
              }
            } else if (item == 3) {
              // 냉장고 구매 시
              System.out.print("<냉장고 브랜드> 1. 삼성 2. LG : ");
              int brand = sc.nextInt();

              if (brand == 1) { // <브랜드> 삼성 냉장고 선택
                if (hum[i].money >= 200) { // 금액이 충분한 경우
                  Ref refrigerator = mart.sendRef(0, 5);
                  if (refrigerator == null) { // 객체가 없는 경우
                    System.out.println("삼성 냉장고가 모두 팔린 상태입니다.");
                  } else { // 물건(객체)도 있고 돈도 충분한 경우
                    hum[i].money -= refrigerator.price; // 소비자가 보유한 금액 - 삼성 냉장고 가격
                    hum[i].receiveProduct(refrigerator); // 냉장고를 소비자가 보유하게 하기
                    mart.changeRefNull(); // null로 바꿔줌.
                  }
                } else { // 돈이 부족한 경우
                  System.out.println("삼성 냉장고 구매하기에는 돈이 부족합니다.");
                  System.out.println();
                }

              } else if (brand == 2) {// <브랜드> LG 냉장고 선택
                if (hum[i].money >= 350) { // 금액이 충분한 경우
                  Ref refrigerator = mart.sendRef(5, 10);
                  if (refrigerator == null) { // 객체가 없는 경우
                    System.out.println("LG 냉장고가 모두 팔린 상태입니다.");
                  } else { // 물건(객체)도 있고 돈도 충분한 경우
                    hum[i].money -= refrigerator.price; // 소비자가 보유한 금액 - LG 냉장고 가격
                    hum[i].receiveProduct(refrigerator); // 냉장고을 소비자가 보유하게 하기
                    mart.changeRefNull(); // null로 바꿔줌.
                  }
                } else { // 돈이 부족한 경우
                  System.out.println("LG 냉장고 구매하기에는 돈이 부족합니다.");
                  System.out.println();
                }
              } else {
                System.out.println("냉장고 브랜드를 잘못 선택했습니다.");
              }
            } else if (item == 4) { // 공기청정기 선택
              // 공기청정기 구매 시
              System.out.print("<공기청정기 브랜드> 1. 다이슨 2. LG : ");
              int brand = sc.nextInt();

              if (brand == 1) { // <브랜드> 다이슨 선택
                if (hum[i].money >= 60) { // 금액이 충분한 경우
                  AirCleaner cleaner = mart.sendAirCleaner(0, 5);
                  if (cleaner == null) { // 객체가 없는 경우
                    System.out.println("다이슨 공기청정기 모두 팔린 상태입니다.");
                  } else { // 물건(객체)도 있고 돈도 충분한 경우
                    hum[i].money -= cleaner.price; // 소비자가 보유한 금액 - 다이슨 청정기 가격
                    hum[i].receiveProduct(cleaner); // 청정기를 소비자가 보유하게 하기
                    mart.changeAirCleanerNull(); // null로 바꿔줌.
                  }
                } else { // 돈이 부족한 경우
                  System.out.println("다이슨 공기청정기 구매하기에는 돈이 부족합니다.");
                  System.out.println();
                }

              } else if (brand == 2) {// <브랜드> LG 공기청정기 선택
                if (hum[i].money >= 80) { // 금액이 충분한 경우
                  AirCleaner cleaner = mart.sendAirCleaner(5, 10);
                  if (cleaner == null) { // 객체가 없는 경우
                    System.out.println("LG 공기청정기 모두 팔린 상태입니다.");
                  } else { // 물건(객체)도 있고 돈도 충분한 경우
                    hum[i].money -= cleaner.price; // 소비자가 보유한 금액 - LG 청정기 가격
                    hum[i].receiveProduct(cleaner); // 청정기를 소비자가 보유하게 하기
                    mart.changeAirCleanerNull(); // null로 바꿔줌.
                  }
                } else { // 돈이 부족한 경우
                  System.out.println("LG 공기청정기 구매하기에는 돈이 부족합니다.");
                  System.out.println();
                }
              } else {
                System.out.println("공기청정기 브랜드를 잘못 선택했습니다.");
              }
            } else {
              System.out.println("잘못된 입력입니다.");
            }
          }
        }
      }
      // 마지막 출력

      System.out.println();
      for (int i = 0; i < hum.length; i++) {
        System.out.println("<" + (i + 1) + "번째 소비자의 구매 상품>");
        hum[i].allPrint();
      }

    }
  }
}

