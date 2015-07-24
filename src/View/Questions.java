package View;

import java.awt.EventQueue;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import controller.Controller;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;


public class Questions {

	private JFrame frmTest;
	private static Controller controller;
	private static ArrayList<main.Question> questions;
	static int countRight;

	/**
	 * Launch the application.
	 */
	public Questions(Controller controller, ArrayList<main.Question> questions) {
		this.controller = controller;
		this.questions = questions;
		initialize();
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Questions window = new Questions(controller, questions);
					window.frmTest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @param controller
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTest = new JFrame();
		frmTest.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"D:\\Java\\Quiztionnaire\\Images\\Help-icon.png"));
		frmTest.setResizable(false);
		frmTest.setTitle("Тест");
		frmTest.setBounds(100, 100, 860, 414);
		frmTest.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		
		frmTest.getContentPane().setLayout(null);

		if (Menu.subject.equals("История")) {
			JLabel lblNewLabel_5 = new JLabel("istoriq");
			lblNewLabel_5.setIcon(new ImageIcon(
					"D:\\JAVA\\Quiztionnaire\\Images\\istoriq.jpg"));
			lblNewLabel_5.setBounds(657, 1, 197, 385);
			frmTest.getContentPane().add(lblNewLabel_5);
			lblNewLabel_5.setVisible(true);
		} else if (Menu.subject.equals("ИТ")) {
			JLabel lblNewLabel_4 = new JLabel("IT");
			lblNewLabel_4.setIcon(new ImageIcon(
					"D:\\JAVA\\Quiztionnaire\\Images\\informatika.jpg"));
			lblNewLabel_4.setBounds(657, 1, 197, 385);
			frmTest.getContentPane().add(lblNewLabel_4);
			lblNewLabel_4.setVisible(true);
		} else if (Menu.subject.equals("География")) {
			JLabel lblNewLabel_3 = new JLabel("geogirafiq");
			lblNewLabel_3.setIcon(new ImageIcon(
					"D:\\JAVA\\Quiztionnaire\\Images\\geografiq.jpg"));
			lblNewLabel_3.setBounds(657, 0, 197, 386);
			frmTest.getContentPane().add(lblNewLabel_3);
			lblNewLabel_3.setVisible(true);
		} else if (Menu.subject.equals("Биология")) {
			JLabel lblNewLabel_1 = new JLabel("biologiq");
			lblNewLabel_1.setIcon(new ImageIcon(
					"D:\\JAVA\\Quiztionnaire\\Images\\bilogiq.jpg"));
			lblNewLabel_1.setBounds(657, 0, 197, 386);
			frmTest.getContentPane().add(lblNewLabel_1);
			lblNewLabel_1.setVisible(true);
		} else if (Menu.subject.equals("Английски")) {
			JLabel lblNewLabel_2 = new JLabel("angliiski");
			lblNewLabel_2.setIcon(new ImageIcon(
					"D:\\JAVA\\Quiztionnaire\\Images\\angliiski.jpg"));
			lblNewLabel_2.setBounds(660, 1, 194, 385);
			frmTest.getContentPane().add(lblNewLabel_2);
			
			lblNewLabel_2.setVisible(true);
		}
		
		final JButton butt1 = new JButton("1");
		butt1.setFont(new Font("SansSerif", Font.BOLD, 16));
		butt1.setBounds(0, 1, 162, 76);
		butt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionWindow a = new QuestionWindow(questions.get(0));
				a.main(null);
				butt1.setEnabled(false);
			}
		});
		
		frmTest.getContentPane().add(butt1);
		
		
		final JButton butt2 = new JButton("2");
		butt2.setFont(new Font("SansSerif", Font.BOLD, 16));
		butt2.setBounds(162, 1, 162, 76);
		butt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionWindow a = new QuestionWindow(questions.get(1));
				a.main(null);
				butt2.setEnabled(false);
			}
		});
		frmTest.getContentPane().add(butt2);

		final JButton butt3 = new JButton("3");
		butt3.setFont(new Font("SansSerif", Font.BOLD, 16));
		butt3.setBounds(324, 1, 162, 76);
		butt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionWindow a = new QuestionWindow(questions.get(2));
				a.main(null);
				butt3.setEnabled(false);
			}
		});
		frmTest.getContentPane().add(butt3);

		final JButton button4 = new JButton("4");
		button4.setFont(new Font("SansSerif", Font.BOLD, 16));
		button4.setBounds(486, 1, 162, 76);
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionWindow a = new QuestionWindow(questions.get(3));
				a.main(null);
				button4.setEnabled(false);
			}
		});
		frmTest.getContentPane().add(button4);

		final JButton butt5 = new JButton("5");
		butt5.setFont(new Font("SansSerif", Font.BOLD, 16));
		butt5.setBounds(0, 77, 162, 76);
		butt5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionWindow a = new QuestionWindow(questions.get(4));
				a.main(null);
				butt5.setEnabled(false);
			}
		});
		frmTest.getContentPane().add(butt5);

		final JButton butt6 = new JButton("6");
		butt6.setFont(new Font("SansSerif", Font.BOLD, 16));
		butt6.setBounds(162, 77, 162, 76);
		butt6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionWindow a = new QuestionWindow(questions.get(5));
				a.main(null);
				butt6.setEnabled(false);
			}
		});
		frmTest.getContentPane().add(butt6);

		final JButton butt7 = new JButton("7");
		butt7.setFont(new Font("SansSerif", Font.BOLD, 16));
		butt7.setBounds(324, 77, 162, 76);
		butt7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionWindow a = new QuestionWindow(questions.get(6));
				a.main(null);
				butt7.setEnabled(false);
			}
		});
		frmTest.getContentPane().add(butt7);

		final JButton butt8 = new JButton("8");
		butt8.setFont(new Font("SansSerif", Font.BOLD, 16));
		butt8.setBounds(486, 77, 162, 76);
		butt8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionWindow a = new QuestionWindow(questions.get(7));
				a.main(null);
				butt8.setEnabled(false);
			}
		});
		frmTest.getContentPane().add(butt8);

		final JButton butt9 = new JButton("9");
		butt9.setFont(new Font("SansSerif", Font.BOLD, 16));
		butt9.setBounds(0, 153, 162, 76);
		butt9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionWindow a = new QuestionWindow(questions.get(8));
				a.main(null);
				butt9.setEnabled(false);
			}
		});
		frmTest.getContentPane().add(butt9);

		final JButton butt16 = new JButton("16");
		butt16.setFont(new Font("SansSerif", Font.BOLD, 16));
		butt16.setBounds(486, 229, 162, 76);
		butt16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionWindow a = new QuestionWindow(questions.get(9));
				a.main(null);
				butt16.setEnabled(false);
			}
		});
		frmTest.getContentPane().add(butt9);

		final JButton butt11 = new JButton("11");
		butt11.setFont(new Font("SansSerif", Font.BOLD, 16));
		butt11.setBounds(324, 153, 162, 76);
		butt11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionWindow a = new QuestionWindow(questions.get(10));
				a.main(null);
				butt11.setEnabled(false);
			}
		});
		frmTest.getContentPane().add(butt11);

		final JButton butt12 = new JButton("12");
		butt12.setFont(new Font("SansSerif", Font.BOLD, 16));
		butt12.setBounds(486, 153, 162, 76);
		butt12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionWindow a = new QuestionWindow(questions.get(11));
				a.main(null);
				butt12.setEnabled(false);
			}
		});
		frmTest.getContentPane().add(butt12);

		final JButton butt13 = new JButton("13");
		butt13.setFont(new Font("SansSerif", Font.BOLD, 16));
		butt13.setBounds(0, 229, 162, 76);
		butt13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionWindow a = new QuestionWindow(questions.get(12));
				a.main(null);
				butt13.setEnabled(false);
			}
		});
		frmTest.getContentPane().add(butt13);

		final JButton butt10 = new JButton("10");
		butt10.setFont(new Font("SansSerif", Font.BOLD, 16));
		butt10.setBounds(162, 153, 162, 76);
		butt10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionWindow a = new QuestionWindow(questions.get(13));
				a.main(null);
				butt10.setEnabled(false);
			}
		});
		frmTest.getContentPane().add(butt10);

		final JButton butt15 = new JButton("15");
		butt15.setFont(new Font("SansSerif", Font.BOLD, 16));
		butt15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionWindow a = new QuestionWindow(questions.get(14));
				a.main(null);
				butt15.setEnabled(false);
			}
		});
		butt15.setBounds(324, 229, 162, 76);
		frmTest.getContentPane().add(butt15);
		frmTest.getContentPane().add(butt16);

		final JButton butt14 = new JButton("14");
		butt14.setFont(new Font("SansSerif", Font.BOLD, 16));
		butt14.setBounds(162, 229, 162, 76);
		butt14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionWindow a = new QuestionWindow(questions.get(15));
				a.main(null);
				butt14.setEnabled(false);
			}
		});
		frmTest.getContentPane().add(butt14);

		JButton subButt = new JButton(
				"\u041F\u0440\u0435\u0434\u0430\u0439 \u0442\u0435\u0441\u0442\u0430");
		subButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
				Date date = new Date();
				String currentDate = dateFormat.format(date);
				
				
				int grade = (int) (100 * (countRight / 16.0));
				JOptionPane.showMessageDialog(frmTest, "Вашият резултат е: "
						+ grade + "%", "Резултат",
						JOptionPane.INFORMATION_MESSAGE);

				frmTest.setVisible(false);
			
				int id = controller.getID(Login.username_string);
			
				try {
					controller.insertTest(Menu.subject, currentDate, grade, id);
				} catch (SQLException | MessagingException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					controller.sendEmail(Login.username_string);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (AddressException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				countRight = 0;
			}
			
		});
		subButt.setFont(new Font("SansSerif", Font.BOLD, 16));
		subButt.setBounds(162, 317, 324, 51);
		frmTest.getContentPane().add(subButt);

		JLabel label = new JLabel("New label");
		label.setBounds(-17, 1, 33, 14);
		frmTest.getContentPane().add(label);

		JLabel lblNewLabel = new JLabel("label");
		lblNewLabel
				.setIcon(new ImageIcon(
						"D:\\JAVA\\Quiztionnaire\\Images\\fresh-green-background-question.jpg"));
		lblNewLabel.setBounds(0, 2, 854, 384);
		frmTest.getContentPane().add(lblNewLabel);
	}
}
