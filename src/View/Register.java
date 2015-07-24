package View;

import controller.Controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Register {

	private JFrame frmRegistration;
	private JTextField reg_username;
	private JTextField parent_email;
	private JPasswordField reg_password;
	private JPasswordField conf_password;
	private Controller controller;

	public Register(Controller controller) {

		this.controller = controller;
		initialize();
	}

	/**
	 * Initializes the content of the frame for the register window.
	 */
	private void initialize() {
		frmRegistration = new JFrame();
		frmRegistration.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 14));
		frmRegistration.getContentPane().setForeground(new Color(173, 216, 230));
		frmRegistration.setForeground(SystemColor.activeCaption);
		frmRegistration.setTitle("\u0420\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u044F");
		frmRegistration.setResizable(false);
		frmRegistration.setBounds(100, 100, 450, 300);
		frmRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistration.getContentPane().setLayout(null);
		
		JButton button = new JButton("\u041D\u0430\u0437\u0430\u0434");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmRegistration.setVisible(false);
				Login.initialize();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBounds(31, 226, 119, 26);
		frmRegistration.getContentPane().add(button);

		reg_username = new JTextField();
		reg_username.setHorizontalAlignment(SwingConstants.LEFT);
		reg_username.setBounds(166, 63, 119, 26);
		frmRegistration.getContentPane().add(reg_username);
		reg_username.setColumns(10);

		JLabel lblUsername = new JLabel("\u041F\u043E\u0442\u0440\u0435\u0431\u0438\u0442\u0435\u043B:");
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 13));
		lblUsername.setBounds(31, 64, 85, 21);
		frmRegistration.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("\u041F\u043E\u0432\u0442\u043E\u0440\u0438 \u043F\u0430\u0440\u043E\u043B\u0430:");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 13));
		lblPassword.setBounds(31, 129, 111, 20);
		frmRegistration.getContentPane().add(lblPassword);

		parent_email = new JTextField();
		parent_email.setBounds(166, 159, 119, 26);
		frmRegistration.getContentPane().add(parent_email);
		parent_email.setColumns(10);

		JLabel lblParrentsEmail = new JLabel("\u0420\u043E\u0434\u0438\u0442\u0435\u043B\u0441\u043A\u0438 e-mail:");
		lblParrentsEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		lblParrentsEmail.setBounds(31, 160, 131, 20);
		frmRegistration.getContentPane().add(lblParrentsEmail);

		JButton btnNewButton = new JButton("\u0420\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u044F");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (reg_username.getText().trim().equals("")||reg_password.getPassword().length==0||conf_password.getPassword().length==0||
						parent_email.getText().trim().equals("")){
					JOptionPane.showMessageDialog(frmRegistration,
							"Моля попълнете всички полета!", "Грешка",
							JOptionPane.ERROR_MESSAGE);
				}
				else if (reg_username.getText().trim().length()>1 && reg_username.getText().trim().length()<4){
					JOptionPane.showMessageDialog(frmRegistration,
							"Името трябва да съдържа поне 4 символа", "Грешка",
							JOptionPane.ERROR_MESSAGE);
				}
				
				else if(!parent_email.getText().trim().contains("@")){
					JOptionPane.showMessageDialog(frmRegistration,
							"Невалиден e-mail", "Грешка",
							JOptionPane.ERROR_MESSAGE);
				}
				else if (reg_password.getPassword().length>1 && reg_password.getPassword().length<4){
					JOptionPane.showMessageDialog(frmRegistration,
							"Паролата трябва да съдържа поне 4 символа", "Грешка",
							JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					char[] reg_char = reg_password.getPassword();
					reg_password.selectAll();

					char[] conf_char = conf_password.getPassword();
					conf_password.selectAll();

					String name = reg_username.getText();
					String password = new String(reg_password.getPassword());
					String email = parent_email.getText();					
					boolean retVal = Arrays.equals(conf_char, reg_char);
					boolean checkUserExist = controller.checkNameExist(name);
					if (checkUserExist){
						JOptionPane.showMessageDialog(frmRegistration,
								"Това име вече е заето! Изберете друго име.", "Грешка",
								JOptionPane.ERROR_MESSAGE);
					}
					else if (!checkUserExist && retVal) {
						controller.addNewUser(name, password, email);
						JOptionPane.showMessageDialog(frmRegistration,
								"Успешна регистрация!", "Поздравления!",
								JOptionPane.INFORMATION_MESSAGE);
						frmRegistration.setVisible(false);
						Login.initialize();
						
					} 
					else if (!checkUserExist && !retVal){
						JOptionPane.showMessageDialog(frmRegistration,
								"Невалидна парола! Опитайте отново.", "Грешка",
								JOptionPane.ERROR_MESSAGE);
					}
			
				}
		
			}
		});
		btnNewButton.setBounds(298, 226, 119, 26);
		frmRegistration.getContentPane().add(btnNewButton);

		JLabel label = new JLabel("\u041F\u0430\u0440\u043E\u043B\u0430:");
		label.setFont(new Font("Dialog", Font.BOLD, 13));
		label.setBounds(31, 97, 79, 20);
		frmRegistration.getContentPane().add(label);

		reg_password = new JPasswordField();
		reg_password.setBounds(166, 96, 119, 26);
		frmRegistration.getContentPane().add(reg_password);

		conf_password = new JPasswordField();
		conf_password.setBounds(166, 128, 119, 26);
		frmRegistration.getContentPane().add(conf_password);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\JAVA\\Quiztionnaire\\Images\\2.png"));
		lblNewLabel.setBounds(306, 48, 111, 158);
		frmRegistration.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\JAVA\\Quiztionnaire\\Images\\fresh-green-background2.jpg"));
		lblNewLabel_1.setBounds(0, 0, 444, 271);
		frmRegistration.getContentPane().add(lblNewLabel_1);

		frmRegistration.setVisible(true);
	}
}