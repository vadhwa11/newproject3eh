package jkt.hrms.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

class PopupAuthenticator extends Authenticator {

	public PasswordAuthentication getPasswordAuthentication() {

		return new PasswordAuthentication("egov@jkt.in",
				"Times@786");
	}
}

public class SendMail {

	public static boolean sendMail(String host, String addressTo,
			String addressFrom, String ccTo, String bccTo, String subject,
			String mailContent) {
		boolean flag = false;
		/*if (host == null || host.length() <= 0) {
			host = "secure.emailsrvr.com";
		}*/
		Properties mailProperty = new Properties();
	
		
		
		    
		try {
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("mail.properties");
			mailProperty.load(new FileInputStream(new File(resourcePath
					.getFile())));

//			Session sessionForJavaMail = Session.getInstance(mailProperty);
			
			

			Authenticator a1 = new PopupAuthenticator();
		    mailProperty.put("mail.smtp.host", "imap.gmail.com");
			mailProperty.put("mail.smtp.socketFactory.port", "465");
			mailProperty.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			mailProperty.put("mail.smtp.auth", "true");
			mailProperty.put("mail.smtp.port", "465");
			
			Session sessionForJavaMail = Session.getDefaultInstance(mailProperty,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication("egov@jkt.in",
									"Times@786");
							
						}
					});

			 SecurityManager security = System.getSecurityManager();

			MimeMessage message = new MimeMessage(sessionForJavaMail);

			if (addressFrom.length() > 0) {
				InternetAddress from = new InternetAddress(addressFrom);
				message.setFrom(from);
			}
			if (addressTo.length() > 0) {
				InternetAddress to = new InternetAddress(addressTo);
				message.addRecipient(Message.RecipientType.TO, to);
			}

			if (ccTo.length() > 0) {
				CharSequence c = new StringBuffer(",");
				if (ccTo.contains(c)) {
					Scanner sc = new Scanner(ccTo).useDelimiter(",");
					InternetAddress[] ccArr = new InternetAddress[2];

					int i = 0;
					while (sc.hasNext()) {
						String cc = sc.next();

						ccArr[i] = new InternetAddress(cc);
						i++;
					}
					message.addRecipients(Message.RecipientType.CC, ccArr);
				} else {
					InternetAddress cc = new InternetAddress(ccTo);
					message.addRecipient(Message.RecipientType.CC, cc);
				}

			}

			if (bccTo.length() > 0) {
				InternetAddress bcc = new InternetAddress(bccTo);
				message.addRecipient(Message.RecipientType.BCC, bcc);
			}
			if (subject.length() > 0) {
				message.setSubject(subject);
			}
			if (mailContent.length() > 0) {
				message.setText(mailContent);
			}
			
			
			 // added by javed khan for attachment attachment
			/* Multipart multipart = new MimeMultipart();
			 BodyPart messageBodyPart = new MimeBodyPart();
	         messageBodyPart = new MimeBodyPart();
	         String filename = "/home/manisha/file.txt";
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);
	         message.setContent(multipart);*/
	         
	        /* Transport transport = sessionForJavaMail.getTransport("smtps");
	         transport.connect();
	         transport.sendMessage(message, message.getAllRecipients());
	         transport.close();*/
			
			Transport.send(message);
			flag = true;
		} catch (MessagingException mex) {
			mex.printStackTrace();
			while (mex.getNextException() != null) {
				Exception ex = mex.getNextException();
				ex.printStackTrace();
				if (!(ex instanceof MessagingException)) {
					break;
				} else {
					mex = (MessagingException) ex;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static Map sendMailForRMS(String host, String[] mailList,
			String addressFrom, String ccTo, String bccTo, String subject,
			String[] emailMessageList) {
		Map<String, Object> mapForMailMsg = new HashMap<String, Object>();
		String sentSuccessfullyMsg = new String();
		String notSentSuccessfullyMsg = new String();

		String ccArray[] = ccTo.split(",");
		if (ccArray[0].equals("")) {
			ccArray = null;
		}
		boolean mailSend = false;
		if (mailList != null && mailList.length > 0) {
			for (int k = 0; k < mailList.length; k++) {
				mailSend = SendMail.sendMailForMultipleCC(host, mailList[k],
						addressFrom, ccArray, bccTo, subject,
						emailMessageList[k]);
				if (mailSend) {
					sentSuccessfullyMsg = sentSuccessfullyMsg + " "
							+ mailList[k] + " .<br /> ";
					mapForMailMsg.put("sentSuccessfullyMsg",
							sentSuccessfullyMsg);
				} else {
					notSentSuccessfullyMsg = notSentSuccessfullyMsg + ""
							+ mailList[k] + " .<br /> ";
					mapForMailMsg.put("notSentSuccessfullyMsg",
							notSentSuccessfullyMsg);
				}
			}
		}
		return mapForMailMsg;
	}

	/*
	 * public static void main(String args[]) {  String host = "mail.jktech.com"; String filepath =
	 * "C:\\YServer.txt";sendMailWithAttachment(host,"sunil.guduru@jktech.com",
	 * "sunil.guduru@jktech.com"
	 * ,"sunil.guduru@jktech.com","","TestMail","WELcome to
	 * jkt",filepath);  }
	 */
	public static boolean sendMailWithAttachment(String host,
			String addressTo[], String addressFrom, String ccTo[],
			String bccTo, String subject, String mailContent, String filePath) {
		boolean flag = false;
		// if(host == null || host.length() <= 0)
		// host = "mail.jktech.com";
		Properties mailProperty = new Properties();
		// Authenticator a1= new PopupAuthenticator();
		mailProperty.put("mail.smtp.auth", "true");
		try {
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("mail.properties");
			mailProperty.load(new FileInputStream(new File(resourcePath
					.getFile())));

			Session sessionForJavaMail = Session.getInstance(mailProperty);
			// SecurityManager security = System.getSecurityManager();

			MimeMessage message = new MimeMessage(sessionForJavaMail);

			if (addressFrom.length() > 0) {
				InternetAddress from = new InternetAddress(addressFrom);
				message.setFrom(from);
			}

			InternetAddress[] toAddress = new InternetAddress[addressTo.length];
			for (int i = 0; i < addressTo.length; i++) {
				toAddress[i] = new InternetAddress(addressTo[i]);
			}
			message.setRecipients(Message.RecipientType.TO, toAddress);

			if (ccTo.length > 0) {
				InternetAddress[] ccAddress = new InternetAddress[ccTo.length];

				for (int i = 0; i < ccTo.length; i++) {
					ccAddress[i] = new InternetAddress(ccTo[i]);
				}
				message.setRecipients(Message.RecipientType.CC, ccAddress);
			}

			if (bccTo.length() > 0) {
				InternetAddress bcc = new InternetAddress(bccTo);
				message.addRecipient(Message.RecipientType.BCC, bcc);
			}
			if (subject.length() > 0) {
				message.setSubject(subject);
			}

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(mailContent);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			if (filePath != "" && filePath != null && filePath.length() > 0) {

				messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(filePath);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(filePath);

				multipart.addBodyPart(messageBodyPart);
			}
			// Put parts in message
			message.setContent(multipart);
			Transport.send(message);
			flag = true;
		} catch (MessagingException mex) {
			mex.printStackTrace();
			while (mex.getNextException() != null) {
				Exception ex = mex.getNextException();
				ex.printStackTrace();
				if (!(ex instanceof MessagingException)) {
					break;
				} else {
					mex = (MessagingException) ex;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean sendHTMLMail(String host, String addressTo[],
			String addressFrom, String ccTo[], String bccTo, String subject,
			String mailContent, String filePath) {
		boolean flag = false;
		if (host == null || host.length() <= 0) {
			host = "mail.jktech.com";
		}
		Properties mailProperty = new Properties();
		// Authenticator a1= new PopupAuthenticator();
		mailProperty.put("mail.smtp.auth", "false");
		try {
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("mail.properties");
			mailProperty.load(new FileInputStream(new File(resourcePath
					.getFile())));

			Session sessionForJavaMail = Session.getInstance(mailProperty);
			// SecurityManager security = System.getSecurityManager();

			MimeMessage message = new MimeMessage(sessionForJavaMail);

			if (addressFrom.length() > 0) {
				InternetAddress from = new InternetAddress(addressFrom);
				message.setFrom(from);
			}

			InternetAddress[] toAddress = new InternetAddress[addressTo.length];
			for (int i = 0; i < addressTo.length; i++) {
				toAddress[i] = new InternetAddress(addressTo[i]);
			}
			message.setRecipients(Message.RecipientType.TO, toAddress);

			if (ccTo.length > 0) {
				InternetAddress[] ccAddress = new InternetAddress[ccTo.length];
				for (int i = 0; i < ccTo.length; i++) {
					if (ccTo[i] != "") {
						ccAddress[i] = new InternetAddress(ccTo[i]);
					}
				}
				message.setRecipients(Message.RecipientType.CC, ccAddress);
			}

			if (bccTo.length() > 0) {
				InternetAddress bcc = new InternetAddress(bccTo);
				message.addRecipient(Message.RecipientType.BCC, bcc);
			}

			if (subject.length() > 0) {
				message.setSubject(subject);
			}
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(mailContent, "text/html");
			// messageBodyPart.setText(mailContent);

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			if (filePath != "" && filePath != null && filePath.length() > 0) {
				messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(filePath);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(filePath);

				multipart.addBodyPart(messageBodyPart);
			}
			// Put parts in message
			message.setContent(multipart);
			Transport.send(message);
			flag = true;

			// message.setContent(mailContent,"text/html");
			// Transport.send(message);
			// flag = true;
		} catch (MessagingException mex) {
			mex.printStackTrace();
			while (mex.getNextException() != null) {
				Exception ex = mex.getNextException();
				ex.printStackTrace();
				if (!(ex instanceof MessagingException)) {
					break;
				} else {
					mex = (MessagingException) ex;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean sendHTMLMail(String host, String addressTo[],
			String addressFrom, String ccTo[], String bccTo[], String subject,
			String mailContent, String filePath) {
		boolean flag = false;
		// if(host == null || host.length() <= 0)
		// host = "mail.jktech.com";
		Properties mailProperty = new Properties();
		// Authenticator a1= new PopupAuthenticator();
		mailProperty.put("mail.smtp.auth", "true");
		try {
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("mail.properties");
			mailProperty.load(new FileInputStream(new File(resourcePath
					.getFile())));

			Session sessionForJavaMail = Session.getInstance(mailProperty);
			// SecurityManager security = System.getSecurityManager();

			MimeMessage message = new MimeMessage(sessionForJavaMail);

			if (addressFrom.length() > 0) {
				InternetAddress from = new InternetAddress(addressFrom);
				message.setFrom(from);
			}

			InternetAddress[] toAddress = new InternetAddress[addressTo.length];
			for (int i = 0; i < addressTo.length; i++) {
				toAddress[i] = new InternetAddress(addressTo[i]);
			}
			message.setRecipients(Message.RecipientType.TO, toAddress);

			if (ccTo.length > 0) {
				InternetAddress[] ccAddress = new InternetAddress[ccTo.length];
				for (int i = 0; i < ccTo.length; i++) {
					if (ccTo[i] != "") {
						ccAddress[i] = new InternetAddress(ccTo[i]);
					}
				}
				message.setRecipients(Message.RecipientType.CC, ccAddress);
			}

			if (bccTo.length > 0) {
				InternetAddress[] bccAddress = new InternetAddress[bccTo.length];
				for (int i = 0; i < bccTo.length; i++) {
					if (bccTo[i] != "") {
						bccAddress[i] = new InternetAddress(bccTo[i]);
					}
				}
				message.setRecipients(Message.RecipientType.BCC, bccAddress);
			}

			if (subject.length() > 0) {
				message.setSubject(subject);
			}
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(mailContent, "text/html");
			// messageBodyPart.setText(mailContent);

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			if (filePath != "" && filePath != null && filePath.length() > 0) {
				messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(filePath);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(filePath);

				multipart.addBodyPart(messageBodyPart);
			}
			// Put parts in message
			message.setContent(multipart);
			Transport.send(message);
			flag = true;

			// message.setContent(mailContent,"text/html");
			// Transport.send(message);
			// flag = true;
		} catch (MessagingException mex) {
			mex.printStackTrace();
			while (mex.getNextException() != null) {
				Exception ex = mex.getNextException();
				ex.printStackTrace();
				if (!(ex instanceof MessagingException)) {
					break;
				} else {
					mex = (MessagingException) ex;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean sendHTMLMailForAudit(String host, String addressTo[],
			String addressFrom, String ccTo[], String bccTo, String subject,
			String mailContent, String filePath) {
		boolean flag = false;
		// if(host == null || host.length() <= 0)
		// host = "mail.jktech.com";
		Properties mailProperty = new Properties();
		Authenticator a1 = new PopupAuthenticator();
		mailProperty.put("mail.smtp.auth", "true");
		try {
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("mail.properties");
			mailProperty.load(new FileInputStream(new File(resourcePath
					.getFile())));

			Session sessionForJavaMail = Session.getInstance(mailProperty, a1);
			// SecurityManager security = System.getSecurityManager();

			MimeMessage message = new MimeMessage(sessionForJavaMail);

			if (addressFrom.length() > 0) {
				InternetAddress from = new InternetAddress(addressFrom);
				message.setFrom(from);
			}

			InternetAddress[] toAddress = new InternetAddress[addressTo.length];
			for (int i = 0; i < addressTo.length; i++) {
				toAddress[i] = new InternetAddress(addressTo[i]);
			}
			message.setRecipients(Message.RecipientType.TO, toAddress);

			if (ccTo.length > 0) {
				InternetAddress[] ccAddress = new InternetAddress[ccTo.length];
				for (int i = 0; i < ccTo.length; i++) {
					if (ccTo[i] != "") {
						ccAddress[i] = new InternetAddress(ccTo[i]);
					}
				}
				message.setRecipients(Message.RecipientType.CC, ccAddress);
			}
			if (bccTo.length() > 0) {
				InternetAddress bcc = new InternetAddress(bccTo);
				message.addRecipient(Message.RecipientType.BCC, bcc);
			}
			if (subject.length() > 0) {
				message.setSubject(subject);
			}
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(mailContent, "text/html");
			// messageBodyPart.setText(mailContent);

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			if (filePath != "" && filePath != null && filePath.length() > 0) {
				messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(filePath);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(filePath);

				multipart.addBodyPart(messageBodyPart);
			}
			// Put parts in message
			message.setContent(multipart);
			Transport.send(message);
			flag = true;

			// message.setContent(mailContent,"text/html");
			// Transport.send(message);
			// flag = true;
		} catch (MessagingException mex) {
			mex.printStackTrace();
			while (mex.getNextException() != null) {
				Exception ex = mex.getNextException();
				ex.printStackTrace();
				if (!(ex instanceof MessagingException)) {
					break;
				} else {
					mex = (MessagingException) ex;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean sendHTMLMailForLeave(String host, String addressTo[],
			String addressFrom, String ccTo[], String bccTo, String subject,
			String mailContent, String filePath) {
		boolean flag = false;
		// if(host == null || host.length() <= 0)
		// host = "mail.jktech.com";
		Properties mailProperty = new Properties();
		Authenticator a1 = new PopupAuthenticator();
		mailProperty.put("mail.smtp.auth", "true");
		try {
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("mail.properties");
			mailProperty.load(new FileInputStream(new File(resourcePath
					.getFile())));

			Session sessionForJavaMail = Session.getInstance(mailProperty, a1);
			// SecurityManager security = System.getSecurityManager();

			MimeMessage message = new MimeMessage(sessionForJavaMail);

			if (addressFrom.length() > 0) {
				InternetAddress from = new InternetAddress(addressFrom);
				message.setFrom(from);
			}

			InternetAddress[] toAddress = new InternetAddress[addressTo.length];
			for (int i = 0; i < addressTo.length; i++) {
				toAddress[i] = new InternetAddress(addressTo[i]);
			}
			message.setRecipients(Message.RecipientType.TO, toAddress);

			if (ccTo.length > 0) {
				InternetAddress[] ccAddress = new InternetAddress[ccTo.length];
				for (int i = 0; i < ccTo.length; i++) {
					if (ccTo[i] != "") {
						ccAddress[i] = new InternetAddress(ccTo[i]);
					}
				}
				message.setRecipients(Message.RecipientType.CC, ccAddress);
			}
			if (bccTo.length() > 0) {
				InternetAddress bcc = new InternetAddress(bccTo);
				message.addRecipient(Message.RecipientType.BCC, bcc);
			}
			if (subject.length() > 0) {
				message.setSubject(subject);
			}
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(mailContent, "text/html");
			// messageBodyPart.setText(mailContent);

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			if (filePath != "" && filePath != null && filePath.length() > 0) {
				messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(filePath);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(filePath);

				multipart.addBodyPart(messageBodyPart);
			}
			// Put parts in message
			message.setContent(multipart);
			Transport.send(message);
			flag = true;

			// message.setContent(mailContent,"text/html");
			// Transport.send(message);
			// flag = true;
		} catch (MessagingException mex) {
			mex.printStackTrace();
			while (mex.getNextException() != null) {
				Exception ex = mex.getNextException();
				ex.printStackTrace();
				if (!(ex instanceof MessagingException)) {
					break;
				} else {
					mex = (MessagingException) ex;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean sendMailForMultipleCC(String host, String addressTo,
			String addressFrom, String[] ccTo, String bccTo, String subject,
			String mailContent) {
		boolean flag = false;

		if (host == null || host.length() <= 0) {
			host = "secure.emailsrvr.com";
		}

		Properties mailProperty = new Properties();
		Authenticator a1 = new PopupAuthenticator();
		mailProperty.put("mail.smtp.auth", "false");

		try {
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("mail.properties");
			mailProperty.load(new FileInputStream(new File(resourcePath
					.getFile())));

			Session sessionForJavaMail = Session.getInstance(mailProperty);
			// SecurityManager security = System.getSecurityManager();

			MimeMessage message = new MimeMessage(sessionForJavaMail);

			if (addressFrom != null && addressFrom.length() > 0) {
				InternetAddress from = new InternetAddress(addressFrom);
				message.setFrom(from);
			}

			if (addressTo != null && addressTo.length() > 0) {
				InternetAddress to = new InternetAddress(addressTo);
				message.addRecipient(Message.RecipientType.TO, to);
			}

			if (ccTo != null && ccTo.length > 0) {
				InternetAddress[] ccAddress = new InternetAddress[ccTo.length];

				for (int i = 0; i < ccTo.length; i++) {
					ccAddress[i] = new InternetAddress(ccTo[i]);
				}

				message.setRecipients(Message.RecipientType.CC, ccAddress);
			}

			if (bccTo != null && bccTo.length() > 0) {
				InternetAddress bcc = new InternetAddress(bccTo);
				message.addRecipient(Message.RecipientType.BCC, bcc);
			}

			if (subject != null && subject.length() > 0) {
				message.setSubject(subject);
			}

			if (mailContent != null && mailContent.length() > 0) {
				message.setText(mailContent);
			}

			Transport.send(message);

			flag = true;
		} catch (MessagingException mex) {
			mex.printStackTrace();
			while (mex.getNextException() != null) {
				Exception ex = mex.getNextException();
				ex.printStackTrace();
				if (!(ex instanceof MessagingException)) {
					break;
				} else {
					mex = (MessagingException) ex;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean sendMailForMultipleCCWithAttachment(String host,
			String addressTo, String addressFrom, String[] ccTo, String bccTo,
			String subject, String mailContent, String filePath) {
		boolean flag = false;

		if (host == null || host.length() <= 0) {
			host = "mail.jktech.com";
		}

		Properties mailProperty = new Properties();
		Authenticator a1 = new PopupAuthenticator();
		mailProperty.put("mail.smtp.auth", "true");

		try {
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("mail.properties");
			mailProperty.load(new FileInputStream(new File(resourcePath
					.getFile())));

			Session sessionForJavaMail = Session.getInstance(mailProperty, a1);
			// SecurityManager security = System.getSecurityManager();

			MimeMessage message = new MimeMessage(sessionForJavaMail);

			if (addressFrom != null && addressFrom.length() > 0) {
				InternetAddress from = new InternetAddress(addressFrom);
				message.setFrom(from);
			}

			if (addressTo != null && addressTo.length() > 0) {
				InternetAddress to = new InternetAddress(addressTo);
				message.addRecipient(Message.RecipientType.TO, to);
			}

			if (ccTo != null && ccTo.length > 0) {
				InternetAddress[] ccAddress = new InternetAddress[ccTo.length];

				for (int i = 0; i < ccTo.length; i++) {
					ccAddress[i] = new InternetAddress(ccTo[i]);
				}

				message.setRecipients(Message.RecipientType.CC, ccAddress);
			}

			if (bccTo != null && bccTo.length() > 0) {
				InternetAddress bcc = new InternetAddress(bccTo);
				message.addRecipient(Message.RecipientType.BCC, bcc);
			}

			if (subject != null && subject.length() > 0) {
				message.setSubject(subject);
			}

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();

			if (mailContent != null && mailContent.length() > 0) {
				messageBodyPart.setContent(mailContent, "text/html");
				multipart.addBodyPart(messageBodyPart);
			}

			if (filePath != "" && filePath != null && filePath.length() > 0) {
				messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(filePath);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(filePath);

				multipart.addBodyPart(messageBodyPart);
			}

			// Put parts in message
			message.setContent(multipart);

			Transport.send(message);

			flag = true;
		} catch (MessagingException mex) {
			mex.printStackTrace();
			while (mex.getNextException() != null) {
				Exception ex = mex.getNextException();
				ex.printStackTrace();
				if (!(ex instanceof MessagingException)) {
					break;
				} else {
					mex = (MessagingException) ex;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static void main(String[] args) {
		
/*
		Properties props = new Properties();
		props.put("mail.smtp.host", "imap.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
	   props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		//props.put("mail.smtp.starttls.enable", "true");
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("egov@jkt.in",
							"Times@786");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("egov@jkt.in"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("avinash.singh@jktech.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler," +
					"\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}*/
		
		sendMail("egov@jkt.in", "avinash.singh@jktech.com","egov@jkt.in" , "", "", "test Mail", "hi");
	}
}