import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;


/*
 * Austin Johnson
 * Playable Sudoku
 * GUI built with WindowBuilder
 */
public class SudokuGUI {

	protected Shell shell;
	private Text txtConsole;
	
	//Global Variables	
	Button[][] gameButtons;
	String currentDigit;
	String[][] board;
	boolean firstPuzzle;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SudokuGUI window = new SudokuGUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(568, 484);
		shell.setText("Austin's Sudoku V1.0");
		
		//Initialize Global Variables
		gameButtons = new Button[9][9];
		firstPuzzle = true;
		currentDigit = "d";
		board = new String[9][9];
		
		//Fill Board with Blanks
		for (int x = 0; x < 9; x++){
			
			for (int y = 0; y < 9; y++){
				
				board[x][y] = "";
				
			}
			
		}
		
		//Gameplay Buttons
		
		final Button btn10 = new Button(shell, SWT.NONE);
		btn10.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn10.setEnabled(false);
		btn10.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn10, 1, 0);
				
			}
		});
		btn10.setBounds(56, 10, 40, 40);
		gameButtons[1][0] = btn10;
		
		final Button btn20 = new Button(shell, SWT.NONE);
		btn20.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn20.setEnabled(false);
		btn20.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn20, 2, 0);
				
			}
		});
		btn20.setBounds(102, 10, 40, 40);
		gameButtons[2][0] = btn20;
		
		final Button btn00 = new Button(shell, SWT.NONE);
		btn00.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn00.setEnabled(false);
		btn00.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn00, 0, 0);
				
			}
		});
		btn00.setBounds(10, 10, 40, 40);
		gameButtons[0][0] = btn00;
		
		final Button btn21 = new Button(shell, SWT.NONE);
		btn21.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn21.setEnabled(false);
		btn21.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn21, 2, 1);
				
			}
		});
		btn21.setBounds(102, 56, 40, 40);
		gameButtons[2][1] = btn21;
		
		final Button btn11 = new Button(shell, SWT.NONE);
		btn11.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn11.setEnabled(false);
		btn11.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn11, 1, 1);
				
			}
		});
		btn11.setBounds(56, 56, 40, 40);
		gameButtons[1][1] = btn11;
		
		final Button btn01 = new Button(shell, SWT.NONE);
		btn01.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn01.setEnabled(false);
		btn01.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn01, 0, 1);
				
			}
		});
		btn01.setBounds(10, 56, 40, 40);
		gameButtons[0][1] = btn01;
		
		final Button btn22 = new Button(shell, SWT.NONE);
		btn22.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn22.setEnabled(false);
		btn22.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn22, 2, 2);
				
			}
		});
		btn22.setBounds(102, 102, 40, 40);
		gameButtons[2][2] = btn22;
		
		final Button btn12 = new Button(shell, SWT.NONE);
		btn12.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn12.setEnabled(false);
		btn12.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn12, 1, 2);
				
			}
		});
		btn12.setBounds(56, 102, 40, 40);
		gameButtons[1][2] = btn12;
		
		final Button btn02 = new Button(shell, SWT.NONE);
		btn02.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn02.setEnabled(false);
		btn02.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn02, 0, 2);
				
			}
		});
		btn02.setBounds(10, 102, 40, 40);
		gameButtons[0][2] = btn02;
		
		final Button btn30 = new Button(shell, SWT.NONE);
		btn30.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn30.setEnabled(false);
		btn30.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn30, 3, 0);
				
			}
		});
		btn30.setBounds(160, 10, 40, 40);
		gameButtons[3][0] = btn30;
		
		final Button btn31 = new Button(shell, SWT.NONE);
		btn31.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn31.setEnabled(false);
		btn31.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn31, 3, 1);
				
			}
		});
		btn31.setBounds(160, 56, 40, 40);
		gameButtons[3][1] = btn31;
		
		final Button btn32 = new Button(shell, SWT.NONE);
		btn32.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn32.setEnabled(false);
		btn32.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn32, 3, 2);
				
			}
		});
		btn32.setBounds(160, 102, 40, 40);
		gameButtons[3][2] = btn32;
		
		final Button btn42 = new Button(shell, SWT.NONE);
		btn42.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn42.setEnabled(false);
		btn42.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn42, 4, 2);
				
			}
		});
		btn42.setBounds(206, 102, 40, 40);
		gameButtons[4][2] = btn42;
		
		final Button btn41 = new Button(shell, SWT.NONE);
		btn41.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn41.setEnabled(false);
		btn41.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn41, 4, 1);
				
			}
		});
		btn41.setBounds(206, 56, 40, 40);
		gameButtons[4][1] = btn41;
		
		final Button btn40 = new Button(shell, SWT.NONE);
		btn40.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn40.setEnabled(false);
		btn40.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn40, 4, 0);
				
			}
		});
		btn40.setBounds(206, 10, 40, 40);
		gameButtons[4][0] = btn40;
		
		final Button btn50 = new Button(shell, SWT.NONE);
		btn50.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn50.setEnabled(false);
		btn50.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn50, 5, 0);
				
			}
		});
		btn50.setBounds(252, 10, 40, 40);
		gameButtons[5][0] = btn50;
		
		final Button btn51 = new Button(shell, SWT.NONE);
		btn51.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn51.setEnabled(false);
		btn51.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn51, 5, 1);
				
			}
		});
		btn51.setBounds(252, 56, 40, 40);
		gameButtons[5][1] = btn51;
		
		final Button btn52 = new Button(shell, SWT.NONE);
		btn52.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn52.setEnabled(false);
		btn52.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn52, 5, 2);
				
			}
		});
		btn52.setBounds(252, 102, 40, 40);
		gameButtons[5][2] = btn52;
		
		final Button btn60 = new Button(shell, SWT.NONE);
		btn60.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn60.setEnabled(false);
		btn60.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn60, 6, 0);
				
			}
		});
		btn60.setBounds(308, 10, 40, 40);
		gameButtons[6][0] = btn60;
		
		final Button btn61 = new Button(shell, SWT.NONE);
		btn61.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn61.setEnabled(false);
		btn61.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn61, 6, 1);
				
			}
		});
		btn61.setBounds(308, 56, 40, 40);
		gameButtons[6][1] = btn61;
		
		final Button btn62 = new Button(shell, SWT.NONE);
		btn62.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn62.setEnabled(false);
		btn62.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn62, 6, 2);
				
			}
		});
		btn62.setBounds(308, 102, 40, 40);
		gameButtons[6][2] = btn62;
		
		final Button btn72 = new Button(shell, SWT.NONE);
		btn72.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn72.setEnabled(false);
		btn72.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn72, 7, 2);
				
			}
		});
		btn72.setBounds(354, 102, 40, 40);
		gameButtons[7][2] = btn72;
		
		final Button btn71 = new Button(shell, SWT.NONE);
		btn71.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn71.setEnabled(false);
		btn71.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn71, 7, 1);
				
			}
		});
		btn71.setBounds(354, 56, 40, 40);
		gameButtons[7][1] = btn71;
		
		final Button btn70 = new Button(shell, SWT.NONE);
		btn70.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn70.setEnabled(false);
		btn70.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn70, 7, 0);
				
			}
		});
		btn70.setBounds(354, 10, 40, 40);
		gameButtons[7][0] = btn70;
		
		final Button btn80 = new Button(shell, SWT.NONE);
		btn80.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn80.setEnabled(false);
		btn80.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn80, 8, 0);
				
			}
		});
		btn80.setBounds(400, 10, 40, 40);
		gameButtons[8][0] = btn80;
		
		final Button btn81 = new Button(shell, SWT.NONE);
		btn81.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn81.setEnabled(false);
		btn81.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn81, 8, 1);
				
			}
		});
		btn81.setBounds(400, 56, 40, 40);
		gameButtons[8][1] = btn81;
		
		final Button btn82 = new Button(shell, SWT.NONE);
		btn82.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn82.setEnabled(false);
		btn82.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn82, 8, 2);
				
			}
		});
		btn82.setBounds(400, 102, 40, 40);
		gameButtons[8][2] = btn82;
		
		final Button btn03 = new Button(shell, SWT.NONE);
		btn03.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn03.setEnabled(false);
		btn03.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn03, 0, 3);
				
			}
		});
		btn03.setBounds(10, 156, 40, 40);
		gameButtons[0][3] = btn03;
		
		final Button btn04 = new Button(shell, SWT.NONE);
		btn04.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn04.setEnabled(false);
		btn04.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn04, 0, 4);
				
			}
		});
		btn04.setBounds(10, 202, 40, 40);
		gameButtons[0][4] = btn04;
		
		final Button btn05 = new Button(shell, SWT.NONE);
		btn05.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn05.setEnabled(false);
		btn05.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn05, 0, 5);
				
			}
		});
		btn05.setBounds(10, 248, 40, 40);
		gameButtons[0][5] = btn05;
		
		final Button btn15 = new Button(shell, SWT.NONE);
		btn15.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn15.setEnabled(false);
		btn15.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn15, 1, 5);
				
			}
		});
		btn15.setBounds(56, 248, 40, 40);
		gameButtons[1][5] = btn15;
		
		final Button btn14 = new Button(shell, SWT.NONE);
		btn14.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn14.setEnabled(false);
		btn14.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn14, 1, 4);
				
			}
		});
		btn14.setBounds(56, 202, 40, 40);
		gameButtons[1][4] = btn14;
		
		final Button btn13 = new Button(shell, SWT.NONE);
		btn13.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn13.setEnabled(false);
		btn13.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn13, 1, 3);
				
			}
		});
		btn13.setBounds(56, 156, 40, 40);
		gameButtons[1][3] = btn13;
		
		final Button btn23 = new Button(shell, SWT.NONE);
		btn23.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn23.setEnabled(false);
		btn23.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn23, 2, 3);
				
			}
		});
		btn23.setBounds(102, 156, 40, 40);
		gameButtons[2][3] = btn23;
		
		final Button btn24 = new Button(shell, SWT.NONE);
		btn24.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn24.setEnabled(false);
		btn24.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn24, 2, 4);
				
			}
		});
		btn24.setBounds(102, 202, 40, 40);
		gameButtons[2][4] = btn24;
		
		final Button btn25 = new Button(shell, SWT.NONE);
		btn25.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn25.setEnabled(false);
		btn25.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn25, 2, 5);
				
			}
		});
		btn25.setBounds(102, 248, 40, 40);
		gameButtons[2][5] = btn25;
		
		final Button btn33 = new Button(shell, SWT.NONE);
		btn33.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn33.setEnabled(false);
		btn33.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn33, 3, 3);
				
			}
		});
		btn33.setBounds(160, 156, 40, 40);
		gameButtons[3][3] = btn33;
		
		final Button btn34 = new Button(shell, SWT.NONE);
		btn34.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn34.setEnabled(false);
		btn34.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn34, 3, 4);
				
			}
		});
		btn34.setBounds(160, 202, 40, 40);
		gameButtons[3][4] = btn34;
		
		final Button btn35 = new Button(shell, SWT.NONE);
		btn35.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn35.setEnabled(false);
		btn35.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn35, 3, 5);
				
			}
		});
		btn35.setBounds(160, 248, 40, 40);
		gameButtons[3][5] = btn35;
		
		final Button btn45 = new Button(shell, SWT.NONE);
		btn45.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn45.setEnabled(false);
		btn45.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn45, 4, 5);
				
			}
		});
		btn45.setBounds(206, 248, 40, 40);
		gameButtons[4][5] = btn45;
		
		final Button btn44 = new Button(shell, SWT.NONE);
		btn44.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn44.setEnabled(false);
		btn44.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn44, 4, 4);
				
			}
		});
		btn44.setBounds(206, 202, 40, 40);
		gameButtons[4][4] = btn44;
		
		final Button btn43 = new Button(shell, SWT.NONE);
		btn43.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn43.setEnabled(false);
		btn43.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn43, 4, 3);
				
			}
		});
		btn43.setBounds(206, 156, 40, 40);
		gameButtons[4][3] = btn43;
		
		final Button btn53 = new Button(shell, SWT.NONE);
		btn53.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn53.setEnabled(false);
		btn53.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn53, 5, 3);
				
			}
		});
		btn53.setBounds(252, 156, 40, 40);
		gameButtons[5][3] = btn53;
		
		final Button btn54 = new Button(shell, SWT.NONE);
		btn54.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn54.setEnabled(false);
		btn54.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn54, 5, 4);
				
			}
		});
		btn54.setBounds(252, 202, 40, 40);
		gameButtons[5][4] = btn54;
		
		final Button btn55 = new Button(shell, SWT.NONE);
		btn55.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn55.setEnabled(false);
		btn55.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn55, 5, 5);
				
			}
		});
		btn55.setBounds(252, 248, 40, 40);
		gameButtons[5][5] = btn55;
		
		final Button btn63 = new Button(shell, SWT.NONE);
		btn63.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn63.setEnabled(false);
		btn63.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn63, 6, 3);
				
			}
		});
		btn63.setBounds(308, 156, 40, 40);
		gameButtons[6][3] = btn63;
		
		final Button btn64 = new Button(shell, SWT.NONE);
		btn64.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn64.setEnabled(false);
		btn64.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn64, 6, 4);
				
			}
		});
		btn64.setBounds(308, 202, 40, 40);
		gameButtons[6][4] = btn64;
		
		final Button btn65 = new Button(shell, SWT.NONE);
		btn65.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn65.setEnabled(false);
		btn65.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn65, 6, 5);
				
			}
		});
		btn65.setBounds(308, 248, 40, 40);
		gameButtons[6][5] = btn65;
		
		final Button btn75 = new Button(shell, SWT.NONE);
		btn75.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn75.setEnabled(false);
		btn75.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn75, 7, 5);
				
			}
		});
		btn75.setBounds(354, 248, 40, 40);
		gameButtons[7][5] = btn75;
		
		final Button btn74 = new Button(shell, SWT.NONE);
		btn74.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn74.setEnabled(false);
		btn74.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn74, 7, 4);
				
			}
		});
		btn74.setBounds(354, 202, 40, 40);
		gameButtons[7][4] = btn74;
		
		final Button btn73 = new Button(shell, SWT.NONE);
		btn73.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn73.setEnabled(false);
		btn73.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn73, 7, 3);
				
			}
		});
		btn73.setBounds(354, 156, 40, 40);
		gameButtons[7][3] = btn73;
		
		final Button btn83 = new Button(shell, SWT.NONE);
		btn83.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn83.setEnabled(false);
		btn83.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn83, 8, 3);
				
			}
		});
		btn83.setBounds(400, 156, 40, 40);
		gameButtons[8][3] = btn83;
		
		final Button btn84 = new Button(shell, SWT.NONE);
		btn84.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn84.setEnabled(false);
		btn84.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn84, 8, 4);
				
			}
		});
		btn84.setBounds(400, 202, 40, 40);
		gameButtons[8][4] = btn84;
		
		final Button btn85 = new Button(shell, SWT.NONE);
		btn85.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn85.setEnabled(false);
		btn85.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn85, 8, 5);
				
			}
		});
		btn85.setBounds(400, 248, 40, 40);
		gameButtons[8][5] = btn85;
		
		final Button btn06 = new Button(shell, SWT.NONE);
		btn06.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn06.setEnabled(false);
		btn06.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn06, 0, 6);
				
			}
		});
		btn06.setBounds(10, 302, 40, 40);
		gameButtons[0][6] = btn06;
		
		final Button btn07 = new Button(shell, SWT.NONE);
		btn07.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn07.setEnabled(false);
		btn07.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn07, 0, 7);
				
			}
		});
		btn07.setBounds(10, 348, 40, 40);
		gameButtons[0][7] = btn07;
		
		final Button btn08 = new Button(shell, SWT.NONE);
		btn08.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn08.setEnabled(false);
		btn08.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn08, 0, 8);
				
			}
		});
		btn08.setBounds(10, 394, 40, 40);
		gameButtons[0][8] = btn08;
		
		final Button btn18 = new Button(shell, SWT.NONE);
		btn18.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn18.setEnabled(false);
		btn18.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn18, 1, 8);
				
			}
		});
		btn18.setBounds(56, 394, 40, 40);
		gameButtons[1][8] = btn18;
		
		final Button btn17 = new Button(shell, SWT.NONE);
		btn17.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn17.setEnabled(false);
		btn17.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn17, 1, 7);
				
			}
		});
		btn17.setBounds(56, 348, 40, 40);
		gameButtons[1][7] = btn17;
		
		final Button btn16 = new Button(shell, SWT.NONE);
		btn16.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn16.setEnabled(false);
		btn16.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn16, 1, 6);
				
			}
		});
		btn16.setBounds(56, 302, 40, 40);
		gameButtons[1][6] = btn16;
		
		final Button btn26 = new Button(shell, SWT.NONE);
		btn26.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn26.setEnabled(false);
		btn26.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn26, 2, 6);
				
			}
		});
		btn26.setBounds(102, 302, 40, 40);
		gameButtons[2][6] = btn26;
		
		final Button btn27 = new Button(shell, SWT.NONE);
		btn27.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn27.setEnabled(false);
		btn27.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn27, 2, 7);
				
			}
		});
		btn27.setBounds(102, 348, 40, 40);
		gameButtons[2][7] = btn27;
		
		final Button btn28 = new Button(shell, SWT.NONE);
		btn28.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn28.setEnabled(false);
		btn28.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn28, 2, 8);
				
			}
		});
		btn28.setBounds(102, 394, 40, 40);
		gameButtons[2][8] = btn28;
		
		final Button btn36 = new Button(shell, SWT.NONE);
		btn36.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn36.setEnabled(false);
		btn36.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn36, 3, 6);
				
			}
		});
		btn36.setBounds(160, 302, 40, 40);
		gameButtons[3][6] = btn36;
		
		final Button btn37 = new Button(shell, SWT.NONE);
		btn37.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn37.setEnabled(false);
		btn37.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn37, 3, 7);
				
			}
		});
		btn37.setBounds(160, 348, 40, 40);
		gameButtons[3][7] = btn37;
		
		final Button btn38 = new Button(shell, SWT.NONE);
		btn38.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn38.setEnabled(false);
		btn38.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn38, 3, 8);
				
			}
		});
		btn38.setBounds(160, 394, 40, 40);
		gameButtons[3][8] = btn38;
		
		final Button btn48 = new Button(shell, SWT.NONE);
		btn48.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn48.setEnabled(false);
		btn48.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn48, 4, 8);
				
			}
		});
		btn48.setBounds(206, 394, 40, 40);
		gameButtons[4][8] = btn48;
		
		final Button btn47 = new Button(shell, SWT.NONE);
		btn47.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn47.setEnabled(false);
		btn47.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn47, 4, 7);
				
			}
		});
		btn47.setBounds(206, 348, 40, 40);
		gameButtons[4][7] = btn47;
		
		final Button btn46 = new Button(shell, SWT.NONE);
		btn46.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn46.setEnabled(false);
		btn46.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn46, 4, 6);
				
			}
		});
		btn46.setBounds(206, 302, 40, 40);
		gameButtons[4][6] = btn46;
		
		final Button btn56 = new Button(shell, SWT.NONE);
		btn56.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn56.setEnabled(false);
		btn56.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn56, 5, 6);
				
			}
		});
		btn56.setBounds(252, 302, 40, 40);
		gameButtons[5][6] = btn56;
		
		final Button btn57 = new Button(shell, SWT.NONE);
		btn57.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn57.setEnabled(false);
		btn57.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn57, 5, 7);
				
			}
		});
		btn57.setBounds(252, 348, 40, 40);
		gameButtons[5][7] = btn57;
		
		final Button btn58 = new Button(shell, SWT.NONE);
		btn58.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn58.setEnabled(false);
		btn58.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn58, 5, 8);
				
			}
		});
		btn58.setBounds(252, 394, 40, 40);
		gameButtons[5][8] = btn58;
		
		final Button btn66 = new Button(shell, SWT.NONE);
		btn66.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn66.setEnabled(false);
		btn66.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn66, 6, 6);
				
			}
		});
		btn66.setBounds(308, 302, 40, 40);
		gameButtons[6][6] = btn66;
		
		final Button btn67 = new Button(shell, SWT.NONE);
		btn67.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn67.setEnabled(false);
		btn67.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn67, 6, 7);
				
			}
		});
		btn67.setBounds(308, 348, 40, 40);
		gameButtons[6][7] = btn67;
		
		final Button btn68 = new Button(shell, SWT.NONE);
		btn68.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn68.setEnabled(false);
		btn68.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn68, 6, 8);
				
			}
		});
		btn68.setBounds(308, 394, 40, 40);
		gameButtons[6][8] = btn68;
		
		final Button btn78 = new Button(shell, SWT.NONE);
		btn78.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn78.setEnabled(false);
		btn78.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn78, 7, 8);
				
			}
		});
		btn78.setBounds(354, 394, 40, 40);
		gameButtons[7][8] = btn78;
		
		final Button btn77 = new Button(shell, SWT.NONE);
		btn77.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn77.setEnabled(false);
		btn77.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn77, 7, 7);
				
			}
		});
		btn77.setBounds(354, 348, 40, 40);
		gameButtons[7][7] = btn77;
		
		final Button btn76 = new Button(shell, SWT.NONE);
		btn76.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn76.setEnabled(false);
		btn76.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn76, 7, 6);
				
			}
		});
		btn76.setBounds(354, 302, 40, 40);
		gameButtons[7][6] = btn76;
		
		final Button btn86 = new Button(shell, SWT.NONE);
		btn86.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn86.setEnabled(false);
		btn86.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn86, 8, 6);
				
			}
		});
		btn86.setBounds(400, 302, 40, 40);
		gameButtons[8][6] = btn86;
		
		final Button btn87 = new Button(shell, SWT.NONE);
		btn87.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn87.setEnabled(false);
		btn87.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn87, 8, 7);
				
			}
		});
		btn87.setBounds(400, 348, 40, 40);
		gameButtons[8][7] = btn87;
		
		final Button btn88 = new Button(shell, SWT.NONE);
		btn88.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		btn88.setEnabled(false);
		btn88.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				gameButtonPressed(btn88, 8, 8);
				
			}
		});
		btn88.setBounds(400, 394, 40, 40);
		gameButtons[8][8] = btn88;
		
		//Radio Buttons
		
		Button radio1 = new Button(shell, SWT.RADIO);
		radio1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				currentDigit = "1";
				
			}
		});
		radio1.setBounds(455, 10, 52, 16);
		radio1.setText("1");
		
		Button radio2 = new Button(shell, SWT.RADIO);
		radio2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				currentDigit = "2";
				
			}
		});
		radio2.setText("2");
		radio2.setBounds(455, 32, 52, 16);
		
		Button radio3 = new Button(shell, SWT.RADIO);
		radio3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				currentDigit = "3";
				
			}
		});
		radio3.setText("3");
		radio3.setBounds(455, 54, 52, 16);
		
		Button radio4 = new Button(shell, SWT.RADIO);
		radio4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				currentDigit = "4";
				
			}
		});
		radio4.setText("4");
		radio4.setBounds(455, 76, 52, 16);
		
		Button radio5 = new Button(shell, SWT.RADIO);
		radio5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				currentDigit = "5";
				
			}
		});
		radio5.setText("5");
		radio5.setBounds(455, 98, 52, 16);
		
		Button radio6 = new Button(shell, SWT.RADIO);
		radio6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				currentDigit = "6";
				
			}
		});
		radio6.setText("6");
		radio6.setBounds(455, 120, 52, 16);
		
		Button radio7 = new Button(shell, SWT.RADIO);
		radio7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				currentDigit = "7";
				
			}
		});
		radio7.setText("7");
		radio7.setBounds(455, 142, 52, 16);
		
		Button radio8 = new Button(shell, SWT.RADIO);
		radio8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				currentDigit = "8";
				
			}
		});
		radio8.setText("8");
		radio8.setBounds(455, 164, 52, 16);
		
		Button radio9 = new Button(shell, SWT.RADIO);
		radio9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				currentDigit = "9";
				
			}
		});
		radio9.setText("9");
		radio9.setBounds(455, 186, 52, 16);
		
		Button radioBlank = new Button(shell, SWT.RADIO);
		radioBlank.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				currentDigit = "";
				
			}
		});
		radioBlank.setText("Blank");
		radioBlank.setBounds(455, 208, 52, 16);
		
		Button btnDirectInput = new Button(shell, SWT.RADIO);
		btnDirectInput.setSelection(true);
		btnDirectInput.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				currentDigit = "d";
				
			}
		});
		btnDirectInput.setBounds(455, 264, 90, 16);
		btnDirectInput.setText("Direct Input");
		
		//Lines
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(446, 10, 3, 424);
		
		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(10, 148, 430, 2);
		
		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(10, 294, 430, 2);
		
		Label label_3 = new Label(shell, SWT.SEPARATOR);
		label_3.setBounds(151, 10, 3, 424);
		
		Label label_4 = new Label(shell, SWT.SEPARATOR);
		label_4.setBounds(299, 10, 3, 424);
		
		//Option Buttons
		
		Button btnNew = new Button(shell, SWT.NONE);
		btnNew.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//Confirm New Puzzle if it is not the first time the button has been pressed.
				if (firstPuzzle){
					
					newPuzzlePressed();
					firstPuzzle = false;
					
				} else {
					
					MessageBox confirmation = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
					int confirmationAnswer;
					
					confirmation.setText("Confirm New Puzzle");
					confirmation.setMessage("Are you sure you want to start a new puzzle?");
					
					confirmationAnswer = confirmation.open();
					
					if (confirmationAnswer == 64){
						
						newPuzzlePressed();
						
					}
					
				}				
				
			}
		});
		btnNew.setBounds(455, 347, 90, 25);
		btnNew.setText("New Puzzle");
		
		Button btnCheck = new Button(shell, SWT.NONE);
		btnCheck.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				checkButtonPressed();
				
			}
		});
		btnCheck.setText("Check If Solved");
		btnCheck.setBounds(455, 378, 90, 25);
		
		//Text Console
		
		txtConsole = new Text(shell, SWT.BORDER);
		txtConsole.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		txtConsole.setEditable(false);
		txtConsole.setBounds(455, 409, 90, 25);
		
	}//end createContents()
		
	//Runs any time a Sudoku Gameplay button is pressed
	//Adjusts the board matrix to be correct and reflects this in the GUI
	private void gameButtonPressed(Button theBtn, int x, int y){
		
		if (!currentDigit.equals("d")){
			
			theBtn.setText(currentDigit);
			board[x][y] = currentDigit;
		
		} else {
			
			//Prompt for direct input, validate, then apply to board
			InputDialog input = new InputDialog(shell,"Direct Input", "Please enter a number (1-9) or leave blank.", "", null);
			input.open();
			
			if (input.getValue() != null) {
				
				String inputAnswer = input.getValue().trim();
				
				if (inputAnswer.equals("") || inputAnswer.equals("1") || inputAnswer.equals("2") 
						|| inputAnswer.equals("3") || inputAnswer.equals("4") || inputAnswer.equals("5") 
						|| inputAnswer.equals("6") || inputAnswer.equals("7") || inputAnswer.equals("8") 
						|| inputAnswer.equals("9")){
					
					theBtn.setText(inputAnswer);
					board[x][y] = inputAnswer;
					
				}				
				
			}
						
		}
		
	}
	
	//Runs when New Puzzle button is pressed
	//Resets the board with a new, randomly chosen, puzzle.
	//Disables buttons that are already filled in.
	private void newPuzzlePressed(){

		String[][] newPuzzle = selectPuzzle();
		
		populateBoard(newPuzzle);
		
	}
		
	//Uses passed boardstate to initialize the game
	//Note that for the puzzle matrix x and y are flipped
	//to make it easier to visually input the new puzzle in selectPuzzle()
	private void populateBoard(String[][] puzzle){
		
		//initialize console and option buttons
		txtConsole.setText("");
		
		//populate game buttons
		for (int x = 0; x < 9; x++){
			
			for (int y = 0; y < 9; y++){
				
				if (puzzle[y][x].equals("-")){
					
					gameButtons[x][y].setText("");
					gameButtons[x][y].setEnabled(true);
					board[x][y] = "";
					
				} else {
					
					gameButtons[x][y].setText(puzzle[y][x]);
					gameButtons[x][y].setEnabled(false);
					board[x][y] = puzzle[y][x];
					
				}
				
			}
			
		}
		
	}
	
	//Runs when the Check button is pressed
	//Checks if the board is in a solved state
	//If it is not, a message saying so appears,
	//if it is, the game buttons are disabled and a message saying so appears
	private void checkButtonPressed(){
		
		if (checkSolved()){
			
			txtConsole.setText("Solved!");
			
			//disable game buttons
			for (int x = 0; x < 9; x++){
				
				for (int y = 0; y < 9; y++){
					
					gameButtons[x][y].setEnabled(false);
					
				}
				
			}
			
		} else {
			
			txtConsole.setText("Unsolved!");
			
		}
		
	}
	
	private boolean checkSolved(){
		
		//Initialize Map for checking each section
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		map = initializeMap(map);
		
		//Check Columns
		for (int x = 0; x < 9; x++){
            
            for (int y = 0; y < 9; y++){
                                
                if (!board[x][y].equals("")){
                
                    if (map.get(board[x][y]))
                        return false;
                    else {

                        map.put(board[x][y],true);

                    }
                    
                } else
                	return false;
                
            }
            
            map = initializeMap(map);
            
        }
		
		map = initializeMap(map);
		
		//Check Rows
		for (int y = 0; y < 9; y++){
            
            for (int x = 0; x < 9; x++){
                                
                if (!board[x][y].equals("")){
                
                    if (map.get(board[x][y]))
                        return false;
                    else {

                        map.put(board[x][y],true);

                    }
                    
                } else
                	return false;
                
            }
            
            map = initializeMap(map);
            
        }
		
		map = initializeMap(map);
		
		//Check Squares
		if (!checkSquare(0,2,0,2, map))
            return false;
        if (!checkSquare(3,5,0,2, map))
            return false;
        if (!checkSquare(6,8,0,2, map))
            return false;
        if (!checkSquare(0,2,3,5, map))
            return false;
        if (!checkSquare(3,5,3,5, map))
            return false;
        if (!checkSquare(6,8,3,5, map))
            return false;
        if (!checkSquare(0,2,6,8, map))
            return false;
        if (!checkSquare(3,5,6,8, map))
            return false;
        if (!checkSquare(6,8,6,8, map))
            return false;       

		return true;
		
	}
	
	//Helper Method
	//Fills the passed HashMap with keys/values that represent whether or not
	//that number has been found in the current section
	private HashMap<String, Boolean> initializeMap(HashMap<String, Boolean> map){
		
		map = new HashMap<String, Boolean>();
        map.put("1",false);
        map.put("2",false);
        map.put("3",false);
        map.put("4",false);
        map.put("5",false);
        map.put("6",false);
        map.put("7",false);
        map.put("8",false);
        map.put("9",false);
        
        return map;
		
	}
	
	//Helper Method
	//returns true if passed square is valid
    private boolean checkSquare (int xStart, int xEnd, int yStart, int yEnd, HashMap<String, Boolean> map){
        
        map = initializeMap(map);
        
        for (int x = xStart; x < xEnd + 1; x++){
            
            for (int y = yStart; y < yEnd + 1; y++){
                                
                if (!board[x][y].equals("")){
                
                    if (map.get(board[x][y]))
                        return false;
                    else {

                        map.put(board[x][y],true);

                    }
                    
                } else
                	return false;
                
            }
                        
        }
        
        return true;
        
    }
    
  //Randomly selects one of several puzzles to be used
  	private String[][] selectPuzzle(){
  		
  		//template for manual entering of puzzles
  		String[][] template = {
  				{"-","-","-",   "-","-","-",   "-","-","-"},
  				{"-","-","-",   "-","-","-",   "-","-","-"},
  				{"-","-","-",   "-","-","-",   "-","-","-"},
  				
  				{"-","-","-",   "-","-","-",   "-","-","-"},
  				{"-","-","-",   "-","-","-",   "-","-","-"},
  				{"-","-","-",   "-","-","-",   "-","-","-"},
  				
  				{"-","-","-",   "-","-","-",   "-","-","-"},
  				{"-","-","-",   "-","-","-",   "-","-","-"},
  				{"-","-","-",   "-","-","-",   "-","-","-"}};
  		
  		String[][] puzzle1 = {
  				{"3","5","6",   "-","-","1",   "2","-","-"},
  				{"-","-","9",   "3","-","-",   "-","8","5"},
  				{"8","-","-",   "7","-","4",   "-","3","9"},
  				
  				{"-","6","-",   "-","1","-",   "-","-","-"},
  				{"-","-","7",   "6","-","3",   "8","-","-"},
  				{"-","-","-",   "-","9","-",   "-","5","-"},
  				
  				{"6","9","-",   "1","-","2",   "-","-","7"},
  				{"2","7","-",   "-","-","9",   "3","-","-"},
  				{"-","-","1",   "5","-","-",   "9","6","2"}};
  		
  		String[][] puzzle2 = {
  				{"1","-","-",   "4","8","9",   "-","-","6"},
  				{"7","3","-",   "-","-","-",   "-","4","-"},
  				{"-","-","-",   "-","-","1",   "2","9","5"},
  				
  				{"-","-","7",   "1","2","-",   "6","-","-"},
  				{"5","-","-",   "7","-","3",   "-","-","8"},
  				{"-","-","6",   "-","9","5",   "7","-","-"},
  				
  				{"9","1","4",   "6","-","-",   "-","-","-"},
  				{"-","2","-",   "-","-","-",   "-","3","7"},
  				{"8","-","-",   "5","1","2",   "-","-","4"}};
  		
  		String[][] puzzle3 = {
  				{"-","-","-",   "2","6","-",   "7","-","1"},
  				{"6","8","-",   "-","7","-",   "-","9","-"},
  				{"1","9","-",   "-","-","4",   "5","-","-"},
  				
  				{"8","2","-",   "1","-","-",   "-","4","-"},
  				{"-","-","4",   "6","-","2",   "9","-","-"},
  				{"-","5","-",   "-","-","3",   "-","2","8"},
  				
  				{"-","-","9",   "3","-","-",   "-","7","4"},
  				{"-","4","-",   "-","5","-",   "-","3","6"},
  				{"7","-","3",   "-","1","8",   "-","-","-"}};
  		
  		String[][] puzzle4 = {
  				{"-","-","5",   "-","-","3",   "9","6","-"},
  				{"9","-","-",   "2","6","7",   "-","-","1"},
  				{"-","6","-",   "-","-","-",   "-","2","8"},
  				
  				{"5","-","3",   "-","-","1",   "-","4","-"},
  				{"4","-","9",   "-","-","-",   "2","-","6"},
  				{"-","1","-",   "9","-","-",   "5","-","3"},
  				
  				{"1","5","-",   "-","-","-",   "-","8","-"},
  				{"8","-","-",   "5","7","4",   "-","-","2"},
  				{"-","2","4",   "8","-","-",   "7","-","-"}};
  		
  		String[][] puzzle5 = {
  				{"-","-","-",   "4","8","6",   "-","5","3"},
  				{"7","-","3",   "2","-","-",   "-","9","-"},
  				{"-","-","-",   "9","3","-",   "2","-","-"},
  				
  				{"3","4","9",   "-","7","-",   "-","2","-"},
  				{"-","7","-",   "-","-","-",   "-","4","-"},
  				{"-","2","-",   "-","4","-",   "8","6","7"},
  				
  				{"-","-","8",   "-","6","1",   "-","-","-"},
  				{"-","1","-",   "-","-","4",   "5","-","8"},
  				{"4","5","-",   "8","2","3",   "-","-","-"}};
  		
  		String[][] puzzle6 = {
  				{"-","1","-",   "-","-","4",   "7","5","-"},
  				{"5","-","8",   "-","3","6",   "-","-","-"},
  				{"7","-","-",   "1","-","5",   "3","-","4"},
  				
  				{"-","-","-",   "-","-","-",   "-","9","-"},
  				{"-","6","5",   "9","8","7",   "2","3","-"},
  				{"-","8","-",   "-","-","-",   "-","-","-"},
  				
  				{"1","-","4",   "3","-","2",   "-","-","8"},
  				{"-","-","-",   "5","6","-",   "4","-","3"},
  				{"-","5","3",   "4","-","-",   "-","7","-"}};
  		
  		String[][] puzzle7 = {
  				{"-","-","5",   "4","-","8",   "-","3","-"},
  				{"-","-","7",   "1","-","9",   "-","-","-"},
  				{"-","4","-",   "5","3","-",   "2","8","-"},
  				
  				{"2","3","1",   "-","-","-",   "6","-","-"},
  				{"-","5","-",   "2","-","1",   "-","9","-"},
  				{"-","-","4",   "-","-","-",   "5","2","1"},
  				
  				{"-","9","2",   "-","1","3",   "-","6","-"},
  				{"-","-","-",   "6","-","5",   "9","-","-"},
  				{"-","1","-",   "8","-","2",   "7","-","-"}};
  		
  		String[][] puzzle8 = {
  				{"4","8","-",   "-","-","6",   "-","-","2"},
  				{"-","-","7",   "-","-","2",   "-","8","-"},
  				{"-","-","-",   "3","-","8",   "-","4","6"},
  				
  				{"9","-","1",   "-","2","-",   "-","-","7"},
  				{"-","7","-",   "5","3","1",   "-","9","-"},
  				{"3","-","-",   "-","6","-",   "2","-","8"},
  				
  				{"7","4","-",   "2","-","5",   "-","-","-"},
  				{"-","1","-",   "9","-","-",   "4","-","-"},
  				{"8","-","-",   "6","-","-",   "-","5","1"}};
  		
  		String[][] puzzle9 = {
  				{"1","-","2",   "3","-","-",   "-","8","-"},
  				{"-","-","-",   "-","-","-",   "2","-","6"},
  				{"-","-","6",   "-","-","8",   "7","-","1"},
  				
  				{"-","1","5",   "2","8","3",   "9","-","-"},
  				{"-","-","-",   "7","-","6",   "-","-","-"},
  				{"-","-","8",   "5","4","1",   "3","7","-"},
  				
  				{"6","-","3",   "8","-","-",   "1","-","-"},
  				{"4","-","9",   "-","-","-",   "-","-","-"},
  				{"-","2","-",   "-","-","9",   "8","-","3"}};
  		
  		String[][] puzzle10 = {
  				{"-","-","7",   "2","-","-",   "-","-","5"},
  				{"-","2","-",   "8","-","-",   "7","3","-"},
  				{"-","8","3",   "7","-","9",   "-","-","-"},
  				
  				{"-","5","-",   "-","2","-",   "-","6","1"},
  				{"-","-","6",   "1","9","4",   "5","-","-"},
  				{"2","7","-",   "-","8","-",   "-","9","-"},
  				
  				{"-","-","-",   "4","-","2",   "3","5","-"},
  				{"-","1","4",   "-","-","8",   "-","7","-"},
  				{"3","-","-",   "-","-","6",   "1","-","-"}};
  		
  		//Select one of the above puzzles randomly to return
  		String[][] chosenPuzzle = template;
  		int randomPuzzle = ThreadLocalRandom.current().nextInt(1,11);//(min, max + 1)
  		
  		switch (randomPuzzle){
  		
  		case 1: chosenPuzzle = puzzle1; break;
  		case 2: chosenPuzzle = puzzle2; break;
  		case 3: chosenPuzzle = puzzle3; break;
  		case 4: chosenPuzzle = puzzle4; break;
  		case 5: chosenPuzzle = puzzle5; break;
  		case 6: chosenPuzzle = puzzle6; break;
  		case 7: chosenPuzzle = puzzle7; break;
  		case 8: chosenPuzzle = puzzle8; break;
  		case 9: chosenPuzzle = puzzle9; break;
  		case 10: chosenPuzzle = puzzle10; break;
  		
  		}		
  			
  		return chosenPuzzle;
  				
  	}
		
}
