package mega.backend_onemore.Day10;

public class Q2_2_1 {

  public static void main(String[] args) {
// 역방향 방법 2 부호 바꾸기
		int[][] c = new int[5][5];
		int count = 1;
		int sw = 1;


		for(int i =0;i<c.length;i++) {
			for(int j = 0;j<c[i].length;j++) {
				// 1 -1  1 -1 1
				if(sw == 1) {
					c[i][j] = count++;
				}
				else { // sw = -1
					// i = 1
					// 5 - 0 -1 4 / 5 -1 -1 3 / 5 -2 -1 2 / 5 - 3 -1 1  / 5 -4 -1 0
					c[i][c[i].length - j -1] = count++;
				}
			}
			sw = sw *(-1);
		}

  }

}
