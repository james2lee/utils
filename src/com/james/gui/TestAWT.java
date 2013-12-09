package com.james.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * AWT demo
 * 
 * @author James Lee
 */
public class TestAWT extends Frame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new TestAWT().run();
	}

	private void run() {
		configureFrame();
		createButton();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setVisible(true);
	}

	/**
	 * 创建按钮
	 */
	private void createButton() {
		Button button = new Button("Open");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createDialog();
			}
		});

		add(button, BorderLayout.NORTH);
	}

	/**
	 * 创建对话框
	 */
	private void createDialog() {
		final Dialog dialog = new Dialog(TestAWT.this, "Dialog", true);
		dialog.setSize(new Dimension(267, 120));
		Toolkit toolkit = dialog.getToolkit();
		Dimension screenSize = toolkit.getScreenSize();

		int x = TestAWT.this.getX() + (TestAWT.this.getWidth() - dialog.getWidth()) / 2;
		if (x < 0) {
			x = 0;
		}
		if (x + dialog.getWidth() > screenSize.width) {
			x = screenSize.width - dialog.getWidth();
		}

		int y = TestAWT.this.getY() + (TestAWT.this.getHeight() - dialog.getHeight()) / 2;
		if (y < 0) {
			y = 0;
		}
		if (y + dialog.getHeight() > screenSize.height) {
			y = screenSize.height - dialog.getHeight();
		}
		
		dialog.setLocation(x, y);
		
		dialog.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				dialog.dispose();
			}
		});
		
		dialog.setLayout(new GridLayout(2,1));
		
		Panel topPanel = new Panel();
		Label label = new Label("这是一个对话框！");
		topPanel.add(label,BorderLayout.NORTH);
		dialog.add(topPanel);
		Panel buttomPanel = new Panel();
		Button button = new Button("确认");
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});
		buttomPanel.add(button,BorderLayout.SOUTH);
		dialog.add(buttomPanel);
		dialog.setVisible(true);
		
	}

	/**
	 * 创建主窗口
	 */
	private void configureFrame() {
		setTitle("My AWT");
		setLayout(new FlowLayout());
		setSize(new Dimension(300, 300));
		setLocation(100, 100);
	}
}
