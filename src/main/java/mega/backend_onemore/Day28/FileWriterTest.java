package mega.backend_onemore.Day28;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// 파일 입출력
public class FileWriterTest {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    String str = "자바는 정말 쉬워요! \n" + "오늘 숙제는 2개입니다. \n" + "주말 숙제는 4개입니다.";

    char[] change = new char[str.length()]; // 문자열을 문자열 길이의 배열으로 만들고
    str.getChars(0, str.length(), change, 0);
    //처음부터 str의 길이만큼을 change 배열에 0(첫위치)부터 삽입한다.
    // 그럼 str의 내용이 전부 change 배열 안으로 들어가게 된다.

    System.out.print("파일 이름을 정하세요 : ");
    String fileName = sc.next();
    FileWriter fw = new FileWriter(fileName); // 지금 fileName이라는 파일에다가 글을 쓰겠다는 말.
    // 외부로 나가는 것이므로 오류 발생. 일단 throw IoException 처리 해준다.
    // try-catch의 방법도 있음.
    fw.write(change); // 쓰는 작업
    fw.close(); // 닫는 작업. 반드시 해줘야함.

    System.out.println(fileName + " 파일이 생성됨");
  }


}
