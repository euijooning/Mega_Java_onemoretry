package mega.backend_onemore.Day24;

public class Week04_Explain {

  public static void main(String[] args) {
/*
    참조자료형변환
    상속이 있어야 할 수 있습니다.
    부모는 자식을 모른다는 걸 명심해야 한다.
    객체는 자식, 자료형은 부모 이렇게
    이렇게 만든다.

    C입장에선 객체가 만들어지면 D는 모른다.
    하지만 D에서 객체가 만들어지면 C는 있기 때문에 안다.

 */

   /*
    Class C{
      int a;
    }

    Class D extends C{
      int b;
    }

    C c = new D(); // 업 캐스팅
    D d = (D)c; // 다운 캐스팅
    */
    /*
    보는 방법을 변수 자료형 타입(기준)으로 보게 된다.
    D로 만들고 C로 갔다. => 내가 볼 수 있는 건 C밖에 없다.
    그 말은 C일 때 int b가 안 보인다는 것.

    다시 D로 다운캐스팅 해주면? int b가 보인다.
    즉, 부모 입장에서는 부모에 있는 것만 보이는 것이고,
    자식은 부모 것도 다 가지고 있으니까, 전부 보인다.

    왜 쓰는가?
    이러한 관계가 있다고 가정했을 때,
    Class A {
    }
    Class B extends A{
    }
    Class C extends A{
    }
    Class D extends A{
    }
    Class E extends A{
    }

    Void abc(B b)
    Void abc(C c)
    Void abc(D d)
    Void abc(E e)

    오버로딩 통해서 이렇게 만들 수 있다.
    근데 이걸 참조자료형 형변환을 쓰면 메서드 네 개 만들 것을
    Void abc(A a)
    이게 가능해진다.

    그런데, 객체가 뭔지를 모르니까, 객체를 확인하기 위해서 일일이 이렇게 확인해줘야 한다.
    Void abc(A a)
    {
      if(a instanceof B)
        B b=(B)a;
      if(a instanceof C)
        C c = ( C )a;
      If(a instanceof D)
      D d = (D)a;
      if(a instanceof E)
        E e = (E)a;
    }

    어차피 조금 번거로움.

    그 해결책으로 나온 것이 메서드 오버라이딩.

    아예 똑같이 만들고, 내가 재정의함.

    오버라이딩 : 부모가 정의한 함수를 자식이 재정의를 하는 것을 말합니다.
    Class A{
      void abc(){
        System.out.print(“ABC”);
      }
    }
    Class B extends A{
      void abc(){
        System.out.println(“DEF”);
      }
    }

    B b = new B();
    b.abc(); 1. DEF 나옴.

    A a = new B();
    a.abc(); 2. DEF 나옴.

        <두 번째 예시>
    객체가 아무리 부모 것을 불러도
    실객체가 자식이면,
    자식이 보인다(동적 바인딩에 의해)
    무조건 실객체 중심.

  함수 재정의가 필요가 없어진다.

  Class Run{

  B, C, D, E, F 를 받아서 뭔가 동작하는 메소드를 abc()를 호출할꺼입니다.

      void run (B b)
      {
        b.abc();
      }
      void run (C c)
      {
        c.abc();
      }

    }

    이렇게 바뀌었다가,

    Void run(A a)
    {
      if(a instaceof(B)){
      B b=(B)a;
      b.abc();
    }
     ….
    }


    Void run(A a)
    {
      a.abc();
    }

    최종적으론 이게 가능!!!




     */

  }
}

