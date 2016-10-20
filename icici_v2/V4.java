package icici_v2;

import java.io.*;
import java.util.*;
import java.math.*;
public class V4 {

	public static void main(String[] args) {
		
		Scanner sin=new Scanner(System.in);
		List<Integer> primes=generatePrime();
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		Map<String,Integer> inputMap=new HashMap<String,Integer>();
		int i='a';
		for(int j=0;j<26;j++)
		{
			map.put(i, primes.get(j));
			i++;
		}
		String str="";
		while(sin.hasNextLine())
		{
			str=sin.nextLine();
			int value=1;
			char ch[]=str.toCharArray();
			for(int j=0;j<ch.length;j++)
			{
				if(ch[j]!=' ')
				value=value*map.get(ch[j]);
			}
			inputMap.put(str, value);
			
		}
		for (Map.Entry<String, Integer> entry : inputMap.entrySet())
		{
		    System.err.println(entry.getKey() + "/" + entry.getValue());
		}
		
		
		
	}
	
	public static List<Integer> generatePrime()
	{
		int count =0;
		int status=1;
		List<Integer> prime=new ArrayList<Integer>();
		prime.add(2);
		count++;
		int num=3;
		while(count<26)
		{
			for(int i=2;i<=Math.sqrt(num);i++)
			{
				if(num%i==0)
				{
					status=0;
					break;
					
				}
			}
			 if ( status != 0 )
	         {
				 prime.add(num);
				 count++;
	         }
	         status = 1;
	         num++;
		}
		return prime;
	}

}
