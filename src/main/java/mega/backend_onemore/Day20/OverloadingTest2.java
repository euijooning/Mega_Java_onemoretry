package mega.backend_onemore.Day20;

class A{
  A(int a) {
    System.out.println("A(int a) 생성자 호출됨. // 인자: " + a);
  }
  A(){
    System.out.println("A() 생성자 호출됨.");
  }
}
public class OverloadingTest2 {

  public static void main(String[] args) {

    A a = new A(5); // A(int a) 생성자 호출
    A a1 = new A(); // A() 생성자 호출
  }
}

