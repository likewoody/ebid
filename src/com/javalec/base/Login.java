package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel loginBackground;
	private JLabel lblNewLabel;
	private JLabel lblPw;
	private JTextField tfId;
	private JTextField tfPw;
	private JButton btnLogin;
	private JLabel lblSign;
	private JLabel lblFindid;
	private JLabel lblFindpw;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setFont(new Font("Lucida Grande", Font.BOLD, 27));
		setTitle("로그인");
		setBounds(100, 100, 430, 732);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLblPw());
		contentPanel.add(getTfId());
		contentPanel.add(getTfPw());
		contentPanel.add(getBtnLogin());
		contentPanel.add(getLblNewLabel_1_3());
		contentPanel.add(getLblNewLabel_1_2());
		contentPanel.add(getLblSign());
		contentPanel.add(getLblFindid());
		contentPanel.add(getLblFindpw());
		contentPanel.add(getLoginBackground());
	}
	private JLabel getLoginBackground() {
		if (loginBackground == null) {
			loginBackground = new JLabel("");
			loginBackground.setBounds(0, 0, 430, 704);
			loginBackground.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/loginBackground.png")));
		}
		return loginBackground;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("아이디 : ");
			lblNewLabel.setBounds(35, 320, 50, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblPw() {
		if (lblPw == null) {
			lblPw = new JLabel("비밀번호 :");
			lblPw.setBounds(25, 370, 60, 16);
		}
		return lblPw;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(96, 315, 280, 26);
			tfId.setColumns(10);
			tfId.setBorder(new LineBorder(new Color(214, 203, 216)));
		}
		return tfId;
	}
	private JTextField getTfPw() {
		if (tfPw == null) {
			tfPw = new JTextField();
			tfPw.setColumns(10);
			tfPw.setBounds(96, 366, 280, 26);
			tfPw.setBorder(new LineBorder(new Color(214, 203, 216)));
		}
		return tfPw;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("로그인");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
										Login();
				}
			});
			btnLogin.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			btnLogin.setBounds(155, 450, 130, 38);
			btnLogin.setBorder(new LineBorder(new Color(214, 203, 216), 2));
			int red = 0xD6;
	        int green = 0xCB;											//기준색 D6CBD8 에 대한 값
	        int blue = 0xD8;

	        Color BackColor = new Color(red, green, blue);				//색깔 적용	   
	        btnLogin.setBackground(BackColor);
	        btnLogin.setOpaque(true);
//			btnLogin.setBorder(new LineBorder(new Color(214, 203, 216)));
		}
		return btnLogin;
	}
	private JLabel getLblSign() {
		if (lblSign == null) {
			lblSign = new JLabel("회원가입");
			lblSign.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
									clickSign();
				}
				@Override
				public void mouseEntered(MouseEvent e) {
									enterSign();
				}
				@Override
				public void mouseExited(MouseEvent e) {
									exitSign();
					
				}
			});
			lblSign.setBounds(126, 500, 61, 16);
		}
		return lblSign;
	}
	private JLabel getLblFindid() {
		if (lblFindid == null) {
			lblFindid = new JLabel("아이디 찾기");
			lblFindid.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
									clickFindid();
				}
				@Override
				public void mouseEntered(MouseEvent e) {
									enterFindid();
				}
				@Override
				public void mouseExited(MouseEvent e) {
									exitFindid();
				}
			});
			lblFindid.setBounds(192, 500, 61, 16);
		}
		return lblFindid;
	}
	private JLabel getLblFindpw() {
		if (lblFindpw == null) {
			lblFindpw = new JLabel("비밀번호 찾기");
			lblFindpw.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
									clickFindpw();
				}
				@Override
				public void mouseEntered(MouseEvent e) {
									enterFindpw();
				}
				@Override
				public void mouseExited(MouseEvent e) {
									exitFindpw();
				}
			});
			lblFindpw.setBounds(270, 500, 72, 16);
		}
		return lblFindpw;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("|");
			lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_2.setBounds(232, 500, 61, 16);
		}
		return lblNewLabel_1_2;
	}
	private JLabel getLblNewLabel_1_3() {
		if (lblNewLabel_1_3 == null) {
			lblNewLabel_1_3 = new JLabel("|");
			lblNewLabel_1_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
				}
			});
			lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_3.setBounds(152, 500, 61, 16);
		}
		return lblNewLabel_1_3;
	}
	
	
	
	//---------Function---------
	
	
	public void clickSign() {
				Register register = new Register();			//회원가입 클릭
				register.setVisible(true);
				this.setVisible(false);
				
				
		
	}
	public void enterSign() {					
	
	}
	public void exitSign() {					
		
	}
	public void clickFindid() {
				FindId findId = new FindId();			  //아이디 찾기 클릭
				findId.setVisible(true);
				this.setVisible(false);
			
				
	}
	public void enterFindid() {
		
	}
	public void exitFindid() {
		
	}
	public void clickFindpw() {
			FindPw findPw = new FindPw();				//패스워드 찾기 클릭
			findPw.setVisible(true);
			this.setVisible(false);
			
	}
	public void enterFindpw() {
		
	}
	public void exitFindpw() {
		
	}
	
	
	
	
	
	
//	// 중복되는 코드 모아주는 매소드   ************************************************
//	 private void setMouseOverEffect(JLabel lblSign2) {
//	        lblSign2.setForeground(Color.BLACK);						//글씨 색깔
//	        Font font = new Font("Arial Black", Font.ITALIC, 13);		//사용 폰트
//	        lblSign2.setFont(font);									//폰트 적용
//	    }
//	
//	 private void resetButton(JTextField textField) {
//	        textField.setForeground(UIManager.getColor("TextField.foreground"));		//텍스트 색깔 되돌리기 
//	        textField.setFont(null);													//폰트 초기화
//	    }
//	 // 중복되는 코드 모아주는 매소드   ************************************************
	
	public void Login() {
				Home H = new Home();
				H.setVisible(true);					//로그인 시 홈으로 이동
				this.setVisible(false);
				
	}
	
	
}
