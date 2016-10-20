package icici_v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class HDFCCapture {

	public static void main(String[] args) throws IOException {
        /*
         * Read input from stdin and provide input before running

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        */
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String line = br.readLine();
        int N = 1;
        String arr[];
        Set pFactors = new HashSet();
        for (int i = 0; i < N; i++) {
        	//arr=br.readLine().split(" ");
        	long m = Long.parseLong("2");
        	long f = Long.parseLong("4");
        	long mflcm = lcm(m, f);
        	System.out.println(mflcm);
        	pFactors = primeFactors(mflcm);
        	System.out.println(pFactors.size());
        	if(isPrime(pFactors.size()))
        	{
        		System.out.println("Yes");
        	}
        	else {
				System.out.println("No");
			}
        }
        
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
	
	public static long lcm(long a, long b)
	{
		
		long max=a>b?a:b;
		long  min=a<b?a:b;
		 long x=1,lcm=1;
		for(int i=1;i<=min;i++)
		   {
		    x=max*i; 
		    if(x%min==0) 
		     {
		      lcm=x; 
		      break; 
		     }
		    }
		return lcm;
	}
	
	public static boolean isPrime(int n) {
		
		if(n==2)
			return true;
	    
	    if (n%2==0 || n==1) 
	    	return false;
	    
	    for(long i=3;i<=Math.ceil(Math.sqrt(n));i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

}
