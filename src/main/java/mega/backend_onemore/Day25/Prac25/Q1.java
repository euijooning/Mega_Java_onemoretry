package mega.backend_onemore.Day25.Prac25; // 물고기와 원리 동일

import java.util.Random;
/*
원숭이 상자 문제>
1번 원숭이 빨강 / 2번 노랑 / 3번 파랑 / 4번 초록 / 5번 검정
원숭이는 스스로 자기 물건 보유 상태 출력

2가지 랜덤 수 받기
1) 0(좌), 1(우)
2) 1~5번의 랜덤으로 정해진 횟수

<게임시작>
빨간원숭이 처음에 상자 보유
1랜덤값 0이면 우측으로 상자 이동
(빨->노->파->초->검)
1랜덤값 1이면 좌측으로 상자 이동
(노<-파<-초<-검<-빨)
 */
/*
아이디어
1. Box 클래스
- 비어있음

2. 원숭이 클래스
- 색깔, Box가 필드(Has 관계)
- 생성자 : color
- Box 가지고 getter, setter
- 출력 메서드

3. 이동 클래스
- 원숭이 배열(5개짜리 1차원)

<생성자>
- 색깔 가진 String 배열
- 원숭이 객체 채우기
- monkeys[0].setBox(new Box());
 (처음에는 빨간 원숭이가 가지고 있다고 했으므로)

<원숭이 상태 전체출력 메서드?
- for문 원숭이 배열 길이만큼 돌면서 monkeys[i].print();

<바꾸기 메서드**>
매개변수: 방향 / 얼마나 이동할지

1) 오른쪽 : for(int i = 0;i<count;i++) 돌면서
1-1) 마지막 인덱스에 해당한다면,
  - 0번째에게 4번째 애가 가지고 있는 것을 주고 4번째 애를 null처리
1-2) 다른 경우(일반적인 경우에 해당)
  다음 인덱스 애한테 이전 것을 주고, 이전것을 null처리
- for문 나와서 상태출력 메서드 호출

2) 왼쪽
<바로 시작하면 된다. 빨간 원숭이 0번 걸 바로 4번에게 주고 시작하면 된다.
 첫번째는 오른쪽으로 간 것과 동일하다>
2-1) 첫번째 것
- 인덱스 나타낼 num 변수 4로 초기화(가장 오른쪽에 있을 것이므로)
- 0번 것을 4번에게 주고 0번을 null 처리
2-2) 나머지 것들
-  for(int i = 1;i<count;i++) 돌면서
- 다음 인덱스 애한테 이전 것을 주고, 이전 것을 null 처리
- 전체 상태 출력
- ** num을 1 감소시켜줘야 한다.

4. main 메서드
- 랜덤 클래스
- Move 인스턴스 생성
- direction 변수, count 변수
(게임시작)
- 두 가지 정보 출력 : 이동 랜덤수, 랜덤 이동횟수
- 처음에 빨간원숭이 가지고있는 거 출력  move.allMonkeyPrint();
- 바꾸기 메서드 호출해서 게임 진행 move.change(direction, count);
- 프로그램 종료
 */
/*
Tip>
num을 쓰지 않으려면
  for(int i = count-1; i>= -1;i--) { // 5 1 ~ 4 : 한 번 갔으니까.
    monkeys[i-1].setBox(monkeys[i].getBox()); // 여기도 한 번 갔으니까.
    monkeys[i].setBox(null);
    allMonkeyPrint();
  } 이렇게 하면 된다.(관계성 파악해서)
 */
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

class Move {
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
  void change(int direction , int count) { //매개변수: 방향 / 얼마나 이동할지

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
      // 첫번째는 오른쪽으로 간 것과 동일하다.
      int num = 4;
      monkeys[num].setBox(monkeys[0].getBox()); // 0번 것을 4번에게 넘김.
      monkeys[0].setBox(null); // 0번 것을 null

      allMonkeyPrint();

      // 나머지는 방향이 같으니까.
      for(int i = 1;i<count;i++) { // 5 1 ~ 4 한 번 갔으니까.
        monkeys[num-1].setBox(monkeys[num].getBox()); // 여기도 한 번 갔으니까.
        monkeys[num].setBox(null);
        allMonkeyPrint();
        num--; // 차례대로 반복을 위해서 빼줌. 왼쪽으로 갈 때는 인덱스가 감소해야지
      }
      /*
      num을 쓰지 않으려면
      for(int i = count-1; i>= -1;i--) { // 5 1 ~ 4 : 한 번 갔으니까.
        monkeys[i-1].setBox(monkeys[i].getBox()); // 여기도 한 번 갔으니까.
        monkeys[i].setBox(null);
        allMonkeyPrint();
      } 이렇게 하면 된다.(관계성 파악해서)
       */
    }
  }

}

public class Q1 {

  public static void main(String[] args) {

    Random r =  new Random();
    Move move = new Move();
    int direction = r.nextInt(2);
    int count = r.nextInt(5) + 1;

    System.out.println("게임을 시작합니다.");

    System.out.println("좌로 이동은 0, 우로 이동은 1 // 현재 랜덤수는 : "+ direction);
    System.out.println("랜덤 이동횟수는 : " +count);
    System.out.println("--------------------게임 진행-------------");
    System.out.println();

    move.allMonkeyPrint(); // 빨간원숭이 처음에 출력하게 하려고

    move.change(direction, count);

    System.out.println();
    System.out.println("프로그램을 종료합니다.");

  }
}
