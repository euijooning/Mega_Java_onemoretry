package mega.backend_onemore.Day32;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

// 스캐너에서 진짜로 입력한 걸 보내는 것.

// 잊지 말아야 할 것
// Receieve 먼저 켜고 Send를 켜야한다.
public class  SendUDP {

  public static void main(String[] args) throws IOException {

    DatagramSocket ds = new DatagramSocket();
    InetAddress ia = InetAddress.getByName("192.168.20.34");
    int port = 8888; //리시브 안 켜고서 send부터 켜면 안 된다.
    Scanner sc = new Scanner(System.in); // 사용자에게 입력 받음
    System.out.print("입력 : "); // 이걸 Receive에서 출력을 해준다.
    String str = sc.next();

    DatagramPacket dp = new DatagramPacket(str.getBytes(), str.getBytes().length, ia, port);
    // 보낼 때는 그냥 받는대로 보낸다(받을 때는 30바이트씩 했었다.)
    // 데이터 상자에 받는 사람, 주소, 데이터 크기 등을 모두 적어놓는 것.
    ds.send(dp);
  }

}
/*
그런데 데이터 주고받을 때 유의해서 봐야하는 부분이 하나 있다.
500바이트를 보내면 30바이트만 받고 나머지는 흘려 보내는지
아니면 500을 전부 받기 위해서 10번을 다 도는지.
그건 구현된 방법에 따라 달라짐
상자는 일종의 운송장. 운송장을 보고 네트워크는 패킷을 제대로 처리한다.
 */
