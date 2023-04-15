package mega.backend_onemore.Day16.Prac16;

class Car{
  String color;
  String menu;
  int maxSpeed;

  Car(String color, String menu, int max){
    this.color = color;
    this.menu = menu;
    maxSpeed = max;
  }

  // 출력 메서드
  void dirve(String driver) {
    System.out.println(driver+"자동차 색깔 "+color+"이고 제조사가 "+menu+"인 차를 최고속도로 "+
        maxSpeed+"로 운전을 합니다.");
  }
}

class Bicycle{
  String menu;
  String func;

  Bicycle(String menu, String func){
    this.menu = menu;
    this.func = func;
  }

  // 츨력 메서드
  void ride(String dirver) {
    System.out.println(dirver+"자전거 제조사가 "+menu+"인 기능이 "+
        func+"로 자전거를 탑니다.");
  }
}

class Bike{
  String color;
  String menu;
  int maxSpeed;

  Bike(String color, String menu, int maxSpeed){
    this.color = color;
    this.menu = menu;
    this.maxSpeed =maxSpeed;
  }

  // 출력 메서드
  void dirve(String dirver) {
    System.out.println(dirver+"오토바이 색깔 "+color+"이고 제조사가 "+menu+"인 오토바이를 최고속도로 "+
        maxSpeed+"로 운전을 합니다.");
  }
}

// Car 객체가 Has 관계
// 객체 받아왔다는 전제
class Human1{
  String name = "첫번째 사람";
  Car c1;
  Car c2;

  // 아래에서 넣어줬기 때문에 Car의 메서드 사용 가능
  void car1Dirver() {
    c1.dirve(name);
  }
  void car2Driver() {
    c2.dirve(name);
  }
}

class Human2{
  String name = "두번째 사람";
  Bicycle b;
  Bike m;

  void bicycleRide() {
    b.ride(name);
  }
  void bikeDrive() {
    m.dirve(name);
  }
}

public class Q1 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Car c1 = new Car("은색", "Ford", 220);
    Car c2 = new Car("검정색", "BMW", 240);
    Car c3 = new Car("하얀색", "삼성", 200);
    Car c4 = new Car("형광색", "현대", 180);

    Bicycle b1 = new Bicycle("삼천리", "산악용");
    Bicycle b2 = new Bicycle("자이언트", "접이식용");

    Bike m = new Bike("빨간색", "대림", 180);

    Human1 h1 = new Human1();
    h1.c1 = c2; // 담보
    c2 = null; // 연결 끊어주기
    h1.c2 = c4;
    c4 = null;

    Human2 h2 = new Human2();
    h2.b = b1; // 이게 여기에 넣어주겠다는 담보로 해석하면 된다.
    b1 = null;
    h2.m = m;
    m = null;

    h1.car1Dirver();
    h1.car2Driver();

    h2.bicycleRide();
    h2.bikeDrive();

  }

}
