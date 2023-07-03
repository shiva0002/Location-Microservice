package com.movieticketsystem.location.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class AccessToken {
    
    private static String getAUthToken(String url,String client_app_key,String client_app_secret) throws IOException {
        URL obj = new URL(url);
        String auth = client_app_key + ":" + client_app_secret;
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
        String authHeaderValue = "Basic " + new String(encodedAuth);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization", authHeaderValue);
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        con.setRequestProperty("User-Agent", "USER_AGENT");
        con.setRequestProperty("scope", "openid");
        con.setRequestProperty("grant_type", "client_credentials");
        // // final String POST_PARAMS = "grant_type=client_credentials";
        // // // For POST only - START
        // // con.setDoOutput(true);
        // // OutputStream os = con.getOutputStream();
        // // os.write(POST_PARAMS.getBytes());
        // // os.flush();
        // // os.close();
        // // // For POST only - END

    
        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { //success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                     con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                  response.append(inputLine);
                }
                in.close();
                Pattern p = Pattern.compile("\"access_token\":\"(\\w)*\",");
                Matcher m = p.matcher(response.toString());
                if (m.find()) {
                    String group = m.group();
                    return group.substring(16,group.length()-2);
                }
                else
                {
                    throw new IOException("Access Token Not found");
                }
        } else {
                System.out.println("POST request not worked");
                throw new IOException("POST request not worked");
        }
    }
}
