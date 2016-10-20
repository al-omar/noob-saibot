package icici_v2;

import java.io.*;
import java.util.*;

import javafx.geometry.Pos;

public class Rerouter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sin=new Scanner(System.in);
		while(sin.hasNext()){
			int bin=sin.nextInt();
			
		//	String prefix0 = "insert into `redwine-db`.`jps_cc_bins` (`bin`, `description`, `issued_by`, `card_type`, `issuing_bank_code`, `card_payment_type`) VALUES";
			String prefix="insert into `redwine-db`.`jps_cc_gateway_map` (`cc_bin`, `gateway_id`, `is_enabled`, `priority`) VALUES";
			
			
			String mid="('"+bin+"'";
		///	String postfix0= ", 'ICICI MASTERCARD CREDIT CARD', 'ONUS_CREDIT', 'MASTERCARD', 'ICICI', CREDIT_CARD);";
			String postfix=", 1, 1, 1);";
			System.out.println(prefix+mid+postfix);
		}
	}

}
