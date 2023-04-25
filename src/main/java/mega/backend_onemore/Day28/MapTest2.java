package mega.backend_onemore.Day28;

import java.util.HashMap;
// 이 예제 : 객체가 Key면서 객체가 값일 수 있다!
class C {
  int k;
}

class D {
  String str;
}

public class MapTest2 {

  public static void main(String[] args) {

    HashMap<C, D> map = new HashMap<>();
    C c = new C();
    C c1 = new C();
    map.put(c, new D());
    map.get(c1); // null
    map.get(c);//객체 D를 리턴

    System.out.println(map.get(c1));
    System.out.println(map.get(c));
  }

}
