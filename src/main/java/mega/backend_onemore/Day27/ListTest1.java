package mega.backend_onemore.Day27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ListTest1 {

  public static void main(String[] args) {

    String[] name = {"kim", "lee", "park", "jung", "oh"};
    ArrayList<String> lname = new ArrayList<String>(Arrays.asList(name));
    // 이 순간 lname에 이 name 배열이 들어간다.
    System.out.println("초기 값 : " + lname);

    lname.add("ha"); // oh 뒤에 붙는다
    System.out.println("\"ha\" 가 추가된 후의 값 : " + lname );

    lname.set(0, "김"); // 한글로 김으로 바뀜
    lname.set(3, "곽"); // jung이 곽으로 바뀜
    System.out.println("\"ha\" 로 변경되고 \"곽\" 이 추가된 값  : " + lname);

    Collections.shuffle(lname); // 돌면서 섞여버림.
    System.out.println("shuffle() 메소드가 적용된 값 : " + lname);

    Collections.sort(lname); // 오름차순 자동 정렬됨.
    System.out.println("sort() 메소드가 적용된 값 : " + lname);
    System.out.println("5번째 요소의 값 : " + lname.get(4));

    Collections.fill(lname, "김"); // 전부 김으로 바뀌어버림.
    System.out.println("모든 요소를 \"김\" 으로 설정된 값 : " + lname );
  }

}
