package mega.backend_onemore.Day24.Prac24;

import java.util.Random;
import java.util.Scanner;

class Water02{
  private int amount;

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

}

class Human02{
  private Water02[] w;

  public Water02[] getW() {
    return w;
  }

  public void setW(Water02[] w) {
    this.w = w;
  }

  int totalWaterAmount() {
    int result = 0;
    for(int i = 0;i<w.length;i++) {
      result += w[i].getAmount();
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

    Human02[] humans = new Human02[3];
    Water02[][] water = new Water02[3][10]; // 2차원 배열이 더 편함.
    // 하나씩 쥐어주면 더 편함.

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
      humans[i].setW(water[i]); // 사람에게 물을 부여
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
      int num =sc.nextInt();
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