package mega.backend_onemore.Day22.Prac22;
// Q1은 앞선 것과 중복되므로 pass
/*
<동물 게임>
동물 클래스에는 이름과 색깔, 모든 속성은 private이며 get, set 함수를 사용합니다.
동물 클래스를 상속받는 개, 고양이, 새가 있습니다.
개는 짖는 기능, 고양이는 야옹하는 기능, 새는 나는 기능이 있습니다.

동물원에는 개가 3마리, 고양이 2마리, 새 1마리가 있습니다.

이름표
개 - 말티즈, 요크셔테리어, 포메라니안, 시바, 웰시코기
고양이 - 앵무새, 참새, 닭, 까마귀, 비둘기
색깔 - 갈색, 검은색, 흰색, 노란색, 점박이

랜덤 0~4로 객체 생성시마다 랜덤 값을 추출해주시기 바람.

여기에 있는 이름표와 색을 랜덤으로 골라서 개, 고양이, 새의 객체를 만든 이후에
개는 짖고, 고양이는 야옹하고, 새는 날아간다.

개 : 짖다(갈색의 시바는 짖는다_)
이런식으로 출력되게

 */


/*
동물클래스 생성, getter, setter 다 만들어줌.
개 클래스는 Animal을 상속받고, get으로 color과 name을 받아옴.
새 클래스, 고양이 클래스도 역시 동일

<동물원 클래스>
랜덤 수 생성, 여기에 새 클래스의 객체 배열을 만들어주고,
Zoo 생성자 안에
랜덤클래스와 각 속성의 String 배열을 넣어줌.
반복문 돌면서 객체 채워주기
print까지 안으로 넣는다.

<main메서드> 여기서는 객체 생성만 하고 끝.
 */

import java.util.Random;

class Animal {

  private String name;
  private String color;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
/*
Zoo 에 통일 시키지 않고, 다른 방법도 있어.
각 클래스에서 랜덤으로 받아서 생성자 호출할 때마다 랜덤 값 받고,
넣어줘서 만들게 하는 방법도 있음
 */

// 개 고양이 새는 기능만 가지고 있으니까 메서드만 가지고 있다는 이야기.
// 이름과 색깔은 상속받아서 get, set으로 불러오거나 세팅하면 된다는 이야기.
class Dog extends Animal {

  void print() {
    System.out.println(getColor() + "의 " + getName() + "은 짖는다.");
  }
}

class Cat extends Animal {

  void print() {
    System.out.println(getColor() + "의 " + getName() + "은 야옹한다.");
  }
}

class Bird extends Animal {

  void print() {
    System.out.println(getColor() + "의" + getName() + "은 날아다닌다.");
  }
}

class Zoo {

  // 모든 동물을 가지고 있는 Zoo 클래스 생성
  // 객체배열로 담기
  Dog[] dog = new Dog[3];
  Cat[] cat = new Cat[2];
  Bird bird;

  // Zoo가 객체생성될 때 모든 것이 다 세팅.
  Zoo() {
    Random r = new Random();
    String[] dt = {"말티즈", "요크셔테리어", "포메리안", "시바", "웰시코기"};
    String[] ct = {"먼치킨", "스핑크스", "뱅갈", "샴", "폴드"};
    String[] bt = {"앵무새", "참새", "닭", "까마귀", "비둘기"};
    String[] co = {"갈색", "검은색", "흰색", "노란색", "점박이"};

    for (int i = 0; i < dog.length; i++) {
      dog[i] = new Dog();
      dog[i].setName(dt[r.nextInt(dt.length)]); //랜덤으로 이름을 세팅
      dog[i].setColor(co[r.nextInt(co.length)]); // 랜덤으로 색깔을 세팅
      dog[i].print(); // 세팅을 완료한 후에 상태를 출력
    }

    for (int i = 0; i < cat.length; i++) {
      cat[i] = new Cat();
      cat[i].setName(ct[r.nextInt(dt.length)]); //랜덤으로 이름을 세팅
      cat[i].setColor(co[r.nextInt(co.length)]); // 랜덤으로 색깔을 세팅
      cat[i].print();
    }

    bird = new Bird();
    bird.setName(bt[r.nextInt(bt.length)]); //랜덤으로 이름을 세팅
    bird.setColor(co[r.nextInt(co.length)]); // 랜덤으로 색깔을 세팅
    bird.print();
  }
}

public class Q2 {

  public static void main(String[] args) {
    new Zoo(); // 객체 한번만 생성해서 모든 과정을 다 끝
    // 여기서 변수에 저장 굳이 안 하는 이유는 한 번 부르고 끝낼 것이기 때문
    //Zoo zoo = new Zoo(); 정석대로 하면 이게 맞지.
  }
}
