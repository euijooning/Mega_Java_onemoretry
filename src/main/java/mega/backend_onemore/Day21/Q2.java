package mega.backend_onemore.Day21;

import java.util.Scanner;

public class Q2 {

  // 1. 입력
  static String input() {
    Scanner sc = new Scanner(System.in);

    System.out.print("입력 : ");
    return sc.next();
  }
  //2-1 숫자를 자르작업  1122335*#66
  static String makeResult(String str) {
    String result = "";
    char ch = str.charAt(0); //1
    int count = 0;
    for(int i = 0;i<str.length();i++) {
      if(ch == str.charAt(i)) { // 같을경우
        count++;
      }
      else { //다른경우
        //1. 문자, 카운터를 보내 결과 문자를 받아야 합니다.
        result += makeChar(ch, count); // result = result + makeChar(ch, count)
        //2. ch를 그다음 문자로 변경
        ch = str.charAt(i);
        //3. 카운터 초기화
        count = 1;
        // 여기서 count를 1로 초기화 하는 이유는,
        // 0이 되면, 비교할 숫자가 바뀌었을 때, 해당 인덱스를 건너 뛰고 가버린다.
        // 그래서 굳이 하나 일부러 증가시키고 반복문 다시 타게 만드는 것.
      }
    }

    result += makeChar(ch, count);
    // 이것은

    return result;
  }

  static String makeChar(char ch, int count) {
    String result = "";
    char [][] key ={
        {'A','B','C'},  //1
        {'D','E','F'},  //2
        {'G','H','I'},  //3
        {'J','K','L'},  //4
        {'M','N','O'},  //5
        {'P','Q','R'},  //6
        {'S','T','U'},  //7
        {'V','W','X'},  //8
        {'Y'}, // 9
        {'*'},
        {'Z'}, //0
        {'#'}
    };

    if(ch == '9') {
      for(int i = 0;i<count;i++) {
        result += key[8][0];
      }

    }
    else if(ch == '*') {
      for(int i = 0;i<count;i++) {
        result += key[9][0];
      }
    }
    else if(ch == '0') {
      for(int i = 0;i<count;i++) {
        result += key[10][0];
      }
    }
    else if(ch == '#') {
      for(int i = 0;i<count;i++) {
        result += key[11][0];
      }
    }
    else {
      if(count <= 3) {
        count--;
      }
      else {
        count = (count-1) % 3;
      }
      // '0' = 45 - '0' 45 => 0
      // '1' = 46 - '0' 45 => 1
      result += key[(ch-'0')-1][count];
    }
    return result;
  }

  static void output(String str) {
    System.out.println("결과 : "+str);
  }

  public static void main(String[] args) {
    // 2. 입력한 값 -> 문자열 변경
    // 2-1 숫자를 자르작업
    // 2-2 숫자를 -> 문자로 변경하는 작업
    // 3. 출력
    output(makeResult(input()));
  }
}

