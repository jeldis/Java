/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jeldis.sendmail;

/**
 *
 * @author jorge.gonzalez
 */

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailService {
    /**
     * Send a email.
     */
    public void sendEmail(String from, String to,
            String subject, String body, String host) {


        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(properties);

        try {

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            message.setSubject(subject);

            message.setText(body);

            Transport.send(message);

            System.out.println("El email se envio correctamente!");

        } catch (MessagingException ex) {
            System.out.println("Un error ha ocurrido: " + ex);
        }
    }
}
