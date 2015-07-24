package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import main.Constants;
import SMTP.smtp;
public class DatabaseManager {
	private Connection conn = null;

	public DatabaseManager() {
		try {
			Class.forName(Constants.JDBC_DRIVER);

			this.conn = DriverManager.getConnection(Constants.DB_URL,
					Constants.DB_USERNAME, Constants.DB_PASSWORD);
			this.conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public class grHistory{
		public String subject;
		public int grade;
		public String date;
		
		public grHistory(String date,String subject,int grade){
			this.subject = subject;
			this.grade = grade;
			this.date = date;
		}
	}
	
	
	/**
	 * method that checks if the name and password already exist in the database.
	 * @param name
	 * @param password
	 * @return
	 */
	public int checkNameAndPasswordExist(String name, String password) {
		String checkCount = "SELECT COUNT(*) FROM users WHERE name=? AND password=?";
		PreparedStatement checkUser = null;
		ResultSet resultSet = null;
		int counter = 0;
		try {
			checkUser = this.conn.prepareStatement(checkCount);
			checkUser.setString(1, name);
			checkUser.setString(2, password);
			resultSet = checkUser.executeQuery();

			while (resultSet.next()) {
				counter = resultSet.getInt("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return counter;
	}

	public int checkNameExist(String name) {
		String checkCount = "SELECT COUNT(*) FROM users WHERE name=?";
		PreparedStatement checkUser = null;
		ResultSet resultSet = null;
		int counter = 0;
		try {
			checkUser = this.conn.prepareStatement(checkCount);
			checkUser.setString(1, name);
			resultSet = checkUser.executeQuery();

			while (resultSet.next()) {
				counter = resultSet.getInt("count(*)");
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return counter;
	}

	/**
	 * method that adds another user to the database
	 * @param name
	 * @param password
	 * @param email
	 */
	public void addDeveloper(String name, String password, String email) {
		String insertQuery = "INSERT INTO users (name, password, email) VALUES(?, ?, ?)";
		PreparedStatement insertUser = null;

		try {
			insertUser = this.conn.prepareStatement(insertQuery);
			insertUser.setString(1, name);
			insertUser.setString(2, password);
			insertUser.setString(3, email);

			insertUser.executeUpdate();
			this.conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * method that sends an email with the data corresponding to the current user and test.
	 * @param name
	 * @throws SQLException
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void sendEmail(String name) throws SQLException, AddressException, MessagingException {
		String checkCount = "select subject,grade,email from tests join users on tests.student_id = users.id where tests.student_id in (select id from users where name =?) group by tests.id order by tests.id desc limit 1";
		PreparedStatement checkUser = null;
		ResultSet resultSet = null;
		int grade = 0;
		String email = null;
		String subject = null;

		
		checkUser = this.conn.prepareStatement(checkCount);
		checkUser.setString(1, name);
		resultSet = checkUser.executeQuery();
		try {
			while (resultSet.next()) {
				subject = resultSet.getString("subject");
				grade = resultSet.getInt("grade");
				email = resultSet.getString("email");
				
				
				smtp sendemail = new smtp();
				sendemail.generateAndSendEmail(name,subject,grade,email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	/**
	 * method that checks if such user exists in the network.
	 * @param name
	 * @param password
	 * @return
	 */
	public int LogIn(String name,String password){
		String checkLogin = "SELECT COUNT(*) FROM users WHERE name=? and password =?";
		PreparedStatement checkUser = null;
		ResultSet resultSet = null;
		int counter = 0;
		
		try {
			
			checkUser = this.conn.prepareStatement(checkLogin);
			checkUser.setString(1, name);
			checkUser.setString(2, password);
			resultSet = checkUser.executeQuery();
			
			while (resultSet.next()) {
				counter = resultSet.getInt("count(*)");
			}
		
		} catch (SQLException e) {
		e.printStackTrace();
		}

		return counter;
	}
	
	/**
	 * method that returns an arraylist with user's grades.
	 * @param name
	 * @return
	 */
	public ArrayList gradeHistory(String name){
		
		String subject = null;
		int grade = 0;
		String date = null;
		
		ArrayList<grHistory> result = new ArrayList<grHistory>();
		
		String checkLogin = "SELECT test_date, subject,grade from tests WHERE student_id in (select id from users where name =?) order by test_date desc limit 9";
		PreparedStatement checkUser = null;
		ResultSet resultSet = null;
		
	
	try {
			checkUser = this.conn.prepareStatement(checkLogin);
			checkUser.setString(1, name);
			resultSet = checkUser.executeQuery();
			
			while (resultSet.next()) {
				subject = resultSet.getString("subject");
				grade = resultSet.getInt("grade");
				date = resultSet.getString("test_date");
				
				grHistory A = new grHistory(date,subject,grade);
				result.add(A);
			}
	
		} catch (SQLException e) {
		e.printStackTrace();
		}
	
	return result;
	}
	
	public ArrayList getQuestion(String subject){
		
		ArrayList<main.Question> question = new ArrayList<main.Question>();
		String text = null;
		String rightanswer = null;
		String wrAns1 = null;
		String wrAns2 = null;
		String wrAns3 = null;
		int id=0;
		String checkLogin = "select id,text,rightanswer,wronganswer1,wronganswer2,wronganswer3 from questions where subject =? order by rand() limit 16 ";
		PreparedStatement checkUser = null;
		ResultSet resultSet = null;
		
	
	try {
			checkUser = this.conn.prepareStatement(checkLogin);
			checkUser.setString(1, subject);
			resultSet = checkUser.executeQuery();
			
			while (resultSet.next()) {
				text = resultSet.getString("text");
				rightanswer = resultSet.getString("rightanswer");
				wrAns1 = resultSet.getString("wronganswer1");
				wrAns2 = resultSet.getString("wronganswer2");
				wrAns3 = resultSet.getString("wronganswer3");
				id = resultSet.getInt("id");
				
				main.Question A = new main.Question(id,text,rightanswer,wrAns1,wrAns2,wrAns3);
				question.add(A);
			}
	
		} catch (SQLException e) {
		e.printStackTrace();
		}
	
	return question;
	}
	
public int getID(String name) {
	String checkCount = "SELECT id from users WHERE name=?";
	PreparedStatement checkUser = null;
	ResultSet resultSet = null;
	int ID = 0;
	try {
		checkUser = this.conn.prepareStatement(checkCount);
		checkUser.setString(1, name);
		resultSet = checkUser.executeQuery();

		while (resultSet.next()) {
			ID = resultSet.getInt("id");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return ID;
}

public void addTest(String subject, String date,int grade,int student_id) {
	
	String insertQuery = "INSERT INTO tests (subject,test_date,grade,student_id) VALUES(?, ?, ?,?)";
	PreparedStatement insertTest = null;

	try {
		insertTest = this.conn.prepareStatement(insertQuery);
		insertTest.setString(1, subject);
		insertTest.setString(2, date);
		insertTest.setInt(3, grade);
		insertTest.setInt(4, student_id);

		insertTest.executeUpdate();
		this.conn.commit();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}