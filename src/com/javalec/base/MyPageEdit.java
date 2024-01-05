package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MyPageEdit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnHome;
	private JButton btnWrite;
	private JButton btnMy;
	private JButton btnAlarm;
	private JButton btnChat;
	private JLabel lblNewLabel;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPageEdit frame = new MyPageEdit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyPageEdit() {
		setTitle("내 정보 수정");
		setBounds(100, 100, 430, 732);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnHome());
		getContentPane().add(getBtnWrite());
		getContentPane().add(getBtnMy());
		getContentPane().add(getBtnAlarm());
		getContentPane().add(getBtnChat());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getLblNewLabel());

	}
	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("홈");
			btnHome.setBounds(20, 55, 70, 34);
		}
		return btnHome;
	}
	private JButton getBtnWrite() {
		if (btnWrite == null) {
			btnWrite = new JButton("글쓰기");
			btnWrite.setBounds(340, 55, 70, 34);
		}
		return btnWrite;
	}
	private JButton getBtnMy() {
		if (btnMy == null) {
			btnMy = new JButton("개인");
			btnMy.setBounds(100, 55, 70, 34);
		}
		return btnMy;
	}
	private JButton getBtnAlarm() {
		if (btnAlarm == null) {
			btnAlarm = new JButton("알림");
			btnAlarm.setBounds(180, 55, 70, 34);
		}
		return btnAlarm;
	}
	private JButton getBtnChat() {
		if (btnChat == null) {
			btnChat = new JButton("채팅");
			btnChat.setBounds(260, 55, 70, 34);
		}
		return btnChat;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(MyPageEdit.class.getResource("/com/javalec/images/mainFrame.png")));
			lblNewLabel.setBounds(0, 0, 430, 704);
		}
		return lblNewLabel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.setBounds(150, 650, 117, 29);
		}
		return btnNewButton;
	}
}
