/**
 * 
 */
package com.elinext.kapturtesttask.taskfour;

import java.io.IOException;

/**
 * @author Артем
 *
 */
public class Runner {

	public static void main(String[] args) {

		FtpClientSocket cl = new FtpClientSocket();

		try {
			System.out.println(cl.sendComand("USER anonymous"));
			System.out.println(cl.sendComand("PASS anonymous"));

			String answer = cl.sendCommandInPassiveMode("NLST").toString();
			System.out.println(answer);

			String[] directories = answer.split("\n");
			for (int i = 0; i < directories.length; i++) {
				if (!directories[i].contains(".")) {
					System.out.println(cl.sendComand("CWD /" + directories[i]));
					System.out.println(cl.sendCommandInPassiveMode("NLST"));
					System.out.println(cl.sendComand("CDUP"));
					System.out.println(cl.sendCommandInPassiveMode("NLST"));
				}
			}
			String str = cl.sendComand("MKD hello");
			if (cl.answerToCode(str))
				System.out.println(cl.sendComand("RMD hello"));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			cl.disconnect();
		}

	}

}
