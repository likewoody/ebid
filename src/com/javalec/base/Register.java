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
	private JTextField tfnickname;
	private JTextField tfphone1;
	private JTextField tfpw;
	private JTextField tfid;
	private JTextField tfname;
	private JTextField tfpwRe;
	private JTextField tfaddress2;
	private JTextField tfaddress1;
	private JComboBox cbaddress;
	private JButton btnIdchek;
	private JButton btnnickNamechek;
	private JButton btnsignIn;
	private JCheckBox ckbagree;
	private JTextField tfphone2;
	private JTextField tfphone3;
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
		contentPanel.add(getTfid());
		contentPanel.add(getLblid());
		contentPanel.add(getLblpw());
		contentPanel.add(getLblpwRe());
		contentPanel.add(getLblNickname());
		contentPanel.add(getLblname());
		contentPanel.add(getLblphone());
		contentPanel.add(getLbladdress());
		contentPanel.add(getTfnickname());
		contentPanel.add(getTfphone1());
		contentPanel.add(getTfpw());
		contentPanel.add(getTfname());
		contentPanel.add(getTfpwRe());
		contentPanel.add(getTfaddress2());
		contentPanel.add(getTfaddress1());
		contentPanel.add(getCbaddress());
		contentPanel.add(getBtnIdchek());
		contentPanel.add(getBtnnickNamechek());
		contentPanel.add(getBtnsignIn());
		contentPanel.add(getCkbagree());
		contentPanel.add(getTfphone2());
		contentPanel.add(getTfphone3());
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
	private JTextField getTfnickname() {
		if (tfnickname == null) {
			tfnickname = new JTextField();
			tfnickname.setBounds(130, 354, 200, 26);
			tfnickname.setColumns(10);
		}
		return tfnickname;
	}
	private JTextField getTfphone1() {
		if (tfphone1 == null) {
			tfphone1 = new JTextField();
			tfphone1.setColumns(10);
			tfphone1.setBounds(130, 445, 65, 26);
		}
		return tfphone1;
	}
	private JTextField getTfpw() {
		if (tfpw == null) {
			tfpw = new JTextField();
			tfpw.setColumns(10);
			tfpw.setBounds(130, 270, 290, 26);
		}
		return tfpw;
	}
	private JTextField getTfid() {
		if (tfid == null) {
			tfid = new JTextField();
			tfid.setColumns(10);
			tfid.setBounds(130, 227, 200, 26);
		}
		return tfid;
	}
	private JTextField getTfname() {
		if (tfname == null) {
			tfname = new JTextField();
			tfname.setColumns(10);
			tfname.setBounds(130, 402, 290, 26);
		}
		return tfname;
	}
	private JTextField getTfpwRe() {
		if (tfpwRe == null) {
			tfpwRe = new JTextField();
			tfpwRe.setColumns(10);
			tfpwRe.setBounds(130, 312, 290, 26);
		}
		return tfpwRe;
	}
	private JTextField getTfaddress2() {
		if (tfaddress2 == null) {
			tfaddress2 = new JTextField();
			tfaddress2.setColumns(10);
			tfaddress2.setBounds(325, 487, 100, 26);
		}
		return tfaddress2;
	}
	private JTextField getTfaddress1() {
		if (tfaddress1 == null) {
			tfaddress1 = new JTextField();
			tfaddress1.setColumns(10);
			tfaddress1.setBounds(225, 487, 100, 26);
		}
		return tfaddress1;
	}
	private JComboBox getCbaddress() {
		if (cbaddress == null) {
			cbaddress = new JComboBox();
			cbaddress.setModel(new DefaultComboBoxModel(new String[] {"서울특별시", "인천광역시", "대전광역시", "대구광역시", "울산광역시", "부산광역시", "광주광역시", "세종특별자치시", "경기도", "강원도", "충청남도", "충청북도", "경상북도", "전라북도", "전라남도", "경상남도", "제주특별자치도"}));
			cbaddress.setBounds(85, 488, 135, 27);
		}
		return cbaddress;
	}
	private JButton getBtnIdchek() {
		if (btnIdchek == null) {
			btnIdchek = new JButton("중복확인");
			btnIdchek.setBounds(330, 227, 80, 26);
		}
		return btnIdchek;
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
	private JTextField getTfphone2() {
		if (tfphone2 == null) {
			tfphone2 = new JTextField();
			tfphone2.setColumns(10);
			tfphone2.setBounds(221, 445, 80, 26);
		}
		return tfphone2;
	}
	private JTextField getTfphone3() {
		if (tfphone3 == null) {
			tfphone3 = new JTextField();
			tfphone3.setColumns(10);
			tfphone3.setBounds(340, 445, 80, 26);
		}
		return tfphone3;
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
