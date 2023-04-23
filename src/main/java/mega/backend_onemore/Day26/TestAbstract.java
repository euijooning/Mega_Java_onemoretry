package mega.backend_onemore.Day26;

interface Repairable{}
interface Heal{}

class Unit{
  int attack;
  int hitPoint;
  final int Max_HP;
  Unit(int hp, int attack){
    Max_HP = hp; // 타고 올라오니까 처음에 150들어가고
    this.attack = attack; // 10들어온다.
  }
}

class GroundUnit extends Unit{
  GroundUnit(int hp, int attack){
    super(hp, attack);
  }
}
class AirUnit extends Unit{
  AirUnit(int hp, int attack){
    super(hp,attack);
  }
}

class Tank extends GroundUnit implements Repairable{
  Tank(){ // 부모 거니까, hp, attack을 둘 다 받아줘야.
    super(150,10);
    hitPoint = Max_HP; // 처음에는 150 들어가있겠지.
  }
  // Object 메소드를 오버라이딩
  public String toString() {
    return "Tank"; // 디폴트값은 주소 나오지만, 여기서는 객체를 넣어줬기 때문에 앞으로는 객체가 출력됨.
  }
}

class SCV extends GroundUnit implements Repairable{
  SCV() {
    super(60, 5);
    hitPoint = Max_HP;
  }

  void repair(Repairable r) {
    if(r instanceof Unit) {
      Unit u = (Unit)r;
      if(u != null && u.Max_HP != u.hitPoint) {
        u.hitPoint += 1;
      }
    }
  }
}

class Marine extends GroundUnit implements Heal{
  Marine(){
    super(40, 6);
    hitPoint = Max_HP;
  }
}

public class TestAbstract {

  public static void main(String[] args) {

    Tank t = new Tank();
    System.out.println(t);
    Marine m = new Marine();
    SCV scv = new SCV();

    scv.repair(t); // 동작 할까요? 동작 됨.
    //scv.repair(m); // 동작 할까요?
    /*
    Marine은 상속 자체가 Heal이기 때문에 Repairable을 가질 수 가 없어요. 그래서 에러가 아예 납니다.
    Marine의 관계 속에 Repairable이 자체가 아예 없으므로 못 넣어요.

    반대로 tank는 되는 이유는, Tank는 Repairable을 가지고 있습니다. 자체가 Repairable이기 때문에
    들어가서 r을 확인할 수 있어요.
    Tank가 GroundUnit을 상속받고, 그 위에는 Unit도 있기 때문에 instanceof Unit을 물어보면 true가 나와요.
    그리고 r을 Unit으로 바꿀 수 있다는 거예요(Unit)r;
    그러면 조건식을 거쳐서 u.hitPint에 1을 더해줘서 Tank에 1만큼 증가하게 될 거예요.

    어? Unit은 r로 받은 게 아닌데 어떻게 형변환이 돼?
    => 실객체가 존재하면 무조건 바꿀 수 있게 되는 거예요.
    원래 Unit과 Repairable은 아무런 관계가 없어요. 그런데 Tank라는 매개체 때문에 관계가 생긴 거예요.
    Tank는 다 가지고 있으니까
    => 결국 인터페이스는 태그 처럼 쓴거죠. 통과할 수 있는 문으로만.
     */
  }

}

/*
실행흐름
Tank 객체 t를 생성합니다.
Tank 객체 t를 출력합니다. 이때 toString() 메소드가 호출되어 "Tank" 문자열이 출력됩니다.
Marine 객체 m을 생성합니다.
SCV 객체 scv를 생성합니다.
scv 객체의 repair() 메소드에 t 객체를 전달하여 수리합니다.
t 객체의 hitPoint가 1 증가합니다.

scv 객체의 repair() 메소드에 m 객체를 전달하려고 하지만,
Marine 클래스는 Heal 인터페이스를 구현하지만 Unit 클래스를 상속받지 않았으므로,
Unit 타입이 아닌 Heal 타입으로 캐스팅할 수 없어서 컴파일 에러가 발생합니다.
 */