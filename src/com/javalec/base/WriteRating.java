package com.javalec.base;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;

import com.javalec.function.Dao_Chat;
import com.javalec.function.Share;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WriteRating extends JDialog {

	private static final long serialVersionUID = 1L;
	private JButton btnOk;
	private JButton btnCancel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lbEmpty1;
	private JLabel lbEmpty2;
	private JLabel lbEmpty3;
	private JLabel lbEmpty4;
	private JLabel lbEmpty5;
	private boolean startCheck1;
	private boolean startCheck2;
	private boolean startCheck3;
	private boolean startCheck4;
	private boolean startCheck5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WriteRating dialog = new WriteRating();
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
	public WriteRating() {
		getContentPane().setBackground(new Color(254, 255, 255));
		setFont(new Font("Lucida Grande", Font.BOLD, 27));
		setTitle("후기남기기");
		setBounds(100, 100, 450, 227);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnOk());
		getContentPane().add(getBtnCancel());
		getContentPane().add(getLbEmpty1());
		getContentPane().add(getLbEmpty2());
		getContentPane().add(getLbEmpty3());
		getContentPane().add(getLbEmpty4());
		getContentPane().add(getLbEmpty5());

	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("확인");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (startCheck1 ||  startCheck2 || startCheck3 || startCheck4 || startCheck5) {
						insertRating();
						JOptionPane.showMessageDialog(getRootPane(), "별점남기기 완료 되었습니다", "알림", JOptionPane.ERROR_MESSAGE);
						dispose();
					}
					
				}
			});
			btnOk.setBounds(65, 122, 117, 29);
		}
		return btnOk;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(getRootPane(), "후기남기기를 취소 하시겠습니까?", "알림", JOptionPane.ERROR_MESSAGE);
					if (result == JOptionPane.YES_OPTION) {
						dispose();
					}
				}
			});
			btnCancel.setBounds(245, 122, 117, 29);
		}
		return btnCancel;
	}
	private JLabel getLbEmpty1() {
		if (lbEmpty1 == null) {
			lbEmpty1 = new JLabel("");
			lbEmpty1.addMouseListener(new MouseAdapter() {
				boolean check = true;
				@Override
				public void mouseEntered(MouseEvent e) {
					lbEmpty1.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					if (check) {
						lbEmpty1.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
					}
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					if (check) {
						lbEmpty1.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
						startCheck1 = true;
					}
					else {
						lbEmpty1.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						check = true;
					}
					check = false;
				}
			});
			lbEmpty1.setBounds(65, 46, 47, 37);
			lbEmpty1.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
		}
		return lbEmpty1;
	}
	private JLabel getLbEmpty2() {
		if (lbEmpty2 == null) {
			lbEmpty2 = new JLabel("");
			lbEmpty2.addMouseListener(new MouseAdapter() {
				boolean check = true;
				@Override
				public void mouseEntered(MouseEvent e) {
					lbEmpty1.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
					lbEmpty2.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					if (check) {
						lbEmpty1.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						lbEmpty2.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
					}
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					if (check) {
						lbEmpty1.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
						lbEmpty2.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
						startCheck2 = true;
					}
					else {
						lbEmpty1.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						lbEmpty2.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						check = true;
					}
					check = false;
				}
			});
			lbEmpty2.setBounds(133, 46, 47, 37);
			lbEmpty2.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
		}
		return lbEmpty2;
	}
	private JLabel getLbEmpty3() {
		if (lbEmpty3 == null) {
			lbEmpty3 = new JLabel("");
			lbEmpty3.addMouseListener(new MouseAdapter() {
				boolean check = true;
				@Override
				public void mouseEntered(MouseEvent e) {
					lbEmpty1.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
					lbEmpty2.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
					lbEmpty3.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					if (check) {
						lbEmpty1.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						lbEmpty2.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						lbEmpty3.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
					}
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					if (check) {
						lbEmpty1.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
						lbEmpty2.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
						lbEmpty3.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
						startCheck3 = true;
					}
					else {
						lbEmpty1.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						lbEmpty2.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						lbEmpty3.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						check = true;
					}
					check = false;
				}
			});
			lbEmpty3.setBounds(202, 46, 47, 37);
			lbEmpty3.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
		}
		return lbEmpty3;
	}
	private JLabel getLbEmpty4() {
		if (lbEmpty4 == null) {
			lbEmpty4 = new JLabel("");
			lbEmpty4.addMouseListener(new MouseAdapter() {
				boolean check = true;
				@Override
				public void mouseEntered(MouseEvent e) {
					lbEmpty1.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
					lbEmpty2.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
					lbEmpty3.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
					lbEmpty4.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					if (check) {
						lbEmpty1.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						lbEmpty2.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						lbEmpty3.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						lbEmpty4.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
					}
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					if (check) {
						lbEmpty1.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
						lbEmpty2.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
						lbEmpty3.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
						lbEmpty4.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
						startCheck4 = true;
					}
					else {
						lbEmpty1.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						lbEmpty2.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						lbEmpty3.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						lbEmpty4.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						check = true;
					}
					check = false;
				}
			});
			lbEmpty4.setBounds(268, 46, 47, 37);
			lbEmpty4.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
		}
		return lbEmpty4;
	}
	private JLabel getLbEmpty5() {
		if (lbEmpty5 == null) {
			lbEmpty5 = new JLabel("");
			lbEmpty5.addMouseListener(new MouseAdapter() {
				boolean check = true;
				@Override
				public void mouseEntered(MouseEvent e) {
					lbEmpty1.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
					lbEmpty2.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
					lbEmpty3.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
					lbEmpty4.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
					lbEmpty5.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					if (check) {
						lbEmpty1.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						lbEmpty2.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						lbEmpty3.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						lbEmpty4.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						lbEmpty5.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
					}
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					if (check) {
						lbEmpty1.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
						lbEmpty2.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
						lbEmpty3.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
						lbEmpty4.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
						lbEmpty5.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/star.png")));
						startCheck5 = true;
					}
					else {
						lbEmpty1.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						lbEmpty2.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						lbEmpty3.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						lbEmpty4.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						lbEmpty5.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
						check = true;
					}
					check = false;
				}
			});
			lbEmpty5.setBounds(334, 46, 47, 37);
			lbEmpty5.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/emptystar.png")));
		}
		return lbEmpty5;
	}
	
	
	// ---- Function ----
	private void insertRating() {
		Dao_Chat d = new Dao_Chat();
		
		if (startCheck1) {
			d = new Dao_Chat(1);
			d.insertRating();
		}
		if (startCheck2) {
			d = new Dao_Chat(2);
			d.insertRating();
		}
		if (startCheck3) {
			d = new Dao_Chat(3);
			d.insertRating();
		}
		if (startCheck4) {
			d = new Dao_Chat(4);
			d.insertRating();
		}
		if (startCheck5) {
			d = new Dao_Chat(5);
			d.insertRating();
		}
	}
}
