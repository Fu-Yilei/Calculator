import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calcultator extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextArea jt = new JTextArea();
	public calcultator(){
		int j = 0;
		int height = 150;
		setTitle("calculator");
		getContentPane().setLayout(null);
		Container c = getContentPane();
		setSize(440,500);
		for(int i = 0; i < 9; i++){
			if(j % 3 == 0){
				height += 60;
				j = 0;
			}
			JButton bl = new JButton("" + (i + 1));
			bl.setFont(new Font("Californian FB", Font.BOLD, 24));
			bl.setFont(UIManager.getFont("Button.font"));
			c.add(bl);
			bl.setBounds(10 + 60 * j, height , 50, 50);
			bl.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					jt.append(bl.getText());
				}
			});
			j++;
		}
		
		JButton bl =new JButton("0");
		bl.setFont(new Font("Californian FB", Font.BOLD, 24));
		bl.setFont(UIManager.getFont("Button.font"));
		bl.setBounds(70, 390, 50, 50);
		c.add(bl);
		bl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jt.append(bl.getText());
			}
		});
		
		JButton b0 = new JButton(".");
		b0.setFont(new Font("Californian FB", Font.BOLD, 24));
		b0.setBounds(130, 390, 50, 50);
		c.add(b0);
		b0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jt.append(b0.getText());				
			}
		});
		
		JButton b1 = new JButton("+");
		b1.setFont(new Font("Californian FB", Font.BOLD, 24));
		b1.setBounds(300, 210, 50, 50);
		c.add(b1);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jt.append(" " + b1.getText() + " ");				
			}
		});
		JButton b2 = new JButton("-");
		b2.setFont(new Font("Californian FB", Font.BOLD, 24));
		b2.setFont(UIManager.getFont("Button.font"));
		b2.setBounds(360, 210, 50, 50);
		c.add(b2);
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jt.append(" " + b2.getText() + " ");				
			}
		});
		JButton b3 = new JButton("*");
		b3.setFont(new Font("Californian FB", Font.BOLD, 24));
		b3.setFont(UIManager.getFont("Button.font"));
		b3.setBounds(300, 270, 50, 50);
		c.add(b3);
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jt.append(" " + b3.getText() + " ");				
			}
		});
		
		JButton b4 = new JButton("/");
		b4.setFont(new Font("Californian FB", Font.BOLD, 24));
		b4.setFont(UIManager.getFont("Button.font"));
		b4.setBounds(360, 270, 50, 50);
		c.add(b4);
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jt.append(" " + b4.getText() + " ");				
			}
		});

		JButton b5 = new JButton("=");
		b5.setFont(new Font("Californian FB", Font.BOLD, 24));
		b5.setFont(UIManager.getFont("Button.font"));
		b5.setBounds(300, 330, 50, 50);
		c.add(b5);
		b5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jt.append(" ");
				float num = transfer(jt.getText());
				jt.append("\n" + num);
			}
		});
		
		JButton b6 = new JButton("AC");
		b6.setFont(new Font("Californian FB", Font.BOLD, 24));
		b6.setFont(UIManager.getFont("Button.font"));
		b6.setBounds(360, 330, 50, 50);
		c.add(b6);
		b6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jt.setText("");
			}
		});
		jt.setBounds(10, 10, 400, 172);
		c.add(jt);

		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public float transfer(String a){
		try{
		int i, count = 0, j= 0;
		float num1 = 0, num2 = 0, result = 0;
		char ch = ' ';
		for(i = 0; i < a.length(); i++){
			if(a.charAt(i) == ' '){
				count++;
				switch(count){
					case 1:
						num1 = Float.parseFloat(a.substring(0, i));
						break;
					case 2:
						ch = a.charAt(i - 1);
						j = i;
						break;
					case 3:
						num2 = Float.parseFloat(a.substring(j + 1, i));
						break;
				}
				switch(ch){
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
				}
			}
		}
		return result;
		}
		catch(Exception e){
			jt.setText("Error, please tap \"AC\".");
		}
		return 0;
	}
	
	public static void main(String arg[]){
		new calcultator();
	}
}
