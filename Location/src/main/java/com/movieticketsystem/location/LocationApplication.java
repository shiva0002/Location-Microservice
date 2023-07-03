package com.movieticketsystem.location;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class LocationApplication {

	// private static String getAUthToken(String url,String client_app_key,String client_app_secret) throws IOException {
    //     URL obj = new URL(url);
    //     String auth = client_app_key + ":" + client_app_secret;
    //     byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
    //     String authHeaderValue = "Basic " + new String(encodedAuth);
    //     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    //     con.setRequestMethod("POST");
    //     con.setRequestProperty("Authorization", authHeaderValue);
    //     con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    //     // con.setRequestProperty("User-Agent", "USER_AGENT");
    //     // con.setRequestProperty("scope", "openid");
    //     // con.setRequestProperty("grant_type", "authorization_code");
    //     // con.setRequestProperty("code", "PtbPYaELMUMcCR8uAE5YzHoAFvo");
    //     final String POST_PARAMS = "{\n" + "\"grant_type\": authorization_code,\r\n" +
    //     "    \"scope\": \"openid\",\r\n" +
    //     "    \"code\": \"2kIcvDNk4LLwf2eAWcp_kjKOshw\",\r\n}";
	// 	// final String POST_PARAMS = "grant_type=client_credentials";
    //     // For POST only - START
    //     con.setDoOutput(true);
    //     OutputStream os = con.getOutputStream();
    //     os.write(POST_PARAMS.getBytes());
    //     os.flush();
    //     os.close();
    //     // For POST only - END

    
    //     int responseCode = con.getResponseCode();
    //     System.out.println("POST Response Code :: " + responseCode);
    //     if (responseCode == HttpURLConnection.HTTP_OK) { //success
    //             BufferedReader in = new BufferedReader(new InputStreamReader(
    //                  con.getInputStream()));
    //             String inputLine;
    //             StringBuffer response = new StringBuffer();
    //             while ((inputLine = in.readLine()) != null) {
    //               response.append(inputLine);
    //             }
    //             in.close();
    //             Pattern p = Pattern.compile("\"access_token\":\"(\\w)*\",");
    //             Matcher m = p.matcher(response.toString());
    //             if (m.find()) {
    //                 String group = m.group();
    //                 return group.substring(16,group.length()-2);
    //             }
    //             else
    //             {
    //                 throw new IOException("Access Token Not found");
    //             }
    //     } else {
    //             System.out.println("POST request not worked");
    //             throw new IOException("POST request not worked");
    //     }
    // }
	
	public static void main(String[] args) throws Exception{
		SpringApplication.run(LocationApplication.class, args);

		String URL = "http://openam.example.com:9090/openam/oauth2/realms/root/realms/demo/access_token";
        String client_app_key = "9c5ba041-80b7-4241-a2c5-32669cefe4a7";
        String client_app_secret = "forgerock";
        // System.out.println(getAUthToken(URL,client_app_key,client_app_secret));

        String auth = client_app_key + ":" + client_app_secret;
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
        String authHeaderValue = "Basic " + new String(encodedAuth);

		var values = new HashMap<String, String>() {{
            put("grant_type", "authorization_code");
            put ("code", "ihYYntfynHLdCuxX2xfoBuQyDeg");
            put("Authorization",authHeaderValue);
        }};

        var objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writeValueAsString(values);

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(URL))
                        .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                        .build();
        
                HttpResponse<String> response = client.send(request,
                        HttpResponse.BodyHandlers.ofString());
        
                System.out.println(response.body());
	}

}
