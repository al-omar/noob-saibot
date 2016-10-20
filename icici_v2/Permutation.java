package icici_v2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Permutation {
    public static void main(String[] args) throws Exception {
    permutation("12345");
    
    }
    static void permutation(String str)
    {
    	permutation(str,"");
    }
    
    static void permutation(String str, String prefix){
    //	System.out.println("calling with str"+str+"and prefix-"+prefix);
    	if(str.length()==0)
    	{
    		System.out.println("===>"+prefix);
    	}
    	else
    	{
    		for(int i=0;i<str.length();i++)
    		{
    			String rem = str.substring(0,i)+str.substring(i+1);
    System.out.println("str:"+str+" pref:"+prefix);		
    //my aim is to keep on adding characters in prefix till str becomes 0 or prefix becomes of size n
    			permutation(rem,prefix+str.charAt(i));
    		}
    	}
    }

}

