/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jeldis.sendmail;

/**
 *
 * @author jorge.gonzalez
 * Como ejecutarlo desde la linea de comando:
 * C:\Users\jorge.gonzalez\Documents\NetBeansProjects\SendMail\target>java -cp SendMail-1.0-SNAPSHOT.jar org.jeldis.sendmail.MainApp
 */
public class MainApp {

    public static void main(String[] args) {
        System.out.println("Enviando Email");

        SendEmailService sendEmail = new SendEmailService();
        sendEmail.sendEmail("jeldis@hotmail.com", "jeldis@hotmail.com", "Asunto", "Body", "10.74.4.43");
    }
}
