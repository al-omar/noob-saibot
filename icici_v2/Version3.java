package icici_v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;

public class Version3  {

	public static void main(String[] args) throws InterruptedException, IOException {

        /*
         * Read input from stdin and provide input before running
*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int inArr[]=new int[N];
        boolean isSquare[]=new boolean[N];
        HashMap responseArray[] = new HashMap[N];
        for (int i = 0; i < N; i++) {
        	inArr[i]=Integer.parseInt(br.readLine());
        	isSquare[i]=isPerfectSquare(inArr[i]);
        	responseArray[i]=(HashMap) findFactors(inArr[i]);
        }
        int count=0;
        for(int i=0;i<N-1;i++)
        {
        	for(int j=i+1;j<N;j++)
        	{
        		if (isSquare[i] && isSquare[j])
        		{
        			count++;
        			continue;
        		}
        		else
        		{
        			Map<Integer,Integer> m1=responseArray[i];
        			Map<Integer,Integer> m2=responseArray[j];
        			for(Map.Entry<Integer,Integer> e : m1.entrySet())
        			{
        				int key=e.getKey();
        				int keyCount=e.getValue();
        				
        				if(m2.get(key)==null)
        				{
        					m2.put(key,keyCount);
        				}
        				else{
        					int m2Count=m2.get(key);
        					m2.put(key,m2Count+keyCount);
        				}
        			}
        			boolean flag=false;
        			for(Map.Entry<Integer,Integer> e : m2.entrySet())
        			{
        				if(e.getValue()%2 !=0)
        				{
        					flag=true;
        					break;
        				}
        				if(!flag)
        					count++;
        			}
        		}
        	}
        }

     int total=N*(N-1)/2;
     BigDecimal dCount = new BigDecimal(count).setScale(6, BigDecimal.ROUND_HALF_UP);
     BigDecimal dTotal = new BigDecimal(total).setScale(6, BigDecimal.ROUND_HALF_UP);
     System.out.println(dCount.divide(dTotal, 6, BigDecimal.ROUND_UP));
    
		
	}
	
	public static boolean isPerfectSquare(int n){
		int sum=0;
		for(int i=1;i<=n;i=i+2)
		{
			sum+=i;
		}
		if(sum==n)
			return true;
		else return false;
		
	}
	
	public static Map findFactors(int n)
	{
		Map result=new HashMap();
		int factor=2;
		while(n>1)
		{
			while(n%factor ==0)
			{
				if(result.get(factor)==null){
					result.put(factor, 1);
					
				}
				else
				{
					int current=(int) result.get(factor);
					result.put(factor, current+1);
					
				}
				n=n/factor;
			}
				factor++;
		}
		return result;
	}

}
