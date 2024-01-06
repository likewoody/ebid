package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;

public class Login extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel homeBackgroundImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setFont(new Font("Lucida Grande", Font.BOLD, 27));
		setTitle("로그인");
		setBounds(100, 100, 430, 732);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getHomeBackgroundImage());
	}
	private JLabel getHomeBackgroundImage() {
		if (homeBackgroundImage == null) {
			homeBackgroundImage = new JLabel("");
			homeBackgroundImage.setBounds(0, 0, 430, 704);
			homeBackgroundImage.setIcon(new Image);
		}
		return homeBackgroundImage;
	}
}
