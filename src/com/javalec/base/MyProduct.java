package com.javalec.base;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;

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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import com.javalec.function.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Home home = new Home();
					dispose();
					home.setVisible(true);
				}
			});
			btnHome.setBounds(33, 55, 70, 34);
		}
		return btnHome;
	}

	private JButton getBtnMy() {
		if (btnMy == null) {
			btnMy = new JButton("개인");
			btnMy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MyPage mp = new MyPage();
					dispose();
					mp.setVisible(true);
				}
			});
			btnMy.setBounds(130, 55, 70, 34);
		}
		return btnMy;
	}

	private JButton getBtnChat() {
		if (btnChat == null) {
			btnChat = new JButton("채팅");
			btnChat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Chat chat = new Chat();
					dispose();
					chat.setVisible(true);
				}
			});
			btnChat.setBounds(230, 55, 70, 34);
		}
		return btnChat;
	}

	private JButton getBtnWrite() {
		if (btnWrite == null) {
			btnWrite = new JButton("글쓰기");
			btnWrite.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Writing w = new Writing();
					dispose();
					w.setVisible(true);
				}
			});
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

	        // 기본 에디터를 설정하고, 더블 클릭 시 행을 선택하도록 마우스 이벤트를 추가
	        innertable.setDefaultEditor(Object.class, null);

	        innertable.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                if (e.getClickCount() == 2) {
	                    // 더블 클릭 이벤트 처리 코드
	                    Dao_Home dao = new Dao_Home();
	                    Dao_MyProduct mp = new Dao_MyProduct();
	                    ArrayList<Dto_MyProduct> dto = mp.searchDB();

	                    // for finding postid
	                    Share.postId = dto.get(innertable.getSelectedRow()).getPostid();

	                    // for find sellid
	                    Share.sellId = dto.get(innertable.getSelectedRow()).getSellid();
//								
	                    Share.post_status = dao.findPostStatus();

	                    dao.viewCount();
	                    Home_detail homeDetail = new Home_detail();
	                    homeDetail.setVisible(true);
	                    dispose();
	                }
	            }
	        });

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
		int row = 0;
		for (Dto_MyProduct dto : dao.searchDB()) {
			outertable.addRow(new Object[] { dto.getPostimage(),
					String.format(
							"<html><b>[%s]</b>" + "<br><br>" + "%s<br>" + "가격 : %s<br>" + "판매자 : %s<br><br>"
									+ "채팅 : %s  ㅣ  찜 : %s</html>",
							dto.getStatus(), dto.getTitle(), Integer.toString(dto.getPrice()), dto.getNick(),
							Integer.toString(dto.getChat()), Integer.toString(dto.getWish())) });
			innertable.setRowHeight(row, 150);
			row++;
		}
		// true값과 false값의 차이를 모르겠음 *******
		innertable.getTableHeader().setReorderingAllowed(false); // true값과 false값의 차이를 모르겠음 *******
		// true값과 false값의 차이를 모르겠음 *******

		// 1번째 이미지 컬럼을 새로 만든다.
		innertable.getColumnModel().getColumn(0).setCellRenderer(new ImageRender());
	}

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
//				setBorder(UIManager.getBorder("TableHeader.cellBorder"));
			setHorizontalAlignment(JLabel.CENTER);
			setBackground(getBackground());

			return this;
		}
	}

} // End
