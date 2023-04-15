package mega.backend_onemore.MakeStar;

public class Star05_Kang {

  public static void main(String[] args) {
    //위: 피라미드 모양
    // 아래 : 역피라미드 모양
    /*
    사실 피라미드 두 개를 찍는다고 보면 된다.
    사실 두 개를 더한 것이 다이아몬드의 크기이다.
    그런데 자바에서는 정수/정수는 그냥 정수
    따라서 int size=5 라고 했을 때,
    size/2 == 5 가 되는 것.
    그래서 size / 2 + 1 해준 이유는 3을 만들고 싶어서, 나머지 하나를 위에 것이 가져가게 만들어 준 것.
     */
    for (int i = 0; i < 3; i++) {  // 0 1 2 3 4
      for (int j = 2; j > i; j--) { // 4 3 2 1 // 4 3 2 // 4 3 // 4
        System.out.print(" ");
      }
      for (int j = 0; j <= i * 2; j++) { // 0 // 0 1 2 // 0 1 2 3 4 // 0 1 2 3 4 5 6 // 0 1 2 3 4 5 6 7 8
        System.out.print("*");
      }
      System.out.println();
    }

    for (int i = 0; i<2; i++) {
      for (int j = 0; j<=i; j++) {
        System.out.print(" ");
      }
      for (int j = 3; j>i*2; j--) { // 줄어드는 것도 두 배씩 줄어드므로.
        System.out.print("*");
      }
      System.out.println();
    }

    /*
    //5.다이아몬드
    Scanner sc = new Scanner(System.in);
    System.out.print("숫자 입력 : ");
    int size = sc.nextInt();

    for (int i = 0; i < size / 2 + 1; i++) {  // 0 1 2 3 4
      for (int j = size / 2; j > i; j--) { // 4 3 2 1 // 4 3 2 // 4 3 // 4
        System.out.print(" ");
      }
      for (int j = 0; j <= i * 2; j++) { // 0 // 0 1 2 // 0 1 2 3 4 // 0 1 2 3 4 5 6 // 0 1 2 3 4 5 6 7 8
        System.out.print("*");
      }
      System.out.println();
    }
    // i:0, 공백: 1, 별: 3
    // i:1, 공백: 2, 별: 1
    for (int i = 0; i < size / 2; i++) {
      for (int j = 0; j <= i; j++) {
        System.out.print(" ");
      }
      for (int j = size - 2; j > i * 2; j--) {
        System.out.print("*");
      }
      System.out.println();
    }
    공백과 별 개수
    // size: 5 -> 3
    // size: 7 -> 5
    // size: 9 -> 7
    // size: 11 -> 9


    System.out.print("숫자 입력 : ");
//        Scanner sc = new Scanner(System.in);
    int num1 = sc.nextInt();
     for (int i = 0; i < num1 / 2 + 1; i++) {  // 0 1 2 3 4
      for (int j = num1 / 2; j > i; j--) { // 4 3 2 1 // 4 3 2 // 4 3 // 4
        System.out.print(" ");
      }
      for (int j = 0; j <= i * 2; j++) { // 0 // 0 1 2 // 0 1 2 3 4 // 0 1 2 3 4 5 6 // 0 1 2 3 4 5 6 7 8
        System.out.print("*");
      }
      System.out.println();
    }

    for (int i = 0; i < num1 / 2; i++) {
      for (int j = 0; j <= i; j++) {
        System.out.print(" ");
      }
      for (int j = num1 - 2; j > i * 2; j--) { //13/2 6 + 1 7
        System.out.print("*");
      }
      System.out.println();
    }

     */

  }

}
