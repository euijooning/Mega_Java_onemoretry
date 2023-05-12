package mega.backend_onemore.Day32;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveUDP {
  // 얘는 받는 애이므로 자기가 받는 거니까 나의 위치를 굳이 특정할 필요 x
  // 그래서 여기서 포트만 주면 될 듯.

  public static void main(String[] args) throws IOException {

    int port = 8888; // 소통할 포트 번호
    int times = 10; // 10번만 주고받겠다.

    DatagramSocket ds = new DatagramSocket(port);
    int i = 1;

    while(i<= times) { //10번 이하일 때(수행되는 동안)
      byte[] buffer = new byte[30]; // 이 패킷에서 30바이트씩 읽어 오겠다.
      DatagramPacket dp = new DatagramPacket(buffer, buffer.length); // 이걸 까보면 데이터가 있겠지.
      ds.receive(dp); // 소켓에게 데이터를 받아오라고 요청.(여기 패킷에)
      String str = new String(dp.getData());
      System.out.println("수신된 데이터 : " + str);
      i++;
    }

  }
}
/*
데이터 패킷을 만들 때는 박스에 데이터를 담아서 보내거나 담는 건데,
지금 여기서는 받는 것만 하고 있다.

데이터 패킷에 담을 수 있는 그릇을 줄 때는 byte 배열로 주는데,
(byte[] buffer = new byte[30];)
이걸 읽을 때는 String으로 변환해서 읽는다.

데이터 패킷 안에 버퍼를 주고, 이 버퍼에 담아달라고 했고,
잘 받았으면, 거기 담긴 거를 바이트를 스트링으로 바꿔서
사용자(sender)가 어떤 데이터를 보냈는지를 문자열로 변환해서 읽겠다.

그럼 왜 처음부터 String이 아닌 byte인가?
컴퓨터는 0과 1, 최대한 작은 단위룰 쑬 수록 좋다.
문자열을 보낸다고 하면 String 배열을 쓸 수 있겠지만
숫자를 보낸다거나 다른 걸 보낼 때, 굳이 String을 쓸 필요가 있나 싶은 것.
통신은 항상 byte로 하고, 받는 사람 입장에서는 채팅서버니까 문자열 변환해서 읽고 요런 식.
(받을 때의 편리성을 위해서)

그리고 DataPacket의 리시브가
일단 누가 보내야 받을 거잖아요.
.receive(dp) 여기서 멈출까요?
 찾아보니까 멈춰있게 구현이 된다.
 데이터를 받는다고 나갔는데 빈손으로 들어올수는 없으니까
 (이걸 block 이라고 표현)
 근데 진짜 프로그램이라면 갑자기 block되면 망한다.
 이러한 문제를 쓰레드 통해서 해결하면 된다.
 보내는 쓰레드 따로, 받기만 하는 쓰레드 따로 둬서 일처리
 */
