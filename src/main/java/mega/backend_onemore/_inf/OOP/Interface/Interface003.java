package mega.backend_onemore._inf.OOP.Interface;
// 문제
// 자바의 인터페이스 문법을 예제 코드로 구현해보시오.
// 이 문제는 자바 문법중 인터페이스에 대한 개념과 어떻게 사용하는지에 대해서 아는지를 묻는 문제이다.


class Person03 {
  // Field
  String name;
  int age;
  int weight;

  // Constructor
  Person03() {
  }
  Person03(String name, int age, int weight) {
    this.name = name;
    this.age = age;
    this.weight = weight;
  }

  // Method
  void wash() { System.out.println( "씻다." ); }
  void study() { System.out.println( "공부하다." ); }
  void play() { System.out.println( "놀다다." ); }
}

interface Allowance03 {
  // Abstract Method
  abstract void in(int price, String name);
  abstract void out(int price, String name);
}

interface Train03 {
  // Abstract Method
  abstract void train(int training_pay, String name);

}

class Student03 extends Person03 implements Allowance03, Train03 {
  // Field

  // Constructor
  Student03() {
  }

  Student03(String name, int age, int weight) {
    super(name, age, weight );
  }

  // Method
  public void in(int price, String name) {
    System.out.printf( "%s 에게서 %d원 용돈을 받았습니다.", name, price );
  }

  public void out(int price, String name) {
    System.out.printf( "%d원 금액을 지출했습니다. [지출용도 --> %s]", price, name );
  }

  public void train(int training_pay, String name) {
    System.out.printf( "[%s --> %d원 입금완료]", name, training_pay );
  }

}


public class Interface003 {

  public static void main(String[] args) {

    // [1] : 객체 생성
    Student03 s1 = new Student03( "홍길동", 20, 85 );

  }

}
