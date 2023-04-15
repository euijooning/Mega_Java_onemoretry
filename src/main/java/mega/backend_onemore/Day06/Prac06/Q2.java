package mega.backend_onemore.Day06.Prac06;

/*
문자 A(65)에서 랜덤 0~25 값을 추출한 이후에 더하기 연산을 해서 랜덤한 문자를 만듭니다.
이 랜덤한 문자를 만드는 작업을 10번 실행해서
10개 문자를 더하기 연산을 해서 하나의 문자열로 만듭니다.
10개 문자 출력하세요.
중복 상관 없습니다.
 */

/*
1. 랜덤 클래스 생성
2. 빈 문자열 생성
3. 반복문 돌기
3-1. 랜덤수 추출하여 변수에 저장
3-2. 추출한 랜덤수와 65를 더하여 다른 변수에 저장
3-3. 더한 수를 문자열로 형변환하여 빈 문자열에 계속 더해주기
		result += (char) 더한 수;
4. 결과 문자열 출력
*/

import java.util.Random;

public class Q2 {

  public static void main(String[] args) {

    // 랜덤 클래스 생성 + 하나의 문자열로 만들라고 했으므로, 빈 문자열도 생성.
    Random r = new Random();
    String result = ""; // 빈 문자열

    for (int i = 0; i<10; i++) {
      result += (char)(65 + r.nextInt(26));
      /*
      쪼개보면, 1. 랜덤수 추출 / 2. 65 + 추출한 랜덤수 / 3. 문자형변환 + result에 저장
      int randomNumber = r.nextInt(26);
      int randomApNumber = 65 + randomNumber;
      result += (char) randomApNumber;
      }
       */
    }
    System.out.print(result);
  }

}
