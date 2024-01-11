package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import com.javalec.function.*;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyCutoff extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnHome;
	private JButton btnMy;
	private JButton btnChat;
	private JButton btnWrite;
	private JButton btnBack;
	private JScrollPane scrollPane;
	private JTable innertable;
	ArrayList<Dto_MyCutoff> dtolist = null;
	
	// Table
	private final DefaultTableModel outertable = new DefaultTableModel();
	private JButton btnDelete;
	private JLabel lblImage;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyCutoff frame = new MyCutoff();
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
	public MyCutoff() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});
		setBounds(100, 100, 430, 732);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnHome());
		getContentPane().add(getBtnMy());
		getContentPane().add(getBtnChat());
		getContentPane().add(getBtnWrite());
		getContentPane().add(getBtnBack());
		getContentPane().add(getSeparator_1());
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtnDelete());
		getContentPane().add(getLblImage_1());

	}

	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("홈");
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Home home = new Home();
					dispose();
					home.setVisible(true);
				}
			});
			btnHome.setBounds(33, 55, 70, 34);
		}
		return btnHome;
	}

	private JButton getBtnMy() {
		if (btnMy == null) {
			btnMy = new JButton("개인");
			btnMy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MyPage mp = new MyPage();
					dispose();
					mp.setVisible(true);
				}
			});
			btnMy.setBounds(130, 55, 70, 34);
		}
		return btnMy;
	}

	private JButton getBtnChat() {
		if (btnChat == null) {
			btnChat = new JButton("채팅");
			btnChat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Chat chat = new Chat();
					dispose();
					chat.setVisible(true);
				}
			});
			btnChat.setBounds(230, 55, 70, 34);
		}
		return btnChat;
	}

	private JButton getBtnWrite() {
		if (btnWrite == null) {
			btnWrite = new JButton("글쓰기");
			btnWrite.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				}
			});
			btnWrite.setBounds(330, 55, 70, 34);
		}
		return btnWrite;
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

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBorder(BorderFactory.createEmptyBorder());
			scrollPane.setBounds(0, 150, 430, 400);
			scrollPane.setViewportView(getInnertable());
		}
		return scrollPane;
	}

	private JTable getInnertable() {
		if (innertable == null) {
			innertable = new JTable();
			innertable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					innertable.setDefaultEditor(Object.class, null);
				}
			});
			innertable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			innertable.setModel(outertable);
		}
		return innertable;
	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("차단풀기");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deleteblockuser();
				}
			});
			btnDelete.setBounds(150, 572, 117, 29);
		}
		return btnDelete;

	}

	private JLabel getLblImage_1() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon(MyCutoff.class.getResource("/com/javalec/images/MyCutoff.png")));
			lblImage.setBounds(0, 0, 430, 704);
		}
		return lblImage;
	}

	private JSeparator getSeparator_1() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(0, 140, 430, 12);
		}
		return separator;
	}
	// ---------------- method

	private void tableInit() {

		// Coulmn명 초기화
		outertable.addColumn("");
		outertable.setColumnCount(1);
		
		int i = outertable.getRowCount();

		for (int j = 0; j < i; j++) {
			outertable.removeRow(0);
		}

	}

	private void searchAction() {
		Dao_MyCutoff dao = new Dao_MyCutoff();
		dtolist = dao.selectList();

		int listCount = dtolist.size();

		for (int i = 0; i < listCount; i++) {

			String[] qTxt = { "       "+dtolist.get(i).getId()+" ( "+dtolist.get(i).getNick()+" )"};
			outertable.addRow(qTxt);
			innertable.setRowHeight(i, 100);
		}
	}

	private void deleteblockuser() {
		Dao_MyCutoff dao = new Dao_MyCutoff();

		int i = innertable.getSelectedRow();
		String blockuser = dtolist.get(i).getId();
		dao.deleteBlockuser(blockuser);

		JOptionPane.showMessageDialog(null, dtolist.get(i).getNick() + "님이 차단 해제 되었습니다.");

		tableInit();
		searchAction();
	}

} // End
