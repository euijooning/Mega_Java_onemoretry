package mega.backend_onemore.Day15.Prac15;
/*
연필, 지우개, 펜
연필은 각각 빨강, 파란, 주황, 노란색
연필 : 쓰는 기능
ex) 쓰는 기능은 빨간색 연필로 적습니다.

지우개는 잠자리, 모닝글로리(제조사)
지우개는 지우는 기능
ex) 지우개를 잠자리의 제품으로 지웁니다.

펜은 검정색-모나미 / 초록-제트스트림 / 베이비블루 - 워터맨
펜은 쓰는 기능이 있습니다.
ex) 펜은 모나미 제품의 검정색으로 씁니다.

4개의 연필을 쓰고 2개의 지우개로 지우고 3개의 펜을 쓰는 프로그램을 만들어주세요.


 */
class Pencil {
  String color;
  void print() {
    System.out.println("쓰는 기능은 " + color + "연필로 적습니다.");
  }
}

class Eraser {
  String brand;
  void erase() {
    System.out.println("지우개를 " + brand + "의 제품으로 지웁니다.");
  }
}

class Pen{
  String color;
  String brand;

  void write() {
    System.out.println("펜은 " + color + "색의 " + brand + " 제품으로 지웁니다.");
  }
}


public class Q3 {

  public static void main(String[] args) {
    Pencil p1 = new Pencil();
    Pencil p2 = new Pencil();
    Pencil p3 = new Pencil();
    Pencil p4 = new Pencil();

    p1.color = "노란";
    p2.color = "파란";
    p3.color = "주황";
    p4.color = "빨강";

    p1.print();
    p2.print();
    p3.print();
    p4.print();

    System.out.println("----------");

    Eraser e1 = new Eraser();
    Eraser e2 = new Eraser();

    e1.brand = "잠자리" ;
    e2.brand = "모닝글로리";

    e1.erase();
    e2.erase();

    System.out.println("-----------------");

    Pen pen1 = new Pen();
    Pen pen2 = new Pen();
    Pen pen3 = new Pen();

    pen1.brand = "모나미";
    pen2.brand = "모닝글로리";
    pen3.brand ="제트스트림";
    pen1.color = "검정";
    pen2.color = "빨간";
    pen3.color = "파랑";
    pen1.write();
    pen2.write();
    pen3.write();



  }

}
