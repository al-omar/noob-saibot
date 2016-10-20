package icici_v2;

import java.io.*;
import java.util.*;

public class TW2 {
	static int maxAllowed=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s=new Scanner(System.in);
		int K=s.nextInt();
		List<Integer> taskList=new ArrayList<Integer>();
		int total=0;
		for(int i=0;i<K;i++)
		{
			int importance=s.nextInt();
			taskList.add(importance);
			total+=importance;
		}
		Collections.sort(taskList);
		 maxAllowed=total/3;
		 
	/*	List<Integer> partial = new ArrayList<Integer>();
		find(taskList, partial, maxAllowed);
		
		taskList.removeAll(maxList);
		
		partial = new ArrayList<Integer>();
		maxList = new ArrayList<Integer>();
		flag=false;
		maxUsed = 0;
		find(taskList, partial, maxAllowed);
		
		taskList.removeAll(maxList);
		
		int result=0;
		for(Integer i : taskList)
		{
			//System.out.println(i);
			result+=i;
		}
		System.out.println(result);*/
		 int result=0;
		 for(int i=taskList.size()-1;i>=0;i--)
		 {
			 if(result+taskList.get(i)<maxAllowed){
				 result+=taskList.get(i);
			 }
			 else{
				 int a=result;
				 for(int j=0;j<=i;j++)
				 {
					 if(result+taskList.get(j)>maxAllowed){
						 a+=taskList.get(j);
						 break;
					 }
				 }
				 int b=result+taskList.get(i);
				 int diffa =maxAllowed -a;
				 int diffb=maxAllowed-b;
				 if(diffa>diffb){
					 result=b;
					 
				 }else{
					 result =a;
				 }
				 //result+=taskList.get(0);
				 break;
			 }
			 
		 }
		 System.out.println(result);
	}
	static List<Integer> maxList = new ArrayList<Integer>();
	static boolean flag=false;
	static int maxUsed = 0;
	private static void find(List<Integer> input, List<Integer> partial, int sum) {
		int total = 0;
		if(flag) return;
		//System.out.println("partial list is "+Arrays.toString(partial.toArray()));
		for (Integer i : partial) {
			total += i;
		}
		if(total > maxAllowed)
		{
			return;
		}
		if (total == maxAllowed) {
			maxList = partial;
			flag = true;
			return;
		}
		if (total > maxUsed) {
			maxList = partial;
			maxUsed=total;
		}
		
		
		for (int i = 0; i < input.size(); i++) {
			int n = input.get(i);
			List<Integer> remain = new ArrayList<Integer>();
			for (int j = i + 1; j < input.size(); j++) {
				remain.add(input.get(j));
			}
			List<Integer> partial_recursive=new ArrayList<Integer>(partial);
			partial_recursive.add(n);
			find(remain,partial_recursive,sum);
		}
	}
}
