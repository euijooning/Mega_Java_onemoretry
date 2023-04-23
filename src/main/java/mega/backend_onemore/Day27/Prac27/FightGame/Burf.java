package mega.backend_onemore.Day27.Prac27.FightGame;

import java.util.Random;

/*
버프
- 턴이 시작함과 동시에 버프의 메서드 중 하나가 랜덤으로 작동하게 된다.
- 버프 목록 : 회복 / 공격력 증가 가 있다.
// 확률적으로 디버프에 걸리게 되며, 이 경우 피가 깎인다.
 */

public class Burf {
  Unit unit; // 이거 아무 쓸모가 없음.

  public void heal(Unit unit) {
    // 매개 값의 unit 피가 증가한다.
    // 범위 : 100~200
    Random r = new Random();
    int healUp = r.nextInt(101) + 100;
    //int healUp = (int) (Math.random()*200) + 100; // 처음 보는 형태
    unit.setHp(unit.getHp() + healUp); // getHp를 받아서 heal된것만큼 더한 것을 다시 hp로 세팅
    System.out.println("버프 : " + unit.getName() + " 의 체력이 " + healUp + " 만큼 증가했습니다.");
  }

  public int attackUp(Unit unit) {
    // 공격력은 50~ 100까지
    Random r = new Random();
    int attackUp = r.nextInt(51) + 100;
    unit.setAttack(unit.getAttack() + attackUp); // getAttack를 받아서 공격력 up된것만큼 더한 것을 다시 hp로 세팅
    return attackUp;
  }

  public void downHp(Unit unit) {
    int downHp = (int)(Math.random()*200) + 100;
    unit.setHp(unit.getHp() - downHp);  // getHp를 받아서 공격력 깎인 것만큼을 뺀 것을 다시 hp로 세팅
    System.out.println("디버프 : " + unit.getName()+ " 의 체력이 디버프로 인해 " + downHp + "만큼 감소하였다.");
  }

}