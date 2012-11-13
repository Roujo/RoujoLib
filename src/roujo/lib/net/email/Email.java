package roujo.lib.net.email;

/*
 Some SMTP servers require a username and password authentication before you
 can use their Server for Sending mail. This is most common with couple
 of ISP's who provide SMTP Address to Send Mail.

 This Program gives any example on how to do SMTP Authentication
 (User and Password verification)

 This is a free source code and is provided as it is without any warranties and
 it can be used in any your code for free.

 Author : Sudhir Ancha
 */

import java.util.LinkedList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 To use this program, change values for the following three constants,

 SMTP_HOST_NAME -- Has your SMTP Host Name
 SMTP_AUTH_USER -- Has your SMTP Authentication UserName
 SMTP_AUTH_PWD  -- Has your SMTP Authentication Password

 Next change values for fields

 emailMsgTxt  -- Message Text for the Email
 emailSubjectTxt  -- Subject for email
 emailFromAddress -- Email Address whose name will appears as "from" address

 Next change value for "emailList".
 This String array has List of all Email Addresses to Email Email needs to be sent to.


 Next to run the program, execute it as follows,

 SendMailUsingAuthentication authProg = new SendMailUsingAuthentication();

 */

public class Email {
	private Properties smtp_props;
	private SMTPAuthenticator smtp_auth;
	private LinkedList<String> recipients;
	private String subject;
	private String message;
	private String from;

	public Email(EmailProfile profile) {
		smtp_props = new Properties();
		smtp_props.put("mail.smtp.host", profile.smtp_host);
		smtp_props.put("mail.smtp.auth", "false");
		smtp_props.put("mail.smtp.starttls.enable","true");
		recipients = new LinkedList<String>();
	}
	
	public Email(EmailProfile profile, String password)
	{
		smtp_props = new Properties();
		smtp_props.put("mail.smtp.host", profile.smtp_host);
		smtp_props.put("mail.smtp.auth", "true");
		smtp_props.put("mail.smtp.starttls.enable","true");
		smtp_auth = new SMTPAuthenticator(profile.smtp_user, password);
		recipients = new LinkedList<String>();
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
	public void addRecipient(String address) {
		this.recipients.add(address);
	}
	
	public void removeRecipient(String address) {
		this.recipients.remove(address);
	}
	
	public void removeAllRecipients() {
		this.recipients.clear();
	}
	
	public void send() throws MessagingException {
		Session session = Session.getDefaultInstance(smtp_props, smtp_auth);
		boolean debug = false;
		session.setDebug(debug);
		
		// Create a message
		Message msg = new MimeMessage(session);
		
		// Set the From and To adresses
		msg.setFrom(new InternetAddress(from));
		InternetAddress[] addressTo = new InternetAddress[recipients.size()];
		for(int i = 0; i < addressTo.length; ++i) {
			addressTo[i] = new InternetAddress(recipients.get(i));
		}
		msg.setRecipients(Message.RecipientType.TO, addressTo);
		
		msg.setSubject(subject);
		msg.setContent(message, "text/plain");
		Transport.send(msg);
	}

	/**
	 * SimpleAuthenticator is used to do simple authentication when the SMTP
	 * server requires it.
	 */
	private static class SMTPAuthenticator extends javax.mail.Authenticator {

		private String username;
		private String password;
		
		public SMTPAuthenticator(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}
		
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	}

}
