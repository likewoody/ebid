package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.javalec.function.*;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;

public class MyPageEdit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnHome;
	private JButton btnWrite;
	private JButton btnMy;
	private JButton btnAlarm;
	private JButton btnChat;
	private JButton btnBack;
	private JLabel lblUserImage;
	private JLabel lblUserNick;
	private JButton btnEditImage;
	private JTextField tfNick;
	private JLabel lblId;
	private JTextField tfId;
	private JLabel lblUserNick_3;
	private JTextField tfPw;
	private JLabel lblUserNick_4;
	private JTextField tfEmail;
	private JLabel lblUserNick_5;
	private JComboBox cbAddress1;
	private JComboBox cbAddress2;
	private JTextField tfEditPw;
	private JLabel lblUserNick_3_1;
	private JButton btnEditNick;
	private JButton btnEditPw;
	private JButton btnEditEmail;
	private JButton btnEditAddress;
	private JLabel lblUserNick_4_1;
	private JTextField tfPhone;

	public final String url_mysql = Share.dbName;
	public final String id_mysql = Share.dbUser;
	public final String pw_mysql = Share.dbPass;
	private JLabel lblPw;
	private JButton btnEditNick_1;
	private JTextField tfprintadd;
	private JLabel lblImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPageEdit frame = new MyPageEdit();
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
	public MyPageEdit() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				insertInfo();
			}
		});
		setTitle("내 정보 수정");
		setBounds(100, 100, 430, 732);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnHome());
		getContentPane().add(getBtnWrite());
		getContentPane().add(getBtnMy());
		getContentPane().add(getBtnAlarm());
		getContentPane().add(getBtnChat());
		getContentPane().add(getBtnBack());
		getContentPane().add(getLblUserImage());
		getContentPane().add(getLblUserNick());
		getContentPane().add(getTfNick());
		getContentPane().add(getBtnEditImage());
		getContentPane().add(getLblId());
		getContentPane().add(getTfId());
		getContentPane().add(getLblUserNick_3());
		getContentPane().add(getTfPw());
		getContentPane().add(getLblUserNick_4());
		getContentPane().add(getTfEmail());
		getContentPane().add(getLblUserNick_5());
		getContentPane().add(getCbAddress1());
		getContentPane().add(getCbAddress2());
		getContentPane().add(getTextField_5_1());
		getContentPane().add(getLblUserNick_3_1());
		getContentPane().add(getBtnEditNick());
		getContentPane().add(getBtnEditPw());
		getContentPane().add(getBtnEditEmail());
		getContentPane().add(getBtnEditAddress());
		getContentPane().add(getLblUserNick_4_1());
		getContentPane().add(getTfPhone());
		getContentPane().add(getLblPw());
		getContentPane().add(getBtnEditNick_1());
		getContentPane().add(getTfprintadd());
		getContentPane().add(getLblImage_1());

	}

	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("홈");
			btnHome.setBounds(20, 55, 70, 34);
		}
		return btnHome;
	}

	private JButton getBtnWrite() {
		if (btnWrite == null) {
			btnWrite = new JButton("글쓰기");
			btnWrite.setBounds(340, 55, 70, 34);
		}
		return btnWrite;
	}

	private JButton getBtnMy() {
		if (btnMy == null) {
			btnMy = new JButton("개인");
			btnMy.setBounds(100, 55, 70, 34);
		}
		return btnMy;
	}

	private JButton getBtnAlarm() {
		if (btnAlarm == null) {
			btnAlarm = new JButton("알림");
			btnAlarm.setBounds(180, 55, 70, 34);
		}
		return btnAlarm;
	}

	private JButton getBtnChat() {
		if (btnChat == null) {
			btnChat = new JButton("채팅");
			btnChat.setBounds(260, 55, 70, 34);
		}
		return btnChat;
	}

	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("뒤로가기");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					MyPage mp = new MyPage();
					mp.setVisible(true);
				}
			});
			btnBack.setBounds(150, 650, 117, 29);
		}
		return btnBack;
	}

	private JLabel getLblUserImage() {
		if (lblUserImage == null) {
			lblUserImage = new JLabel("유저 이미지");
			lblUserImage.setBackground(Color.WHITE);
			lblUserImage.setBounds(163, 120, 100, 100);
		}
		return lblUserImage;
	}

	private JLabel getLblUserNick() {
		if (lblUserNick == null) {
			lblUserNick = new JLabel("닉네임 : ");
			lblUserNick.setBounds(42, 300, 61, 16);
		}
		return lblUserNick;
	}

	private JButton getBtnEditImage() {
		if (btnEditImage == null) {
			btnEditImage = new JButton("사진수정");
			btnEditImage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					editImage();
				}
			});
			btnEditImage.setBounds(267, 190, 88, 29);
		}
		return btnEditImage;
	}

	private JTextField getTfNick() {
		if (tfNick == null) {
			tfNick = new JTextField();
			tfNick.setBounds(115, 300, 200, 30);
			tfNick.setColumns(10);
		}
		return tfNick;
	}

	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID : ");
			lblId.setBounds(42, 250, 61, 16);
		}
		return lblId;
	}

	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setEditable(false);
			tfId.setColumns(10);
			tfId.setBounds(115, 250, 200, 30);
		}
		return tfId;
	}

	private JLabel getLblUserNick_3() {
		if (lblUserNick_3 == null) {
			lblUserNick_3 = new JLabel("현재 PW : ");
			lblUserNick_3.setBounds(42, 350, 61, 16);
		}
		return lblUserNick_3;
	}

	private JTextField getTfPw() {
		if (tfPw == null) {
			tfPw = new JTextField();
			tfPw.setColumns(10);
			tfPw.setBounds(115, 350, 200, 30);
		}
		return tfPw;
	}

	private JLabel getLblUserNick_4() {
		if (lblUserNick_4 == null) {
			lblUserNick_4 = new JLabel("이메일 : ");
			lblUserNick_4.setBounds(42, 500, 61, 16);
		}
		return lblUserNick_4;
	}

	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBounds(115, 500, 200, 30);
		}
		return tfEmail;
	}

	private JLabel getLblUserNick_5() {
		if (lblUserNick_5 == null) {
			lblUserNick_5 = new JLabel("주소 : ");
			lblUserNick_5.setBounds(42, 570, 61, 16);
		}
		return lblUserNick_5;
	}

	private JComboBox getCbAddress1() {
		if (cbAddress1 == null) {
			cbAddress1 = new JComboBox();
			cbAddress1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updatecbAddress2();
				}
			});
			cbAddress1.setModel(new DefaultComboBoxModel(new String[] {"-", "서울시", "경기도"}));

			cbAddress1.setBounds(115, 580, 100, 30);
		}
		return cbAddress1;
	}

	private JComboBox getCbAddress2() {
		if (cbAddress2 == null) {
			cbAddress2 = new JComboBox();
			cbAddress2.setModel(new DefaultComboBoxModel(new String[] { "강남구", "동작구" }));
			cbAddress2.setBounds(220, 580, 100, 30);
			updatecbAddress2();
		}
		return cbAddress2;
	}

	private JTextField getTextField_5_1() {
		if (tfEditPw == null) {
			tfEditPw = new JTextField();
			tfEditPw.setEditable(false);
			tfEditPw.setColumns(10);
			tfEditPw.setBounds(115, 400, 200, 30);
		}
		return tfEditPw;
	}

	private JLabel getLblUserNick_3_1() {
		if (lblUserNick_3_1 == null) {
			lblUserNick_3_1 = new JLabel("바꿀 PW : ");
			lblUserNick_3_1.setBounds(42, 400, 80, 16);
		}
		return lblUserNick_3_1;
	}

	private JButton getBtnEditNick() {
		if (btnEditNick == null) {
			btnEditNick = new JButton("수정");
			btnEditNick.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateNick();
				}
			});
			btnEditNick.setBounds(324, 300, 100, 30);
		}
		return btnEditNick;
	}

	private JButton getBtnEditPw() {
		if (btnEditPw == null) {
			btnEditPw = new JButton("수정");
			btnEditPw.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updatePw();
				}
			});
			btnEditPw.setBounds(324, 400, 100, 30);
		}
		return btnEditPw;
	}

	private JButton getBtnEditEmail() {
		if (btnEditEmail == null) {
			btnEditEmail = new JButton("수정");
			btnEditEmail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateEmail();
				}
			});
			btnEditEmail.setBounds(324, 500, 100, 30);
		}
		return btnEditEmail;
	}

	private JButton getBtnEditAddress() {
		if (btnEditAddress == null) {
			btnEditAddress = new JButton("수정");
			btnEditAddress.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateAddress();
				}
			});
			btnEditAddress.setBounds(324, 580, 100, 30);
		}
		return btnEditAddress;
	}

	private JLabel getLblUserNick_4_1() {
		if (lblUserNick_4_1 == null) {
			lblUserNick_4_1 = new JLabel("전화번호 : ");
			lblUserNick_4_1.setBounds(42, 450, 61, 16);
		}
		return lblUserNick_4_1;
	}

	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setEditable(false);
			tfPhone.setColumns(10);
			tfPhone.setBounds(115, 450, 200, 30);
		}
		return tfPhone;
	}

	private JLabel getLblPw() {
		if (lblPw == null) {
			lblPw = new JLabel("현재 비밀번호와 틀립니다.");
			lblPw.setBounds(120, 381, 190, 16);
		}
		return lblPw;
	}

	private JButton getBtnEditNick_1() {
		if (btnEditNick_1 == null) {
			btnEditNick_1 = new JButton("확인");
			btnEditNick_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comparePw();
				}
			});
			btnEditNick_1.setBounds(324, 350, 100, 30);
		}
		return btnEditNick_1;
	}

	private JTextField getTfprintadd() {
		if (tfprintadd == null) {
			tfprintadd = new JTextField();
			tfprintadd.setEditable(false);
			tfprintadd.setColumns(10);
			tfprintadd.setBounds(115, 550, 200, 30);
		}
		return tfprintadd;
	}

	private JLabel getLblImage_1() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon(MyPageEdit.class.getResource("/com/javalec/images/mainFrame.png")));
			lblImage.setBounds(0, 0, 430, 704);
		}
		return lblImage;
	}
	// -------------- function

	private void insertInfo() {
		Dao_MyPage dao = new Dao_MyPage();
		Dto_MyPage dto = dao.insertInfo();

		tfId.setText(dto.getUserid());
		tfNick.setText(dto.getNickname());
		tfPhone.setText(dto.getPhone());
		tfEmail.setText(dto.getEmail());
		tfprintadd.setText(dto.getAddress().substring(0, 3) + " " + dto.getAddress().substring(3));

		String filePath = Integer.toString(Share.filename);
		// 파일이 존재하는지 확인
		File file = new File(filePath);
		lblUserImage.setIcon(new ImageIcon(filePath));
		lblUserImage.setHorizontalAlignment(SwingConstants.CENTER);
	}

	private void updateNick() {
		Dao_MyPage dao = new Dao_MyPage();
		dao.updateNick(tfNick.getText());
		JOptionPane.showMessageDialog(null, "닉네임이 수정되었습니다.");
		insertInfo();
	}

	private void updateEmail() {
		Dao_MyPage dao = new Dao_MyPage();
		dao.updateEmail(tfEmail.getText());
		JOptionPane.showMessageDialog(null, "이메일이 수정되었습니다.");
		insertInfo();
	}

	private void comparePw() {
		if (tfPw.getText().equals(Share.pw)) {
			tfEditPw.setEditable(true);
			lblPw.setText("");
		} else {
			tfEditPw.setEditable(false);
			lblPw.setText("현재 비밀번호와 틀립니다.");
		}
	}

	private void updatePw() {
		Dao_MyPage dao = new Dao_MyPage();
		dao.updatePw(tfEditPw.getText());
		JOptionPane.showMessageDialog(null, "비밀번호가 수정되었습니다.");
		tfPw.setText("");
		tfEditPw.setText("");
		insertInfo();
		tfEditPw.setEditable(false);
	}

	private void editImage() {

	}

	private void updatecbAddress2() {
		String selectedAddress1 = (String) cbAddress1.getSelectedItem();
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

		cbAddress2.setModel(address2Model);
	}

	private void updateAddress() {
		Dao_MyPage dao = new Dao_MyPage();
		String add1 = (String) cbAddress1.getSelectedItem();
		String add2 = (String) cbAddress2.getSelectedItem();
		String address = add1.trim().concat(add2.trim());
		dao.updateAddress(address);
		JOptionPane.showMessageDialog(null, "주소가 수정되었습니다.");
	}

}// End
