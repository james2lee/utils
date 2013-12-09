package com.james.utils;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class FileIO {
	public static void main(String[] args) throws IOException {
		//给byte数组赋初值
		byte[] bytes = new byte[10];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) (9 - i);
		}
		Long start = System.currentTimeMillis();

		testBufferedReader_BufferedWriter();
		//		testByteArrayIS(bytes);
		//		testPipedIO(bytes);
		//		fileIO();
		//		testThreadPipedIO(bytes);
		Long end = System.currentTimeMillis();
		System.out.println("耗时： " + (end - start));

	}
	
	/**
	 * 用转换流文本文件
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void testBufferedReader_BufferedWriter() throws FileNotFoundException, IOException {
		//创建输入流
		InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("D:/项目管理知识体系指南_(第4版).pdf"));
		//创建带缓冲的输入流
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		//创建输出流
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("D:/1.pdf"));
		//创建带缓冲的输出流
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
		char[] cbuf = new char[1024];
		int len = 0;
		//循环读取文件，直到文件结束
		while (bufferedReader.ready()) {
			len = bufferedReader.read(cbuf);
			bufferedWriter.write(cbuf, 0, len);
			bufferedWriter.flush();
		}
		//关闭流
		bufferedWriter.close();
		outputStreamWriter.close();
		inputStreamReader.close();
		bufferedReader.close();
	}

	private static void testThreadPipedIO(byte[] bytes) throws IOException {
		Sender sender = new Sender(bytes);
		PipedOutputStream pipedOutputStream = sender.getOutputStream();
		Receiver receiver = new Receiver();
		PipedInputStream pipedInputStream = receiver.getPipedInputStream();
		pipedOutputStream.connect(pipedInputStream);

		new Thread(sender).start();
		new Thread(receiver).start();
	}

	private static void fileIO() throws FileNotFoundException, IOException {
		FileInputStream fileInputStream = new FileInputStream("D:/JavaScript语言精粹_修订版.pdf");
		FileOutputStream fileOutputStream = new FileOutputStream("D:/1.pdf");
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		byte[] b = new byte[1024];
		int len = 0;
		while ((len = fileInputStream.read(b)) != -1) {
			//			fileOutputStream.write(fileInputStream.read());
			bufferedOutputStream.write(b, 0, len);
			bufferedOutputStream.flush();
		}
		bufferedOutputStream.close();
		fileOutputStream.close();
		fileInputStream.close();
	}

	private static void testPipedIO(byte[] bytes) throws IOException {
		//创建管理输出流
		PipedOutputStream pipedOutputStream = new PipedOutputStream();
		//创建管理输入流
		PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);
		//从输出流写入数据
		pipedOutputStream.write(bytes);
		//从输入流读出数据
		while (pipedInputStream.available() > 0) {
			int i = pipedInputStream.read();
			System.out.println(i);
		}
		pipedInputStream.close();
		pipedOutputStream.close();
	}

	/**
	 * 测试ByteArrayInputStream
	 * 
	 * @throws IOException
	 */
	private static void testByteArrayIS(byte[] bytes) throws IOException {
		//创建输入流
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		byte[] b = new byte[10];
		//从输入流读取数据
		bais.read(b);
		//输出到控制台
		for (byte c : b) {
			System.out.println(c);
		}
		//关闭输入流
		bais.close();
	}
}

/**
 * 发送线程类
 * 
 * @author James Lee
 */
class Sender extends Thread {

	private PipedOutputStream pipedOutputStream = new PipedOutputStream();
	private byte[] bytes;

	/**
	 * 构造函数，传入一个byte[]
	 * 
	 * @param bytes
	 */
	public Sender(byte[] bytes) {
		this.bytes = bytes;
	}

	/**
	 * 获取PipedOutputStream
	 * 
	 * @return
	 */
	public PipedOutputStream getOutputStream() {
		return pipedOutputStream;
	}

	/**
	 * 启动线程
	 */
	public void run() {
		try {
			pipedOutputStream.write(bytes);
			pipedOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/**
 * 接收线程类
 * 
 * @author James Lee
 */
class Receiver extends Thread {

	private PipedInputStream pipedInputStream = new PipedInputStream();

	/**
	 * 获取PipedOutputStream
	 * 
	 * @return
	 */
	public PipedInputStream getPipedInputStream() {
		return pipedInputStream;
	}

	/**
	 * 启动线程
	 */
	public void run() {
		try {
			int len;
			while ((len = pipedInputStream.read()) > 0) {
				System.out.println(len);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
