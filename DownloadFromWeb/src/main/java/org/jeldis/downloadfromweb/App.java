package org.jeldis.downloadfromweb;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 * run: java -jar DownloadFromWeb-1.0.jar
 */
public class App {

    public static void main(String[] args) {

        try {
            saveUrl("Calculus.pdf", "http://stitz-zeager.com/szprecalculus07042013.pdf");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public static void saveUrl(String filename, String urlString) throws MalformedURLException, IOException {
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try {
            in = new BufferedInputStream(new URL(urlString).openStream());
            fout = new FileOutputStream(filename);

            byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (fout != null) {
                fout.close();
            }
        }
    }
}
