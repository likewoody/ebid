package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindPw extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel fPwBackground;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JTextField tfid;
	private JTextField tfname;
	private JTextField tfphone;
	private JButton btnSearchpw;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindPw dialog = new FindPw();
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
	public FindPw() {
		setFont(new Font("Lucida Grande", Font.BOLD, 27));
		setTitle("비밀번호 찾기");
		setBounds(100, 100, 430, 732);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getTfid());
		getContentPane().add(getTfname());
		getContentPane().add(getTfphone());
		getContentPane().add(getBtnSearchpw());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getFPwBackground());

	}

	private JLabel getFPwBackground() {
		if (fPwBackground == null) {
			fPwBackground = new JLabel("");
			fPwBackground.setBounds(0, 0, 430, 704);
			fPwBackground.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/logindetailBackground.png")));
		}
		return fPwBackground;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("비밀번호 찾기");
			lblNewLabel.setForeground(new Color(214, 203, 216));
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(165, 165, 90, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("아이디 :");
			lblNewLabel_1.setBounds(60, 275, 60, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("닉네임 :");
			lblNewLabel_2.setBounds(60, 323, 60, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("전화번호 :");
			lblNewLabel_4.setBounds(60, 374, 61, 16);
		}
		return lblNewLabel_4;
	}
	private JTextField getTfid() {
		if (tfid == null) {
			tfid = new JTextField();
			tfid.setBounds(125, 270, 130, 26);
			tfid.setColumns(10);
		}
		return tfid;
	}
	private JTextField getTfname() {
		if (tfname == null) {
			tfname = new JTextField();
			tfname.setBounds(125, 318, 90, 26);
			tfname.setColumns(10);
		}
		return tfname;
	}
	private JTextField getTfphone() {
		if (tfphone == null) {
			tfphone = new JTextField();
			tfphone.setBounds(125, 369, 183, 26);
			
			tfphone.setColumns(10);
		}
		return tfphone;
	}
	private JButton getBtnSearchpw() {
		if (btnSearchpw == null) {
			btnSearchpw = new JButton("비밀번호 찾기");
			btnSearchpw.setBorder(new LineBorder(new Color(214, 203, 216), 2));
			int red = 0xD6;
	        int green = 0xCB;											//기준색 D6CBD8 에 대한 값
	        int blue = 0xD8;

	        Color BackColor = new Color(red, green, blue);				//색깔 적용	   
	        btnSearchpw.setBackground(BackColor);
	        btnSearchpw.setOpaque(true);
			btnSearchpw.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
										searchPw();
				}
			});
			btnSearchpw.setBounds(80, 570, 117, 29);
		}
		return btnSearchpw;
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("취소");
			btnNewButton.setBorder(new LineBorder(new Color(214, 203, 216), 2));
			int red = 0xD6;
	        int green = 0xCB;											//기준색 D6CBD8 에 대한 값
	        int blue = 0xD8;

	        Color BackColor = new Color(red, green, blue);				//색깔 적용	   
	        btnNewButton.setBackground(BackColor);
	        btnNewButton.setOpaque(true);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
									cancelclick();
				}
			});
			btnNewButton.setBounds(250, 570, 117, 29);
		}
		return btnNewButton;
	}
	
	
	
	
	//--------Function--------
	
	
	public void searchPw() {
		 String id = tfid.getText().trim();
	        String name = tfname.getText().trim();
	        String phone = tfphone.getText().trim();

	        if (id.isEmpty() || name.isEmpty() || phone.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "아이디, 이름, 전화번호를 모두 입력해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
	            return;
	        }

	        com.javalec.function.Dao_Login dao = new com.javalec.function.Dao_Login(id);
	        dao.setNickname(name);
	        dao.setPhone(phone);

	        if (dao.findPw()) {
	            // 비밀번호를 찾았을 경우
	            String foundPw = dao.getPw();
	            // 비밀번호를 알려주는 메시지 창에 닫기 버튼 추가
	            Object[] options = { "닫기" };
	            int choice = JOptionPane.showOptionDialog(null, "비밀번호는 " + foundPw + " 입니다.", "비밀번호 찾기 결과",
	                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

	            if (choice == 0) {
	                dispose();
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "일치하는 정보가 없습니다. 다시 입력해 주세요.", "알림", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	public void cancelclick() {
		int cancel = JOptionPane.showConfirmDialog(null, "비밀번호 찾기를 취소 하시겠습니까?", "알림", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
		if (cancel == JOptionPane.YES_OPTION) {
		dispose();
			
			
		}
	}
}
	
	
	
	

