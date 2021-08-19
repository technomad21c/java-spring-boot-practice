package com.technomad.webdownload;

import com.technomad.webdownload.config.MyAuthenticator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        String username = "quotemedia";
        String password = "quotemedia";

//        MyAuthenticator ma = new MyAuthenticator();
//        ma.setPasswordAuthentication(username, password);
//        Authenticator.setDefault(ma);

        try {

            String url = "https://qmapiuat.decimalpointanalytics.com/fund-master?country=CA&instrumenttype=etf&format=csv";
//            url = "https://qmapiuat.decimalpointanalytics.com/fund-master?country=CA&instrumenttype=mutualfund&format=csv";
//            url = "https://qmapiuat.decimalpointanalytics.com/fund-master?country=CA&instrumenttype=moneymarket&format=csv";
//            url = "https://qmapiuat.decimalpointanalytics.com/fund-master?country=US&instrumenttype=etf&format=csv";
//            url = "https://qmapiuat.decimalpointanalytics.com/fund-master?country=US&instrumenttype=mutualfund&format=csv";
//            url = "https://qmapiuat.decimalpointanalytics.com/fund-master?country=US&instrumenttype=moneymarket&format=csv";
//            URL obj = new URL(url);
//            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
//            conn.setReadTimeout(5000);
//            conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
//            conn.addRequestProperty("User-Agent", "Mozilla");
//            conn.addRequestProperty("Referer", "google.com");
//
//            System.out.println("Request URL ... " + url);
//            String cookies = conn.getHeaderField("Set-Cookie");

            // open the new connnection again
            URL newUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) newUrl.openConnection();
            conn = (HttpURLConnection) newUrl.openConnection();
            conn.setReadTimeout(5000);
            conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
            conn.addRequestProperty("User-Agent", "Chrome");
            conn.addRequestProperty("Referer", "google.com");

            URL downloadUrl = new URL(url);
            System.out.println("Starting downloading...");
            HttpURLConnection connection = (HttpURLConnection) downloadUrl.openConnection();
            connection.setRequestMethod("GET");
//            String fieldValue = connection.getHeaderField("Content-Disposition");
//            System.out.println("*** "  + fieldValue);
//            if (fieldValue == null || ! fieldValue.contains("filename=\"")) {
//                System.out.println("no filename");
//            }

            InputStream in = connection.getInputStream();
            FileOutputStream out = new FileOutputStream("1.csv");
            copy(in, out, 1024);
            System.out.println("Starting downloaded.");
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copy(InputStream input, OutputStream output, int bufferSize) throws IOException {
        byte[] buf = new byte[bufferSize];
        int n = input.read(buf);
        while (n >= 0) {
            output.write(buf, 0, n);
            n = input.read(buf);
        }
        output.flush();
    }
}
