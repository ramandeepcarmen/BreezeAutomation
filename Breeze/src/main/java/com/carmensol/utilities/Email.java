package com.carmensol.utilities;




import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
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
/*
 * This class has the main code for sending mail
 */
public class Email {
  public static void send(String from, String tos[], String subject,
      String text) throws MessagingException {
    // Get the session object
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class",
        "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");
    Session session = Session.getDefaultInstance(props,
        new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(
            "test01@gmail.com",
            "pass1234");// change accordingly
          }
        });
    // compose message
    try {
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(from));// change accordingly
      for (String to : tos) {
        message.addRecipient(Message.RecipientType.TO,
            new InternetAddress(to));
      }
      /*
       * for (String cc : ccs)
       * message.addRecipient(Message.RecipientType.CC,new
       * InternetAddress(cc));
       */
      message.setSubject(subject);
      // Option 1: To send normal text message
      // message.setText(text);
      // Option 2: Send the actual HTML message, as big as you like
      // message.setContent("<h1>This is actual message</h1></br></hr>" +
      // text, "text/html");
      // Set the attachment path
      String filename = "E:\\Selenium\\junit.pdf";
      BodyPart objMessageBodyPart = new MimeBodyPart();
      // Option 3: Send text along with attachment
      objMessageBodyPart.setContent(
          "<h1>Mail from Selenium Project!</h1></br>" + text, "text/html");
      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(objMessageBodyPart);
      objMessageBodyPart = new MimeBodyPart();
      DataSource source = new FileDataSource(filename);
      objMessageBodyPart.setDataHandler(new DataHandler(source));
      objMessageBodyPart.setFileName(filename);
      multipart.addBodyPart(objMessageBodyPart);
      message.setContent(multipart);
      // send message
      Transport.send(message);
      System.out.println("message sent successfully");
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }// End of SEND method
}