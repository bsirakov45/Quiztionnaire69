package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import database.DatabaseManager;

public class Controller {
	public DatabaseManager manager = null;

	public Controller() {
		this.manager = new DatabaseManager();
	}
	
	
/**
 * The method returns true if name and password already exist in 
 * the database system or false, if they don't. 
 * @param names
 * @param password
 * @return true/false
 */
	public boolean checkNameAndPasswordExist(String name, String password) {
		int counter = this.manager.checkNameAndPasswordExist(name, password);
		if (counter!=0)
		return true;
		else return false;
		
	}

	/**
	 * The method checks if name already exists in the database 
	 * using the counter variable. The counter variable=0 if name
	 * doesn't exist in the database, or false, if it exists. 
	 * @param name
	 * @return true/false
	 */
	public boolean checkNameExist(String name) {
		int counter = this.manager.checkNameExist(name);
		if (counter!=0)
			return true;
			else return false;
	}
	
	/**The method adds a new user with their corresponding username,
	 * password and email to the database. 
	 * @param username
	 * @param password
	 * @param email
	 */
	public void addNewUser(String username, String password, String email) {
		this.manager.addDeveloper(username, password, email);
	}
	
	/**
	 * The method uses sendEmail to send an email to the user's email. 
	 * @param name
	 * @throws SQLException
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void sendEmail(String name) throws SQLException, AddressException, MessagingException {
		this.manager.sendEmail(name);
	
	}
	
	/**
	 * The method checks if the user has already logged in or not.
	 * @param name
	 * @param password
	 * @return true/false
	 */
	public boolean checkLogIn (String name, String password){
		int counter = this.manager.LogIn(name,password);
		if(counter==1)
			return true;
		else return false;
	}
	/**
	 * The method returns arrayList with student's grades history.
	 * @param name
	 * @return arrayList
	 * @throws SQLException
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public ArrayList<DatabaseManager.grHistory> gradeHistory(String name) throws SQLException, AddressException, MessagingException {
		ArrayList<DatabaseManager.grHistory> A = this.manager.gradeHistory(name);
		return A;
	
	}

/**
 * The method returns a question from the database system.
 * @param subject
 * @return arraylist
 * @throws SQLException
 * @throws AddressException
 * @throws MessagingException
 */
public ArrayList<main.Question> getQuestion(String subject) throws SQLException, AddressException, MessagingException {
	ArrayList<main.Question> A = this.manager.getQuestion(subject);
	return A;

	}

/**
 * The method returns the id, corresponding to the name, as parameter. 
 * @param name
 * @return int id
 */
public int getID(String name) {
	int id = this.manager.getID(name);
	return id;
	}

/**
 * The method inserts test into the database with the result, corresponding to it. 
 * @param subject
 * @param date
 * @param grade
 * @param student_id
 * @throws SQLException
 * @throws AddressException
 * @throws MessagingException
 */
public void insertTest(String subject, String date,int grade,int student_id) throws SQLException, AddressException, MessagingException {
	this.manager.addTest(subject,date,grade,student_id);

	}
}