package mega.backend_onemore.Day18;
/*
음식 옮기기 게임
동물은 "원숭이","개","닭","돼지"
음식은 "바나나","뼈다귀","모이","여물"

각자가 가지고 있는 것을 돌면서 하나씩 뒤로 옮김.
옮겨진 결과값을 출력하면 됨

idea.
- type 과 food 필드로 가지고 있고, 생성자도 그렇게 만들어주면 됨.
- 출력 메서드 하나면 충분

main
- 음식과 동물을 담을 String 배열 각각 생성
- 각 세트를 담아줄 객체 배열 생성(Animal)
- 객체에 요소 담아주고, 출력 메서드 호출하여 상태 확인

- 4번째 요소(인덱스로는 3번) 임시 변수에 저장하기
- 가장 끝 인덱스부터 시작 인덱스까지 하기 위해서 length-1 돌면서
해당 인덱스에 있는 위치에 앞선 위치 인덱스에 있는 음식 넣어주기.
- 저장한 4번째 요소를 다시 첫번째로 옮겨버림 => 완전체

- 마지막으로 출력
 */

class Animal{
  String type;
  String food;

  // 생성자
  Animal(String type, String food){
    this.type = type;
    this.food = food;
  }

  // 출력 메서드
  void print() {
    System.out.println(type+"->"+food);
  }

}

public class Q1 {

  public static void main(String[] args) {

    // 각각 담긴 배열 생성하여 값을 넣어줌
    String[] aT = {"원숭이","개","닭","돼지"};
    String[] fT = {"바나나","뼈다귀","모이","여물"};

    // 에니멀 배열 생성
    Animal[] ani = new Animal[4];

    // 끝까지 돌면서 객체 넣어주기
    for(int i = 0;i<ani.length;i++) {
      ani[i] = new Animal(aT[i],fT[i]);
      ani[i].print();
    }
    System.out.println("---------------------------------------------");
    String temp = ani[3].food;

    for(int i = ani.length-1;i>0;i--) { // 3 2 1
      // 가장 끝 인덱스부터 시작 인덱스까지 하기 위해서 length-1
      //(인간의 숫자 개념 != 배열의 숫자 개념 그 마이너스1)
      // 그리고... 앞서서 하나가 빠졌기 때문에 i>=0 이 아닌 i>0
      // 유효한 범위를 만들기 위한 사소한 작업이라고 생각하면 된다. -1은 비교할 수가 없으니.
      ani[i].food = ani[i-1].food;
      //3            2
      //2            1
      //1            0
    }

    ani[0].food = temp; // 저장한 4번째 요소를 다시 첫번째로 옮겨버림 => 완전체

    // 끝까지 돌면서 출력
    for(int i = 0;i<ani.length;i++) {
      ani[i].print();
    }

  }

}
