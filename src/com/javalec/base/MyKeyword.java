package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class MyKeyword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnHome;
	private JButton btnMy;
	private JButton btnAlarm;
	private JButton btnChat;
	private JButton btnWrite;
	private JButton btnBack;
	private JTextField tfkeyword1;
	private JCheckBox cbKeyword1;
	private JCheckBox cbKeyword2;
	private JTextField tfkeyword2;
	private JCheckBox cbKeyword3;
	private JTextField tfkeyword3;
	private JCheckBox cbKeyword4;
	private JTextField tfkeyword4;
	private JCheckBox cbKeyword5;
	private JTextField tfkeyword5;
	private JButton btnDelete;
	private JButton btnEdit;
	private JLabel lblImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyKeyword frame = new MyKeyword();
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
	public MyKeyword() {
		setBounds(100, 100, 430, 732);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnHome());
		getContentPane().add(getBtnMy());
		getContentPane().add(getBtnAlarm());
		getContentPane().add(getBtnChat());
		getContentPane().add(getBtnWrite());
		getContentPane().add(getBtnBack());
		getContentPane().add(getTfkeyword1());
		getContentPane().add(getCbKeyword1());
		getContentPane().add(getCbKeyword2());
		getContentPane().add(getTfkeyword2());
		getContentPane().add(getCbKeyword3());
		getContentPane().add(getTfkeyword3());
		getContentPane().add(getCbKeyword4());
		getContentPane().add(getTfkeyword4());
		getContentPane().add(getCbKeyword5());
		getContentPane().add(getTfkeyword5());
		getContentPane().add(getBtnDelete());
		getContentPane().add(getBtnEdit());
		getContentPane().add(getLblImage());

	}
	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("홈");
			btnHome.setBounds(20, 55, 70, 34);
		}
		return btnHome;
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
	private JButton getBtnWrite() {
		if (btnWrite == null) {
			btnWrite = new JButton("글쓰기");
			btnWrite.setBounds(340, 55, 70, 34);
		}
		return btnWrite;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("뒤로가기");
			btnBack.setBounds(150, 650, 117, 29);
		}
		return btnBack;
	}
	private JTextField getTfkeyword1() {
		if (tfkeyword1 == null) {
			tfkeyword1 = new JTextField();
			tfkeyword1.setBounds(68, 130, 342, 40);
			tfkeyword1.setColumns(10);
		}
		return tfkeyword1;
	}
	private JCheckBox getCbKeyword1() {
		if (cbKeyword1 == null) {
			cbKeyword1 = new JCheckBox("");
			cbKeyword1.setBounds(20, 130, 30, 40);
		}
		return cbKeyword1;
	}
	private JCheckBox getCbKeyword2() {
		if (cbKeyword2 == null) {
			cbKeyword2 = new JCheckBox("");
			cbKeyword2.setBounds(20, 200, 30, 40);
		}
		return cbKeyword2;
	}
	private JTextField getTfkeyword2() {
		if (tfkeyword2 == null) {
			tfkeyword2 = new JTextField();
			tfkeyword2.setColumns(10);
			tfkeyword2.setBounds(68, 200, 342, 40);
		}
		return tfkeyword2;
	}
	private JCheckBox getCbKeyword3() {
		if (cbKeyword3 == null) {
			cbKeyword3 = new JCheckBox("");
			cbKeyword3.setBounds(20, 270, 30, 40);
		}
		return cbKeyword3;
	}
	private JTextField getTfkeyword3() {
		if (tfkeyword3 == null) {
			tfkeyword3 = new JTextField();
			tfkeyword3.setColumns(10);
			tfkeyword3.setBounds(68, 270, 342, 40);
		}
		return tfkeyword3;
	}
	private JCheckBox getCbKeyword4() {
		if (cbKeyword4 == null) {
			cbKeyword4 = new JCheckBox("");
			cbKeyword4.setBounds(20, 340, 30, 40);
		}
		return cbKeyword4;
	}
	private JTextField getTfkeyword4() {
		if (tfkeyword4 == null) {
			tfkeyword4 = new JTextField();
			tfkeyword4.setColumns(10);
			tfkeyword4.setBounds(68, 340, 342, 40);
		}
		return tfkeyword4;
	}
	private JCheckBox getCbKeyword5() {
		if (cbKeyword5 == null) {
			cbKeyword5 = new JCheckBox("");
			cbKeyword5.setBounds(20, 410, 30, 40);
		}
		return cbKeyword5;
	}
	private JTextField getTfkeyword5() {
		if (tfkeyword5 == null) {
			tfkeyword5 = new JTextField();
			tfkeyword5.setColumns(10);
			tfkeyword5.setBounds(68, 410, 342, 40);
		}
		return tfkeyword5;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제하기");
			btnDelete.setBounds(80, 520, 117, 29);
		}
		return btnDelete;
	}
	private JButton getBtnEdit() {
		if (btnEdit == null) {
			btnEdit = new JButton("수정하기");
			btnEdit.setBounds(220, 520, 117, 29);
		}
		return btnEdit;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon(MyKeyword.class.getResource("/com/javalec/images/mainFrame.png")));
			lblImage.setBounds(0, 0, 430, 704);
		}
		return lblImage;
	}
}
