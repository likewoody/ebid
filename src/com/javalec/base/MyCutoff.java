package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class MyCutoff extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnHome;
	private JButton btnMy;
	private JButton btnAlarm;
	private JButton btnChat;
	private JButton btnWrite;
	private JButton btnBack;
	private JLabel lblMyBid;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyCutoff frame = new MyCutoff();
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
	public MyCutoff() {
		setBounds(100, 100, 430, 732);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnHome());
		getContentPane().add(getBtnMy());
		getContentPane().add(getBtnAlarm());
		getContentPane().add(getBtnChat());
		getContentPane().add(getBtnWrite());
		getContentPane().add(getBtnBack());
		getContentPane().add(getScrollPane());
		getContentPane().add(getLblMyBid());

	}
	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("홈");
			btnHome.setBounds(20, 55, 70, 34);
		}
		return btnHome;
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
	private JButton getBtnWrite() {
		if (btnWrite == null) {
			btnWrite = new JButton("글쓰기");
			btnWrite.setBounds(340, 55, 70, 34);
		}
		return btnWrite;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("뒤로가기");
			btnBack.setBounds(150, 650, 117, 29);
		}
		return btnBack;
	}
	private JLabel getLblMyBid() {
		if (lblMyBid == null) {
			lblMyBid = new JLabel("");
			lblMyBid.setIcon(new ImageIcon(MyCutoff.class.getResource("/com/javalec/images/mainFrame.png")));
			lblMyBid.setBounds(0, 0, 430, 704);
		}
		return lblMyBid;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 115, 380, 450);
		}
		return scrollPane;
	}
}