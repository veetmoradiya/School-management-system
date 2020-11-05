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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class SubmitFee extends JFrame {

	private JPanel contentPane;
	private JTextField textAdmissionno;
	private JTextField textName;
	private JTextField textClass;
	private JTextField textSection;
	private JTextField textAdmissionNo;
	private JTextField textFName;
	private JTextField textAddress;
	private JTextField textYear;
	private JTextField textMonth;
	private JTextField textAmount;
	
	String username = "root";
	String password = "";
	Connection conn = null;
	Statement stat = null;
	
	PreparedStatement stmt = null;
	
	String number = null;
	
	String admin;
	int year;
	String month;
	int amount;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubmitFee frame = new SubmitFee();
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
	public SubmitFee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFee = new JLabel("Fee");
		lblFee.setHorizontalAlignment(SwingConstants.CENTER);
		lblFee.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblFee.setBounds(10, 10, 866, 50);
		contentPane.add(lblFee);
		
		JLabel lblAdmissionno = new JLabel("Admission No.");
		lblAdmissionno.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAdmissionno.setBounds(100, 80, 150, 30);
		contentPane.add(lblAdmissionno);
		
		textAdmissionno = new JTextField();
		textAdmissionno.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAdmissionno.setBounds(287, 80, 250, 30);
		contentPane.add(textAdmissionno);
		textAdmissionno.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					String url = "jdbc:mysql://localhost:3306/mydatabase";
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(url, username, password);
					
					number = textAdmissionno.getText();
					
					String sql = "SELECT `AdmissionNo`, `Name`, `Father`, `Class`, `Mother`, `Section`, `Mobile`, `Roll`, `Address`, `Gender`, `DOB`, `fees` FROM `student` WHERE AdmissionNo=?";
					PreparedStatement stmt = conn.prepareStatement(sql);
					
					stmt.setString(1, number);
					
					ResultSet rs = stmt.executeQuery();
					
					while(rs.next()) {
						textName.setText(rs.getString(2));
						textClass.setText(rs.getString(4));
						textSection.setText(rs.getString(6));
						textAdmissionNo.setText(rs.getString(1));
						textFName.setText(rs.getString(3));
						textAddress.setText(rs.getString(9));
						
					}
					conn.close();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(580, 80, 100, 30);
		contentPane.add(btnSearch);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(10, 171, 60, 30);
		contentPane.add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textName.setBounds(83, 174, 200, 30);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblClass = new JLabel("Class :");
		lblClass.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClass.setBounds(310, 171, 60, 30);
		contentPane.add(lblClass);
		
		textClass = new JTextField();
		textClass.setFont(new Font("Tahoma", Font.BOLD, 14));
		textClass.setColumns(10);
		textClass.setBounds(380, 171, 200, 30);
		contentPane.add(textClass);
		
		JLabel lblSection = new JLabel("Section :");
		lblSection.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSection.setBounds(590, 171, 80, 30);
		contentPane.add(lblSection);
		
		textSection = new JTextField();
		textSection.setFont(new Font("Tahoma", Font.BOLD, 14));
		textSection.setColumns(10);
		textSection.setBounds(680, 171, 200, 30);
		contentPane.add(textSection);
		
		JLabel lblAdmissionNo = new JLabel("Admission No :");
		lblAdmissionNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdmissionNo.setBounds(10, 228, 120, 30);
		contentPane.add(lblAdmissionNo);
		
		textAdmissionNo = new JTextField();
		textAdmissionNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAdmissionNo.setColumns(10);
		textAdmissionNo.setBounds(140, 228, 200, 30);
		contentPane.add(textAdmissionNo);
		
		JLabel lblFName = new JLabel("F Name :");
		lblFName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFName.setBounds(350, 228, 70, 30);
		contentPane.add(lblFName);
		
		textFName = new JTextField();
		textFName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFName.setColumns(10);
		textFName.setBounds(430, 228, 200, 30);
		contentPane.add(textFName);
		
		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(10, 289, 70, 30);
		contentPane.add(lblAddress);
		
		textAddress = new JTextField();
		textAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAddress.setColumns(10);
		textAddress.setBounds(100, 289, 200, 30);
		contentPane.add(textAddress);
		
		JLabel lblYear = new JLabel("Year :");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblYear.setBounds(310, 289, 70, 30);
		contentPane.add(lblYear);
		
		textYear = new JTextField();
		textYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		textYear.setColumns(10);
		textYear.setBounds(380, 289, 200, 30);
		contentPane.add(textYear);
		
		JLabel lblMonth = new JLabel("Month :");
		lblMonth.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMonth.setBounds(590, 289, 70, 30);
		contentPane.add(lblMonth);
		
		textMonth = new JTextField();
		textMonth.setFont(new Font("Tahoma", Font.BOLD, 14));
		textMonth.setColumns(10);
		textMonth.setBounds(660, 289, 200, 30);
		contentPane.add(textMonth);
		
		JLabel lblAmount = new JLabel("Amount :");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmount.setBounds(190, 340, 80, 30);
		contentPane.add(lblAmount);
		
		textAmount = new JTextField();
		textAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAmount.setColumns(10);
		textAmount.setBounds(287, 343, 200, 30);
		contentPane.add(textAmount);
		
		JButton BtnSave = new JButton("Save");
		BtnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "jdbc:mysql://localhost:3306/mydatabase";
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(url, username, password);
					
					if(textYear==null || textMonth==null) {
						JOptionPane.showMessageDialog(null, "Please Enter Valid Data");
					}else if(textAmount==null){
						JOptionPane.showMessageDialog(null, "Please Enter Fees Amount");
					}else {
						
						admin = textAdmissionNo.getText();
						year =Integer.parseInt(textYear.getText());
						month = textMonth.getText();
						amount = Integer.parseInt(textAmount.getText());
						
						String sql = "INSERT INTO `feerecord`(`AdmissionNo`, `year`, `month`, `amount`) VALUES (?, ?, ?, ?)";
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, admin);
						stmt.setInt(2, year);
						stmt.setString(3, month);
						stmt.setInt(4, amount);
						
						stmt.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Fees Data Added Successfully");
						dispose();
					}
				
					conn.close();
				}catch(Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		BtnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		BtnSave.setBounds(387, 424, 100, 30);
		contentPane.add(BtnSave);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(516, 424, 100, 30);
		contentPane.add(btnClose);
	}
}
