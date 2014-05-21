/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jeldis.simplemessage;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

/**
 *
 * @author jeldis
 */
public class SendMsg {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws java.io.IOException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //String message = "Hello World!";

        try {
            int countMessahes = Integer.parseInt(args[1]);
            String cmdMessage = args[0];

            for (int i = 0; i < countMessahes; i++) {
                channel.basicPublish("", QUEUE_NAME, null, cmdMessage.getBytes());
                System.out.println(" [x] Sent '" + cmdMessage + "'");
            }

        } catch (NumberFormatException e) {
            System.err.println(e);
            System.exit(1);
        }

        channel.close();
        connection.close();

    }

}
