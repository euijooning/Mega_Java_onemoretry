package mega.backend_onemore.Day24.Prac24;
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

import java.util.Random;
import java.util.Scanner;

// 물의 양을 나타내는 Water 클래스
class Water{
  private int amount; // 물의 양(수량은 1~8 될 예정)

  // 물의 양을 반환하는 getter 메소드
  public int getAmount() {
    return amount;
  }

  // 물의 양을 설정하는 setter 메소드
  public void setAmount(int amount) {
    this.amount = amount;
  }

}

class Human{
  private Water[] w; // 물을 저장하는 Water 배열을 나타내는 private 변수 w

  // 물을 저장하는 Water 배열을 반환하는 getter 메소드
  public Water[] getW() {
    return w;
  }

  // 사람이 가지고 있는 총 물의 양을 반환하는 메소드
  public void setW(Water[] w) {
    this.w = w;
  }

  int totalWaterAmount() { // 물 수량이 얼마인지 알려주는 메서드
    int result = 0;
    for(int i = 0;i<w.length;i++) {
      result += w[i].getAmount(); // result에 물 양을 계속 누적
    }
    return result; // 누적된 결과값을 반환
  }
}
/*int result = 0;
Human 객체가 가지고 있는 총 물의 양을 저장하는 데 사용됩니다.
반복문 내부에서는
w 배열에 저장된 각 Water 객체의 물의 양을 getAmount() 메서드를 사용하여 더해져
result 변수가 증가됩니다.
마지막으로, result 변수가 호출자에게 반환됩니다.
 */


public class Q2_T1 {

  public static void main(String[] args) {

    Random r = new Random();
    Scanner sc = new Scanner(System.in);

    Human[] h = new Human[3];
    Water[][] w = new Water[3][10];

    // 물의 양을 랜덤으로 설정합니다.
    for (int i = 0; i < w.length; i++) {
      for (int j = 0; j < w[i].length; j++) {
        w[i][j] = new Water();
        w[i][j].setAmount(r.nextInt(8) + 1);
      }
    }

    // 3명의 사람에게 물을 할당하고 총 물의 양을 출력합니다.
    int max = 0;
    // 가장 많은 물을 가지고 있는 사람의 물의 양을 저장하는 변수

    for (int i = 0; i < h.length; i++) {
      h[i] = new Human();
      h[i].setW(w[i]);
      w[i] = null;
      System.out.println((i + 1) + "번째 사람 : " + h[i].totalWaterAmount());
      if (max < h[i].totalWaterAmount()) {
        max = h[i].totalWaterAmount();
      }
    }

    while (true) {
      System.out.println("물을 제일 많이 가지고 있는 사람은 ? ");
      int num = sc.nextInt();
      if (num == 1) { // 1번사람이 물을 가장 많이 가지고 있는 경우
        if (h[0].totalWaterAmount() > h[1].totalWaterAmount() &&
            h[0].totalWaterAmount() > h[2].totalWaterAmount()) { // 물 양 비교하기
          System.out.println("1번사람이 물이 제일 많습니다.");
          break;
        } else {
          System.out.println("틀렸습니다.");
        }
      } else if (num == 2) { // 2번사람이 물을 가장 많이 가지고 있는 경우
        if (h[1].totalWaterAmount() > h[0].totalWaterAmount() &&
            h[1].totalWaterAmount() > h[2].totalWaterAmount()) {
          System.out.println("2번사람이 물이 제일 많습니다.");
          break;
        } else {
          System.out.println("틀렸습니다.");
        }
      } else if (num == 3) { // 3번사람이 물을 가장 많이 가지고 있는 경우
        if (h[2].totalWaterAmount() > h[1].totalWaterAmount() &&
            h[2].totalWaterAmount() > h[0].totalWaterAmount()) {
          System.out.println("3번사람이 물이 제일 많습니다.");
          break;
        } else {
          System.out.println("틀렸습니다.");
        }
      } else {
        System.out.println("잘못된 입력입니다.");
      }
    }
  }
}
