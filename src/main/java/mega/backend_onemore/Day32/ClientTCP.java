package mega.backend_onemore.Day32;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientTCP {

  public static void main(String[] args) throws IOException {

    String server ="172.30.1.61"; //cmd : ipconfig 로 확인
    int port = 7777;

    // 서버를 켜고 클라이언트를 켜니까
    // 얘가 접속을 하면 서로 연결된 소켓을 하나씩 받는다(s에서도 받고 c에서도 받고)
    Socket c = new Socket(server, port); // 소켓 생성
    // 클라이언트 소켓은 서버에게 보내는 것.
    // cf. 서버소켓은 말 그대로 내가 서버니까 나에게 들어오기만 할 것임.

    InputStream is = c.getInputStream(); // 인풋스트림이니까 얘는 여기다가 읽어오겠다!
    DataInputStream dis = new DataInputStream(is);

    for(int i = 1; i<= 10; i++) {
      int j = dis.read(); // 읽어오는 거니까 read
      System.out.println("서버로부터 받은 데이터 " + j + "출력"); // 매개변수로 들어가있던 j
    }
    c.close(); // 소캣 닫기
  }

}
/*
보통 보내는 사람이 server주소를 써서 난 여기에 보낼 거야 선언을 하는데,
지금 얘는 받는 사람임에도 불구하고 어디서 받을거야 주소를 선언하고 받고 있다.


최종 정리를 하면
TCP는 클라이언트가 서버에 요청을 해야하기 때문에
클라이언트 측에서 서버의 ip 주소를 알아야 한다.
UDP는 보내는 입장이 어디에 보낼지 받는사람이 직접 택배에 주소를 써서 보내야하니까
여기다가 직접 보낼 때 주소를 적어야 한다.(Sender에 주소 적음)
 */
