package mega.backend_onemore.Day28;

import java.util.HashSet;
import java.util.Iterator;

class A {
  int a;
  int b;

  A(int a, int b){
    this.a = a;
    this.b = b;
  }

  void print() {
    System.out.println("a:"+a+",b :"+b);
  }
}

public class SetTest2 {

  public static void main(String[] args) {

    HashSet<A> set = new HashSet<A>();

    A a1 = new A(7,8);
    set.add(new A(5,6));
    /*
    set.add(new A(5,6));
    set.add(new A(5,6)); 이 두개 쓰는 것은 가능
    new를 두 번 불렀기 때문에 객체가 다르므로.
    하지만 찾을 때 곤란해지는 상황이 생기지.
     */
    set.add(a1);
    Iterator<A> it = set.iterator();
    int num = 1;
    while(it.hasNext()) {
      A a =it.next();
      if(a == a1) { // 변수로 a1을 빼놨기 때문에 비교 가능
        System.out.println(num+"번째에 있습니다.");
        // 돌 거니까 1번째, 2번째 등 여러 숫자 중 하나가 나올 수 있음
      }
      num++;
    }
  }

}