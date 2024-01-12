package com.javalec.base;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

import com.javalec.function.Dao_Home;
import com.javalec.function.Dto_Home;
import com.javalec.function.Share;

public class ZoomImage extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lbZoomImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZoomImage dialog = new ZoomImage();
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
	public ZoomImage() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				zoomImageAction();
			}
		});
		setFont(new Font("Lucida Grande", Font.BOLD, 27));
		setTitle("이미지 확대");
		setBounds(100, 100, 430, 732);
		getContentPane().setLayout(null);
		getContentPane().add(getLbZoomImage());

	}
	private JLabel getLbZoomImage() {
		if (lbZoomImage == null) {
			lbZoomImage = new JLabel("");
			lbZoomImage.setBounds(0, 0, 430, 703);
		}
		return lbZoomImage;
	}
	
	// ---- Fucntion -----
	
	public void zoomImageAction() {
		Dao_Home dao = new Dao_Home();
		ArrayList<Dto_Home> dtoList = dao.findPostImage();
		byte[] getImg = null;
		for(int i=0; i<dtoList.size(); i++) {
			if (i == Share.imageNum) {
				getImg = dtoList.get(i).getPost_image();
			}
		}
		ImageIcon imageIcon = new ImageIcon(getImg);
		Image img = imageIcon.getImage();
		Image setImg = img.getScaledInstance(430, 703, DO_NOTHING_ON_CLOSE);
		ImageIcon image = new ImageIcon(setImg);
		lbZoomImage.setIcon(image);
	}
}
