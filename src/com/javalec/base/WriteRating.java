package com.javalec.base;
import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Font;

public class WriteRating extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WriteRating dialog = new WriteRating();
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
	public WriteRating() {
		setFont(new Font("Lucida Grande", Font.BOLD, 27));
		setTitle("후기남기기");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

	}

}
