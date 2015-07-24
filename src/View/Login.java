package View;

import controller.Controller;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import java.sql.SQLException;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import main.User;

public class Login {

	private static JFrame frmAsds;
	private static JTextField username_f;
	private static JPasswordField password_f;
	private static Controller controller = null;
	public static String username_string;

	/**
	 * Constructor
	 * @param controller
	 */
	public Login(Controller controller) {
		this.controller = controller;
		initialize();
	}
/**
 * Void method that initializes the main window, including the frames and labels.
 */
		public static void initialize() {
		frmAsds = new JFrame();
		frmAsds.setBackground(SystemColor.activeCaption);
		frmAsds.setResizable(false);
		frmAsds.setTitle("Quiztionnaire 69");
		frmAsds.setBounds(100, 100, 400, 300);
		frmAsds.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAsds.getContentPane().setLayout(null);

		username_f = new JTextField();
		username_f.setBounds(118, 73, 126, 26);
		frmAsds.getContentPane().add(username_f);
		username_f.setColumns(10);

		JLabel lblNewLabel = new JLabel("\u041F\u043E\u0442\u0440\u0435\u0431\u0438\u0442\u0435\u043B:");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 76, 85, 20);
		frmAsds.getContentPane().add(lblNewLabel);

		JLabel lblPassword = new JLabel("\u041F\u0430\u0440\u043E\u043B\u0430:");
		lblPassword.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setBounds(10, 121, 71, 20);
		frmAsds.getContentPane().add(lblPassword);

		JButton btnLogin = new JButton("\u0412\u0445\u043E\u0434");
		btnLogin.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				 username_string = username_f.getText();
				 username_f.selectAll();
				 char[] password_char = password_f.getPassword();
				 password_f.selectAll();
				 String password = new String(password_f.getPassword());
			
				 boolean checkLogIn = controller.checkLogIn(username_string,password);
				
				if (!checkLogIn){
					JOptionPane.showMessageDialog(frmAsds,
							"Грешно име или парола.", "Грешка!",
							JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					Menu a=null;
					try {
					a = new Menu(controller);
					} catch (SQLException | MessagingException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					a.runn();
					frmAsds.setVisible(false);
				}

			}
		});
		btnLogin.setBounds(24, 226, 126, 26);
		frmAsds.getContentPane().add(btnLogin);

		JButton btnRegister = new JButton("\u0420\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u044F");
		btnRegister.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				Register register = new Register(controller);
				frmAsds.setVisible(false);
			}
		});
		btnRegister.setBounds(247, 226, 126, 26);
		frmAsds.getContentPane().add(btnRegister);

		password_f = new JPasswordField();
		password_f.setBounds(118, 118, 126, 26);
		frmAsds.getContentPane().add(password_f);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\JAVA\\Quiztionnaire\\Images\\1.png"));
		lblNewLabel_1.setBounds(253, 24, 120, 155);
		frmAsds.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u0417\u0434\u0440\u0430\u0432\u0435\u0438\u0442\u0435!<br>T\u043E\u0432\u0430 \u0435 \u0430\u0432\u0442\u043E\u043C\u0430\u0442\u0438\u0447\u043D\u043E \u0441\u044A\u043E\u0431\u0449\u0435\u043D\u0438\u0435, \u043A\u043E\u0435\u0442\u043E \u0441\u044A\u0434\u044A\u0440\u0436\u0430 \u0440\u0435\u0437\u0443\u043B\u0442\u0430\u0442\u0438 \u043E\u0442 \u0442\u0435\u0441\u0442\u0430 \u043D\u0430");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\JAVA\\Quiztionnaire\\Images\\fresh-green-background1.png"));
		lblNewLabel_2.setBounds(0, -4, 394, 275);
		frmAsds.getContentPane().add(lblNewLabel_2);

		frmAsds.setVisible(true);
	}
}