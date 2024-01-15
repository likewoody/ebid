package com.javalec.base;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.function.Dao_Chat;
import com.javalec.function.Dto_Chat;
import com.javalec.function.Dto_Home;
import com.javalec.function.Share;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.Format;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Chat extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel chatBackground;
	private JButton btnHome;
	private JButton btnChat;
	private JButton btnWrite;
	private JButton btnMypage;
	private JLabel lbDelete;
	private JScrollPane scrollPane;
	private JTable innerTable;
	private final DefaultTableModel outerTable = new DefaultTableModel() {
		public java.lang.Class<?> getColumnClass(int column) {
			switch(column) {
			case 0 : return boolean.class;
			case 1 : return byte[].class;
			case 2 : return Object[].class;
			default :
				return Object[].class;
			}
		};
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat dialog = new Chat();
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
	public Chat() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchChat();
			}
		});
		setFont(new Font("Lucida Grande", Font.BOLD, 27));
		setTitle("채팅 목록");
		setBounds(100, 100, 430, 732);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnHome());
		getContentPane().add(getBtnChat());
		getContentPane().add(getBtnWrite());
		getContentPane().add(getBtnMypage());
		getContentPane().add(getLbDelete());
		getContentPane().add(getChatBackground());
		getContentPane().add(getScrollPane());

	}
	private JLabel getChatBackground() {
		if (chatBackground == null) {
			chatBackground = new JLabel("");
			chatBackground.setBounds(0, 0, 430, 703);
			chatBackground.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/chatBackground.png")));
		}
		return chatBackground;
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
	private JLabel getLbDelete() {
		if (lbDelete == null) {
			lbDelete = new JLabel("삭제하기");
			lbDelete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					deleteChat();
				}
			});
			lbDelete.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			lbDelete.setHorizontalAlignment(SwingConstants.CENTER);
			lbDelete.setBounds(133, 642, 163, 40);
		}
		return lbDelete;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 96, 430, 525);
			scrollPane.setBorder(BorderFactory.createEmptyBorder());
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
					
					if (e.getClickCount() == 2) {
						// 챗 아이디를 찾기 위함
						Dao_Chat dao = new Dao_Chat();
//						if (Share.id.equals(Share.chatUserId)) {
						ArrayList<Dto_Chat> dto = dao.searchChat();
						
						
						int i = innerTable.getSelectedRow();
						Share.chatid = dto.get(i).getChatId();
						Share.checkUser = dto.get(i).getSellUser();
						
						// chatuser 와 share.id와 비교 같다면 sellUserId을 chatdeatil로 보내주고 같지 않다면 chatuser을 보내준다.
//						if (! Share.id.equals(dto.get(i).getChatUser())) Share.checkUser = dto.get(i).getChatUser();
//						else Share.checkUser = dto.get(i).getSellUser();
						
						ChatDetail cd = new ChatDetail();
						cd.setVisible(true);
						dispose();
//						}
//						if (Share.id.equals(Share.chatSellerId)) {
//							ArrayList<Dto_Chat> dto = dao.searchChatforSeller();
//							
//							
//							int i = innerTable.getSelectedRow();
//							Share.chatid = dto.get(i).getChatId();
//							
//							// chatuser 와 share.id와 비교 같다면 sellUserId을 chatdeatil로 보내주고 같지 않다면 chatuser을 보내준다.
//							if (! Share.id.equals(dto.get(i).getChatUser())) Share.checkUser = dto.get(i).getChatUser();
//							else Share.checkUser = dto.get(i).getSellUser();
//						
//							ChatDetail cd = new ChatDetail();
//							cd.setVisible(true);
//							dispose();
//						}
					}
				}
			});
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
			innerTable.setGridColor(Color.LIGHT_GRAY);
			innerTable.setShowGrid(false);
			innerTable.setShowHorizontalLines(true);
		}
		return innerTable;
	}
	
	// ---- Fucntion ----
	
	private void tableInit() {
		
		outerTable.addColumn("");
		outerTable.addColumn("");
		outerTable.addColumn("");
		outerTable.setColumnCount(3);
		
		TableColumn col = innerTable.getColumnModel().getColumn(0);
		col.setPreferredWidth(30);
		
		col = innerTable.getColumnModel().getColumn(1);
		col.setPreferredWidth(100);
		
		col = innerTable.getColumnModel().getColumn(2);
		col.setPreferredWidth(300);
		
		TableColumn checkboxColumn = innerTable.getColumnModel().getColumn(0);
	    checkboxColumn.setCellRenderer(new DefaultTableCellRenderer() {
	        @Override
	        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	            JCheckBox checkbox = new JCheckBox();
	            checkbox.setSelected((Boolean) value);
	            checkbox.setHorizontalAlignment(SwingConstants.CENTER);
	            checkbox.setBackground(getBackground());
	            return checkbox;
	        }
	    });

	    checkboxColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()));
		
		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);
		
		int i = outerTable.getRowCount();
		for (int j = 0; j < i; j++) {
			outerTable.removeRow(0);
		}
	}
	
	private void searchChat() {
		Dao_Chat dao = new Dao_Chat();
		
		// 유저가 일반 사용자 일 때
//		if (Share.id.equals(Share.chatUserId)) { 
			for (Dto_Chat dto : dao.searchChat()) {
				outerTable.addRow(new Object[] {
						false,
						dto.getProfile_image(),
						String.format("<html><<h2>%s</h2>"
								+ "%s<h4 style = 'font-weight:normal;text-align:right';>%s</h4></html>",  dto.getNickname(), dto.getTitle(), dto.getChatDate())
				});
			}
//		}
		// 유저가 일반 판매자 일 때
//		if(Share.id.equals(Share.chatSellerId)) {
//			for (Dto_Chat dto : dao.searchChatforSeller()) {
//				outerTable.addRow(new Object[] {
//						false,
//						dto.getProfile_image(),
//						String.format("<html><<h2>%s</h2>"
//								+ "%s<h4 style = 'font-weight:normal;text-align:right';>%s</h4></html>",  dto.getNickname(), dto.getTitle(), dto.getChatDate())
//				});
//			}
//		}
		innerTable.getTableHeader().setReorderingAllowed(false);
		innerTable.getColumnModel().getColumn(1).setCellRenderer(new ImageRender());
		innerTable.setRowHeight(80);
	}
	
	private void deleteChat() {
		// 챗 아이디를 찾기 위함
		Dao_Chat dao = new Dao_Chat();
		ArrayList<Dto_Chat> dto = dao.searchChat();
		
		
		
		int i = innerTable.getSelectedRow();
		// chatid 저장
		Share.chatid = dto.get(i).getChatId();
		
		
		// 먼저 detail의 텍스트들을 삭제 한 후 밑에 chatting room을 삭제한다.
		dao.deleteChatDetail(Share.chatid);
		
		// deleteChat에 인자값 chatId 넣어주면서 chatId 삭제
		dao.deleteChat(Share.chatid);
		tableInit();
		searchChat();
		
	}
	
	// image render
	private class ImageRender extends DefaultTableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			byte[] bytes = (byte[]) value;
			ImageIcon imageIcon = new ImageIcon(bytes);
			Image img = imageIcon.getImage();
			Image setImg = img.getScaledInstance(80, 60, Image.SCALE_SMOOTH);
			ImageIcon image = new ImageIcon(setImg);
			
			setIcon(image);
			setHorizontalAlignment(JLabel.CENTER);
			setBackground(getBackground());
			return this;
		}
		
	}
	
	// checkbox render
	private class CheckBoxRender extends DefaultTableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			JCheckBox checkbox = new JCheckBox();
            checkbox.setSelected((Boolean) value);
            checkbox.setHorizontalAlignment(SwingConstants.CENTER);
            return checkbox;
		}
	}
}
