package mega.backend_onemore.Day20.Prac20;

import java.util.Scanner;

public class Q2 {
  // 1. 입력
  static String input() {
    Scanner sc = new Scanner(System.in);

    System.out.print("입력 : ");
    return sc.next();
  }
  //2-1 숫자를 자르는 작업  ex) 1122335*#66
  static String makeResult(String str) {
    String result = "";
    char ch = str.charAt(0); // 현재 문자
    int count = 0; // 연속으로 나타난 문자의 수

    // 문자열 탐색
    for(int i = 0;i<str.length();i++) {
      if(ch == str.charAt(i)) { // 현재 문자와 같은 경우
        count++; // 연속된 문자의 수 증가
      }
      else { // 다른 문자인 경우
        //1. 문자, 카운터를 보내 결과 문자를 받아야 합니다.
        // 현재 문자와 연속된 문자의 수를 이용해 새로운 문자열을 생성
        result += makeChar(ch, count);
        // result = result + makeChar(ch, count)
        // 이 결과를 반드시 어딘가에 저장 필요
        // 그래서 앞에까지의 결과를 result문자열에 저장

        //2. ch를 그다음 문자로 변경
        ch = str.charAt(i);
        // 예를 들어 지금 이 상황에서는 기준점으로 2가 들어가는데,
        // 3번째 요소니까 인덱스로 하면 인덱스 2.
        // 따라서 i는 2가 되는 것임.


        //3. 카운터 초기화 // 연속된 문자의 수 초기화
        count = 1; // 즉 i의 기준이 다르니까 여기서 하나를 세고 넘긴다.
        // 또는
        /*
        count = 0;
        i--;
         */
        /*
        지금 이 코드에서는 if 부분이 세는 로직인데,
        ch = str.charAt(i); 여기서 세는 부분으로 가는 방법은
        끝나고 다음 반복 때 가는 경우밖에 없음.
        즉, str.charAt(i)얘인 채로 다음 반복을 맞이해야 하나,
        반복이 끝나고 나면 i가 1 증가가 되어서
        count++를 계획대로 만나지 못하게 된다는 소리.
        예를 들어 str.charAt(i);가 2였으면 2인 상태로 count++
        를 만나야 하는데 반복문이 끝나면 3인 상태로 만나게 된단 말.
        즉, 2일 때가 카운트가 안 되고 건너뛰어졌다는 소리.


         */
      }
    }
    // 마지막 문자와 연속된 문자의 수를 이용해 문자열 생성
    // 같을 때는 결과를 만들지 않아서!
    // 마지막 인덱스가 없으므로, 이 작업을 굳이 한 번 해줘야 결과에 포함이 된다.
    result += makeChar(ch, count);

    return result;
  }

  // 2-2. 숫자를 문자로 변환하는 함수
  // 어떤 문자인지(ch), 몇 번 눌렸는지(count)
  static char makeChar(char ch, int count) {
    char result;
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
    // 숫자 9, *, 0, #인 경우 처리
    // 몇 번 눌렸는지 관심이 없음.
    if(ch == '9') {
      result = key[8][0];
    }
    else if(ch == '*') {
      result = key[9][0];
    }
    else if(ch == '0') {
      result = key[10][0];
    }
    else if(ch == '#') {
      result = key[11][0];
    }
    // 숫자 1~8인 경우 처리
    // 몇 번 눌렸느냐에 따라 문자가 달라짐.
    else {
      // 연속된 문자의 수에 따라 인덱스 값 조정
      if(count <= 3) { // 정상적으로 눌림 -> 하나의 문자를 반환
        count--; // (카운트 - 1)을 결과 문자 인덱스로 사용
        // 인덱스 매핑(3번 눌렀을 때 인덱스 2로 가야하니까)
      }
      else { // 카운트가 4 이상인 경우
        count = (count-1) % 3;
        // (카운트 - 1) % 3을 결과 문자 인덱스로 사용
        // count-1은 인덱스 매핑
        // %3은 처음으로 되돌리기
        // 1억번이 되더라도 3으로 나눈 나머지만큼만 움직이면 되지.
      }
      // '0' = 45 - '0' 45 => 0
      // '1' = 46 - '0' 45 => 1
      // 숫자에 해당하는 문자 생성 // 결과 문자 설정
      result = key[(ch-'0')-1][count];
      // 여기 역시도 -1은 인덱스 매핑
      // 앞의 행은 몇 번 눌렀냐고, 뒤의 count는 해당하는 문자
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
    // makeResult 메소드를 호출하여 결과 문자열 생성 후
    // output 메소드를 호출하여 출력
  }
}

/*
1. input() 함수는 사용자로부터 입력을 받습니다.

2. makeResult() 함수는 입력받은 숫자를 문자열로 변환하는 함수입니다.
이 함수는 다음과 같은 작업을 수행합니다.
2-1. 입력된 숫자 문자열에서 첫 번째 문자를 ch에 저장합니다.
2-2.반복문을 통해 문자열을 처음부터 끝까지 탐색합니다.
2-3,탐색 중 현재 문자가 ch와 같으면 count를 1 증가시킵니다.
2-4. 만약 현재 문자가 ch와 다르다면, ch와 count를 이용해
결과 문자열 result에 문자를 추가합니다.
2-5. 마지막 문자까지 탐색한 후,
마지막 문자와 count를 이용해 result에 문자를 추가합니다.
2-6. 최종적으로 result를 반환합니다.
2-7. makeChar() 함수는 입력받은 문자와 해당 문자가 반복된 횟수를 이용해
전화번호의 문자로 변환하는 함수입니다.
이 함수는 다음과 같은 작업을 수행합니다.
2-8. 입력받은 문자 ch가 '9', '*', '0', '#' 중 하나라면
해당하는 문자를 result에 저장합니다.
2-9. 만약 ch가 '1'부터 '9'까지의 숫자라면,
ch와 count를 이용해 key 배열에서 해당하는 문자를 찾아 result에 저장합니다.
2-10. result를 반환합니다.

3..output() 함수는 최종적으로 결과 문자열을 출력합니다.
4. main() 함수는 위의 함수들을 이용해 전체적인 프로그램의 작동을 구현합니다.
입력받은 숫자를 문자열로 변환한 후, 결과 문자열을 출력합니다.

우선 코드의 실행은 main 함수에서 시작됩니다.
main 함수는 input() 함수를 호출하여
사용자로부터 문자열 입력을 받습니다.

makeResult(String str) 함수는 입력받은 문자열을 압축하는 함수입니다.
이 함수에서는 입력된 문자열을 하나씩 탐색하면서
문자가 바뀔 때마다 그 문자가 몇 번 연속으로 나타났는지 세어주고,
그에 해당하는 문자를 만드는 makeChar(char ch, int count) 함수를 호출합니다.

makeChar(char ch, int count) 함수에서는
입력받은 ch와 count 값을 이용해 문자를 만듭니다.
이 함수에서는 전화기의 숫자 키패드를 이용해 각 숫자에 해당하는 문자를 만듭니다.
만약 ch 값이 9, *, 0, #인 경우에는 각각 Y, *, Z, #으로 처리합니다.
만약 ch 값이 1부터 9까지인 경우에는
count 값에 따라 각 숫자에 해당하는 문자를 만듭니다.

마지막으로 output(String str) 함수에서는
압축된 문자열을 출력합니다.
이 함수는 makeResult(String str) 함수에서
반환된 문자열을 받아 출력하는 역할을 합니다.
 */

/*
    else {
      result = key[(ch-'0')-1][(count-1) % 3];
    }
    return result;
  }

  이렇게 해도 될 듯
 */