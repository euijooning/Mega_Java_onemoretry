package mega.backend_onemore.Day29.Prac29.Q1_2;

import java.util.Random;


abstract class Vehicle{
  int distance;
  int gauge;

  abstract void Move(int stop, Random r, int count);
}

interface Booster{
  void boost();
}

// 자동차만 잘 만들면 나머지는 조금만 수정해주면 된다.
class Car extends Vehicle implements Booster{
  void gaugePrint(int count) {
    gauge = count % 4; // 몇 게이지가 차는지 확인하려고
    System.out.print("자동차의 게이지 : "+gauge+", "); // 쉼표는 바로 뒤에 주행거리 이어서 나오게 하려고.
  }
  void distancePrint() {
    System.out.println("자동차의 주행거리 : "+distance);
  }

  void Move(int stop, Random r, int count) {
    int move = r.nextInt(21); //0~20

    if(stop != 1) { // 굳이 1이 필요없어서 주석처리
      distance += move;
    }

//		if(stop == 1) { // 못움직임.
//			distance += 0;
//		}
//		else {
//			distance += move;
//		}
    //게이지 출력
    gaugePrint(count);
    //전체 이동거리 출력
    distancePrint();
  }

  //부스터 메서드
  public void boost() {
    distance += 2;
  }
}

class Bicyle extends Vehicle implements Booster{
  void gaugePrint(int count) {
    gauge = count % 2; // 2턴마다
    System.out.print("자전거의 게이지 : "+gauge+", ");
  }
  void distancePrint() {
    System.out.println("자전거의 주행거리 : "+distance);
  }

  void Move(int stop, Random r, int count) {
    int move = r.nextInt(11); //0~10

    if(stop !=2) {
      distance += move;
    }
//		if(stop == 2) {
//			distance += 0;
//		}
//		else {
//			distance += move;
//		}

    gaugePrint(count);
    distancePrint();
  }
  public void boost() {
    distance += 5;
  }
}
class Motocycle  extends Vehicle implements Booster{
  void gaugePrint(int count) {
    gauge = count % 3; // 3턴마다
    System.out.print("오토바이의 게이지 : "+gauge+", ");
  }
  void distancePrint() {
    System.out.println("오토바이의 주행거리 : "+distance);
  }

  void Move(int stop, Random r, int count) {
    int move = r.nextInt(16); //0~15

    if(stop != 3) {
      distance += move;
    }

//		if(stop == 3) {
//			distance += 0;
//		}
//		else {
//			distance += move;
//		}
    gaugePrint(count);
    distancePrint();
  }

  public void boost() {
    distance += 3;
  }
}


public class Q1_T2 {

  //이 함수에서 부스터를 작동시킨다. 돌발상황과 부모 객체가 필요함.
  static void boosterRun(int stop, Booster b) { // Vehicle v 대신에 Booster b 들어와도 된다 왜????

    if (b instanceof Car) {
      if (stop != 1 && ((Vehicle) b).gauge == 3) {
        b.boost();
      }
    }
    if (b instanceof Bicyle) {
      if (stop != 2 && ((Vehicle) b).gauge == 1) {
        b.boost();
      }
    }
    if (b instanceof Motocycle) {
      if (stop != 3 && ((Vehicle) b).gauge == 2) {
        b.boost();
      }
    }
//		if(v instanceof Car) {
//			if(stop != 1 && v.gauge == 3) {
//				((Car) v).boost();
//			}
//		}
//		if(v instanceof Bicyle) {
//			if(stop !=2 && v.gauge == 1) {
//				((Bicyle) v).boost();
//			}
//		}
//		if(v instanceof Motocycle) {
//			if(stop !=3 && v.gauge == 2) {
//				((Motocycle) v).boost();
//			}
//		}
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Random r = new Random();
    Car c = new Car();
    Bicyle b = new Bicyle();
    Motocycle m = new Motocycle();

    int count = 0;
    int stop;

    while (true) {
      stop = r.nextInt(3) + 1;

      //부스터
      boosterRun(stop, c);
      boosterRun(stop, b);
      boosterRun(stop, m);
      //이동
      c.Move(stop, r, count);
      b.Move(stop, r, count);
      m.Move(stop, r, count);
      //게이지 => 어딘가에 들어가 있다. 어디?

//			c.gauge++;
//			b.gauge++;
//			m.gauge++;

      //탈출 조건
      if (c.distance >= 500 || b.distance >= 500 || m.distance >= 500) {
        break;
      }

      //턴증가
      count++;
    }

    if (c.distance > b.distance && c.distance > m.distance) {
      System.out.println("자동차 우승입니다.");
    } else if (b.distance > c.distance && b.distance > m.distance) {
      System.out.println("자전거 우승입니다.");
    } else {
      System.out.println("오토바이 우승입니다.");
    }
  }
}