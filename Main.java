/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the 
   standard library */

/* Do not add a namespace declaration */
public class Main {
	public static Map<String, Integer> processData(ArrayList<String> array) {
		/*
		 * Modify this method to process `array` as indicated in the question.
		 * At the end, return the appropriate value.
		 *
		 * Please create appropriate classes, and use appropriate data
		 * structures as necessary.
		 *
		 * Do not print anything in this method.
		 *
		 * Submit this entire program (not just this method) as your answer
		 */
		Map<String, Integer> retVal = new HashMap<String, Integer>();
		Map<String, Integer> maxMap = new HashMap<String, Integer>();
		String studentDetails[] = null;
		for (String singleRecord : array) {
			studentDetails = singleRecord.split("\\|");
			int studentId=Integer.parseInt(studentDetails[0]);
			int studentMarks = Integer.parseInt(studentDetails[2]);
			String subject = studentDetails[1];
			if (maxMap.containsKey(subject)) {
				if (maxMap.get(subject) < studentMarks) {
					maxMap.put(subject, studentMarks);
					retVal.put(subject, studentId);
				}
			} else {
				maxMap.put(subject, studentMarks);
				retVal.put(subject, studentId);
			}
		}
		return retVal;
	}

	public static void main(String[] args) {
		ArrayList<String> inputData = new ArrayList<String>();
		String line;
		try {
			Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));
			while (in.hasNextLine())
				inputData.add(in.nextLine());
			Map<String, Integer> retVal = processData(inputData);
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
			for (Map.Entry<String, Integer> e : retVal.entrySet())
				output.println(e.getKey() + ": " + e.getValue());
			output.close();
		} catch (IOException e) {
			System.out.println("IO error in input.txt or output.txt");
		}
	}
}