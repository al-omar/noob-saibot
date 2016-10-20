package icici_v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MasterBinRouter {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			List<String> mappingList=new ArrayList<String>();
			String bin ="";
			String prefix_ccbins = "INSERT INTO `redwine-db`.`jps_cc_bins` (`bin`,`description`, `issued_by`, `card_type`, `issuing_bank_code`, `card_payment_type`) VALUES(";
			String prefix_gatewaymap = "INSERT INTO `redwine-db`.`jps_cc_gateway_map` (`cc_bin`,`gateway_id`, `is_enabled`, `priority`) VALUES(";
			String postfix = ");";
			int N=Integer.parseInt(br.readLine());
			for(int i=0;i<N;i++){
				bin=br.readLine();
				
				String input[]=bin.split(",");
				if (input.length!=5 || input[1]=="" || input[1]==null || input[4].equalsIgnoreCase("prepaid") 
				|| input[4].equalsIgnoreCase("acquiring bin")){
					continue;
				}
				String binNum="'"+input[0]+"'";
				String description="'"+input[1]+"_"+input[2]+"'";
				String issuedBy="'"+input[1]+"_"+input[2]+"'";
				String cardType="'"+input[3]+"'";
				String issuingBank="'"+input[1]+"'";
				String cardPaymentType="'"+input[4]+"'";
				String midBins = binNum+","+description+","+issuedBy+","+cardType+","+issuingBank+","+cardPaymentType;
				System.out.println(prefix_ccbins+midBins+postfix);
				
				String midMap = binNum+",5,1,1";
				String resultMap=prefix_gatewaymap+midMap+postfix;
				mappingList.add(resultMap);
			}
			for(String s:mappingList)
			{
				System.out.println(s);
			}
	}

}
