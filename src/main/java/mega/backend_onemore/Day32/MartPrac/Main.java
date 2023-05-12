package mega.backend_onemore.Day32.MartPrac;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Product {
  String name;
  String brand;

  public Product(String name, String brand) {
    this.name = name;
    this.brand = brand;
  }

  public String toString() {
    return "제조사: " + brand + " / 종류 : " + name;
  }
}


class Computer extends Product {
  public Computer(String name, String brand) {
    super(name, brand);
  }
}

class AirConditioner extends Product {
  public AirConditioner(String name, String brand) {
    super(name, brand);
  }
}

class Ref extends Product {
  public Ref(String name, String brand) {
    super(name, brand);
  }
}

class AirCleaner extends Product {
  public AirCleaner(String name, String brand) {
    super(name, brand);
  }
}

class Mart {
  List<Product> products = new ArrayList<>();
}

public class Main {

  public static void main(String[] args) {

    Mart mart = new Mart();
    Random random = new Random();
    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < 40; i++) {
      int num = random.nextInt(4); //0~3
      if (num == 0) { // computer
        int brandNumber = random.nextInt(2);
        if (brandNumber == 0) { // samsung
          mart.products.add(new Computer("컴퓨터", "삼성"));
        } else {
          mart.products.add(new Computer("컴퓨터", "LG"));
        }

      } else if (num == 1) {
        int brandNumber = random.nextInt(2); // 0~1
        if (brandNumber == 0) {
          mart.products.add(new AirConditioner("에어컨", "삼성"));
        } else {
          mart.products.add(new AirConditioner("에어컨", "LG"));
        }

      } else if (num == 2) {
        int brandNumber = random.nextInt(2);
        if (brandNumber == 0) {
          mart.products.add(new Ref("냉장고", "삼성"));
        } else {
          mart.products.add(new Ref("냉장고", "LG"));
        }

      } else { // num == 3
        int brandNumber = random.nextInt(2);
        if (brandNumber == 0) {
          mart.products.add(new AirCleaner("공기청정기", "다이슨"));
        } else {
          mart.products.add(new AirCleaner("공기청정기", "LG"));
        }
      }
    }

    // 40개의 제품 출력하기
    for (Product product : mart.products) {
      System.out.println(product);
    }
    System.out.println("====================");

    // 제품과 제조사를 입력받아서 해당 제품&제조사가 존재하면 최초의 인덱스, 없으면 없다 출력
    System.out.print("찾고싶은 제품 입력 : ");
    String goods = sc.next();
    System.out.print("제품 제조사 입력 : ");
    String company = sc.next();

    boolean find = false;
    int index = -1;

    for (int i = 0; i < mart.products.size(); i++) {
      Product product = mart.products.get(i);
      if (product.name.equals(goods) && product.brand.equals(company)) {
        index = i;
        find = true;
        break;
      }
    }

    // 사용자는 냉장고 -> Ref, LG
    if (find) {
      System.out.println("상품 최초의 위치 : " + (index+1) + "번째에 있습니다.");
    } else {
      System.out.println("상품이 목록에 없습니다.");
    }
  }
}
