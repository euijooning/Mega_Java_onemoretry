package mega.backend_onemore.Day15.Prac15;

class Dog {
  String color;
  String weight;

  void bark() {
    System.out.println(color + "색의 " + weight + "kg" + " 고양이는 짖는다." );
  }
}

class Cat {
  String color;
  String weight;

  void yaong() {
    System.out.println(color + "색의 " + weight + "kg" + " 개는 야옹한다." );
  }

}

class Bird {
  String color;
  String weight;

  void fly() {
    System.out.println(color + "색의 " + weight + "kg" + " 새는 날아다닌다.");
  }
}


public class Q4 {

  public static void main(String[] args) {

    Dog dog1 = new Dog();
    Dog dog2 = new Dog();

    dog1.weight = "80";
    dog2.weight = "70";

    dog1.color = "노란";
    dog2.color = "하얀";


    Cat cat1 = new Cat();
    cat1.color ="다홍";
    cat1.weight = "70";

    Cat cat2 = new Cat();
    cat2.color ="청록";
    cat2.weight = "70";

    Bird bird = new Bird();
    bird.color = "하늘";
    bird.weight =" 90";


    dog1.bark();
    dog2.bark();

    cat1.yaong();
    cat2.yaong();

    bird.fly();


  }
}
