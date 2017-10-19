package com.landg.lqa.testflow;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.border.BevelBorder;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.Canvas;
import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JPopupMenu;

import java.awt.Component;

import javax.swing.JPasswordField;

//import org.eclipse.*;

import java.awt.Choice;

import javax.swing.JPanel;

import java.awt.Label;
import javax.swing.Box;
import java.awt.Panel;

public class Window {

	private JFrame frmConfused;
	private JTextField textField_2;
	String TestCase, Input, Output, URL, Username, Password, Browser,
	environment, testPack;
	static int progress_count = 0;

	int flag = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmConfused.setVisible(true);
					window.frmConfused.setBounds(200, 200, 600, 400);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frmConfused = new JFrame();

		frmConfused.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmConfused.getContentPane().setForeground(Color.LIGHT_GRAY);
		frmConfused.setForeground(Color.GRAY);
		frmConfused.setTitle("NQA");
		frmConfused.setBounds(0, -39, 625, 367);
		frmConfused.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConfused.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Run Selected Test");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(350, 60, 172, 23);
		frmConfused.getContentPane().add(btnNewButton);

		JLabel lblTestCaseRange = new JLabel("Test Case Number");
		lblTestCaseRange.setForeground(Color.BLACK);
		lblTestCaseRange.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTestCaseRange.setBackground(new Color(0, 0, 102));
		lblTestCaseRange.setBounds(56, 63, 130, 14);
		frmConfused.getContentPane().add(lblTestCaseRange);

		JButton btnNewButton_1 = new JButton("Stop....");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);
			}

		});
		btnNewButton_1.setBounds(331, 270, 108, 23);
		frmConfused.getContentPane().add(btnNewButton_1);

		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(188, 210, 227, 22);
		frmConfused.getContentPane().add(comboBox_2);
		comboBox_2.addItem("Smoke Test");
		comboBox_2.addItem("Health Check");
		comboBox_2.addItem("Regression Test");
		comboBox_2.addItem("NQA UW");
		comboBox_2.addItem("NQA Pricing");
		comboBox_2.addItem("PostCode Test");

		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(188, 106, 135, 22);

		comboBox.addItem("Firefox");
		comboBox.addItem("InternetExplorer");
		comboBox.addItem("Chrome");

		frmConfused.getContentPane().add(comboBox);

		JLabel lblBrowser = new JLabel("Browser");
		lblBrowser.setForeground(Color.BLACK);
		lblBrowser.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBrowser.setBounds(56, 104, 89, 25);
		frmConfused.getContentPane().add(lblBrowser);

		JLabel lblNewLabel_3 = new JLabel("NQA - Test Automation");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setForeground(UIManager.getColor("desktop"));
		lblNewLabel_3.setBounds(48, 11, 196, 41);
		frmConfused.getContentPane().add(lblNewLabel_3);
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(188, 156, 135, 22);
		frmConfused.getContentPane().add(comboBox_1);
		comboBox_1.addItem("IFTE");
		comboBox_1.addItem("FTE");
		comboBox_1.addItem("NFTE");
		comboBox_1.addItem("Preprod");
		comboBox_1.addItem("I Stage");
		comboBox_1.addItem("P Stage");

		JButton btnRunSelectedTest = new JButton("Run All");
		btnRunSelectedTest.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRunSelectedTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				TestCase = textField_2.getText();

				TestCase = "";

				// URL=txtHttplamstwaslgnetcoukportalserverlqacallcentercallcentermainpage.getText();
				String t1 = textField_2.getText();
				// Username=txtFs.getText();
				// Password=passwordField.getText();
				Browser = (String) comboBox.getSelectedItem();
				environment = (String) comboBox_1.getSelectedItem();
				testPack = (String) comboBox_2.getSelectedItem();
				frmConfused.enableInputMethods(true);

				// TestFlow01.start(TestCase,Browser);
				TestFlow01.start(TestCase, Browser, environment, testPack);

			}
		});
		btnRunSelectedTest.setForeground(Color.BLACK);
		btnRunSelectedTest.setBounds(188, 270, 121, 23);
		frmConfused.getContentPane().add(btnRunSelectedTest);

		textField_2 = new JTextField();
		textField_2.setBounds(188, 61, 135, 20);
		frmConfused.getContentPane().add(textField_2);
		textField_2.setToolTipText("Test Case Number");
		textField_2.setColumns(10);

		JLabel lblEnvironment = new JLabel("Environment");
		lblEnvironment.setForeground(Color.BLACK);
		lblEnvironment.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEnvironment.setBounds(56, 154, 89, 25);
		frmConfused.getContentPane().add(lblEnvironment);

		JLabel lblTestPack = new JLabel("Test Pack");
		lblTestPack.setForeground(Color.BLACK);
		lblTestPack.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTestPack.setBounds(56, 208, 89, 25);
		frmConfused.getContentPane().add(lblTestPack);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TestCase = textField_2.getText();

				String t1 = textField_2.getText();

				Browser = (String) comboBox.getSelectedItem();
				environment = (String) comboBox_1.getSelectedItem();
				testPack = (String) comboBox_2.getSelectedItem();

				if (TestCase.matches("[0-9]+")) {
					frmConfused.enableInputMethods(true);
					TestFlow01.start(TestCase, Browser, environment, testPack);

				} else {

					JOptionPane.showMessageDialog(null,
							"Enter the test case number");
				}

			}
		});
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});

	}
}
