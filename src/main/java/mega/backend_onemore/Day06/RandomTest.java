package mega.backend_onemore.Day06;

import java.util.Random;

public class RandomTest {

  public static void main(String[] args) {

    Random r = new Random();

    int num = r.nextInt(10); // 0~9
    int num2 = r.nextInt(10) + 1; // 1~10
    int num3 = r.nextInt(16) + 15; //0~15 => 15~30

    System.out.println(num);
    System.out.println(num2);
    System.out.println(num3);
  }

}
