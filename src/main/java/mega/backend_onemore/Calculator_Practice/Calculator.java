package mega.backend_onemore.Calculator_Practice;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {

  JFrame frame; // GUI 창을 나타내는 프레임입니다.
  JTextField textfield; // 숫자 입력과 계산 결과를 표시하는 텍스트 필드입니다.
  JButton[] numberButtons = new JButton[10]; // 0부터 9까지의 숫자 버튼을 담은 배열입니다.
  JButton[] functionButtons = new JButton[9]; // 사칙연산, 소수점, +/-, 지우기, 초기화 버튼을 담은 배열입니다.
  JButton addButton,subButton,mulButton,divButton; // 사칙연산 버튼입니다.
  JButton decButton, equButton, delButton, clrButton, negButton; // 소수점, 등호, 지우기, 초기화, +/- 버튼입니다.
  JPanel panel; // 숫자와 연산 버튼을 담은 패널입니다.

  Font myFont = new Font("Ink Free",Font.BOLD,30); // 버튼과 텍스트 필드에 사용될 폰트입니다.

  double num1=0,num2=0,result=0; // 계산에 사용될 숫자와 계산 결과를 저장하는 변수입니다.
  char operator; // 현재 선택된 연산자를 저장하는 변수입니다.

  Calculator(){
    // JFrame 인스턴스 생성
    frame = new JFrame("Calculator");
    // JFrame의 X 버튼 클릭 시 프로그램 종료
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420, 550);
    frame.setLayout(null);

    textfield = new JTextField();
    textfield.setBounds(50, 25, 300, 50);
    textfield.setFont(myFont);
    textfield.setEditable(false);

    addButton = new JButton("+");
    subButton = new JButton("-");
    mulButton = new JButton("*");
    divButton = new JButton("/");
    decButton = new JButton(".");
    equButton = new JButton("=");
    delButton = new JButton("Del");
    clrButton = new JButton("Clr");
    negButton = new JButton("(-)");

    functionButtons[0] = addButton;
    functionButtons[1] = subButton;
    functionButtons[2] = mulButton;
    functionButtons[3] = divButton;
    functionButtons[4] = decButton;
    functionButtons[5] = equButton;
    functionButtons[6] = delButton;
    functionButtons[7] = clrButton;
    functionButtons[8] = negButton;

    for(int i =0;i<9;i++) {
      functionButtons[i].addActionListener(this);
      functionButtons[i].setFont(myFont);
      functionButtons[i].setFocusable(false);
    }

    for(int i =0;i<10;i++) {
      numberButtons[i] = new JButton(String.valueOf(i));
      numberButtons[i].addActionListener(this);
      numberButtons[i].setFont(myFont);
      numberButtons[i].setFocusable(false);
    }

    negButton.setBounds(50,430,100,50);
    delButton.setBounds(150,430,100,50);
    clrButton.setBounds(250,430,100,50);

    panel = new JPanel();
    panel.setBounds(50, 100, 300, 300);
    panel.setLayout(new GridLayout(4,4,10,10));

    panel.add(numberButtons[1]);
    panel.add(numberButtons[2]);
    panel.add(numberButtons[3]);
    panel.add(addButton);
    panel.add(numberButtons[4]);
    panel.add(numberButtons[5]);
    panel.add(numberButtons[6]);
    panel.add(subButton);
    panel.add(numberButtons[7]);
    panel.add(numberButtons[8]);
    panel.add(numberButtons[9]);
    panel.add(mulButton);
    panel.add(decButton);
    panel.add(numberButtons[0]);
    panel.add(equButton);
    panel.add(divButton);

    frame.add(panel);
    frame.add(negButton);
    frame.add(delButton);
    frame.add(clrButton);
    frame.add(textfield);
    frame.setVisible(true);
  }

  public static void main(String[] args) {

    Calculator calc = new Calculator();
  }

  @Override
  public void actionPerformed(ActionEvent e) { // 버튼 클릭 이벤트가 발생하면 실행됩니다.

    for(int i=0;i<10;i++) {
      if(e.getSource() == numberButtons[i]) {
        textfield.setText(textfield.getText().concat(String.valueOf(i)));
      }
    }
    if(e.getSource()==decButton) {
      textfield.setText(textfield.getText().concat("."));
    }
    if(e.getSource()==addButton) {
      num1 = Double.parseDouble(textfield.getText());
      operator ='+';
      textfield.setText("");
    }
    if(e.getSource()==subButton) {
      num1 = Double.parseDouble(textfield.getText());
      operator ='-';
      textfield.setText("");
    }
    if(e.getSource()==mulButton) {
      num1 = Double.parseDouble(textfield.getText());
      operator ='*';
      textfield.setText("");
    }
    if(e.getSource()==divButton) {
      num1 = Double.parseDouble(textfield.getText());
      operator ='/';
      textfield.setText("");
    }
    if(e.getSource()==equButton) {
      num2=Double.parseDouble(textfield.getText());

      switch(operator) {
        case'+':
          result=num1+num2;
          break;
        case'-':
          result=num1-num2;
          break;
        case'*':
          result=num1*num2;
          break;
        case'/':
          result=num1/num2;
          break;
      }
      textfield.setText(String.valueOf(result));
      num1=result;
    }
    if(e.getSource()==clrButton) {
      textfield.setText("");
    }
    if(e.getSource()==delButton) {
      String string = textfield.getText();
      textfield.setText("");
      for(int i=0;i<string.length()-1;i++) {
        textfield.setText(textfield.getText()+string.charAt(i));
      }
    }
    if(e.getSource()==negButton) {
      double temp = Double.parseDouble(textfield.getText());
      temp*=-1;
      textfield.setText(String.valueOf(temp));
    }
  }
}