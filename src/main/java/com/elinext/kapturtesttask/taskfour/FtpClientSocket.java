/**
 * 
 */
package com.elinext.kapturtesttask.taskfour;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Артем
 *
 */
public class FtpClientSocket {
	Socket socket;
	PrintWriter outputStream;
	BufferedReader inputStream;

	public FtpClientSocket() {
		try {
			socket = new Socket(InetAddress.getByName("ftp.byfly.by"), 21);
			outputStream = new PrintWriter(socket.getOutputStream());
			inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(getResponse());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public StringBuilder sendCommandInPassiveMode(String command) throws IOException {
		String str = sendComand("PASV");

		System.out.println(str);
		int start = str.indexOf("(");
		int end = str.indexOf(")");
		str = str.substring(start, end);
		str = str.replace("(", "");
		str = str.replace(")", "");
		str = str.replace(".", "");
		String[] temp = str.split(",");
		int port = Integer.parseInt(temp[4]) * 256 + Integer.parseInt(temp[5]);
		String address = temp[0] + "." + temp[1] + "." + temp[2] + "." + temp[3];

		Socket dataConnection = new Socket(address, port);

		sendComand(command);

		BufferedReader dataIn = new BufferedReader(new InputStreamReader(dataConnection.getInputStream()));
		String line;
		StringBuilder sb = new StringBuilder();
		while ((line = dataIn.readLine()) != null) {
			sb.append(line + "\n");
		}
		dataConnection.close();
		dataIn.close();
		getResponse();
		return sb;
	}

	public void disconnect() {
		try {
			System.out.println(sendComand("QUIT"));
			socket.close();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		outputStream.close();
	}

	public String sendComand(String command) throws IOException {
		for (int i = 0; i < command.length(); i++) {
			outputStream.write(command.charAt(i));
		}
		outputStream.write('\r');
		outputStream.write('\n');
		outputStream.flush();
		return getResponse();
	}

	private String getResponse() throws IOException {
		StringBuffer response = new StringBuffer();
		String line = inputStream.readLine();
		response.append(line);

		return response.toString();
	}

	public boolean answerToCode(String answer) {
		Pattern p = Pattern.compile("\\d\\d\\d");
		Matcher m = p.matcher(answer);
		while (m.find()) {
			Integer parsse = Integer.parseInt(m.group());
			if (parsse > 299 || parsse < 200)
				return false;
			return true;
		}
		return true;
	}

}
