package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel reBackground;
	private JLabel lblNewLabel;
	private JLabel lblid;
	private JLabel lblpw;
	private JLabel lblpwRe;
	private JLabel lblNickname;
	private JLabel lblname;
	private JLabel lblphone;
	private JLabel lbladdress;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JComboBox cbState;
	private JButton btnidchek;
	private JButton btnnickNamechek;
	private JButton btnsignIn;
	private JCheckBox ckbagree;
	private JTextField textField_8;
	private JTextField textField_9;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Register dialog = new Register();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Register() {
		setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		setTitle("회원가입");
		setBounds(100, 100, 430, 732);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getTextField_3());
		contentPanel.add(getLblid());
		contentPanel.add(getLblpw());
		contentPanel.add(getLblpwRe());
		contentPanel.add(getLblNickname());
		contentPanel.add(getLblname());
		contentPanel.add(getLblphone());
		contentPanel.add(getLbladdress());
		contentPanel.add(getTextField());
		contentPanel.add(getTextField_1());
		contentPanel.add(getTextField_2());
		contentPanel.add(getTextField_4());
		contentPanel.add(getTextField_5());
		contentPanel.add(getTextField_6());
		contentPanel.add(getTextField_7());
		contentPanel.add(getCbState());
		contentPanel.add(getBtnidchek());
		contentPanel.add(getBtnnickNamechek());
		contentPanel.add(getBtnsignIn());
		contentPanel.add(getCkbagree());
		contentPanel.add(getTextField_8());
		contentPanel.add(getTextField_9());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getLblNewLabel_1_1());
		contentPanel.add(getReBackground());
	}
	private JLabel getReBackground() {
		if (reBackground == null) {
			reBackground = new JLabel("");
			reBackground.setBounds(0, 0, 430, 704);
			reBackground.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/logindetailBackground.png")));
		}
		return reBackground;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("회원가입");
			lblNewLabel.setForeground(new Color(214, 203, 216));
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(175, 165, 80, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblid() {
		if (lblid == null) {
			lblid = new JLabel("ID :");
			lblid.setBounds(52, 232, 40, 16);
		}
		return lblid;
	}
	private JLabel getLblpw() {
		if (lblpw == null) {
			lblpw = new JLabel("PW :");
			lblpw.setBounds(52, 277, 61, 16);
		}
		return lblpw;
	}
	private JLabel getLblpwRe() {
		if (lblpwRe == null) {
			lblpwRe = new JLabel("PW 재입력 :");
			lblpwRe.setBounds(52, 318, 65, 16);
		}
		return lblpwRe;
	}
	private JLabel getLblNickname() {
		if (lblNickname == null) {
			lblNickname = new JLabel("닉네임 :");
			lblNickname.setBounds(52, 360, 61, 16);
		}
		return lblNickname;
	}
	private JLabel getLblname() {
		if (lblname == null) {
			lblname = new JLabel("이름 :");
			lblname.setBounds(52, 407, 61, 16);
		}
		return lblname;
	}
	private JLabel getLblphone() {
		if (lblphone == null) {
			lblphone = new JLabel("전화번호 :");
			lblphone.setBounds(52, 450, 61, 16);
		}
		return lblphone;
	}
	private JLabel getLbladdress() {
		if (lbladdress == null) {
			lbladdress = new JLabel("주소 :");
			lbladdress.setBounds(52, 492, 61, 16);
		}
		return lbladdress;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(130, 354, 200, 26);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(130, 445, 65, 26);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(130, 270, 290, 26);
		}
		return textField_2;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(130, 227, 200, 26);
		}
		return textField_3;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(130, 402, 290, 26);
		}
		return textField_4;
	}
	private JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(130, 312, 290, 26);
		}
		return textField_5;
	}
	private JTextField getTextField_6() {
		if (textField_6 == null) {
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(325, 487, 100, 26);
		}
		return textField_6;
	}
	private JTextField getTextField_7() {
		if (textField_7 == null) {
			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setBounds(225, 487, 100, 26);
		}
		return textField_7;
	}
	private JComboBox getCbState() {
		if (cbState == null) {
			cbState = new JComboBox();
			cbState.setModel(new DefaultComboBoxModel(new String[] {"서울특별시", "인천광역시", "대전광역시", "대구광역시", "울산광역시", "부산광역시", "광주광역시", "세종특별자치시", "경기도", "강원도", "충청남도", "충청북도", "경상북도", "전라북도", "전라남도", "경상남도", "제주특별자치도"}));
			cbState.setBounds(85, 488, 135, 27);
		}
		return cbState;
	}
	private JButton getBtnidchek() {
		if (btnidchek == null) {
			btnidchek = new JButton("중복확인");
			btnidchek.setBounds(330, 227, 80, 26);
		}
		return btnidchek;
	}
	private JButton getBtnnickNamechek() {
		if (btnnickNamechek == null) {
			btnnickNamechek = new JButton("중복확인");
			btnnickNamechek.setBounds(330, 354, 80, 26);
		}
		return btnnickNamechek;
	}
	private JButton getBtnsignIn() {
		if (btnsignIn == null) {
			btnsignIn = new JButton("회원가입");
			btnsignIn.setBorder(new LineBorder(new Color(214, 203, 216), 2));
			int red = 0xD6;
	        int green = 0xCB;											//기준색 D6CBD8 에 대한 값
	        int blue = 0xD8;

	        Color BackColor = new Color(red, green, blue);				//색깔 적용	   
	        btnsignIn.setBackground(BackColor);
	        btnsignIn.setOpaque(true);
			btnsignIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
									signIn();
				}
			});
			btnsignIn.setBounds(158, 624, 117, 29);
		}
		return btnsignIn;
	}
	private JCheckBox getCkbagree() {
		if (ckbagree == null) {
			ckbagree = new JCheckBox("개인정보 처리에 동의하시갰습니까?");
			ckbagree.setBounds(127, 545, 250, 23);
		}
		return ckbagree;
	}
	
	
	
	
	
	
	//--------Function---------
	
	
	
	public void signIn() {
		
	}
	private JTextField getTextField_8() {
		if (textField_8 == null) {
			textField_8 = new JTextField();
			textField_8.setColumns(10);
			textField_8.setBounds(221, 445, 80, 26);
		}
		return textField_8;
	}
	private JTextField getTextField_9() {
		if (textField_9 == null) {
			textField_9 = new JTextField();
			textField_9.setColumns(10);
			textField_9.setBounds(340, 445, 80, 26);
		}
		return textField_9;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("-");
			lblNewLabel_1.setBounds(199, 445, 20, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("-");
			lblNewLabel_1_1.setBounds(310, 445, 20, 16);
		}
		return lblNewLabel_1_1;
	}
}
