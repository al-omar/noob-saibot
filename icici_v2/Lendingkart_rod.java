package icici_v2;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Lendingkart_rod {

	public static void main(String[] args) throws Exception {
    	
    	
		// TODO Auto-generated method stub

        /*
         * Read input from stdin and provide input before running
*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
         int count=0;
        	long rod=Long.parseLong(br.readLine());
        	boolean unevenRod=true;
        	while(rod>1){
        		if(rod%2 == 0){
        			
        			System.out.println("0");
        			unevenRod=false;
        		break;
        		}else{
        		rod = rod>>1;
        		count++;
        		}
        	}
        	if(unevenRod)
        	System.out.println(count);
        	}
      	
    }

}
