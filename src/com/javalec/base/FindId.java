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

public class FindId extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel fIdBackground;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField tfname;
	private JTextField tfphone;
	private JButton btnFindid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindId dialog = new FindId();
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
	public FindId() {
		setFont(new Font("Lucida Grande", Font.BOLD, 27));
		setTitle("아이디 찾기");
		setBounds(100, 100, 430, 732);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getTfname());
		getContentPane().add(getTfphone());
		getContentPane().add(getBtnFindid());
		
		JButton btncancel = new JButton("취소");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						cancelclick();
			}
		});
		btncancel.setBounds(250, 567, 119, 29);
		getContentPane().add(btncancel);
		getContentPane().add(getFIdBackground());
		btncancel.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		int red = 0xD6;
        int green = 0xCB;											//기준색 D6CBD8 에 대한 값
        int blue = 0xD8;

        Color BackColor = new Color(red, green, blue);				//색깔 적용	   
        btncancel.setBackground(BackColor);
        btncancel.setOpaque(true);

	}
	private JLabel getFIdBackground() {
		if (fIdBackground == null) {
			fIdBackground = new JLabel("");
			fIdBackground.setBounds(0, 0, 430, 704);
			fIdBackground.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/logindetailBackground.png")));
		}
		return fIdBackground;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("아이디 찾기");
			lblNewLabel.setForeground(new Color(214, 203, 216));
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(175, 165, 80, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("닉네임");
			lblNewLabel_1.setBounds(60, 275, 45, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("전화번호");
			lblNewLabel_2.setBounds(60, 340, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JTextField getTfname() {
		if (tfname == null) {
			tfname = new JTextField();
			tfname.setBounds(120, 270, 250, 26);
			tfname.setColumns(10);
		}
		return tfname;
	}
	private JTextField getTfphone() {
		if (tfphone == null) {
			tfphone = new JTextField();
			tfphone.setBounds(120, 337, 250, 26);
			tfphone.setColumns(10);
		}
		return tfphone;
	}
	private JButton getBtnFindid() {
		if (btnFindid == null) {
			btnFindid = new JButton("아이디 찾기");
			btnFindid.setBorder(new LineBorder(new Color(214, 203, 216), 2));
			int red = 0xD6;
	        int green = 0xCB;											//기준색 D6CBD8 에 대한 값
	        int blue = 0xD8;

	        Color BackColor = new Color(red, green, blue);				//색깔 적용	   
	        btnFindid.setBackground(BackColor);
	        btnFindid.setOpaque(true);
			btnFindid.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
								 idsearch();
				}
			});
			btnFindid.setBounds(80, 567, 117, 29);
		}
		return btnFindid;
	}
	
	
	
	
	
	
	
	
	//------------Function--------------
	
	public void idsearch() {
		
		String name = tfname.getText().trim();
		String phone = tfphone.getText().trim();
		
		 if (name.isEmpty() && phone.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "닉네임과 전화번호를 작성해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
		        return;
		    }

		 com.javalec.function.Dao_Login dao = new com.javalec.function.Dao_Login();
		 dao.setNickname(name);
		 dao.setPhone(phone);

		    
		    if (!name.isEmpty() && phone.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "전화번호를 작성해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
		        return;
		    }

		    if (name.isEmpty() && !phone.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "닉네임을 작성해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
		        return;
		    }

		
		    if (dao.findId()) {
		        String foundUserId = dao.getUserid();
		        // 아이디를 알려주는 메시지 창에 닫기 버튼 추가
		        Object[] options = {"닫기"};
		        int choice = JOptionPane.showOptionDialog(null,"아이디는 " + foundUserId + " 입니다.", "아이디 찾기 결과",
		            JOptionPane.DEFAULT_OPTION,
		            JOptionPane.INFORMATION_MESSAGE,
		            null,
		            options,
		            options[0]
		        );

		        if (choice == 0) {
		        
		            dispose();
		    } else {
		        JOptionPane.showMessageDialog(null, "일치하는 정보가 없습니다. 다시 입력해 주새요.", "알림", JOptionPane.ERROR_MESSAGE);
		    }
		}
	}
	
	
	public void cancelclick() {
		int cancel = JOptionPane.showConfirmDialog(null, "아이디 찾기를 취소 하시겠습니까?", "알림", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
		if (cancel == JOptionPane.YES_OPTION) {
		dispose();
			
			
		}
	}
}
