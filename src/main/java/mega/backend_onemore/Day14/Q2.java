package mega.backend_onemore.Day14;

import java.util.Random;
import java.util.Scanner;

public class Q2 {

  static int[] randomMake(Random r) {
    int[] com = new int[3];
    for(int i = 0;i<com.length;i++) {
      com[i] = r.nextInt(9)+1;   // com[0] = 8 com[1] = 7 com[2] = 7
      for(int j = 0;j<i;j++) {
        if(com[i] == com[j]) {
          i--;
          break;
        }
      }
    }
    return com;
  }

  static void comPrint(int[] com) {
    System.out.println(com[0]+","+com[1]+","+com[2]);
  }

  static int[] userInput(Scanner sc) {
    int[] user = new int[3];
    for(int i = 0;i<user.length;i++) {
      System.out.print((i+1)+"번째 숫자 : ");
      user[i] = sc.nextInt();
      //범위 1~9 아닌경우
      if(user[i]<1 || user[i] >9) {
        System.out.println("잘못된 입력입니다.");
        i--;
        continue;
      }
      //값이 중복되는 경우
      for(int j = 0;j<i;j++) {
        if(user[i] == user[j]) {
          System.out.println("잘못된 입력입니다.");
          i--;
          break;
        }
      }
    }
    return user;

  }

  static void SBCount(int[] user, int[] com, int[] result) {
    result[0] = 0;
    result[1] = 0;
    for(int i = 0;i<user.length;i++) {
      for(int j = 0;j<com.length;j++) {
        if(user[i] == com[j]) {
          if(i==j) {
            result[0]++;
          }
          else {
            result[1]++;
          }
        }
      }
    }
  }

  static void resultPrint(int[] result) {
    if(result[0] == 0 && result[1] == 0) {
      System.out.println("OUT 입니다.");
    }
    else if(result[0] == 3) {
      System.out.println("홈런입니다.");
    }
    else {
      System.out.println("strike : "+result[0]+", ball : "+result[1]);
    }
  }

  static boolean gameRunCheck(int strike) {
    if(strike == 3) {
      return false;
    }
    else {
      return true;
    }
  }
  /*
  static boolean gameRunCheck(int[] result) {
    if(result[0] == 3) {
      return false;
    }
    else {
      return true;
    }
  }
  */
  public static void main(String[] args) {
    Random r = new Random();
    Scanner sc = new Scanner(System.in);
    int[] com = randomMake(r);
    comPrint(com);
    int[] result = new int[2];
    while(gameRunCheck(result[0])) {
      SBCount(userInput(sc), com, result);
      resultPrint(result);
    }
  }

}
