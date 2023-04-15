package mega.backend_onemore.Day08;

import java.util.Random;

public class BBGame_Question {
/*

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


 */

}
