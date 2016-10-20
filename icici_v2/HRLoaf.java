package icici_v2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HRLoaf {

    public static void main(String[] args) {
       // Scanner in = new Scanner(System.in);
     //   int N = in.nextInt();
       // int B[] = new int[N];
        int N = 5;
        int B[] ={2,3,4,5,6};
        int sum=0;
        for(int B_i=0; B_i < N; B_i++){
          //  B[B_i] = in.nextInt();
            sum+=B[B_i];
                  
    }int result=0;
        if (sum%2!=0){
        	System.out.println("NO");
        }else{
        	for(int i=0;i<N;i++){
        		if(B[i]%2!=0 &&B[i+1]%2!=0){
        			result=result+2;        	
        			System.out.println("afcwadfv");
        			i++;
        		}else if( (B[i]%2!=0 && B[i+1]%2==0)){
        			System.out.println("---"+B[i]);
        			result=result+2;
        			B[i+1]=B[i+1]+1;
        		}
        		
        	}
        	System.out.println(result);
        }
}}
