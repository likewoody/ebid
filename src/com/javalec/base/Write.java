package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.javalec.function.Dao_Write;
import com.javalec.function.Dto_Write;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Write extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField tfTitle;
	private JTextField tfPrice;
	private JTextField tfdescription;
	private JTextField tfUserid;
	private JLabel lblNewLabel_3_1;

	private AbstractButton lblUserid;
	private JTextArea texDescription;


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
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//input
				Home home = new Home();
				dispose();
				home.setVisible(true);
			
			}
		});
		btnHome.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnHome.setBounds(37, 55, 70, 34);
		contentPane.add(btnHome);
		
		JButton btnMypage = new JButton("개인");
		btnMypage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//input
				MyPage mypage = new MyPage();
				dispose();
				mypage.setVisible(true);
			
			}
		});
		btnMypage.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnMypage.setBounds(131, 55, 70, 34);
		contentPane.add(btnMypage);
		
		JButton btnChat = new JButton("채팅");
		btnChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Chat chat = new Chat();
					dispose();
					chat.setVisible(true);
			}
		});
		btnChat.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnChat.setBounds(227, 55, 70, 34);
		contentPane.add(btnChat);
		
		JButton btnWrite = new JButton("글쓰기");
		btnWrite.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnWrite.setBounds(320, 55, 70, 34);
		contentPane.add(btnWrite);
		
		JLabel lblNewLabel_3 = new JLabel("제목");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 13));
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
		contentPane.add(getTexDescription());
		
		JLabel lblNewLabel_1 = new JLabel("원");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(379, 156, 34, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lbladdimage = new JLabel("");
		lbladdimage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inputimage();
			}
		});
		lbladdimage.setHorizontalAlignment(SwingConstants.CENTER);
		lbladdimage.setBounds(37, 548, 64, 59);
		contentPane.add(lbladdimage);
		
		JLabel lblimage = new JLabel("");
		lblimage.setBounds(127, 548, 64, 59);
		contentPane.add(lblimage);
		
		JButton btnPost = new JButton("게시하기");
		btnPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAction(); //******input***********
			}
		});
		btnPost.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnPost.setBounds(111, 640, 210, 40);
		contentPane.add(btnPost);
		
		JLabel lblNewLabel_4 = new JLabel("아이디 :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(289, 521, 47, 15);
		contentPane.add(lblNewLabel_4);
		contentPane.add(getTfUserid());
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(Write.class.getResource("/com/javalec/images/writingBackgroundnew.png")));
		lblBackground.setBounds(0, 0, 430, 704);
		contentPane.add(lblBackground);
		
		tfdescription = new JTextField();
		tfdescription.setHorizontalAlignment(SwingConstants.LEFT);
		tfdescription.setFont(new Font("Dialog", Font.PLAIN, 14));
		tfdescription.setColumns(10);
		tfdescription.setBounds(29, 215, 371, 294);
		contentPane.add(tfdescription);
		
	}
	private JTextField getTfUserid() {
		if (tfUserid == null) {
			tfUserid = new JTextField();
			tfUserid.setEditable(false);
			tfUserid.setHorizontalAlignment(SwingConstants.CENTER);
			tfUserid.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			tfUserid.setBounds(336, 520, 64, 16);
			tfUserid.setColumns(10);
		}
		return tfUserid;
	}
	
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("판매가격");
			lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3_1.setFont(new Font("Dialog", Font.PLAIN, 13));
			lblNewLabel_3_1.setBounds(37, 156, 70, 24);
		}
		return lblNewLabel_3_1;
	}
	
	
	private JTextArea getTexDescription() {
		if (texDescription == null) {
			texDescription = new JTextArea();
			texDescription.setWrapStyleWord(true);
			texDescription.setLineWrap(true);
			texDescription.setFont(new Font("Dialog", Font.PLAIN, 13));
			texDescription.setBounds(37, 224, 353, 285);
		}
		return texDescription;
	}
	
	
	//--------functions----------
	
	private void insertInfo() {
	
		Dao_Write dao = new Dao_Write();
		Dto_Write dto = dao.userIdinput();
	
		tfUserid.setText(dto.getUserid());
			
	}
	
	// 정보 입력하기
	private void updateAction() {
		
		// 작동됨******************
		String title = tfTitle.getText();
		String price = tfPrice.getText();  	                
        String description = texDescription.getText();
        // 추가 고정값
     
    
    // 회원가입 처리
    Dao_Write dao = new Dao_Write(title, description, price); 
    // 사용자 등록 수행
    dao.wUpdate();

    // 사용자에게 성공적으로 등록되었음을 알림
    JOptionPane.showMessageDialog(null, "게시글이 등록되었습니다.");
   dispose();
	}
	
	private void inputimage() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "bmp");
		chooser.setFileFilter(filter);

		int ret = chooser.showOpenDialog(null);
		if (ret == JFileChooser.APPROVE_OPTION) {
			// 내가 선택한 사진 파일 경로 찾기
		    File selectedFile = chooser.getSelectedFile();
		    String filePath = selectedFile.getPath();
		    
		    FileInputStream input = null;
		    File file = new File(filePath);
		    
		    try {
		    	input = new FileInputStream(file);
		    }catch(Exception e) {
		    	e.printStackTrace();
		    }
		    
		} else {
		    JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.");
		}
	}
}//--end--
