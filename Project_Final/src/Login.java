import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import loanassistance.LoanAssistant;

import java.sql.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
public class Login {

	private JFrame frame;
	private JTextField UsernametextField;
	private JPasswordField passwordField;
	private JButton clearButton;

	Connection connection = null;
	private JPasswordField accountField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		
		
		initialize();
		connection = The_Connection.dbconnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\JOSEPHINE BOAKYE\\Desktop\\Imagess\\bank-icon (2).png"));
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setBounds(100, 100, 852, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\JOSEPHINE BOAKYE\\Desktop\\Imagess\\Admin-icon.png"));
		lblNewLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(40, 65, 159, 51);
		frame.getContentPane().add(lblNewLabel);
		
		UsernametextField = new JTextField();
		UsernametextField.setToolTipText("Please enter your username");
		UsernametextField.setHorizontalAlignment(SwingConstants.CENTER);
		UsernametextField.setFont(new Font("Tahoma", Font.PLAIN, 21));
		UsernametextField.setBounds(217, 53, 283, 63);
		frame.getContentPane().add(UsernametextField);
		UsernametextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\JOSEPHINE BOAKYE\\Desktop\\Imagess\\Apps-password-icon.png"));
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.PLAIN, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(40, 157, 171, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Please enter your Password");
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(217, 149, 283, 63);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		loginButton.setForeground(new Color(128, 0, 0));
		loginButton.setBackground(Color.BLACK);
		loginButton.setIcon(new ImageIcon("C:\\Users\\JOSEPHINE BOAKYE\\Desktop\\Imagess\\ok-icon.png"));
		loginButton.setBounds(281, 369, 148, 39);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					try {
					String query = "Select * from LoanBalance where Username=? and Password=? and AccountNumber=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, UsernametextField.getText() );
					pst.setString(2, passwordField.getText() );
					pst.setString(3, accountField.getText() );
					
					ResultSet rst = pst.executeQuery();
					
					int count = 0;
					while (rst.next()) {
						count++;
					}
					if (count == 1) {
						JOptionPane.showMessageDialog(null, "UserName and Password is correct\n Click ok to continue");
						frame.dispose();
						LoanAssistant obj = new LoanAssistant();
						obj.setVisible(true);
						
					}
					else if (count >1) {
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(null, "Duplicate password and username");
						clearButton.setEnabled(true);
					}else {
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(null, "Incorrect details, please try again");
						clearButton.setEnabled(true);
						
					}
					pst.close();
					rst.close();
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(loginButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\JOSEPHINE BOAKYE\\Desktop\\Imagess\\bank-icon.png"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(531, 25, 306, 282);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Account Number");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\JOSEPHINE BOAKYE\\Desktop\\Imagess\\ok.png"));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 258, 201, 35);
		frame.getContentPane().add(lblNewLabel_3);
		
		accountField = new JPasswordField();
		accountField.setToolTipText("Enter a valid Account Number");
		accountField.setHorizontalAlignment(SwingConstants.CENTER);
		accountField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		accountField.setEchoChar('*');
		accountField.setBounds(221, 258, 283, 51);
		frame.getContentPane().add(accountField);
		
		clearButton = new JButton("C");
		clearButton.setToolTipText("Clear all fields");
		clearButton.setEnabled(false);
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			accountField.setText("");
			UsernametextField.setText("");
			passwordField.setText("");
			clearButton.setEnabled(false);
			UsernametextField.setFocusable(true);
			}
		});
		clearButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		clearButton.setBounds(458, 382, 52, 23);
		frame.getContentPane().add(clearButton);
	}
}
