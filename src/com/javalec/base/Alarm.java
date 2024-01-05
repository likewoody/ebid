package com.javalec.base;

import java.awt.EventQueue;

import javax.lang.model.util.Elements.Origin;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.PageAttributes.OriginType;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

public class Alarm {
	
	    private boolean sellBuyClicked = false;
	    private boolean bidClicked = false;
	    private boolean keyClicked = false;
	    
	
		private final DefaultTableModel outer_Table = new DefaultTableModel();  // TAble 선언
		
	//	private List<Boolean> checkBoxStates = new ArrayList<>();
		
		
	private JFrame frame;
	private JLabel lblNewLabel;
	private JButton btnHome;
	private JButton btnMypage;
	private JButton btnAlarm;
	private JButton btnChat;
	private JButton btnRight;
	private JTextField tfSellBuyAlarm;
	private JTextField tfBidAlarm;
	private JTextField tfKeyAlarm;
	private JButton btnNewButton;
	private JButton cbAllButten;
	private JScrollPane scrollPane;
	private JTable innerTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alarm window = new Alarm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Alarm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
							tableInit();
			}
		});
		frame.setFont(new Font("Dialog", Font.BOLD, 27));
		frame.setTitle("알림창");
		frame.setBounds(100, 100, 430, 732);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getBtnHome());
		frame.getContentPane().add(getBtnMypage());
		frame.getContentPane().add(getBtnAlarm());
		frame.getContentPane().add(getBtnChat());
		frame.getContentPane().add(getBtnRight());
		frame.getContentPane().add(getTfSellBuyAlarm());
		frame.getContentPane().add(getTfBidAlarm());
		frame.getContentPane().add(getTfKeyAlarm());
		frame.getContentPane().add(getCbAllButten());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getScrollPane());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(0, 0, 430, 704);
			lblNewLabel.setIcon(new ImageIcon(Alarm.class.getResource("/com/javalec/images/mainFrame.png")));
			
		}
		return lblNewLabel;
	}
	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("홈");
			btnHome.setBounds(20, 55, 70, 34);
			btnHome.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		
			
		}
		return btnHome;
	}
	private JButton getBtnMypage() {
		if (btnMypage == null) {
			btnMypage = new JButton("개인");
			btnMypage.setBounds(100, 55, 70, 34);
			btnMypage.setBorder(new LineBorder(new Color(214, 203, 216), 2));	
			
		}
		return btnMypage;
	}
	private JButton getBtnAlarm() {
		if (btnAlarm == null) {
			btnAlarm = new JButton("알림");
			btnAlarm.setBounds(180, 55, 70, 34);
			btnAlarm.setBorder(new LineBorder(new Color(214, 203, 216), 2));
			btnAlarm.setBackground(new Color(214, 203, 216));
		
			
	
		}
		return btnAlarm;
	}
	private JButton getBtnChat() {
		if (btnChat == null) {
			btnChat = new JButton("채팅");
			btnChat.setBounds(260, 55, 70, 34);
			btnChat.setBorder(new LineBorder(new Color(214, 203, 216), 2));
			 btnAlarm.setOpaque(true);
		        btnAlarm.setBorderPainted(false);
			
		}
		return btnChat;
	}
	private JButton getBtnRight() {
		if (btnRight == null) {
			btnRight = new JButton("글쓰기");
			btnRight.setBounds(340, 55, 70, 34);
			btnRight.setBorder(new LineBorder(new Color(214, 203, 216), 2));
			
		}
		return btnRight;
	}
	private JTextField getTfSellBuyAlarm() {	
		if (tfSellBuyAlarm == null) {
			tfSellBuyAlarm = new JTextField();
			tfSellBuyAlarm.setEditable(false);
			tfSellBuyAlarm.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
							sbAlarmClick();
				}
				@Override
				public void mouseEntered(MouseEvent e) {
							SellBuyListMouseEntered();
				}
				@Override
				public void mouseExited(MouseEvent e) {
					       	SellBuyListMouseExit();
				}
			});
			tfSellBuyAlarm.setText("판매/구매 알림");
		//	tfSellBuyAlarm.setBackground(Color.LIGHT_GRAY);
			tfSellBuyAlarm.setBounds(40, 120, 95, 55);
			tfSellBuyAlarm.setColumns(10);
			int red = 0xD6;
	        int green = 0xCB;
	        int blue = 0xD8;

	        Color BackColor = new Color(red, green, blue);
	      
	        tfSellBuyAlarm.setBackground(BackColor);
	        tfSellBuyAlarm.setOpaque(true);
		}
		return tfSellBuyAlarm;
	}
	private JTextField getTfBidAlarm() {
		if (tfBidAlarm == null) {
			tfBidAlarm = new JTextField();
			tfBidAlarm.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
							BidAlarmClick();
				}
				@Override
				public void mouseEntered(MouseEvent e) {
							BidListMouseEntered();
				}
				@Override
				public void mouseExited(MouseEvent e) {
							BidListMouseExit();
				}
			});
			tfBidAlarm.setEditable(false);
			tfBidAlarm.setText("    경매 알림");
			tfBidAlarm.setColumns(10);
			tfBidAlarm.setBounds(170, 120, 95, 55);
			int red = 0xD6;
	        int green = 0xCB;											//기준색 D6CBD8 에 대한 값
	        int blue = 0xD8;

	        Color BackColor = new Color(red, green, blue);				//색깔 적용	     
	        tfBidAlarm.setBackground(BackColor);
	        tfBidAlarm.setOpaque(true);
		}
		return tfBidAlarm;
	}
	private JTextField getTfKeyAlarm() {
		if (tfKeyAlarm == null) {
			tfKeyAlarm = new JTextField();
			tfKeyAlarm.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
							KeyAlarmClick();
				}
				@Override
				public void mouseEntered(MouseEvent e) {
							KeyListMouseEntered();
				}
				@Override
				public void mouseExited(MouseEvent e) {
							KeyListMouseExit();
				}
			});
			tfKeyAlarm.setEditable(false);
			tfKeyAlarm.setText("  키워드 알림");
			tfKeyAlarm.setColumns(10);
			tfKeyAlarm.setBounds(300, 120, 95, 55);
			int red = 0xD6;
	        int green = 0xCB;											//기준색 D6CBD8 에 대한 값
	        int blue = 0xD8;

	        Color BackColor = new Color(red, green, blue);				//색깔 적용	   
	        tfKeyAlarm.setBackground(BackColor);
	        tfKeyAlarm.setOpaque(true);
		}
		return tfKeyAlarm;
	}
		
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("삭제");
			btnNewButton.setBackground(new Color(214, 203, 216));
			btnNewButton.setOpaque(true);
	        btnNewButton.setBorderPainted(false);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					  deleteRow();
				}
			});
			btnNewButton.setBounds(161, 649, 100, 34);
			btnNewButton.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return btnNewButton;
	}
	private JButton getCbAllButten() {
		if (cbAllButten == null) {
			cbAllButten = new JButton("전체선택");
			cbAllButten.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					selectallRow();
					
				}
			});
			cbAllButten.setBounds(13, 652, 70, 28);
			cbAllButten.setBorder(new LineBorder(new Color(214, 203, 216), 2));
		}
		return cbAllButten;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(15, 190, 400, 400);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable(outer_Table);
			innerTable.setModel(outer_Table);
			innerTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			
			 
		}
		return innerTable;
	} 

	
	//---------------Function---------------
	
	
	
	
	/*알림 종류					// 임시 작성
	 *   판매/구매 알림
	 *  
	 *  "post name" + 물품을 구매하셧군요. 거래자에 대한 별점을 남겨주새요.
	 *   내 + "안쓰는 장난감 팔아요" + "post_category" + 글에 채팅이 달렸어요.
	 *   내가찜한 + "wish_list.post_id" + 가 판매완료 되었어요. 
	 *   
	 *   경매 알림
	 *   내가 찜한 + "post.present_status 가 경매일때 " +	 가 종료되었어요.
	 *   내가 올린  + "post.present_status 가 경매일때 " +	 에 채팅이  올라왔어요.
	 *   내가 올린 +  "post.present_status 가 경매일때 " + 가 종료되었어요.
	 *   
	 *   키워드알림
	 *   
	 *   	내가 선택한 "Keyword" 가 +"post.title"+ 에 포합될때   -> 내가선택한 키워드 물품을 판매하는 글이 올라왔어요.
	 *  
	 *  
	 *  
	 *   
	 */
	

	
	
	
	//    알림 카테고리 선택할 때 텍스트 색깔/폰트 변화 Function 
	public void SellBuyListMouseEntered() {
		if ( !sellBuyClicked)	{				
			setMouseOverEffect(tfSellBuyAlarm);
				
		}
	}
	public void SellBuyListMouseExit() {		
		if (!sellBuyClicked && !tfSellBuyAlarm.isFocusOwner()) {	  //구매/판매 알람 버튼이 클릭된 상태가 아니고, 구매/판매 알람 텍스트 필드가 포커스를 가지고 있지 않은 경우 에만 적용
			resetButton(tfSellBuyAlarm);

		 
		}
	}	
	public void BidListMouseEntered() {
		if (!bidClicked) {						
			setMouseOverEffect(tfBidAlarm);
		}
		
	}	
	public void BidListMouseExit() {													
		if ( !bidClicked && !tfBidAlarm.isFocusOwner()) {			  //경매 알람 버튼이 클릭된 상태가 아니고, 경매 알람 텍스트 필드가 포커스를 가지고 있지 않은 경우 에만 적용
			resetButton(tfBidAlarm);            
			
		}
	}
	public void KeyListMouseEntered() {
		if (!keyClicked) {				
			setMouseOverEffect(tfKeyAlarm);									

		}
	}
	public void KeyListMouseExit() {
		if ( !keyClicked && !tfKeyAlarm.isFocusOwner()) {			  //키 알람 버튼이 클릭된 상태가 아니고, 키 알람 텍스트 필드가 포커스를 가지고 있지 않은 경우 에만 적용
			resetButton(tfKeyAlarm);								

		}
	}
	// 중복되는 코드 모아주는 매소드   ************************************************
	 private void setMouseOverEffect(JTextField textField) {
	        textField.setForeground(Color.BLACK);						//글씨 색깔
	        Font font = new Font("Arial Black", Font.ITALIC, 13);		//사용 폰트
	        textField.setFont(font);									//폰트 적용
	    }
	
	 private void resetButton(JTextField textField) {
	        textField.setForeground(UIManager.getColor("TextField.foreground"));		//텍스트 색깔 되돌리기 
	        textField.setFont(null);													//폰트 초기화
	    }
	 // 중복되는 코드 모아주는 매소드   ************************************************
	
	 
	 //outer_Table / innerTable 컬럼 구현
		public void tableInit() {
	//	    sbAlarmClick();					//처음에는 판매/구매 알림이 선택된 상태
		    SellBuyListMouseEntered();
			outer_Table.addColumn("선택");
			outer_Table.addColumn("내용");
			outer_Table.setColumnCount(2);
			
			//선택
			int colNo =0;
			TableColumn col = innerTable.getColumnModel().getColumn(colNo);
			int width= 30;		
			col.setPreferredWidth(width);
			//내용
			 colNo =1;
			   col = innerTable.getColumnModel().getColumn(colNo);
	         width= 370;
			col.setPreferredWidth(width);
			

			int i = outer_Table.getRowCount();
			for (int j = 0; j < i; j++) {
				outer_Table.removeRow(0);
			
			 
			
			}
		}
						
		//판매/구매	카테고리 클릭 이밴트
		public void sbAlarmClick() {
			tableInit();

			 resetButton(tfBidAlarm);
		     resetButton(tfKeyAlarm);
		     
		     
			
		}
		// 경매 알림 카테고리 클릭 이밴트
		public void BidAlarmClick() {
			tableInit();
			  resetButton(tfSellBuyAlarm);
		      resetButton(tfKeyAlarm);


			
		}
		//키워드 알림 카테고리 클릭 이밴트
		public void KeyAlarmClick() {
			tableInit();
			   resetButton(tfBidAlarm);
		       resetButton(tfSellBuyAlarm);


//			tfBidAlarm.setForeground(Color.GRAY); 					//클릭시 회색으로 변경		
//			tfSellBuyAlarm.setForeground(Color.GRAY);				//	 ==	
			
		}
// 선택 행 삭제 버튼
	private void deleteRow() {
	
			
		
	}
	//전체 선택버튼
	private void selectallRow() {
		
	}

}//END
