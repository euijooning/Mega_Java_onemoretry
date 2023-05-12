package mega.backend_onemore.Day32.Prac32;

import java.util.Random;
import java.util.Scanner;

class Product {
  String type; // 컴퓨터인지 뭔지 확인하고 출력해줘도 괜찮으나, 귀찮은 일이다.
  // 그래서 그냥 타입을 박아버렸어
  String brand;

  void print() {

  }
}

class Computer extends Product {
  // 여기에 지금처럼 멤버변수가 없으면, 생성자에서 this나 super나 똑같아지게 됨
  // 하지만 여기에 있으면, 두 개 구별을 반드시 해줘야지.

  Computer(String brand) { // 종류는 해당하는 거 박아버리면 되지만 브랜드는 가져와서 넣어줘야지.
    super.type ="컴퓨터"; //super을 써주면 더욱 명확해짐.
    super.brand = brand;
  }
}

class AirConditioner extends Product {

  AirConditioner(String brand) {
    super.type ="에어컨";
    super.brand = brand;
  }
}

class Ref extends Product {

  Ref(String brand) {
    super.type = "냉장고";
    super.brand = brand;
  }
}

class AirCleaner extends Product {

  AirCleaner(String brand) {
    super.type = "공기청정기";
    super.brand = brand;
  }
}

// 여기서는 마트 따로 안 만드시고 그대로 감.

public class Q1 {

  public static void main(String[] args) {
    Random r = new Random();
    Scanner sc = new Scanner(System.in);

    Product[] products = new Product[40]; //40칸 배열을 만든거지 객체가 만들어진 건 아니다.
    String[] brand1 = {"삼성", "LG"};
    String[] brand2 = {"LG", "다이슨"};
    // 브랜드를 배열로 받아서, 객체 생성 시에 랜덤으로 배정되게 만듦.
    // if문이 하나 줄어서 조금 더 간결해지는 효과는 있음.


    // 객체 만들어 넣어주기
    for (int i = 0; i<products.length; i++) {
      int num = r.nextInt(4);
      if (num == 0) {
        products[i] = new Computer(brand1[r.nextInt(2)]);

      } else if (num == 1) {
        products[i] = new AirConditioner(brand1[r.nextInt(2)]);

      } else if (num == 2) {
        products[i] = new Ref(brand1[r.nextInt(2)]);

      } else {
        products[i] = new AirCleaner(brand2[r.nextInt(2)]);
      }
    }

    // 입력받기
    System.out.print("제품 입력 : ");
    String type = sc.next();
    System.out.print("제조사 입력 : ");
    String brand = sc.next();

    // 제품 찾기 있는지(찾고 + 출력 까지)
    boolean notFound = true;

    for(int i = 0;i<products.length;i++) {
      if(products[i].type.equals(type) && products[i].brand.equals(brand)) { // 찾은 것
        System.out.println(i+"번째 제품 입니다.");
        notFound = false; // 탈출하기 위함.
        break;
      }
    }

    // 없으면 없다고 10번 나오면 이상하기 때문에 단일 if로 분리한 것.
    if(notFound) { // 다 돌았으니 제품이 없는 것!
      System.out.println("제품이 없습니다.");
    }

  }
}

