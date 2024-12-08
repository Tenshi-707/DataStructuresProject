package dataStructuresProject;


import java.awt.*;
import javax.swing.*;

public class ClassGrade {
	
	public ClassGrade() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0, 1));
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Class Manager");
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new ClassGrade();
	}

}
