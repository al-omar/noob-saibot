package icici_v2;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

//import org.json.JSONObject;

public class FreechargeChecksum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		Map<String,String> map=new TreeMap<String,String>();
		map.put("channel", "THROUGH_SMS");
		map.put("merchantId", "K6971Hb9mY94Ml");
		map.put("otpId","27dac6b9-40f4-4792-86cb-cbe246630537");
	//	org.json.JSONObject json = new JSONObject(map);
		//System.out.println(json.toString());
		String jsonString="{\"amount\":\"2.00\",\"channel\":\"WEB\",\"instructionType\":\"LOAD_DEFAULT\",\"mobileNumber\":\"9716587427\",\"transactionRefNumber\":\"123456789\"}";
		String Merchantkey="11b21366-2140-439d-9f2e-cb768277e8c4";
		MessageDigest md = null;
		String plainText = jsonString.toString().concat(Merchantkey);
		try
		{
		md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e)
		{
		}
		md.update(plainText.getBytes(Charset.defaultCharset()));
		byte[] mdbytes = md.digest();
		// convert the byte to hex format method 1
		StringBuffer checksum = new StringBuffer();
		for (int i = 0; i < mdbytes.length; i++)
		{
		checksum.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		System.out.println(checksum);
	
	}
	

}
