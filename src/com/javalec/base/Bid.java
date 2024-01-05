package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Bid extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel homeBackImage;
	private JButton btnHome;
	private JButton btnMypage;
	private JButton btnAlarm;
	private JButton btnChat;
	private JButton btnWrite;
	private JTextField tfOption;
	private JLabel lbPostTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Bid dialog = new Bid();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Bid() {
		setFont(new Font("Lucida Grande", Font.BOLD, 27));
		setTitle("입찰");
		setBounds(100, 100, 430, 732);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getBtnHome());
		contentPanel.add(getBtnMypage());
		contentPanel.add(getBtnAlarm());
		contentPanel.add(getBtnChat());
		contentPanel.add(getBtnWrite());
		contentPanel.add(getTfOption());
		contentPanel.add(getLbPostTitle());
		contentPanel.add(getHomeBackImage());
	}

	private JLabel getHomeBackImage() {
		if (homeBackImage == null) {
			homeBackImage = new JLabel("");
			homeBackImage.setBounds(0, 0, 430, 704);
			homeBackImage.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/bidBackground.png")));
		}
		return homeBackImage;
	}
	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("홈");
			btnHome.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnHome.setBounds(20, 55, 70, 34);
			
			btnHome.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnHome;
	}
	private JButton getBtnMypage() {
		if (btnMypage == null) {
			btnMypage = new JButton("개인");
			btnMypage.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnMypage.setBounds(100, 55, 70, 34);
			btnMypage.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnMypage;
	}
	private JButton getBtnAlarm() {
		if (btnAlarm == null) {
			btnAlarm = new JButton("알림");
			btnAlarm.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnAlarm.setBounds(180, 55, 70, 34);
			btnAlarm.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnAlarm;
	}
	private JButton getBtnChat() {
		if (btnChat == null) {
			btnChat = new JButton("채팅");
			btnChat.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnChat.setBounds(260, 55, 70, 34);
			btnChat.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnChat;
	}
	private JButton getBtnWrite() {
		if (btnWrite == null) {
			btnWrite = new JButton("글쓰기");
			btnWrite.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnWrite.setBounds(340, 55, 70, 34);
			btnWrite.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnWrite;
	}
	private JTextField getTfOption() {
		if (tfOption == null) {
			tfOption = new JTextField();
			tfOption.setHorizontalAlignment(SwingConstants.CENTER);
			tfOption.setText("경매");
			tfOption.setBounds(10, 112, 85, 30);
			tfOption.setColumns(10);
			tfOption.setBorder(new LineBorder(new Color(214, 203, 216), 2));
			
		}
		return tfOption;
	}
	private JLabel getLbPostTitle() {
		if (lbPostTitle == null) {
			lbPostTitle = new JLabel("잡지 경매 합니다 (한정판)");
			lbPostTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			lbPostTitle.setBounds(109, 101, 301, 53);
		}
		return lbPostTitle;
	}
}
