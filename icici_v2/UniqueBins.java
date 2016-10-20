package icici_v2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class UniqueBins {

	public static void main(String[] args) throws Exception {
		
		// TODO Auto-generated method stub
		Set<String> set=new TreeSet<String>();
		
		Scanner sin =new Scanner(System.in);
		//System.out.println("afvrvfe");
		
		while(sin.hasNextLine())
		{
			String str=sin.nextLine();
		//	System.out.println(str);
			boolean x=set.add(str);
		//	System.out.println(x);
		//	System.out.println(set.size());
			if(set.size()==1679)
				break;
			
		}
		
		
	//	System.out.println("sadvfsdv");
		
		for(String i:set)
		{
			System.out.println(i);
		}
}

}
