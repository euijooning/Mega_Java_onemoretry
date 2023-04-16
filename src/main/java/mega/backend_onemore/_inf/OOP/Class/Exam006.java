package mega.backend_onemore._inf.OOP.Class;

class Person06 {
  // [1] : 속성(Attribute)
  int age;			// 나이
  String name;		// 이름

   // [2] : 생성자(Constructor)
  Person06() {
  }

  Person06(int age, String name) {
    this.age = age;
    this.name = name;
  }

  // [3] : 메서드(Method)
  void printPerson() {
    System.out.println( "나이 : " + age + ", 이름 : " + name );
  }
}

public class Exam006 {

  public static void main(String[] args) {
    Person06 p0 = new Person06();
    p0.printPerson();// 나이 0, 이름 null 출력

    // [1] : 객체 생성
    Person06 p1 = new Person06( 20, "홍길동" );
    // System.out.println( p1 ); // 주소값
    // System.out.println( p1.age );  		// 20
    // System.out.println( p1.name );  	// 홍길동
    p1.printPerson();

    Person06 p2 = new Person06( 30, "이순신" );
    p2.printPerson();

    Person06 p3 = new Person06(40, "을지문덕");
    p3.printPerson();
  }

  // 각각의 객체는 해당 주소값을 가지고 있고, 그 주소를 타고 가면 해당 객체의 값이 있다.

}
