package org.jeldis.httprequestapp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;

/**
 * Hello world!
 * http://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
 */
public class App {

    private static String USER_AGENT = "Mozilla/5.0";
    App http = new App();
    private static long _time = 0;

    public static void main(String[] args) {

        try {

//            System.out.println("Testing 1 - Send Http GET request");
//            http.sendGet();
//
//            System.out.println("\nTesting 2 - Send Http POST request");
//            http.sendPost();

            _time = Long.parseLong(args[0]);

            System.out.println("Ctrl + C para salir");

            VoteTMS();

        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void VoteTMS() throws Exception {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            int loop = 0;

            public void run() {


                Date today = new Date();

                try {

                    loop++;

                    System.out.println("Request: " + Integer.toString(loop));

                    //http://docs.oracle.com/javase/tutorial/java/data/numberformat.html
                    //http://javarevisited.blogspot.com/2012/08/how-to-format-string-in-java-printf.html

                    System.out.printf("%td/%tm/%tY %tl:%tM %tp %n", today, today, today, today, today, today);

                    sendGet("http://tvn-2.com/tucaramesuena/vote291330/send_data.asp?opcion=96");

                } catch (Exception ex) {

                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }, 0, _time);

    }

    // HTTP GET request
    private static void sendGet(String url) throws Exception {

        //String url = "http://www.google.com/search?q=mkyong";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

    // HTTP POST request
    private void sendPost() throws Exception {

        String url = "https://selfsolve.apple.com/wcResults.do";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }
}
