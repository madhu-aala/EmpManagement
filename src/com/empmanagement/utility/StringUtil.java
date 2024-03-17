package com.empmanagement.utility;

import java.util.StringTokenizer;

public class StringUtil {

	private static final String className = "StringUtil";

	public static String password(String oldPassword) {
		String password = "";
		for (int i = 0; i < oldPassword.length(); i++) {
			if (oldPassword.charAt(i) > 47 && oldPassword.charAt(i) < 58) {
				password += oldPassword.charAt(i);
			}
		}
		return password;
	}

	public static boolean validatePassword(String password) {
		boolean output = true;
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) > 47 && password.charAt(i) < 58 && password.length() > 5) {
				continue;
			} else {
				return false;
			}
		}
		return output;
	}

	public static String giveDateFormat(String inputDate) {
		String methodName = "giveDateFormat";
		System.out.println(className + "--->" + methodName + "---? START ");
		String out = "";
		StringTokenizer st1 = new StringTokenizer(inputDate, " ");
		String date = "";
		if (st1.hasMoreElements()) {
			date = st1.nextToken();
		}
		StringTokenizer st = new StringTokenizer(date, "-,/");
		String[] collect = new String[st.countTokens()];
		System.out.println("TOKENS COUNT --->" + st.countTokens() + " " + date);
		int i = 0;
		while (st.hasMoreElements()) {
			System.out.println("i===" + i);
			collect[i] = st.nextToken();
			i++;
		}
		for (int j = collect.length - 1; j >= 0; j--) {
			System.out.println("j===" + j);
			out += collect[j];
			System.out.println(out);
			if (j != 0) {
				out += "-";
				System.out.println(out);
			}
		}
		System.out.println(className + "--->" + methodName + "---? START");
		return out;
	}

	public static boolean checkStringChar(String str) {
		String methodName = "checkStringChar";
		System.out.println(className + "--->" + methodName + "---? START ");
		boolean out = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) > 47 && str.charAt(i) < 59) {
				out = true;
				break;
			}
		}
		System.out.println(className + "--->" + methodName + "---? END ");
		return out;
	}

}
