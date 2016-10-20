package icici_v2;

import java.util.*;
import java.io.*;

public class MojoNetworks_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		//for (int i = 0; i < N; i++) {
			String str[] = br.readLine().split(" ");
			List<Long> list = new ArrayList<Long>();

			for (int j = 0; j < str.length; j++) {
				list.add(Long.parseLong(str[j]));
			}
			Collections.sort(list);
			int left = 0, right = list.size() - 1;
			long result = 0;
			boolean flag=true;
			while (left < right) {
				result=result+Math.abs(list.get(left)-list.get(right));
				if(flag){
					left++;
					flag=false;
				}else{
					right--;
					flag=true;
				}
				
				
			}
			left=0;
			right=list.size()-1;
			long result2 = 0;
			flag=false;
			while (left < right) {
				result2=result2+Math.abs(list.get(left)-list.get(right));
				if(flag){
					left++;
					flag=false;
				}else{
					right--;
					flag=true;
				}
				
				
			}
			System.out.println(result>result2?result:result2);
		//}

	}

}
