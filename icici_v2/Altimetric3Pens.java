package icici_v2;
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/

import java.io.*;
import java.util.*;

class Altimetric3Pens {
		public static void main(String args[]) throws Exception {
			/*
			 * Read input from stdin and provide input before running
			 */
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			int N = Integer.parseInt(line);
			String line1, line2, line3;
		
			for (int i = 0; i < N; i++) {
				Set<Integer> penSet = new HashSet<Integer>();
				boolean theycant = false;
				
				line1 = br.readLine();
				String npm[] = line1.split(" ");
				int n = Integer.parseInt(npm[0]);
				int p = Integer.parseInt(npm[1]);
				int m = Integer.parseInt(npm[2]);
				if (p+m<n){
					System.out.println("They can't");
					br.readLine();
					br.readLine();
					continue;
				}
				String pPens[] = br.readLine().split(" ");
				for (String id : pPens) {
					penSet.add(Integer.parseInt(id));
				}
				String mPens[] = br.readLine().split(" ");
				for (String id : mPens) {
					penSet.add(Integer.parseInt(id));
				}
				
				for(int j=1;j<=n;j++){
					if (!penSet.contains(j)){
						theycant=true;						
						break;
					}
					
				}
				if (theycant)
					System.out.println("They can't");
				else
					System.out.println("They can");
				
			}
	
		}
}
