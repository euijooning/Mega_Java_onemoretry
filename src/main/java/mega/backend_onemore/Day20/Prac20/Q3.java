package mega.backend_onemore.Day20.Prac20;

import java.util.Random;
import java.util.Scanner;

/*
문제
시민 5명이 있고, 1명 마피아 랜덤으로 마피아가 선택이됩니다.
경찰 – 번호를 선택하는 변수

시민이면 print
“억울합니다. 저는 마피아가 아닙니다.”
마피아이면 print
“네 제가 마피아입니다.”

마피아 일일이 잡기
 */
class Human{
  boolean check; // 마피아 여부를 나타내는 변수
  Human(boolean check){
    this.check = check;
  }
  void print() {

    if(check) {
      System.out.println("네 제가 마피아 입니다.");
    }
    else {
      System.out.println("억울합니다. 저는 마피아가 아닙니다.");
    }
  }
}

class Police{
  Scanner sc = new Scanner(System.in);
  int input() {
    System.out.print("마피아는?");
    return sc.nextInt();
  }
}

public class Q3 {

  public static void main(String[] args) {

    Random r = new Random();
    Police p = new Police();
    Human[] hlist = new Human[5];
    // Human 인스턴스를 저장할 배열 생성

    int num = r.nextInt(5); //0~4

    for(int i =0;i<hlist.length;i++) {
      if(i == num) {
        hlist[i] = new Human(true);
        // 난수와 인덱스가 같으면 해당 인스턴스를 마피아로 지정
      }
      else {
        hlist[i] = new Human(false);
        // 난수와 인덱스가 다르면 해당 인스턴스를 일반인으로 지정
      }
    }

    while(true) {
      int pNum = p.input(); // 사용자로부터 입력 받은 번호
      if(pNum >0 && pNum <6) { // 1부터 5까지의 번호만 유효
        hlist[pNum-1].print();
        //hlist가 들어가 있기 때문에 반드시
        // true 또는 false가 들어가 있을 것.
        // 해당 인덱스의 Human 인스턴스의 print() 메서드 호출
        if(hlist[pNum-1].check) {  // 해당 인스턴스가 마피아면
          break;
        }
      }
      else { // 1부터 5까지의 번호가 아닌 경우
        System.out.println("잘못된 입력입니다.");
      }
    }
  }

}
/*
이 코드는 마피아 게임의 간단한 버전을 구현한 것입니다.

Human 클래스: 마피아인지 아닌지를 나타내는 check 필드와
이를 출력하는 print() 메서드를 가지고 있습니다.

Police 클래스: Scanner를 이용하여
사용자로부터 마피아의 번호를 입력받는 input() 메서드를 가지고 있습니다.

main() 메서드:
a. Random 클래스를 이용하여 0~4 중 랜덤한 번호를 선택하여
그 번호의 사람을 마피아로 지정합니다.
b. Human 클래스의 인스턴스를 배열로 생성합니다.
c. while(true) 루프 안에서 Police 클래스의
input() 메서드를 이용하여 마피아가 있는 사람의 번호를 입력받고,
해당 번호의 Human 인스턴스의 print() 메서드를 호출하여
그 사람이 마피아인지 아닌지 출력합니다.
d. 만약 입력받은 번호의 사람이 마피아인 경우 while(true) 루프를 빠져나옵니다.

Human 클래스는 마피아 게임에서 사용되는 사람을 표현하기 위한 클래스입니다.
클래스의 구성 요소는 다음과 같습니다.

boolean check: 인스턴스가 마피아인지 아닌지를 나타내는 필드입니다.
생성자에서 초기화됩니다.

Human(boolean check): check 필드를 초기화하는 생성자입니다.

void print(): check 필드의 값을 출력하는 메서드입니다.
만약 check 필드가 true이면 "네 제가 마피아 입니다."를 출력하고,
false이면 "억울합니다. 저는 마피아가 아닙니다."를 출력합니다.

즉, 이 클래스는 게임 참여자가 마피아인지 아닌지를 나타내는 역할을 하며,
그에 따라 각각 다른 메시지를 출력하는 기능을 제공합니다.

Human 클래스의 생성자에서 받아온 boolean 매개변수 check는
true나 false 중 하나의 값을 가질 수 있습니다.
if문에서 사용된 check는 인스턴스 변수의 값을 나타내며,
따라서 true 또는 false의 값을 가질 수 있습니다.

if(check)는 check 변수가 true인 경우에 실행됩니다.
이 경우 "네 제가 마피아 입니다."를 출력합니다.
반대로 check 변수가 false인 경우에는
"억울합니다. 저는 마피아가 아닙니다."를 출력합니다.


main
main 메서드는 마피아 게임을 구현하는 코드로서,
게임 참여자가 마피아인지 아닌지를 맞추는 게임입니다.
구체적으로, main 메서드의 내용은 다음과 같습니다.

Random r = new Random()
: Random 클래스를 이용하여 난수 생성기 객체를 생성합니다.

Police p = new Police()
: Police 클래스의 인스턴스를 생성하여 p 변수에 할당합니다.

Human[] hlist = new Human[5]
: Human 클래스의 인스턴스 5개를 저장할 수 있는 배열 hlist를 생성합니다.

int num = r.nextInt(5)
: 0부터 4까지의 정수 중에서 랜덤한 하나를 생성하여 변수 num에 할당합니다.

for(int i =0;i<hlist.length;i++)
: hlist 배열의 각 인덱스에 Human 클래스의 인스턴스를 생성합니다.
num과 i가 같은 경우, 즉 num번째 인스턴스인 경우에는
생성자의 매개변수를 true로 설정하여 마피아로 지정하고,
그렇지 않은 경우에는 false로 설정하여 일반인으로 지정합니다.

while(true): 무한 루프를 실행합니다.

int pNum = p.input()
: Police 클래스의 input() 메서드를 호출하여
사용자로부터 마피아의 번호를 입력받습니다.
입력받은 번호를 pNum 변수에 할당합니다.

if(pNum >0 && pNum <6)
: pNum이 1부터 5까지의 값인 경우에만 아래의 코드를 실행합니다.

hlist[pNum-1].print()
: hlist 배열에서 pNum-1번째 인스턴스의 print() 메서드를 호출하여,
해당 인스턴스가 마피아인지 아닌지 출력합니다.

if(hlist[pNum-1].check)
: 만약 해당 인스턴스가 마피아인 경우에는 무한 루프를 종료합니다.

else
: 만약 해당 인스턴스가 마피아가 아닌 경우에는 아무 작업도 하지 않고
다시 while문의 처음으로 돌아갑니다.

위 코드는 사용자로부터 마피아의 번호를 입력받아
해당 번호가 마피아의 번호와 일치하는지를 맞추는 게임입니다.
초기에는 5명의 인스턴스가 생성되며,
그 중 하나만 마피아로 지정됩니다.
사용자가 마피아의 번호를 맞추면 게임이 종료됩니다.

 */

