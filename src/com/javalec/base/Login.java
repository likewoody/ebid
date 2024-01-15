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

import com.javalec.function.Dao_Login;
import com.javalec.function.Share;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel loginBackground;
	private JLabel lblNewLabel;
	private JLabel lblPw;
	private JTextField tfId;
	private JButton btnLogin;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JPasswordField tfpw;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnSign;
	private JButton btnFindid;
	private JButton btnFindpw;

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
		contentPanel.add(getBtnLogin());
		contentPanel.add(getLblNewLabel_1_3());
		contentPanel.add(getLblNewLabel_1_2());
		
		tfpw = new JPasswordField();
		tfpw.setBounds(96, 370, 280, 26);
		tfpw.setBorder(new LineBorder(new Color(214, 203, 216)));
		contentPanel.add(tfpw);
//		contentPanel.add(getBtnNewButton());
//		contentPanel.add(getBtnNewButton_(1));
//		contentPanel.add(getBtnNewButton_(2));
		contentPanel.add(getBtnSign());
		contentPanel.add(getBtnFindid());
		contentPanel.add(getBtnFindpw());
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
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("|");
			lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_2.setBounds(275, 500, 20, 16);
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
			lblNewLabel_1_3.setBounds(145, 500, 20, 16);
		}
		return lblNewLabel_1_3;
	}
	private JButton getBtnSign() {
		if (btnSign == null) {
			btnSign = new JButton("회원가입");
			 btnSign.setBorderPainted(false);
			btnSign.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					SignMouseEnter();
				}
				@Override
				public void mouseExited(MouseEvent e) {
					SignMouseExit();
				}
			});
			btnSign.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Signclick();
				}
			});
			btnSign.setBounds(60, 500, 90, 20);
		}
		return btnSign;
	}
	private JButton getBtnFindid() {
		if (btnFindid == null) {
			btnFindid = new JButton("아이디 찾기");
			 btnFindid.setBorderPainted(false);
			btnFindid.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					FindidMouseEnter();
					
				}
				@Override
				public void mouseExited(MouseEvent e) {
					FindidMouseExit();
				}
			});
			btnFindid.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Findidclick();
				}
			});
			btnFindid.setBounds(165, 500, 110, 16);
		}
		return btnFindid;
	}
	private JButton getBtnFindpw() {
		if (btnFindpw == null) {
			btnFindpw = new JButton("비밀번호 찾기");
			 btnFindpw.setBorderPainted(false);
			btnFindpw.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					FindpwMouseEnter();
				}
				@Override
				public void mouseExited(MouseEvent e) {
					FindpwMouseExit();
				}
			});
			btnFindpw.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Findpwclick();
				}
			});
			btnFindpw.setBounds(285, 500, 115, 16);
		}
		return btnFindpw;
	}
	
	
	
	//---------Function---------
	
	
	public void Signclick() {
		dispose();
				Register register = new Register();			//회원가입 클릭
				register.setVisible(true);

	}
				
	public void SignMouseEnter() {
			setMouseOverEffect(btnSign);
	}
	public void SignMouseExit()	{
			resetButton(btnSign);
		
	}
	public void Findidclick() {
		FindId findId = new FindId();			  //아이디 찾기 클릭
		findId.setVisible(true);

	}
	public void FindidMouseEnter() {
			setMouseOverEffect(btnFindid);
	}
	public void FindidMouseExit() {
			resetButton(btnFindid);
		
	}
	public void Findpwclick() {
		FindPw findPw = new FindPw();				//패스워드 찾기 클릭
		findPw.setVisible(true);


	}
	public void FindpwMouseEnter() {
			setMouseOverEffect(btnFindpw);
			
	}
	public void FindpwMouseExit() {
		   resetButton(btnFindpw);
	}
	
//	// 중복되는 코드 모아주는 매소드   ************************************************
	 private void setMouseOverEffect(JButton btnSign2) {
	        btnSign2.setForeground(Color.BLACK);						//글씨 색깔
	        Font font = new Font("Arial Black", Font.ITALIC, 13);		//사용 폰트
	        btnSign2.setFont(font);									    //폰트 적용
	    }
	
	 private void resetButton(JButton btnLogin2) {
	        btnLogin2.setForeground(UIManager.getColor("TextField.foreground"));		//텍스트 색깔 되돌리기 
	        btnLogin2.setFont(null);													//폰트 초기화
	    }
//	 // 중복되는 코드 모아주는 매소드   ************************************************
	
	public void Login() {
			Share s = new Share();
			
			char[] c = tfpw.getPassword();
			String password = new String(c);
		Share.id = 	tfId.getText();
		Share.pw =  password;
		
				
		 String inputid = tfId.getText().trim();
		    String inputPw = new String(tfpw.getPassword()).trim();
		    			

		    if (inputid.isEmpty() && inputPw.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력하세요", "알림", JOptionPane.ERROR_MESSAGE);
		        return;
		    } else if (inputid.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "아이디를 입력하세요", "알림", JOptionPane.ERROR_MESSAGE);
		        return;
		    } else if (inputPw.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요", "알림", JOptionPane.ERROR_MESSAGE);
		        return;
		    }
		    	 
		    
		    	 Dao_Login dao = new Dao_Login(inputid, inputPw);
		    	 
		    	
		    	 if (dao.LoginAction()) {
//		    	        JOptionPane.showMessageDialog(null, "환영합니다.", "알림", JOptionPane.INFORMATION_MESSAGE);

		    	        // 로그인 성공 시 홈 화면으로 이동
		    	        Home home = new Home();
		    	        home.setVisible(true);

		    	        // 현재 로그인 창은 닫음
		    	        dispose();
//		    	        this.setVisible(false);
		    	    } else {
		    	        JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 올바르지 않습니다", "알림", JOptionPane.ERROR_MESSAGE);

		    	        // 로그인 실패 시 패스워드 클리어와 포커스 설정
		    	        tfpw.setText("");
		    	        tfId.setText("");
		    	        tfId.requestFocus();
		    	    }
		    	 
		
				
	}
}
