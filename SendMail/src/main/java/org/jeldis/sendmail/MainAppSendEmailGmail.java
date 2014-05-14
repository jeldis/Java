/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jeldis.sendmail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author jorge.gonzalez
 * http://www.oracle.com/technetwork/java/javamail-138606.html
 * https://java.net/projects/javamail/pages/Home
 * https://javamail.java.net/docs/README.txt
 * http://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
 */
public class MainAppSendEmailGmail {

    public static void main(String[] args) {
        System.out.println("Enviando Email");

        final String username = "jeldis@gmail.com";
        final String password = "Yumuri2012.";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("jeldis@hotmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("jeldis@hotmail.com"));
            message.setSubject("Testing Subject");
            message.setText("Prueba de como funciona la cosa!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            
            System.out.println(e);
            throw new RuntimeException(e);
            
        }


    }
}
