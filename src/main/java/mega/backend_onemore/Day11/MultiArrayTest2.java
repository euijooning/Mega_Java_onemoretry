package mega.backend_onemore.Day11;

public class MultiArrayTest2 {
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[][][] b= new int[2][2][2];

    int count = 1;

    for(int i = 0;i<b.length;i++) {
      for(int j = 0;j<b[i].length;j++) {
        for(int x = 0;x<b[i][j].length;x++) {
          b[i][j][x] = count++;
        }
      }
    }
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
