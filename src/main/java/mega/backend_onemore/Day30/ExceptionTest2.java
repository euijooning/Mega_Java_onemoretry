package mega.backend_onemore.Day30;

import java.io.FileReader;

// 방법 2.
public class ExceptionTest2 {

  public static void main(String[] args) throws Exception {

    FileReader file = new FileReader("a.txt");
    int i;
    while((i = file.read()) !=-1) {
      System.out.println((char) i);
    }
    file.close();

  }

}