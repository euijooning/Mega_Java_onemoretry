package mega.backend_onemore.Day12;

import java.util.Scanner;

// 1. add, 주고 받고
// 2. minus, 안주고 받고
// => 출력 부분을 아예 여기서 작성해주면 됨.

// 3. mul, 주고 안받고
// => 연산을 해야 하는데, 여기서는 받아서 계산해야 하는데 그 수가 없으니까
// 아예 스캐너를 이 메서드 안에서 생성
// 그리고 받은 값을 그 배열에 저장
// 배열의 [0], [1]에 있는 인덱스 값을 리턴

// 4. 안주고 안 받고
// 3번과 원리는 비슷.
// 스캐너 여기서 직접 만들고
// 배열에 저장
// 리턴은 없으므로 직접 여기서 계산 결과 출력문을 작성

// 5. 인풋 메서드
// 2칸짜리 1차원 배열 받고, 그 두개 값을 a[0], a[1]에 저장, a배열 리턴

// 6. main 메서드
// 1) 스캐너 생성하고 연산자 입력
// 2) 더하기 빼기는 메서드에서 받은 값을 그대로 쓸 것이므로
//    int[] array=input(sc) 로 받은 값을 저장
//    리턴 값 그대로 출력(배열의 인덱스로 바꿔서)
// 3) 곱하기 나누기는 메서드에서 직접 연산을 수행하고, 스캐너도 메서드 내에
// 형식에 맞춰 불러오기
// 4) 잘못된 입력

public class Q1_1 {
  static int add(int a, int b) {
    return a + b;
  }

  static void minus(int a, int b) {
    System.out.println("결과값 : "+(a-b)+" 입니다.");
  }

  static int mul() {
    Scanner sc = new Scanner(System.in);//여기는 받는 게 없는데, 계산은 해야하니까 스캐너를 여기서 만듦.
    int[] array =input(sc); // 그리고 이 입력받은 값을 int 배열에 저장해놓고 써야지
    return array[0] * array[1];
  }
  static void div() {
    Scanner sc = new Scanner(System.in);
    int[] array =input(sc);
    System.out.printf("결과값 : %.1f 입니다.", (double)array[0]/(double)array[1]);
  }

  static int[] input(Scanner sc) {
    int[] a = new int[2];
    System.out.print("숫자1 입력 : ");
    a[0] = sc.nextInt();
    System.out.print("숫자2 입력 : ");
    a[1] = sc.nextInt();
    return a;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    //1. 입력
    System.out.print("연산자 입력 : ");
    String op = sc.next(); //위로 뺀다
    // 스캐너 숫자 입력은 자체에서 할 것이므로.
    // 매개변수 안 받는 애들이 문제이기 때문에 걔네들은 직접 메서드 안으로 들어가서 입력값을 받아줘야 한다.

    if(op.equals("+")) {
      int[] array=input(sc); // 아래에서 입력받은 값을 쓸거잖아. 그래서 int 배열 변수에 저장해준다.
      System.out.println("결과값 : "+(array[0]+array[1])+" 입니다.");
    }
    else if(op.equals("-")) {
      int[] array=input(sc);
      System.out.println("결과값 : "+(array[0]-array[1])+" 입니다.");
    }
    else if(op.equals("*")) {
      System.out.println("결과값 : "+mul()+" 입니다.");
    }
    else if(op.equals("/")) {
      div();
    }
    else {
      System.out.println("잘못된 연산자 입니다.");
    }
  }

}


