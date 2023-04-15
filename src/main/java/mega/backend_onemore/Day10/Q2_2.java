package mega.backend_onemore.Day10;
// 역방향
/*
1번은 동일함.

2.
정방향은 짝수
if(i%2 == 0)
for(int j = 0;j<b[i].length;j++) {
역방향은 홀수
else
for(int j = b[i].length-1;j>=0;j--)

3. 출력하기
 */

public class Q2_2 {

  public static void main(String[] args) {

    int[][] array = new int[5][5];
    int count = 1;

    //여러분이 좋아하는 유형
    for(int i = 0;i<array.length;i++) {
      if(i%2 == 0) { // 정방향
        for(int j = 0;j<array[i].length;j++) {
          array[i][j] = count++;
        }
      }
      else { // 역방향
        for(int j = array[i].length-1;j>=0;j--) {
          array[i][j] = count++;
        }
      }
    }

    for(int i = 0;i<5;i++) {
      for(int j = 0;j<5;j++) {
        System.out.print(array[i][j]+"\t");
      }
      System.out.println();
    }

    System.out.println();


    // 출력하기
    for(int i = 0;i<5;i++) {
      for(int j = 0;j<5;j++) {
        System.out.print(array[i][j]+"\t");
      }
      System.out.println();
    }

  }
}

