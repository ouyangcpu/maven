package maven;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author ouyangcpu
 *使用JAVA发送邮件
 */
public class JavaMail {
	 Properties properties;
	 Session session;
	 MimeMessage mimeMessage;
	/**
	 * 初始化对象
	 */
	public JavaMail()
	{
		properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        properties.setProperty("mail.smtp.host", "smtp.163.com");   // 发件人的邮箱的 SMTP 服务器地址
        properties.setProperty("mail.smtp.auth", "true");            // 需要请求认证
		session = Session.getDefaultInstance(properties);
		session.setDebug(true); 
		mimeMessage = createMailMassage(session);;  // 创建邮件对象
		sendJavaMail(mimeMessage);
	}
	
	/**
	 * 发送邮件
	 */
	public void sendJavaMail(MimeMessage mimeMessage)
	{
		try {
			Transport transport = session.getTransport();
			try {
				transport.connect("tangyue2911@163.com", "denglu1992");
				transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
				transport.close();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    /**
     * 创建邮件对象
     */
    public MimeMessage createMailMassage(Session session)
    {
    	MimeMessage mimeMessage = new MimeMessage(session);
    	try {
			mimeMessage.setFrom(new InternetAddress("tangyue2911@163.com", "163", "UTF-8"));
			mimeMessage.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("814943616@qq.com", "163", "UTF-8"));
			mimeMessage.setSubject("邮件发送测试","UTF-8");
			mimeMessage.setContent("HELLO", "text/html;charset=UTF-8");
			mimeMessage.setSentDate(new Date());
			mimeMessage.saveChanges();
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	return mimeMessage;
    	
    }


}
