package mega.backend_onemore.Day27.Prac27.FightGame;

public class Main {

  public static void main(String[] args) throws InterruptedException {

    //기본적인 셋팅.
    Unit knight = new Knight("기사",50,1600);
    Unit vl = new VL("악당",80,1200);
    Battle battle = new Battle();
    //경기 시작.

    boolean run = true;
    int turn = 1;
    String winner;
    int count = 0;

    while(run) {

      //경기가 시작됨과 동시에 기사가 먼저 공격을 하게 된다.
      //공격은 순서대로 돌아가게 되며 if문을 사용 기사가 공격할 경우
      //카운트는 0이 되며 0 이 될경우 악당의 턴이다.
      if( knight.getHp() > 0 && vl.getHp() >0) {
        System.out.println(count +"번 째 경기가 시작됩니다");
        if( turn == 1) { // 그런데 사실 이것보다, %2 활용하는게 코드가 더 깔끔한 건 사실이다.
          System.out.println("=====================================");
          ++count;
          //기사의 공격
          //1. 버프 발동.
          // 버프는 랜덤값을 부여받아 스위치문에서 하나가 실행된다.
          battle.randomBurf(knight); // 기사 차례라 knight를 넘겨줌

          //버프를 받은 후 공격을 한다.
          //기사가 공격할 경우 버프된 공격력으로 악당을 공격한다.
          // 악당의 체력은 악당체력 - 기사의 공격력이다.
          battle.attack(knight,vl);
          System.out.println("=====================================");

          //공격 완료 후 turn값은 0이 된다.
          turn = 0;
          Thread.sleep(1000);
        }else {
          //악당의 공격
          System.out.println("=====================================");
          ++count;
          battle.randomBurf(vl);
          battle.attack(vl,knight);
          turn = 1;
          System.out.println("=====================================");
          Thread.sleep(1000); // 1초 지연시킴.
        }

      }else{
        //악당과 기사 둘중 하나의 체력이 0이 아닐경우
        if( knight.getHp() <= 0) {
          winner = vl.getName();
          System.out.println(" 승자 : " +winner);
          run = false;
        }else {
          winner = knight.getName();
          System.out.println("승자 : " +winner);
          run = false;
        }
      }
    }

  }
}
