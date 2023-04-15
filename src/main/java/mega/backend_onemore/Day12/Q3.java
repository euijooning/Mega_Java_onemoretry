package mega.backend_onemore.Day12;

import java.util.Random;

/*
1. 랜덤 수 만드는 메서드 주고 안받고
- 랜덤클래스 생성, 그리고 그것 그대로 리턴 가능
2. 65와 합치는 메서드 주고 받고
- 랜덤수 만들기에서 생성된 수를 받고
- 더한 값을 그대로 리턴
3. 문자 만들기, 주고 받고
- 결과를 받아서(result)
- (char) result한 값을 리턴
4. 문자열 만들기 주고 받고
- 문자(ch) 를 받아서
- ch + ""; 의 형태를 리턴
5. 전체 연산(run) 안주고 안받고
- 문자열 하나 생성하면 됨 String result = "";
for문으로 10번 돌면서
result += makeString(makeChar(intSum(makeRandom())))
6. 문자 출력 안주고 받고
- 만들어진 String str을 받아서
  str을 출력해주면 됨

7. main에서
run(); 만 부르면 끝
 */

public class Q3 {

  // 주고 안받고
  static int makeRandom() {
    Random r = new Random();
    return r.nextInt(26);
  }

  // 주고 받고
  static int intSum(int r) {
    return 65 + r;
  }

  // 주고 받고 문자열 만들기
  static char makeChar(int result) {
    return (char) result;
  }

  // 안주고 안받고 랜덤한 문자 받기 10번 수행
  static void run() {
    String result = "";
    for (int i = 0; i < 10; i++) {
      result += makeString(makeChar(intSum(makeRandom())));
    }
    printString(result);
  }

  // 주고 받고 10개 문자를 더하기 연산
  static String makeString(char ch) {
    return ch + "";
  }

  // 안주고 받고 문자 출력
  static void printString(String str) {
    System.out.println(str);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    run();
  }


}
