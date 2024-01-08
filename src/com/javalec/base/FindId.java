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

public class FindId extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel fIdBackground;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindId dialog = new FindId();
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
	public FindId() {
		setFont(new Font("Lucida Grande", Font.BOLD, 27));
		setTitle("아이디 찾기");
		setBounds(100, 100, 430, 732);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getTextField());
		getContentPane().add(getTextField_1());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getFIdBackground());

	}
	private JLabel getFIdBackground() {
		if (fIdBackground == null) {
			fIdBackground = new JLabel("");
			fIdBackground.setBounds(0, 0, 430, 704);
			fIdBackground.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/logindetailBackground.png")));
		}
		return fIdBackground;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("아이디 찾기");
			lblNewLabel.setForeground(new Color(214, 203, 216));
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(175, 165, 80, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름");
			lblNewLabel_1.setBounds(60, 275, 35, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("전화번호");
			lblNewLabel_2.setBounds(60, 340, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(120, 270, 100, 26);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(120, 337, 250, 26);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("아이디 찾기");
			btnNewButton.setBorder(new LineBorder(new Color(214, 203, 216), 2));
			int red = 0xD6;
	        int green = 0xCB;											//기준색 D6CBD8 에 대한 값
	        int blue = 0xD8;

	        Color BackColor = new Color(red, green, blue);				//색깔 적용	   
	        btnNewButton.setBackground(BackColor);
	        btnNewButton.setOpaque(true);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
								 idsearch();
				}
			});
			btnNewButton.setBounds(144, 567, 117, 29);
		}
		return btnNewButton;
	}
	
	
	
	
	
	
	
	
	//------------Function--------------
	
	public void idsearch() {
			
	}
	
	
}
