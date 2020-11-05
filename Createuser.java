import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Createuser extends JFrame {

	String username = "root";
	String password = "";
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	PreparedStatement stmt = null;
	
	String name = null, uname = null, pass = null;
	
	private JPanel contentPane;
	private JTextField textName;
	private JTextField textUsername;
	private JTextField textPassword;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Createuser frame = new Createuser();
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
	public Createuser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 560);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreateUserPanel = new JLabel("Create User Panel");
		lblCreateUserPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateUserPanel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCreateUserPanel.setBounds(0, 0, 424, 70);
		contentPane.add(lblCreateUserPanel);
		
		JLabel lblLoginAs = new JLabel("Login As");
		lblLoginAs.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLoginAs.setBounds(80, 136, 110, 25);
		contentPane.add(lblLoginAs);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(80, 188, 110, 25);
		contentPane.add(lblName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(80, 248, 110, 25);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(80, 302, 110, 25);
		contentPane.add(lblPassword);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textName.setBackground(new Color(253, 245, 230));
		textName.setBounds(204, 190, 150, 30);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textUsername = new JTextField();
		textUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		textUsername.setColumns(10);
		textUsername.setBackground(new Color(253, 245, 230));
		textUsername.setBounds(204, 248, 150, 30);
		contentPane.add(textUsername);
		
		textPassword = new JTextField();
		textPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPassword.setColumns(10);
		textPassword.setBackground(new Color(253, 245, 230));
		textPassword.setBounds(204, 302, 150, 30);
		contentPane.add(textPassword);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String url = "jdbc:mysql://localhost:3306/mydatabase";
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, username, password);	
				
				stat = conn.createStatement();
				
				name = textName.getText();
				uname = textUsername.getText();
				pass = textPassword.getText();
				
				String sql  = "SELECT * FROM `login` WHERE username='"+uname+"'";
				rs = stat.executeQuery(sql);
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, "Username Already Exist Try Another Username");	
				}else {
						String sql1 = "INSERT INTO `login`(`Name`, `username`, `password`) VALUES (?,?,?)";
						stmt = conn.prepareStatement(sql1);
						stmt.setString(1, name);
						stmt.setString(2, uname);
						stmt.setString(3, pass);
						stmt.executeUpdate();
						JOptionPane.showMessageDialog(null, "User Added Successfully");
					}
				}catch(Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCreate.setBounds(105, 371, 90, 30);
		contentPane.add(btnCreate);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "jdbc:mysql://localhost:3306/mydatabase";
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(url, username, password);	
					
					stat = conn.createStatement();
					
					name = textName.getText();
					uname = textUsername.getText();
					pass = textPassword.getText();
					String sql1 = "UPDATE `login` SET `Name`='"+name+"', `password`='"+pass+"' WHERE `username`='"+uname+"'";
					stat.executeUpdate(sql1);
					
					JOptionPane.showMessageDialog(null, "User Updated Successfully");
					}catch(Exception e1) {
						System.out.println(e1.getMessage());
					}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(264, 371, 90, 30);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "jdbc:mysql://localhost:3306/mydatabase";
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(url, username, password);	
					name = textName.getText();
					uname = textUsername.getText();
					pass = textPassword.getText();
					
					String sql  = "SELECT * FROM `login` WHERE username='"+uname+"'";
					rs = stat.executeQuery(sql);
					if(rs.next()) {
						String sql1 = "DELETE FROM `login` WHERE username='"+uname+"'";
						stat.executeUpdate(sql1);
						JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
					}else {
						JOptionPane.showMessageDialog(null, "Username Won't Exist Try Another Username");
					}
					}catch(Exception e1) {
						System.out.println(e1.getMessage());
					}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(105, 428, 90, 30);
		contentPane.add(btnDelete);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(264, 428, 90, 30);
		contentPane.add(btnClose);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(385, 10, 391, 503);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Username", "Password"
			}
		));
		scrollPane.setViewportView(table);
	}
}
