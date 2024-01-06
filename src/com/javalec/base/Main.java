package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

	private JFrame frame;
	private JLabel homeBackImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		frame.setFont(new Font("Lucida Grande", Font.BOLD, 27));
		frame.setTitle("메인");
		frame.setBounds(100, 100, 430, 732);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getHomeBackImage());
	}

	private JLabel getHomeBackImage() {
		int count = 0;
		if (homeBackImage == null) {
			homeBackImage = new JLabel("");
			homeBackImage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					clickBackground();
				}
			});
			homeBackImage.setBounds(0, 0, 430, 707);
			homeBackImage.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/appStartLogo.png")));
		}
		return homeBackImage;
	}
	
	// ---- Fucntion ----
	
	private void clickBackground() {
		
		// 몇번 반복할 것인가
		int num_iterations = 1;
		
		// 얼마나 딜레이걸 것인가 1000 = 1초
		int delay = 750;
	
		SwingUtilities.invokeLater(() ->  {
			// 타이머 클래스 객체 생성 0.2초 딜레이, actionlistener 객체 생성
			Timer timer = new Timer(delay, new ActionListener() {
				
				// 카운트
				int iteration = 0; 
				@Override
				public void actionPerformed(ActionEvent e) {
					// 카운트가 num_iterations까지 반복
					if (iteration < num_iterations) {
						if (iteration == 0) {
							homeBackImage.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/appStartLogo2.png")));
						}
						iteration++;
					}
					else {
						frame.setVisible(false);
					}
				}
				
			});
			
			// 타이머 시작
			timer.start();
		});
		
	}
}
