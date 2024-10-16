package DAO;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class EmailUtility {

    public static void sendEmail(String recipient, String subject, String content) throws MessagingException {
        final String username = "hiennnhe187362@fpt.edu.vn"; // Địa chỉ email của bạn
        final String appPassword = "mlsdzpniwqjhuocm"; // Mật khẩu ứng dụng

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, appPassword);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("hiennnhe187362@fpt.edu.vn")); // Địa chỉ email của bạn
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
        message.setSubject(subject);
        message.setContent(content, "text/html");

        Transport.send(message);
    }

    //main method to test
    public static void main(String[] args) {
        try {
            sendEmail("hiennnhe187362@fpt.edu.vn", "Test email", "This is a test email");
            System.out.println("Email sent successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
