package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.function.Dao_Write;
import com.javalec.function.Dto_Write;
import com.javalec.function.Share;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Writing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnHome;
	private JButton btnMypage;
	private JButton btnChat;
	private JButton btnWrite;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfTitle;
	private JTextField tfPrice;
	private JTextArea texDescription;
	private JLabel lblNewLabel_2;
	private JLabel lbladdimage;
	private JLabel lblimage;
	private JButton btnPost;
	private JLabel lblBackgroud;
	
	private final String url_mysql = Share.dbName;
	private final String id_mysql = Share.dbUser;
	private final String pw_mysql = Share.dbPass;
	private JLabel imagePreviewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Writing frame = new Writing();
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
	public Writing() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				insertInfo();//****input****
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 732);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnHome());
		contentPane.add(getBtnMypage());
		contentPane.add(getBtnChat());
		contentPane.add(getBtnWrite());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getTfTitle());
		contentPane.add(getTfPrice());
		contentPane.add(getTexDescription());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLbladdimage());
		contentPane.add(getLblimage());
		contentPane.add(getBtnPost());
		contentPane.add(getImagePreviewLabel());
		contentPane.add(getLblBackgroud());
	}
	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("홈");
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//input
					Home home = new Home();
					dispose();
					home.setVisible(true);
					
				}
			});
			btnHome.setFont(new Font("Dialog", Font.PLAIN, 14));
			btnHome.setBounds(37, 55, 70, 34);
		}
		return btnHome;
	}
	private JButton getBtnMypage() {
		if (btnMypage == null) {
			btnMypage = new JButton("개인");
			btnMypage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//input
					MyPage mypage = new MyPage();
					dispose();
					mypage.setVisible(true);			
				}
			});
			btnMypage.setFont(new Font("Dialog", Font.PLAIN, 14));
			btnMypage.setBounds(131, 55, 70, 34);
		}
		return btnMypage;
	}
	private JButton getBtnChat() {
		if (btnChat == null) {
			btnChat = new JButton("채팅");
			btnChat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//input
					Chat chat = new Chat();
					dispose();
					chat.setVisible(true);				
				}
			});
			btnChat.setFont(new Font("Dialog", Font.PLAIN, 14));
			btnChat.setBounds(227, 55, 70, 34);
		}
		return btnChat;
	}
	private JButton getBtnWrite() {
		if (btnWrite == null) {
			btnWrite = new JButton("글쓰기");
			btnWrite.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnWrite.setFont(new Font("Dialog", Font.PLAIN, 14));
			btnWrite.setBounds(320, 55, 70, 34);
		}
		return btnWrite;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("제목");
			lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(37, 119, 70, 30);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("판매가격");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(37, 156, 70, 24);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfTitle() {
		if (tfTitle == null) {
			tfTitle = new JTextField();
			tfTitle.setFont(new Font("Dialog", Font.PLAIN, 13));
			tfTitle.setBounds(150, 119, 240, 28);
			tfTitle.setColumns(10);
		}
		return tfTitle;
	}
	private JTextField getTfPrice() {
		if (tfPrice == null) {
			tfPrice = new JTextField();
			tfPrice.setHorizontalAlignment(SwingConstants.TRAILING);
			tfPrice.setFont(new Font("Dialog", Font.PLAIN, 14));
			tfPrice.setColumns(10);
			tfPrice.setBounds(150, 156, 240, 24);
		}
		return tfPrice;
	}
	private JTextArea getTexDescription() {
		if (texDescription == null) {
			texDescription = new JTextArea();
			texDescription.setFont(new Font("Dialog", Font.PLAIN, 13));
			texDescription.setWrapStyleWord(true);
			texDescription.setLineWrap(true);
			texDescription.setBounds(31, 216, 363, 293);
		}
		return texDescription;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("원");
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(379, 156, 34, 25);
		}
		return lblNewLabel_2;
	}
	private JLabel getLbladdimage() {
		if (lbladdimage == null) {
			lbladdimage = new JLabel("사진첨부");
			lbladdimage.setFont(new Font("굴림", Font.BOLD, 10));
			lbladdimage.setVerticalAlignment(SwingConstants.BOTTOM);
			lbladdimage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					chooseImage(); //input
					
				}
			});
			lbladdimage.setHorizontalAlignment(SwingConstants.CENTER);
			lbladdimage.setBounds(37, 548, 64, 59);
		}
		return lbladdimage;
	}
	private JLabel getLblimage() {
		if (lblimage == null) {
			lblimage = new JLabel("");
			lblimage.setFont(new Font("Dialog", Font.PLAIN, 11));
			lblimage.setBounds(210, 580, 170, 20);
		}
		return lblimage;
	}
	private JButton getBtnPost() {
		if (btnPost == null) {
			btnPost = new JButton("게시하기");
			btnPost.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateAction(); //****input********
					uploadImage();
				}
			});
			btnPost.setFont(new Font("Dialog", Font.PLAIN, 14));
			btnPost.setBounds(111, 640, 210, 40);
		}
		return btnPost;
	}
	private JLabel getLblBackgroud() {
		if (lblBackgroud == null) {
			lblBackgroud = new JLabel("");
			lblBackgroud.setIcon(new ImageIcon(Writing.class.getResource("/com/javalec/images/writeBackImage.png")));
			lblBackgroud.setBounds(0, 0, 430, 704);
		}
		return lblBackgroud;
	}
	private JLabel getImagePreviewLabel() {
		if (imagePreviewLabel == null) {
			imagePreviewLabel = new JLabel("");
			imagePreviewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			imagePreviewLabel.setBounds(125, 549, 80, 54);
		}
		return imagePreviewLabel;
	}
	//-------functions------------
	
	private void insertInfo() {
		
		Dao_Write dao = new Dao_Write();
		Dto_Write dto = dao.userIdinput();
	}
	
	//***************추가입력 미리보기*******************
	//이미지 미리보기 기능 추가.
	private JComponent createImagePreviewAccessory(JFileChooser fileChooser) {
	    JPanel panel = new JPanel(new BorderLayout());
	    imagePreviewLabel = new JLabel();
	    panel.add(imagePreviewLabel, BorderLayout.CENTER);

	    fileChooser.addPropertyChangeListener("selectedFileChanged", evt -> {
	        File selectedFile = fileChooser.getSelectedFile();
	        try {
	        if (selectedFile != null && selectedFile.isFile()) {
	            // 선택된 파일에 대한 이미지 프리뷰 업데이트 및 자동 크기 조절
	            ImageIcon icon = createImageIcon(selectedFile.getAbsolutePath(), imagePreviewLabel.getWidth(), imagePreviewLabel.getHeight());
	            imagePreviewLabel.setIcon(icon);
	        } else {
                imagePreviewLabel.setIcon(null);
	        	}
            }  catch (Exception e) {
	            e.printStackTrace();
	            System.err.println("Error setting image preview: " + e.getMessage());
	            // 예외가 발생한 경우에 대한 처리를 추가할 수 있습니다.
	            // 예를 들어, 사용자에게 오류 메시지를 표시하거나, 기본 이미지를 설정할 수 있습니다.
	        } 
	        
	    });

	    return panel;
	}

	//----포토---------------------
	//이미지 미리보기 기능
	private ImageIcon createImageIcon(String path, int width, int height) {
	      try {  
	    	  if (width <= 0 || height <= 0) {
	            // 너비 또는 높이가 0 이하인 경우, 기본 크기(100x100)로 설정
	            width = 100;
	            height = 100;
	        }
	    	  
	    	  // 이미지 아이콘 생성 및 자동 크기 조절
	          ImageIcon originalIcon = new ImageIcon(path);
	          Image originalImage = originalIcon.getImage();

	          // 이미지를 지정된 크기로 스케일링
	          Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);

	          // 스케일링된 이미지로 ImageIcon 생성
	          return new ImageIcon(resizedImage);
	      } catch (Exception e) {
	          e.printStackTrace();
	          System.err.println("Error creating ImageIcon: " + e.getMessage());
	          return null; // 이미지 생성에 실패한 경우 null 반환
	      }
	  }
	
		
	//-----------------------------
	// 사진 선택 다이얼로그를 열고 선택된 파일의 경로를 표시하는 메서드
	// 미리보 코드 수정.
	private void chooseImage() {
		JFileChooser fileChooser = new JFileChooser();
	    int result = fileChooser.showOpenDialog(this);

	    if (result == JFileChooser.APPROVE_OPTION) {
	        File selectedFile = fileChooser.getSelectedFile();

	        if (selectedFile != null) {
	        	
	            String imagePath = selectedFile.getAbsolutePath();
	            System.out.println("Selected image path: " + imagePath);
	            lblimage.setText(imagePath);
	            
	            // 이미지 프리뷰 업데이트 및 자동 크기 조절
	            ImageIcon icon = createImageIcon(imagePath, 80, 54); // 레이블 크기에 맞게 설정
	            if (icon != null) {
	                imagePreviewLabel.setIcon(icon);            
	        } else {
	            System.out.println("Selected file is null.");
	            lblimage.setText("No image selected.");
	            imagePreviewLabel.setIcon(null);
	           
	    }
	    } else {
	        System.out.println("File selection canceled.");
	        lblimage.setText("No image selected.");
	        imagePreviewLabel.setIcon(null);
	        
	    }
		} else {
	        System.out.println("File selection canceled.");
	        lblimage.setText("No image selected.");
	        imagePreviewLabel.setIcon(null);
	    }
	}
	
	//*************************************************************
	//--------------------------------------
	// 선택된 사진을 데이터베이스에 업로드하는 메서드
	private void uploadImage() {
		
		 try (Connection connection = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql)){
		        
        	 // Retrieve the maximum postid
            int maxPostId = getMaxPostId(connection);
            
            // tfImage가 null인지 확인
            if (lblimage != null) {
        	// SQL 쿼리를 사용하여 이미지를 데이터베이스에 삽입
            String sql = "INSERT INTO ebid.image(postid, post_image) VALUES (?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // 선택된 이미지 파일을 바이트 배열로 읽어옴
                File selectedFile = new File(lblimage.getText());
                byte[] imageData = new byte[(int) selectedFile.length()];
                try (FileInputStream fileInputStream = new FileInputStream(selectedFile)) {
                    fileInputStream.read(imageData);
                }

                // 쿼리에 이미지 데이터와 maxPostId 삽입
                preparedStatement.setInt(1, maxPostId);
                preparedStatement.setBytes(2, imageData);
               
                // 실행
                preparedStatement.executeUpdate();
            }
            
            System.out.println("Image uploaded successfully.");
            } else {
                System.out.println("No image selected.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
     		
	}
	
	 private int getMaxPostId(Connection connection) throws SQLException {
	        try (PreparedStatement ps = connection.prepareStatement("SELECT MAX(postid) FROM ebid.post");
	             ResultSet resultSet = ps.executeQuery()) {
	            if (resultSet.next()) {
	                return resultSet.getInt(1);
	            } else {
	                throw new SQLException("Error retrieving max postid");
	            }
	        }
	    }
	    
	 	
	//------------------------------------
	// 정보 입력하기
	private void updateAction() {
		
	//예외처리
	// 데이터 입력 여부 확인
	   if (tfTitle.getText().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "제목을 입력하세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
	        return; // 입력이 누락되었으므로 메서드를 더 이상 진행하지 않고 종료
	       }
	   if (tfPrice.getText().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "가격을 입력하세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
	        return; // 입력이 누락되었으므로 메서드를 더 이상 진행하지 않고 종료
	       } else {
	         try {
	         // 가격이 숫자로 변환이 가능한지 확인
	         double price = Double.parseDouble(tfPrice.getText());
	       } catch (NumberFormatException e) {
	           JOptionPane.showMessageDialog(null, "가격은 숫자로 입력하세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
	           return; // 숫자가 아니라면 메서드를 더 이상 진행하지 않고 종료
	       }
	    }	
	    if (texDescription.getText().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "작성중인 글을 입력하세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
	        return; // 입력이 누락되었으므로 메서드를 더 이상 진행하지 않고 종료
	      }	
	    if (lblimage.getText().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "사진을 첨부하세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
	        return; // 입력이 누락되었으므로 메서드를 더 이상 진행하지 않고 종료
	      }	
	     
	  // 파일 폴더를 열었지만 파일을 첨부하지 않은 경우
	       File attachedFile = new File(lblimage.getText());
	       if (!attachedFile.exists() || !attachedFile.isFile()) {
	           JOptionPane.showMessageDialog(null, "올바른 파일을 첨부하세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
	           return; // 파일이 존재하지 않거나 파일이 아닌 경우 메서드를 종료
	       }  
	    
	    
	//-----------------------------------------------    
			
	// 작동됨******************
		String title = tfTitle.getText();
		String price = tfPrice.getText();  	                
        String description = texDescription.getText();
        // 추가 고정값
	     
	    
    // 글올리기 처리
    Dao_Write dao = new Dao_Write(title, description, price); 
    // 사용자 등록 수행
    dao.wUpdate();

    // 사용자에게 성공적으로 등록되었음을 알림
    JOptionPane.showMessageDialog(null, "게시글이 등록되었습니다.");
   
    dispose();
        
    MyPage mypage = new MyPage();
    mypage.setVisible(true);
	}



}// end
