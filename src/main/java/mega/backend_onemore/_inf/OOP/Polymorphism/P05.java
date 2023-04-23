package mega.backend_onemore._inf.OOP.Polymorphism;

//문제
// 추상 클래스와 상속을 사용하여 다형성 예제를 만들어보시오.
// 이 문제는 추상 클래스와 상속의 개념을 이해하고 이를 활용하여 다형성을 구현할 수 있는지를 묻는 문제이다.


abstract class Car05 {
  abstract void run();
}

class Ambulance05 extends Car05 {

  void run() {
    System.out.println("앰블런스 지나가요~ 삐뽀삐뽀~");
  }
}

class Cultivator05 extends Car05 {
  void run() {
    System.out.println("경운기 지나가요~ 덜컹덜컹~");
  }
}

class SportsCar05 extends Car05 {
  void run() {
    System.out.println("스포츠카 지나가요~ 씽~");
  }
}

public class P05 {

  public static void main(String[] args) {
    // [1] : 객체 생성
    Car05 c1 = new Ambulance05();	// 정상
    Car05 c2 = new Cultivator05();	// 정상
    Car05 c3 = new SportsCar05();	// 정상

    // [2] : run() 메서드 호출
    c1.run();
    c2.run();
    c3.run();

  }

}
