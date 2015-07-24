package View;

import java.awt.EventQueue;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import controller.Controller;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import database.DatabaseManager;
import javax.swing.ImageIcon;

public class Menu {


	static ArrayList<main.Question>  B =null;
	private JFrame frmMenu;
	private JLabel SubjectLabel;
	private Controller controller;
	private JTable table;
	static String subject;

	/**
	 * Launch the application.
	 * @throws MessagingException 
	 * @throws SQLException 
	 * @throws AddressException 
	 */
	
	public Menu(Controller controller) throws AddressException, SQLException, MessagingException {
		this.controller = controller;
		initialize();
	}
	/**
	 * method that invokes the main menu window
	 */
	public void runn(){ 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu(controller);
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 * @throws MessagingException 
	 * @throws SQLException 
	 * @throws AddressException 
	 */
	public void initialize() throws AddressException, SQLException, MessagingException {
		frmMenu = new JFrame();
		frmMenu.setTitle("\u041C\u0435\u043D\u044E");
		frmMenu.setBounds(100, 100, 496, 311);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.getContentPane().setLayout(null);
		
		ArrayList<DatabaseManager.grHistory>  A = controller.gradeHistory(Login.username_string);
		
		
		JButton btnNewButton = new JButton("\u0418\u0437\u0445\u043E\u0434");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMenu.setVisible(false);
				Login.initialize();
			}
		});
		
		JLabel label = new JLabel("\u0418\u0441\u0442\u043E\u0440\u0438\u044F \u043D\u0430 \u043E\u0446\u0435\u043D\u043A\u0438\u0442\u0435:");
		label.setToolTipText("Select one of the topics below to begin a new test:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("SansSerif", Font.BOLD, 15));
		label.setBounds(53, 6, 189, 32);
		frmMenu.getContentPane().add(label);
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnNewButton.setBounds(90, 221, 114, 28);
		frmMenu.getContentPane().add(btnNewButton);
		
		SubjectLabel = new JLabel("\u0418\u0437\u0431\u0435\u0440\u0438 \u0442\u0435\u043C\u0430:");
		SubjectLabel.setToolTipText("Select one of the topics below to begin a new test:");
		SubjectLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		SubjectLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SubjectLabel.setBounds(254, 6, 189, 32);
		frmMenu.getContentPane().add(SubjectLabel);
		
		JButton biologyButt = new JButton("\u0411\u0438\u043E\u043B\u043E\u0433\u0438\u044F");
		biologyButt.setFont(new Font("SansSerif", Font.BOLD, 13));
		biologyButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subject = "Биология";
				ArrayList<main.Question> genQuestions = null;
				try {
					genQuestions = controller.getQuestion("Биология");
				} catch (SQLException | MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Questions questions= new Questions(controller, genQuestions);
				questions.main(null);
				
			}
		});
		biologyButt.setBounds(301, 43, 114, 32);
		frmMenu.getContentPane().add(biologyButt);
		
		JButton geoButt = new JButton("\u0413\u0435\u043E\u0433\u0440\u0430\u0444\u0438\u044F");
		geoButt.setFont(new Font("SansSerif", Font.BOLD, 13));
		geoButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subject = "География";
				ArrayList<main.Question> genQuestions = null;
				try {
					genQuestions = controller.getQuestion("География");
				} catch (SQLException | MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Questions questions= new Questions(controller, genQuestions);
				questions.main(null);
				
			}
		});
		geoButt.setBounds(301, 87, 114, 32);
		frmMenu.getContentPane().add(geoButt);
		
		JButton englishButt = new JButton("\u0410\u043D\u0433\u043B\u0438\u0439\u0441\u043A\u0438");
		englishButt.setFont(new Font("SansSerif", Font.BOLD, 13));
		englishButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subject = "Английски";
				ArrayList<main.Question> genQuestions = null;
				try {
					genQuestions = controller.getQuestion("Английски");
				} catch (SQLException | MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Questions questions= new Questions(controller, genQuestions);
				questions.main(null);	
			}
		});
		englishButt.setBounds(301, 131, 114, 32);
		frmMenu.getContentPane().add(englishButt);
		
		JButton itButt = new JButton("\u0418\u0422");
		itButt.setFont(new Font("SansSerif", Font.BOLD, 13));
		itButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subject = "ИТ";
				ArrayList<main.Question> genQuestions = null;
				try {
					genQuestions = controller.getQuestion("ИТ");
				} catch (SQLException | MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Questions questions= new Questions(controller, genQuestions);
				questions.main(null);
				
			}
		});
		itButt.setBounds(301, 175, 114, 32);
		frmMenu.getContentPane().add(itButt);
		
		JButton histButt = new JButton("\u0418\u0441\u0442\u043E\u0440\u0438\u044F");
		histButt.setFont(new Font("SansSerif", Font.BOLD, 13));
		histButt.setBounds(301, 219, 114, 32);
		histButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subject = "История";
				ArrayList<main.Question> genQuestions = null;
				try {
					genQuestions = controller.getQuestion("История");
				} catch (SQLException | MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Questions questions= new Questions(controller, genQuestions);
				questions.main(null);
				
			}
		});
		frmMenu.getContentPane().add(histButt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 37, 283, 172);
		frmMenu.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setSurrendersFocusOnKeystroke(true);
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		
		int size = A.size();
		
		Object[][] grades = new Object[9][3];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					grades[i][j] = A.get(i).date;
				}
				else if (j == 1) {
					grades[i][j] = A.get(i).subject;
				}
				else if (j == 2) {
					grades[i][j] = A.get(i).grade + "%";
				}
			}
		}
		for (int i = size; i < grades.length; i++) {
			for (int j = 0; j < 3; j++) {
				grades[i][j] = null;
			}
		}
		
		String[] nameOfColumns ={
				"\u0414\u0430\u0442\u0430", "\u041F\u0440\u0435\u0434\u043C\u0435\u0442", "\u041E\u0446\u0435\u043D\u043A\u0430"};
		

		table.setModel(new DefaultTableModel( grades, nameOfColumns) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(0).setMinWidth(120);
		table.getColumnModel().getColumn(0).setMaxWidth(120);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(1).setMaxWidth(100);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setMinWidth(60);
		table.getColumnModel().getColumn(2).setMaxWidth(60);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\JAVA\\Quiztionnaire\\Images\\fresh-green-background-menu.jpg"));
		lblNewLabel.setBounds(0, 0, 480, 272);
		frmMenu.getContentPane().add(lblNewLabel);
	}
}
