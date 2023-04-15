package mega.backend_onemore._230324;

import java.util.Random;

public class Question_full {
  public static void main(String[] args) {
    Random r = new Random();
    int[] array = new int[10];
    int max = 0;
    int maxIndex = 0;

    for (int i = 0; i < array.length; i++) {
      array[i] = r.nextInt(11);
      if (max < array[i]) { // 배열 인덱스에 들어있는 값이 최댓값에 저장되어 있는 수보다 크면
        max = array[i];  // 최댓값 변수에 이 값을 저장한다. => update
        maxIndex = i;
      }
    }
    for (int i = 0; i < array.length; i++) {
      System.out.println("index[" + i + "] : " + array[i]);
    }
    System.out.print("최댓값 : [" + maxIndex + "] " );
  }
}

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
public class Hello {
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

질문 2
public class Hello {
  public static void main(String[] args) {
    Random r = new Random();
    String result = "";
    for (int i = 0; i < 10; i++) {
      result += (char) (65 + r.nextInt(26));
    }
    System.out.print(result);
  }
}
자굼 요기서
이 코드의 뜻은, 지금 문자 A에다가 0~25사이에서 추출한 값을 더한 다음에 이걸 문자로 바꿔서 result라는 문자열에 집어 넣는다는 뜻인가요?

이 코드를 쪼개보면
    for (int i = 0; i < 10; i++) {
      int randomNumber = r.nextInt(26);
      int randomApNumber = 65 + randomNumber;
      result += (char) randomApNumber;
    } 이렇게 된다.



최댓값.
값을 일일이 하나씩 비교. 집단 내에서 가장 큰 애.
최댓값을 저장할 변수를 하나 만들고, 기존 값 저장 변수. 즉 두 개의 저울 중에 더 무거운 것을 최댓값 변수에 업데이트함.
처음부터 끝에 있는 수까지 전부 비교해야 하기 때문에 반복문이 필요하다.

public class Hello {
  public static void main(String[] args) {
    Random r = new Random();
    int[] array = new int[10];
    int max = 0;

    for(int i = 0;i<array.length;i++) {
      array[i] = r.nextInt(11);
      if(max < array[i]) { // 배열 인덱스에 들어있는 값이 최댓값에 저장되어 있는 수보다 크면
        max = array[i];  // 최댓값 변수에 이 값을 저장한다. => update
      }
    }
  }
}

    // 지금 아래 반복문은
    for (int i = 0; i<array.length; i++) {
      array[i] =r.nextInt(11);
    }
    //입력을 받고

    for (int i = 0; i<array.length; i++) {
      if(max < array[i]) {
        max = array[i];
    }
      // 최댓값과 비교해서 배열의 값이 더 크면
      // 이렇게 두 개로 쪼개서 볼 수 있다.


마지막으로, 리펙토링 가능하다.
import java.util.Random;

public class Hello {

  public static void main(String[] args) {
    Random r = new Random();
    int[] array = new int[10];
    int max = 0;
    int maxIndex = 0;

    for (int i = 0; i < array.length; i++) {
      array[i] = r.nextInt(11);
      if (max < array[i]) { // 배열 인덱스에 들어있는 값이 최댓값에 저장되어 있는 수보다 크면
        max = array[i];  // 최댓값 변수에 이 값을 저장한다. => update
        maxIndex = i;
      }
    }
    for (int i = 0; i < array.length; i++) {
      System.out.println("index[" + i + "] : " + array[i]);
    }
    System.out.print("최댓값 : [" + maxIndex + "] " );
    }
}

 */
/*
package Day08;

import java.util.Random;
import java.util.Scanner;

public class BaseBallGame {

	public static void main(String[] args) {

		//1. 컴퓨터 랜덤 숫자 생성 단, 중복제거 O
		//2. 유저 숫자 입력 단, 1~9값만 허용, 중복허용X
		//3. 컴퓨터 랜덤 숫자와 유저 입력 숫자 비교
		//3-1. 자리와 숫자가 같으면 strike
		//3-2. 숫자는 같지만 자리가 다르면 ball
		//3-3. strike, ball이 없으면 out
		//3-4. 3 strike -> 홈런 프로그램 종료
		//홈런이 나오기 전까지는 strike ball을 출력 or out 출력
		//참 쉽죠

		Random r = new Random();
		Scanner sc = new Scanner(System.in);

		int com1 = 0;
		int com2 = 0;
		int com3 = 0;
		while(com1 == com2 || com2 == com3 || com1 == com3) {
			com1 = r.nextInt(9)+1;
			com2 = r.nextInt(9)+1;
			com3 = r.nextInt(9)+1;
		}
		System.out.println(com1+","+com2+","+com3);

		//1. 클리어

		int strike = 0;
		int ball = 0;

		while(strike < 3) { // 게임이 끝날때 까지 하겠다.
			System.out.print("첫번째 숫자 : ");
			int user1 = sc.nextInt();
			System.out.print("두번째 숫자 : ");
			int user2 = sc.nextInt();
			System.out.print("세번째 숫자 : ");
			int user3 = sc.nextInt();

			// 2번클리어
			if(user1 == user2 || user2 == user3 || user1 == user3 ||
					user1 < 1 || user1 >9 || user2 < 1 || user2 >9 ||
					user3 < 1 || user3 >9 ) { // 입력값에 중복된 숫자가 있거나 1 미만, 혹은 9 초과의 수를 입력한 경우
				System.out.println("잘못된 입력입니다.");
			}
			else {// 3번으로 고
				strike = 0;
				ball = 0;
				//3-1
				// 원래는 상식적으로 입력받은 숫자로 자리가 같냐 다르냐를 판단해야하지만, 컴퓨터는 멍청해서 그런걸 할 수가 없어요.
				// 그래서 판단하는 중요한 근거가 바로, 변수 이름!
				if(user1 == com1) {
					strike++;
				}
				if(user2 == com2) {
					strike++;
				}
				if(user3 == com3) {
					strike++;
				}
				//3-2
				if(user1 == com2 || user1 == com3) {
					ball++;
				}
				if(user2 == com1 || user2 == com3) {
					ball++;
				}
				if(user3 == com1 || user3 == com2) {
					ball++;
				}

				//3-3
				if(strike == 0 && ball == 0) {
					System.out.println("OUT 입니다.");
				}
				else if(strike == 3) {
					System.out.println("홈런입니다.");
				}
				else {
					System.out.println("strike : "+strike+", ball : "+ball);
				}
			}
		}
	}
}
 */
/*
이걸 배열로 바꾸는 숫자야구에서 i--; 부분이 이해하기 힘들어요.
		for(int i = 0;i<com.length;i++) {
			com[i] = r.nextInt(9)+1;   // 예를 들면 com[0] = 8 com[1] = 7 com[2] = 7
			for(int j = 0;j<i;j++) {
				if(com[i] == com[j]) {
					i--; // i의 값을 변동시켜 com[i]에 계속 다른 값을 넣기 위함. 결국 i가 3이 되고 [0], [1], [2]의 값이 모두 다르면 탈출함.
					break;
				}
			}
		}

		이건 보면, 아까 위에서 증감식 없는 for문이 뭐였는지 개념을 다시 살펴보면 된다.
		그것은 무엇이었냐면,
		반복을 돌면서, 내가 원하는 경우에만 증가를 시켜주는 게 있었잖아. 그거랑 동일하다고 여기면 된다.
		그러니까, 내가 원하지 않는 입력(com[i] == com[j]. 즉 두 수가 같은 경우 숫자야구의 의미가 없으니까...) 일 때는
		그 수도 빼버리고, 반복 횟수도 제외해버리면 되지.
		그게 i--;

-----------
// 현재 조건,
// 자리 && 숫자 => 스트라이크 / 숫자 같으면 => 볼
// 여기서 공통된 것은 숫자!. 그래서 숫자를 보는 거다.
for(int i = 0;i<user.length;i++) {  //0일때 0 1 2 다 비교  / 1일때 0 1 2 다 비교/ 2일 때 0 1 2 다 비교
				for(int j = 0;j<com.length;j++) {
					if(user[i] == com[j]) { // i, j의 인덱스는 신경쓰지 않아도 된다. 숫자가 같니?
						if(i==j) { // 위치도 같니?
							strike++;
						}
						else {
							ball++;
						}
					}
				}
			}

			이거 좀 헷갈릴 수도 있어, 그냥 짤 때는 스트라이크, 볼 따로 짰는데, 이건 합쳐놨으니까.






---------
Random r = new Random();
		Scanner sc = new Scanner(System.in);

		int[] com = new int[3];
		// 무슨소리지? 난 알 수가 없는데..

		int[] user = new int[3];

		for(int i = 0;i<com.length;i++) {
			com[i] = r.nextInt(9)+1;   // 예를 들면 com[0] = 8 com[1] = 7 com[2] = 7
			for(int j = 0;j<i;j++) {
				if(com[i] == com[j]) {
					i--; // i의 값을 변동시켜 com[i]에 계속 다른 값을 넣기 위함. 결국 i가 3이 되고 [0], [1], [2]의 값이 모두 다르면 탈출함.
					break;
				}
			}
		}
		System.out.println(com[0]+","+com[1]+","+com[2]);

		//1. 클리어

		int strike = 0;
		int ball = 0;

		while(strike < 3) {
			for(int i = 0;i<user.length;i++) {
				System.out.print((i+1)+"번째 숫자 : ");
				user[i] = sc.nextInt();
				//범위 1~9 아닌경우
				if(user[i]<1 || user[i] >9) {
					System.out.println("잘못된 입력입니다.");
					i--;
					continue;
					// 그 값만 보면 되기 때문에 반복문 안 쓴다.
				}
				//값이 중복되는 경우
				for(int j = 0;j<i;j++) { // 일일이 확인해줘야 하기 때문에 밤복문 출력
					if(user[i] == user[j]) {
						System.out.println("잘못된 입력입니다.");
						i--;
						break;
					}
				}
			}

			strike = 0;
			ball = 0;
			//이거 이해 못하면 안된다.
			for(int i = 0;i<user.length;i++) {  //0일때 0 1 2 다 비교  / 1일때 0 1 2 다 비교/ 2일 때 0 1 2 다 비교
				for(int j = 0;j<com.length;j++) {
					if(user[i] == com[j]) { // i, j의 인덱스는 신경쓰지 않아도 된다.
						if(i==j) {
							strike++;
						}
						else {
							ball++;
						}
					}
				}
			}

			//3-3
			if(strike == 0 && ball == 0) {
				System.out.println("OUT 입니다.");
			}
			else if(strike == 3) {
				System.out.println("홈런입니다.");
			}
			else {
				System.out.println("strike : "+strike+", ball : "+ball);
			}
		}
-------------

치환
a=10;
b=20;
나는 최종적으로 a와 b의 값을 서로 바꾸고 싶어.

일단 a에 20 값을 넣어버리면, 10 들어있는 값이 사라지지. 그래서 얘를 백업할 데이터 공간이 필요하다.
변수는 그냥 a와 b를 옮길 때 필요한 껍데기
int temp;

그래서 그 과정을 해보면
temp = a; // 일단 a값을 임시변수에 저장
a = b; 그리고 a에는 b를 저장
b = temp; 마지막으로 b에는 임시변수에 저장해뒀던 원래 a값을 저장
// 그러면 두 값이 바뀌게 된 것.


//잘못된 입력
			if(h<1 || h >9 || y >2 || y<1) {
				System.out.println("잘못된 입력입니다.");
			}
			else {
				//예약 여부확인
				// 그러니까 이 비즈니스 로직에서는 0이면 예약이 안 되어 있는 상태이고,
				// 1 이상이면 예약이 되어있는 것.
				if(seat[h-1][y-1] == 0) { // 사람이 입력한 숫자와 컴퓨터가 인식하는 숫자는 1 차이가 나므로, 빼줘야.
					System.out.println("예약이 완료 됐습니다.");
					count--;
					seat[h-1][y-1]++;
				}
				else {
					System.out.println("비어있는 좌석 ");
					for(int i = 0;i<seat.length;i++) {
						for(int j = 0;j<seat[i].length;j++) {
							if(seat[i][j] == 0) { // 이것은 빈 자리가 있다(예약이 가능하다)
							// 여기서 i와 j는 0부터 시작하도록 세팅을 해줬으니 -1을 굳이 해주지 않아도 됐던 것.
								System.out.println("행 : "+(i+1)+"열 : "+(j+1)); // 이건 사용자한테 보여주는 것이므로, 다시 +1 씩 해준다는 것.
							}
						}
					}



 */

