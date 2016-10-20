package icici_v2;

import java.io.*;

import java.util.*;

public class Lendingkart_Hydra {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

        /*
         * Read input from stdin and provide input before running
*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        
        for (int i = 0; i < N; i++) {
        
        	String input=br.readLine();
        	String str[]=input.split(" ");
        	String key=str[0];
        	String password=str[1];
        	//String result = "Possible";
        	char charArr[] = null;
        	if(password.length()!=(2*key.length())&&(password.length()!=key.length()))
        	{
        		System.out.println("Impossible1");
        		continue;
        	}
        	if(password.equals(key))
        	{
        		System.out.println("Possible");
        		continue;
        	}
        	if(password.indexOf(key)!=-1){
        		//System.out.println(password);
        		charArr=password.toCharArray();
        		int start=password.indexOf(key);
        		StringBuilder sb=new StringBuilder();
        		for(int j=start;j<start+key.length();j++)
        		{
        		//	System.out.println(charArr[j]);
        			charArr[j]='-'; 
        			sb.append("-");
          		}
        		//System.out.println();
        		password=new String(charArr);
        		//System.out.println(password.toString());
        		String modPassword[]=password.split(sb.toString());
        		//System.out.println(modPassword.length);
        		if(modPassword.length==1){
        			password=modPassword[0];
        		}else if(modPassword.length==2){
        		password = modPassword[0]+modPassword[1];
        		
        		}//System.out.println(password);
        		else{
        			System.out.println("Impossible2");
        			continue;
        		}
        		if(password.equals(key))
        			System.out.println("Possible");
        		else
        			System.out.println("Impossible3"+password+"==="+key);
        	}else
        	{
        		System.out.println("Impossible4");
        	}
        	
        }
        

        
    
	}

}
