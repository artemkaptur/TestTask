/**
 * 
 */
package com.elinext.kapturtesttask.taskfive.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Артем
 *
 */
public class ConnectionHelper {

	private ConnectionHelper() {
	}

	public static HttpURLConnection makeConnection(String urlstr) throws IOException {

		URL url = new URL(urlstr);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		return connection;
	}

	public static StringBuilder readAllFromStream(InputStreamReader in) throws IOException {
		BufferedReader reader = new BufferedReader(in);
		StringBuilder sb = new StringBuilder();
		String inputStr;
		while ((inputStr = reader.readLine()) != null)
			sb.append(inputStr);
		reader.close();
		return sb;
	}

}
