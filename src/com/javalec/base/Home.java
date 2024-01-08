package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.javalec.function.Dao_Home;
import com.javalec.function.Dto_Home;
import com.javalec.function.Share;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JComboBox cbSort;
	private JButton btnSearch;
	private JTable innerTable;
	private final DefaultTableModel outerTable = new DefaultTableModel() ;

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
				searchDB();
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
		contentPanel.add(getCbSort());
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
			btnHome.setBounds(20, 55, 70, 34);
			btnHome.setFont(new Font("Helvetica", Font.PLAIN, 14));
			
//			btnHome.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnHome;
	}
	private JButton getBtnMypage() {
		if (btnMypage == null) {
			btnMypage = new JButton("개인");
			btnMypage.setBounds(100, 55, 70, 34);
			btnMypage.setFont(new Font("Helvetica", Font.PLAIN, 14));
//			btnMypage.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnMypage;
	}
	private JButton getBtnAlarm() {
		if (btnAlarm == null) {
			btnAlarm = new JButton("알림");
			btnAlarm.setBounds(180, 55, 70, 34);
			btnAlarm.setFont(new Font("Helvetica", Font.PLAIN, 14));
//			btnAlarm.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnAlarm;
	}
	private JButton getBtnChat() {
		if (btnChat == null) {
			btnChat = new JButton("채팅");
			btnChat.setBounds(260, 55, 70, 34);
			btnChat.setFont(new Font("Helvetica", Font.PLAIN, 14));
//			btnChat.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnChat;
	}
	private JButton getBtnWrite() {
		if (btnWrite == null) {
			btnWrite = new JButton("글쓰기");
			btnWrite.setBounds(340, 55, 70, 34);
			btnWrite.setFont(new Font("Helvetica", Font.PLAIN, 14));
//			btnWrite.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnWrite;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(95, 640, 240, 35);
			tfSearch.setColumns(10);
			tfSearch.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return tfSearch;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnSearch();
				}
			});
			btnSearch.setBounds(342, 642, 70, 34);
			
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
			innerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					innerTable.setDefaultEditor(Object.class, null);
					Dao_Home dao = new Dao_Home();
					if (e.getClickCount() == 2) {
						for (int i = 0; i < innerTable.getRowCount(); i++ ) {
							System.out.println(Share.postId[i]);
//							if(innerTable.getSelectedRow() == (Share.postId[i] - 7)) {
//								dao.viewCount(Share.postId[i]);
//							}
						}
//						getvalueat
						Home_detail homeDetail = new Home_detail();
						homeDetail.setVisible(true);
						dispose();
					}
				}
			});
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
			innerTable.setFont(new Font("Helvetica", Font.PLAIN, 14));
			innerTable.setGridColor(Color.LIGHT_GRAY);
			innerTable.setShowGrid(false);
			innerTable.setShowHorizontalLines(true);
			innerTable.setRowHeight(140);
		}
		return innerTable;
	}
	private JComboBox getCbSort() {
		if (cbSort == null) {
			cbSort = new JComboBox();
			cbSort.setBounds(5, 641, 90, 34);
			cbSort.setModel(new DefaultComboBoxModel(new String[] {"제목", "닉네임"}));
		}
		return cbSort;
	}
	
	// ---- Fucntion ----
	private void tableInit() {
		outerTable.addColumn("이미지");
		outerTable.addColumn("상세정보");
		outerTable.setColumnCount(2);
		
		int colNo = 0;
		TableColumn col = innerTable.getColumnModel().getColumn(colNo);
//		TableColumn col = innerTable.getColumnModel().getColumn(colNo).setCellRenderer(new ImageRender());
		int width = 140;
		col.setPreferredWidth(width);
		
		colNo = 1;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 290;
		col.setPreferredWidth(width);
		
		// 화면 자동 조절 오프, 오프시 화면 스크롤바가 나오게 한다.
//		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);
		
		int i = outerTable.getRowCount();
		for (int j = 0; j < i; j ++) {
			outerTable.removeRow(0);
		}
	}
	
	
	private void searchDB() {
		Dao_Home dao = new Dao_Home();
		int count = 0;
		for (Dto_Home dto : dao.searchDB()) {
				outerTable.addRow(new Object[] {
						dto.getPost_image(),
						String.format("<html><b>[%s]</b><br><br>%s<br>판매금액 : %d<br>작성자 : %s</html>",
							dto.getSort(), dto.getTitle(), dto.getStart_price(), dto.getNickname())
				});
				Share.postId[] = dto.getPostId();
				count++;
		}
		// true값과 false값의 차이를 모르겠음 *******
		innerTable.getTableHeader().setReorderingAllowed(false); // true값과 false값의 차이를 모르겠음 *******
		// true값과 false값의 차이를 모르겠음 *******
		
		// 1번째 이미지 컬럼을 새로 만든다.
		innerTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRender());
	}
	
	// ImageRender는 그냥 class 이름 DefaultTableCellRenderer로 상속받는다.
	private class ImageRender extends DefaultTableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			
			// innerTable.getColumnModel().getColumn(0)로부터 데이터 받아오기
			byte[] bytes = (byte[]) value;
			
			// 이미지 객체로 전환 및 이미지 사이즈 설정
			ImageIcon imageIcon = new ImageIcon(bytes);
			Image img = imageIcon.getImage();
			Image setImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			ImageIcon image = new ImageIcon(setImg);
			
			// 이미지 아이콘으로 세팅, 보더, 수직 수평, 배경 설정
			setIcon(image);
//			setBorder(UIManager.getBorder("TableHeader.cellBorder"));
			setHorizontalAlignment(JLabel.CENTER);
			setBackground(getBackground());
			
			return this;
		}
	}
	
	private void btnSearch() {
		tableInit();
		
		Dao_Home dao = new Dao_Home();
		
		for (Dto_Home dto : dao.search(cbSort.getSelectedIndex(), tfSearch.getText())) {
			outerTable.addRow(new Object[] {
					dto.getPost_image(),
					String.format("<html><b>[%s]</b><br><br>%s<br>판매금액 : %d<br>작성자 : %s</html>",
							dto.getSort(), dto.getTitle(), dto.getStart_price(), dto.getNickname())
			});
		}
		// true값과 false값의 차이를 모르겠음 *******
		innerTable.getTableHeader().setReorderingAllowed(false); // true값과 false값의 차이를 모르겠음 *******
		// true값과 false값의 차이를 모르겠음 *******
		
		// 1번째 이미지 컬럼을 새로 만든다.
		innerTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRender());
		
	}	
	
}
