package mega.backend_onemore.Day19.HT2;

class B {

}

class C {

  B[] b = new B[5]; //멤버변수 has 관계 (변수만 있으면 Has관계 가능하다)
  // 그러면 당연히 배열도 가능한 것이다.

}

class D {

  //has 관계?? 아니다!
  // 멤버변수로 갖는 거랑 메서드로 부르는 거랑 차이가 있으므로
  // 내가 실제로 가지고 있어야 한다.
  B make(B[] b) {
    b[2] = new B();
    return b[2];
  }
}


class E {

  D[][] d = new D[3][3];

  /*
  D[][] sendD(D[][][] d, int i, int j, int k) {
    return d[0];
    // 자료형으로 받고 싶은 만큼 뒤에서부터 소거(->리턴 부분에 적어준다)
  }
   */
  D[] sendD(D[][] d, int i, int j) {
    d[i][j] = new D();
    return d[i];
  }


  public class HasTest2 {

    public static void main(String[] args) {


      C c = new C();
      D d = new D();
      D[][] d1 = new D[3][3];

      B b = d.make(c.b);
      E e = new E();

      e.sendD(d1, 2, 0);
      // 이렇게 해주면 d[0][2]에만 객체가 있는 것이고 나머지에는 없는 것.

      // d1[2][0]은 객체가 있을까요 없을까요?
      // 있다 => d1 배열에 인덱스로 2,0에 매개변수로 넣어서 객체를 만들어줬으니까.
      // 그럼 d1[0][2]에는?
      // 없다!

      // 다시
      /*
      e.sendD(d1, 0, 2); 여기서 d1이 넘어가면 D[3][3]; 이게 넘어간 것이다.
      d1은 2차원 배열
      그리고 그 속에 있는 0행 2열에 객체 만들어 넣은 것*함수콜 의의
      그럼 뒤에 3열은 남겨놓고 앞에 3열은 먼저 가있는 상태가 되겠지.

      D[] d2 = e.sendD(d1, 0, 2);에서 객체에 있는 것을 출력하려면 어떻게 해야 되냐?
      일단 i를 보냈으니까 d[0] 보낸 것.
      d2[2]; 하면 된다.
      지금 d2가 d[0]으로 치환된 것.
       */
    }
  }
}
