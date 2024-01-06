package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyPageEdit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnHome;
	private JButton btnWrite;
	private JButton btnMy;
	private JButton btnAlarm;
	private JButton btnChat;
	private JButton btnBack;
	private JLabel lblUserImage;
	private JLabel lblUserNick;
	private JButton btnEditImage;
	private JLabel lblNewLabel_1;
	private JTextField tfNick;
	private JLabel lblUserNick_1;
	private JTextField tfName;
	private JLabel lblId;
	private JTextField tfId;
	private JLabel lblUserNick_3;
	private JTextField tfPw;
	private JLabel lblUserNick_4;
	private JTextField tfTelno;
	private JLabel lblUserNick_5;
	private JComboBox cbAddress1;
	private JComboBox cbAddress2;
	private JTextField tfEditPw;
	private JLabel lblUserNick_3_1;
	private JButton btnEditNick;
	private JButton btnEditPw;
	private JButton btnEditTelno;
	private JButton btnEditAddress;
	private JLabel lblMyBid;

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
		getContentPane().add(getBtnBack());
		getContentPane().add(getLblUserImage());
		getContentPane().add(getLblUserNick());
		getContentPane().add(getTfNick());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getBtnEditImage());
		getContentPane().add(getLblUserNick_1());
		getContentPane().add(getTfName());
		getContentPane().add(getLblId());
		getContentPane().add(getTfId());
		getContentPane().add(getLblUserNick_3());
		getContentPane().add(getTfPw());
		getContentPane().add(getLblUserNick_4());
		getContentPane().add(getTfTelno());
		getContentPane().add(getLblUserNick_5());
		getContentPane().add(getCbAddress1());
		getContentPane().add(getCbAddress2());
		getContentPane().add(getTextField_5_1());
		getContentPane().add(getLblUserNick_3_1());
		getContentPane().add(getBtnEditNick());
		getContentPane().add(getBtnEditPw());
		getContentPane().add(getBtnEditTelno());
		getContentPane().add(getBtnEditAddress());
		getContentPane().add(getLblMyBid());

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
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("뒤로가기");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					MyPage mp = new MyPage();
					mp.setVisible(true);
				}
			});
			btnBack.setBounds(150, 650, 117, 29);
		}
		return btnBack;
	}
	private JLabel getLblUserImage() {
		if (lblUserImage == null) {
			lblUserImage = new JLabel("유저 이미지");
			lblUserImage.setBackground(Color.WHITE);
			lblUserImage.setBounds(163, 141, 100, 100);
		}
		return lblUserImage;
	}
	private JLabel getLblUserNick() {
		if (lblUserNick == null) {
			lblUserNick = new JLabel("닉네임 : ");
			lblUserNick.setBounds(42, 280, 61, 16);
		}
		return lblUserNick;
	}
	private JButton getBtnEditImage() {
		if (btnEditImage == null) {
			btnEditImage = new JButton("사진수정");
			btnEditImage.setBounds(267, 212, 88, 29);
		}
		return btnEditImage;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("개인 정보 수정");
			lblNewLabel_1.setBounds(176, 113, 74, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfNick() {
		if (tfNick == null) {
			tfNick = new JTextField();
			tfNick.setBounds(115, 280, 200, 30);
			tfNick.setColumns(10);
		}
		return tfNick;
	}
	private JLabel getLblUserNick_1() {
		if (lblUserNick_1 == null) {
			lblUserNick_1 = new JLabel("이름 : ");
			lblUserNick_1.setBounds(42, 330, 61, 16);
		}
		return lblUserNick_1;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setEditable(false);
			tfName.setColumns(10);
			tfName.setBounds(115, 330, 200, 30);
		}
		return tfName;
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID : ");
			lblId.setBounds(42, 380, 61, 16);
		}
		return lblId;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setEditable(false);
			tfId.setColumns(10);
			tfId.setBounds(115, 380, 200, 30);
		}
		return tfId;
	}
	private JLabel getLblUserNick_3() {
		if (lblUserNick_3 == null) {
			lblUserNick_3 = new JLabel("현재 PW : ");
			lblUserNick_3.setBounds(42, 430, 61, 16);
		}
		return lblUserNick_3;
	}
	private JTextField getTfPw() {
		if (tfPw == null) {
			tfPw = new JTextField();
			tfPw.setColumns(10);
			tfPw.setBounds(115, 430, 200, 30);
		}
		return tfPw;
	}
	private JLabel getLblUserNick_4() {
		if (lblUserNick_4 == null) {
			lblUserNick_4 = new JLabel("전화번호 : ");
			lblUserNick_4.setBounds(42, 530, 61, 16);
		}
		return lblUserNick_4;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setColumns(10);
			tfTelno.setBounds(115, 530, 200, 30);
		}
		return tfTelno;
	}
	private JLabel getLblUserNick_5() {
		if (lblUserNick_5 == null) {
			lblUserNick_5 = new JLabel("주소 : ");
			lblUserNick_5.setBounds(42, 580, 61, 16);
		}
		return lblUserNick_5;
	}
	private JComboBox getCbAddress1() {
		if (cbAddress1 == null) {
			cbAddress1 = new JComboBox();
			cbAddress1.setBounds(115, 580, 100, 30);
		}
		return cbAddress1;
	}
	private JComboBox getCbAddress2() {
		if (cbAddress2 == null) {
			cbAddress2 = new JComboBox();
			cbAddress2.setBounds(220, 580, 100, 30);
		}
		return cbAddress2;
	}
	private JTextField getTextField_5_1() {
		if (tfEditPw == null) {
			tfEditPw = new JTextField();
			tfEditPw.setColumns(10);
			tfEditPw.setBounds(115, 480, 200, 30);
		}
		return tfEditPw;
	}
	private JLabel getLblUserNick_3_1() {
		if (lblUserNick_3_1 == null) {
			lblUserNick_3_1 = new JLabel("바꿀 PW : ");
			lblUserNick_3_1.setBounds(42, 480, 80, 16);
		}
		return lblUserNick_3_1;
	}
	private JButton getBtnEditNick() {
		if (btnEditNick == null) {
			btnEditNick = new JButton("수정");
			btnEditNick.setBounds(324, 280, 100, 30);
		}
		return btnEditNick;
	}
	private JButton getBtnEditPw() {
		if (btnEditPw == null) {
			btnEditPw = new JButton("수정");
			btnEditPw.setBounds(324, 480, 100, 30);
		}
		return btnEditPw;
	}
	private JButton getBtnEditTelno() {
		if (btnEditTelno == null) {
			btnEditTelno = new JButton("수정");
			btnEditTelno.setBounds(324, 530, 100, 30);
		}
		return btnEditTelno;
	}
	private JButton getBtnEditAddress() {
		if (btnEditAddress == null) {
			btnEditAddress = new JButton("수정");
			btnEditAddress.setBounds(324, 580, 100, 30);
		}
		return btnEditAddress;
	}
	private JLabel getLblMyBid() {
		if (lblMyBid == null) {
			lblMyBid = new JLabel("");
			lblMyBid.setIcon(new ImageIcon(MyPageEdit.class.getResource("/com/javalec/images/mainFrame.png")));
			lblMyBid.setBounds(0, 0, 430, 704);
		}
		return lblMyBid;
	}
}
