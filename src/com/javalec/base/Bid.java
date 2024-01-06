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
	private JLabel bidBackground;
	private JButton btnHome;
	private JButton btnMypage;
	private JButton btnAlarm;
	private JButton btnChat;
	private JButton btnWrite;
	private JTextField tfOption;
	private JLabel lbPostTitle;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lbStartPrice;
	private JLabel lbDeposit;
	private JLabel lblNewLabel_1_1;
	private JTextField tfBidPrice;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_1;
	private JLabel lblNewLabel_2_1;
	private JLabel lbBid;

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
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getLbDeposit());
		contentPanel.add(getLblNewLabel_1_1());
		contentPanel.add(getTfBidPrice());
		contentPanel.add(getTfOption());
		contentPanel.add(getLbStartPrice());
		contentPanel.add(getLbBid());
		contentPanel.add(getLblNewLabel_2_1());
		contentPanel.add(getLblNewLabel_3_1());
		contentPanel.add(getLblNewLabel_3());
		contentPanel.add(getLblNewLabel_2());
		contentPanel.add(getLbPostTitle());
		contentPanel.add(getBidBackground());
	}

	private JLabel getBidBackground() {
		if (bidBackground == null) {
			bidBackground = new JLabel("");
			bidBackground.setBounds(0, 0, 430, 704);
			bidBackground.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/bidBackground.png")));
		}
		return bidBackground;
	}
	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("홈");
			btnHome.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnHome.setBounds(20, 55, 70, 34);
//			btnHome.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnHome;
	}
	private JButton getBtnMypage() {
		if (btnMypage == null) {
			btnMypage = new JButton("개인");
			btnMypage.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnMypage.setBounds(100, 55, 70, 34);
//			btnMypage.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnMypage;
	}
	private JButton getBtnAlarm() {
		if (btnAlarm == null) {
			btnAlarm = new JButton("알림");
			btnAlarm.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnAlarm.setBounds(180, 55, 70, 34);
//			btnAlarm.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnAlarm;
	}
	private JButton getBtnChat() {
		if (btnChat == null) {
			btnChat = new JButton("채팅");
			btnChat.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnChat.setBounds(260, 55, 70, 34);
//			btnChat.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnChat;
	}
	private JButton getBtnWrite() {
		if (btnWrite == null) {
			btnWrite = new JButton("글쓰기");
			btnWrite.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnWrite.setBounds(340, 55, 70, 34);
//			btnWrite.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnWrite;
	}
	private JTextField getTfOption() {
		if (tfOption == null) {
			tfOption = new JTextField();
			tfOption.setEditable(false);
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
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("시작금액");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(33, 184, 78, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("예약금 (10%)");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(33, 223, 78, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLbStartPrice() {
		if (lbStartPrice == null) {
			lbStartPrice = new JLabel("500,000 원");
			lbStartPrice.setHorizontalAlignment(SwingConstants.RIGHT);
			lbStartPrice.setBounds(180, 184, 221, 16);
		}
		return lbStartPrice;
	}
	private JLabel getLbDeposit() {
		if (lbDeposit == null) {
			lbDeposit = new JLabel("50,000 원");
			lbDeposit.setHorizontalAlignment(SwingConstants.RIGHT);
			lbDeposit.setBounds(180, 223, 221, 16);
		}
		return lbDeposit;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("입찰 금액");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setBounds(180, 324, 85, 16);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTfBidPrice() {
		if (tfBidPrice == null) {
			tfBidPrice = new JTextField();
			tfBidPrice.setText("550,000 원");
			tfBidPrice.setHorizontalAlignment(SwingConstants.RIGHT);
			tfBidPrice.setColumns(10);
			tfBidPrice.setBounds(110, 366, 230, 40);
			tfBidPrice.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return tfBidPrice;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("입찰 예약금은 시작금액의 10%입니다.");
			lblNewLabel_2.setForeground(new Color(255, 38, 0));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(0, 470, 430, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("입찰은 최대 3번까지 가능하며, 낙찰 되지 않을 시 예약금은 100% 환불 됩니다.");
			lblNewLabel_3.setForeground(new Color(255, 38, 0));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setBounds(0, 500, 430, 16);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("낙찰 후 거래를 파기할 시 결재한 예약금 10%는 반환되지 않습니다.");
			lblNewLabel_3_1.setForeground(new Color(255, 38, 0));
			lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3_1.setBounds(0, 530, 430, 16);
		}
		return lblNewLabel_3_1;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("신중한 입찰 부탁드립니다.");
			lblNewLabel_2_1.setForeground(new Color(255, 38, 0));
			lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_1.setBounds(0, 560, 430, 16);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLbBid() {
		if (lbBid == null) {
			lbBid = new JLabel("입찰하기");
			lbBid.setHorizontalAlignment(SwingConstants.CENTER);
			lbBid.setBounds(102, 644, 227, 40);
		}
		return lbBid;
	}
}
