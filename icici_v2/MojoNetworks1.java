package icici_v2;

import java.util.*;
import java.io.*;

public class MojoNetworks1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		initSet();
		System.out.println(highPowerful("99"));
		/*
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String line = br.readLine(); int N =
		 * Integer.parseInt(line); for (int i = 0; i < N; i++) { String
		 * input=br.readLine(); if(isInfinite(input)){ System.out.println(
		 * "Unlimited Power"); continue; } String higher=highPowerful(input);
		 * String lower=lessPowerful(input); long
		 * higherLong=Long.parseLong(higher); long
		 * lowerLong=Long.parseLong(lower); long original=Long.parseLong(input);
		 * 
		 * long numer=higherLong-original; long denom=original-lowerLong;
		 * if(numer%denom==0){ numer=numer/denom; denom=1; }
		 * System.out.println(numer+"/"+denom); }
		 */

	}

	static boolean isInfinite(String input) {
		char inChar[] = input.toCharArray();
		for (int i = 0; i < inChar.length; i++) {
			if (!evenSet.contains(inChar[i]))
				return false;
		}
		return true;
	}

	static Set<Character> evenSet = new HashSet<Character>();

	public static void initSet() {
		evenSet.add('0');
		evenSet.add('2');
		evenSet.add('4');
		evenSet.add('6');
		evenSet.add('8');
	}

	public static int increment(char ch) {
		if (ch != '9')
			return ((((int) ch) % 48) + 1) % 10;
		else
			return 2;
	}

	public static int decrement(char ch) {
		return ((((int) ch) % 48) + 9) % 10;
	}

	public static String highPowerful(String input) {
		if (input.toCharArray().length == 1) {

			switch (input) {
			case "1":
				return "2";
			case "3":
				return "4";
			case "5":
				return "6";
			case "7":
				return "8";
			case "9":
				return "20";
			}
		}
		char inChar[] = input.toCharArray();

		int pos = 0;
		for (int i = 0; i < inChar.length; i++) {

			if (!evenSet.contains(inChar[i])) {
				pos = i;
				break;
			}

		}
		if (pos != inChar.length - 1) {
			inChar[pos] = (char) (increment(inChar[pos]) + 48);

			for (int i = pos + 1; i < inChar.length; i++) {
				inChar[i] = '0';
			}
			if (inChar[inChar.length - 1] == '0')
				return String.valueOf(inChar) + "0";
			else
				return String.valueOf(inChar);
		} else {
			if(inChar[pos]!='9'){
				inChar[pos]=(char)(increment(inChar[pos])+48);
			}
			else{
				
			}
		}

		return String.valueOf(inChar);

	}

	public static String lessPowerful(String input) {
		if (input.length() == 1) {

			switch (input) {
			case "1":
				return "0"; // should not happen
			case "3":
				return "2";
			case "5":
				return "4";
			case "7":
				return "6";
			case "9":
				return "8";
			}
		}
		char inChar[] = input.toCharArray();

		int pos = 0;
		for (int i = 0; i < inChar.length; i++) {

			if (!evenSet.contains(inChar[i])) {
				pos = i;
				break;
			}

		}
		inChar[pos] = (char) (decrement(inChar[pos]) + 48);

		for (int i = pos + 1; i < inChar.length; i++) {
			inChar[i] = '8';
		}
		long result = Long.parseLong(String.valueOf(inChar));
		long initial = Long.parseLong(input);
		/*
		 * if(initial>result) return result+"0"; else
		 */
		return String.valueOf(inChar);

	}
}
