package mega.backend_onemore.Day28;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderTest {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    System.out.print("읽고싶은 파일 입력 : ");
    String fileName = sc.next();

    String root = "C:\\Users\\eui44\\OneDrive\\바탕 화면\\메가It\\Mega_plus\\backend_onemore\\" + fileName;
    FileReader fr = new FileReader(root);

    int i;
    while ((i = fr.read()) != -1) { // 얘가 int로 읽어요. -1이면 데이터가 없는 것(디폴트)
      System.out.print((char) i);
    }
    fr.close();

  }
}
