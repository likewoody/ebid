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

public class Login extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel loginBackground;
	private JLabel lblNewLabel;
	private JLabel lblPw;
	private JTextField tfId;
	private JTextField tfPw;
	private JButton btnLogin;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setFont(new Font("Lucida Grande", Font.BOLD, 27));
		setTitle("로그인");
		setBounds(100, 100, 430, 732);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLblPw());
		contentPanel.add(getTfId());
		contentPanel.add(getTfPw());
		contentPanel.add(getBtnLogin());
		contentPanel.add(getLblNewLabel_1_3());
		contentPanel.add(getLblNewLabel_1_2());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getLblNewLabel_1_1());
		contentPanel.add(getLblNewLabel_1_1_1());
		contentPanel.add(getLoginBackground());
	}
	private JLabel getLoginBackground() {
		if (loginBackground == null) {
			loginBackground = new JLabel("");
			loginBackground.setBounds(0, 0, 430, 704);
			loginBackground.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/loginBackground.png")));
		}
		return loginBackground;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("아이디 : ");
			lblNewLabel.setBounds(35, 320, 50, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblPw() {
		if (lblPw == null) {
			lblPw = new JLabel("비밀번호 :");
			lblPw.setBounds(25, 370, 60, 16);
		}
		return lblPw;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(96, 315, 280, 26);
			tfId.setColumns(10);
			tfId.setBorder(new LineBorder(new Color(214, 203, 216)));
		}
		return tfId;
	}
	private JTextField getTfPw() {
		if (tfPw == null) {
			tfPw = new JTextField();
			tfPw.setColumns(10);
			tfPw.setBounds(96, 366, 280, 26);
			tfPw.setBorder(new LineBorder(new Color(214, 203, 216)));
		}
		return tfPw;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("로그인");
			btnLogin.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			btnLogin.setBounds(155, 450, 130, 38);
			
//			btnLogin.setBorder(new LineBorder(new Color(214, 203, 216)));
		}
		return btnLogin;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("회원가입");
			lblNewLabel_1.setBounds(126, 500, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("아이디 찾기");
			lblNewLabel_1_1.setBounds(192, 500, 61, 16);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("비밀번호 찾기");
			lblNewLabel_1_1_1.setBounds(270, 500, 72, 16);
		}
		return lblNewLabel_1_1_1;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("|");
			lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_2.setBounds(232, 500, 61, 16);
		}
		return lblNewLabel_1_2;
	}
	private JLabel getLblNewLabel_1_3() {
		if (lblNewLabel_1_3 == null) {
			lblNewLabel_1_3 = new JLabel("|");
			lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_3.setBounds(152, 500, 61, 16);
		}
		return lblNewLabel_1_3;
	}
}
