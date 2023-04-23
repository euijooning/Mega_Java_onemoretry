package mega.backend_onemore.Day27.Prac27.FightGame;
// 빌런 attack =>80
// 빌런 hp => 1200

public class VL extends Unit{

  public VL(String name, int attack, int hp) {
    this.setName(name);
    this.setAttack(attack);
    this.setHp(hp);
  }

  @Override
  public String getName() {
    return super.getName();
  }

  @Override
  public void setName(String name) {
    super.setName(name);
  }

  @Override
  public int getAttack() {
    return super.getAttack();
  }

  @Override
  public void setAttack(int attack) {
    super.setAttack(attack);
  }

  @Override
  public int getHp() {
    return super.getHp();
  }

  @Override
  public void setHp(int hp) {
    super.setHp(hp);
  }

}
