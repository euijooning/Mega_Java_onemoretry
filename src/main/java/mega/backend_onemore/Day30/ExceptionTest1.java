package mega.backend_onemore.Day30;

import java.io.FileReader;

// 방법 1.

public class ExceptionTest1 {

  public static void main(String[] args) {

    FileReader fr;

    try { // 파일이 존재하지 않는 경우가 있을 수 있음.
      fr = new FileReader("test.txt"); // fileName은 문자
      int value;
      while((value = fr.read()) != -1) { // 결과가 int니까 int로 받았는데
        System.out.println((char)value); // 그래서 char로 형변환
      } // read는 읽으려고 할 때 파일이 무조건 있어야 함.
      fr.close();
    } catch(Exception e) {
      System.out.println("에러 발생 : " + e);
      // e에서 에러에 대한 정보를 모두 담고 있음.
    } finally {
      System.out.println("하2 나는 무조건 실행됨");
    }

  }
}
/*
정리하자면 문자가 저장되어 있으면,
읽을 때는 숫자로 읽어 오는데(ex.아스키코드)
(fr.read() 가 int임)
이걸 실제 저장된 문자로 출력을 하려면
char로 형변환을 한 번 해줘야 한다는 것.
 */
