package icici_v2;
import java.io.*;
import java.util.*;

public class AltiMetric1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
        	
        	String strA[]=br.readLine().split(" ");
        	String strB[]=br.readLine().split(" ");
        	String strC[]=br.readLine().split(" ");
        	String strD[]=br.readLine().split(" ");
        	
        	long a[]=new long[2];
        	long b[]=new long[2];
        	long c[]=new long[2];
        	long d[]=new long[2];
        	
        	a[0] = Integer.parseInt(strA[0]);
        	b[0] = Integer.parseInt(strB[0]);
        	c[0] = Integer.parseInt(strC[0]);
        	d[0] = Integer.parseInt(strD[0]);
        	a[1] = Integer.parseInt(strA[1]);
        	b[1] = Integer.parseInt(strB[1]);
        	c[1] = Integer.parseInt(strC[1]);
        	d[1] = Integer.parseInt(strD[1]);
        	
        	int o1=orientation(a,c,b);
        	int o2=orientation(a,c,d);
        	int o3=orientation(b,d,a);
        	int o4=	orientation(b,d,c);
        	
        	if (o1 != o2 && o3 != o4)
                System.out.println("No");
        	else
        		System.out.println("Yes");
        }
        
	}
	
		static int orientation(long p1[],long p2[], long p3[])
		{
			long res = (p2[1]-p1[1])*(p3[0]-p2[0]) - (p3[1]-p2[1])*(p2[0]-p1[0]);
			if (res==0) return 0; 
			if(res>0) return 1;
			else
				return 2;
		}

}
