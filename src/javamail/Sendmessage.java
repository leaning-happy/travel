package javamail;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class Sendmessage {
	// �����˵� ���� �� ���루�滻Ϊ�Լ�����������룩
	 // PS: ĳЩ���������Ϊ���������䱾������İ�ȫ�ԣ��� SMTP �ͻ��������˶������루�е������Ϊ����Ȩ�롱��, 
	 // ���ڿ����˶������������, ����������������ʹ������������루��Ȩ�룩��
	 public static String myEmailAccount = "2512041822@qq.com";
	 public static String myEmailPassword = "qujfusuopywzdihc";
	 
	 // ����������� SMTP ��������ַ, ����׼ȷ, ��ͬ�ʼ���������ַ��ͬ, һ��(ֻ��һ��, ���Ǿ���)��ʽΪ: smtp.xxx.com
	 // ����163����� SMTP ��������ַΪ: smtp.163.com
	 public static String myEmailSMTPHost = "smtp.qq.com";
	 
	 // �ռ������䣨�滻Ϊ�Լ�֪������Ч���䣩
//	 public static String receiveMailAccount = "2587013709@qq.com";
//�����ʼ�����	 
	 public static void sendeMail(String name ,int h,String receiveMailAccount) throws Exception {
	 // 1. ������������, ���������ʼ��������Ĳ�������
	 Properties props = new Properties();   // ��������
	 props.setProperty("mail.transport.protocol", "smtp"); // ʹ�õ�Э�飨JavaMail�淶Ҫ��
	 props.setProperty("mail.smtp.host", myEmailSMTPHost); // �����˵������ SMTP ��������ַ
	 props.setProperty("mail.smtp.auth", "true");  // ��Ҫ������֤
	 
	 // PS: ĳЩ���������Ҫ�� SMTP ������Ҫʹ�� SSL ��ȫ��֤ (Ϊ����߰�ȫ��, ����֧��SSL����, Ҳ�����Լ�����),
	 // ����޷������ʼ�������, ��ϸ�鿴����̨��ӡ�� log, ����������� ������ʧ��, Ҫ�� SSL ��ȫ���ӡ� �ȴ���,
	 // ������ /* ... */ ֮���ע�ʹ���, ���� SSL ��ȫ���ӡ�
	 /*
	 // SMTP �������Ķ˿� (�� SSL ���ӵĶ˿�һ��Ĭ��Ϊ 25, ���Բ����, ��������� SSL ����,
	 //   ��Ҫ��Ϊ��Ӧ����� SMTP �������Ķ˿�, ����ɲ鿴��Ӧ�������İ���,
	 //   QQ�����SMTP(SLL)�˿�Ϊ465��587, ������������ȥ�鿴)
	 final String smtpPort = "465";
	 props.setProperty("mail.smtp.port", smtpPort);
	 props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	 props.setProperty("mail.smtp.socketFactory.fallback", "false");
	 props.setProperty("mail.smtp.socketFactory.port", smtpPort);
	 */
	 
	 // 2. �������ô����Ự����, ���ں��ʼ�����������
	 Session session = Session.getDefaultInstance(props);
//	 session.setDebug(true);     // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log
	 
	 // 3. ����һ���ʼ�
	 MimeMessage message = Createmessage(session, myEmailAccount, receiveMailAccount, name, h);
	 
	 // 4. ���� Session ��ȡ�ʼ��������
	 Transport transport = session.getTransport();
	 
	 // 5. ʹ�� �����˺� �� ���� �����ʼ�������, ������֤����������� message �еķ���������һ��, ���򱨴�
	 // 
	 // PS_01: �ɰܵ��жϹؼ��ڴ�һ��, ������ӷ�����ʧ��, �����ڿ���̨�����Ӧʧ��ԭ��� log,
	 //  ��ϸ�鿴ʧ��ԭ��, ��Щ����������᷵�ش������鿴�������͵�����, ���ݸ����Ĵ���
	 //  ���͵���Ӧ�ʼ��������İ�����վ�ϲ鿴����ʧ��ԭ��
	 //
	 // PS_02: ����ʧ�ܵ�ԭ��ͨ��Ϊ���¼���, ��ϸ������:
	 //  (1) ����û�п��� SMTP ����;
	 //  (2) �����������, ����ĳЩ���俪���˶�������;
	 //  (3) ���������Ҫ�����Ҫʹ�� SSL ��ȫ����;
	 //  (4) �������Ƶ��������ԭ��, ���ʼ��������ܾ�����;
	 //  (5) ������ϼ��㶼ȷ������, ���ʼ���������վ���Ұ�����
	 //
	 // PS_03: ��ϸ��log, ���濴log, ����log, ����ԭ����log��˵����
	 transport.connect(myEmailAccount, myEmailPassword);
	 
	 // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
	 transport.sendMessage(message, message.getAllRecipients());
	 
	 // 7. �ر�����
	 transport.close();
	 }
	 //�����ʼ�����
	 public static MimeMessage Createmessage(Session session, String sendMail, String receiveMail,String name ,int time) throws MessagingException, IOException {

//		 Session session= Session.getDefaultInstance(props); // ���ݲ������ã������Ự����Ϊ�˷����ʼ�׼���ģ�
		 MimeMessage message = new MimeMessage(session); // �����ʼ�����
		 
		 /*
		  * Ҳ���Ը������е�eml�ʼ��ļ����� MimeMessage ����
		  * MimeMessage message = new MimeMessage(session, new FileInputStream("MyEmail.eml"));
		  */
		 
		 // 2. From: ������
		 // ���� InternetAddress �����������ֱ�Ϊ: ����, ��ʾ���ǳ�(ֻ������ʾ, û���ر��Ҫ��), �ǳƵ��ַ�������
		 // ����Ҫ����ʱ, �����������ʵ��Ч�����䡣
		 message.setFrom(new InternetAddress(sendMail, "���ϲƾ�������ѧ�����Ƽ�ϵͳ", "UTF-8"));
		 
		 // 3. To: �ռ���
		 message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "USER_CC", "UTF-8"));
/*		 // To: �����ռ��ˣ���ѡ��
		 message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress("dd@receive.com", "USER_DD", "UTF-8"));
		 // Cc: ���ͣ���ѡ��
		 message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("ee@receive.com", "USER_EE", "UTF-8"));
		 // Bcc: ���ͣ���ѡ��
		 message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("ff@receive.com", "USER_FF", "UTF-8"));   */
		 
		 // 4. Subject: �ʼ�����
		 message.setSubject("�������μƻ�����", "UTF-8");
		 
		 // 5. Content: �ʼ����ģ�����ʹ��html��ǩ��
		 message.setContent("���ڽ���"+time+"ʱ�����мƻ�", "text/html;charset=UTF-8");
		 
		 // 6. ������ʾ�ķ���ʱ��
		 message.setSentDate(new Date());
		 
		 // 7. ����ǰ�������
		 message.saveChanges();
		 
		 return message;
	 
		 
		 // 8. �����ʼ����浽����
/*		 OutputStream out = new FileOutputStream("MyEmail.eml");
		 message.writeTo(out);
		 out.flush();
		 out.close(); */
		 }	 	
}



