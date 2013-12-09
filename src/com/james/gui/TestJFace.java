package com.james.gui;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class TestJFace extends ApplicationWindow{
	public TestJFace() {
		super(null);
		
	}

	public static void main(String[] args) {
		new TestJFace().run();
	}

	private void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}
	
	

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		
		shell.setText("Hello JFace");
		shell.setSize(300,300);
		shell.setLocation(0,0);
		
	}
	
	protected Control createContents(final Composite parent) {
		Composite composite = new Composite(parent, SWT.None);
		composite.setLayout(new GridLayout(1,false));
		createButton(composite);
		return composite;
	}
	
	private void createButton(Composite composite) {
		Button button = new Button(composite, SWT.PUSH);
		button.setText("打开");
		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.CENTER;
		gridData.grabExcessHorizontalSpace = true;
		button.setLayoutData(gridData);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				createDialog();
			}
		});
	}
	
	
	private void createDialog() {
		MessageDialog.openInformation(Display.getCurrent().getShells()[0], "对话框", "这是一个对话框");
	}

}
