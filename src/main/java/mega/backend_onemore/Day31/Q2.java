package mega.backend_onemore.Day31;
/*
<보물찾기 문제>
- 사람 3명, 총 100개의 선물 그 중에서 하나만 진짜 선물
- 사람 3명이 선물을 요청하면 선물을 주는데 꽝 또는 당첨
- 이 중에서 선물 당첨자가 나오면 프로그램을 종료하고 당첨자가 누군지 출력해주면 됨
- 100개 선물 중에 랜덤 활용해서 하나만 선물이 있고 나머지는 꽝이 나오게 만들어서
  게임을 시작하면 됩니다.
 */

import java.util.Random;

class Present {

}

class TreasureBox {
  Present[] pre = new Present[100];

  TreasureBox() {
    // 이렇게 만들면 처음에 만들 때 보물 위치 딱 나온다.
    Random r = new Random(); //랜덤수 생성
    int num = r.nextInt(100);
    pre[num] = new Present();
    System.out.println("보물의 위치는 : " + num);
  }

  //몇번째에 선물을 깔지 선택하는 사람이 인덱스를 주는 게 더 낫다.
  //사람쪽에서 선택된 인덱스의 박스를 여는 게 맞다는 이야기.
  synchronized Present sendPresent(int index) {
    if (index <= 99) { // 안전장치 (예제에서 check 같은 것)
      return pre[index];
    }
    else {
      return null;
    }
  }
}

class Joiner extends Thread {

  static int index = 0;
  TreasureBox box; // 이게 있어야 보물에 접근이 가능하니까.
  Present pre; // 이건 진짜 선물을 받아오려고

  Joiner(TreasureBox box, String name){
    this.box = box;
    setName(name);
  }

  public void run() { // 선물 받기
    while (true) {
      pre = box.sendPresent(index++);
      // 왜 index에 ++이 들어가지? 세 명이 공통적으로 들어가는 요소
      System.out.println((index-1) + getName() + "보물 확인");

      if (pre != null) {
        System.out.println("보물이 있습니다.");
      }
      else {
        System.out.println("보물이 없습니다.");
      }
      // 탈출조건
      if (index>=100 || pre!=null) { // 한 명은 선물 받을 거고, 나머지 두 명은 100까지 간다.
        break;
      }
    }
  }

}


public class Q2 {

  public static void main(String[] args) throws InterruptedException {
    TreasureBox box = new TreasureBox(); // 보물상자 객체 생성
    Joiner j1 = new Joiner(box, "르세라핌");
    Joiner j2 = new Joiner(box, "아이브");
    Joiner j3 = new Joiner(box, "뉴진스");

    j1.start();
    j2.start();
    j3.start();

    j1.join();
    j2.join();
    j3.join();

    // 최종 결과 출력
    if(j1.pre != null) {
      System.out.println(j1.getName()+"최종 보물을 찾았습니다.");
    }
    if(j2.pre != null) {
      System.out.println(j2.getName()+"최종 보물을 찾았습니다.");
    }
    if(j3.pre != null) {
      System.out.println(j3.getName()+"최종 보물을 찾았습니다.");
    }
  }
}
