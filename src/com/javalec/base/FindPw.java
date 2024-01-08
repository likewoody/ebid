package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindPw extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel fPwBackground;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JTextField tfid;
	private JTextField tfname;
	private JTextField tfphone;
	private JButton btnSearchpw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindPw dialog = new FindPw();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public FindPw() {
		setFont(new Font("Lucida Grande", Font.BOLD, 27));
		setTitle("비밀번호 찾기");
		setBounds(100, 100, 430, 732);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getTfid());
		getContentPane().add(getTfname());
		getContentPane().add(getTfphone());
		getContentPane().add(getBtnSearchpw());
		getContentPane().add(getFPwBackground());

	}

	private JLabel getFPwBackground() {
		if (fPwBackground == null) {
			fPwBackground = new JLabel("");
			fPwBackground.setBounds(0, 0, 430, 704);
			fPwBackground.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/logindetailBackground.png")));
		}
		return fPwBackground;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("비밀번호 찾기");
			lblNewLabel.setForeground(new Color(214, 203, 216));
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(165, 165, 90, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("아이디 :");
			lblNewLabel_1.setBounds(60, 275, 340, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("이름 :");
			lblNewLabel_2.setBounds(60, 323, 235, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("전화번호 :");
			lblNewLabel_4.setBounds(60, 374, 61, 16);
		}
		return lblNewLabel_4;
	}
	private JTextField getTfid() {
		if (tfid == null) {
			tfid = new JTextField();
			tfid.setBounds(120, 270, 130, 26);
			tfid.setColumns(10);
		}
		return tfid;
	}
	private JTextField getTfname() {
		if (tfname == null) {
			tfname = new JTextField();
			tfname.setBounds(125, 318, 90, 26);
			tfname.setColumns(10);
		}
		return tfname;
	}
	private JTextField getTfphone() {
		if (tfphone == null) {
			tfphone = new JTextField();
			tfphone.setBounds(125, 369, 183, 26);
			
			tfphone.setColumns(10);
		}
		return tfphone;
	}
	private JButton getBtnSearchpw() {
		if (btnSearchpw == null) {
			btnSearchpw = new JButton("비밀번호 찾기");
			btnSearchpw.setBorder(new LineBorder(new Color(214, 203, 216), 2));
			int red = 0xD6;
	        int green = 0xCB;											//기준색 D6CBD8 에 대한 값
	        int blue = 0xD8;

	        Color BackColor = new Color(red, green, blue);				//색깔 적용	   
	        btnSearchpw.setBackground(BackColor);
	        btnSearchpw.setOpaque(true);
			btnSearchpw.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
										searchPw();
				}
			});
			btnSearchpw.setBounds(138, 570, 117, 29);
		}
		return btnSearchpw;
	}
	
	
	
	
	
	//--------Function--------
	
	
	public void searchPw() {
		
	}
	
}
