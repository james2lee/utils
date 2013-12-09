package com.james.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class TestSWT {
	public static void main(String[] args) {
		new TestSWT().run();
	}

	private void run() {
		Display display = new Display();
		Shell shell = new Shell(display);
		configureShell(shell);
		createButton(shell);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	
	private void configureShell(Shell shell) {
		shell.setText("Hello SWT");
		shell.setLayout(new GridLayout(1, false));
		shell.setSize(300, 300);
		shell.setLocation(0, 0);
	}

	
	private void createButton(final Shell shell) {
		Button button = new Button(shell,SWT.PUSH);
		button.setText("打开");
		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.CENTER;
		gridData.grabExcessHorizontalSpace=true;
		button.setLayoutData(gridData);
		
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				createDialog(shell);
			}

		});
	}
	private void createDialog(Shell shell) {
		MessageBox messageBox = new MessageBox(shell);
		messageBox.setText("对话框");
		messageBox.setMessage("这是一个对话框！");
		messageBox.open();
	}
	
}
