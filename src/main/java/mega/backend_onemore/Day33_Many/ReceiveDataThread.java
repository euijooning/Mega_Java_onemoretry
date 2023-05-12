package mega.backend_onemore.Day33_Many;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
/*
이게 보다 현실적
서버 하나가 데이터 하나만 바라보고 있는 상황은 거의 낭비에 가깝고
정말 많은 사용자들을 처리할 수 있는게 일반적.
 */
/*
얘는 간단히 말하면 출력만 하는 애.
읽어오는 애로부터 데이터를 한 줄씩 읽어 와서
콘솔에 찍기만 한다.
 */
public class ReceiveDataThread implements Runnable {
  //Runnable에서는 run()에서 무엇을 할 지를 명시하니까

  Socket client; //Socket 변수 client 선언
  BufferedReader ois; // BufferReader 변수 ois 선언
  String receiveData; // 문자열 변수 receiveData 선언

  /*
  원래 여기는 try-with-resources 할 수도 있는데
  여기서는 주입을 받으려고 new를 하지 않고.. 다른 방법이 없었을 것
  여기서 new 해서 썼으면 자원 반납 깔끔하게 할 수 있었겠으나
  이것들을 만드는 걸 밖으로 책임을 떠넘겼기 때문에
  finally 안에서 직접 close()를 불렀다.
   */

  public ReceiveDataThread(Socket s, BufferedReader ois){
    //ReceiveDataThread 생성자 이고 Socket과 BufferReader을 인자로 받는다.
    client = s;
    //인자 s를 client에 대입
    this.ois = ois;
    //인자 ois를 인스턴스 변수 ois에 대입
  }

  public void run(){
    //받는게 없고 주지도 않는 run 함수
    try{//시도하다
      while( ( receiveData = ois.readLine() ) != null )
        //ois의 readLine 함수를 호출하여 문자열 한줄 씩을 receiveDate에 담으면
        //receiveData가 null이 아니면 계속 반복(값이 있으면)
        System.out.println( receiveData );
      //receiveData 출력

    } catch(Exception e) {//예외처리 발생시 실행
      e.printStackTrace();  //예외처리시 출력
    }
    finally {
      //위에 try catch 어떤상황이든 다 끝나면 실행
      // 자원정리를 할 때도 예외가 발생할 수 있어서 여기도 try-catch가 등장한다.
      try{//시도하다.
        ois.close();
        //BufferReader 객체 ois close()
        client.close();
        //Socket 객체 client close()
      } catch(IOException e2) { //예외처리 발생시 실행(IOException 시)
        e2.printStackTrace();//예외처리 출력
      }
    }
  }
}
