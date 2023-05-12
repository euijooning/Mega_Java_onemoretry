package mega.backend_onemore.Day24.Prac24;

/*
<공룡 오버라이딩 문제>
- 키와 무게를 가진 공룡 클래스에는 나는 공룡이다를 외치는 함수
- 티라노사우르스는 공룡 상속받고, 오버라이딩
"나는 키 2m, 몸무게 1톤인 티라노사우르스다"
- 트리케라톱스는 공룡 상속받고, 오버라이딩
"나는 키 3m, 몸무게 2톤인 트리케라톱스다"
- 부경사우르스는 공룡 상속받고, 오버라이딩
"나는 키 5m, 몸무게 3톤인 부경사우르스다"

main문에서 static 함수를 하나 만들어서
그 함수에서 외치는 함수가 호출되도록 구현
(함수 인자는 1개, 세 공룡을 외치려면, 함수 세 번 호출되게)
 */

// 키와 무게는 부모 것을 가져다 쓴다.
// 변수에 담겨 있는 것을 불러다 쓴다는 원칙!

class Dino{
  int height;
  int ton;

  Dino(int meter, int t){
    this.height = meter;
    this.ton = t;
  }

  void print() {
    System.out.println("나는 공룡이다.");
  }
}

class Tirano extends Dino{
  Tirano(){
    super(2,1);
  }
  void print() { // 오버라이딩.
    System.out.println("나는 키 "+height+"m, 몸무게 "+ton+"톤인 티라노사우르스다.");
  }
}
class Trice extends Dino{
  Trice(){
    super(3,2);
  }
  void print() {
    System.out.println("나는 키 "+height+"m, 몸무게 "+ton+"톤인 트리케라톱스다.");
  }
}
class BuKyeong extends Dino{
  BuKyeong(){
    super(5,3);
  }
  void print() {
    System.out.println("나는 키 "+height+"m, 몸무게 "+ton+"톤인 부경사우르스다.");
  }
}

public class Q3 {

  static void talk(Dino dino) { //Dino가 부모이므로 티라노고 뭐고 다 들어올 수 있음. 이게 상속의 장점.
    dino.print();
  }

  public static void main(String[] args) {
    talk(new Tirano());
    talk(new Trice());
    talk(new BuKyeong());
  }

}
