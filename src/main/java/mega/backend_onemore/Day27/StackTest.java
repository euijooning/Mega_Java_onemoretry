package mega.backend_onemore.Day27;

import java.util.Stack;

public class StackTest {

  public static void main(String[] args) {
    Stack<String> stackSample = new Stack<>();

    System.out.println("스택에 push 1 : " + stackSample.push("경기도"));
    System.out.println("스택에 push 2 : " + stackSample.push("충청도"));
    System.out.println("스택에 push 3 : " + stackSample.push("강원도"));
    System.out.println("스택에 push 4 : " + stackSample.push("전라도"));
    System.out.println("스택에 push 5 : " + stackSample.push("제주도"));
    System.out.println("==================================================");

    int num = stackSample.search("제주도");
    if (num != -1) { //-1이 기본값이었다!
      System.out.println(" 스택에서 숫자 \"제주도\"의 위치는 : " + num + "번째 입니다.");
    }
    else {
      System.out.println("제주도는 목록에 존재하지 않습니다.");
    }
    System.out.println("======================================================");

    // 삭제
    while (!stackSample.empty()) { // 목록이 존재하는 동안
      String obj = stackSample.pop(); // 스택의 맨 위에 있는 객체를 pop하여 가져옴
      System.out.println("스택에서 pop : " + obj); // pop한 객체 출력
    }
  }
}
