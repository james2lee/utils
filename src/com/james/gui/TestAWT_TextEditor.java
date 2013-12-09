package com.james.gui;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class TestAWT_TextEditor extends WindowAdapter implements ActionListener {

	private Frame frame;	//主窗体
	private TextArea textArea;	//文本输入区域
	private String filename;	//打开的文件名

	public static void main(String[] args) {
		TestAWT_TextEditor testTextEditor = new TestAWT_TextEditor();
		testTextEditor.createEditor();
	}

	public void createEditor() {
		//建立菜单文件
		MenuBar menuBar = new MenuBar();
		menuBar.setFont(new Font("simsunb.ttf", Font.BOLD, 14));
		Menu menuFile = new Menu("\u65b0\u5efa");	//文件
		menuFile.setFont(new Font("simsunb.ttf", Font.BOLD, 14));
		MenuItem menuNew = new MenuItem("\u65b0\u5efa");	//新建
		menuFile.add(menuNew);
		MenuItem menuOpen = new MenuItem("\u6253\u5f00");	//打开
		menuFile.add(menuOpen);
		MenuItem menuSave = new MenuItem("\u4fdd\u5b58");	//保存
		menuFile.add(menuSave);
		menuFile.add("\u53e6\u5b58\u4e3a...");	//另存为
		menuFile.addSeparator();
		menuFile.add("\u9000\u51fa");	//退出
		menuFile.addActionListener(this);	//注册菜单单击事件监听器
		menuBar.add(menuFile);

		//建立帮助菜单
		Menu menuHelp = new Menu("\u5e2e\u52a9");	//帮助
		menuHelp.setFont(new Font("新宋体", Font.BOLD, 14));
		menuHelp.add("\u5173\u4e8e");	//关于
		menuHelp.addActionListener(this);	//注册菜单单击事件监听器
		menuBar.setHelpMenu(menuHelp);

		//主窗口
		frame = new JFrame("Java \u6587\u672c\u7f16\u8f91\u5668");	//文本编辑器
		frame.setFont(new Font("simsunb.ttf", Font.BOLD, 14));
		frame.setMenuBar(menuBar);
		textArea = new TextArea();
		textArea.setFont(new Font("simsunb.ttf", Font.BOLD, 14));
		frame.add("Center", textArea);
		frame.addWindowListener(this);	//注册窗口关闭监听器
		frame.setSize(800, 600);
		frame.setVisible(true);
	}

	//菜单选择事件
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getActionCommand() == "\u65b0\u5efa") {	//新建
				textArea.setText("");
			} else if (e.getActionCommand() == "\u6253\u5f00") {
				//选择文件
				FileDialog fileOpen = new FileDialog(frame, "Open", 0);
				fileOpen.setVisible(true);
				filename = fileOpen.getDirectory() + fileOpen.getFile();
				//读取文件
				FileReader fileReader = new FileReader(filename);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String s = "";
				while (bufferedReader.ready()) {
					int c = bufferedReader.read();
					s+=(char)c;
				}
				textArea.setText(s);
				bufferedReader.close();
				fileReader.close();
				frame.setTitle("Java \u6587\u672c\u7f16\u8f91\u5668 - " + filename);
			} else if (e.getActionCommand() == "\u4fdd\u5b58") {	//保存
				//写入文件
				FileWriter fileWriter = new FileWriter(new File(filename), true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				PrintWriter printWriter = new PrintWriter(bufferedWriter);
				//写入对象数据
				printWriter.print(textArea.getText());
				//关闭输出流
				printWriter.close();
				bufferedWriter.close();
				fileWriter.close();

			} else if (e.getActionCommand() == "\u53e6\u5b58\u4e3a...") {	//另存为
				//选择文件
				FileDialog fileDialog = new FileDialog(frame, "Open", 0);
				fileDialog.setVisible(true);
				filename = fileDialog.getDirectory() + fileDialog.getFile();
				//写入文件
				FileWriter fileWriter = new FileWriter(new File(filename), true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				PrintWriter printWriter = new PrintWriter(bufferedWriter);
				//写入对象数据
				printWriter.print(textArea.getText());
				//关闭输出流
				printWriter.close();
				bufferedWriter.close();
				fileWriter.close();
			} else if (e.getActionCommand() == "\u9000\u51fa") {	//退出
				System.exit(0);
			} else if (e.getActionCommand() == "\u5173\u4e8e") {	//关于
				//显示关于对话框
				final JDialog dialog = new JDialog(frame, "\u5173\u4e8e", true);	//关于
				dialog.setSize(200, 130);
				dialog.setLayout(new GridLayout(2, 1));
				//窗口关闭事件
				dialog.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						dialog.dispose();
					}
				});
				//显示消息
				Panel panel = new Panel();
				Label label = new Label("Java \u6587\u672c\u7f16\u8f91\u5668 - \u4f5c\u8005：James Lee");	//文本编辑器 - 作者
				panel.add(label, BorderLayout.NORTH);
				dialog.add(panel);
				dialog.setVisible(true);
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
