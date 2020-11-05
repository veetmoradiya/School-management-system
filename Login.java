import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	String strUser = null;
	String strPass = null;
	
	static Connection conn = null;

	
	public static void main(String[] args) throws ClassNotFoundException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbltop = new JLabel("Login");
		lbltop.setBackground(new Color(100, 149, 237));
		lbltop.setForeground(Color.BLACK);
		lbltop.setHorizontalAlignment(SwingConstants.CENTER);
		lbltop.setFont(new Font("Tahoma", Font.BOLD, 25));
		lbltop.setBounds(10, 10, 466, 55);
		contentPane.add(lbltop);
		
		JLabel lblNewLabel = new JLabel("Username : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(80, 100, 169, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(80, 168, 169, 25);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setBounds(250, 100, 200, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 16));
		passwordField.setBounds(250, 163, 200, 30);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login ");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname = textField.getText();
				String pass = passwordField.getText();
				String username = "root";
				String password = "";
				try {
					
					String url = "jdbc:mysql://localhost:3306/mydatabase";
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(url, username, password);
					
					Statement stat = conn.createStatement();
					String sql = "SELECT * FROM login WHERE username='"+uname+"'";
					ResultSet rs = stat.executeQuery(sql);
					
					if(rs.next()) {
						if(pass.equals(rs.getObject(3))) {
							setVisible(false);
							Home h = new Home();
							
							h.SetString(rs.getString(1));	
							h.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "Password Didn't Match With Username");
						}
					}else {
						JOptionPane.showMessageDialog(null, "User Does Not Exists");
					}
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.setBounds(80, 269, 96, 30);
		contentPane.add(btnLogin);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClose.setBounds(250, 269, 120, 30);
		contentPane.add(btnClose);
	}
}
