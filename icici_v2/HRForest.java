package icici_v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HRForest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N= Integer.parseInt(line);
		for(int i=0;i<N;i++){
		  line=br.readLine();
		  long M=Long.parseLong(line);
		  String H[]=br.readLine().split(" ");
		  List<Long> list=new ArrayList<Long>();
		  for(int j=0;j<M;j++){
			  list.add(Long.parseLong(H[j]));
		  }
		  Collections.sort(list);
		  Set<Long> set=new HashSet<Long>();
		  long max=0;
		  int start=(int)(M/2)-1;
		  for (int j=start;j<start+2;j++){
			  long answer=calculate(j,list);
			  if(answer>max){
				  max=answer;
				 
			  }
			  else
				  break;
			  
		  }
		  System.out.println(max);
		}
		
	}
	public static long calculate(int var,List<Long> H){
		
		long S=var+1;
		long result=0;
		for(int i=var;i<H.size();i++){
			result=result + (S*H.get(i));
			
		}
		System.out.println("----"+result+"=="+var);
		return result;
	}

}
