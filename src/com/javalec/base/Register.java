package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.javalec.function.Dao_Login;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel reBackground;
	private JLabel lblNewLabel;
	private JLabel lblid;
	private JLabel lblpw;
	private JLabel lblpwRe;
	private JLabel lblNickname;
	private JLabel lblname;
	private JLabel lblphone;
	private JLabel lbladdress;
	private JTextField tfnickname;
	private JTextField tfphone;
	private JTextField tfpw;
	private JTextField tfid;
	private JTextField tfname;
	private JTextField tfpwRe;
	private JTextField tfaddress2;
	private JTextField tfaddress1;
	private JComboBox cbaddress;
	private JButton btnIdchek;
	private JButton btnnickNamechek;
	private JButton btnsignIn;
	private JCheckBox ckbagree;
	private JTextField tfPinfo;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Register dialog = new Register();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Register() {
		setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		setTitle("회원가입");
		setBounds(100, 100, 430, 732);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getTfid());
		contentPanel.add(getLblid());
		contentPanel.add(getLblpw());
		contentPanel.add(getLblpwRe());
		contentPanel.add(getLblNickname());
		contentPanel.add(getLblname());
		contentPanel.add(getLblphone());
		contentPanel.add(getLbladdress());
		contentPanel.add(getTfnickname());
		contentPanel.add(getTfphone());
		contentPanel.add(getTfpw());
		contentPanel.add(getTfname());
		contentPanel.add(getTfpwRe());
		contentPanel.add(getTfaddress2());
		contentPanel.add(getTfaddress1());
		contentPanel.add(getCbaddress());
		contentPanel.add(getBtnIdchek());
		contentPanel.add(getBtnnickNamechek());
		contentPanel.add(getBtnsignIn());
		contentPanel.add(getCkbagree());
		contentPanel.add(getTfPinfo());
		contentPanel.add(getBtnBack());
		contentPanel.add(getReBackground());
	}
	private JLabel getReBackground() {
		if (reBackground == null) {
			reBackground = new JLabel("");
			reBackground.setBounds(0, 0, 430, 704);
			reBackground.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/logindetailBackground.png")));
		}
		return reBackground;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("회원가입");
			lblNewLabel.setForeground(new Color(214, 203, 216));
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(175, 165, 80, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblid() {
		if (lblid == null) {
			lblid = new JLabel("ID :");
			lblid.setBounds(52, 232, 40, 16);
		}
		return lblid;
	}
	private JLabel getLblpw() {
		if (lblpw == null) {
			lblpw = new JLabel("PW :");
			lblpw.setBounds(52, 277, 61, 16);
		}
		return lblpw;
	}
	private JLabel getLblpwRe() {
		if (lblpwRe == null) {
			lblpwRe = new JLabel("PW 재입력 :");
			lblpwRe.setBounds(52, 318, 65, 16);
		}
		return lblpwRe;
	}
	private JLabel getLblNickname() {
		if (lblNickname == null) {
			lblNickname = new JLabel("닉네임 :");
			lblNickname.setBounds(52, 360, 61, 16);
		}
		return lblNickname;
	}
	private JLabel getLblname() {
		if (lblname == null) {
			lblname = new JLabel("이름 :");
			lblname.setBounds(52, 407, 61, 16);
		}
		return lblname;
	}
	private JLabel getLblphone() {
		if (lblphone == null) {
			lblphone = new JLabel("전화번호 :");
			lblphone.setBounds(52, 450, 61, 16);
		}
		return lblphone;
	}
	private JLabel getLbladdress() {
		if (lbladdress == null) {
			lbladdress = new JLabel("주소 :");
			lbladdress.setBounds(52, 492, 61, 16);
		}
		return lbladdress;
	}
	private JTextField getTfnickname() {
		if (tfnickname == null) {
			tfnickname = new JTextField();
			tfnickname.setBounds(130, 354, 200, 26);
			tfnickname.setColumns(10);
		}
		return tfnickname;
	}
	private JTextField getTfphone() {
		if (tfphone == null) {
			tfphone = new JTextField();
			tfphone.setColumns(10);
			tfphone.setBounds(130, 445, 290, 26);
		}
		return tfphone;
	}
	private JTextField getTfpw() {
		if (tfpw == null) {
			tfpw = new JTextField();
			tfpw.setColumns(10);
			tfpw.setBounds(130, 270, 290, 26);
		}
		return tfpw;
	}
	private JTextField getTfid() {
		if (tfid == null) {
			tfid = new JTextField();
			tfid.setColumns(10);
			tfid.setBounds(130, 227, 200, 26);
		}
		return tfid;
	}
	private JTextField getTfname() {
		if (tfname == null) {
			tfname = new JTextField();
			tfname.setColumns(10);
			tfname.setBounds(130, 402, 290, 26);
		}
		return tfname;
	}
	private JTextField getTfpwRe() {
		if (tfpwRe == null) {
			tfpwRe = new JTextField();
			tfpwRe.setColumns(10);
			tfpwRe.setBounds(130, 312, 290, 26);
		}
		return tfpwRe;
	}
	private JTextField getTfaddress2() {
		if (tfaddress2 == null) {
			tfaddress2 = new JTextField();
			tfaddress2.setColumns(10);
			tfaddress2.setBounds(325, 487, 100, 26);
		}
		return tfaddress2;
	}
	private JTextField getTfaddress1() {
		if (tfaddress1 == null) {
			tfaddress1 = new JTextField();
			tfaddress1.setColumns(10);
			tfaddress1.setBounds(225, 487, 100, 26);
		}
		return tfaddress1;
	}
	private JComboBox getCbaddress() {
		if (cbaddress == null) {
			cbaddress = new JComboBox();
			cbaddress.setModel(new DefaultComboBoxModel(new String[] {"서울특별시", "인천광역시", "대전광역시", "대구광역시", "울산광역시", "부산광역시", "광주광역시", "세종특별자치시", "경기도", "강원도", "충청남도", "충청북도", "경상북도", "전라북도", "전라남도", "경상남도", "제주특별자치도"}));
			cbaddress.setBounds(85, 488, 135, 27);
		}
		return cbaddress;
	}
	private JButton getBtnIdchek() {
		if (btnIdchek == null) {
			btnIdchek = new JButton("중복확인");
			btnIdchek.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					  		idDoubleCheck();
					  		
				}
			});
			btnIdchek.setBounds(330, 227, 80, 26);
		}
		return btnIdchek;
	}
	private JButton getBtnnickNamechek() {
		if (btnnickNamechek == null) {
			btnnickNamechek = new JButton("중복확인");
			btnnickNamechek.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
								nickNameDoubleCheck();
				}
			});
			btnnickNamechek.setBounds(330, 354, 80, 26);
		}
		return btnnickNamechek;
	}
	private JButton getBtnsignIn() {
		if (btnsignIn == null) {
			btnsignIn = new JButton("회원가입");
			btnsignIn.setBorder(new LineBorder(new Color(214, 203, 216), 2));
			int red = 0xD6;
	        int green = 0xCB;											//기준색 D6CBD8 에 대한 값
	        int blue = 0xD8;

	        Color BackColor = new Color(red, green, blue);				//색깔 적용	   
	        btnsignIn.setBackground(BackColor);
	        btnsignIn.setOpaque(true);
			btnsignIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
									signIn();
				}
			});
			btnsignIn.setBounds(260, 624, 117, 29);
		}
		return btnsignIn;
	}
	private JCheckBox getCkbagree() {
		if (ckbagree == null) {
			ckbagree = new JCheckBox("");
			ckbagree.addMouseListener(new MouseAdapter() {
			
			});
			ckbagree.setBounds(127, 545, 30, 23);
		}
		return ckbagree;
	}
	private JTextField getTfPinfo() {
		if (tfPinfo == null) {
			tfPinfo = new JTextField();
			tfPinfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
							 goPinfo();
				}
			});
			tfPinfo.setEditable(false);
			tfPinfo.setText("(필수) 개인정보 수집에 대한 동의.");
			tfPinfo.setBounds(158, 545, 220, 23);
			tfPinfo.setColumns(10);
		}
		return tfPinfo;
	}
	
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("뒤로가기");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
										goBack();
				}
			});
			btnBack.setOpaque(true);
			btnBack.setBorder(new LineBorder(new Color(214, 203, 216), 2));
			btnBack.setBackground(new Color(214, 203, 216));
			btnBack.setBounds(70, 624, 117, 29);
		}
		return btnBack;
	}
	
	
	
	
	
	//--------Function---------
	
	
	
	public void signIn() {
//				if ( signError()) {
//					
//				}
//						
				Dao_Login dao = new Dao_Login();
			dao.signUpdate();
						JOptionPane.showInputDialog(null, "회원가입이 완료되었습니다.", JOptionPane.INFORMATION_MESSAGE);
					
		
		
	}	
				
	public boolean signError() {
		  if (tfid.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "ID를 입력하세요.", "알림", JOptionPane.WARNING_MESSAGE);
	            return false;
	        }

	        if (tfpw.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요.", "알림", JOptionPane.WARNING_MESSAGE);
	            return false;
	        }

	        if (tfpwRe.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "비밀번호 재입력을 입력하세요.", "알림", JOptionPane.WARNING_MESSAGE);
	            return false;
	        }

	        if (tfnickname.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "닉네임을 입력하세요.", "알림", JOptionPane.WARNING_MESSAGE);
	            return false;
	        }

	        if (tfname.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "이름을 입력하세요.", "알림", JOptionPane.WARNING_MESSAGE);
	            return false;
	        }

	        if (tfphone.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "전화번호를 입력하세요.", "알림", JOptionPane.WARNING_MESSAGE);
	            return false;
	        }

	        if (tfaddress1.getText().isEmpty() || tfaddress2.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "주소를 입력하세요.", "알림", JOptionPane.WARNING_MESSAGE);
	            return false;
	        }

	        return true;
	    
	
				
				
	}
	// 아이디 중복확인
	public void idDoubleCheck() {
		 String userId = tfid.getText();
		 Dao_Login daoLogin = new Dao_Login(userId);
		 			if ( tfid.getText().isEmpty()) {
		 				JOptionPane.showMessageDialog(this, "ID를 입력해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
		 				return;
		 			}
		 			if (daoLogin.Idcheck())  {
		        JOptionPane.showMessageDialog(this, "사용 가능한 ID입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
		 		tfid.setEditable(false);
		 			}
		 			else 
		        JOptionPane.showMessageDialog(this, "이미 사용 중인 ID입니다. 다른 ID를 입력하세요.", "알림", JOptionPane.WARNING_MESSAGE);
	

	}
	//닉네임 중복 확인
	public void nickNameDoubleCheck() {
		 String userNickname = tfnickname.getText();
		 Dao_Login daoLogin = new Dao_Login(userNickname);
		 			if ( tfnickname.getText().isEmpty()) {		
		 				JOptionPane.showMessageDialog(this, "닉네임을 입력해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
		 				return;
		 			}
		 			if (daoLogin.nickNameCheck()) {
		        JOptionPane.showMessageDialog(this, "사용 가능한 닉네임 입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
		          tfnickname.setEditable(false);
	}else { 
		        JOptionPane.showMessageDialog(this, "이미 사용 중인 닉네임 입니다. 다른 닉네임을 입력하세요.", "알림", JOptionPane.WARNING_MESSAGE);
		        
	}
	}
				
		
		
	public void goPinfo() {
			JOptionPane.showMessageDialog(null, "");				//약관 집어 넣기?
	}
	// 로그인 화면으로 돌아가기
	public void goBack () {
		int back = JOptionPane.showConfirmDialog(null, "로그인 화면으로 돌아가시갰습니까?", "알림", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (back == JOptionPane.YES_OPTION) {
		dispose();
		Login login = new Login();	
		login.setVisible(true);
		
					
	}
	}
//	
//	public void startRegister() {
//						Dao_Login dao = new Dao_Login();
//						if(dao.Idcheck()) {
//						 tfid.setEditable(false);
//						}
//	}

	
}