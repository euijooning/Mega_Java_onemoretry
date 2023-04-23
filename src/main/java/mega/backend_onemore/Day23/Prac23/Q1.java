package mega.backend_onemore.Day23.Prac23;
// 잘 안 돌아감. 이상
// 2대장 마트 문제
// 1. 컴퓨터랑 에어컨, 냉장고, 공기청정기에는 필드와 생성자만 존재
// 1.-1 생성자는 그냥 우리가 기존에 만들던 방식 그대로.
// 2. 이 클래스들에는 사용하는 메서드만 있음.
// 3. 마트에는 앞선 세 개의 객체가 들어가 있는데, 배열로 넣었고,
//   인덱스가 있다.
// 4. 마트 생성자에는 객체 생성할 때, 0~4 / 5~9를 나눠서 속성을 입력하고 객체를 만들었다.
// 5. 각자 전달하는 기능

// 마트에 있다 => 객체까지 존재해야 한다.
// 소비자에게 먼저 돈 입력을 받아야 한다.
// 1번 소비자가 먼저 메뉴 고르고, 제품이 있으면 보유한 돈에서 차감하고
// 그 상품 객체가 바이어 쪽으로 넘어가면 돼요.
// 그리고 팔리고 나서 null로 변경

// 잘못된 입력 필요.
// 돈이 부족하다면 안 줘야 하므로 구매할 수 없다고 출력되고 다음으로 넘어가야함.
//만약 보유한 돈이 60원보다 적다면, 걔를 건너 뛰고 다음 소비자가 나와야 한다.
// 1,2,3번이 모두 더이상 살 여력이 없을 때 끝~!
// 나온 다음에 구매목록을 출력하면 된다.

/*
핵심 로직
- 마트에서 물건을 주고 send
- 사람이 물건을 받고 receive
- nullCheck.
- money 계산
끝. ㅎㅎ
 */


import java.util.Scanner;

class Computer {

  String menu;
  String cpu;
  int price;

  Computer(String menu, String cpu, int price) {
    this.menu = menu;
    this.cpu = cpu;
    this.price = price;
  }

  void use() {
    System.out.println("제조사가 " + menu + "인 " + cpu + " 스펙의 컴퓨터를 사용합니다.");
    // 가격은 여기 가지고 있는 게 아니라 사람이 사면 차감시키려고 하는 것이기 때문에,
    // 여기 굳이 넣어줄 필요가 없다.
  }
}

class Airconditioner {

  String menu;
  String type;
  int price;

  Airconditioner(String menu, String type, int price) {
    this.menu = menu;
    this.type = type;
    this.price = price;
  }

  void use() {
    System.out.println("제조사가 " + menu + "인 " + type + " 에어컨을 사용합니다.");
  }
}

class Ref {

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

  void use() {
    System.out.println("제조사가 " + menu + "인 " + type + "형 " + size + " 냉장고가 식품을 관리합니다.");
  }
}

class AirCleaner {

  String menu;
  int price;

  AirCleaner(String menu, int price) {
    this.menu = menu;
    this.price = price;
  }

  void use() {
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
  Computer[] com = new Computer[10];
  Airconditioner[] ac = new Airconditioner[10];
  Ref[] ref = new Ref[10];
  AirCleaner[] air = new AirCleaner[10];
  int money;


  // 마트에서 산 객체를 담아주는 기능
  void receiveComputer(Computer computer) { // 컴퓨터를 받아와서
    for (int i = 0; i < com.length; i++) {
      if (com[i] == null) { // 그 공간이 null이면
        com[i] = computer; // 구매한 컴퓨터를 채워준다(장바구니에)
        break;
      }
    }
  }

  void recieveAirconditioner(Airconditioner aircon) {
    for (int i = 0; i < ac.length; i++) {
      if (ac[i] == null) {
        ac[i] = aircon;
        break;
      }
    }
  }

  void receiveRef(Ref refrigerator) {
    for (int i = 0; i < ref.length; i++) {
      if (ref[i] == null) {
        ref[i] = refrigerator;
        break;
      }
    }
  }

  void receiveAirCleaner(AirCleaner cleaner) {
    for (int i = 0; i < air.length; i++) {
      if (air[i] == null) {
        air[i] = cleaner;
        break;
      }
    }
  }


  // 내가 산 물품 출력
  void allPrint() {
    // 전부 확인해줘야 하므로, 단일 if 사용하는게 맞다.
    for (int i = 0; i < 10; i++) { //전부 10개이므로
      if (com[i] != null) { // 담긴 객체가 있으면
        com[i].use(); // 그 공간에 있는 객체의 내용을 출력.
      }
      if (ac[i] != null) {
        ac[i].use();
      }
      if (ref[i] != null) {
        ref[i].use();
      }
      if (air[i] != null) {
        air[i].use();
      }
    }
  }
}

//이제 main에서 연결만 시켜주면 된다.
public class Q1 {

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
          System.out.print((i + 1) + "번째 소비자 상품을 선택해주세요 :  \n 1. 컴퓨터, 2. 에어컨, 3. 냉장고, 4. 공기청정기 > ");
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
                  hum[i].receiveComputer(computer); // 컴퓨터를 소비자가 보유하게 하기
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
                  hum[i].receiveComputer(computer); // 컴퓨터를 소비자가 보유하게 하기
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
                  hum[i].recieveAirconditioner(aircon); // 에어컨을 소비자가 보유하게 하기
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
                  hum[i].recieveAirconditioner(aircon); // 에어컨을 소비자가 보유하게 하기
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
                  hum[i].receiveRef(refrigerator); // 냉장고를 소비자가 보유하게 하기
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
                  hum[i].receiveRef(refrigerator); // 냉장고을 소비자가 보유하게 하기
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
                  hum[i].receiveAirCleaner(cleaner); // 청정기를 소비자가 보유하게 하기
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
                  hum[i].receiveAirCleaner(cleaner); // 청정기를 소비자가 보유하게 하기
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
      System.out.println("<"+ (i + 1) + "번째 소비자의 구매 상품>");
      hum[i].allPrint();
    }

  }
}