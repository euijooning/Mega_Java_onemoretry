package mega.backend_onemore.Day33_Many;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;

/*
이 쓰레드의 실행흐름
- 이 쓰레드를 만들 때마다
- 사용자는 자기소개 하고
- 그 사용자가 들어왔다는 걸 다른 모든 클라이언트들에게 메시지 보내주고
- 이 사용자의 정보를 Map에 저장하고.
이걸 반복

run을 하면 사용자가 quit한다 했을 때 접근할 수 있는 사람만 데이터 삭제하고,
쓸 때는 /to 하고 쓰고
(indexOf의 반환이 음수면 없다는 뜻이고, 양수면 존재한다는 뜻)
그게 아니라면, 출력해준다.(일반적 채팅 왔다갔다 하는 경우)
- 서버 쪽에도 얘를 찍어주고, 다른 클라이언트들에도 알려주고.
- finally에서는 유저아이디 가져와서 그 유저아이디 삭제하고,
  화면에도 찍고, 모든 자원 반납하고 끝.
 */
public class ChatServerThread implements Runnable {

  Socket child;
  BufferedReader ois;
  PrintWriter oos;

  String user_id;
  HashMap<String, PrintWriter> hm;
  InetAddress ip;
  String msg;

  /*
  결국 얘는 뭐하는 애냐면
  소켓에서 데이터를 읽어와서 child에 쓰겠다.
  child에서 읽어오는건 내가 ois로부터 읽어올거고,
  child에 쓰는건 oos에서 쓰겠다.
   */
  public ChatServerThread(Socket s, HashMap<String, PrintWriter> h ) {

    child = s;
    hm = h;

    try	{
      ois = new BufferedReader(new InputStreamReader(child.getInputStream()));
      // BufferedReader를 만드는데 그걸 어디서 읽어올거냐면 child에서 읽어올거고,
      // child를 봤더니 소켓이다.

      oos = new PrintWriter(child.getOutputStream());
      // child(소켓)에 쓰는데,
      // 그럼 서버에 연결된 어떤 클라이언트가 올거고,
      // 그 클라이언트에 쓸 수 있는 공간을 user_id로 매핑시켜서 저장하는 거구나 알 수 있음.
      // 왜 이렇게 저장? key만 알면 value는 자동으로 달려 나오니까.

      user_id = ois.readLine(); // 입력받아온 것을 유저아이디에 저장
      //한 줄을 읽어서 user_id를 받아오고
      // 그런데 무조건 .readLine()했다고 user_id가 나오는 것은 아니다.
      // 여기서 규칙을 첫 줄에 무조건 자기 정보 입력하고 시작하자고 정했기 때문에 이렇게 나오는 것.

      ip = child.getInetAddress(); // ip만 뽑아서 출력
      // child가 소켓이니까 소켓은 연결 정보를 가지고 있고, 여기서 ip주소를 얻어오는 것.

      // 이렇게 하면 사용자 정보를 얻어온 것이 되기에 여기서 출력 가능
      System.out.println(ip + "로부터 " + user_id + "님이 접속하였습니다.");
      //출력 서버만 보는거고
      broadcast(user_id + "님이 접속하셨습니다."); // 일반 클라이언트
      // 현재 연결되어 있는 클라이언트를 다 보냄

      synchronized(hm) {
        hm.put(user_id, oos); // 데이터저장. 이 때는 user_id를 Key, oos(PrintWriter)를 value로.
      }
    }

    catch (Exception e) {
      e.printStackTrace();
    }

  }

  public void run() {
    String receiveData;

    try {
      while((receiveData = ois.readLine()) != null) {
        if(receiveData.equals("/quit")) { // 탈출
          synchronized(hm) {
            hm.remove(user_id); // /quit 친 애들은 해시맵에서 연결 끊어줌
          } // user_id는 key 값이 되는 것이겠죠.
          break;
        }

        else if(receiveData.indexOf("/to") >= 0) { //귓속말
          sendMsg(receiveData);
        }
        else { // 전체 다 보내는 채팅
          System.out.println(user_id + " >> " + receiveData );//출력
          broadcast(user_id + " >> " + receiveData);
        }

      }

    }

    catch (Exception e ) {
      e.printStackTrace();
    }

    finally { //서버 종료 시
      synchronized(hm) {
        hm.remove(user_id); // user_id를 삭제하고
      }
      broadcast(user_id + "님이 퇴장했습니다.");
      System.out.println(user_id + "님이 퇴장했습니다.");//출력

      try {
        if(child != null) {
          ois.close();
          oos.close();
          child.close();
        }
      }
      catch (Exception e) {}//예외처리 발생시
    }
  }

  /*
  broadcast <작동 로직>
  메시지를 받아서
  hm에서 oos를 꺼내 와서
  oos에 메시지를 쓰고 있음.

  어디서 쓰는지 어디서 읽는지는 new가 어떻게 되어있는지를 보고 판단할 수 있는 것.
  여기서는 확실한 건 hm에서 꺼내왔다는 것
  원래 향상된for문의 우측엔 배열이든 컬렉션이든이 와야 하는데
  메서드가 온 상태.(원래는 어떤 값이 와야 하는데
  그 뜻은?
  이 메서드의 리턴을 이용하겠다는 것.
  hm을 확인해보니까 이건 Map
  그런데 HashMap에서 values() 메서드(내장메서드)는
  그 맵이 가지고 있는 모든 value들을 컬렉션으로 반환하는 특성을 가지고 있다.
  그래서 broadcast는 결국에는 얘가 서버잖아요
  서버가 Map을 가지고 있는데 그 Map이 어떤 문자열을 기준으로 PrintWriter을 가지고 있다.

  그런데 얘는 추측 상,
  우리가 user_id를 받았죠.
  user_id를 기준으로 그 유저의 소켓에 쓸 수 있는 것을 저장하고 있는 것.
  hm은 그냥 HashMap 나타내는 변수 정도로 해석하면 됩니다.
   */
  public void broadcast(String message){
    synchronized(hm) {
      try {
        //향상된 for문
        // HashMap values 하면
        // HashMap에 연결되어 있는 id마다 PrintWriter가 다 연결되어 있을 것.
        // 그 PrintWriter 빼서 반복문 돌면서 전부 쏘면 다 가는 것.
        for(PrintWriter oos : hm.values()) { // 키 말고 값만 나옴
          oos.println(message);
          oos.flush(); // PrintWriter를 통해 쓴 것들을 전부 보내버림.
        }

      } catch(Exception e) {

      }
    }
  }

  // /to 홍길동 안녕하세요.
  public void sendMsg(String message){
    int begin = message.indexOf(" ") + 1;
    int end   = message.indexOf(" ", begin);

    if(end != -1) {
      String id = message.substring(begin, end); // 여기서는 홍길동 출력
      String msg = message.substring(end + 1); // 실제 작성한 메시지
      PrintWriter oos = hm.get(id);

      try {//시도하다
        if (oos != null) {
          oos.println(user_id + "님이 다음과 같은 귓속말을 보내셨습니다. : " + msg);
          oos.flush();
        }
      }
      catch (Exception e) { //예외처리가 발생하면 실행
      }
    }
  }

}
/*
결국에는,
서버는 모든 클라이언트의 정보를 가지고 있는데,
그 클라이언트들에게 말 그대로 broadcasting 하는 것.
(ex, 카카오톡 단체방 - 누가 말을 하면 여러 사람에게 다 보여야 하니까)
 */

/*
synchronized는 메서드에 붙을 수도 있지만 블록으로 처리될 수도 있다.
메서드로 붙으면 이 메서드의 클래스는 어떤 객체를 가지고 있겠죠.
그 객체가 메서드에 접근하는 건 딱 하나만 가능하다라는 뜻이고,
synchronized(hm)처럼 블록으로 쓰이면
hm의 모니터를 가진 애만 여기 들어올 수 있다는 뜻이 된다.

잠기는 부분이 메서드에 붙으면  클래스의 객체
블럭으로 쓰면 매개변수로 넘긴 객체
 */