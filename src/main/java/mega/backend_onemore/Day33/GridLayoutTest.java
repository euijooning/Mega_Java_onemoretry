package mega.backend_onemore.Day33;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

class Grid extends JFrame implements ActionListener {
  JButton[] jbArray = new JButton[20];
  Grid() {
    // 컨테이너를 가져와서 GridLayout을 설정합니다.
    Container ct = getContentPane();
    GridLayout gl = new GridLayout(4,5,10,10);
    ct.setLayout(gl);

    // 20개의 버튼을 생성하고 ActionListener를 등록합니다
    for(int i = 1;i<=20;i++) {
      jbArray[i-1] = new JButton("버튼"+i);
      jbArray[i-1].addActionListener(this);
      ct.add(jbArray[i-1]);
    }

    // 프레임(창)의 제목과 크기를 설정하고 보이도록 설정합니다.
    setTitle("Grid"); // 프레임이 가지고 있는 타이틀
    setSize(800,800); // 창의 크기
    setVisible(true); // 창을 보이게 만들겠다.
    // 이 메서드는 JFrame에서 제공
  }

  public void actionPerformed(ActionEvent ae) {
    System.out.println(ae.getActionCommand());
    // 이걸 하면 무슨 버튼을 눌렀는지가 콘솔에 나옴.

  }

}


public class GridLayoutTest {

  public static void main(String[] args) {

    new Grid();
  }

}
