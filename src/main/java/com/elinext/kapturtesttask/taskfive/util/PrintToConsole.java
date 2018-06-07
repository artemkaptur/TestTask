/**
 * 
 */
package com.elinext.kapturtesttask.taskfive.util;

/**
 * @author Артем
 *
 */
public class PrintToConsole {

	private PrintToConsole() {

	}

	public static void findAndPrint(StringBuilder sb, String key) {
		int lastIndex = 0;

		System.out.println("All length: " + sb.length());
		while (lastIndex != -1) {
			lastIndex = sb.indexOf(key, lastIndex);
			if (lastIndex != -1) {
				int ind = sb.indexOf("<", lastIndex);
				int tempInd = sb.indexOf("\\", lastIndex);
				ind = ind < tempInd ? ind : tempInd;
				tempInd = sb.indexOf("\"", lastIndex);
				ind = ind < tempInd ? ind : tempInd;
				System.out.println(String.format("...%s - [%d]", sb.substring(lastIndex, ind), lastIndex));
				lastIndex += 1;
			}
		}
	}

}
