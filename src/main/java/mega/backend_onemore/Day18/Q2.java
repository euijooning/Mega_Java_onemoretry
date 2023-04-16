package mega.backend_onemore.Day18;
import java.util.Random;

// 주사위 던지기 게임
// 빨간색 주사위, 파란색 주사위가 있음.
// 각각은 색깔을 요소로 가지고 있음.
// 1부터 6까지 랜덤 수 생성 메서드

// 객체 두 개 생성(빨간주사위, 파란주사위)
// 결과를 저장할 정수 변수 두 개 생성
// red객체에서 diceRun 메소드를 호출 한 결과 값을
// rResult 정수 변수의 값과 더해서 다시 rResult에 대입
// blue 객체도 이러한 과정 반복
// 둘 중에 하나가 50이 넘어가면 경기 종료

// 비교하여 결과 출력.

class Dice{
  String color;

  Dice(String color){
    this.color = color;
  }

  int diceRun() {
    Random r = new Random();
    return r.nextInt(6)+1; // 1부터 6까지
  }
}

public class Q2 {

  public static void main(String[] args) {
    // 클래스인 Dice 변수를 red라는 이름으로 변수를 생성 후
    // Dice 객체를 생성할 때 매개변수로 문자열 "레드" 넣어줍니다.
    // 그 객체를 red라는 변수에 대입
    Dice red = new Dice("레드");
    Dice blue = new Dice("블루");

    int rResult = 0; // 정수변수 생성
    int bResult = 0; // 정수 변수 생성

    while(true) { // 무한 반복합니다.
      // red객체에서 diceRun 메소드를 호출 한 결과 값을 rResult 정수 변수의 값과 더해서 다시 rResult에 대입
      rResult += red.diceRun();
      bResult += blue.diceRun();

      System.out.println("red : "+rResult);
      System.out.println("blue : "+bResult);

      if(rResult >= 50 || bResult >=50) {
        break;
      }
    }

    // 결과 출력
    if(rResult > bResult) {
      System.out.println(red.color+"주사위가 이겼습니다.");
    }
    else if(rResult == bResult) {
      System.out.println("비겼습니다.");
    }
    else {
      System.out.println(blue.color+"주사위가 이겼습니다.");
    }
  }
}

