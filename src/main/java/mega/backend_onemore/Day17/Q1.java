package mega.backend_onemore.Day17;
/*
올림픽 퀴즈
한국 선수, 중국 선수, 미국 선수, 러시아 선수 출전
각 선수 : 레인번호, 국가명, 전진 거리, 돌발상황 체크

main문에서는
- 돌발상황 생성, 총 전진 거리 체크 및 출력(100m 먼저 완주한 선수 우승)
- 전진거리 최대 10m / 랜덤으로 숫자를 방아서 진행함.
- 우승 확정 시 어느 나라의 우승인지 print

 */

/*
<아이디어>
- 플레이어 클래스 하나면 된다.
- 플레이어 클래스에서 생성자 넣어서 총 4개의 객체만 생성해주면 된다.
- 플레이어 필드에는 <레인번호, 나라, 전진거리 있으면 됨>
- 플레이어 생성자에는 <레인번호, 나라> - 전진거리는 플레이어의 고정적인 구성요소가 아니지.

- 메서드 => 전진하고(행동) + 이동한 거리만큼 체크해주면 됨 (runAndCheck)
-- 여기 안에는 전진거리에 이동거리만큼을 누적 / 전진거리는 랜덤 수 1~10 사이에서 생성 / 출력문 만들기
-- 메서드 파라미터로는 : 레인번호, 랜덤수를 받아와서 작업을 수행하면 됨
--- 돌발수 레인번호와 나의 레인번호가 일치하지 않으면 => 전진(전진거리에 이동거리만큼을 누적)
--- 출력문은 (country+"선수 이동거리는 "+m+"M 입니다."); 이런 형태.

main문
- 랜덤클래스 생성
- 플레이어 객체 4개 생성
- while 반복문 만들기
-- 조건은 4개국의 이동거리가 100 미만
--- 실행조건(본문)은 랜덤수로 돌발상황 레인 책정
--- 각 4개국에 runAndCheck() 돌려서 전진시키면 되고, 파라미터로는 dolbal과 r을 집어넣으면 됨.

- 마지막으로 if문에 우승국 판별
- 조건은 각 4개국이 100m 이상이면서, 타국의 거리(ex. kor.m) 가 다른 국가들보다 전부 클 때
  우승국 문구 출력.
=> 끝

 */

import java.util.Random;

class Player {
  int laneNum; //레인번호
  String country; // 나라이름
  int move; // 전진거리

  //생성자(객체 생성 시 들어가야 하는 요소)
  Player(int laneNum, String country) {
    this.laneNum = laneNum;
    this.country = country;
  }


  void runAndCheck(int lane, Random r) { // 밖에서 레인 넘버와 이동을 시킬 생성자만 넣어주면 된다.
    if (lane != this.laneNum) { // 돌발 레인번호와 내 레인번호가
      move += r.nextInt(10) + 1; // 전진 가능 (전진거리에 이동거리만큼울 누적)
    }
    System.out.println(" 선수의 이동거리는 " + move + "m 입니다."); // 출력
  }

}

public class Q1 {

  public static void main(String[] args) {
    Random r = new Random();

    // 객체 4개 생성
    Player kor = new Player(1, "대한민국");
    Player china = new Player(2,"중국");
    Player america = new Player(3,"미국");
    Player russia = new Player(4, "러시아");

    // 돌발변수 책정 후 아니면 전진
    while (kor.move<100 && china.move<100 && america.move<100 && russia.move<100) {
      //돌발변수 랜덤값 생성
      int dolbal = r.nextInt(10) + 1;
      kor.runAndCheck(dolbal, r);
      america.runAndCheck(dolbal, r);
      china.runAndCheck(dolbal, r);
      russia.runAndCheck(dolbal, r);
    }

    // 우승국 확인
    if(kor.move >=100 && kor.move >china.move && kor.move > america.move && kor.move > russia.move) {
      System.out.println("우승국은 한국입니다.");
    }
    else if(china.move >=100 && china.move>kor.move&&china.move>america.move&&china.move>russia.move) {
      System.out.println("우승국은 중국입니다.");
    }
    else if(america.move >=100&&america.move>kor.move&&america.move>china.move&&america.move>russia.move) {
      System.out.println("우승국은 미국입니다.");
    }
    else {
      System.out.println("우승국은 러시아입니다.");
    }
  }

}
