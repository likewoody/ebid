package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import com.javalec.function.Dao_Chat;
import com.javalec.function.Dto_Chat;
import com.javalec.function.Dto_Home;
import com.javalec.function.Share;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChatDetail extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel chatDeatilBackground;
	private JButton btnHome;
	private JButton btnMypage;
	private JButton btnChat;
	private JButton btnWrite;
	private JLabel lbUserImage;
	private JLabel lbUserNickname;
	private JLabel lbEnterMessage;
	private JScrollPane scrollPane;
	private JPanel innerPanel;
	private JButton btnInsert;
	private JTextField tfText;
	private JButton btnCb;
	private JButton btnRating;
	private JTable innerTable;
	private DefaultTableModel outerTable = new DefaultTableModel();
	private JButton btnBlock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatDetail dialog = new ChatDetail();
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
	public ChatDetail() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				if (Share.checkNewChat) {
					newChatInit();
				}
				else {
					tableInit();
					searchDB();
				}
			}
		});
		setFont(new Font("Lucida Grande", Font.BOLD, 27));
		setTitle("채팅방");
		setBounds(100, 100, 430, 732);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnHome());
		getContentPane().add(getBtnMypage());
		getContentPane().add(getBtnChat());
		getContentPane().add(getBtnWrite());
		getContentPane().add(getBtnCb());
		getContentPane().add(getBtnInsert());
		getContentPane().add(getBtnRating());
		getContentPane().add(getTfText());
		getContentPane().add(getBtnBlock());
		getContentPane().add(getScrollPane());
		getContentPane().add(getLbUserImage());
		getContentPane().add(getLbUserNickname());
		getContentPane().add(getLbEnterMessage());
		getContentPane().add(getChatDeatilBackground());

	}
	private JLabel getChatDeatilBackground() {
		if (chatDeatilBackground == null) {
			chatDeatilBackground = new JLabel("");
			chatDeatilBackground.setBounds(0, 0, 430, 703);
			chatDeatilBackground.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/chatDeatilBackground.png")));
		}
		return chatDeatilBackground;
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
					Write wrt = new Write();
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
	private JLabel getLbUserImage() {
		if (lbUserImage == null) {
			lbUserImage = new JLabel("");
			lbUserImage.setBackground(new Color(4, 50, 255));
			lbUserImage.setBounds(165, 130, 90, 70);
		}
		return lbUserImage;
	}
	private JLabel getLbUserNickname() {
		if (lbUserNickname == null) {
			lbUserNickname = new JLabel("");
			lbUserNickname.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			lbUserNickname.setHorizontalAlignment(SwingConstants.CENTER);
			lbUserNickname.setBounds(130, 212, 170, 16);
		}
		return lbUserNickname;
	}
	private JLabel getLbEnterMessage() {
		if (lbEnterMessage == null) {
			lbEnterMessage = new JLabel("");
			lbEnterMessage.setHorizontalAlignment(SwingConstants.CENTER);
			lbEnterMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			lbEnterMessage.setBounds(130, 240, 170, 16);
		}
		return lbEnterMessage;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 97, 430, 450);
			scrollPane.setBorder(BorderFactory.createEmptyBorder());
			scrollPane.setViewportView(getInnerTable());
//			scrollPane.setViewportView(getInnerPanel());
		}
		return scrollPane;
	}
	
//	private JPanel getInnerPanel() {
//		if (innerPanel == null) {
//			innerPanel = new JPanel();
//			innerPanel.setBackground(Color.WHITE);
//		}
//		return innerPanel;
//	}
	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("전송");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertChat();
				}
			});
			btnInsert.setFont(new Font("Helvetica", Font.BOLD, 14));
			btnInsert.setBounds(350, 575, 70, 34);
		}
		return btnInsert;
	}
	private JTextField getTfText() {
		if (tfText == null) {
			tfText = new JTextField();
			tfText.setBounds(56, 575, 290, 30);
			tfText.setColumns(10);
			tfText.setBorder(new LineBorder(new Color(214, 203, 216), 2));
			
		}
		return tfText;
	}
	private JButton getBtnCb() {
		if (btnCb == null) {
			btnCb = new JButton("+");
			btnCb.setFont(new Font("Helvetica", Font.PLAIN, 14));
			btnCb.setBounds(10, 575, 36, 30);
		}
		return btnCb;
	}
	private JButton getBtnRating() {
		if (btnRating == null) {
			btnRating = new JButton("별점남기기");
			btnRating.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					WriteRating wr = new WriteRating();
					wr.setVisible(true);
				}
			});
			btnRating.setFont(new Font("Helvetica", Font.BOLD, 14));
			btnRating.setBounds(60, 648, 128, 34);
		}
		return btnRating;
	}
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					innerTable.setDefaultEditor(Object.class, null);
				}
			});
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
			innerTable.setFont(new Font("Helvetica", Font.PLAIN, 15));
			innerTable.setBorder(new LineBorder(Color.BLACK));
		}
		return innerTable;
	}
	private JButton getBtnBlock() {
		if (btnBlock == null) {
			btnBlock = new JButton("차단하기");
			btnBlock.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					block();
				}
			});
			btnBlock.setFont(new Font("Helvetica", Font.BOLD, 14));
			btnBlock.setBounds(230, 650, 128, 34);
		}
		return btnBlock;
	}
	
	// ---- Fucntion ----
	
	private void tableInit() {
		outerTable.addColumn("닉넴");
		outerTable.addColumn("닉넴");
		outerTable.setColumnCount(2);
		
		TableColumn col = innerTable.getColumnModel().getColumn(0);
		int width = 100;
		col.setPreferredWidth(width);
		
		col = innerTable.getColumnModel().getColumn(1);
		width = 330;
		col.setPreferredWidth(width);
		
		int i = innerTable.getRowCount();
		for (int j = 0; j < i; j++) {
			outerTable.removeRow(0);
		}
	}
	
	private void searchDB() {
		Dao_Chat dao = new Dao_Chat();
		
		// 이미지 사진 첫 메시지에만 사진이 나온다 특히 상대방의 그게 아니라면 사진이 안나옴 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@22
		
		for (Dto_Chat dto : dao.findChatDeatil()) {
			outerTable.addRow(new Object[] {
					dto.getProfile_image(),
					String.format("%s : %s", dto.getDetailUser(), dto.getDetailtext())
			});
		}
		innerTable.getTableHeader().setReorderingAllowed(false); // true값과 false값의 차이를 모르겠음 *******
		
		innerTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRender());
		innerTable.getColumnModel().getColumn(1).setCellRenderer(new JText());
		innerTable.setRowHeight(50);
		
	}
	
	private class ImageRender extends DefaultTableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (value == null || !(value instanceof byte[])) {
	            // Handle the case where value is null or not a byte array
	            // You can customize this part based on your requirements
	            setIcon(null); // Clear the icon
	            setText("");
	            setHorizontalAlignment(JLabel.CENTER);
	            setBackground(getBackground());
	        } else {
	            byte[] bytes = (byte[]) value;
	            ImageIcon imageIcon = new ImageIcon(bytes);
	            Image img = imageIcon.getImage();
	            Image setImg = img.getScaledInstance(100, 75, Image.SCALE_SMOOTH);
	            ImageIcon image = new ImageIcon(setImg);
	            
	            setIcon(image);
	            setHorizontalAlignment(JLabel.CENTER);
	            setBackground(getBackground());
	        }

	        return this;
		}
		
	}
	private class JText extends DefaultTableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			
			String txts = (String) value;
			
			JTextField jText = new JTextField();
			jText.setSize(100, 30);
			jText.setText(txts);
			jText.setOpaque(true);
//			jText.setEditable(false);
			jText.setBackground(Color.WHITE);
			
			return jText;
		}
		
	}
	
	private void newChatInit() {
		outerTable.addColumn("");
		outerTable.addColumn("");
		
		outerTable.setColumnCount(2);
		
		TableColumn col = innerTable.getColumnModel().getColumn(0);
		int width = 100;
		col.setPreferredWidth(width);
		
		col = innerTable.getColumnModel().getColumn(1);
		col.setPreferredWidth(330);
		
		Dao_Chat dao = new Dao_Chat();
		for (Dto_Chat dto : dao.findUserImageId()) {
			outerTable.addRow(new Object[] {
					dto.getProfile_image(),
					String.format("<html>%s님과의 대화가 시작 되었습니다.</html>", dto.getSellUser(), dto.getSellUser())
			});
		}
		innerTable.getTableHeader().setReorderingAllowed(false);
		innerTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRender());
		innerTable.setRowHeight(100);
		
	}
	
	private void insertChat() {
		// 입력시 새로운 채팅일 때 true였던 체크뉴챗을 false로 바꾸면 tableinti, serachDB 활성화
		Share.checkNewChat = false;
		Dao_Chat dao = new Dao_Chat();
		// insert 
		dao.insertChat(tfText.getText());
		// 채팅방에 똑같이 업데이트 해주기 위함
		dao.updateChatRoom(tfText.getText());
		// 입력 후 텍스트 필드 초기화
		tfText.setText("");
		tableInit();
		searchDB();
	}
	
	private void block() {
		
	}
	
	
	
}
