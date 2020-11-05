import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class admission extends JFrame {
	
	String username = "root";
	String password = "";
	Connection conn = null;
	PreparedStatement stat = null;

	private JPanel contentPane;
	private JTextField textAdmNum;
	private JTextField textName;
	private JTextField textfathername;
	private JTextField textmothername;
	private JTextField textMobile;
	private JTextField textRoll;
	private JTextField textdob;
	private JTextField textClass;
	private JTextField textSection;
	
	int admission_no = 0;
	String name = null, father = null;
	String class_ = null;
	String mother = null;
	String Section = null;
	String mobile = null;
	String roll = null;
	String Address = null;
	String Gender = null;
	String DOB = null;
	
//	int class_dummy = Integer.parseInt(class_);	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admission frame = new admission();
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
	public admission() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 130, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentAdmission = new JLabel("Student Admission");
		lblStudentAdmission.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentAdmission.setForeground(new Color(240, 255, 240));
		lblStudentAdmission.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblStudentAdmission.setBounds(10, 10, 966, 48);
		contentPane.add(lblStudentAdmission);
		
		JLabel lblAdmissionno = new JLabel("Admission No.");
		lblAdmissionno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdmissionno.setBounds(65, 130, 130, 25);
		contentPane.add(lblAdmissionno);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(65, 174, 110, 25);
		contentPane.add(lblName);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setBackground(new Color(255, 255, 255));
		lblClass.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClass.setBounds(65, 225, 110, 25);
		contentPane.add(lblClass);
		
		JLabel lblSection = new JLabel("Section");
		lblSection.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSection.setBounds(65, 279, 110, 25);
		contentPane.add(lblSection);
		
		JLabel lblRollNo = new JLabel("Roll No.");
		lblRollNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRollNo.setBounds(65, 330, 110, 25);
		contentPane.add(lblRollNo);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(65, 380, 110, 25);
		contentPane.add(lblGender);
		
		JLabel lblDob = new JLabel("D.O.B");
		lblDob.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDob.setBounds(65, 435, 110, 25);
		contentPane.add(lblDob);
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFathersName.setBounds(540, 179, 110, 25);
		contentPane.add(lblFathersName);
		
		JLabel lblMothersName = new JLabel("Mother's Name");
		lblMothersName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMothersName.setBounds(540, 225, 110, 25);
		contentPane.add(lblMothersName);
		
		JLabel lblMobileNo = new JLabel("Mobile no.");
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobileNo.setBounds(540, 279, 110, 25);
		contentPane.add(lblMobileNo);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(540, 330, 110, 25);
		contentPane.add(lblAddress);
		
		textAdmNum = new JTextField();
		textAdmNum.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAdmNum.setBounds(190, 130, 200, 30);
		contentPane.add(textAdmNum);
		textAdmNum.setColumns(10);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textName.setBounds(190, 179, 300, 30);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textfathername = new JTextField();
		textfathername.setFont(new Font("Tahoma", Font.BOLD, 14));
		textfathername.setColumns(10);
		textfathername.setBounds(660, 179, 300, 30);
		contentPane.add(textfathername);
		
		textmothername = new JTextField();
		textmothername.setFont(new Font("Tahoma", Font.BOLD, 14));
		textmothername.setColumns(10);
		textmothername.setBounds(660, 225, 300, 30);
		contentPane.add(textmothername);
		
		textMobile = new JTextField();
		textMobile.setFont(new Font("Tahoma", Font.BOLD, 14));
		textMobile.setColumns(10);
		textMobile.setBounds(660, 274, 300, 30);
		contentPane.add(textMobile);
		
		textRoll = new JTextField();
		textRoll.setFont(new Font("Tahoma", Font.BOLD, 14));
		textRoll.setColumns(10);
		textRoll.setBounds(190, 325, 300, 30);
		contentPane.add(textRoll);
		
		JTextArea textAddress = new JTextArea();
		textAddress.setFont(new Font("Monospaced", Font.BOLD, 14));
		textAddress.setBounds(660, 332, 300, 150);
		contentPane.add(textAddress);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnMale.setBounds(190, 384, 103, 30);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnFemale.setBounds(330, 384, 103, 30);
		contentPane.add(rdbtnFemale);
		
		ButtonGroup gender = new ButtonGroup();
		gender.add(rdbtnFemale);
		gender.add(rdbtnMale);
		
		textdob = new JTextField();
		textdob.setFont(new Font("Tahoma", Font.BOLD, 14));
		textdob.setColumns(10);
		textdob.setBounds(190, 435, 300, 30);
		contentPane.add(textdob);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				admission_no = Integer.parseInt(textAdmNum.getText());
				name = textName.getText();
				father = textfathername.getText();
				class_ = textClass.getText();
				mother = textmothername.getText();
				Section = textSection.getText();
				mobile = textMobile.getText();
				roll = textRoll.getText();
				Address = textAddress.getText();
				
				if(rdbtnMale.isSelected()) {
					Gender = "Male";
				}else {
					Gender = "Female";
				}
				
				DOB = textdob.getText();
				
				try {
					
					String url = "jdbc:mysql://localhost:3306/mydatabase";
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(url, username, password);	
					
					if(mobile.length()!=10) {
						JOptionPane.showMessageDialog(null, "Enter Valid Mobile Number");
					}else if(DOB.length()!=10) {
						JOptionPane.showMessageDialog(null, "Enter DOB in DD/MM/YYYY Format");
					}else if(Section.length()!=1) {
						JOptionPane.showMessageDialog(null, "Enter Valid Section as A or B'");
					}else {
						String query = "INSERT INTO `student`(`AdmissionNo`, `Name`, `Father`, `Class`, `Mother`, `Section`, `Mobile`, `Roll`, `Address`, `Gender`, `DOB`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
						stat = conn.prepareStatement(query);
						
						stat.setInt(1, admission_no);
						stat.setString(2, name);
						stat.setString(3, father);
						stat.setString(4, class_);
						stat.setString(5, mother);
						stat.setString(6, Section);
						stat.setString(7, mobile);
						stat.setString(8, roll);
						stat.setString(9, Address);
						stat.setString(10, Gender);
						stat.setString(11, DOB);
						
						stat.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Data Added");
					}
					conn.close();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSave.setBounds(390, 521, 100, 50);
		contentPane.add(btnSave);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClose.setBounds(550, 521, 100, 50);
		contentPane.add(btnClose);
		
		textClass = new JTextField();
		textClass.setFont(new Font("Tahoma", Font.BOLD, 14));
		textClass.setColumns(10);
		textClass.setBounds(190, 230, 300, 30);
		contentPane.add(textClass);
		
		textSection = new JTextField();
		textSection.setFont(new Font("Tahoma", Font.BOLD, 14));
		textSection.setColumns(10);
		textSection.setBounds(190, 274, 300, 30);
		contentPane.add(textSection);
	}
}
