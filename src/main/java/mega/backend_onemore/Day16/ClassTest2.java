package mega.backend_onemore.Day16;

class Sample {

  int a1;
  // static int a1;
  int b1;

  // 생성자
  Sample(int a, int b) {
    a1 = a;
    b1 = b;
  }
}
public class ClassTest2 {

  public static void main(String[] args) {
    Sample sample = new Sample(5,7);
    sample.a1= 20;
    System.out.println(sample.b1);
    //a1 = 20, b1 = 7
    //static a1로 바뀌면 B 객체가 100개 만들어지더라도 a는 하나가지고 쓰면 되어서 하나.
    //static이면, a는 객체 만들 필요 없이 B.a1 찍으면 사용이 가능함.
  }

}
