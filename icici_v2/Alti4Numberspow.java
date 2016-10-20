package icici_v2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Alti4Numberspow {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		/*
		 * Read input from stdin and provide input before running
		 * 
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String line = br.readLine(); int N =
		 * Integer.parseInt(line); for (int i = 0; i < N; i++) {
		 * System.out.println("hello world"); }
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		
		for (int i = 0; i < N; i++) {
			int Q=Integer.parseInt(br.readLine());
			for(int j=0;j<Q;j++){
				int n =Integer.parseInt(br.readLine());
				int min = callBoss(n);
				System.out.println(min);
			}
		}
		/*
		int x=99;
		double result = (Math.log(x)/Math.log(10));
		System.out.println(result);
		double d=(double)result;
		System.out.println(Math.pow(10, d));
		*/
	}
		public static int callBoss(int n){
			//System.out.println("calculating - "+n);
			int maxLog=(int) Math.sqrt(n);
			double min = 1.0;
			int minI = 2,minLog=2;
			for (int i=2;i<=maxLog+1;i++){
				double log=Math.log(n)/Math.log(i);
				if ((log - (int )log) == 0)
					return 0;
				double diff=0;
				double diff1 = Math.abs(log - (int)log);
				double diff2 = Math.abs(log - (int)log-1);
				if (diff1<diff2)
					diff=diff1;
				else
					diff=diff2;
				//System.out.println(log+"---"+i);
				if (diff<min){
					min = diff; 
					minI=i;
					
					if (log - (int)log <=0.5){
					    minLog=(int)log;
					    } else {
					    	minLog=(int)log+1;
					    }
				}
				/*double newAnswer = Math.pow(i, (int)log);
				double newAnswer2 = Math.pow(i, (int)log+1);
				if(newAnswer2-n<=n-newAnswer && newAnswer2-n<min){
					min = (int) (newAnswer2-n);
					continue;
				}
				if(n-newAnswer<min){
					min=(int)(n-newAnswer);
					continue;
				}*/
				/*if (log-(int)log <= 0.5){
					double newAnswer = Math.pow(i, (int)log);
					if (n-newAnswer<min){
						min=(int)(n-newAnswer);
					}
				} else {
					double newAnswer = Math.pow(i, ((int)log)+1);
					if (newAnswer-n<min){
						min=(int)(newAnswer-n);
					}
				}*/
			}
			return (int)(Math.abs(n-Math.pow(minI, minLog)));
			
			//return min;
		}

}
