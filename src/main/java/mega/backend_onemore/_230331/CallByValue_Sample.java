package mega.backend_onemore._230331;

// 어떻게 보면 자바에서는 그냥 통칭하여 call by value라고 할 수도 있음.
  /*
  예시, swap이란 함수를 써서 값을 바꾸기만 했으면 좋겠다.
  */
public class CallByValue_Sample {

  static void swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;

    System.out.println(a); // 20 출력
    System.out.println(b); // 10 출력
  }


  public static void main(String[] args) {
    int a = 10;
    int b = 20;

    swap(a, b);

    System.out.println(a); // 10 출력
    System.out.println(b); // 20 출력

  }
}

/*
일단 지금 변수 a와 b를 main에서 만들었다.
그럼 main에는 이 함수만을 위한 공간이 따로 있다고 생각하면 됨.
여기에 a라는 공간이 만들어지고 여기에 값이 10이 들어가는 상황
b도 만들어지고 여기에 값이 20이 들어가는 상황이다.

또 swap을 불렀으니까, 함수 스택이 만들어지고,
파라미터로 받은 int a와 int b를 위한 공간이 만들어지고
그 공간에 10과 20이 들어간다.

그런데 이 공간 a와 b는 서로 완전히 독립적이라서
main과 swap 스택은 서로 아무 영향을 주지 않는다.

그리고 그 다음에 어떤 일이 일어나냐면
swap에 a와 b를 넘긴다는 건
원본이 넘어간다는 것이 아니라, 가지고 있는 값이 "복사된 값이 넘어간다"는 뜻이다.
그러니까 핵심은 파라미터로 값을 가져올 때, 값만 가져오는 거지,
main에 선언된 원본을 가져오는 건 아니라는 뜻.

즉 a를 가져오고 b를 가져오는 것이 아니라
a에 담겨있는 10만 가져오고 b에 담겨있는 20만 가져와서 파라미터로 넣는다!

따지고 보면 main에서의 a, b와
swap 에서의 a, b 가 공존하는 모양새이다.

그래서 swap은 잘 되고, a와 b의 값은 서로 바뀌고
출력을 찍어보면 바뀐 채로 잘 나온다.

그런데, 중괄호가 닫히면 함수는 끝난다!

그럼 swap이란 공간이 날아간다.
main만 다시 남게 되는 건데,

main에서의 a, b는 swap에서의 a, b와 전혀 관련이 없기 때문에(독립적)
main에서 a와 b의 값을 출력해보면, 원래 선언한 그대로의 값인
a = 10,
b = 20 이 출력된다.
 */
