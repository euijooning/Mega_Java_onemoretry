package mega.backend_onemore._230324;

public class ForExplain {
  public static void main(String[] args) {


  /*
    for(초기식; 조건식; 증감식){

        }
세미콜론은 이를 구분하는 용도로만 사용하기 때문에 증감식 끝에는 세미콜론이 들어가지 않는다고 이해해도 된다.
그래서 for(; ;) 이것도 가능
아무 조건도 주지 않으면 무한히 반복된다.

반복문 초기식 => 반복변수
초기식을 안 써도 되는 경우 : 밖에서 이미 반복변수를 만들어 놨을 때.
public class Hello {
  public static void main(String[] args) {
    int i = 0;
    for (; i < 10; i++) {
    }
  }
}
    이렇게 쓸 수 있다. for문에서만 쓰고, 끝나면 죽게 만드는 변수.

조건이 없으면, 무한반복
키오스크 등.

조건식이 없는 경우: 사용자가 어떤 조건을 만족했을 때만 탈출하고, 그렇지 않은 경우에는 무한반복하고 싶다!
public class Hello {

  public static void main(String[] args) {

    int i = 0;
    Scanner scanner = new Scanner(System.in);

    for (; ;i++) {
      int inputNum = scanner.nextInt();
      if(inputNum == 1) {
        break;
      }
    }

    또는
    while(true) {
      int inputNum = scanner.nextInt();
      if(inputNum == 0) {
        break;
      }
    }
  }
}
요런 식으로,,,

증감식은 없어도 되고, 두 개가 들어가도 된다.
증감식은 사실 잘못된 말일 수도 있다.

public class Hello {
  public static void main(String[] args) {
    for(int i = 0; i<10; System.out.println("반복끝")) {
      i++;
    }
  }
}
정확하게 말하면, 반복이 끝날때마다 할 일.
또 다른 예시, 이런 것도 가능함
public class ForExplain {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();
    for (int i = 0; i < 10; ) {
      if (input % 2 != 0) {

      } else {
        i++;
      }
    }
  }
}
이것은 내가 원하는 경우만 카운트를 한다는 뜻.
*/
  }
}
