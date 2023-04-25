package mega.backend_onemore.Day29.Prac29.Q1_1;
//추상, 일반 => 탈 것: 주행거리, 게이지, 이동함수
// 자동차 탈 것을 상속, 주행거리를 출력함수 구현, 게이지 출력함수 구현, 이동함수 오버라이딩
// 자전거, 오토바이도 동일
//
// 인터페이스 1. 부스터(아무것도 없습니다.)
// 자동차, 자전거, 오토바이가 상속을 받습니다.
//
// main문
// 부스터 실행하는 함수를 구현
// 1턴씩 자동차, 오토바이, 자전거가 진행이 됩니다.
// 랜덤으로 1~3을 받아서 1이면 자동차 2면 자전거 3이면 오토바이가 움직이지 못한다
//
// 자동차 0~20 자전거 0~10 오토바이 0~15 까지 턴마다 움직일 수 있습니다.
//
// 2턴마다 자전거는 부스터 발동, 주행거리 +5
// 3턴 오토바이 부스터 발동 주행거리 +3
// 4턴 자동차 부스터 발동 주행거리+2
//
// 먼저 도착하는 탈 것이 무엇인지 출력.
// 모든 탈 것은 주행거리와 게이지는 턴마다 출력이 되어야 합니다.
// 게이지는 턴마다 하나씩 증가합니다. 자전거는 3턴 진행 시 게이지가 0으로 초기화 됩니다.
//
// 500m를 먼저 들어오는 탈것이 우승합니다.

//cf. 부스터 켰는데 3번에 걸렸다? 안타깝게 못 써먹는 거죠.

import java.util.Random;

abstract class Vehicle {
  int distance;
  int gauge;

  abstract void gogo(int stop, Random r, int count); //stop은 돌발, r은 난수, 얼마나 움직였는지 count
}

interface Booster {
  void boost();
}

// 자동차만 잘 만들면 나머지는 그대로 가져다 쓰면 된다.
class Car extends Vehicle implements Booster{
  void gaugePrint(int count) {
    gauge = count % 4;
    System.out.print("자동차의 게이지 : "+gauge+", "); //, 뒤에 주행거리 바로 붙게 하려고.
  }

  void distancePrint() {
    System.out.println("자동차의 주행거리 : "+distance);
  }

  void gogo(int stop, Random r, int count) {
    int move = r.nextInt(21); //자동차 : 0 ~20
    //cf. main에서는 부스터를 stop 걸려도 못 켜게 해놓았다.

    if(stop != 1) {
      distance += move; //원래 소스처럼 0일 때를 굳이 써줄 필요 없이
    }                   // 해당하지 않으면 바로 가게 만들어버림(효율화)

    //게이지 출력
    gaugePrint(count);
    //전체 이동거리 출력
    distancePrint();

    //사실 gaugePrint나 distancePrint는
    // 부모거에 써놓고 오버라이딩 해와서 사용해도 무방.

  }
  public void boost() {
    distance += 2;
  }
}

class Bicyle extends Vehicle implements Booster{
  void gaugePrint(int count) {
    gauge = count % 2;
    System.out.print("자전거의 게이지 : "+gauge+", ");
  }

  void distancePrint() {
    System.out.println("자전거의 주행거리 : "+distance);
  }

  void gogo(int stop, Random r, int count) {
    int move = r.nextInt(11); // 0 ~10

    if(stop != 2) {
      distance += move;
    }
    //게이지 출력
    gaugePrint(count);
    //전체 이동거리 출력
    distancePrint();

  }
  public void boost() {
    distance += 5;
  }
}

class Motocycle extends Vehicle implements Booster{
  void gaugePrint(int count) {
    gauge = count % 3;
    System.out.print("오토바이의 게이지 : "+gauge+", ");
  }

  void distancePrint() {
    System.out.println("오토바이의 주행거리 : "+distance);
  }

  void gogo(int stop, Random r, int count) {
    int move = r.nextInt(16); // 0 ~15

    if(stop != 3) {
      distance += move;
    }
    //게이지 출력
    gaugePrint(count);
    //전체 이동거리 출력
    distancePrint();

  }
  public void boost() {
    distance += 3;
  }
}

public class Q1_T1 {

  // stop이 걸리면 안 된까, 이를 제어할 스태틱 함수 하나 생성.
  static void boosterRun(int stop, Booster b) { //부모 Vehicle 또는 인터페이스 부스터 사용 가능.
    if(b instanceof Car) {
      if(stop != 1 && ((Vehicle)b).gauge == 3) { //3에 걸렸을 때 차는 부스터 켜짐.
        b.boost(); //오버라이딩 했으니 알아서 Car의 것을 작동시키겠죠.
      }
    }
    if(b instanceof Bicyle) {
      if(stop != 2 && ((Vehicle)b).gauge == 1) {
        b.boost();
      }
    }
    if(b instanceof Motocycle) {
      if(stop != 3 && ((Vehicle)b).gauge == 2) {
        b.boost();
      }
    }
  }


  public static void main(String[] args) throws InterruptedException {

    Random r = new Random();
    Car car = new Car();
    Bicyle bicyle = new Bicyle();
    Motocycle moto = new Motocycle();

    int count = 0; //횟수, 턴 개념. 1씩 증가될거야.
    int stop; //돌발상황에서ㅏ 쓸 것

    while(true) {
      stop = r.nextInt(3)+1; //돌발상황 만들기.

      //부스터 켜고
      boosterRun(stop, car);
      boosterRun(stop, bicyle);
      boosterRun(stop, moto);
      //이동
      // 출력이 되어야 하니까 부스터 먼저 켜고 이동하는 게 좋다
      car.gogo(stop, r, count);
      bicyle.gogo(stop, r, count);
      moto.gogo(stop, r, count);
      Thread.sleep(500);

      /*
      게이지 주석처리한 이유는 각 클래스들에
      gaugePrint 메서드에 게이지가 포함되어 있어서 거기서 알아서 변동이 될 것이다.
       */

      if(car.distance>=500 || bicyle.distance >= 500 || moto.distance >= 500) {
        break;
      }

      count++;
    }


    if(car.distance > bicyle.distance && car.distance > moto.distance) {
      System.out.println("자동차 우승입니다.");
    }
    else if(bicyle.distance > car.distance && bicyle.distance > moto.distance) {
      System.out.println("자전거 우승입니다.");
    }
    else {
      System.out.println("오토바이 우승입니다.");
    }


  }

}



