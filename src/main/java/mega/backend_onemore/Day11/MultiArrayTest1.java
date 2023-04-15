package mega.backend_onemore.Day11;

public class MultiArrayTest1 {

  public static void main(String[] args) {

    // 2차원 배열 d를 생성하고, 각 차원에 맞게 크기를 지정한다.
    int[][] d = new int[3][];
    d[0] = new int[5];
    d[1] = new int[2];
    d[2] = new int[3];

    // 2차원 배열 d의 값을 9로 초기화하고 출력한다.
    for (int i = 0; i < d.length; i++) {
      for (int j = 0; j < d[i].length; j++) {
        d[i][j] = 9;
        System.out.print(d[i][j] + "\t");
      }
      System.out.println();
    }

    // 3차원 배열 k를 생성하고, 첫 번째 차원에 맞게 크기를 지정한다.
    int[][][] k = new int[5][][];

    // k의 첫 번째 차원의 첫 번째 원소에 대해, 두 번째와 세 번째 차원에 맞게 크기를 지정한다.
    k[0] = new int[5][3];

  }
}