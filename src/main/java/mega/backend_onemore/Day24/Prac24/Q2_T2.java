package mega.backend_onemore.Day24.Prac24;

import java.util.Random;
import java.util.Scanner;
/*
<물담기 문제> 이건 클래스 배열 문제
물 : 수량(속성) -private // get, set 활용
사람 : 물의 객체를 담을 수 있는 배열 // get set 활용

<main>
물 배열 객체 30개 + 객체마다 수량을 랜덤으로 1~8 까지 채워줌
물 객체 10개씩 사람에게 부여한다.

사람 3명 1, 2, 3 중에서 물을 가장 많이 가지고 있는 사람은?
이외는 잘못된 입력.
제일 많이 마신 사람을 고르지 못하면 다시 선택하세요.

마지막에 비교하면서 출력
 */

/*
접근 방향
1. <Water> 클래스
- 물의 양 담을 int 변수, getter, setter

2. <Human> 클래스
- 믈 배열, getter, setter
- totalWaterAmount() 메서드
-- 결과 저장할 변수 하나 초기화해둠
-- 물 배열 길이만큼 돌면서
   결과변수에 water[i].getAmount()를 계속 누적
-- 결과변수를 리턴

3. <main>
랜덤으로 물 채우고
사람에게 물 주고
게임 펼치면 된다.

- 랜덤클래스, 스캐너

- 사람 3명 배열, 물 저장할 2차원!!! 배열
- 물 객체 채워주기
 (for문 돌면서, 객체 만들어주고, 물의 양을 랜덤 배분)
 ( 랜덤 배분: water[i][j].setAmount(r.nextInt(8)+1); )

- 최댓값 저장할 max 변수 하나 초기화해둠
- 사람 배열에 객체 채우기
-- 사람에게 물 배분(humans[i].setWater(water[i]))하고 null처리
-- 상태출력 (i+1)+"번째 사람 : "+ humans[i].totalWaterAmount()
- 최댓값 찾기(공동 1등 방지)

- 게임시작
- 비교하고 결과출력
- cf. 잘못된 입력
 */
class Water02{
  private int amount; // 양 담을 변수

  public int getAmount() { // getter
    return amount;
  }

  public void setAmount(int amount) { // setter
    this.amount = amount;
  }

}

class Human02{
  private Water02[] water;

  public Water02[] getWater() {
    return water;
  }

  public void setWater(Water02[] w) {
    this.water = w;
  }

  int totalWaterAmount() {
    int result = 0; // 결과 변수
    for(int i = 0;i<water.length;i++) {
      result += water[i].getAmount();
    }
    return result;
  }
}


public class Q2_T2 {

  public static void main(String[] args) {
    /*
    랜덤으로 물 채우고
    사람에게 물 주고
    게임 펼치면 된다.
     */

    Random r = new Random();
    Scanner sc = new Scanner(System.in);

    Human02[] humans = new Human02[3]; // 사람 3명 배열
    Water02[][] water = new Water02[3][10]; // 2차원 배열이 더 편함.
    // 하나씩 쥐어주면 더 편함.
    // 2차원 배열을 만들지 않았다면, 10개씩 세팅하는 과정이 한번 더 필요하다.

    // 물의 객체 채워주기
    for(int i = 0;i<water.length;i++) {
      for(int j =0;j<water[i].length;j++) {
        water[i][j] = new Water02(); // 객체 생성하고
        water[i][j].setAmount(r.nextInt(8)+1); // 물 양 배분
      }
    }

    int max = 0; // 1등을 가리기 위해서 추가.

    // 사람 안에 객체 만들기
    for(int i =0;i<humans.length;i++) {
      humans[i] = new Human02();
      humans[i].setWater(water[i]); // 사람에게 물을 부여
      water[i] = null; // 준 물 null 처리하기
      System.out.println((i+1)+"번째 사람 : "+ humans[i].totalWaterAmount());
      // 최댓값 찾기(공동 1등 방지)
      if(max < humans[i].totalWaterAmount()) {
        max = humans[i].totalWaterAmount();
      }
    }

    // 게임시작
    boolean check = true;
    // 하나라도 해당되면 나가게 한다.

    while(check) {
      System.out.println("물을 제일 많이 가지고 있는 사람은 ? ");
      int num =sc.nextInt(); //사용자가 입력

      if(num == 1 || num == 2 || num == 3) {
        if(num == 1 && humans[0].totalWaterAmount() == max) {
          System.out.println("1번사람이 물이 제일 많습니다.");
          check = false;
        }
        if(num == 2 && humans[1].totalWaterAmount() == max) {
          System.out.println("2번사람이 물이 제일 많습니다.");
          check = false;
        }
        if(num == 3 && humans[2].totalWaterAmount() == max) {
          System.out.println("3번사람이 물이 제일 많습니다.");
          check = false;
        }

        /*
        따라서 각각의 if문에서 check 값을 false로 변경하는 이유는
        해당하는 사람이 물을 가장 많이 가지고 있고,
        사용자가 그 사람의 번호를 입력했으므로 게임에서 승리한 것이 되기 때문입니다.
         */
        if(check) {
          System.out.println("틀렸습니다.");
        }
      }
      else {
        System.out.println("잘못된 입력입니다.");
      }
    }

  }
}

