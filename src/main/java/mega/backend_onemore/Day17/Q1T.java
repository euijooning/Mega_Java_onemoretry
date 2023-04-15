package megait.backend_lecture.Day17;

import java.util.Random;
/*
아이디어
1. 플레이어 클래스는 기존과 완전 동일
2. main문에서
    Random r = new Random(); // 랜덤 수 출력
    String[] c = {"한국","중국","미국","러시아"};
    // 국가 담을 클래스 배열 생성
    Player[] p = new Player[4]; // 배열 각각의 객체를 생성
3. 이동 거리 누적시키기
3-1. 어떤 한 선수의 이동거리가 100 이상이 되면 반복문을 종료
3-2. 모든 선수의 이동거리가 100 미만인 경우에 반복문을 계속 실행
3-3.  for 루프를 사용하여 p 배열의 모든 요소에 대해
    runAndCheck 메서드를 호출하면서,
    dol 값을 인자로 전달하여 각 선수의 이동거리를 누적
4. 우승국 찾기
      if(max < p[i].move) {
        max = p[i].move;
        }
5. 우승국 출력하기
if(p[i].move == max) {

}

 */

class Player01{
  int num; //레인번호
  String country; // 국가
  int m; // 전진거리

  Player01(int num, String country){ // 생성자 => 레인번호, 국가
    this.num = num;
    this.country = country;

  }

  void runAndCheck(int num, Random r) { // 이동거리(전진) 실행 메서드
    // 밖에서 레인번호만 알려주면 된다.
    if(num != this.num) { //돌발 레인번호와 내 레인번호가 일치하지 않으면ㅇ
      m += r.nextInt(10)+1; // 전진(전진거리에 이동거리만큼을 누적)
    }
    System.out.println(country+"선수 이동거리는 "+m+"M 입니다.");
  }
}

public class Q1T {

  public static void main(String[] args) {
    Random r = new Random();
    String[] c = {"한국","중국","미국","러시아"};
    Player[] p = new Player[4]; // 배열 각각의 객체를 생성

    for(int i = 0;i<p.length;i++) {
      p[i] = new Player(i+1, c[i]);
    }
    /*
    i가 0부터 시작하여 p의 길이보다 작은 동안,
    i를 증가시키면서 p[i]에 새로운 Player 객체를 생성합니다.
    이때, Player 생성자에 i+1과 c[i]를 전달하여, Player 객체의 num 필드에는 i+1이,
    country 필드에는 c[i]가 할당됩니다.

    결과적으로, 위 코드는 p 배열의 각 요소에 대해 Player 객체를 생성하고,
    num 필드와 country 필드를 초기화하여 해당 객체를 초기화하는 작업을 수행합니다.
     */

    while(p[0].move<100&&p[1].move<100&&p[2].move<100&&p[3].move<100) {
      int dol =r.nextInt(4)+1;
      for(int i = 0;i<p.length;i++) {
        p[i].runAndCheck(dol, r);
      }
    }
    /*
    해당 코드는 4개의 선수 중 하나를 무작위로 선택하고,
    선택된 선수의 runAndCheck 메서드를 호출하여
    이동거리를 누적시키는 작업을 반복하다가,
    어떤 한 선수의 이동거리가 100 이상이 되면 반복문을 종료합니다.

    while 루프의 조건문에서는 p[0]부터 p[3]까지
    각각의 선수 객체의 move 필드를 비교하여,
     모든 선수의 이동거리가 100 미만인 경우에 반복문을 계속 실행합니다.

    int dol = r.nextInt(4) + 1은
    1부터 4까지의 숫자 중 하나를 무작위로 선택하여 dol 변수에 저장합니다.
    이 변수는 runAndCheck 메서드에서
    선수의 이동거리를 누적시킬지 여부를 결정하는 데 사용됩니다.

    마지막으로 for 루프를 사용하여 p 배열의 모든 요소에 대해
    runAndCheck 메서드를 호출하면서,
    dol 값을 인자로 전달하여 각 선수의 이동거리를 누적시킵니다.
    이렇게 반복문을 실행하다가 어떤 한 선수의 이동거리가 100 이상이 되면,
    while 루프의 조건이 거짓이 되어 반복문이 종료됩니다.
     */

    int max = -1; // 시작이
    //선수들의 이동거리 중 최댓값을 구할 때,
    // 만약에 선수들의 이동거리가 모두 0 미만인 경우에도
    // 올바른 최댓값을 구할 수 있도록 보장합니다.
    for(int i = 0;i<p.length;i++) { // 우승국 추출하기(최댓값 활용)
      if(max < p[i].move) {
        max = p[i].move;
      }
    }

    for(int i = 0;i<p.length;i++) { // 우승국 출력하기
      if(p[i].move == max) {
        System.out.println(p[i].country+"우승국입니다.");
        break;
      }
    }
  }
}
