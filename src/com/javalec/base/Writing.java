package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Writing {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JButton btnHome;
	private JButton btnMypage;
	private JButton btnAlram;
	private JButton btnChat;
	private JButton btnWrite;
	private JComboBox comboBox;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Writing window = new Writing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Writing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 430, 732);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnHome());
		frame.getContentPane().add(getBtnMypage());
		frame.getContentPane().add(getBtnAlram());
		frame.getContentPane().add(getBtnChat());
		frame.getContentPane().add(getBtnWrite());
		frame.getContentPane().add(getComboBox());
		
		lblNewLabel_1 = new JLabel("제목을 입력해주세요.");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(143, 120, 187, 25);
		frame.getContentPane().add(lblNewLabel_1);
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_3());
		
		textField = new JTextField();
		textField.setBounds(38, 221, 355, 281);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(37, 548, 50, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("게시하기");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(115, 643, 50, 15);
		frame.getContentPane().add(lblNewLabel_5);
		frame.getContentPane().add(getLblNewLabel());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Writing.class.getResource("/com/javalec/images/writingBackgroud.png")));
			lblNewLabel.setBounds(0, 0, 430, 704);
		}
		return lblNewLabel;
	}
	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("홈");
			btnHome.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnHome.setBounds(20, 55, 70, 34);
		}
		return btnHome;
	}
	private JButton getBtnMypage() {
		if (btnMypage == null) {
			btnMypage = new JButton("개인");
			btnMypage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnMypage.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnMypage.setBounds(98, 55, 70, 34);
		}
		return btnMypage;
	}
	private JButton getBtnAlram() {
		if (btnAlram == null) {
			btnAlram = new JButton("알림");
			btnAlram.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnAlram.setBounds(180, 55, 70, 34);
		}
		return btnAlram;
	}
	private JButton getBtnChat() {
		if (btnChat == null) {
			btnChat = new JButton("채팅");
			btnChat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnChat.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnChat.setBounds(262, 55, 70, 34);
		}
		return btnChat;
	}
	private JButton getBtnWrite() {
		if (btnWrite == null) {
			btnWrite = new JButton("글쓰기");
			btnWrite.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnWrite.setBounds(343, 55, 70, 34);
		}
		return btnWrite;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"판매", "경매"}));
			comboBox.setFont(new Font("Helvetica", Font.PLAIN, 14));
			comboBox.setEditable(true);
			comboBox.setToolTipText("");
			comboBox.setBounds(37, 116, 70, 34);
		}
		return comboBox;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("판매금액");
			lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblNewLabel_2.setBounds(37, 156, 70, 25);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_3.setBounds(153, 155, 230, 22);
		}
		return lblNewLabel_3;
	}
}
