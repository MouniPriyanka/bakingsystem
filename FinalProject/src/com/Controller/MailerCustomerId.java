package com.Controller;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//import com.customer.register.Mailer;

public class MailerCustomerId {
	public static void send(final String from, final String password, String to, String sub, String msg) {
        //Get properties object    
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        //get Session   
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });
        //compose message    
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);
            System.out.println("in Mailer");
            //send message  
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();  
        }
    }
}
class SendMailSSLCustomerID {

    public static void main(String[] args) {
        //from,password,to,subject,message 
        Random rnd = new Random();
        int n = 100000 + rnd.nextInt(900000);
        System.out.println("in Mailer");
        String msg = Integer.toString(n);
        Mailer.send("wellsteam04@gmail.com", "wellsteam4", "mounipriyanka27@gmail.com", "Your Customer ID", msg);
        //change from, password and to  
    }
}
