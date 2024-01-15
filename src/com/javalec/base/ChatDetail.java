package com.javalec.base;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import com.javalec.function.Dao_Chat;
import com.javalec.function.Dto_Chat;
import com.javalec.function.Dto_Home;
import com.javalec.function.Share;
import com.javalec.function.TestThread;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ChatDetail extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel chatDeatilBackground;
	private JButton btnHome;
	private JButton btnMypage;
	private JButton btnChat;
	private JButton btnWrite;
	private JScrollPane scrollPane;
	private JPanel innerPanel;
	private JButton btnInsert;
	private JTextField tfText;
	private JButton btnCb;
	private JButton btnRating;
	private JTable innerTable;
	private DefaultTableModel outerTable = new DefaultTableModel();
	private JButton btnBlock;
	private Dao_Chat dao = new Dao_Chat();
	private ImageIcon image;
	private JLabel lbUserImage_1;
	private JTextField textField;
	private JLabel lbText;
	private boolean fileExist;
	private byte[] bytes = null;
	private int previousCount = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					TestThread th = new TestThread();
//					th.start();
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
					int currentCount = dao.findChatCount();
					
					// 이전 현재 카운트와 이전 카운트 비교 이전 카운트가 더 작다면 테이블 초기화, serachDB
					if (currentCount > previousCount) {
						tableInit();
						searchDB();
						Share.count = currentCount - previousCount;
						previousCount = currentCount;
					}
				}
				
			}

			@Override
			// 화면이 꺼진 후 데이터가 아무 것도 입력되지 않았다면 삭제
			public void windowDeactivated(WindowEvent e) {
				if (dao.deleteNoneTitle()) {
					dao.deleteNoneTitle();
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
		getContentPane().add(getLbText());
		getContentPane().add(getTfText());
		getContentPane().add(getBtnBlock());
		getContentPane().add(getScrollPane());
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
					
					if (fileExist) {
						dao.insertImage(bytes);
						tfText.setBounds(56, 575, 290, 30);
						tfText.setText("");
						lbText.setIcon(null);
						fileExist = false;
					}
					else  {
						insertChat();
					}
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
			btnCb.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					insertImage();
				}
			});
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
	
	private JLabel getLbText() {
		if (lbText == null) {
			lbText = new JLabel("");
			lbText.setBackground(new Color(4, 50, 255));
			lbText.setBounds(65, 555, 290, 50);
		}
		return lbText;
	}
	
	// ---- Fucntion ----
	
	// 테이블 초기값
	private void tableInit() {
		outerTable.addColumn("");
		outerTable.addColumn("");
		outerTable.addColumn("");
		outerTable.setColumnCount(3);
		
		TableColumn col = innerTable.getColumnModel().getColumn(0);
		int width = 100;
		col.setPreferredWidth(width);
		
		col = innerTable.getColumnModel().getColumn(1);
		width = 60;
		col.setPreferredWidth(width);
		
		col = innerTable.getColumnModel().getColumn(2);
		width = 230;
		col.setPreferredWidth(width);
		
		int i = innerTable.getRowCount();
		for (int j = 0; j < i; j++) {
			outerTable.removeRow(0);
		}
	}
	
	// db 데이터 load
	public void searchDB() {
	    outerTable.setRowCount(0);

	    for (Dto_Chat dto : dao.findChatDeatil()) {
	        Object[] rowData;
	        if (dto.getDetailtext() != null) {
	            rowData = new Object[]{
	                    dto.getProfile_image(),
	                    String.format("%s : ", dto.getDetailUser()),
	                    String.format("<html>%s     <h5 style='text-align:right;'>%s</h5></html>", dto.getDetailtext(), dto.getDetailDate())
	            };
	        } else {
	            rowData = new Object[]{
	                    dto.getProfile_image(),
	                    String.format("%s : ", dto.getDetailUser()),
	                    dto.getDetailtextImage()
	            };
	        }

	        // Add the row data to the outer table
	        outerTable.addRow(rowData);
	    }

	    // Set cell renderer for column 2 (outside the loop)
	    innerTable.getColumnModel().getColumn(2).setCellRenderer(new ImageRender());

	    // Set other table properties
	    innerTable.getTableHeader().setReorderingAllowed(false);
	    innerTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRender());
	    innerTable.setRowHeight(50);
	}

	
	// 이미지 세팅
	private class ImageRender extends DefaultTableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (column == 0) {
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
			}
			if (column == 2) {
	            if (value instanceof ImageIcon) {
	                // Handle rendering for ImageIcon (image)
	            	byte[] bytes = (byte[]) value;
		            ImageIcon imageIcon = new ImageIcon(bytes);
		            Image img = imageIcon.getImage();
		            Image setImg = img.getScaledInstance(100, 75, Image.SCALE_SMOOTH);
		            ImageIcon image = new ImageIcon(setImg);
		            
		            setIcon(image);
		            setHorizontalAlignment(JLabel.CENTER);
		            setBackground(getBackground());
	                setText("");
	            } else {
	                // Handle rendering for text
	                setIcon(null);
	                setText(value != null ? value.toString() : "");
	            }
	        }

	        return this;
		}
		
	}
	
	// chat text 설정
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
	
	// 새로운 채팅 일 때 초기화면
	private void newChatInit() {
		outerTable.addColumn("");
		outerTable.addColumn("");
		
		outerTable.setColumnCount(2);
		
		TableColumn col = innerTable.getColumnModel().getColumn(0);
		int width = 100;
		col.setPreferredWidth(width);
		
		col = innerTable.getColumnModel().getColumn(1);
		col.setPreferredWidth(330);
		
//		Dao_Chat dao = new Dao_Chat();
		for (Dto_Chat dto : dao.findUserImageId()) {
//			ImageIcon imageIcon =  new ImageIcon(dto.getProfile_image());
//			Image img = imageIcon.getImage();
//			Image setImg = img.getScaledInstance(90, 7, DO_NOTHING_ON_CLOSE);
//			ImageIcon image = new ImageIcon(setImg);
//			lbUserImage.setIcon(image);
//			lbUserNickname.setText(dto.getSellUser() + "님과의 대화가 시작 되었습니다.");
			outerTable.addRow(new Object[] {
					dto.getProfile_image(),
					String.format("<html>%s님과의 대화가 시작 되었습니다.</html>", dto.getSellUser(), dto.getSellUser())
			});
		}
		innerTable.getTableHeader().setReorderingAllowed(false);
		innerTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRender());
		innerTable.setRowHeight(100);
		
	}
	
	// new chat 아무것도 입력 안하고 나갈 시 삭제하기
	
	// 채팅 입력
	private void insertChat() {
		// 입력시 새로운 채팅일 때 true였던 체크뉴챗을 false로 바꾸면 tableinti, serachDB 활성화
		Share.checkNewChat = false;
//		Dao_Chat dao = new Dao_Chat();
		// insert 
		dao.insertChat(tfText.getText());
		// 채팅방에 똑같이 업데이트 해주기 위함
		dao.updateChatRoom(tfText.getText());
		// 입력 후 텍스트 필드 초기화
		tfText.setText("");
		tableInit();
		searchDB();
	}
	
	// 차단하기
	private void block() {
		if (dao.searchBlock()) {
			JOptionPane.showMessageDialog(this, "이미 차단된 유저입니다", "알림", JOptionPane.ERROR_MESSAGE);
		}
		else {
			dao.block();
			JOptionPane.showMessageDialog(this, "차단이 등록 되었습니다", "알림", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private byte[] insertImage() {
		JFileChooser chooser = new JFileChooser();
		
		bytes = null;
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "bmp");
        chooser.setFileFilter(filter);
		int result = chooser.showOpenDialog(null);
		
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = chooser.getSelectedFile();
			
			if (selectedFile != null) {
				fileExist = true;
				String imagePath = chooser.getSelectedFile().getPath();
				
				// 이미지 크기 세팅
				ImageIcon imageIcon = new ImageIcon(imagePath);
				Image img = imageIcon.getImage();
				Image setImg = img.getScaledInstance(70, 55, Image.SCALE_SMOOTH);
				ImageIcon image2 = new ImageIcon(setImg);
				
				// 이미지아이콘 타입을 바이트로 전환
				bytes = convertImageIconToByteArray(image2);
				
				// 텍스트를 이미지 아이콘으로 입력
				lbText.setIcon(image2);
				// tfText 이미지 크기만큼 크기 변경
				tfText.setBounds(56, 545, 290, 70);
				lbText.setHorizontalAlignment(SwingConstants.LEFT);
				
				// typing 모양 가리기 위함
				tfText.setText("                ");
				
			}
		}
		return bytes;
	}

	// 이미지아이콘 타입을 바이트로 전환하기 위한 
	private byte[] convertImageIconToByteArray(ImageIcon icon) {
	    BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
	    Graphics g = image.getGraphics();
	    icon.paintIcon(null, g, 0, 0);
	    g.dispose();

	    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
	        ImageIO.write(image, "png", baos);
	        return baos.toByteArray();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
//	private class TestThread extends Thread {
//
//		@Override
//		public void run() {
//			tableInit();
//			searchDB();
//		}
//		
//	}
}