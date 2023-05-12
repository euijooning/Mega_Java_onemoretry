package mega.backend_onemore.Day33_Many;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {

  String ipAddress;
  static final int port = 7777;
  Socket client = null;
  BufferedReader read;
  PrintWriter oos;
  BufferedReader ois;
  String sendData;
  String receiveData;

  String user_id;
  ReceiveDataThread rt;
  boolean endflag = false;

  public MainClient(String id, String ip) {

    user_id = id;
    ipAddress = ip;

    try {//시도하다.
      System.out.println("**** 클라이언트*****");//출력 자기 클라이언트라고 해주고
      client = new Socket(ipAddress, port);


      read = new BufferedReader(new InputStreamReader(System.in)); // 키보드 입력 받아서
      ois = new BufferedReader(new InputStreamReader
          (client.getInputStream())); // 소켓 에서 input(입력받음)
      oos = new PrintWriter(client.getOutputStream()); // 소켓에서 output(쓰는 것)
      oos.println(user_id); // 우리가 약속하길 사용자는 가장 처음에 입력받은 걸 id삼기로 했으니까
      // 사용자는 보낼 때 자기 이름부터 보낸 거다.
      oos.flush();
      // 원래는 버퍼가 꽉차면 왔다갔다 작업이 이루어지는데
      // flush를 하면 강제집행이 가능하다.
      // 여기서는 id만 입력받으면 내용을 서버로 바로 보내게 만든 것.

      rt = new ReceiveDataThread(client, ois);
      Thread t = new Thread(rt); //Runnable로 만들었기 때문에 생성자에 쓰레드 넣어줘야.
      t.start(); // 쓰레드 만들어서 실행.
      // 그래서 이 사용자는 ois로부터 뭔가를 받아서 화면에 무언가를 계속 출력하게 될 것이다.

      // 입력
      while(true){ // 무한반복
        sendData = read.readLine(); // 사용자로부터 입력 받아서

        oos.println(sendData); // 사용자 입력내용을 소켓에 쓰고
        oos.flush();

        if(sendData.equals("/quit")) { // 만약 quit이었다면
          endflag = true;
          break; // 그만하겠다.
        }
      }

      System.out.print("클라이트의 접속을 종료합니다. ");
      System.exit(0);

    } catch(Exception e) {
      if(!endflag) {
        e.printStackTrace();
      }
    }
    finally {
      try {//자원정리 때문에 보이는 중복 코드들...
        ois.close();
        oos.close();
        client.close();
        System.exit(0);

      } catch(IOException e2) {
        e2.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in); //스캐너 입력
    System.out.print("아이디를 입력하세요 : ");//아이디 입력
    String id = sc.next();//입력 받기
    new MainClient(id, "192.168.10.46");
    // 생성자 부르는 것만으로도 이 로직이 다 실행이 되니까, 굳이 저장을 안한 듯.
  }
}


