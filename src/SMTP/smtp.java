package SMTP;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class smtp {
	
	/**
	 * The method generates and sends an email to the user with their 
	 * score,  given from the conducted test.
	 * @param name
	 * @param subject
	 * @param grade
	 * @param email
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void generateAndSendEmail(String name,String subject,int grade,String email) throws AddressException, MessagingException {
		 Properties mailServerProperties;
		 Session getMailSession;
		 MimeMessage generateMailMessage = null;
		
		// Step1
		
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		

		// Step2
	
	    
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

		
		//text
		String emailBody = "Здравейте!\nTова е автоматично съобщение, което съдържа резултати от теста на Quiztionnare 69.\n"
				+ "Име:"+name+"\n"
				+ "Предмет:"+subject+"\n"
				+ "Оценка:"+grade+"%.";
		
		generateMailMessage.setHeader("Content-type","text/plain; charset=UTF-8");
		generateMailMessage.setSubject("Тест по "+subject, "utf-8");
		generateMailMessage.setContent(emailBody, "text/plain; charset=UTF-8");
	
		

		// Step3
		Transport transport = getMailSession.getTransport("smtp");

	
		transport.connect("smtp.gmail.com", "quiztionnaire69@gmail.com", "46494649denis");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
}

