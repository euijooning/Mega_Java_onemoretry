package mega.backend_onemore.Day26;
// 클래스 형변환 문제
// 동물 : "나는 동물이다" / 색깔 기능
// 강아지, 고양이, 미어캣, 판다
// -> 오버라이딩 기능 (나는 + 색깔 + 종류 입니다.)

// 색깔은 빨강, 주황, 노랑, 초록, 파랑, 남색, 보라
// 동물 우리에는 총 10마리가 들어갈 수 있고,
// 이 과정은 랜덤을 통해서 이뤄짐
// 색깔은 랜덤 0~6 / 동물은 0~3
// 동물우리에 동물이 다 채워지면 각각 동물 기능을 호출하고 끝.
/*
깜찍한 idea
그런데, 동물이라는 클래스 자체가 객체로 만들어질 필요성이 있는가를 잘 생각해봐야.
(현실에서 강아지, 고양이는 있어도 "동물"이라는 존재는 없으니까...)
=> 그래서 동물클래스는 추상클래스로 만드는 게 좋음.
 */

import java.util.Random;

/*
접근 방향
1. 동물 클래스(추상)
- color 필드, print도 추상 메서드

2. 개 클래스 동물을 상속받음
- 생성자 color 매개변수
- print 메서드 오버라이딩

3. 고양이 클래스 동물을 상속받음
- 생성자 color 매개변수
- print 메서드 오버라이딩

4. 미어캣 클래스 동물을 상속받음
- 생성자 color 매개변수
- print 메서드 오버라이딩

5. 판다 클래스 동물을 상속받음
- 생성자 color 매개변수
- print 메서드 오버라이딩

6. main
- 랜덤 클래스, 동물 저장할 10개짜리 배열, 색깔 String 배열
- 동물 배열에 객체 채우기(if문 분기로 각각 집어넣기)
  ( 형태 : new Dog(color[colorRandom]); )
- print 메서드 호출
 */
abstract class Animal {
  String color;
  abstract void print();
}

class Dog extends Animal{
  Dog(String color){
    super.color = color; // 상위 클래스에서 정의한 color 멤버 변수에 값을 할당
  }

  void print() {
    System.out.println("나는 "+color+"강아지 입니다.");
  }
}


class Cat extends Animal{
  Cat(String color){
    super.color = color;
  }

  void print() {
    System.out.println("나는 "+color+"고양이 입니다.");
  }
}


class MeerKat extends Animal {
  MeerKat(String color){
    super.color = color;
  }

  void print() {
    System.out.println("나는 "+color+"미어캣 입니다.");
  }
}


class Panda extends Animal {
  Panda(String color){
    super.color = color;
  }
  void print() {
    System.out.println("나는 "+color+"판다 입니다.");
  }
}


public class Q1 {

  public static void main(String[] args) {

    Random r = new Random();
    Animal[] cage = new Animal[10]; // 동물 10마리 배열
    String[] color = {"빨간색","주황색","노란색","초록색","파란색","남색","보라색"};

    for(int i = 0;i<cage.length;i++) {
      int num = r.nextInt(4); // 동물 :0, 1, 2, 3
      int colorRandom = r.nextInt(7); // 색깔 0,1,2,3,4,5,6,7

      if(num == 0) { // 개
        cage[i] = new Dog(color[colorRandom]); // 색깔
      } // 물론 대괄호 안에 r.nextInt(7) 그대로 집어넣어도 무방하다.
      else if(num == 1) { // 고양이
        cage[i] = new Cat(color[colorRandom]);
      }
      else if(num == 2) { // 미어캣
        cage[i] = new MeerKat(color[colorRandom]);
      }
      else { // 나머지, 판다
        cage[i] = new Panda(color[colorRandom]);
      }

      // 마지막으로 동물이 가지고 있는 각각의 기능 출력.
      cage[i].print();
      // 우리에 들어갈 때마다 출력하여 보이게 하면 되므로
      // 굳이 반복문 돌릴 필요가 없음.
    }

  }
}
