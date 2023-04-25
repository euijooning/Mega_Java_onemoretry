package mega.backend_onemore.Day29;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileTest01 {

  public static void main(String[] args) throws IOException {

    FileReader fr = new FileReader("study.txt");
    BufferedReader reader = new BufferedReader(fr);

    String line;
    while ((line = reader.readLine()) != null) { // 읽으려고 한 줄 뺐는데 null이 아니면!(내용 유)
      System.out.println(line);
      // 얘가 더 편한 건, 한 줄 문자열로 넘어온다는것. 저번처럼 귀찮은 형변환이 필요가 없어요.
    }
  }

}
