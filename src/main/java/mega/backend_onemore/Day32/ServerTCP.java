package mega.backend_onemore.Day32;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {

  public static void main(String[] args) throws IOException {

    int port = 7777; // 포트번호
    int times = 10; // 반복 client 10명 들어오게 해주겠다.

    ServerSocket ss = new ServerSocket(port); //서버 소켓 생성

    int i = 1; // times와 비교를 위한 변수
    while(i<= times) { // 반복문 times와 같아질때까지 반복
      Socket s = ss.accept(); // accept함수를 통한 소켓 생성 // 여기서는 서버가 받는 역할을 수행
      // 클라이언트 들어올 때까지 여기서 기다림.
      // 클라이언트 접속이 되면 그때부터 아래로 내려간다.
      // 왜 소켓이 리턴되냐면, 클라이언트랑 서버랑 같이 쓰는 소켓이 하나 나오기 때문.
      // 그러면 서로 왔다갔다가 가능해진단 소리지

      OutputStream os = s.getOutputStream(); // accept로 받아왔으니 accept 한 곳에다가 쓰겠다.
      // 소켓으로 out 밖으로 보내는 스트림을 생성
      DataOutputStream dos = new DataOutputStream(os);
      // OutputStrema을 인자로 넣어서 DataoutputStream의 객체를 생성


      for(int j = 1; j<=10;j++) { // 10번 반복
        dos.write(j); // DataOutputStream을 이용해서 쓰기 실행 1~10
        // 나오면 클라이언트가 받는다. 이 j가 클라이언트의 j로 출력됨.
      }
      s.close(); //s도 소켓이니까, 다 썼으면 커넥션 끊어야죠.
      i++; // 10번 접속할 수 있게 만들어줌.
    }
    ss.close();

  }
}
/*
TCP는 연결 지향적
일단 먼저 연결 루트를 미리 깔아놓고 데이터를 보낸다.
그래서 이름도 다르다. 데이터그램소켓보다는 서버소켓이라는 명칭을 썼고,
서버-클라이언트 개념이 도입되어 좀 더 연결의 중요성을 강조.

그런데 쓰고 출력을 한다는 건 명확한 기준이 있어야 한다는 건데.
s.getOutputStream()은 s에 쓰일 수 있는 스트림이 오게 된다는 것.
 */
