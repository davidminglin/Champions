package ics321;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.Connection;

public class Login extends JPanel {
	private JPasswordField pwdPassword;
	private JTextField testUsername;
	private String user = "";
	private String pass = "";
	private String host = "";
	public static Connection connection = null;
	JLayeredPane layeredPane = null;
	JLabel Home = null;

	/**
	 * Create the panel.
	 */
	public Login() {
		setLayout(null);
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 455, 315);
		add(layeredPane);
		layeredPane.setLayout(null);
		
		JLabel Login = new JLabel("");
		layeredPane.setLayer(Login, 0);
		Login.setBounds(0, 0, 455, 315);
		Login.setIcon(new ImageIcon(Login.class.getResource("/images/Login.png")));
		// Login.setIcon(new ImageIcon("C:\\Users\\David\\Desktop\\Champions\\src\\images\\Login.jpg"));
		// Login.setIcon(new ImageIcon("src\\images\\Login.jpg"));
		layeredPane.add(Login);
		
		pwdPassword = new JPasswordField();
		layeredPane.setLayer(pwdPassword, 1);
		pwdPassword.setBounds(290, 195, 142, 20);
		layeredPane.add(pwdPassword);
		
		testUsername = new JTextField();
		layeredPane.setLayer(testUsername, 1);
		testUsername.setBounds(290, 146, 142, 20);
		layeredPane.add(testUsername);
		testUsername.setColumns(10);
		
		JButton btnLogin = new JButton("Log In");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// user = testUsername.getText();
				// pass = "ics321";
				// pass = pwdPassword.getText();
				layeredPane.setLayer(Home, 2);
				try {
				    Thread.sleep(2000);
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
				/**
				try {
					Class.forName ("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://192.254.189.7:3306/vpawid_321project", user, pass);
					
					Statement statement = connection.createStatement();
					ResultSet result = statement.executeQuery("select * from champion_stats");
					while(result.next()) {
						System.out.println(result.getString("Champion_name"));
					}
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} 
				**/
			}
		});
		layeredPane.setLayer(btnLogin, 1);
		btnLogin.setBounds(368, 231, 64, 20);
		btnLogin.setBackground(new Color(255, 165, 0));
		layeredPane.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setForeground(Color.WHITE);
		layeredPane.setLayer(lblNewLabel, 1);
		lblNewLabel.setBounds(290, 177, 75, 14);
		layeredPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		layeredPane.setLayer(lblUsername, 1);
		lblUsername.setBounds(290, 128, 75, 14);
		layeredPane.add(lblUsername);
		
		JLabel lblNewLabel_1 = new JLabel("Database Login");
		lblNewLabel_1.setForeground(Color.WHITE);
		layeredPane.setLayer(lblNewLabel_1, 1);
		lblNewLabel_1.setBounds(290, 103, 104, 14);
		layeredPane.add(lblNewLabel_1);
		
		Home = new JLabel("");
		layeredPane.setLayer(Home, 0);
		Home.setBounds(0, 0, 455, 315);
		Home.setIcon(new ImageIcon(Login.class.getResource("/images/League.jpg")));
		// Home.setIcon(new ImageIcon("src\\images\\League.jpg"));
		layeredPane.add(Home);
		
	}
}
