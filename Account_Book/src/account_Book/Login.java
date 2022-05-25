package account_Book;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class Login {

	private JFrame frame;
	private JTextField id;
	private JLabel lblNewLabel_1;
	private JPasswordField password;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(new Dimension(408, 275));
		frame.setLocationRelativeTo(null); // ó�� ���� ��ġ = ȭ�� ���
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/* �� */
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblNewLabel.setBounds(119, 76, 28, 16);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(69, 112, 78, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		/* id �� password �Է¹ޱ� */
		id = new JTextField();
		id.setBounds(159, 74, 116, 21);
		frame.getContentPane().add(id);
		id.setColumns(10);
					
		password = new JPasswordField();
		password.setBounds(159, 110, 116, 21);
		frame.getContentPane().add(password);
		
		JButton logIN = new JButton("LogIN");
		logIN.setBounds(133, 161, 97, 23);
		
		/* ��ư�� Ŭ���� ��*/
		logIN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String p =new String(password.getPassword()); // .getPassword()�� char[]Ÿ������ ����
				if (DB.logIn(id.getText(), p) == true) {	// DB �α���
					MainFrame m = new MainFrame();
					m.setVisible(true);
					frame.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "ID Ȥ�� Password�� Ʋ�Ƚ��ϴ�.");
				}
			}
		});
		
		frame.getContentPane().add(logIN);
	}
}
