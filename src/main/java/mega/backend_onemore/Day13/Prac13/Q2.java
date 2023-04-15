package mega.backend_onemore.Day13.Prac13;

import java.util.Scanner;

/*
1. 문자열 입력 메서드 / 주고 안받고
2. 짝수 홀수 입력 메서드 / 주고 안받고
3. 홀짝 출력 메서드 / 안주고 받고
- 입력받은 숫자와 문자열을 받아서
- for문을 돌면서.. 아래와 같은 행위 수행
  System.out.print(str.charAt(i));
- 잘못 입력했으면 잘못된 입력 출력
 */
/*
  for문에서 i는 num - 1로 초기화되고,
  i가 문자열의 길이보다 작은 동안 반복됩니다. 반복문에서 i는 2씩 증가합니다.

  즉, 입력받은 num이 1이라면 i는 0번째부터 시작하여 짝수번째 문자를 출력하고,
  2라면 i는 1번째부터 시작하여 홀수번째 문자를 출력합니다.

  예를 들어, 입력된 문자열이 "abcdefg"이고 num이 1인 경우,
  i는 0부터 시작하여 문자열의 길이보다 작은 동안 2씩 증가합니다.
  따라서, i가 0, 2, 4번째일 때 "a", "c", "e"를 순서대로 출력합니다.
*/
/*
4. run() 메소드 / 안주고 받고
- 입력받은 num과 str을 받아야 하고
- num이 1 또는 2에 해당했을 때 printHJ() 수행
- 아니면 잘못된 입력

5. main
run() 만 있으면 되고, 매개변수로
inputString(), inputNum() 이걸 직접 수행

 */



public class Q2 {

  // 1. 문자열 입력 메서드 / 주고 안받고
  static String inputString() {
    Scanner sc = new Scanner(System.in);
    System.out.print("문자열 입력하세요 : ");
    return sc.next();
  }

  // 2. 짝수 홀수 입력 메서드 / 주고 안받고
  static int inputNum() {
    Scanner sc = new Scanner(System.in);
    System.out.print("1. 짝수 2 홀수 : ");
    return sc.nextInt();
  }

  // 3. 홀짝 출력 메서드 / 안주고 받고
  static void printHJ(int num, String str) {
    for (int i = num - 1; i < str.length(); i += 2) {
      System.out.print(str.charAt(i));
    }
  }
  /*
  for문에서 i는 num - 1로 초기화되고,
  i가 문자열의 길이보다 작은 동안 반복됩니다. 반복문에서 i는 2씩 증가합니다.

  즉, 입력받은 num이 1이라면 i는 0번째부터 시작하여 짝수번째 문자를 출력하고,
  2라면 i는 1번째부터 시작하여 홀수번째 문자를 출력합니다.

  예를 들어, 입력된 문자열이 "abcdefg"이고 num이 1인 경우,
  i는 0부터 시작하여 문자열의 길이보다 작은 동안 2씩 증가합니다.
  따라서, i가 0, 2, 4번째일 때 "a", "c", "e"를 순서대로 출력합니다.
   */

  // 4. run() 메소드 / 안주고 받고
  static void run(String str, int num) {
    if (num == 1 || num == 2) { // 홀수 혹은 짝수에
      printHJ(num, str);
    } else {
      System.out.println("잘못된 입력입니다.");
    }
  }

  public static void main(String[] args) {

    run(inputString(), inputNum());
  }

}
