package com.javalec.base;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class ArticlePage extends JDialog {

	private static final long serialVersionUID = 1L;
	 private Object[][] data = {
	            {"회원 식별 및 서비스 제공", "아이디 , 비밀번호", "개인정보 보호법 제15조 제1항"},
	            {"서비스 변경사항 및 고지사항 전달", "전화번호, 이메일, 주소", "개인정보 보호법 제15조 제1항"},
	    };

	    private String[] columnNames = {"수집목적", "수집항목", "수집 근거"};


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArticlePage dialog = new ArticlePage();
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
	public ArticlePage() {
		setBounds(100, 100, 683, 307);
		getContentPane().setLayout(null);
		  // JTable을 생성하고 데이터와 열 제목을 설정
        JTable table = new JTable(new DefaultTableModel(data, columnNames));
        table.setRowSelectionAllowed(false);
        
        // JScrollPane을 이용하여 JTable을 감싸서 스크롤이 가능하도록 함
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(25, 47, 636, 65);
        
        getContentPane().add(scrollPane);
        
        JLabel lblNewLabel = new JLabel("*귀하는 이웃비드의 서비스 이용에 필요한 최소한의 개인정보수집•이용에 동의하지않을 수 있으나");
        lblNewLabel.setBounds(36, 164, 554, 15);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("동의를 거부할 경우 회원제서비스이용이 불가합니다.");
        lblNewLabel_1.setBounds(40, 189, 532, 15);
        getContentPane().add(lblNewLabel_1);
        
        JButton btnNewButton = new JButton("닫기");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        					exit();
        	}
        });
        btnNewButton.setBounds(276, 214, 91, 23);
        getContentPane().add(btnNewButton);
	}
	
	
	//----Function---
	
	public void exit() {
		dispose();
		
	}
	
	
}
