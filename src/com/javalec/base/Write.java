package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.function.Dao_Write;
import com.javalec.function.Dto_Write;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Write extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfTitle;
	private JTextField tfPrice;
	private JTextField tfDescription;
	private JTextField tfUserid;
	private JLabel lblNewLabel_3_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Write frame = new Write();
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
	public Write() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				insertInfo();//*****input*****
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 732);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnHome = new JButton("홈");
		btnHome.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnHome.setBounds(37, 55, 70, 34);
		contentPane.add(btnHome);
		
		JButton btnMypage = new JButton("개인");
		btnMypage.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnMypage.setBounds(131, 55, 70, 34);
		contentPane.add(btnMypage);
		
		JButton btnChat = new JButton("채팅");
		btnChat.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnChat.setBounds(227, 55, 70, 34);
		contentPane.add(btnChat);
		
		JButton btnWrite = new JButton("글쓰기");
		btnWrite.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnWrite.setBounds(320, 55, 70, 34);
		contentPane.add(btnWrite);
		
		JLabel lblNewLabel_3 = new JLabel("제목");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(37, 119, 70, 30);
		contentPane.add(lblNewLabel_3);
		contentPane.add(getLblNewLabel_3_1());
		
		tfTitle = new JTextField();
		tfTitle.setFont(new Font("Dialog", Font.PLAIN, 14));
		tfTitle.setColumns(10);
		tfTitle.setBounds(150, 119, 240, 28);
		contentPane.add(tfTitle);
		
		tfPrice = new JTextField();
		tfPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		tfPrice.setFont(new Font("Dialog", Font.PLAIN, 14));
		tfPrice.setColumns(10);
		tfPrice.setBounds(150, 156, 240, 24);
		contentPane.add(tfPrice);
		
		JLabel lblNewLabel_1 = new JLabel("원");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(379, 156, 34, 25);
		contentPane.add(lblNewLabel_1);
		
		tfDescription = new JTextField();
		tfDescription.setFont(new Font("Dialog", Font.PLAIN, 14));
		tfDescription.setColumns(10);
		tfDescription.setBounds(29, 215, 371, 294);
		contentPane.add(tfDescription);
		
		JLabel lbladdimage = new JLabel("");
		lbladdimage.setHorizontalAlignment(SwingConstants.CENTER);
		lbladdimage.setBounds(37, 548, 64, 59);
		contentPane.add(lbladdimage);
		
		JLabel lblimage = new JLabel("");
		lblimage.setBounds(127, 548, 64, 59);
		contentPane.add(lblimage);
		
		JButton btnPost = new JButton("게시하기");
		btnPost.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnPost.setBounds(111, 640, 210, 40);
		contentPane.add(btnPost);
		
		JLabel lblNewLabel_4 = new JLabel("ID :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(294, 521, 34, 15);
		contentPane.add(lblNewLabel_4);
		contentPane.add(getTfUserid());
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Write.class.getResource("/com/javalec/images/writingBackgroundnew.png")));
		lblNewLabel.setBounds(0, 0, 430, 704);
		contentPane.add(lblNewLabel);
		
	}
	private JTextField getTfUserid() {
		if (tfUserid == null) {
			tfUserid = new JTextField();
			tfUserid.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			tfUserid.setBounds(326, 520, 78, 16);
			tfUserid.setColumns(10);
		}
		return tfUserid;
	}
	
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("판매가격");
			lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3_1.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblNewLabel_3_1.setBounds(37, 150, 70, 30);
		}
		return lblNewLabel_3_1;
	}
	
	
	//--------functions----------
	
		private void insertInfo() {
		
			Dao_Write dao = new Dao_Write();
			Dto_Write dto = dao.userIdinput();
		
			tfUserid.setText(dto.getUserid());
		
	}
	
}//--end--
