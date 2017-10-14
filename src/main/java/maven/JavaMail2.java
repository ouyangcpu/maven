/**
 * 
 */
package maven;

import java.io.UnsupportedEncodingException;
import java.security.cert.TrustAnchor;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * @author ouyangcpu
 *复杂邮件处理
 */
public class JavaMail2 {
	
	private static final String EMAILACCOUNT  = "tangyue2911@163.com";
	private static final String EMAILPASSWORD = "denglu1992";
	private static final String STMPHOST = "smtp.163.com";
	private static final String RECEIVE = "814943616@qq.com";
	Properties properties;
	Session session;
	
	public JavaMail2()
	{
		properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.host", STMPHOST);
		properties.setProperty("mail.smtp.auth", "true");
		session = session.getDefaultInstance(properties);
		session.setDebug(true);
		MimeMessage mimeMessage = createMimeMessage(session, EMAILACCOUNT, RECEIVE);
	}

	private MimeMessage createMimeMessage(Session session2, String emailaccount2, String receive2) {
		MimeMessage mimeMessage = new MimeMessage(session2);
		try {
			mimeMessage.setFrom(new InternetAddress(emailaccount2,"发邮件","UTF-8"));
			mimeMessage.setRecipient(RecipientType.TO, new InternetAddress(RECEIVE, "收件人", "UTF-8"));
			mimeMessage.setSubject("HELLO", "UTF-8");
			mimeMessage.setContent("HELLO","text/html;charset=UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
