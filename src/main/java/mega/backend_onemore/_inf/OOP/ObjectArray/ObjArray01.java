package mega.backend_onemore._inf.OOP.ObjectArray;

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
    Person01[] pa = new Person01[5];
    pa[0] = new Person01("홍길동", 20);
    pa[1] = new Person01("박길동", 21);
    pa[2] = new Person01("김길동", 22);
    pa[3] = new Person01("장길동", 23);
    pa[4] = new Person01("고길동", 24);

    // [2] : 출력
    for (int i = 0; i < pa.length; i++) {
      // System.out.print( pa[i].name + "\t\t" );
      System.out.print(pa[i].getAge() + "\t\t");
    }
    System.out.println();
  }

}
