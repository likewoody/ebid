package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.function.Dao_Home;
import com.javalec.function.Dto_Home;
import com.javalec.function.Share;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;

public class Home_detail extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel homeBackImage;
	private JButton btnMypage;
	private JButton btnHome;
	private JButton btnAlarm;
	private JButton btnChat;
	private JButton btnWrite;
	private JTextField tfOption;
	private JLabel lbPostTitle;
	private JScrollPane scrollPane;
	private JTable innerTableImage;
	private JLabel lbUserImage;
	private JLabel lbUserNick;
	private JLabel lbDescription;
	private JLabel lbBid;
	private final DefaultTableModel imageOuterTable = new DefaultTableModel();
	private JSeparator separator;
	private JLabel lbUserRating;
	private JLabel lbPrice;
	private JLabel lbClickWish;
	private JLabel lbChangeWish_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Home_detail dialog = new Home_detail();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Home_detail() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
//				getPostInfo();
				tableInit();
				searchDB();
			}
		});
		setFont(new Font("Lucida Grande", Font.BOLD, 27));
		setTitle("상세페이지");
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
		contentPanel.add(getTfOption());
		contentPanel.add(getLbPostTitle());
		contentPanel.add(getLbUserImage());
		contentPanel.add(getLbBid());
		contentPanel.add(getLbUserNick());
		contentPanel.add(getLbPrice());
		contentPanel.add(getLbUserRating());
		contentPanel.add(getLbDescription());
		contentPanel.add(getLbChangeWish_1());
		contentPanel.add(getSeparator());
		contentPanel.add(getScrollPane());
		contentPanel.add(getLbClickWish());
		contentPanel.add(getHomeBackImage());
	}
	private JLabel getHomeBackImage() {
		if (homeBackImage == null) {
			homeBackImage = new JLabel("");
			homeBackImage.setBounds(0, 0, 430, 704);
			homeBackImage.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/HomeDetailBackground.png")));
		}
		return homeBackImage;
	}
	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("홈");
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Home home = new Home();
					home.setVisible(true);
					dispose();
				}
			});
			btnHome.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnHome.setBounds(20, 55, 70, 34);
			
//			btnHome.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnHome;
	}
	private JButton getBtnMypage() {
		if (btnMypage == null) {
			btnMypage = new JButton("개인");
			btnMypage.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnMypage.setBounds(100, 55, 70, 34);
//			btnMypage.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnMypage;
	}
	private JButton getBtnAlarm() {
		if (btnAlarm == null) {
			btnAlarm = new JButton("알림");
			btnAlarm.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnAlarm.setBounds(180, 55, 70, 34);
//			btnAlarm.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnAlarm;
	}
	private JButton getBtnChat() {
		if (btnChat == null) {
			btnChat = new JButton("채팅");
			btnChat.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnChat.setBounds(260, 55, 70, 34);
//			btnChat.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnChat;
	}
	private JButton getBtnWrite() {
		if (btnWrite == null) {
			btnWrite = new JButton("글쓰기");
			btnWrite.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnWrite.setBounds(340, 55, 70, 34);
//			btnWrite.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnWrite;
	}
	private JTextField getTfOption() {
		if (tfOption == null) {
			tfOption = new JTextField();
			tfOption.setEditable(false);
			tfOption.setHorizontalAlignment(SwingConstants.CENTER);
			tfOption.setText("판매");
			tfOption.setBounds(10, 112, 85, 30);
			tfOption.setColumns(10);
			tfOption.setBorder(new LineBorder(new Color(214, 203, 216), 2));
			
		}
		return tfOption;
	}
	private JLabel getLbPostTitle() {
		if (lbPostTitle == null) {
			lbPostTitle = new JLabel("");
			lbPostTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			lbPostTitle.setBounds(109, 101, 301, 53);
		}
		return lbPostTitle;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 156, 430, 126);
			scrollPane.setViewportView(getInnerTableImage());
		}
		return scrollPane;
	}
	private JTable getInnerTableImage() {
		if (innerTableImage == null) {
			innerTableImage = new JTable();
			innerTableImage.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTableImage.setModel(imageOuterTable);
			innerTableImage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					innerTableImage.setDefaultEditor(Object.class, null);
					
//					if (e.getClickCount() == 2) {
//						// postid가 7부터 시작이기에 viewcount에 선택된 row번호에 +7을 객체로 넣어준다.
//						Dao_Home dao = new Dao_Home(innerTableImage.getSelectedRow() + 7);
//						//detail에서 사용하기 위해 static으로 저장해둔다.
//						Share.postId = innerTableImage.getSelectedRow() + 7;
//						dao.viewCount();
//						Home_detail homeDetail = new Home_detail();
//						homeDetail.setVisible(true);
//						dispose();
//					}
				}
			});
		}
		return innerTableImage;
	}
	private JLabel getLbUserImage() {
		if (lbUserImage == null) {
			lbUserImage = new JLabel("");
			lbUserImage.setHorizontalAlignment(SwingConstants.CENTER);
			lbUserImage.setBounds(25, 293, 60, 60);
		}
		return lbUserImage;
	}
	private JLabel getLbUserNick() {
		if (lbUserNick == null) {
			lbUserNick = new JLabel("");
			lbUserNick.setFont(new Font("Lucida Grande", Font.BOLD, 13));
			lbUserNick.setBounds(105, 303, 132, 16);
		}
		return lbUserNick;
	}
	private JLabel getLbDescription() {
		if (lbDescription == null) {
			lbDescription = new JLabel("");
			lbDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbDescription.setVerticalAlignment(SwingConstants.TOP);
			lbDescription.setBounds(20, 380, 390, 230);
		}
		return lbDescription;
	}
	private JLabel getLbBid() {
		if (lbBid == null) {
			lbBid = new JLabel("입찰하기");
			lbBid.setHorizontalAlignment(SwingConstants.CENTER);
			lbBid.setBounds(247, 643, 160, 37);
		}
		return lbBid;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(Color.GRAY);
			separator.setBounds(0, 360, 430, 12);
		}
		return separator;
	}
	private JLabel getLbUserRating() {
		if (lbUserRating == null) {
			lbUserRating = new JLabel("");
			lbUserRating.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			lbUserRating.setBounds(105, 328, 132, 16);
		}
		return lbUserRating;
	}
	private JLabel getLbPrice() {
		if (lbPrice == null) {
			lbPrice = new JLabel("");
			lbPrice.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			lbPrice.setHorizontalAlignment(SwingConstants.CENTER);
			lbPrice.setBounds(93, 650, 120, 16);
		}
		return lbPrice;
	}
	private JLabel getLbClickWish() {
		if (lbClickWish == null) {
			lbClickWish = new JLabel("New label");
			lbClickWish.setBounds(22, 643, 54, 34);
		}
		return lbClickWish;
	}
	private JLabel getLbChangeWish_1() {
		if (lbChangeWish_1 == null) {
			lbChangeWish_1 = new JLabel("New label");
			lbChangeWish_1.setBounds(0, 0, 54, 34);
		}
		return lbChangeWish_1;
	}
	
	// ---- Function ----
	
	private void tableInit() {
		imageOuterTable.addColumn("");
		imageOuterTable.addColumn("");
		imageOuterTable.addColumn("");
		
		imageOuterTable.setColumnCount(3);
		
		TableColumn col = innerTableImage.getColumnModel().getColumn(0);
		int width = 160;
		col.setPreferredWidth(width);
		
		col = innerTableImage.getColumnModel().getColumn(1);
		col.setPreferredWidth(width);
		
		col = innerTableImage.getColumnModel().getColumn(2);
		col.setPreferredWidth(width);
		
		// 화면 자동 조절 오프, 오프시 화면 스크롤바가 나오게 한다.
		innerTableImage.setAutoResizeMode(innerTableImage.AUTO_RESIZE_OFF);
		
		int i = imageOuterTable.getRowCount();
		for (int j = 0; j < i; j ++) {
			imageOuterTable.removeRow(0);
		}
	}
	
//	private void getPostInfo() {
//		Dao_Home dao = new Dao_Home();
//		lbPostTitle.setText(dao.findPostTitle());
//	}
	
	private void searchDB() {
		Dao_Home dao = new Dao_Home();
		ArrayList<Dto_Home> dto = dao.findPostImage();
		
		// 테이블 최대 3개 이미지 넣기 
		if (dto.size() == 3) {
			imageOuterTable.addRow(new Object[] {
					dto.get(0).getPost_image(), dto.get(1).getPost_image(), dto.get(2).getPost_image()
			});
			innerTableImage.getColumnModel().getColumn(0).setCellRenderer(new ImageRender());
			innerTableImage.getColumnModel().getColumn(1).setCellRenderer(new ImageRender());
			innerTableImage.getColumnModel().getColumn(2).setCellRenderer(new ImageRender());
			
		}
		else if (dto.size() == 2) {
			imageOuterTable.addRow(new Object[] {
					dto.get(0).getPost_image(), dto.get(1).getPost_image()
			});
			innerTableImage.getColumnModel().getColumn(0).setCellRenderer(new ImageRender());
			innerTableImage.getColumnModel().getColumn(1).setCellRenderer(new ImageRender());
		}
		else if (dto.size() == 1) {
			imageOuterTable.addRow(new Object[] {
					dto.get(0).getPost_image()
			});
			innerTableImage.getColumnModel().getColumn(0).setCellRenderer(new ImageRender());
		}
		else {}
				
		innerTableImage.getTableHeader().setReorderingAllowed(false); // true값과 false값의 차이를 모르겠음 *******
		innerTableImage.setRowHeight(110);
		
		// 유저 프로필 이미지
		ArrayList<Dto_Home> getUserInfo = dao.findUserInfo();
		
		// 1. 이미지 설정
		ImageIcon imageIcon = new ImageIcon(dao.findUserImage());
		Image img = imageIcon.getImage();
		Image setImg = img.getScaledInstance(58, 58, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(setImg);
		lbUserImage.setIcon(image);
		
		// 2. 타이틀 설정
		lbPostTitle.setText(getUserInfo.get(0).getTitle());
		
		// 3. 닉네임 설정
		lbUserNick.setText(getUserInfo.get(0).getNickname());
		
		// 4. 설명 설정
		lbDescription.setText(getUserInfo.get(0).getDesc());
		
		// 5. 가격 설정
		lbPrice.setText(String.format("%,d원", getUserInfo.get(0).getStart_price()));
		
		// 별점 설정
		lbUserRating.setText(dao.findUserRating());
		
	}
	
	private class ImageRender extends DefaultTableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			
			byte[] bytes = (byte[]) value;
			
			// 이미지 객체로 전환 및 이미지 사이즈 설정
			ImageIcon imageIcon = new ImageIcon(bytes);
			Image img = imageIcon.getImage();
			Image setImg = img.getScaledInstance(120, 90, Image.SCALE_SMOOTH);
			ImageIcon image = new ImageIcon(setImg);
			
			// 이미지 아이콘으로 세팅, 보더, 수직 수평, 배경 설정
			setIcon(image);
//				setBorder(UIManager.getBorder("TableHeader.cellBorder"));
			setHorizontalAlignment(JLabel.CENTER);
			setBackground(getBackground());
			
			return this;
		}
		
	}
	
}