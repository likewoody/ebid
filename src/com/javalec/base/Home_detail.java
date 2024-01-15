package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
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
	private JButton btnChat;
	private JButton btnWrite;
	private JTextField tfStatus;
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
	private Dao_Home dao = new Dao_Home();

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
		contentPanel.add(getBtnChat());
		contentPanel.add(getBtnWrite());
		contentPanel.add(getTfStatus());
		contentPanel.add(getLbPostTitle());
		contentPanel.add(getLbUserImage());
		contentPanel.add(getLbBid());
		contentPanel.add(getLbUserNick());
		contentPanel.add(getLbPrice());
		contentPanel.add(getLbUserRating());
		contentPanel.add(getLbDescription());
		contentPanel.add(getSeparator());
		contentPanel.add(getScrollPane());
		contentPanel.add(getLbClickWish());
		contentPanel.add(getHomeBackImage());
	}
	private JLabel getHomeBackImage() {
		if (homeBackImage == null) {
			homeBackImage = new JLabel("");
			homeBackImage.setBounds(0, 0, 430, 704);
			
//			Dao_Home dao = new Dao_Home();		
			// 불러온 wish_status가 1이라면 초기 배경값 설정
			if (dao.findWishStatus() == 1) homeBackImage.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/changeWishListColor.png")));
			else homeBackImage.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/HomeDetailBackground.png")));
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
			btnHome.setBounds(30, 55, 70, 34);
			
//			btnHome.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnHome;
	}
	private JButton getBtnMypage() {
		if (btnMypage == null) {
			btnMypage = new JButton("개인");
			btnMypage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MyPage mypage = new MyPage();
					mypage.setVisible(true);
					dispose();
				}
			});
			btnMypage.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnMypage.setBounds(130, 55, 70, 34);
//			btnMypage.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnMypage;
	}
	private JButton getBtnChat() {
		if (btnChat == null) {
			btnChat = new JButton("채팅");
			btnChat.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnChat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Chat chat = new Chat();
					chat.setVisible(true);
					dispose();
				}
			});
			btnChat.setBounds(230, 55, 70, 34);
//			btnChat.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnChat;
	}
	private JButton getBtnWrite() {
		if (btnWrite == null) {
			btnWrite = new JButton("글쓰기");
			btnWrite.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Writing wrt = new Writing();
					wrt.setVisible(true);
					dispose();
				}
			});
			btnWrite.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnWrite.setBounds(330, 55, 70, 34);
//			btnWrite.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnWrite;
	}
	private JTextField getTfStatus() {
		if (tfStatus == null) {
			tfStatus = new JTextField();
			tfStatus.setEditable(false);
			tfStatus.setHorizontalAlignment(SwingConstants.CENTER);
			tfStatus.setText(Share.post_status);
			tfStatus.setBounds(10, 112, 85, 30);
			tfStatus.setColumns(10);
			tfStatus.setBorder(new LineBorder(new Color(214, 203, 216), 2));
			
		}
		return tfStatus;
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
//			scrollPane.setBorder(BorderFactory.createEmptyBorder());
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
					
					if (e.getClickCount() == 2) {
						Share.imageNum = innerTableImage.getSelectedColumn();
						ZoomImage zoom = new ZoomImage();
						zoom.setVisible(true);
					}
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
			lbUserNick.setFont(new Font("Lucida Grande", Font.BOLD, 14));
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
			lbBid = new JLabel("채팅");
			lbBid.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println(Share.sellId);
					if (!dao.findChatExist()) {
						createChatRoom();
						Share.chatid = dao.findChatId();
						Share.checkNewChat = true;
					}
					ChatDetail cd = new ChatDetail();
					cd.setVisible(true);
					dispose();
				}
			});
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
			lbClickWish = new JLabel("");
			lbClickWish.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
//					Dao_Home dao = new Dao_Home();
					
					// findWishStatus가 0이라면 1로 바꿔주면서 이미지를 바꿔준다.
					// 그리고 데이터가 없다면 데이터를 생성해준다.
					if (dao.findWishStatus() == 0) {
						dao.updateWishStatus();
						dao.insertWish();
						homeBackImage.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/changeWishListColor.png")));
					}
					else {
						dao.updateWishStatus();
						homeBackImage.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/homedetailBackground.png")));
					}
					
				}
			});
			lbClickWish.setBounds(20, 641, 56, 36);
		}
		return lbClickWish;
	}
	
	// ---- Function ----
	
	private void tableInit() {
//		Dao_Home dao = new Dao_Home();
		ArrayList<Dto_Home> dto = dao.findPostImage();
		
		// 사진 갯수에 따라 컬럼 갯수를 다르게 설정
		if (dto.size() == 3) {
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
		}
		// 사진 갯수에 따라 컬럼 갯수를 다르게 설정
		else if (dto.size() == 2) {
			imageOuterTable.addColumn("");
			imageOuterTable.addColumn("");
			imageOuterTable.setColumnCount(2);
			TableColumn col = innerTableImage.getColumnModel().getColumn(0);
			int width = 160;
			col.setPreferredWidth(width);
			
			col = innerTableImage.getColumnModel().getColumn(1);
			col.setPreferredWidth(width);
			
		}
		// 사진 갯수에 따라 컬럼 갯수를 다르게 설정
		else if (dto.size() == 1) {
			imageOuterTable.addColumn("");
			imageOuterTable.setColumnCount(1);
			TableColumn col = innerTableImage.getColumnModel().getColumn(0);
			int width = 160;
			col.setPreferredWidth(width);
			
			
		}
		
		
		// 화면 자동 조절 오프, 오프시 화면 스크롤바가 나오게 한다.
//		innerTableImage.setAutoResizeMode(innerTableImage.AUTO_RESIZE_OFF);
		
		int i = imageOuterTable.getRowCount();
		for (int j = 0; j < i; j ++) {
			imageOuterTable.removeRow(0);
		}
	}
	
	private void searchDB() {
//		Dao_Home dao = new Dao_Home();
		ArrayList<Dto_Home> dto = dao.findPostImage();
		
		// 테이블 (최대 이미지 3개) 이미지 넣기 
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
				
		innerTableImage.getTableHeader().setReorderingAllowed(false); // true값과 false값의 차이를 모르겠음 *******
		innerTableImage.setRowHeight(110);
		
		// 유저 프로필 이미지
		ArrayList<Dto_Home> getUserInfo = dao.findUserInfo();
		
		// 1. 이미지 설정
		ImageIcon imageIcon = new ImageIcon(dao.findSellerImage());
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
	
	private void createChatRoom() {
//		Dao_Home dao = new Dao_Home();
		dao.createChatRoom();
		
	}
	
}