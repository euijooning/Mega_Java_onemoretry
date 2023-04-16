package mega.backend_onemore._inf.OOP.Inheritance;

// 문제
// getter, setter가 포함된 클래스의 상속을 코드로 구현해보시오.
// 이 문제는 클래스의 상속을 구현시 getter, setter의 개념과 용도를 알고 있는지를 묻는 문제이다.
// 부모 클래스 --> Person, 자식 클래스 --> Villain, Hero

class Person07 {
  // Field
  private String name;
  private int age;
  private int height;
  private int weight;

  // Constructor
  Person07() {

  }

  Person07(String name, int age, int height, int weight) {
    this.name = name;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }


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

  public void move() {
    System.out.println( "이동중.." );
  }
}

class Villain07 extends Person07 {
  // Field
  private String unique_key;
  private int weapon;			// 1~9 숫자로 무기 분류 --> 1: 창, 2: 방패, 3: 총..
  private double power;


  // Constructor
  Villain07() {

  }

  Villain07(String name, int age, int height, int weight, String unique_key, int weapon, double power) {
    super(name, age, height, weight);

    this.unique_key = unique_key;
    this.weapon = weapon;
    this.power = power;
  }

  // Method
  public String getUnique_key() {
    return unique_key;
  }


  public void setUnique_key(String unique_key) {
    this.unique_key = unique_key;
  }

  public int getWeapon() {
    return weapon;
  }


  public void setWeapon(int weapon) {
    this.weapon = weapon;
  }

  public double getPower() {
    return power;
  }

  public void setPower(double power) {
    this.power = power;
  }

  // printPerson()
  public void printPerson() {
    System.out.println( "---------------------------------" );
    System.out.println( "악당 이름 : " + getName() );
    System.out.println( "악당 나이 : " + getAge() );
    System.out.println( "악당의 키 : " + getHeight() );
    System.out.println( "악당 체중 : " + getWeight() );
    System.out.println( "악당 넘버 : " + getUnique_key() );
    System.out.println( "악당 무기 : " + getWeaponName( getWeapon() ) );  // 숫자(1~9) --> 1: 창, 2: 방패, 3: 총..
    System.out.println( "악당 파워 : " + getPower() );
    System.out.println( "---------------------------------" );
  }

  // getWeaponName()
  public String getWeaponName(int a) { //1, 2등으로 받으므로.
    String weapon;
    switch(a) {
      case 1:
        weapon = "창";
        break;
      case 2:
        weapon = "방패";
        break;
      case 3:
        weapon = "총";
        break;
      default:
        weapon = "---";
        break;
    }
    return weapon;
  }
}


class Hero07 extends Person07 {

}


public class IHSample07 {

  public static void main(String[] args) {

    // [1] : 객체 생성
    Villain07 v1 = new Villain07( "좀비", 20, 180, 80, "15001231", 2, 99.5 );
    v1.printPerson();
    System.out.print( v1.getName() + " " );
    v1.move();  // 부모 클래스의 move() 메서드를 호출.

    // [2] : 객체 생성
    Villain07 v2 = new Villain07( "도깨비", 30, 175, 70, "11001121", 1, 77.5 );
    v2.printPerson();
    System.out.print( v2.getName() + " " );
    v2.move();

    // [3] : 객체 생성
    Villain07 v3 = new Villain07( "몽달귀신", 40, 150, 40, "10001010", 3, 27.5 );
    v3.printPerson();
    System.out.print( v3.getName() + " " );
    v3.move();

  }

}
