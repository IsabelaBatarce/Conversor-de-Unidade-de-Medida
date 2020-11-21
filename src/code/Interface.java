package code;

import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame{

	Interface(String title) {
		super(title);
		this.setSize(700,300);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void setMainPainel() {
		String[] messageString = {"Message1","Message2"};
		JComboBox cmbMessageList = new JComboBox(messageString);
		JTextField test = new JTextField(20);   
		JLabel label = new JLabel("Convert From");
		JComboBox cmbMessageList2 = new JComboBox(messageString);
		JTextField test2 = new JTextField(20);   
		JLabel label2 = new JLabel("To:");
		Container mainContainer = this.getContentPane();
		mainContainer.setBackground(Color.WHITE);
	
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(5));
		topPanel.setBackground(Color.WHITE);
		topPanel.add(label2);
		topPanel.add(test2);
		topPanel.add(cmbMessageList2);
		mainContainer.add(topPanel, BorderLayout.NORTH);
		
		JPanel middlePanel = new JPanel();
		middlePanel.setBackground(Color.WHITE);
		middlePanel.setLayout(new FlowLayout(10));
		middlePanel.add(label);
		middlePanel.add(test);
		middlePanel.add(cmbMessageList);
		mainContainer.add(middlePanel, BorderLayout.WEST);
	}

}