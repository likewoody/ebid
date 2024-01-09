package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import com.javalec.function.Dao_MyPage;
import com.javalec.function.Dto_MyPage;
import com.javalec.function.Share;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyPage extends JDialog {

	private static final long serialVersionUID = 1L;
	private JButton btnHome;
	private JButton btnMy;
	private JButton btnAlarm;
	private JButton btnChat;
	private JButton btnWrite;
	private JLabel lblMyLike;
	private JLabel lblMyProduct;
	private JLabel lblMyCutoff;
	private JSeparator separator;
	private JLabel lblUserImage;
	private JLabel lblUserNick;
	private JButton btnEdit;
	private JSeparator separator_1;
	private JSeparator separator_1_1;
	private JSeparator separator_1_1_1;
	private JLabel lblImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPage dialog = new MyPage();
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
	public MyPage() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				insertInfo();
			}
		});
		setTitle("개인");
		setBackground(SystemColor.window);
		setBounds(100, 100, 430, 732);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnHome());
		getContentPane().add(getBtnMy());
		getContentPane().add(getBtnAlarm());
		getContentPane().add(getBtnChat());
		getContentPane().add(getBtnWrite());
		getContentPane().add(getLblUserImage());
		getContentPane().add(getLblUserNick());
		getContentPane().add(getBtnEdit());
		getContentPane().add(getSeparator_1());
		getContentPane().add(getLblMyProduct());
		getContentPane().add(getSeparator_1_1());
		getContentPane().add(getSeparator_1_1_1());
		getContentPane().add(getLblMyLike());
		getContentPane().add(getLblMyCutoff());
		getContentPane().add(getSeparator_1_1_1_1());
		getContentPane().add(getLblImage());

	}

	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("홈");
			btnHome.setBounds(20, 55, 70, 34);
		}
		return btnHome;
	}

	private JButton getBtnMy() {
		if (btnMy == null) {
			btnMy = new JButton("개인");
			btnMy.setBounds(100, 55, 70, 34);
		}
		return btnMy;
	}

	private JButton getBtnAlarm() {
		if (btnAlarm == null) {
			btnAlarm = new JButton("알림");
			btnAlarm.setBounds(180, 55, 70, 34);
		}
		return btnAlarm;
	}

	private JButton getBtnChat() {
		if (btnChat == null) {
			btnChat = new JButton("채팅");
			btnChat.setBounds(260, 55, 70, 34);
		}
		return btnChat;
	}

	private JButton getBtnWrite() {
		if (btnWrite == null) {
			btnWrite = new JButton("글쓰기");
			btnWrite.setBounds(340, 55, 70, 34);
		}
		return btnWrite;
	}

	private JLabel getLblMyLike() {
		if (lblMyLike == null) {
			lblMyLike = new JLabel("- 나의 찜목록");
			lblMyLike.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MyLike mylike = new MyLike();
					dispose();
					mylike.setVisible(true);
				}
			});
			lblMyLike.setBounds(20, 370, 400, 16);
		}
		return lblMyLike;
	}

	private JLabel getLblMyProduct() {
		if (lblMyProduct == null) {
			lblMyProduct = new JLabel("- 나의 게시글");
			lblMyProduct.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MyProduct myproduct = new MyProduct();
					dispose();
					myproduct.setVisible(true);
				}
			});
			lblMyProduct.setBounds(20, 310, 400, 16);
		}
		return lblMyProduct;
	}

	private JLabel getLblMyCutoff() {
		if (lblMyCutoff == null) {
			lblMyCutoff = new JLabel("- 차단 목록");
			lblMyCutoff.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MyCutoff mycutoff = new MyCutoff();
					dispose();
					mycutoff.setVisible(true);
				}
			});
			lblMyCutoff.setBounds(20, 430, 400, 16);
		}
		return lblMyCutoff;
	}

	private JSeparator getSeparator_1() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(0, 280, 430, 12);
		}
		return separator;
	}

	private JLabel getLblUserImage() {
		if (lblUserImage == null) {
			lblUserImage = new JLabel("유저 이미지");
			lblUserImage.setBackground(Color.WHITE);
			lblUserImage.setBounds(89, 150, 100, 100);
		}
		return lblUserImage;
	}

	private JLabel getLblUserNick() {
		if (lblUserNick == null) {
			lblUserNick = new JLabel("유저 닉네임");
			lblUserNick.setBounds(211, 174, 200, 16);
		}
		return lblUserNick;
	}

	private JButton getBtnEdit() {
		if (btnEdit == null) {
			btnEdit = new JButton("개인정보 수정");
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					MyPageEdit mpe = new MyPageEdit();
					mpe.setVisible(true);
				}
			});
			btnEdit.setBounds(201, 211, 117, 29);
		}
		return btnEdit;
	}

	private JSeparator getSeparator_1_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(0, 340, 430, 12);
		}
		return separator_1;
	}

	private JSeparator getSeparator_1_1_1() {
		if (separator_1_1 == null) {
			separator_1_1 = new JSeparator();
			separator_1_1.setBounds(0, 400, 430, 12);
		}
		return separator_1_1;
	}

	private JSeparator getSeparator_1_1_1_1() {
		if (separator_1_1_1 == null) {
			separator_1_1_1 = new JSeparator();
			separator_1_1_1.setBounds(0, 460, 430, 12);
		}
		return separator_1_1_1;
	}

	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon(MyPage.class.getResource("/com/javalec/images/MyPageFrame.png")));
			lblImage.setBounds(0, 0, 430, 704);
		}
		return lblImage;
	}

	// ------------------function

	private void insertInfo() {
		Dao_MyPage dao = new Dao_MyPage();
		Dto_MyPage dto = dao.insertInfo();

		lblUserNick.setText(dto.getNickname() + "님 안녕하세요 :)");

		String filePath = Integer.toString(Share.filename);
		// 파일이 존재하는지 확인
		File file = new File(filePath);
		lblUserImage.setIcon(new ImageIcon(filePath));
		lblUserImage.setHorizontalAlignment(SwingConstants.CENTER);
	}
} // End
