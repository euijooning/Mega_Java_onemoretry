package mega.backend_onemore._inf.OOP.Inheritance;
// 문제
// getter, setter가 포함된 클래스의 상속을 코드로 구현해보시오.
// 이 문제는 클래스의 상속을 구현시 getter, setter의 개념과 용도를 알고 있는지를 묻는 문제이다.
// 부모 클래스 --> Person, 자식 클래스 --> Villain, Hero

class Person05 {
  // Field
  private String name;
  private int age;
  private int height;
  private int weight;

  // Constructor

  // Method
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }
}



class Villain05 extends Person05 {

}


class Hero05 extends Person05 {

}


public class IHSample05 {

  public static void main(String[] args) {

    // [1] : 객체 생성
    Person05 p1 = new Person05();
    p1.setName( "홍길동" );
    System.out.println( p1.getName() );
  }
}
