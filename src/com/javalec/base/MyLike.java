package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.BorderFactory;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.javalec.function.*;

public class MyLike extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnHome;
	private JButton btnMy;
	private JButton btnAlarm;
	private JButton btnChat;
	private JButton btnWrite;
	private JButton btnBack;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JButton btnDelete;
	private JLabel lblImage;
	private JTable innertable;

	ArrayList<Dto_Like> dtolist = null;

	// Table
	private final DefaultTableModel outertable = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyLike frame = new MyLike();
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
	public MyLike() {
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
		getContentPane().add(getBtnAlarm());
		getContentPane().add(getBtnChat());
		getContentPane().add(getBtnWrite());
		getContentPane().add(getBtnBack());
		getContentPane().add(getSeparator());
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtnDelete());
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

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(0, 140, 430, 12);
		}
		return separator;
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

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제하기");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deleteLike();
				}
			});
			btnDelete.setBounds(150, 572, 117, 29);
		}
		return btnDelete;
	}

	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon(MyLike.class.getResource("/com/javalec/images/MyLike.png")));
			lblImage.setBounds(0, 0, 430, 704);
		}
		return lblImage;
	}

	private JTable getInnertable() {
		if (innertable == null) {
			innertable = new JTable();
			innertable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innertable.setModel(outertable);
		}
		return innertable;
	}
	// method

	private void tableInit() {

		// Coulmn명 초기화
		outertable.addColumn("상품 이미지");
		outertable.addColumn("상품 정보");
		outertable.setColumnCount(2);

		int colNo = 0;
		TableColumn col = innertable.getColumnModel().getColumn(colNo);
		int width = 150;
		col.setPreferredWidth(width);

		colNo = 1;
		col = innertable.getColumnModel().getColumn(colNo);
		width = 280;
		col.setPreferredWidth(width);

		int i = outertable.getRowCount();

		for (int j = 0; j < i; j++) {
			outertable.removeRow(0);
		}

	}

	private void searchAction() {
		Dao_Like dao = new Dao_Like();

		dtolist = dao.searchDB();

		int listCount = dtolist.size();

		for (int i = 0; i < listCount; i++) {
			String[] qTxt = { null,
					String.format("<html><b>[%s]</b>" + "<br><br>" + "%s<br>" + "가격 : %s<br>" + "판매자 : %s </html>",
							dtolist.get(i).getPost_status(), dtolist.get(i).getTitle(),
							Integer.toString(dtolist.get(i).getPrice()), dtolist.get(i).getNickname()) };
			outertable.addRow(qTxt);
			innertable.setRowHeight(i, 150);
		}
	}

	private void deleteLike() {
		Dao_Like dao = new Dao_Like();

		int i = innertable.getSelectedRow();
		int like = dtolist.get(i).getPostid();
		dao.deleteLike(like);

		JOptionPane.showMessageDialog(null, "상품이 찜목록에서 삭제 되었습니다.");

		tableInit();
		searchAction();
	}

} // End
