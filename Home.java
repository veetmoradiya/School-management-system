import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	String username = "	";
	public JLabel lblName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 568);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(147, 112, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1000, 22);
		contentPane.add(menuBar);
		
		JMenu mnSettings = new JMenu("Settings");
		mnSettings.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnSettings);
		
		JMenuItem mntmCreatUser = new JMenuItem("Create User");
		mntmCreatUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Createuser c1 = new Createuser();
				c1.setVisible(true);
			}
		});
		mntmCreatUser.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnSettings.add(mntmCreatUser);
		
		JMenuItem mntmCreateClass = new JMenuItem("Create Class");
		mntmCreateClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Createclass c = new Createclass();
				c.setVisible(true);
			}
		});
		mntmCreateClass.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnSettings.add(mntmCreateClass);
		
		JMenu mnNewMenu = new JMenu("Student");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAdmission = new JMenuItem("Admission");
		mntmAdmission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admission ad = new admission();
				ad.setVisible(true);
			}
		});
		mntmAdmission.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmAdmission);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Modify Student");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnTeacher = new JMenu("Teacher");
		mnTeacher.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnTeacher);
		
		JMenuItem mntmAddTeacher = new JMenuItem("Add Teacher");
		mntmAddTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTeacher te = new AddTeacher();
				te.setVisible(true);
			}
		});
		mntmAddTeacher.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnTeacher.add(mntmAddTeacher);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Modify Teacher");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modifyteacher t = new Modifyteacher();
				t.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnTeacher.add(mntmNewMenuItem_1);
		
		JMenu mnFee = new JMenu("Fee");
		mnFee.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnFee);
		
		JMenuItem mntmSubmitFee = new JMenuItem("Submit Fee");
		mntmSubmitFee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubmitFee f1 = new SubmitFee();
				f1.setVisible(true);
			}
		});
		mntmSubmitFee.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnFee.add(mntmSubmitFee);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Modify Fee");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyFee f = new ModifyFee();
				f.setVisible(true);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnFee.add(mntmNewMenuItem_2);
		
		JMenu mnPayment = new JMenu("Payment");
		mnPayment.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnPayment);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Teacher Payment");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Payment p = new Payment();
				p.setVisible(true);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnPayment.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Modify Payment");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyPayment p = new ModifyPayment();
				p.setVisible(true);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnPayment.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_1 = new JMenu("Student Record");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmViewStudent = new JMenuItem("View Student Record");
		mntmViewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentRecord s1 = new StudentRecord();
				s1.setVisible(true);
			}
		});
		mntmViewStudent.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_1.add(mntmViewStudent);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("View Fee Record");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FeeRecord r = new FeeRecord();
				r.setVisible(true);
			}
		});
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("Teacher Record");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("View Teacher Record");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherRecord t = new TeacherRecord();
				t.setVisible(true);
			}
		});
		mntmNewMenuItem_6.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("View Payment Record");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaymentRecord r = new PaymentRecord();
				r.setVisible(true);
			}
		});
		mntmNewMenuItem_7.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenu mnLogOut = new JMenu("Logout");
		mnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				
				Login l = new Login();
				l.setVisible(true);
			}
		});
		mnLogOut.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnLogOut);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcome.setBounds(10, 32, 69, 22);
		contentPane.add(lblWelcome);
		
		lblName = new JLabel("");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(88, 32, 139, 22);
		contentPane.add(lblName);
	}

	public void SetString(String str) {
		lblName.setText(str);
//		System.out.println(this.username);
	}
}
