package mega.backend_onemore.Day11.Prac11;

public class Q2_HomeWork {

  public static void main(String[] args) {
    // 달팽이 모양의 배열
    // 일단 반복문 다 쪼개서 해봤습니다.

    int[][] array = new int[5][5];
    int count = 1;
    int rs = 0;
    int re = 4;
    int cs = 0;
    int ce = 4;

    while (count <= 25) {
      // 왼쪽에서 오른쪽으로 이동
      for (int i = cs; i <= ce; i++) {
        array[rs][i] = count++;
      }
      rs++; // 위쪽 한 칸 이동

      // 위에서 아래로 이동하
      for (int i = rs; i <= re; i++) {
        array[i][ce] = count++;
      }
      ce--; // 오른쪽 한 칸 이동

      // 오른쪽에서 왼쪽으로 이동하면서 배열에 값을 채움
      for (int i = ce; i >= cs; i--) {
        array[re][i] = count++;
      }
      re--; // 아래쪽 한 칸 이동

      // 아래에서 위로 이동하면서 배열에 값을 채움
      for (int i = re; i >= rs; i--) {
        array[i][cs] = count++;
      }
      cs++; // 왼쪽 한 칸 이동
    }

    // 출력하기
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        System.out.printf("%2d ", array[i][j]);
      }
      System.out.println();
    }
  }
}

