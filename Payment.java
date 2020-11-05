import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Payment extends JFrame {

	private JPanel contentPane;
	private JTextField textTeacherName;
	private JTextField textName;
	private JTextField textAddress;
	private JTextField textYear;
	private JTextField textMonth;
	private JTextField textSalary;

	String username = "root";
	String password = "";
	Connection conn = null;
	
	String name;
	String t_name, month;
	int year, salary;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment();
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
	public Payment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 370);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPayment.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayment.setBounds(0, 0, 786, 40);
		contentPane.add(lblPayment);
		
		JLabel lblTeacherName = new JLabel("Teacher Name :");
		lblTeacherName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTeacherName.setBounds(60, 75, 150, 30);
		contentPane.add(lblTeacherName);
		
		textTeacherName = new JTextField();
		textTeacherName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textTeacherName.setBounds(235, 75, 250, 30);
		contentPane.add(textTeacherName);
		textTeacherName.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "jdbc:mysql://localhost:3306/mydatabase";
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(url, username, password);	
				
					name = textTeacherName.getText();
					String sql = "SELECT `name`, `salary`, `mobile`, `address`, `payment` FROM `teacher` WHERE name='"+name+"'";
					PreparedStatement stmt = conn.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					
					while(rs.next()) {
						textName.setText(rs.getString(1));
						textAddress.setText(rs.getString(4));
						textSalary.setText(rs.getString(2));
					}					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} 
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.setBounds(542, 75, 100, 30);
		contentPane.add(btnSearch);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(60, 137, 70, 30);
		contentPane.add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textName.setColumns(10);
		textName.setBounds(140, 137, 200, 30);
		contentPane.add(textName);
		
		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddress.setBounds(350, 137, 100, 30);
		contentPane.add(lblAddress);
		
		textAddress = new JTextField();
		textAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAddress.setColumns(10);
		textAddress.setBounds(460, 137, 200, 30);
		contentPane.add(textAddress);
		
		JLabel lblYear = new JLabel("Year :");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYear.setBounds(60, 187, 70, 30);
		contentPane.add(lblYear);
		
		textYear = new JTextField();
		textYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		textYear.setColumns(10);
		textYear.setBounds(140, 187, 100, 30);
		contentPane.add(textYear);
		
		JLabel lblMonth = new JLabel("Month :");
		lblMonth.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMonth.setBounds(250, 187, 70, 30);
		contentPane.add(lblMonth);
		
		textMonth = new JTextField();
		textMonth.setFont(new Font("Tahoma", Font.BOLD, 14));
		textMonth.setColumns(10);
		textMonth.setBounds(330, 187, 100, 30);
		contentPane.add(textMonth);
		
		JLabel lblSalary = new JLabel("Salary :");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalary.setBounds(440, 187, 70, 30);
		contentPane.add(lblSalary);
		
		textSalary = new JTextField();
		textSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		textSalary.setColumns(10);
		textSalary.setBounds(520, 187, 140, 30);
		contentPane.add(textSalary);
		
		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "jdbc:mysql://localhost:3306/mydatabase";
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(url, username, password);	
				
					t_name = textName.getText();
					month = textMonth.getText();
					year = Integer.parseInt(textYear.getText());
					salary = Integer.parseInt(textSalary.getText());
					
					String sql = "INSERT INTO `payment`(`t_name`, `year`, `month`, `salary`) VALUES ('"+t_name+"', '"+year+"', '"+month+"', '"+salary+"')";
					Statement stmt = conn.createStatement();
					
					stmt.executeUpdate(sql);
					
					JOptionPane.showMessageDialog(null, "Salary Updated Successfully");
					dispose();
						
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				} 
				
				
			}
		});
		btnPay.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPay.setBounds(240, 244, 100, 30);
		contentPane.add(btnPay);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClose.setBounds(385, 244, 100, 30);
		contentPane.add(btnClose);
	}

}
