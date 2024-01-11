package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.function.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JSeparator;

public class MyProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnHome;
	private JButton btnMy;
	private JButton btnChat;
	private JButton btnWrite;
	private JButton btnBack;
	private JLabel lblImage;
	private JScrollPane scrollPane;
	private JTable innertable;

	// Table
	private final DefaultTableModel outertable = new DefaultTableModel();
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyProduct frame = new MyProduct();
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
	public MyProduct() {
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
		getContentPane().add(getScrollPane());
		getContentPane().add(getSeparator());
		getContentPane().add(getLblImage());

	}

	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("홈");
			btnHome.setBounds(33, 55, 70, 34);
		}
		return btnHome;
	}

	private JButton getBtnMy() {
		if (btnMy == null) {
			btnMy = new JButton("개인");
			btnMy.setBounds(130, 55, 70, 34);
		}
		return btnMy;
	}

	private JButton getBtnChat() {
		if (btnChat == null) {
			btnChat = new JButton("채팅");
			btnChat.setBounds(230, 55, 70, 34);
		}
		return btnChat;
	}

	private JButton getBtnWrite() {
		if (btnWrite == null) {
			btnWrite = new JButton("글쓰기");
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

	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon(MyProduct.class.getResource("/com/javalec/images/MyProduct.png")));
			lblImage.setBounds(0, 0, 430, 704);
		}
		return lblImage;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBorder(BorderFactory.createEmptyBorder());
			scrollPane.setBounds(0, 150, 430, 470);
			scrollPane.setViewportView(getInnertable());
		}
		return scrollPane;
	}

	private JTable getInnertable() {
		if (innertable == null) {
			innertable = new JTable();
			innertable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innertable.setModel(outertable);
		}
		return innertable;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(0, 139, 430, 12);
		}
		return separator;
	}

	// -------------function

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
		Dao_MyProduct dao = new Dao_MyProduct();
		ArrayList<Dto_MyProduct> dtolist = dao.searchDB();
		ArrayList<Dto_MyProduct> like = dao.LikeDB();

		int listCount = dtolist.size();

		for (int i = 0; i < listCount; i++) {
			
			String[] qTxt = { null,
					String.format("<html><b>[%s]</b>"
							+ "<br><br>"
							+ "%s<br>"
							+ "가격 : %s<br>"
							+ "판매자 : %s<br><br>"
							+ "좋아요 : %s</html>", dtolist.get(i).getPost_status(), dtolist.get(i).getTitle(),
							Integer.toString(dtolist.get(i).getPrice()), dtolist.get(i).getNickname(),Integer.toString(like.get(i).getLike()))};
			outertable.addRow(qTxt);
			innertable.setRowHeight(i, 150);
		}
	}

} // End
