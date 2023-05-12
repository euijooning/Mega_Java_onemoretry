package mega.backend_onemore.Day33_OnetoOne;

import java.io.IOException;
import java.net.Socket;

public class MainClient {
  // 연결하고 데이터 보내는 역할을 해주는 앤데(제어 기능)
  // ReceiveThread 에서는 사실상 설계만

  public static void main(String[] args) {

    // 그런데 여기는 ReceiveThread 만 있고 SendThread는 없어요.
    // 그냥 ClientThread를 SendThread라고 생각해도 될 거 같아요
    try {
      Socket c_socket = new Socket("192.168.10.46",9000); // Socket 생성 -> 서버 역할
      System.out.println("서버 연결");

      ReceiveThread receive_thread = new ReceiveThread(); // Receive Thread 객체 생성
      receive_thread.setSocket(c_socket); // Receive Thread Socket 전달
      ClientThread send_thread = new ClientThread(); // Client Send Thread 객체 생성
      send_thread.setSocket(c_socket); // Client Send Thread Socket 전달
      // 그래서 요 두개에다가 여기서 만든 소켓 달아주고

      // 각각 스타트를 해주면
      // send쓰레드가 데이터를 먼저 보내기 시작할거고
      send_thread.start(); // Client Thread 시작
      receive_thread.start(); // Receive Thread 시작
      // 얘는 데이터를 읽어와서 콘솔에 출력하고 요런 식으로 진행이 될 것.
    }
    catch(IOException e) {
      e.printStackTrace();
    }
  }

}
/*
헷갈림직한 것
ReceiveThread도 읽고 쓰고,
SendThread도 읽고 쓴다. 차이는 위치!!!
Send는 콘솔에서 읽어서 Socket에 썼고,
반대로 ReceiveThread는 소켓에서 읽어서
콘솔에 쓰는 것.
 */

