import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;

public class AboutWindow {

	JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutWindow window = new AboutWindow();
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					Point middle = new Point(screenSize.width / 2, screenSize.height / 2);
					Point newLocation = new Point(middle.x - (window.frame.getWidth() + 300), 
					                              middle.y - (window.frame.getHeight() / 2));
					window.frame.setLocation(newLocation);
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
	public AboutWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JCheckBox chckbxCheckThisIf = new JCheckBox("Check This If You are Cool");
		frame.getContentPane().add(chckbxCheckThisIf, BorderLayout.SOUTH);
		
		JTextPane txtpnHelloHelloHell = new JTextPane();
		txtpnHelloHelloHell.setEditable(false);
		txtpnHelloHelloHell.setFont(new Font("Arial Black", Font.PLAIN, 16));
		txtpnHelloHelloHell.setText("\t              Shift Scheduler\n \t          Team 1 - The Team\n                            Nathan Whiteman\n                                   Joe Poti\n                              Mason Sayles\n              \t\t    Dalton Aird\n                          Cameron Alverez");
		frame.getContentPane().add(txtpnHelloHelloHell, BorderLayout.CENTER);
	}

}
