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
 *ʹ��JAVA�����ʼ�
 */
public class JavaMail {
	 Properties properties;
	 Session session;
	 MimeMessage mimeMessage;
	/**
	 * ��ʼ������
	 */
	public JavaMail()
	{
		properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
        properties.setProperty("mail.smtp.host", "smtp.163.com");   // �����˵������ SMTP ��������ַ
        properties.setProperty("mail.smtp.auth", "true");            // ��Ҫ������֤
		session = Session.getDefaultInstance(properties);
		session.setDebug(true); 
		mimeMessage = createMailMassage(session);;  // �����ʼ�����
		sendJavaMail(mimeMessage);
	}
	
	/**
	 * �����ʼ�
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
     * �����ʼ�����
     */
    public MimeMessage createMailMassage(Session session)
    {
    	MimeMessage mimeMessage = new MimeMessage(session);
    	try {
			mimeMessage.setFrom(new InternetAddress("tangyue2911@163.com", "163", "UTF-8"));
			mimeMessage.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("814943616@qq.com", "163", "UTF-8"));
			mimeMessage.setSubject("�ʼ����Ͳ���","UTF-8");
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
