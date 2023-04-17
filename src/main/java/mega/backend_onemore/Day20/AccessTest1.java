package mega.backend_onemore.Day20;

class AA{
  private int a;

  AA() {
  }

  public void setA(int a) {
    //로그나 여러기능을 사용이 가능
    this.a = a;
  }

  public int getA() {
    //로그나 여러기능을 사용이 가능
    return this.a;
  }
}

class B{
  int b;
}



public class AccessTest1 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    AA a = new AA();
    //a.a = 10; //에러 O => 왜냐면 a는 private이기 때문에 함부로 접근할 수 없다.
    a.setA(10); // 그래서 set을 통해서 값 세팅을 해줘야 한다.
    System.out.println(a.getA()); // 세팅해준 값을 가져오기

    B b = new B();
    b.b  = 10; // 에러 X => 왜냐면 필드가 private가 아니기 때문에.
  }
}
