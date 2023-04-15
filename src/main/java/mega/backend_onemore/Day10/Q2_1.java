package mega.backend_onemore.Day10;

/*
1. 2차원 배열 생성, 카운트 변수(사작점) 생성
2. 배열을 돌면서 count변수 하나씩 증가시키며 채워넣기
3. 배열 출력하기
*/

public class Q2_1 {
  //정방향 배열 만들기
  public static void main(String[] args) {
    // 초기 세팅
    int[][] a= new int[5][5];
    int count = 1;

    for(int i = 0;i<a.length;i++) {
      for(int j = 0;j<a[i].length;j++) {
        a[i][j] = count++;
      }
    }

    for(int i = 0;i<5;i++) {
      for(int j = 0;j<5;j++) {
        System.out.print(a[i][j]+"\t");
      }
      System.out.println();
    }

    System.out.println();
  }
}



