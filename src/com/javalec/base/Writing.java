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

public class Writing {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JButton btnHome;
	private JButton btnMypage;
	private JButton btnAlram;
	private JButton btnChat;
	private JButton btnWrite;
	private JComboBox comboBox;
	private JTextPane textPane;

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
		frame.getContentPane().add(getTextPane());
		frame.getContentPane().add(getLblNewLabel());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Writing.class.getResource("/com/javalec/images/mainFrame.png")));
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
			comboBox.setBounds(30, 131, 70, 34);
		}
		return comboBox;
	}
	private JTextPane getTextPane() {
		if (textPane == null) {
			textPane = new JTextPane();
			textPane.setBounds(16, 177, 395, 428);
		}
		return textPane;
	}
}
