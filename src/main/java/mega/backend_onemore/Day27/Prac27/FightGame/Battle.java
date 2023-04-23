package mega.backend_onemore.Day27.Prac27.FightGame;

public class Battle {

  // 버프 랜덤으로 선택해주기
  int attackUp = 0;

  public void randomBurf(Unit unit) { //Unit으로 받음. 참조자료형 형변환

    Burf burf = new Burf(); // 객체 만들고

    // 랜덤 수 만든 다음에
    int radomBurf = (int) (Math.random() * 3) + 1; // 0~0.9 -> 1~3

    // 1, 2, 3 판단
    switch (radomBurf) {
      case 1:
        //1이 나올 경우 공격력 증가.
        attackUp = burf.attackUp(unit);
        break;
      case 2:
        //2 힐
        burf.heal(unit);
        attackUp = 0;
        break;
      case 3:
        //3. 디버프
        burf.downHp(unit);
        attackUp = 0;
        break;
// 이 때 unit이 넘어감.(기사면 기사, 악마면 악마가 넘어가는 것이겠죠)
    }
  }

  public void attack(Unit unit, Unit unit2) { // unit이 unit2 때리게

    unit2.setHp(unit2.getHp() - unit.getAttack()); //unit2의 체력에서 공격받은 능력치만큼 빼줘야지.
    System.out.println(unit.getName() + " 의 공격!!");
    System.out.println(unit2.getName() + "의 체력이 " + unit2.getHp() + " 남았다.");
    if (attackUp > 0) { // 공격력 받은 것에서 그만큼 빼줘야 원상복구 되므로 이 조치 취해줌.
      unit.setAttack(unit.getAttack() - attackUp);
    }
  }

}
