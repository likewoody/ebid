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
	private JButton btnAlram;
	private JButton btnChat;
	private JButton btnWrite;
	private JComboBox comboBox;
	private JLabel lblNewLabel_2;
	private JTextField tfTitle;
	private JTextField tfPrice;

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
		
		tfTitle = new JTextField();
		tfTitle.setFont(new Font("Dialog", Font.PLAIN, 14));
		tfTitle.setText("제목을 입력하세요.");
		tfTitle.setBounds(150, 119, 240, 28);
		frame.getContentPane().add(tfTitle);
		tfTitle.setColumns(10);
		frame.getContentPane().add(getLblNewLabel_2());
		
		tfPrice = new JTextField();
		tfPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		tfPrice.setFont(new Font("Dialog", Font.PLAIN, 14));
		tfPrice.setBounds(150, 156, 221, 24);
		frame.getContentPane().add(tfPrice);
		tfPrice.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("원");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(370, 156, 34, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextArea taWriting = new JTextArea();
		taWriting.setLineWrap(true);
		taWriting.setFont(new Font("Dialog", Font.PLAIN, 14));
		taWriting.setBounds(39, 219, 351, 288);
		frame.getContentPane().add(taWriting);
		
		JLabel lbladdimage = new JLabel("addimage");
		lbladdimage.setBounds(37, 548, 64, 59);
		frame.getContentPane().add(lbladdimage);
		
		JLabel lblimage = new JLabel("image");
		lblimage.setBounds(127, 548, 64, 59);
		frame.getContentPane().add(lblimage);
		
		JLabel lblPosting = new JLabel("게시하기");
		lblPosting.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblPosting.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosting.setBounds(116, 640, 201, 34);
		frame.getContentPane().add(lblPosting);
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
}
