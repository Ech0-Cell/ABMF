package me.waterarchery.abmf.requests;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestCall {

    // Not used.
    // This is for homework
    public static void sendRequest() {
        try {
            // Preparing connection
            URL url = new URL("http://universities.hipolabs.com/search?name=bahce");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            InputStream is = con.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder();

            // Parsing response
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }

            // Closing reader and printing response
            rd.close();
            System.out.println(response);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
