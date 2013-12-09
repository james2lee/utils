package com.james.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.HeadlessException;
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
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TestSwing_TextEditor extends WindowAdapter implements ActionListener {
	
	private JFrame jFrame;	//主窗体
	private JTextArea jTextArea;	//文本区
	private String filename;	//打开的文件名
	private JScrollPane jScrollPane;	//滚动面板
	
	public static void main(String[] args) {
		TestSwing_TextEditor textEditor = new TestSwing_TextEditor();
		textEditor.createEditor();
	}
	
	public void createEditor(){
		//建立菜单条
		JMenuBar menuBar = new JMenuBar();
		//建立文件菜单
		JMenu menuFile = new JMenu("文件");
		//新建菜单项
		JMenuItem menuNew = new JMenuItem("新建");
		menuNew.addActionListener(this);	//监听事件
		menuFile.add(menuNew);	//添加到“文件”菜单
		//打开菜单项
		JMenuItem menuOpen = new JMenuItem("打开");
		menuOpen.addActionListener(this);
		menuFile.add(menuOpen);
		//保存菜单项
		JMenuItem menuSave = new JMenuItem("保存");
		menuSave.addActionListener(this);
		menuFile.add(menuSave);
		//另存为菜单项
		JMenuItem menuSaveAS = new JMenuItem("另存为...");
		menuSaveAS.addActionListener(this);
		menuFile.add(menuSaveAS);
		//添加分隔条
		menuFile.addSeparator();
		//退出菜单项
		JMenuItem menuExit = new JMenuItem("退出");
		menuExit.addActionListener(this);
		menuFile.add(menuExit);
		//将"文件"菜单添加到菜单条
		menuBar.add(menuFile);
		
		//建立帮助菜单
		JMenu menuHelp = new JMenu("帮助");
		JMenuItem menuAbout = new JMenuItem("关于");
		menuAbout.addActionListener(this);
		menuHelp.add(menuAbout);
		//将"帮助"菜单添加到菜单条
		menuBar.add(menuHelp);
		
		
		//主窗口
		jFrame = new JFrame("Java Swing 文本编辑器");
		//给主窗口添加菜单
		jFrame.setJMenuBar(menuBar);
		//创建文本编辑区
		jTextArea = new JTextArea();
		//将文本编辑区添加到滚动面板
		jScrollPane = new JScrollPane(jTextArea);
		//给主窗口添加滚动面板 
		jFrame.add(jScrollPane);
		jFrame.addWindowListener(this);	//注册窗口关闭监听器
		jFrame.setSize(800, 600);
		jFrame.setVisible(true);
		
	}
	
	//菜单选择事件
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getActionCommand() == "新建") {
				jTextArea.setText("");
				jFrame.setTitle("Java Swing 文本编辑器");
			}else if (e.getActionCommand() == "打开") {
				//选择文件
				JFileChooser jFileChooser = new JFileChooser();
				int result = jFileChooser.showOpenDialog(jFrame);
				if (result == JFileChooser.APPROVE_OPTION) {
					File file = jFileChooser.getSelectedFile();
					filename = file.getAbsolutePath();
					//读取文件
					BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
					String string = "";
					while (bufferedReader.ready()) {
						int c = bufferedReader.read();
						string += (char)c;
					}
					jTextArea.setText(string);
					bufferedReader.close();
					jFrame.setTitle("Java Swing 文本编辑器 - " + filename);
				}
			}else if (e.getActionCommand() == "保存") {
				//选择文件
				JFileChooser jFileChooser = new JFileChooser();
				int result = jFileChooser.showOpenDialog(jFrame);
				if (result == JFileChooser.APPROVE_OPTION) {
					File file = jFileChooser.getSelectedFile();
					filename = file.getAbsolutePath();
					//写入文件
					PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file,true)));
					//写入对象数据
					printWriter.print(jTextArea.getText());
					printWriter.close();
					jFrame.setTitle("Java Swing 文本编辑器 - " + filename);
				}
			}else if (e.getActionCommand() == "另存为...") {
				//选择文件
				JFileChooser jFileChooser = new JFileChooser();
				int result = jFileChooser.showOpenDialog(jFrame);
				if (result == JFileChooser.APPROVE_OPTION) {
					File file = jFileChooser.getSelectedFile();
					filename = file.getAbsolutePath();
					//写入文件
					PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file,true)));
					//写入对象数据
					printWriter.print(jTextArea.getText());
					printWriter.close();
					jFrame.setTitle("Java Swing 文本编辑器 - " + filename);
				}
			}else if (e.getActionCommand() == "退出") {
				System.exit(0);
			}else if (e.getActionCommand() == "关于") {
				//显示关于对话框
				final JDialog jDialog = new JDialog(jFrame,"关于",true);
				jDialog.setSize(300, 150);
				jDialog.setLayout(new GridLayout(2, 1));
				
				//窗口关闭事件
				jDialog.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e){
						jDialog.dispose();
					}
				});
				
				//显示消息
				JPanel jPanel = new JPanel();
				JLabel jLabel = new JLabel("Java Swing 文本编辑器 - 作者：James Lee");
				jPanel.add(jLabel,BorderLayout.NORTH);
				jDialog.add(jPanel);
				jDialog.setVisible(true);
			}
		} catch (HeadlessException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	//关闭窗体事件
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}

}
