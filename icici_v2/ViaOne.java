package icici_v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ViaOne {
static List<Integer> globalList=new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		System.out.println("asdcsa");
		// TODO Auto-generated method stub
		createAllPalindromes();
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);

	       for (int i = 0; i < N; i++) {
	            String times[]=br.readLine().split(" ");
	            int st=Integer.parseInt(times[0]);
	            int et=Integer.parseInt(times[1]);
	            int count=0;
	            for (int j=st;j<=et;j++){
	            	if (globalList.contains(j)){
	            		count++;
	            	}
	            }
	            System.out.println(count);
	        }
	 System.out.println("ascd");       
	}
	
	public static void createAllPalindromes(){
		globalList.add(0);
		globalList.add(110);
		globalList.add(220);
		globalList.add(330);
		globalList.add(330);
		globalList.add(550);
		globalList.add(660);
		globalList.add(770);
		globalList.add(880);
		globalList.add(990);
		globalList.add(1001);
		globalList.add(1111);
		globalList.add(1221);
		globalList.add(1331);
		globalList.add(1441);
		globalList.add(1551);
		globalList.add(2002);		
		globalList.add(2112);
		globalList.add(2222);
		globalList.add(2332);
	}

}
