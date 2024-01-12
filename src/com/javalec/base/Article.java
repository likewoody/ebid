package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Article {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JCheckBox ckbAgree;
	private JLabel lblNewLabel;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Article window = new Article();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Article() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getCkbAgree());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getBtnExit());
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(36, 47, 375, 309);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setText("\t\t");
		}
		return textArea;
	}
	private JCheckBox getCkbAgree() {
		if (ckbAgree == null) {
			ckbAgree = new JCheckBox("");
			ckbAgree.setBounds(357, 382, 29, 23);
		}
		return ckbAgree;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("위 사항에 동의하시갰습니까?");
			lblNewLabel.setBounds(193, 387, 152, 16);
		}
		return lblNewLabel;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("닫기");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
										
								
				}
			});
			btnExit.setBounds(46, 382, 82, 29);
		}
		return btnExit;
	}
}
