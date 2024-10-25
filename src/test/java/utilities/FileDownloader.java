package utilities;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileDownloader {

	public static String fileURL;
	 public static String saveDir;
	 
	public static void downloadFile(String fileURL, String saveDir) throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("GET");

        // Check for response code
        int responseCode = httpConn.getResponseCode();
        System.out.println("Response Code: " + responseCode); // Print response code for debugging

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            InputStream inputStream = new BufferedInputStream(httpConn.getInputStream());
            FileOutputStream outputStream = new FileOutputStream(saveDir);

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();
            System.out.println("File downloaded: " + saveDir);
        } else {
            System.out.println("No file to download. Server replied HTTP code: " + responseCode);
            System.out.println("Error Message: " + httpConn.getResponseMessage());
            
        }
        httpConn.disconnect();
    }

    public static void main(String[] args) {
        // Use the direct download link you created
    	
      //  String fileURL = "https://docs.google.com/spreadsheets/d/1vFF8WKP9VB1rjViUE4JnZfyRFqFY14zxWBO-wq0gzKQ/export?format=xlsx"; 
       // String saveDir = "src/test/resources/filename.xlsx"; // Specify the path where you want to save the file

        try {
            downloadFile(fileURL, saveDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
}
