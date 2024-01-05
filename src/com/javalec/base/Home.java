package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.javalec.function.Dao_Home;
import com.javalec.function.Dto_Home;
import com.javalec.function.Share;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Home extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel homeBackImage;
	private JButton btnHome;
	private JButton btnMypage;
	private JButton btnAlarm;
	private JButton btnChat;
	private JButton btnWrite;
	private JTextField tfSearch;
	private JScrollPane scrollPane;
	private JComboBox cbOption;
	private JButton btnSearch;
	private JTable innerTable;
//	private final DefaultTableModel outerTable = new DefaultTableModel() ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Home dialog = new Home();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Home() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
//				searchAction();
			}
		});
		setFont(new Font("Lucida Grande", Font.BOLD, 27));
		setTitle("홈");
		setBounds(100, 100, 430, 732);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getBtnHome());
		contentPanel.add(getBtnMypage());
		contentPanel.add(getBtnAlarm());
		contentPanel.add(getBtnChat());
		contentPanel.add(getBtnWrite());
		contentPanel.add(getTfSearch());
		contentPanel.add(getScrollPane());
		contentPanel.add(getCbOption());
		contentPanel.add(getBtnSearch());
		contentPanel.add(getHomeBackImage());
	}
	
	private JLabel getHomeBackImage() {
		if (homeBackImage == null) {
			homeBackImage = new JLabel("");
			homeBackImage.setBounds(0, 0, 430, 704);
			homeBackImage.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/mainFrame.png")));
		}
		return homeBackImage;
	}
	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("홈");
			btnHome.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnHome.setBounds(20, 55, 70, 34);
			
			btnHome.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnHome;
	}
	private JButton getBtnMypage() {
		if (btnMypage == null) {
			btnMypage = new JButton("개인");
			btnMypage.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnMypage.setBounds(100, 55, 70, 34);
			btnMypage.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnMypage;
	}
	private JButton getBtnAlarm() {
		if (btnAlarm == null) {
			btnAlarm = new JButton("알림");
			btnAlarm.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnAlarm.setBounds(180, 55, 70, 34);
			btnAlarm.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnAlarm;
	}
	private JButton getBtnChat() {
		if (btnChat == null) {
			btnChat = new JButton("채팅");
			btnChat.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnChat.setBounds(260, 55, 70, 34);
			btnChat.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnChat;
	}
	private JButton getBtnWrite() {
		if (btnWrite == null) {
			btnWrite = new JButton("글쓰기");
			btnWrite.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnWrite.setBounds(340, 55, 70, 34);
			btnWrite.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnWrite;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(90, 640, 240, 35);
			tfSearch.setColumns(10);
			tfSearch.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return tfSearch;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.setBounds(342, 642, 70, 34);
			btnSearch.setBorder(new LineBorder(new Color(214, 203, 216), 2));
			
		}
		return btnSearch;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 97, 430, 531);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//			innerTable.setModel(outerTable);
		
		}
		return innerTable;
	}
	private JComboBox getCbOption() {
		if (cbOption == null) {
			cbOption = new JComboBox();
			cbOption.setModel(new DefaultComboBoxModel(new String[] {"기본", "판매", "경매"}));
			cbOption.setBounds(10, 641, 80, 34);
		}
		return cbOption;
	}
	
	// ---- Fucntion ----
	
	private void tableInit() {
		
		Dao_Home dao = new Dao_Home();
		DefaultTableModel outerTable = new DefaultTableModel() {
			

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		
		
		// Add Column
		outerTable.addColumn("No");	
		outerTable.addColumn("file");
		
		
		for (Dto_Home dto : dao.findAll()) {
			outerTable.addRow(new Object[] {
				dto.getSeq(),
				dto.getFile()
			});
			
		}
		innerTable.setModel(outerTable);
		// row 높이 설정
		innerTable.setRowHeight(50);
		innerTable.getTableHeader().setReorderingAllowed(false);
		innerTable.getColumnModel().getColumn(1).setCellRenderer(new ImageRender());;
			
	}
	
	private class ImageRender extends DefaultTableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			String photoName = value.toString();
			ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/com/javalec/images/" + photoName).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			
			return new JLabel(imageIcon);
		}
		
	}
}
