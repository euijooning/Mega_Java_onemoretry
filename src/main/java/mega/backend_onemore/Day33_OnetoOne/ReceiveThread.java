package mega.backend_onemore.Day33_OnetoOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread {

  private Socket m_Socket;

  public void run() {
    super.run();
    try {
      BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(m_Socket.getInputStream()));
      // Socket을 이용한 BufferReader 생성
      // 이제는 소켓에서 읽겠다.
      // BufferReader를 만드는데, InputStreamReader로 받는다.
      // InputStreamReader는 소켓을 InputStream으로 받을 수 있다.
      // 이걸 하면 문자로 바로 받을 수 있다.
      // 줄 단위로 끊어서 읽을 수 있게 됨.

      String receiveString;

      while(true) {
        receiveString = tmpbuf.readLine(); // 한줄로 문자를 만듦
        // BufferReader ReadLine 저장

        if(receiveString == null) { // 데이터가 없으면
          System.out.println("상대방 연결이 끊겼습니다.");
          break;
        }
        else { // 있으면
          System.out.println("상대방: " + receiveString); // 상대방 출력
          // 여기서는 소켓에서 읽은 걸 콘솔에 쓰겠다.
        }
      }
      tmpbuf.close(); // 버퍼 닫기 연결 종료
    }
    catch(IOException e) {
      e.printStackTrace();
    }
  }

  // 메인문에서 Socket 객체 받아 내 변수에 대입

  public void setSocket(Socket _socket) {
    m_Socket = _socket;
  }
}
