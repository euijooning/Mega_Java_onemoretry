package mega.backend_onemore.Day33_OnetoOne;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class  MainServer {
  public static void main(String[] args) {

    try {
      ServerSocket a_socket = new ServerSocket(9000); // ServerSocket 객체 생성
      Socket c_socket = a_socket.accept(); // 클라이언트 쪽에 연결되면 c_socket 만들어짐.
      // 서버소켓에서 연결 요청한 애를 받아와서(클라이언트) 얘를 연결시키고
      // 누구랑 연결됐는지를  Socket c_socket 여기서 가져온 것.
      // 즉 클라이언트의 소켓이 Socket c_socket 여기 쏙 담긴다.
      // ServerSocket accept 메소드, 변수 c_socket에 대입

      ReceiveThread receive_thread = new ReceiveThread(); // Receive Thread 객체 생성
      receive_thread.setSocket(c_socket); // Receive Thread Socket 전달
      // 그럼 이 클라이언트 소켓에게 데이터를 가져와서

      SendThread send_thread = new SendThread(); // Send Thread 객체 생성
      send_thread.setSocket(c_socket); // Send Thread Socket 전달
      // 여기에서 데이터를 쓴다.



      receive_thread.start();
      send_thread.start(); // Send Thread 시작
    }
    catch(IOException e) {
      e.printStackTrace();
    }
  }

}