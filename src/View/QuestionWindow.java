package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuestionWindow {

	private JFrame frame;
	private static main.Question question;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionWindow window = new QuestionWindow(question);
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
	public QuestionWindow(main.Question question) {
		this.question = question;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 409, 310);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextPane textArea = new JTextPane();
		textArea.setBackground(UIManager.getColor("Button.background"));
		textArea.setFont(new Font("SansSerif", Font.BOLD, 13));
		textArea.setEditable(false);
		textArea.setText(question.getQuestionText());
		textArea.setBounds(25, 6, 362, 71);
		panel.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\JAVA\\Quiztionnaire\\Images\\3.png"));
		lblNewLabel_1.setBounds(259, 140, 128, 128);
		panel.add(lblNewLabel_1);
		
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("A ");
		rdbtnNewRadioButton.setText(question.getRightAnswerText());
		rdbtnNewRadioButton.setBackground(UIManager.getColor("Button.background"));
		rdbtnNewRadioButton.setFont(new Font("SansSerif", Font.BOLD, 13));
		rdbtnNewRadioButton.setBounds(25, 83, 362, 18);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Á ");
		rdbtnNewRadioButton_1.setText(question.getWrongAnswerText1());
		rdbtnNewRadioButton_1.setBackground(UIManager.getColor("Button.background"));
		rdbtnNewRadioButton_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		rdbtnNewRadioButton_1.setBounds(25, 113, 362, 18);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Â ");
		rdbtnNewRadioButton_2.setText(question.getWrongAnswerText2());
		rdbtnNewRadioButton_2.setBackground(UIManager.getColor("Button.background"));
		rdbtnNewRadioButton_2.setFont(new Font("SansSerif", Font.BOLD, 13));
		rdbtnNewRadioButton_2.setBounds(25, 140, 362, 18);
		panel.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Ã ");
		rdbtnNewRadioButton_3.setText(question.getWrongAnswerText3());
		rdbtnNewRadioButton_3.setBackground(UIManager.getColor("Button.background"));
		rdbtnNewRadioButton_3.setFont(new Font("SansSerif", Font.BOLD, 13));
		rdbtnNewRadioButton_3.setBounds(25, 170, 281, 18);
		panel.add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton = new JButton("\u041F\u043E\u0442\u0432\u044A\u0434\u0440\u0438");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnNewRadioButton.isSelected()) {
				Questions.countRight++;
				}
				
				frame.setVisible(false);
			}
		});
		
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnNewButton.setBounds(141, 220, 102, 28);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("AAAAA");
		lblNewLabel.setBackground(SystemColor.desktop);
		lblNewLabel.setIcon(new ImageIcon("D:\\JAVA\\Quiztionnaire\\Images\\fresh-green-background-Questionboxxxx.jpg"));
		lblNewLabel.setBounds(0, 0, 393, 271);
		panel.add(lblNewLabel);
	}
}
