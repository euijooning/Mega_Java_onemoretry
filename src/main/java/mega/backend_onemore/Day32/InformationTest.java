package mega.backend_onemore.Day32;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class InformationTest {

  public static void main(String[] args) throws UnknownHostException, MalformedURLException {

    // ip 정보를 알아내는 클래스
    InetAddress ia = InetAddress.getLocalHost();
    System.out.println("컴퓨터 이름 : "+ia.getHostName());
    System.out.println("컴퓨터 IP : "+ia.getHostAddress());

    InetAddress[] all = InetAddress.getAllByName("www.google.com");
    for(InetAddress a : all) { // 향상된 for문
      System.out.println(a);
    }

    URL starbuks = new URL("https://www.starbucks.co.kr");

    System.out.println("프로토콜 : "+ starbuks.getProtocol());
    System.out.println("포트 : "+starbuks.getPort());
    System.out.println("호스트 : "+starbuks.getHost());
    System.out.println("파일(경로포함) : "+starbuks.getFile());
    System.out.println("전체 URL : "+starbuks.toExternalForm());
  }


}
