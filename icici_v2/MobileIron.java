package icici_v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MobileIron {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = ' ';
		// System.out.println((int )c-96);
		int charMap[] = new int[27];
		/*
		 * for(int j=0;j<charMap.length;j++) { System.out.println(charMap[j]); }
		 */
		String str[] = new String[3];
		str[0] = "2";
		str[1] = "The quick brown fox jumps over the lazy dog";
		str[2] = "The quick brown fox jumps over the lazy dog";
		String res = (isPangram(str));
		res = mergeStrings("abc", "defyyyyyyyyyyyyyyyy");
		System.out.println(res);
	}

	static String isPangram(String[] strings) {
		int N = Integer.parseInt(strings[0]);
		String result = "";
		for (int i = 1; i <= N; i++) {

			boolean flag = false;
			int charMap[] = new int[27];
			char inChar[] = strings[i].toCharArray();
			for (int j = 0; j < inChar.length; j++) {
				if (inChar[j] == ' ') {
					continue;
				}
				inChar[j] = Character.toLowerCase(inChar[j]);
				int key = (int) inChar[j] - 96;

				if (charMap[key] == 0) {
					charMap[key] = 1;
				}
			}

			for (int j = 1; j < charMap.length; j++) {
				if (charMap[j] == 0) {
					flag = true;
					break;
				}
			}
			if (flag) {
				result = result + "0";
				continue;
			}
			result = result + "1";

		}
		return result;
	}

	static String mergeStrings(String a, String b) {
		char charA[] = a.toCharArray();
		char charB[] = b.toCharArray();
		Stack<Character> aStack = new Stack<Character>();
		for (int i = charA.length - 1; i >= 0; i--) {
			aStack.push(charA[i]);
		}
		Stack<Character> bStack = new Stack<Character>();
		for (int i = charB.length - 1; i >= 0; i--) {
			bStack.push(charB[i]);
		}
		String result = "";
		List<Character> rList = new ArrayList<Character>();
		while (true) {
			if (!aStack.isEmpty()) {
				rList.add(aStack.pop());
			//	rStack.push(aStack.pop());// = result + aStack.pop();
			} else {
				break;
			}

			if (!bStack.isEmpty()) {
				rList.add(bStack.pop());
			} else {
				break;
			}

		}
		while (!aStack.isEmpty()) {
			rList.add(aStack.pop());
		}

		while (!bStack.isEmpty()) {
			rList.add(bStack.pop());
		}
		StringBuilder sb = new StringBuilder(rList.size());
		for (Character c : rList)
		    sb.append(c);
		String result1 = sb.toString();
		return result1;
	}

}
