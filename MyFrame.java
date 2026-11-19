import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{

	JButton button;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[5];
	JButton addButton, subButton, mulButton, divButton, crlButton;
	JPanel panelTop, panelDown;

	List<JButton> numberList = Arrays.asList(numberButtons);

	Font fonte = new Font("SansSerif", Font.BOLD,25);

	double num1, num2, result;
	char operator;

	JTextField visualTextField, backgroundTextField;

	MyFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(420, 540);


		button = new JButton("GO!");
		button.setFocusable(false);
		button.setFont(new Font("Arial", Font.BOLD, 18));
		button.addActionListener(this);
		visualTextField = new JTextField();
		visualTextField.setPreferredSize(new Dimension(250, 20));
		visualTextField.setFont(fonte);
		visualTextField.setEditable(false);

		backgroundTextField = new JTextField();
		backgroundTextField.setEditable(false);

		functionButtons[0] = addButton = new JButton("+");
		functionButtons[1] = subButton = new JButton("-");
		functionButtons[2] = mulButton = new JButton("*");
		functionButtons[3] = divButton = new JButton("/");
		functionButtons[4] = crlButton = new JButton("CE");

		panelTop = new JPanel(null);
		panelTop.setBounds(5, 0, 270, 42);
		button.setBounds(0, 5, 80, 36);
		visualTextField.setBounds(84, 5, 186, 36);
		panelTop.add(button); 
		panelTop.add(visualTextField);

		panelDown = new JPanel(new GridLayout(4, 3, 5, 5));
		panelDown.setBounds(5, 43, 270, 360);

		for(int i=0; i<10; i++){
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].setFont(fonte);
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFocusable(false);

			panelDown.add(numberButtons[i]);
		}
		for(int i=0; i<5; i++){
			functionButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFocusable(false);
			panelDown.add(functionButtons[i]);
		}


		this.add(panelTop);
		this.add(panelDown);

		this.setVisible(true);	
	}
	@Override
	public void actionPerformed(ActionEvent e){

		if(e.getSource()==button){

			num2 = Double.parseDouble(backgroundTextField.getText());

			switch(operator){
				case '+'-> result = num1 + num2;
				case '-'-> result = num1 - num2;
				case '*'-> result = num1 * num2;
				case '/'-> result = num1 / num2;
				default -> {

				}
			}
			backgroundTextField.setText(String.valueOf(result));
			visualTextField.setText(String.valueOf(result));
			System.out.println("background holder is: " + backgroundTextField.getText());
			num1=result;
		}
		else if(numberList.contains(e.getSource())){
			for(int i=0; i<10; i++){
				if(e.getSource()==numberButtons[i]){
					backgroundTextField.setText(backgroundTextField.getText().concat(String.valueOf(i)));
					visualTextField.setText(visualTextField.getText().concat(String.valueOf(i)));
				}
			}
		}
		else if(e.getSource()==addButton){
			num1 = Double.parseDouble(backgroundTextField.getText());
			operator = '+';
			backgroundTextField.setText("");
			visualTextField.setText(visualTextField.getText().concat(String.valueOf(operator)));
		}
		else if(e.getSource()==subButton){
			num1 = Double.parseDouble(backgroundTextField.getText());
			operator = '-';
			backgroundTextField.setText("");
			visualTextField.setText(visualTextField.getText().concat(String.valueOf(operator)));
		}
		else if(e.getSource()==mulButton){
			num1 = Double.parseDouble(backgroundTextField.getText());
			operator = '*';
			backgroundTextField.setText("");
			visualTextField.setText(visualTextField.getText().concat(String.valueOf(operator)));
		}
		else if(e.getSource()==divButton){
			num1 = Double.parseDouble(backgroundTextField.getText());
			operator = '/';
			backgroundTextField.setText("");
			visualTextField.setText(visualTextField.getText().concat(String.valueOf(operator)));
		}
		else if(e.getSource()==crlButton){
			backgroundTextField.setText("");
			visualTextField.setText("");
		}
	}

	public static void main(String[] args){
	System.out.println("working");
	}
}
