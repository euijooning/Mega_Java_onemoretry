package mega.backend_onemore._inf.OOP.ObjectArray;
// <문제>
// 객체에 대한 참조값을 요소로 가지는 객체 배열을 생성하는 코드를 구현하시오.
// 반복문을 사용하여 객체를 생성하시오.
class Person01 {
  // Field
  private String name;
  private int age;

  // Constructor
  Person01() {

  }
  Person01( String name, int age ) {
    this.name = name;
    this.age = age;
  }

  // Method
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}

public class ObjArray01 {
  public static void main(String[] args) {

    // [1] : 객체 생성
    int[] ar1 = {1, 2, 3, 4, 5};
    char[] ar2 = {'A', 'B', 'C', 'D', 'E'};
    Person01[] ps = new Person01[5];
    ps[0] = new Person01("홍길동", 20);
    ps[1] = new Person01("박길동", 21);
    ps[2] = new Person01("김길동", 22);
    ps[3] = new Person01("장길동", 23);
    ps[4] = new Person01("고길동", 24);

    // [2] : 출력
    for (int i = 0; i < ps.length; i++) {
      // System.out.print( pa[i].name + "\t\t" );//private이므로 안 됨.
      System.out.println(ps[i].getName());
    }
    System.out.println();

  }
}
