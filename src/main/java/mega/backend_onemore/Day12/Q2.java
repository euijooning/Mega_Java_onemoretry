package mega.backend_onemore.Day12;

import java.util.Scanner;

/*
1. 입력 메서드, 주고 안받고
- 스캐너 생성, 입력값 저장할 1차원 배열 생성
- 배열을 리턴

2. 사각형 메서드, 주고 받고
- 배열 자체를 매개변수로 받고
- 배열의 계산 값(array[0]*array[1])이 int이므로 그대로 리턴

3. 삼각형 메서드, 안주고 받고
- 역시 이것도 배열 자체를 매개변수로 받고
- 출력 자체를 계산한 값을 그대로 본문에 작성
 -- System.out.print("삼각형 넓이 : " + (array[0] * array[1] / 2)

 4. main
 1) 스캐너 생성
 2) while(true)
 - 메뉴 입력하는 숫자 입력
 if문 분기
 - 1번 선택하면 사각형
 System.out.println("사각형 넓이 : " + rect(input()));
 - 2번 선택하면 삼각형
  tri(input());
 - 3번 선택하면 종료
 break

- 잘못된 입력

 */
public class Q2 {

  static int[] input() {
    Scanner sc = new Scanner(System.in);
    int[] a = new int[2];
    System.out.print("1.가로 : ");
    a[0] = sc.nextInt();
    System.out.print("2.세로 : ");
    a[1] = sc.nextInt();
    return a;
  }

  static int rect(int[] array) { //주고 받고
    return array[0] * array[1]; // 이거 int이다.
  }

  static void tri(int[] array) { //안주고 받고
    System.out.println("삼각형 넓이 : " + (array[0] * array[1] / 2));
  }


  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.print("1. 사각형 넓이 2.삼각형 넓이 3. 종료");
      int num = sc.nextInt();
      if (num == 1) {
        //1. 가로 세로 입력
        //2. 사각형 넓이 구하는 함수 호출
        System.out.println("사각형 넓이 : " + rect(input()));
        //rect 안에 int배열을 받아야 하므로, 그 자체의 값이 input()
        // 왜 배열을 받아야 하냐면, 가로 세로 두 개의 값을 받아야 하잖아.

      } else if (num == 2) {
        //1. 가로 세로 입력
        //2. 삼각형 넓이 구하는 함수 호출
        tri(input());
        //tri 함수는 매개변수로 int 배열 받고 있는데, 역시 그 자체의 값이 input()의 결과
        // 매개변수는 리턴 타입만 맞으면 함수로도 할 수 있다.

      } else if (num == 3) {
        System.out.println("종료합니다.");
        break;
      } else {
        System.out.println("잘못된 입력입니다.");
      }
    }
  }

}


