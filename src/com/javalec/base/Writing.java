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
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;

public class Writing {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JButton btnHome;
	private JButton btnMypage;
	private JButton btnChat;
	private JButton btnWrite;
	private JLabel lblNewLabel_2;
	private JTextField tfTitle;
	private JTextField tfPrice;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;

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
		frame.getContentPane().add(getBtnChat());
		frame.getContentPane().add(getBtnWrite());
		frame.getContentPane().add(getLblNewLabel_3());
		
		tfTitle = new JTextField();
		tfTitle.setFont(new Font("Dialog", Font.PLAIN, 14));
		tfTitle.setBounds(150, 119, 240, 28);
		frame.getContentPane().add(tfTitle);
		tfTitle.setColumns(10);
		frame.getContentPane().add(getLblNewLabel_2());
		
		tfPrice = new JTextField();
		tfPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		tfPrice.setFont(new Font("Dialog", Font.PLAIN, 14));
		tfPrice.setBounds(150, 156, 240, 24);
		frame.getContentPane().add(tfPrice);
		tfPrice.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("원");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(379, 159, 34, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextArea taWriting = new JTextArea();
		taWriting.setLineWrap(true);
		taWriting.setFont(new Font("Dialog", Font.PLAIN, 14));
		taWriting.setBounds(39, 219, 351, 288);
		frame.getContentPane().add(taWriting);
		
		JLabel lbladdimage = new JLabel("");
		lbladdimage.setHorizontalAlignment(SwingConstants.CENTER);
		lbladdimage.setBounds(37, 548, 64, 59);
		frame.getContentPane().add(lbladdimage);
		
		JLabel lblimage = new JLabel("");
		lblimage.setBounds(127, 548, 64, 59);
		frame.getContentPane().add(lblimage);
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getLblNewLabel());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Writing.class.getResource("/com/javalec/images/writingBackgroundnew.png")));
			lblNewLabel.setBounds(0, 0, 430, 704);
		}
		return lblNewLabel;
	}
	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("홈");
			btnHome.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnHome.setBounds(30, 55, 70, 34);
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
			btnMypage.setBounds(130, 55, 70, 34);
		}
		return btnMypage;
	}
	private JButton getBtnChat() {
		if (btnChat == null) {
			btnChat = new JButton("채팅");
			btnChat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnChat.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnChat.setBounds(230, 55, 70, 34);
		}
		return btnChat;
	}
	private JButton getBtnWrite() {
		if (btnWrite == null) {
			btnWrite = new JButton("글쓰기");
			btnWrite.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnWrite.setBounds(330, 55, 70, 34);
		}
		return btnWrite;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("판매금액");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblNewLabel_2.setBounds(37, 156, 70, 25);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("제목");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblNewLabel_3.setBounds(37, 119, 70, 30);
		}
		return lblNewLabel_3;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("게시하기");
			btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 14));
			btnNewButton.setBounds(111, 640, 210, 40);
		}
		return btnNewButton;
	}
}
