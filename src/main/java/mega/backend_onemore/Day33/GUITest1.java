package mega.backend_onemore.Day33;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class GUIMake extends JFrame implements ActionListener { // 전체 화면이 됨.

  private JTextField jtf; // 한 줄 글자 입력할 수 있는 칸
  private JTextArea jta; // 여러 줄 입력할 수 있는 칸.

  GUIMake() {
    JButton jb = new JButton("Save"); // 버튼 만듦(화면에 생김)
    jtf = new JTextField("파일 이름을 입력하시오", 20);
    jta = new JTextArea("파일에 쓸 글을 적으시오", 20, 20);

    Container ct = getContentPane(); //객체생성x, JFrame에서 사용할 수 있게 만드는 애.
    // 컨테이너는 JFrame에서 제공. 컨테이너에 담아줌.
    // 컨테이너는 도화지
    // 이 도화지에 레이아웃 깔아주고
    ct.setLayout(new FlowLayout()); // 내용 넘치면 자동으로 다음줄에 작성

    JPanel p = new JPanel(); // 패널 만들어서
    ct.add(jta); // 도화지에 텍스트에어리어 추가
    p.add(jtf); // 패널에 텍스트필드 추가
    p.add(jb); // 패널에 버튼 추가
    ct.add(p); // 마지막에 판넬 자체를 통으로 붙여버렸음=> 패널 자체를 도화지에 넣음.(세트화되어서 딱 붙음)
    // 아래로 내려간 이유는, 옆에 붙이려했는데 넘쳐서 자동으로 내려감.
    jb.addActionListener(this); //Save버튼 누르면 액션리스너가 동작하게 만듦.
    //=>버튼 눌렀으면 actionPerformed()메서드가 동작
    // this를 붙인 이유는 내가 ActionListener를 구현했으므로 나에게 있으니까.

    setTitle("Test1");
    setSize(500, 500);
    setVisible(true); // 보여줄거니?
  }

  public void actionPerformed(ActionEvent ae) { // 액션을 인자로 받아서
    try {
      // jtf에서 입력된 문자열을 가져와서 s 변수에 저장합니다.
      String s = jtf.getText(); // 텍스트 필드에 작성했던 텍스트 가져와서
      // s에 해당하는 파일을 생성하기 위해 FileOutputStream을 생성합니다.
      FileOutputStream fos = new FileOutputStream(s); // 걔를 파일에 쓰겠다.
      // 생성된 FileOutputStream을 사용하여 DataOutputStream을 생성합니다.
      DataOutputStream dos = new DataOutputStream(fos);
      // jta에서 입력된 문자열을 UTF-8 형식으로 파일에 저장합니다.
      dos.writeUTF(jta.getText());
      // FileOutputStream을 닫습니다.
      fos.close();
      // 생성된 파일 이름을 콘솔에 출력합니다.
      System.out.println(s + " 파일 생성~~~~");
    }
    // 예외 발생 시 처리합니다.
    catch (Exception e) {
      // 예외 처리 내용을 작성합니다.
    }
  }
}

public class GUITest1 {

  public static void main(String[] args) {
    new GUIMake();
  }
}
