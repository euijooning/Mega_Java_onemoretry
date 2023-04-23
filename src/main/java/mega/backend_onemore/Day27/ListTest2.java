package mega.backend_onemore.Day27;

import java.util.ArrayList;

class A {
  int a;
  int b;

  A(int a, int b) {
    this.a = a;
    this.b = b;
  }

  void print() {
    System.out.println("a: " + a + "b: " + b);
  }
}

public class ListTest2 {

  public static void main(String[] args) {
    //ArrayList 속에 자료형으로 아예 클래스를 집어넣는 사례.
    // ArrayList 선언
    ArrayList<A> sampleList = new ArrayList<>();

    // 값을 집어넣기
    for (int i = 0; i<sampleList.size(); i++) {
      sampleList.add(new A(i, i+1)); // new로 집어넣는게 중요하다.
    }

    // 출력하기 => 위에 print 메서드 있었음.
    for (int i = 0; i<sampleList.size(); i++) {
      sampleList.get(i).print(); // get(i) 까지 오면 그냥 가져오기만 한다.
    }

    // 몇 번째 인덱스인지 찾기
    for (int i = 0; i<sampleList.size(); i++) {
      if (sampleList.get(i).b == 4) {
        System.out.println(i);
      }
    }

  }

}
