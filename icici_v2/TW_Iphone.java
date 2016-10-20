package icici_v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Country{
	public int iPhone_Q;
	public int iPod_Q;
	public int iPhone_P;
	public int iPod_P;
	public Country(int iPhone_Q, int iPod_Q,int iPhone_P, int iPod_P){
		this.iPhone_Q=iPhone_Q;
		this.iPod_Q=iPod_Q;
		this.iPhone_P=iPhone_P;
		this.iPod_P=iPod_P;
	}
	public Country(){
		
	}
	
}

public class TW_Iphone {
	static double sales_price=0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line="";
        while(( line = br.readLine())!=null){
        	sales_price=0;
        	
        	int i=0;
        	boolean hasPassport =false;
        	String passport="";
        	Map<String,Integer> itemMap = new HashMap<String,Integer>();
        	String input[]=line.split(":");
        	String purCountry = input[i++];
        	if(input[1].charAt(0)=='A' || input[1].charAt(0)=='B'){
        		 passport = input[i++];
        		hasPassport = true;
        	}
        	
        	for (int j=i;j<input.length;j++){
        		String itemName = input[j++];
        		int quantity = Integer.parseInt(input[j]);
        		itemMap.put(itemName, quantity);
        	}
        	//reading done
        	String remaingStock = processRequest(input[0], itemMap,passport);
        	System.out.println((int)sales_price+":"+remaingStock);
        }
        
	
	}
	public static double calculateShipping(int  unitPrice,int demandQuantity, int shipQuantity, boolean discountApplicable){
		if (!discountApplicable){
			return ((unitPrice*demandQuantity)+(40*shipQuantity));
		} else
			return ((unitPrice*demandQuantity)+(40*shipQuantity)-(40*shipQuantity*0.2));
	}
	public static Integer calculateLocal(int  unitPrice, int quantity){
		return unitPrice*quantity;
	}
	public static String processRequest(String country, Map<String,Integer> demand, String... passport){
		boolean discountApplicable=false;
		Country argentina = new Country(50,100,150,100);
		Country brazil = new Country(100,100,100,65);
		Country hostCountry = new Country();
		Country foreignCountry= new Country();;
		if(country.equalsIgnoreCase("brazil")){
			hostCountry = brazil;
			foreignCountry = argentina;
		}else if(country.equalsIgnoreCase("argentina")){
			hostCountry = argentina;
			foreignCountry = brazil;
		}
		if(passport.length>0){
			if(country.equalsIgnoreCase("brazil") && (passport[0].charAt(0)=='A' || passport[0].charAt(0)=='a')){
				discountApplicable = true;
			} else 
				if(country.equalsIgnoreCase("argentina") && (passport[0].charAt(0)=='B' || passport[0].charAt(0)=='b')){
					discountApplicable = true;
				}				
		}
		for (Map.Entry<String, Integer> item : demand.entrySet()) {
			String itemType = item.getKey();
			int itemDemand = item.getValue();
			if (itemType.equalsIgnoreCase("iphone")) {
				if (itemDemand <= hostCountry.iPhone_Q) {
					sales_price += calculateLocal(hostCountry.iPhone_P, itemDemand);
					hostCountry.iPhone_Q = hostCountry.iPhone_Q-itemDemand;
				} else {
					
					sales_price += calculateLocal(hostCountry.iPhone_P, hostCountry.iPhone_Q);
					int remaining = 0;
					if (((itemDemand - hostCountry.iPhone_Q) % 10) == 0) {
						remaining = itemDemand - hostCountry.iPhone_Q;
					} else {
						remaining = (itemDemand - hostCountry.iPhone_Q) / 10;
						remaining = (remaining + 1) * 10;
					}
					sales_price += calculateShipping(hostCountry.iPhone_P, itemDemand - hostCountry.iPhone_Q, remaining,
							discountApplicable);
					hostCountry.iPhone_Q=hostCountry.iPhone_Q+remaining-itemDemand;
					foreignCountry.iPhone_Q=foreignCountry.iPhone_Q-remaining;
				}

			} else if (itemType.equalsIgnoreCase("ipod")) {

				if (itemDemand <= hostCountry.iPod_Q) {
					sales_price += calculateLocal(hostCountry.iPod_P, itemDemand);
					hostCountry.iPod_Q = hostCountry.iPod_Q-itemDemand;
				} else {
					hostCountry.iPod_Q=0;
					sales_price += calculateLocal(hostCountry.iPod_P, hostCountry.iPod_Q);
					int remaining = 0;
					if (((itemDemand - hostCountry.iPod_Q) % 10) == 0) {
						remaining = itemDemand - hostCountry.iPod_Q;
					} else {
						remaining = (itemDemand - hostCountry.iPod_Q) / 10;
						remaining = (remaining + 1) * 10;
					}
					sales_price += calculateShipping(hostCountry.iPod_P, itemDemand - hostCountry.iPod_Q, remaining,
							discountApplicable);
					hostCountry.iPod_Q=hostCountry.iPod_Q+remaining-itemDemand;
					foreignCountry.iPod_Q=foreignCountry.iPod_Q-remaining;
				}

			}

		}
		String result="";
		if(country.equalsIgnoreCase("brazil")){
			result=hostCountry.iPod_Q+":"+foreignCountry.iPod_Q+":"+hostCountry.iPhone_Q+":"+foreignCountry.iPhone_Q;
		}else{
			result=foreignCountry.iPod_Q+":"+hostCountry.iPod_Q+":"+foreignCountry.iPhone_Q+":"+hostCountry.iPhone_Q;
		}
		return result;
	}
	

}
