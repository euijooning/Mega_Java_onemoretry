package mega.backend_onemore.Day28;

import java.util.LinkedList;

public class QueueTest {

  public static void main(String[] args) {

    LinkedList<String> q = new LinkedList<String>();
    System.out.println("큐 offer : " + q.offer("한국"));
    System.out.println("큐 offer : " + q.offer("중국"));
    System.out.println("큐 offer : " + q.offer("미국"));
    System.out.println("큐 offer : " + q.offer("러시아"));
    System.out.println("큐 offer : " + q.offer("우크라이나"));
    System.out.println("큐 offer : " + q.offer("북한"));

    System.out.println("===============================");

    // "우크라이나"가 큐(Queue)의 몇 번째 위치에 있는지 찾습니다.
    int index = q.indexOf("우크라이나");
    if(index != -1) {
      System.out.println("큐에서 숫자 \"우크라이나\"의 위치는 : " + index + "번째 입니다.");
    }
    else {
      System.out.println("큐에서 숫자 \"우크라이나\"가 없습니다.");
    }
    System.out.println("===============================");

    // 큐(Queue)에서 값을 순서대로 빼내어 출력합니다.
    while(!q.isEmpty()) { // 비어있지 않다면(차있다면) 반복
      String obj = q.poll(); // 꺼내서
      System.out.println("poll : "+ obj); // 요소 전체출력
    }
  }

}
