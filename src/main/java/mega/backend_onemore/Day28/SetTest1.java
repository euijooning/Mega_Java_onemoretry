package mega.backend_onemore.Day28;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

// hasNext로 뒤에 값 있는지 확인하고 next로 넘어가서 다음 요소 반환시킴.
public class SetTest1 {

  public static void main(String[] args) {

    HashSet<String> a = new HashSet<>();
    HashSet<Integer> b = new HashSet<>();

    String[] color = {"빨간색","주황색","노란색","초록색","파란색","남색","보라색"};

    for(int i = 0;i<color.length;i++) {
      a.add(color[i]);
      b.add(i);
    }

    a.add("빨간색"); // 추가적으로 안 들어감, 여기서는 무시됨.

    boolean checkChange = a.add("무지개색"); // 잘 들어갔으면 true가 나온다.
    System.out.println(checkChange);

    System.out.println("b의 가장 큰값은 ? > " + Collections.max(b)); // 6 출력
    System.out.println("b의 가장 최소값은 ? > " + Collections.min(b)); // 0 출력

    // 얘는 순서가 없기 때문에 이터레이터를 통해 돌려서 출력해야 한다.
    Iterator<String> it = a.iterator();

    while(it.hasNext()) {
      System.out.println(it.next());
    }
  }
}
