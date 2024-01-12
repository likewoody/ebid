package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Article extends JDialog {

  
	private static final long serialVersionUID = 1L;
	private JFrame frame;
    private JLabel lblNewLabel;
    private JButton btnExit;
    private JScrollPane scrollPane;
    private JTable table;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JCheckBox ckbAgree;
    private Register register;
	public Object ckbagree;
	
	

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Article window = new Article();                 
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
  
//    public void setDialogVisible(boolean visible) {
//        setVisible(visible);
//    }
    public Article() {
    	register = new Register();
    	 ckbAgree = getCkbAgree(); // getCkbAgree 메소드를 호출해서 초기화
    	    initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 683, 307);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        frame.getContentPane().add(getScrollPane());
        frame.getContentPane().add(getLblNewLabel());
        frame.getContentPane().add(getBtnExit());
        frame.getContentPane().add(getLblNewLabel_1());
        frame.getContentPane().add(getLblNewLabel_2());
        frame.getContentPane().add(getCkbAgree());
    }

    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
            lblNewLabel = new JLabel("위개인정보수집•이용에동의합니다.(필수)");
            lblNewLabel.setBounds(255, 218, 218, 16);
        }
        return lblNewLabel;
    }

    private JButton getBtnExit() {
        if (btnExit == null) {
            btnExit = new JButton("닫기");
            btnExit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ExitArticle();
                }
            });
            btnExit.setBounds(75, 213, 82, 29);
        }
        return btnExit;
    }

    private JScrollPane getScrollPane() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setBounds(25, 47, 636, 65);

            // 표를 생성하고 데이터를 추가합니다.
            table = createTable();
            scrollPane.setViewportView(table);
        }
        return scrollPane;
    }

    private JTable createTable() {
        String[] columnNames = {"수집목적", "수집항목", "수집 근거"};
        Object[][] data = {
                {"회원 식별 및 서비스 제공", "아이디 , 비밀번호", "개인정보 보호법 제15조 제1항"},
                {"서비스 변경사항 및 고지사항 전달", "전화번호, 이메일", "개인정보 보호법 제15조 제1항"},
              
        };

        JTable table = new JTable(data, columnNames);
        table.setRowSelectionAllowed(false);
        table.setEnabled(false);
        return table;
    }

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("*귀하는 이웃비드의 서비스 이용에 필요한 최소한의 개인정보수집•이용에 동의하지않을 수 있으나");
			lblNewLabel_1.setBounds(25, 136, 510, 38);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("동의를거부할경우\n회원제서비스이용이불가합니다.");
			lblNewLabel_2.setBounds(30, 174, 510, 38);
		}
		return lblNewLabel_2;
	}
	private JCheckBox getCkbAgree() {
		if (ckbAgree == null) {
			ckbAgree = new JCheckBox("동의함");
			ckbAgree.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
								ok();
				}
			});
			ckbAgree.setBounds(521, 214, 65, 23);
		}
		return ckbAgree;
	}
	
	//------Function-----
	
	
	
	public void ExitArticle() {			
		System.exit(0);    
	}
	
	public void ok() {
			
				Register r = register;
					r.Check();
		
	}
	
}
