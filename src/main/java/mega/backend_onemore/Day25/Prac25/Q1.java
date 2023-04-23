package mega.backend_onemore.Day25.Prac25; // 물고기와 원리 동일

import java.util.Random;

class Box {

}

class Monkey {
  private String color;
  private Box box;

  Monkey(String color) {
    this.color = color;
  }

  public void setBox(Box box) {
    this.box = box;
  }

  public Box getBox() {
    return box;
  }

  void print() {
    if (box != null) {
      System.out.println(color + " 원숭이가 상자를 가지고 있습니다.");
    }
    else {
      System.out.println(color + " 원숭이가 상자를 가지고 있지 않습니다.");
    }
  }


}

class Move{
  Monkey[] monkeys = new Monkey[5];

  Move() {
    String[] color = {"빨간","노란","파란","초록","검정"};
    for(int i = 0;i<monkeys.length;i++) {
      monkeys[i] = new Monkey(color[i]);
    }
    monkeys[0].setBox(new Box()); // 처음에는 빨간 원숭이가 가지고 있으므로 여기에 세팅.
  }

  // 상태 출력 메서드
  void allMonkeyPrint() {
    for(int i = 0;i<monkeys.length;i++) {
      monkeys[i].print();
    }
    System.out.println("---------------------------------------------");
  }

  // 1번, 2번, 3번, 4번이면 정방향 이동이라 큰 문제가 없는데,
  // 5번이면 조금 곤란핼진다.
  // 즉, 마지막 것만 제외하고 전부 ++ 가면 된다.
  void change(int direction , int count) { //매개변수: 방향/얼마나 이동할지

    if(direction == 1) { // 오른쪽
      for(int i = 0;i<count;i++) { // 5 0~4 5번
        if(i == 4) { // 마지막 인덱스에 해당(처음으로 옮겨가야 하는 경우)
          monkeys[0].setBox(monkeys[i].getBox()); // 0번째 있는 애한테 4번째 요소를 주고
          monkeys[i].setBox(null); // 4번째 있는 애를 null
        }
        else { // 일반적인 경우
          monkeys[i+1].setBox(monkeys[i].getBox());// 그다음 애한테 이전 걸 주고
          monkeys[i].setBox(null); // 이전거를 null로 만든다.
        }

        allMonkeyPrint(); // 돌리면서 찍어야.
      }
    }
    else { //왼쪽
      // 바로 시작하면 된다. 빨간 원숭이 0번 걸 바로 4번에게 주고 시작하면 된다.
      int num = 4;
      monkeys[num].setBox(monkeys[0].getBox()); // 0번 것을 4번에게 넘김.
      monkeys[0].setBox(null); // 0번 것을 null

      allMonkeyPrint();

      for(int i = 1;i<count;i++) { // 5 1 ~ 4 한 번 갔으니까.
        monkeys[num-1].setBox(monkeys[num].getBox()); // 여기도 한 번 갔으니까.
        monkeys[num].setBox(null);
        allMonkeyPrint();
        num--; // 차례대로 반복을 위해서 빼줌.
      }
    }
  }

}

public class Q1 {

  public static void main(String[] args) {

    Random r =  new Random();
    Move m = new Move();
    int direction = r.nextInt(2);
    int count = r.nextInt(5) + 1;

    System.out.println("게임을 시작합니다.");

    System.out.println("좌로 이동은 0, 우로 이동은 1 랜덤수는 : "+ direction);
    System.out.println("랜덤 이동횟수는 : "+count);
    System.out.println();

    m.allMonkeyPrint(); // 빨간원숭이 처음에 출력하게 하려고

    m.change(direction, count);

    System.out.println();
    System.out.println("프로그램을 종료합니다.");

  }

}
