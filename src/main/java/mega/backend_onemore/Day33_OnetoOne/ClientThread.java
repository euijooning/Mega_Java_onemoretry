package mega.backend_onemore.Day33_OnetoOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// 사실상 sendThread
public class ClientThread extends Thread{

  private Socket m_Socket; // 그냥 Socket이잖아요. 이것만 봐도 이게 TCP라는 걸 알 수 있죠.

  public void run() { // 어떤 작업을 할 지 명시
    super.run();
    try {
      // new InputStreamReader(System.in) : 콘솔에서 입력을 받는다는 것 / 버퍼 이용해서 속도 좀 더 높이겠다.
      BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
      // BufferReader 이용해 입력 객체 생성
      PrintWriter sendWriter = new PrintWriter(m_Socket.getOutputStream());
      // PrintWriter 객체 생성 : 쓴다는 건데, 이 소켓에다가 쓰겠다고 선언(getOutputStream()은 쓰는 것.)
      // 객체 생성 시, Socket의 출력 스트림 인자로 받아서 생성
      String sendString;

      while(true) {
        sendString = tmpbuf.readLine(); // 여기서 입력을 받겠다.
        // 콘솔 사용자 입력을 받아서(읽는 것은 콘솔 사용자 입력에서 읽어오는 거고)
        if(sendString.equals("quit")) { // 내가 종료하게 만들기 위해서 이걸 만듦
          break; // 사용자가 quit을 치면 그만하고,
        }
        else {
          sendWriter.println(sendString); // 그게 아니면 이 Writer에게 출력을 한다.
          // 콘솔 사용자 입력에서 읽어 온 것을 그대로 sendWriter에 쓸 거다.
          sendWriter.flush();
          // sendWriter는 "여기다 쓰겠다" 해서 쓸 곳을 만들어준 것.
        }
      }
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
