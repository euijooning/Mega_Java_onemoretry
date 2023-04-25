package mega.backend_onemore.Day29;

import java.io.FileWriter;
import java.io.IOException;

public class FileTest02 {
// 덮어쓰기(새로 쓰기)와 이어쓰기가 있다.
  public static void main(String[] args) throws IOException {

      FileWriter fw1 = new FileWriter("study.txt", false); // 덮어쓰기

//    FileWriter fw2 = new FileWriter("study.txt", true); // 이어쓰기

//    fw2.write("자바 정말 쉬워요! 진짜로요. 제발 좀 믿으세요!");
//    fw2.close();
//    // 얘는 출력하는 게 없어서 아무것도 안나오지만, 파일경로 타고 들어가서 열어보면 추가되어 있음을 확인 가능

    fw1.write("실험을 위해 덮어쓰기를 해볼거예요. 자바 정말 쉬워요!!!");
    fw1.close();
  }

}
