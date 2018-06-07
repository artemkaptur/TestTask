/**
 * 
 */
package com.elinext.kapturtesttask.taskfive;

import static com.elinext.kapturtesttask.taskfive.util.ConnectionHelper.makeConnection;
import static com.elinext.kapturtesttask.taskfive.util.ConnectionHelper.readAllFromStream;
import static com.elinext.kapturtesttask.taskfive.util.PrintToConsole.findAndPrint;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * @author Артем
 *
 */
public class Runner {

	public static void main(String[] args) throws IOException {

		String connectingUrl = "https://www.cnn.com/";
		HttpURLConnection connection = makeConnection(connectingUrl);

		StringBuilder sb = readAllFromStream((new InputStreamReader(connection.getInputStream())));

		String key = "Trump";
		findAndPrint(sb, key);
	}

}
