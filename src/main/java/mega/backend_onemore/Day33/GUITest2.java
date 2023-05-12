package mega.backend_onemore.Day33;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Hi extends JFrame implements ActionListener {
  JLabel jl; // 무언가를 설명해주는 라벨
  Hi(){
    // 컨테이너를 가져와서 FlowLayout을 설정합니다.
    Container ct = getContentPane(); // 도화지 만들어서 레이아웃을 짜주고
    ct.setLayout(new FlowLayout());

    // 두 개의 버튼을 생성합니다.
    JButton j1 = new JButton("10");
    JButton j2 = new JButton("20");

    // JLabel을 생성하고 컨테이너에 추가합니다.
    jl = new JLabel("하이!!!!!"); // 라벨에 하이!!라고 씀
    ct.add(j1); // 도화지에 버튼 두 개 추가하고
    ct.add(j2);
    ct.add(jl); // 도화지에 라벨도 추가

    // 버튼에 ActionListener를 등록합니다
    j1.addActionListener(this); //즉, Hi라는 ActionListener를 여기서 만든 첫번째 버튼(j1)에다가 넣은 것.
    // 즉, this는 ActionListener <- 왜냐면 Hi도 ActionListener라고 볼 수 있으니까.
    j2.addActionListener(this);
    /*
    액션리스너에 다시 자기자신을 넣는 게 아니라,
    j1이라는 버튼에게 ActionListener를 자기 자신으로 단 것이다.
    => 즉 들어가는 것은 모두 j1에 저장이 된다는 뜻.
    => "j1에 어떤 액션이 발생하면 내가 듣겠다."
    => 내가 듣겠다는 말은
  public void actionPerformed(ActionEvent ae) {
    String input = ae.getActionCommand();
    String result = "힘내세요!!!!" + input;
    jl.setText(result);
    System.out.println(input);
  } 이 일을 하겠다!!
     */

    // 프레임의 제목과 크기를 설정하고 보이도록 설정합니다.
    setTitle("Two");
    setSize(500,500);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) {

    String input = ae.getActionCommand(); // 이벤트에서 액션 명령을 가져와서 input 변수에 저장합니다.
    String result = "힘내세요!!!!" + input; // result 변수에 "힘내세요!!!!"와 input 변수를 결합하여 저장합니다.
    jl.setText(result); // 이 result 결과를 jl(라벨)에다가 쓰겠다.
    System.out.println(input);
    //=>즉, j1이든 j2든 버튼이 눌리면 하이!!!라는 라벨이 힘내세요!!!라고 바뀌겠구나. 라고 알 수 있는 거죠.
  }
}

public class GUITest2 {

  public static void main(String[] args) {

    new Hi();
  }
}
