package mega.backend_onemore.Day24.Prac24;

import java.util.Random;
/*
상어 먹이 먹기 게임
- 100개의 먹이, 상어의 객체는 5마리
- 상어는 객체 생성 시 먹이 먹을 수 있는 양이 정해짐
(랜덤 8~14개 범위)
- main문에서 상어 5마리는 먹이 섭취
- 상어가 얼마나 잡아먹었는지 출력하기
끝
 */

class FishFeed{

}
/*
상어 - 물고기를 먹고, 얼마나 먹었는지 출력하면 됨.
 */
class Shark{
  String name; // 상어의 이름
  FishFeed[] feeds = new FishFeed[14]; // 여기서 먹이 14개 갖게 함.

  Shark(String name) { // 상어1, 상어2 등으로
    this.name = name;  // 상어 객체 생성 시 이름을 인자로 받아와 초기화
  }

  //1. 진짜 먹는거
  // 먹이를 받아와 feeds 배열에 추가하는 메서드
  void eat(FishFeed feed) { // 먹이를 매개변수로 받아서
    for(int i = 0;i<feeds.length;i++) { // 전체를 돌면서
      if(feeds[i] == null) { // null이면
        feeds[i] = feed; // 물고기를 채워준다.
        break;
      }
    }
  }

  //2. 먹는 개수 확인(오버로딩 활용)
  // feeds 배열에 저장된 먹이 객체 수를 반환하는 메서드
  // 얘가 먹는데까지 돌아서 null 이 아닌데까지 리턴해주면 된다.
  int eat() {
    for(int i = 0;i<feeds.length;i++) {
      if(feeds[i] == null) { // 그 부분이 비어있다면,
        return i; //여기까지 먹은 것.(영부터 시작했으니 i줘도 된다.)
        // 해당 인덱스 이전까지 먹은 먹이 수를 반환
      }
    }
    return feeds.length; // 다 먹은 것 꽉찼다.
    // feeds 배열이 꽉 차있는 경우, 배열 길이(최대 먹이 수)를 반환
  }

  //3. 출력

  void print() {
    System.out.println(this.name+"상어는 "+eat()+"마리 만큼 잡아먹었습니다.");
  }
}
public class Q1 {

  public static void main(String[] args) {

    Random r = new Random();
    FishFeed[] feeds = new FishFeed[100]; //100마리
    Shark[] shark = new Shark[5]; // 상어 5마리

    int fishCount = 0; // 상어들이 먹은 물고기 수를 추적하기 위해 사용

    // 먹이 객체 넣어주기
    for(int i = 0;i<feeds.length;i++) {
      feeds[i] = new FishFeed();
    }

    // 상어 객체 넣어주기
    for(int i = 0;i<shark.length;i++) {
      shark[i] = new Shark(Integer.toString(i+1)); // 숫자여서 에러나니까 문자로
      // 상어 객체의 이름을 1부터 순차적으로 지정

      // 진짜 먹기 랜덤수만큼. // 랜덤한 수만큼 먹이 객체를 받아와 상어 객체의 feeds 배열에 추가
      for(int j = 0;j<r.nextInt(7)+8;j++) { // 랜덤한 수는 8 ~ 14까지

        // 상어 객체가 먹이를 먹음
        shark[i].eat(feeds[fishCount++]); // 처음 먹은 다음에 그 다음 것 줘야 하므로.
        feeds[fishCount-1] = null; // 먹이 배열에서 먹은 먹이 객체를 null로 변경하여 먹은 것으로 표시
      }
      shark[i].print(); // 상어 객체의 정보 하나씩 출력
    }

  }

}

/*
만들고 먹이주고 출력 로직.


feeds[fishCount-1] = null;은
fishCount 변수가 증가될 때마다,
feeds 배열에서 상어가 먹은 물고기 객체를 참조하는 인덱스를 변경합니다.

만약 fishCount 값이 1이라면,
feeds[0] 인덱스가 첫 번째 상어가 먹은 물고기를 참조합니다.
그러나, fishCount 값이 2가 된다면,
feeds[1] 인덱스가 두 번째 상어가 먹은 물고기를 참조합니다.
즉, fishCount 변수는
상어가 먹은 물고기의 개수와
feeds 배열에서 상어가 참조할 물고기 객체의 인덱스를 추적합니다.

그러나, 위의 코드에서 fishCount-1을 사용하는 이유는
fishCount 변수가 증가될 때,
feeds 배열에서 참조할 물고기 객체의 인덱스가 1씩 증가하지만,

feeds 배열에서 삭제할 물고기 객체의 인덱스는
1씩 증가하지 않기 때문입니다.

따라서, 삭제할 물고기 객체의 인덱스를 fishCount-1로 지정해주어야 합니다.
 */