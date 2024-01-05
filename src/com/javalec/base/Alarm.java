package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;

public class Alarm {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JButton btnHome;
	private JButton btnMypage;
	private JButton btnAlarm;
	private JButton btnChat;
	private JButton btnRight;
	private JTextField tfSellBuyAlarm;
	private JTextField tfBidAlarm;
	private JTextField tfKeyAlarm;
	private JButton btnNewButton;
	private JCheckBox cb1;
	private JCheckBox cb2;
	private JCheckBox cb3;
	private JCheckBox cb4;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alarm window = new Alarm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Alarm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
							tableInit();
			}
		});
		frame.setFont(new Font("Dialog", Font.BOLD, 27));
		frame.setTitle("알림창");
		frame.setBounds(100, 100, 430, 732);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getBtnHome());
		frame.getContentPane().add(getBtnMypage());
		frame.getContentPane().add(getBtnAlarm());
		frame.getContentPane().add(getBtnChat());
		frame.getContentPane().add(getBtnRight());
		frame.getContentPane().add(getTfSellBuyAlarm());
		frame.getContentPane().add(getTfBidAlarm());
		frame.getContentPane().add(getTfKeyAlarm());
		frame.getContentPane().add(getCb1());
		frame.getContentPane().add(getCb2());
		frame.getContentPane().add(getCb3());
		frame.getContentPane().add(getCb4());
		frame.getContentPane().add(getTf1());
		frame.getContentPane().add(getTf2());
		frame.getContentPane().add(getTf3());
		frame.getContentPane().add(getTf4());
		frame.getContentPane().add(getLblNewLabel());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(0, 0, 430, 704);
			lblNewLabel.setIcon(new ImageIcon(Alarm.class.getResource("/com/javalec/images/mainFrame.png")));
			
		}
		return lblNewLabel;
	}
	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("홈");
			btnHome.setBounds(20, 55, 70, 34);
		}
		return btnHome;
	}
	private JButton getBtnMypage() {
		if (btnMypage == null) {
			btnMypage = new JButton("개인");
			btnMypage.setBounds(100, 55, 70, 34);
		}
		return btnMypage;
	}
	private JButton getBtnAlarm() {
		if (btnAlarm == null) {
			btnAlarm = new JButton("알림");
//			btnAlarm.setBackground(new Color(247, 226, 254));
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
	private JButton getBtnRight() {
		if (btnRight == null) {
			btnRight = new JButton("글쓰기");
			btnRight.setBounds(340, 55, 70, 34);
		}
		return btnRight;
	}
	private JTextField getTfSellBuyAlarm() {
		if (tfSellBuyAlarm == null) {
			tfSellBuyAlarm = new JTextField();
			tfSellBuyAlarm.setEditable(false);
			tfSellBuyAlarm.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
							sbAlarmClick();
				}
			});
			tfSellBuyAlarm.setText("판매/구매 알림");
			tfSellBuyAlarm.setBackground(Color.LIGHT_GRAY);
			tfSellBuyAlarm.setBounds(40, 120, 90, 55);
			tfSellBuyAlarm.setColumns(10);
		}
		return tfSellBuyAlarm;
	}
	private JTextField getTfBidAlarm() {
		if (tfBidAlarm == null) {
			tfBidAlarm = new JTextField();
			tfBidAlarm.setEditable(false);
			tfBidAlarm.setText("    경매 알림");
			tfBidAlarm.setColumns(10);
			tfBidAlarm.setBackground(Color.LIGHT_GRAY);
			tfBidAlarm.setBounds(170, 120, 90, 55);
		}
		return tfBidAlarm;
	}
	private JTextField getTfKeyAlarm() {
		if (tfKeyAlarm == null) {
			tfKeyAlarm = new JTextField();
			tfKeyAlarm.setEditable(false);
			tfKeyAlarm.setText("  키워드 알림");
			tfKeyAlarm.setColumns(10);
			tfKeyAlarm.setBackground(Color.LIGHT_GRAY);
			tfKeyAlarm.setBounds(300, 120, 90, 55);
		}
		return tfKeyAlarm;
	}
		
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("삭제");
			btnNewButton.setBounds(161, 649, 100, 34);
			Color buttonColor = Color.decode("#D6CBD8");
            btnNewButton.setBackground(buttonColor);
            btnNewButton.setOpaque(true);
		}
		return btnNewButton;
	}
	private JCheckBox getCb1() {
		if (cb1 == null) {
			cb1 = new JCheckBox("");
			cb1.setBounds(6, 250, 28, 23);
		}
		return cb1;
	}
	private JCheckBox getCb2() {
		if (cb2 == null) {
			cb2 = new JCheckBox("");
			cb2.setBounds(6, 350, 28, 23);
		}
		return cb2;
	}
	private JCheckBox getCb3() {
		if (cb3 == null) {
			cb3 = new JCheckBox("");
			cb3.setBounds(6, 450, 28, 23);
		}
		return cb3;
	}
	private JCheckBox getCb4() {
		if (cb4 == null) {
			cb4 = new JCheckBox("");
			cb4.setBounds(6, 550, 28, 23);
		}
		return cb4;
	}
	private JTextField getTf1() {
		if (tf1 == null) {
			tf1 = new JTextField();
			tf1.setEditable(false);
			tf1.setBounds(40, 210, 350, 70);
			tf1.setColumns(10);
		}
		return tf1;
	}
	private JTextField getTf2() {
		if (tf2 == null) {
			tf2 = new JTextField();
			tf2.setEditable(false);
			tf2.setColumns(10);
			tf2.setBounds(40, 310, 350, 70);
		}
		return tf2;
	}
	private JTextField getTf3() {
		if (tf3 == null) {
			tf3 = new JTextField();
			tf3.setEditable(false);
			tf3.setColumns(10);
			tf3.setBounds(40, 410, 350, 70);
		}
		return tf3;
	}
	private JTextField getTf4() {
		if (tf4 == null) {
			tf4 = new JTextField();
			tf4.setEditable(false);
			tf4.setColumns(10);
			tf4.setBounds(40, 510, 350, 70);
		}
		return tf4;
	}
	
	
	
	//---------------Function---------------
	
	
		public void tableInit() {
			
			
			
		}
		
		
		
		
		
		
		public void sbAlarmClick() {
			
			
		}
		
	
	
	
}
