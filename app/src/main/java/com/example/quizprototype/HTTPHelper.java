package com.example.quizprototype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPHelper {
    // I used Brother Macbeth's code here:
    public String readHTTP(String url) {
        try {
            // Convert string to URL
            URL urlObject = new URL(url);

            // Send the Get request
            HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder info = new StringBuilder();
            String line;

            // Read from remote server until null
            do {
                // Read next line
                line = reader.readLine();
                if (line != null) {
                    // Concatenate new string into StringBuilder
                    info.append(line);
                }
            }
            while (line != null) ;

            // Convert to normal String
            return info.toString() ;
        }
        catch (IOException ioe) {
            System.out.println("Error reading the HTTP response: " + ioe);
            return null;
        }
    }
}

