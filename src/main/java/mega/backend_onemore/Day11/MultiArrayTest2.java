package mega.backend_onemore.Day11;

public class MultiArrayTest2 {

  public static void main(String[] args) {
    // 3차원 배열 b를 생성하고, 각 차원에 맞게 크기를 지정한다.
    int[][][] b= new int[2][2][2];

    // count 변수를 이용하여 배열의 값을 1부터 순서대로 증가시킨다.
    int count = 1;

    // 이중 for문과 삼중 for문을 이용하여 배열의 값을 순서대로 할당한다.
    for(int i = 0;i<b.length;i++) {
      for(int j = 0;j<b[i].length;j++) {
        for(int x = 0;x<b[i][j].length;x++) {
          b[i][j][x] = count++;
        }
      }
    }

    // 이중 for문과 삼중 for문을 이용하여 배열의 값을 출력한다.
    for(int i = 0;i<b.length;i++) {
      for(int j = 0;j<b[i].length;j++) {
        for(int x = 0;x<b[i][j].length;x++) {
          System.out.print(b[i][j][x]+"\t");
        }
        System.out.println();
      }
      System.out.println();
    }
  }

}