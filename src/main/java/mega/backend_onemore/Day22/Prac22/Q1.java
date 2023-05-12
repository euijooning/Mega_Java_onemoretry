package mega.backend_onemore.Day22.Prac22;
/* <포켓몬 퀴즈>
<지우 클래스>
포켓몬 볼 -> 포켓몬

<오박사 클래스>
포켓몬 볼 -> 포켓몬
포켓몬 볼 -> 포켓몬
포켓몬 볼 -> 포켓몬

<포켓몬>    <색깔>   <크기>
피카츄     노란색     대
파이리     빨간색     중
꼬부기     파란색     소
이상해씨   초록색     미니

오박사 포켓몬 볼에 랜덤으로 포켓몬, 색깔, 크기가 정해져서
3개의 포켓몬 볼에 들어가 있습니다.

지우가 오박사에게
1, 2, 3 번 중 하나를 선택해서 하나의 포켓몬 볼을 받습니다.(지우가 고른다)
-> 이 말은 오박사가 포켓몬 볼을 가지고 있다는 소리...!!

그 받은 포켓몬의 포켓몬 볼을 열어서
어떤 포켓몬인지 출력을 하면 됩니다.
예)   파란색 피카츄 이고 크기는 중입니다.

지우가 무슨 포켓몬인지 받아서 말하게 시키면 된다.
지우는 포켓몬을 통해서 포켓몬 볼에 포켓몬을 담을 수 있게 된다.
지우는 포켓몬 볼만 가지고 있다.
 */

/*
idea
- 지우 클래스, 오박사 클래스, 포켓몬 볼 클래스, 포켓몬 클래스, 오박사 클래스 있으면 됨

<포켓몬 클래스>
- 먼저 포켓몬에는 포켓몬 타입, 색깔, 사이즈를 속성으로 가지고,
- 포켓몬이 생성될 때 생성자 안에는 랜덤수와,
  각각의 속성을 받을 String 배열이 필요(3개)
- 랜덤 수 만들기
속성(type) =  monster[r.nextInt(m.length)]; 이런식으로
- 다 받았으면, 생성자 속에 talk 메서드까지 호출되도록 호출하는 코드를 하나 넣어줌.

- 그리고 talk(상태출력) 메서드
-- void talk() {
		System.out.println(color+" "+type+"이(며)고, 크기는 "+size+" 입니다.");
	} 요 느낌으로 가지고 있으면 된다.

<포켓몬 볼 클래스>
- 포켓몬 자료형의 포켓몬 필드를 가지고 있으면 됨.

<지우 클래스>
- 포켓몬볼 자료형의 ball 을 필드로 가지고 있으면 됨.

<오박사 클래스>
- 객체배열, PB[] 를 3개 가지고 있으면 됨.
- 생성자에서 초기화 하고, 객체 넣어줌.

<main>
- 스캐너 생성
- 포켓몬 세 마리 담을 객체 배열 생성
=> 세 마리 채우고 나서 오박사 클래스에 넘겨줄 것.
- 반복문 돌면서 포켓몬 채우기
- 채워주는 것은 o.bl[i].m = p[i];
// b1은 오박사에 있는 포켓몬 자료형 객체배열,
m은 포켓몬볼에 있는 포켓몬 ,  p[i]는 포켓몬 한마리

while true
- 1, 2, 3 중에 하나 고르기(숫자 입력 받기)
- 입력한 수가 1, 2, 3 중에 하나이면,
그렇게 되면 지우의 ball에다가 오박사의 ball을 할당함.

그렇지 않으면 잘못된 입력

true문 나와서, 지우의 ball의  몬스터의 상태를 talk함.

코드 종료.
 */
/*
지우는 포켓몬 볼만 가지고 있어야 한다. 왜? 오박사에게 받아야 하니까.
 */
import java.util.Random;
import java.util.Scanner;

class PMon {
  String type;
  String color;
  String size;

  PMon(){
    // 생성자에서 랜덤으로 포켓몬 종류, 색, 크기를 정함
    // 객체 만들어질 때, 배치도 같이 해버리기 위함.(불릴 때 피카츄의 정체가 정해짐)
    Random r = new Random();
    String[] name = {"피카츄","파이리","꼬부기","이상해씨"};
    String[] c = {"노란색","빨간색","파란색","초록색"};
    String[] s = {"대","중","소","미니"};

    // 랜덤수, 부를 때마다 한번씩 배치하는 메서드 호출해서 type, color, size에 저장.
    type = name[r.nextInt(name.length)];
    color = c[r.nextInt(c.length)];
    size = s[r.nextInt(s.length)];

    talk(); // 생성자 내에 메소드가 더 효율적.

  }

  void talk() {
    System.out.println(color+" "+type+" 이(며)고, 크기는 "+size+" 입니다.");
  }
}

// 포켓몬 클래스 PM을 가지고 있는 포켓볼 클래스 PB 정의
class PBall{
  PMon monster;
}

// 포켓볼을 가지고 있는 캐릭터 클래스 JW 정의
class JiWoo{
  PBall ball; //이렇게 되면 포켓볼 안에 포켓몬스터가 담기게 된다.
}

// 포켓볼 배열을 가지고 있는 오박사 클래스 Oh 정의
// 오박사는 생성될 때 포캣볼 객체를 가지고 있어야 겠죠.
class DrOh{
  PBall[] ball = new PBall[3];


  DrOh(){ // 생성자에서 포켓볼 3개를 만듦
    for(int i = 0;i<ball.length;i++) {
      ball[i] = new PBall(); // 객체생성
      // 생성된 포켓볼에는 PM 인스턴스가 없으므로,
      // 이후 main에서 PM 인스턴스를 채워줌
      // main에서 포켓볼 넣어주고
      // 나중에 지우에게 고르라고 하면 끝.
    }
  }
}


public class Q1 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    PMon poke[] = new PMon[3]; //3마리 채우고 오박사 주면 된다.
    // PM 클래스의 인스턴스를 담을 배열 생성

    DrOh oh = new DrOh(); // 오박사 클래스 인스턴스 생성
    JiWoo jw = new JiWoo(); // 지우 클래스 인스턴스 생성

    // PM 인스턴스를 3개 생성하고,
    // 생성된 PM 인스턴스를 PB 인스턴스에 담아 포켓볼에 넣음
    for (int i = 0; i < poke.length; i++) {
      poke[i] = new PMon();
      oh.ball[i].monster = poke[i];// 오박사가 가지고 있는 몬스터의 포켓볼에 바로 들어간다.
      //오박사가 가지고 있는 포켓볼에 있는 포켓몬에 포켓몬이 들어간 것(채워진 것)
      // 즉, 이 과정을 거치면 오박사 포켓몬볼에는 3마리 포켓몬이 다 차있게 될 것.

    }

    // 사용자에게 포켓볼을 선택하게 함
    while (true) {
      System.out.println("1,2,3 중에 고르세요 : ");
      int num = sc.nextInt();
      if (num == 1 || num == 2 || num == 3) {
        jw.ball = oh.ball[num - 1]; // -1은 1, 2, 3을 입력하므로 인덱스 맞추기
        // ball을 줘야하는 이유는 지우가 볼 객체가 없다.
        // 지우 클래스 인스턴스의 ball 필드에
        // 선택된 포켓볼의 PB 인스턴스를 담음

        // 즉 입력을 받아서 오박사의 포켓몬볼을 지우에게 넘겨주는 과정.

        break;
        /*
        사용자가 1, 2, 3 중 하나를 입력하면
        j 객체의 ball 멤버 변수에 Oh 클래스의 bl 배열에서
        해당 인덱스에 해당하는 PB 객체를 할당합니다.
        여기서 PB 객체는 PM 객체를 포함하고 있습니다.
         */
      } else {
        System.out.println("잘못된 입력입니다.");
        System.out.println("제대로 고르세요.");
      }
    }

    jw.ball.monster.talk(); // 지우가 가지고 있는 포켓볼의 포켓몬이 뭔지 말한다.

  }

}

/*
프로그램의 실행 흐름
<PM 클래스>
PM 클래스는 포켓몬을 나타내는 클래스입니다.
포켓몬의 종류(type), 색상(color), 크기(size)를 멤버 변수로 가집니다.
PM 클래스의 생성자에서는
랜덤으로 포켓몬의 종류, 색상, 크기를 정하고 talk() 메소드를 호출합니다.

<PB 클래스>
PB 클래스는 포켓몬을 담을 포켓볼을 나타내는 클래스입니다.
PB 클래스의 멤버 변수로는 PM 클래스 타입의 m이 있습니다.

<JW 클래스>
JW 클래스는 지우를 나타내는 클래스입니다.
JW 클래스의 멤버 변수로는 PB 클래스 타입의 ball이 있습니다.

<Oh 클래스>
Oh 클래스는 오박사를 나타내는 클래스입니다.
Oh 클래스의 멤버 변수로는 PB 배열 bl이 있습니다.
Oh 클래스의 생성자에서는 PB 배열의 각 요소를 생성합니다.
생성된 포켓볼은 나중에 사용될 것입니다.

<main() 메소드>
main() 메소드에서는 PM 배열 p를 선언합니다.
그리고 Oh 클래스의 객체 o, JW 클래스의 객체 j,
Scanner 클래스의 객체 sc를 생성합니다.
for문을 이용하여 p 배열의 각 요소를 생성하고,
생성된 포켓몬을 o.bl 배열에 있는 포켓볼에 저장합니다.

while문을 이용하여 사용자로부터 1, 2, 3 중 하나의 번호를 입력받습니다.
입력된 번호에 해당하는 포켓볼을 j.ball에 저장합니다.
j.ball.m.talk()을 호출하여 지우가 가지고 있는 포켓몬의 정보를 출력합니다.
 */
