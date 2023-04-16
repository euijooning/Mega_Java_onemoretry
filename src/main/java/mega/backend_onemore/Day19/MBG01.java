package mega.backend_onemore.Day19;

/*
<문방구>
연필 : 주황색, 초록색, 노랑색, 파란색
지우개 : 회색, 빨간
펜: 초록색, 노랑색, 주황색, 파란색


학생 A
필통 => 색연필 2, 지우개 1, 펜 2
학생 B
필통 => 색연필 2, 지우개 1, 펜 2

학생별로 물건을 사야 한다.
학생 순서 A -> B
구매 순서 색연필 -> 지우개 -> 펜

만약에 고른 색깔이 팔렸으면 "벌써 팔렸습니다" 출력
없는 색을 입력하면 "잘못된 입력입니다." 출력

학생 모두가 색연필, 지우게, 펜이 다 필통에 차면 종료
학생별로 가지고 있는 색깔 연필, 지우게, 펜을 출력하고 종료
 */

// 헷갈릴까봐 적어놓음
// Student 는 a 와 b
// ColorPencil 은 pc1, pc2 (펜슬)
// Eraser 은 er
// ColorPen 은 cp1, cp2

import java.util.Scanner;

// 색연필
class ColorPencil {
  String color;

  ColorPencil(String color) {
    this.color= color;
  }
}

//지우개
class Eraser {
  String color;

  Eraser(String color) {
    this.color = color;
  }

}

class Pen {
  String color;

  Pen(String color) {
    this.color = color;
  }
}

//  얘네들이 필통에 담긴다고 했으므로, 필통도 하나 만들어줘야함.
class Case {
  ColorPencil cpc1;
  ColorPencil cpc2;
  Eraser er;
  Pen pen1;
  Pen pen2;

}

//학생은 A학생인지 B학생인지 구분이 필요하므로 이름을 넣었다.
//학생이 필통도 가지고 있으므로, 필통도 넣어준다.
class Student {
  String name;
  Case c;

  Student(String name) {
    this.name = name;
    c = new Case(); // Student가 만들어지는 순간 필통 객체도 만들어서 넣어주는 것.
  }

  boolean checkPencil() {
    if (c.cpc1 != null && c.cpc2 != null) {
      return false; // 확인하고 바로 나간다.
    }
    return true; // 굳이 else 넣을 필요 없음.
  }

  boolean checkEraser() {
    if (c.er != null) {
      return false; // 확인하고 바로 나간다.
    }
    return true; // 굳이 else 넣을 필요 없음.
  }

  boolean checkPen() {
    if (c.pen1 != null && c.pen2 != null) {
      return false; // 확인하고 바로 나간다.
    }
    return true; // 굳이 else 넣을 필요 없음.
  }

  void say() {
    System.out.println(name+"---------------");
    System.out.println("색연필1 : "+c.cpc1.color);
    System.out.println("색연필2 : "+c.cpc2.color);
    System.out.println("지우개 : "+c.er.color);
    System.out.println("펜1 : "+c.pen1.color);
    System.out.println("펜2 : "+c.pen2.color);
  }

  void end() {
    System.out.println("프로그램을 종료합니다.");
    System.out.println("이용해주셔서 감사합니다.");
  }
}


class Mungu {
  ColorPencil[] cpc;
  //ColorPencil[] pc = new ColorPencil[4];
  // 여기서 선언은 가능하다. 채워넣는 건 안 됨.
  Eraser[] er;
  Pen[] pen;

  Mungu() { // 받아올 필요 없이 여기서 선언된 것을 바로 채워넣게 만든다.
    cpc = new ColorPencil[4];
    er = new Eraser[2];
    pen = new Pen[4];

    String[] color1 = {"주황색", "초록색", "노란색", "파란색"};
    String[] color2 = {"회색", "빨간색"};

    // 객체생성 반복문 한 번에 만들기
    for (int i = 0; i<cpc.length; i++) {
      if (i<er.length) {
        er[i] = new Eraser(color2[i]);
      }
      cpc[i] = new ColorPencil(color1[i]);
      pen[i] = new Pen(color1[i]);
    }

  }

}

class Controller { // 실행 메서드 분리를 위한 클래스

  void buyPencil(Mungu m, String color, Student a) {

    // 1-1. 문방구에서 색깔이 맞는 색연필 찾기
    int i = 0;
    for (i = 0; i < m.cpc.length; i++) { // 문구 색연필 배열의 길이만큼 돌아서
      // 안전장치 => 문방구 색연필 재고가 null이 아니어야 한다.
      if (m.cpc[i] != null) {
        if (color.equals(m.cpc[i].color)) { // 입력색깔이, 문구 색연필 배열의 색깔과 일치하면

          //1-2. 색깔 맞는 색연필 객체 추출
          //1-3. 추츨된 객체를 A학생에게 전달
          if (a.c.cpc1 == null) {
            a.c.cpc1 = m.cpc[i]; // 학생 필통의 색연필 첫 선택에 재고 색연필 i번째 있는 것을 넣어준다.
          } else {
            a.c.cpc2 = m.cpc[i]; // 앞선 게 다 팔렸으면, 두 번째 색연필을 대신해서 넣어준다.
          }
          System.out.println(a.name + "이 " + m.cpc[i].color + " 색연필을 구매했습니다.");
          m.cpc[i] = null; // 1-4. 넘겨준 후 출력 후 원래 값 null로 바꿈
          break;
        }
      }
    }
    if (i == m.cpc.length) {
      System.out.println("재고가 없습니다. 벌써 팔렸습니다.");
    }
  }

  void buyEraser(Mungu m, String color, Student a) {

    // 1-1. 문방구에서 색깔이 맞는 색연필 찾기
    int i = 0;
    for (i = 0; i < m.er.length; i++) { // 문구 색연필 배열의 길이만큼 돌아서
      // 안전장치 => 문방구 색연필 재고가 null이 아니어야 한다.
      if (m.er[i] != null) {
        if (color.equals(m.er[i].color)) { // 입력색깔이, 문구 색연필 배열의 색깔과 일치하면
          //1-2. 색깔 맞는 색연필 객체 추출
          //1-3. 추츨된 객체를 A학생에게 전달
          a.c.er = m.er[i]; // 학생 필통의 색연필 첫 선택에 재고 색연필 i번째 있는 것을 넣어준다.
          // 요기서는 하나니꺼 굳이 if/else 할 필요가 없다.
          System.out.println(a.name + "이 " + m.er[i].color + " 지우개를 구매했습니다.");
          m.er[i] = null; // 1-4. 넘겨준 후 출력 후 원래 값 null로 바꿈
          break;
        }
      }
    }
    if (i == m.er.length) {
      System.out.println("재고가 없습니다. 벌써 팔렸습니다.");
    }
  }

  void buyPen(Mungu m, String color, Student a) {

    // 1-1. 문방구에서 색깔이 맞는 색연필 찾기
    int i = 0;
    for (i = 0; i < m.pen.length; i++) { // 문구 색연필 배열의 길이만큼 돌아서
      // 안전장치 => 문방구 색연필 재고가 null이 아니어야 한다.
      if (m.pen[i] != null) {
        if (color.equals(m.pen[i].color)) { // 입력색깔이, 문구 색연필 배열의 색깔과 일치하면

          //1-2. 색깔 맞는 색연필 객체 추출
          //1-3. 추츨된 객체를 A학생에게 전달
          if (a.c.pen1 == null) {
            a.c.pen1 = m.pen[i]; // 학생 필통의 색연필 첫 선택에 재고 색연필 i번째 있는 것을 넣어준다.
          } else {
            a.c.pen2 = m.pen[i]; // 앞선 게 다 팔렸으면, 두 번째 색연필을 대신해서 넣어준다.
          }
          System.out.println(a.name + "이 " + m.pen[i].color + " 색연필을 구매했습니다.");
          m.pen[i] = null; // 1-4. 넘겨준 후 출력 후 원래 값 null로 바꿈
          break;
        }
      }
    }
    if (i == m.cpc.length) {
      System.out.println("재고가 없습니다. 벌써 팔렸습니다.");
    }
  }

}


public class MBG01 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Mungu m = new Mungu();
    Student a = new Student("A학생");
    Student b = new Student("B학생");
    Controller ct = new Controller();

    // 1. A학생 색연필
    while (a.checkPencil()) {
      System.out.println("<주황색, 초록색, 노란색, 파란색>");
      System.out.print(a.name + " 색연필 색깔 골라주세요 : ");
      String color = sc.next();

      //1) 색이 올바르게 입력된 경우 => 문구점에 있는 펜을 학생에게 줘야.
      if (color.equals("주황색") || color.equals("초록색")
          || color.equals("노란색") || color.equals("파란색")) {
        ct.buyPencil(m, color, a);

      }
      else { //2) 색이 올바르게 입력이 되지 않은 경우
        System.out.println("잘못된 색깔을 입력하였습니다.");
      }
      // 그러면 나가는 조건을 고민? 학생의 색연필이 꽉 차면 나가면 된다.
      // checkPencil() 만들어줬음.
    }


    // 2. B학생 색연필
    // a를 b로 바꿔주기만 하면 된다.
    while (b.checkPencil()) {
      System.out.println("<주황색, 초록색, 노란색, 파란색>");
      System.out.print(b.name + " 색연필 색깔 골라주세요 : ");
      String color = sc.next();

      //1) 색이 올바르게 입력된 경우 => 문구점에 있는 펜을 학생에게 줘야.
      if (color.equals("주황색") || color.equals("초록색")
          || color.equals("노란색") || color.equals("파란색")) {
        ct.buyPencil(m, color, b);

      }
      else { //2) 색이 올바르게 입력이 되지 않은 경우
        System.out.println("잘못된 색깔을 입력하였습니다.");
      }
      // 그러면 나가는 조건을 고민? 학생의 색연필이 꽉 차면 나가면 된다.
      // checkPencil() 만들어줬음.
    }


    // 3. A학생 지우개
    while (a.checkEraser()) {
    System.out.println("<빨간색, 회색>");
      System.out.print(a.name + " 지우개 색깔 골라주세요 : ");
      String color = sc.next();

      //1) 색이 올바르게 입력된 경우 => 문구점에 있는 지우개을 학생에게 줘야.
      if (color.equals("빨간색") || color.equals("회색")) {
        ct.buyEraser(m, color, a);

      }
      else { //2) 색이 올바르게 입력이 되지 않은 경우
        System.out.println("잘못된 색깔을 입력하였습니다.");
      }
      // 그러면 나가는 조건을 고민? 학생의 지우개가 꽉 차면
    }


    // 4. B학생 지우개
    while (b.checkEraser()) {
      System.out.println("<빨간색, 회색>");
      System.out.print(b.name + " 지우개 색깔 골라주세요 : ");
      String color = sc.next();

      //1) 색이 올바르게 입력된 경우 => 문구점에 있는 지우개을 학생에게 줘야.
      if (color.equals("빨간색") || color.equals("회색")) {
        ct.buyEraser(m, color, b);

      }
      else { //2) 색이 올바르게 입력이 되지 않은 경우
        System.out.println("잘못된 색깔을 입력하였습니다.");
      }
      // 그러면 나가는 조건을 고민? 학생의 지우개가 꽉 차면
    }


    // 5. A학생 펜
    while (a.checkPen()) {
      System.out.println("<주황색, 초록색, 노란색, 파란색>");
      System.out.print(a.name + " 펜 색깔 골라주세요 : ");
      String color = sc.next();

      //1) 색이 올바르게 입력된 경우 => 문구점에 있는 펜을 학생에게 줘야.
      if (color.equals("주황색") || color.equals("초록색")
          || color.equals("노란색") || color.equals("파란색")) {
        ct.buyPen(m, color, a);

      }
      else { //2) 색이 올바르게 입력이 되지 않은 경우
        System.out.println("잘못된 색깔을 입력하였습니다.");
      }
      // 그러면 나가는 조건을 고민? 학생의 색연필이 꽉 차면 나가면 된다.
      // checkPencil() 만들어줬음.
    }

    // 6. B학생 펜
    while (b.checkPen()) {
      System.out.println("<주황색, 초록색, 노란색, 파란색>");
      System.out.print(b.name + " 펜 색깔 골라주세요 : ");
      String color = sc.next();

      //1) 색이 올바르게 입력된 경우 => 문구점에 있는 펜을 학생에게 줘야.
      if (color.equals("주황색") || color.equals("초록색")
          || color.equals("노란색") || color.equals("파란색")) {

        ct.buyPen(m, color, b);
      }
      else { //2) 색이 올바르게 입력이 되지 않은 경우
        System.out.println("잘못된 색깔을 입력하였습니다.");
      }
      // 그러면 나가는 조건을 고민? 학생의 색연필이 꽉 차면 나가면 된다.
      // checkPencil() 만들어줬음.
    }
    // 지금 얘는 하나 끝나고 또 하나 끝나고 하기 때문에
    // 반복문을 다 끊어서 만들어도 무방하다.

    a.say();
    b.say();
    a.end();
  }

}

/*
    // 1. A학생 색연필
    while (true) {
      System.out.println("<주황색, 초록색, 노란색, 파란색>");
      System.out.print(a.name + " 색연필 색깔 골라주세요 : ");
      String color = sc.next();

      //1) 색이 올바르게 입력된 경우 => 문구점에 있는 펜을 학생에게 줘야.
      if (color.equals("주황색") || color.equals("초록색")
          || color.equals("노란색") || color.equals("파란색")) {

        // 부족한 부분 ?? 벌써 팔렸습니다. 색깔이 다 돌면서 없으면 팔린 것.
        //i를 바깥에서 초기화 할 수 있도록 해줌. 왜냐면 다 팔린 것까지 쓸 것이기 때문에 계속 필요하므로

        // 1-1. 문방구에서 색깔이 맞는 색연필 찾기
        ColorPencil tempCP = null; // 색연필 객체를 넘기기 위한 임시 변수 생성

        int i = 0;
        for (i = 0; i < m.cpc.length; i++) { // 문구 색연필 배열의 길이만큼 돌아서
          if (color.equals(m.cpc[i].color)) { // 입력색깔이, 문구 색연필 배열의 색깔과 일치하면
            // 1-2. 색깔이 맞는 색연필 객체 추출하기
            tempCP = m.cpc[i]; // 객체 넘겨주기
            m.cpc[i] = null; // 1-3. 넘겨준 후 원래 값 null로 바꿈
            break; // 찾았으면 반복문을 굳이 돌 필요가 없음. 색깔은 하나니까.
          }
        }
        // 1-4. 추출된 객체를 A학생에게 전달.
        a.c.pc1 = tempCP;

      }
      else { //2) 색이 올바르게 입력이 되지 않은 경우
        System.out.println("잘못된 색깔을 입력하였습니다.");
      }
 */
