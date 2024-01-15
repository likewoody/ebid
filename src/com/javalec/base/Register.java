package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
						
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.javalec.function.Dao_Login;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GrayFilter;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
	private JComboBox cbaddress1;
	private JButton btnIdchek;
	private JButton btnnickNamechek;
	private JButton btnsignIn;
	private JCheckBox ckbagree;
	private JTextField tfPinfo;
	private JButton btnBack;
	private JTextField tfpwmatch;
	private Dao_Login daoLogin;
	private int activeid =0;
	  private int activationCount = 0; // 닉네임 중복확인 메세지 를 위한 변수
	 
	  private ArrayList<Character> passwordList;
	  private JComboBox cbaddress2;
	  private JLabel lblNewLabel_1;
	  private JTextField tfemail;

	
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
		contentPanel.add(getCbaddress1());
		contentPanel.add(getBtnIdchek());
		contentPanel.add(getBtnnickNamechek());
		contentPanel.add(getBtnsignIn());
		contentPanel.add(getCkbagree());
		contentPanel.add(getTfPinfo());
		contentPanel.add(getBtnBack());
		
		tfpwmatch = new JTextField();
		tfpwmatch.setBackground(Color.WHITE);
		tfpwmatch.setEditable(false);
		tfpwmatch.setText("비밀번호가 일치하지않습니다.");
		 tfpwmatch.setBorder(null);
		tfpwmatch.setBounds(135, 360, 260, 20);
		tfpwmatch.setForeground(Color.RED);
		contentPanel.add(tfpwmatch);
		tfpwmatch.setVisible(false);
		tfpwmatch.setColumns(10);
		contentPanel.add(getCbaddress2());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getTfemail());
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
			lblid.setBounds(52, 262, 40, 16);
		}
		return lblid;
	}
	private JLabel getLblpw() {
		if (lblpw == null) {
			lblpw = new JLabel("PW :");
			lblpw.setBounds(52, 305, 61, 16);
		}
		return lblpw;
	}
	private JLabel getLblpwRe() {
		if (lblpwRe == null) {
			lblpwRe = new JLabel("PW 재입력 :");
			lblpwRe.setBounds(52, 335, 65, 16);
		}
		return lblpwRe;
	}
	private JLabel getLblNickname() {
		if (lblNickname == null) {
			lblNickname = new JLabel("닉네임 :");
			lblNickname.setBounds(52, 394, 61, 16);
		}
		return lblNickname;
	}
	private JLabel getLblname() {
		if (lblname == null) {
			lblname = new JLabel("이름 :");
			lblname.setBounds(52, 440, 61, 16);
		}
		return lblname;
	}
	private JLabel getLblphone() {
		if (lblphone == null) {
			lblphone = new JLabel("전화번호 :");
			lblphone.setBounds(52, 480, 61, 16);
		}
		return lblphone;
	}
	private JLabel getLbladdress() {
		if (lbladdress == null) {
			lbladdress = new JLabel("주소 :");
			lbladdress.setBounds(52, 520, 61, 16);
		}
		return lbladdress;
	}
	private JTextField getTfnickname() {
		if (tfnickname == null) {
			tfnickname = new JTextField();
			tfnickname.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
								if (tfnickname.isEditable() == false  && activationCount ==1)
											idFirst();
										
				}   
			});
			tfnickname.setEditable(false);
			tfnickname.setBounds(130, 390, 200, 26);
			tfnickname.setColumns(10);
		}
		return tfnickname;
	}
	private JTextField getTfphone() {
		if (tfphone == null) {
			tfphone = new JTextField();
			tfphone.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
									if ( tfphone.isEditable() == false)
												idFirst();
									
				}
			});
			tfphone.setEditable(false);
			tfphone.setColumns(10);
			tfphone.setBounds(130, 475, 290, 26);
		}
		return tfphone;
	}
	private JTextField getTfpw() {
		if (tfpw == null) {
			tfpw = new JTextField();
			tfpw.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					 passwordList = getPasswordList(tfpw);
	                    checkPasswordMatch();
				}
			});
			tfpw.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					 passwordList = getPasswordList(tfpw);
	                    checkPasswordMatch();
				}
			});
				
		
			tfpw.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
							if ( tfpw.isEditable() == false )
									idFirst();
				}
			});
			tfpw.setEditable(false);
			tfpw.setColumns(10);
			tfpw.setBounds(130, 300, 290, 26);
		}
		return tfpw;
	}
	private JTextField getTfid() {
		if (tfid == null) {
			tfid = new JTextField();
			tfid.setColumns(10);
			tfid.setBounds(130, 257, 200, 26);
		}
		return tfid;
	}
	private JTextField getTfname() {
		if (tfname == null) {
			tfname = new JTextField();
			tfname.setColumns(10);
			tfname.setBounds(130, 437, 290, 26);
			tfname.setEditable(false);
			tfname.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
								if ( tfname.isEditable() == false) 
											idFirst();
								
				}
			});
		}
		return tfname;
	}
	private JTextField getTfpwRe() {
		if (tfpwRe == null) {
			tfpwRe = new JTextField();
			tfpwRe.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
										if ( tfpwRe.isEditable() == false) 
												idFirst();
										 
				}
			});
			tfpwRe.setEditable(false);
			tfpwRe.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					  checkPasswordMatch();
				}
			});
			tfpwRe.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					  checkPasswordMatch();
				}
			});
			
			tfpwRe.setColumns(10);
			tfpwRe.setBounds(130, 330, 290, 26);
		}
		return tfpwRe;
	}
	private JComboBox getCbaddress1() {
		if (cbaddress1 == null) {
			cbaddress1 = new JComboBox();				
			cbaddress1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 address2info();
				}
			});
			cbaddress1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
								if ( cbaddress1.isEnabled() == false)
											idFirst();
								   
				}
			});
			cbaddress1.setEnabled(false);
			cbaddress1.setModel(new DefaultComboBoxModel(new String[] {"-", "서울시", "인천시", "대전시", "대구시", "울산시", "부산시", "광주시", "세종시", "경기도", "강원도", "충청남도", "충청북도", "경상북도", "전라북도", "전라남도", "경상남도", "제주도"}));
			cbaddress1.setBounds(130, 516, 135, 27);
		}
		return cbaddress1;
	}
	private JButton getBtnIdchek() {
		if (btnIdchek == null) {
			btnIdchek = new JButton("중복확인");
			btnIdchek.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			
					  		idDoubleCheck();						  		
				}
			});
			btnIdchek.setBounds(330, 257, 80, 26);
		}
		return btnIdchek;
	}
	private JButton getBtnnickNamechek() {
		if (btnnickNamechek == null) {
			btnnickNamechek = new JButton("중복확인");
			btnnickNamechek.setEnabled(false);
			btnnickNamechek.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    	nickNameDoubleCheck();
				}
			});
			btnnickNamechek.addMouseListener(new MouseAdapter() {
				@Override  
				public void mouseClicked(MouseEvent e) {
							if ( btnnickNamechek.isEnabled() == false && activationCount == 1)
										idFirst();
				}  
			});

			btnnickNamechek.setBounds(330, 390, 80, 26);
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
				public void actionPerformed(ActionEvent e) {		//회원가입 정보를 가져오기
					if (!signError()) {
                        return;
                    }
					  RegisterAct();

                   					
				}
			});
			btnsignIn.setBounds(260, 624, 117, 29);
		}
		return btnsignIn;
	}
	private JCheckBox getCkbagree() {
		if (ckbagree == null) {
			ckbagree = new JCheckBox("");
		
			ckbagree.setEnabled(false);
		
			ckbagree.setBounds(127, 590, 30, 23);
		}
		return ckbagree;
	}
	private JTextField getTfPinfo() {
		if (tfPinfo == null) {
			tfPinfo = new JTextField();
			tfPinfo.setEnabled(false);
			tfPinfo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					tfPinfo.setForeground(Color.BLACK);						//글씨 색깔
			        Font font = new Font("Arial Black", Font.ITALIC, 13);		//사용 폰트
			        tfPinfo.setFont(font);	
				}
				@Override
				public void mouseExited(MouseEvent e) {
					 tfPinfo.setForeground(UIManager.getColor("TextField.foreground"));		//텍스트 색깔 되돌리기 
				        tfPinfo.setFont(null);
				} 
				@Override
				public void mouseClicked(MouseEvent e) {									
								if (activeid == 0) {
										idFirst();
								}
									goPinfo();
				}
			});
		
			tfPinfo.setEditable(false);
			tfPinfo.setText("(필수) 개인정보 수집에 대한 동의");
			tfPinfo.setBounds(158, 590, 220, 23);
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
	private JComboBox getCbaddress2() {
		if (cbaddress2 == null) {
			cbaddress2 = new JComboBox();
			cbaddress2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					  address2info();
				}
			});
			cbaddress2.setEnabled(false);
			cbaddress2.setModel(new DefaultComboBoxModel( new String[] {"강남구", "동작구" }));
			cbaddress2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (cbaddress2.isEnabled() == false) {
						   idFirst();				
				}
				}
			});
			cbaddress2.setBounds(280, 516, 135, 27);
				address2info();
		}
		return cbaddress2;
	}
	 	
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이메일 :");
			lblNewLabel_1.setBounds(52, 560, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfemail() {
		if (tfemail == null) {
			tfemail = new JTextField();
			tfemail.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if ( tfemail.isEditable() == false) {
								idFirst();
					}
				}
			});
			tfemail.setEditable(false);
			tfemail.setBounds(130, 555, 290, 26);
			tfemail.setColumns(10);
		}
		return tfemail;
	}

	
	//--------Function---------
	
	
	public void address2info ()  {
		
		String selectedAddress1 = (String) cbaddress1.getSelectedItem();
		DefaultComboBoxModel<String> address2Model = new DefaultComboBoxModel<>();

		if ("서울시".equals(selectedAddress1)) {
			address2Model.addElement("강남구");
			address2Model.addElement("동작구");
			address2Model.addElement("강서구");
			address2Model.addElement("강동구");
			address2Model.addElement("강북구");
		} else if ("경기도".equals(selectedAddress1)) {
			address2Model.addElement("하남시");
			address2Model.addElement("구리시");
			address2Model.addElement("성남시");
			address2Model.addElement("용인시");
			address2Model.addElement("고양시");
		}
		cbaddress2.setModel(address2Model);
	}
		
	
	 	
	
	
			// 비밀번호 확인 텍스트
	   private ArrayList<Character> getPasswordList(JTextField textField) {
	        ArrayList<Character> list = new ArrayList<>();
	        String password = textField.getText();
	        for (int i = 0; i < password.length(); i++) {
	            list.add(password.charAt(i));
	        }
	        return list;
	    }

	    private void checkPasswordMatch() {
	        if (tfpw.getText().isEmpty() || tfpwRe.getText().isEmpty()) {
	            // 하나라도 비어 있으면 메시지를 표시하지 않음
	            tfpwmatch.setVisible(false);
	            return;
	        }
	        ArrayList<Character> passwordReList = getPasswordList(tfpwRe);

	        // 비밀번호 길이가 다르면 일치하지 않음
	        if (passwordList.size() != passwordReList.size()) {
	            displayPasswordMismatch();
	            return;
	        } 

	        // 비밀번호 각 문자를 비교
	        for (int i = 0; i < passwordList.size(); i++) {
	            if (!passwordList.get(i).equals(passwordReList.get(i))) {
	                displayPasswordMismatch();
	                return;
	            }
	        }

	        // 모든 조건이 일치하면 비밀번호 일치
	        displayPasswordMatch();
	    }

	    private void displayPasswordMatch() {
	        tfpwmatch.setText("비밀번호가 일치합니다.");
	        tfpwmatch.setForeground(Color.GREEN);
	        tfpwmatch.setVisible(true);
	    }

	    private void displayPasswordMismatch() {
	        tfpwmatch.setText("비밀번호가 일치하지 않습니다.");
	        tfpwmatch.setForeground(Color.RED);
	        tfpwmatch.setVisible(true);
	    }
	    	// 회원가입 예외처리
	public boolean signError() {
					Dao_Login dao = new Dao_Login();				
									
		  if (tfid.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "ID를 입력하세요.", "알림", JOptionPane.WARNING_MESSAGE);
	            return false;
	        		
		    }  else if (activeid == 0  ) {
	            JOptionPane.showMessageDialog(this, "ID 중복확인을 수행하세요.", "알림", JOptionPane.WARNING_MESSAGE);
	            return false;
	        }
		 
		      else	if (tfpw.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요.", "알림", JOptionPane.WARNING_MESSAGE);
	            return false;
	        }
		  
		      else  if (tfpwRe.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "비밀번호 재입력을 입력하세요.", "알림", JOptionPane.WARNING_MESSAGE);
	            return false;
	        } else if (tfpw.getText().length() < 6	 || tfpw.getText().length() > 8 || !tfpw.getText().matches("^(?=.*[a-zA-Z])(?=.*[0-9]).*$")) {
	            JOptionPane.showMessageDialog(this, "비밀번호는 6~8자리의 영문과 숫자를 혼용해야 합니다.", "알림", JOptionPane.WARNING_MESSAGE);
	            return false;
		  
	        }    else if ( !tfpw.getText().equals(tfpwRe.getText())) {
		    	  JOptionPane.showMessageDialog(this, "비밀번호를 확인해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
		    	  return false;	
		    }
		  				
		      else  if (tfnickname.getText().isEmpty()) {	
	            JOptionPane.showMessageDialog(this, "닉네임을 입력하세요.", "알림", JOptionPane.WARNING_MESSAGE);
	           return false;						
	        }
		      else if ( activationCount == 1) {
			  JOptionPane.showMessageDialog(this, "닉네임 중복확인을 수행하세요.", "알림", JOptionPane.WARNING_MESSAGE);			 
			  return false;
		    }	  

		      else  if (tfname.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "이름을 입력하세요.", "알림", JOptionPane.WARNING_MESSAGE);
	            return false;
		    }
		      else if (!tfname.getText().matches("^[가-힣]{3}$")) {
			        JOptionPane.showMessageDialog(this, "이름을 다시한번 확인해 주세요.", "알림", JOptionPane.WARNING_MESSAGE);
			        return false;
			}
		      else  if (tfphone.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "전화번호를 입력하세요.", "알림", JOptionPane.WARNING_MESSAGE);
	            return false;	
	        }
		      else if (!tfphone.getText().matches("^010-[0-9]{4}-[0-9]{4}$")) {
			        JOptionPane.showMessageDialog(this, "전화번호는 (010-xxxx-xxxx) 형식으로 입력하세요.", "알림", JOptionPane.WARNING_MESSAGE);
			        return false;
		    }
		      else if (cbaddress1.getSelectedItem().equals("-")) {
		    	  JOptionPane.showMessageDialog(this, "주소를 선택해 주세요.", "알림", JOptionPane.WARNING_MESSAGE);
			        return false;
		      }
		  
		      else if ( tfemail.getText().isEmpty()) {
		    	  JOptionPane.showMessageDialog(this, "이메일을 입력해 주세요.", "알림", JOptionPane.WARNING_MESSAGE);
		    	  return false;
		      }
		      else if ( !tfemail.getText().matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$")) {
		    	  JOptionPane.showMessageDialog(this, "이메일을 정확하게 입력하여주세요.", "알림", JOptionPane.WARNING_MESSAGE);
		    	  return false;
		      }		   
		  						  
		      else if (!ckbagree.isSelected() ) {				   
	        	JOptionPane.showMessageDialog(this, "개인정보 수집에 대한 동의가 필요합니다.", "알림", JOptionPane.WARNING_MESSAGE);
	        	return false;
           }
		  return true;
		  			
	        }
					
							
	// 아이디 중복확인
	public void idDoubleCheck() {
		 String userId = tfid.getText().trim();
		 Dao_Login daoLogin = new Dao_Login(userId);
		 			if ( userId.isEmpty()) {
		 				JOptionPane.showMessageDialog(this, "ID를 입력해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
		 				return;
		 			}
		 			
		 			
		 	
		 			if (daoLogin.Idcheck())  {
		        JOptionPane.showMessageDialog(this, "사용 가능한 ID입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
		    	// 다른 회원가입 항목 활성화
		 			tfpw.setEditable(true);
		 			tfname.setEditable(true);
		 			tfnickname.setEditable(true);
		 			tfphone.setEditable(true);		 		
		 			tfpwRe.setEditable(true);
		 			ckbagree.setEnabled(true);
		 			btnnickNamechek.setEnabled(true);
		 			cbaddress1.setEnabled(true);
		 			cbaddress2.setEnabled(true);
		 			tfPinfo.setEnabled(true);
		 			tfemail.setEditable(true);
		 			tfid.setEditable(false);
		 			tfid.setEnabled(false);
		 			btnIdchek.setEnabled(false);
		 				
		 					
		 			activeid++;						//중복체크용
		 			activationCount++;				//중복체크용
		 			
		 			return;
		 		
		 			  
				}
		 			else 
		 				
		        JOptionPane.showMessageDialog(this, "이미 사용 중인 ID입니다. 다른 ID를 입력하세요.", "알림", JOptionPane.WARNING_MESSAGE);
		 					return;
		 	
	}
	//닉네임 중복 확인								
	public void nickNameDoubleCheck() {

 String userNickname = tfnickname.getText().trim();
 Dao_Login daoLogin = new Dao_Login(userNickname);	
 										
 													
	if (userNickname.isEmpty()) {	
		JOptionPane.showMessageDialog(this, "닉네임을 입력해주세요.", "알림", JOptionPane.ERROR_MESSAGE);
	//	tfnickname.setEditable(true);
		
		return;
	}
	if (daoLogin.nickNameCheck(userNickname) == false) {
		JOptionPane.showMessageDialog(this, "이미 사용 중인 닉네임 입니다. 다른 닉네임을 입력하세요.", "알림",
				JOptionPane.ERROR_MESSAGE);
	//	tfnickname.setEditable(true);		
		return;
	}				
	else 
		JOptionPane.showMessageDialog(this, "사용 가능한 닉네임 입니다.", "알림", JOptionPane.ERROR_MESSAGE);
	btnnickNamechek.setEnabled(false);
	tfnickname.setEditable(false);
	activationCount = 2;
	return;
				
} 
		//약관페이지 이동
	public void goPinfo() {		
	ArticlePage art = new ArticlePage();
			if ( tfPinfo.isEnabled() == true)
			art.setVisible(true);
				
	}
							// 아이디를 먼저하지 않았을 경우
		public void idFirst() {
					JOptionPane.showMessageDialog(null, "아이디 중복체크를 먼저 해 주세요.");
						
			
		}
								
	
	// 로그인 화면으로 돌아가기
	public void goBack () {
		int back = JOptionPane.showConfirmDialog(null, "로그인 화면으로 돌아가시갰습니까?", "알림", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (back == JOptionPane.YES_OPTION) {
			String userid = tfid.getText();
		Dao_Login dao = new Dao_Login();		
		  dao.idDelete(userid);
		Login login = new Login();
		login.setVisible(true);
		
		
		dispose();
		}
											
													
											
	}			//회원가입 기능
	public void RegisterAct() {
		String userid = tfid.getText().trim();
        String pw = tfpw.getText().trim();  	                
        String nickname = tfnickname.getText().trim();	                   
        String phone = tfphone.getText().trim();
        String add1 = (String) cbaddress1.getSelectedItem();
        String add2 = (String) cbaddress2.getSelectedItem();
        String address = add1.trim().concat(add2.trim());
        String email = tfemail.getText().trim();
        
        
    // 회원가입 처리
    Dao_Login dao = new Dao_Login(userid, pw, phone, email, nickname, address );
    // 사용자 등록 수행
    dao.signUpdate();

    // 사용자에게 성공적으로 등록되었음을 알림
    JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
   dispose();
	}


	}
	
	
