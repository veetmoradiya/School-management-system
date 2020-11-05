import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddTeacher extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textSalary;
	private JTextField textMobile;
	private JTextField textAddress;
	
	String username = "root";
	String password = "";
	Connection conn = null;
	PreparedStatement stat = null;
	
	String name=null;
	int salary = 0;
	String mobile = null;
	String address = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeacher frame = new AddTeacher();
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
	public AddTeacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 402);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddTeacher = new JLabel("Add Teacher");
		lblAddTeacher.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddTeacher.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAddTeacher.setBounds(0, 0, 436, 40);
		contentPane.add(lblAddTeacher);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(75, 71, 100, 30);
		contentPane.add(lblName);
		
		JLabel lblSalary = new JLabel("Salary : ");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalary.setBounds(75, 111, 100, 30);
		contentPane.add(lblSalary);
		
		JLabel lblMobile = new JLabel("Mobile : ");
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMobile.setBounds(75, 151, 100, 30);
		contentPane.add(lblMobile);
		
		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddress.setBounds(75, 191, 100, 30);
		contentPane.add(lblAddress);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textName.setBounds(197, 71, 200, 30);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textSalary = new JTextField();
		textSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		textSalary.setColumns(10);
		textSalary.setBounds(197, 111, 200, 30);
		contentPane.add(textSalary);
		
		textMobile = new JTextField();
		textMobile.setFont(new Font("Tahoma", Font.BOLD, 14));
		textMobile.setColumns(10);
		textMobile.setBounds(197, 151, 200, 30);
		contentPane.add(textMobile);
		
		textAddress = new JTextField();
		textAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAddress.setColumns(10);
		textAddress.setBounds(197, 194, 200, 30);
		contentPane.add(textAddress);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				try {	
					String url = "jdbc:mysql://localhost:3306/mydatabase";
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(url, username, password);	
						
						name = textName.getText();
						salary = Integer.parseInt(textSalary.getText());
						mobile = textMobile.getText();
						address = textAddress.getText();
					
						if(mobile.length()!=10) {
							JOptionPane.showMessageDialog(null, "Please Enter Valid Mobile Number");
						}else if(name=="" || address=="" || textSalary.getText()=="") {
							JOptionPane.showMessageDialog(null, "Please Enter Valid Data");
						}else {
							String query = "INSERT INTO `teacher`(`name`, `salary`, `mobile`, `address`) VALUES (?, ?, ?, ?)";
							stat = conn.prepareStatement(query);
							
							stat.setString(1, name);
							stat.setInt(2, salary);
							stat.setString(3, mobile);
							stat.setString(4, address);

							stat.executeUpdate();
							
							JOptionPane.showMessageDialog(null, "Data Added");
						}
					conn.close();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnSave.setBounds(115, 258, 110, 40);
		contentPane.add(btnSave);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnClose.setBounds(255, 258, 110, 40);
		contentPane.add(btnClose);
	}
}
