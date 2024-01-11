package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.javalec.function.Dao_Chat;
import com.javalec.function.Dto_Chat;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	private ArrayList<Dto_Chat> chatHistory;
	private JPanel panel_1;
	private JButton btnInsert;
	private JTextField tfText;
	private JButton btnCb;
	private JButton btnRating;

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
				tableInit();
				getUserInfo();
					
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
					Writing wrt = new Writing();
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
			scrollPane.setViewportView(getInnerPanel());
		}
		return scrollPane;
	}
	
	private JPanel getInnerPanel() {
		if (innerPanel == null) {
			innerPanel = new JPanel();
			innerPanel.setBackground(Color.WHITE);
		}
		return innerPanel;
	}
	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("전송");
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
			btnRating = new JButton("후기남기기");
			btnRating.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btnRating.setFont(new Font("Helvetica", Font.BOLD, 14));
			btnRating.setBounds(148, 648, 128, 34);
		}
		return btnRating;
	}
	
	// ---- Fucntion ----
	
	private void tableInit() {
		
		
	
	}
	private void getUserInfo() {
	    Dao_Chat dao = new Dao_Chat();
	    ArrayList<Dto_Chat> dtoList = dao.findChatDeatil();

	    for (Dto_Chat dto : dtoList) {
	    	System.out.println(dto.getDetailtext());
	    	System.out.println(dto.getDetailuserid());
	        addChatDetailToPanel(dto);
	    }
	}

	private void addChatDetailToPanel(Dto_Chat dto) {
	    String detailText = dto.getDetailtext();
	    String detailUserId = dto.getDetailuserid();

	    // Create components for the chat detail
	    JLabel detailTextLabel = new JLabel(detailText);
	    JLabel detailUserIdLabel = new JLabel("User ID: " + detailUserId);

	    // Customize the appearance, fonts, etc. as needed
	    detailTextLabel.setFont(new Font("Arial", Font.PLAIN, 14));
	    detailUserIdLabel.setFont(new Font("Arial", Font.PLAIN, 12));

	    // Create a panel to hold the components
	    JPanel detailPanel = new JPanel(new GridLayout(2, 1));
	    detailPanel.add(detailTextLabel);
	    detailPanel.add(detailUserIdLabel);

	    // Add the detailPanel to your innerPanel
	    innerPanel.add(detailPanel);
	    
	    // Optionally, you might want to add some spacing between chat details
	    innerPanel.add(Box.createVerticalStrut(10));
	}
	
	private static JPanel createPanel(ArrayList<Dto_Chat> dto) {
		JPanel panel = new JPanel(new GridLayout(0, 1)); // Use GridLayout for a single column
		
		 // Create and add labels to the panel
        for (Dto_Chat item : dto) {
            JLabel label = new JLabel();
            label.setFont(new Font("Lucida Grande", Font.BOLD, 14));
            panel.add(label);
        }
        
		return panel;
	}
	
}