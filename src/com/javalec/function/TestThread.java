package com.javalec.function;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import com.javalec.base.ChatDetail;
import com.javalec.base.Login;
import com.javalec.base.Main;



public class TestThread extends Thread {

	private Timer timer;
	ChatDetail cd = new ChatDetail();
	
	@Override
	public void run() {
		
		
		// 몇번 반복할 것인가
		int num_iterations = Share.count;
		
		// 얼마나 딜레이걸 것인가 1000 = 1초
		int delay = 750;
	
		SwingUtilities.invokeLater(() ->  {
			// 타이머 클래스 객체 생성 0.2초 딜레이, actionlistener 객체 생성
			timer = new Timer(delay, new ActionListener() {
				
				// 카운트
				int iteration = 0; 
				@Override
				public void actionPerformed(ActionEvent e) {
					// 카운트가 num_iterations까지 반복
					if (iteration < num_iterations) {
						if (iteration == 0) {
							cd.searchDB();
						}
						iteration++;
					}
					else {
						cd.setVisible(true);
//						frame.dispose();
//						timer.stop();
					}
				}
			});
			// 타이머 시작
			timer.start();
		});
		
	}

}
