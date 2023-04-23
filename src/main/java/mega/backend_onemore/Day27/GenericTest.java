package mega.backend_onemore.Day27;

class Box<T> {
  T vol;

  void setVolume(T vol) {
    this.vol = vol;
  }
  T getVolume() {
    return vol;
  }
}

public class GenericTest {

  public static void main(String[] args) {
    Box<Integer> ibox = new Box<Integer>();
    ibox.setVolume(200);
    //ibox.setVolume(32.3); 에러 / 실수 아니잖아.
    System.out.println("<Integer> 박스의 부피는 : " + ibox.getVolume());

    Box<Double> dbox = new Box<Double>();
    dbox.setVolume(32.300);
    //dbox.setVolume(2); 에러
    System.out.println("<Double> 박스의 부피는 : " + dbox.getVolume());
  }

}
