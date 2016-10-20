package icici_v2;

import java.util.*;
import java.io.*;
import java.lang.*;
	class Sapient {
	 public static void main(String arg[]) throws IOException {
		 //BufferedReader
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);
      Map<Integer,Integer> primeFactorMap = new HashMap<Integer,Integer>();
      primeFactorMap.put(1, 1);
	        for (int i = 0; i < N; i++) {
	            int num=Integer.parseInt(br.readLine());
	            if(primeFactorMap.containsKey(num)){
	            	System.out.println(primeFactorMap.get(num));
	            } else {
	            	int result=0;
	            	Set resultSet=primeFactors(new Long(num));
	            	if (resultSet.size()==1){
	            		result=2;
	            		primeFactorMap.put(num, result);
	            	} else 
	            	if (resultSet.size()==2){
	            		result=4;
	            	} else{
	            		result=2+(2*resultSet.size());
	            	}
	            	
	            //	System.out.println(primeFactors(new Long(num)));
	            	primeFactorMap.put(num, result);
	            	System.out.println(result);
	            }
	        }
	        System.out.println(primeFactors(84));
	 
	 }
	 public static Set primeFactors(long  n)
		{
			Set result=new HashSet();
			while(n%2==0)
			{
				result.add(2);
				n=n/2;
			}
			for (long i=3;i<=Math.ceil(Math.sqrt(n));i=i+2)
			{
				while(n%i==0)
				{	result.add(i);
					n=n/i;
				}
			}
			if(n>2)
				result.add(n);
			
			return result;
		}
	}