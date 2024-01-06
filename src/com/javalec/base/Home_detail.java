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
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Home_detail extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel homeBackImage;
	private JButton btnMypage;
	private JButton btnHome;
	private JButton btnAlarm;
	private JButton btnChat;
	private JButton btnWrite;
	private JTextField tfOption;
	private JLabel lbPostTitle;
	private JScrollPane scrollPane;
	private JTable innerTableImage;
	private JLabel lbUserImage;
	private JLabel lbUserNickRating;
	private JScrollPane scrollPane_1;
	private JTable innerTableUserInfo;
	private JLabel lbDescription;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_2;
	private JLabel lbStartPrice;
	private JLabel lbHighestPrice;
	private JLabel lblDuration;
	private JButton btnWish;
	private JLabel lbBid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Home_detail dialog = new Home_detail();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Home_detail() {
		setFont(new Font("Lucida Grande", Font.BOLD, 27));
		setTitle("상세페이지");
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
		contentPanel.add(getLbUserImage());
		contentPanel.add(getLbBid());
		contentPanel.add(getLbUserNickRating());
		contentPanel.add(getLbDescription());
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getLblNewLabel_1_1());
		contentPanel.add(getLbStartPrice());
		contentPanel.add(getLbHighestPrice());
		contentPanel.add(getLblDuration());
		contentPanel.add(getLblNewLabel_1_2());
		contentPanel.add(getScrollPane_1());
		contentPanel.add(getScrollPane());
		contentPanel.add(getHomeBackImage());
		contentPanel.add(getBtnWish());
	}
	private JLabel getHomeBackImage() {
		if (homeBackImage == null) {
			homeBackImage = new JLabel("");
			homeBackImage.setBounds(0, 0, 430, 704);
			homeBackImage.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/HomeDetailBackground.png")));
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
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 156, 430, 126);
			scrollPane.setViewportView(getInnerTableImage());
		}
		return scrollPane;
	}
	private JTable getInnerTableImage() {
		if (innerTableImage == null) {
			innerTableImage = new JTable();
		}
		return innerTableImage;
	}
	private JLabel getLbUserImage() {
		if (lbUserImage == null) {
			lbUserImage = new JLabel("image");
			lbUserImage.setBounds(25, 300, 61, 50);
		}
		return lbUserImage;
	}
	private JLabel getLbUserNickRating() {
		if (lbUserNickRating == null) {
			lbUserNickRating = new JLabel("nickname + rating");
			lbUserNickRating.setBounds(100, 328, 132, 16);
		}
		return lbUserNickRating;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(0, 280, 430, 190);
			scrollPane_1.setViewportView(getInnerTableUserInfo());
		}
		return scrollPane_1;
	}
	private JTable getInnerTableUserInfo() {
		if (innerTableUserInfo == null) {
			innerTableUserInfo = new JTable();
		}
		return innerTableUserInfo;
	}
	private JLabel getLbDescription() {
		if (lbDescription == null) {
			lbDescription = new JLabel("description");
			lbDescription.setBounds(20, 360, 377, 95);
		}
		return lbDescription;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("image");
			lblNewLabel.setBounds(30, 176, 85, 77);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("시작금액");
			lblNewLabel_1.setBounds(47, 494, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("최고금액");
			lblNewLabel_1_1.setBounds(47, 536, 61, 16);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("경매기간");
			lblNewLabel_1_2.setBounds(47, 577, 61, 16);
		}
		return lblNewLabel_1_2;
	}
	private JLabel getLbStartPrice() {
		if (lbStartPrice == null) {
			lbStartPrice = new JLabel("StartPrice");
			lbStartPrice.setHorizontalAlignment(SwingConstants.RIGHT);
			lbStartPrice.setBounds(180, 494, 221, 16);
		}
		return lbStartPrice;
	}
	private JLabel getLbHighestPrice() {
		if (lbHighestPrice == null) {
			lbHighestPrice = new JLabel("HighestPrice");
			lbHighestPrice.setHorizontalAlignment(SwingConstants.RIGHT);
			lbHighestPrice.setBounds(180, 536, 221, 16);
		}
		return lbHighestPrice;
	}
	private JLabel getLblDuration() {
		if (lblDuration == null) {
			lblDuration = new JLabel("Duration");
			lblDuration.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDuration.setBounds(180, 577, 221, 16);
		}
		return lblDuration;
	}
	private JButton getBtnWish() {
		if (btnWish == null) {
			btnWish = new JButton("");
			btnWish.setBounds(24, 643, 54, 41);
		}
		return btnWish;
	}
	private JLabel getLbBid() {
		if (lbBid == null) {
			lbBid = new JLabel("입찰하기");
			lbBid.setHorizontalAlignment(SwingConstants.CENTER);
			lbBid.setBounds(180, 643, 230, 41);
		}
		return lbBid;
	}
}
