package com.james.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TestSwing extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new TestSwing().run();
	}

	private void run() {
		configureJFrame();
		createButton();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		setVisible(true);
	}

	private void configureJFrame() {
		setTitle("Hello Swing");
		getContentPane().setLayout(new FlowLayout());
		setSize(new Dimension(300,300));
		setLocation(0, 0);
	}
	
	private void createButton() {
		Button button = new Button("Open");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				createDialog();
			}

		});
		getContentPane().add(button, BorderLayout.NORTH);
	}
	private void createDialog() {
		JOptionPane.showMessageDialog(TestSwing.this, "这是一个对话框","对话框",JOptionPane.INFORMATION_MESSAGE);
	}

}
