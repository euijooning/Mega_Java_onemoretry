package mega.backend_onemore.Day09;

public class MultiArrayTest {

  public static void main(String[] args) {
    int[][] a = new int[5][5];

    int count = 1;
    for(int i = 0;i<a.length;i++) {
      for(int j = 0;j<a[i].length;j++) {
        a[i][j] = count++;
      }
    }

    for(int i = 0;i<a.length;i++) {
      for(int j = 0;j<a[i].length;j++) {
        System.out.print(a[i][j]+"\t");
      }
      System.out.println();
    }
  }

}
