package icici_v2;

import java.io.*;
import java.util.*;

public class TW_HackerEarth {

	static List<Integer> primeList =new ArrayList<Integer>();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		generateList();
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);
	        int group=findSmallerPrime(N);
	        line = br.readLine();
	        String inArrStr[]=line.split(" ");
	        long inArr[]=new long[inArrStr.length];
	        for (int i = 0; i < inArrStr.length; i++) {
	            inArr[i]=Long.parseLong(inArrStr[i]);
	        }
	        long sum=0;
	        int head=0,maxHead=0;
	        int tail=group-1,maxTail=group-1;
	        while(tail<N){
	        	long result=findSum(inArr,head,tail);
	        	if (result>sum){
	        		sum=result;
	        		maxHead=head;
	        		maxTail=tail;
	        	}
	        	//break;
	        	head++;
	        	tail++;
	        }
	        if (maxHead > 2){
	        	group=findSmallerPrime(maxHead-1);
	        //	head=0;tail=group-1;
	        	long result=findSum(inArr,0,group);
	        	sum+=result;
	        }
	        N=N-1;
	        if (N-maxTail >2 ){
	        	//System.out.println("N="+N);
	        //	System.out.println("tail="+tail);
	        	group=findSmallerPrime(N-maxTail-1); 
	        	//System.out.println("group="+group);
	        	long result=findSum(inArr,maxTail+2,maxTail+group+1);
	        	sum+=result;
	        	
	        }
	        
		System.out.println(sum);
	}
	public static long findSum(long[] inArr,int head,int tail){
		long sum=0;
		for(int i = head;i <= tail;i++){
			sum+=inArr[i];
			
		}
		return sum;
	}
	
	public static int findSmallerPrime(int N){
		Collections.sort(primeList);
		int smaller=0;
		for(int i:primeList){
			if(i<=N){
				smaller=i;
			}
			else{
				break;
			}
		}
		return smaller;
	}
	public static void generateList()
	{
		
	int n=5000;
	boolean primes[]=new boolean[5000];
	for(int i=0;i<primes.length;i++)
	{
		primes[i]=true;
	}
		 for (int i=2; i*i<n; i++)
		    {
		       if (primes[i] == true)
		        {   for (int j=i*2; j<n; j += i)
		                primes[j] = false;		        
		        }
		    }
		 primeList.add(2);
	//	 System.out.println(2);
		 for(int i=3;i<n;i=i+2){
			 if(primes[i])
			 {
				 primeList.add(i);
				 //System.out.println(i);
			 }
		 }
		 
	}

}
