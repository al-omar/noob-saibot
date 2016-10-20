package icici_v2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class Test {

    public static void main(String args[]) {
    	String failedOrder="";
    	//Scanner in = new Scanner(System.in);
    	String input="";
    	//while((input=in.nextLine())!=null)
    		
try{
	
	FileReader reader=new FileReader("/home/jadehol1273/approved.txt");
	BufferedReader br= new BufferedReader(reader);
	String line="";
	while((line=br.readLine())!=null)
	{
		
	String arr[]=line.split(",");
	failedOrder=arr[0];
    	String httpsURL = "https://jps.jabong.com/api/payments/v1/_capture/"+arr[0];


    	URL myurl = new URL(httpsURL);
    	HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
    	con.setRequestMethod("POST");

    	String query = "{"+
    					"\"payment_id\":\""+arr[0]
    					+"\","
    					+"\"amount\":\""+arr[1]
    					+"\"}";
    	con.setRequestProperty("Content-Type","application/json"); 
    	con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0;Windows98;DigExt)"); 
    	con.setRequestProperty("Authorization", "BEARER 94c708a5-228c-4366-a8c5-03add455b7d1");
    	con.setDoOutput(true); 
    	con.setDoInput(true); 

    	DataOutputStream output = new DataOutputStream(con.getOutputStream());  


    	output.writeBytes(query);

    	//output.close();

    	DataInputStream input1 = new DataInputStream( con.getInputStream() ); 

        DataOutputStream outputFile = new DataOutputStream(new FileOutputStream("/home/jadehol1273/result_capture.txt",true));
        outputFile.writeByte(con.getInputStream().read());
        outputFile.flush();
    	for( int c = input1.read(); c != -1; c = input1.read() ) 
    	{
    		System.out.print( (char)c) ; 
    		
    	}
    	//input.close(); 
    	
    	

    	System.out.println("Resp Code:"+con .getResponseCode()); 
    	System.out.println("Resp Message:"+ con .getResponseMessage()); 
	}
}
catch(Exception e)
{
	System.out.println("Order failed-"+failedOrder);
	e.printStackTrace();
}
    }

   
}

