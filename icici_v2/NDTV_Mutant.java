package icici_v2;

import java.io.*;
import java.util.*;

public class NDTV_Mutant {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		String temp = "";
		for (int i = 0; i < tc; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > 26) {
				System.out.println("NO");
				for (int j = 0; j < num; j++) {
					temp = br.readLine();
				}
				continue;
			}
			int arr[] = new int[128];
			boolean duplicate = false;
			for (int j = 0; j < num; j++) {
				char ch = br.readLine().charAt(0);
				if (!duplicate) {
					if (arr[ch] == 0) {
						arr[ch] = 1;
					} else {
						duplicate = true;
					}
				}
			}
			if (duplicate)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}

}
