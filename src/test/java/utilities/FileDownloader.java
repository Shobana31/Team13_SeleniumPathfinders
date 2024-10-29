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

		int responseCode = httpConn.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			InputStream inputStream = new BufferedInputStream(httpConn.getInputStream());
			FileOutputStream outputStream = new FileOutputStream(saveDir);
			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			outputStream.close();
			inputStream.close();
		} else {
			System.out.println("No file to download. Server replied HTTP code: " + responseCode);
			System.out.println("Error Message: " + httpConn.getResponseMessage());
		}
		httpConn.disconnect();
	}

	public static void main(String[] args) {
		try {
			downloadFile(fileURL, saveDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
