package icici_v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TW_Caeser {
	static Map<Integer,Integer> charMap=new HashMap<Integer,Integer>();
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line="";
        while(( line = br.readLine())!=null){
        	
        	char ch[]=line.toCharArray();
        	for(int i=0;i<ch.length;i++){
        		if(ch[i]!= ' ')
        			{
        			ch[i]=encrypt(ch[i]);
        		}
        	}
        	String output=new String(ch);
        	System.out.println(output);
        }
        
	}
	static char encrypt(char input){
		
		int num=(int )input;
		int result=0;
		
		 result=(((num-65)+3)%26)+65;
		
		
		return (char)result;
	}
}
