package icici_v2;

import java.io.*;
import java.util.*;


public class Quintype_Taxi {
	static List<Taxi> taxiList=new ArrayList<Taxi>();
	static Set<Taxi> busyTaxiSet=new HashSet<Taxi>();
	static boolean allBusy=false;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line[] = br.readLine().split(" ");
	        long N = Long.parseLong(line[0]);
	        long M = Long.parseLong(line[1]);
	        
	        List<User> userList=new ArrayList<User>();
	        for(int i=0;i<M;i++){
	        	taxiList.add(new Taxi(i, true,0,0));
	        }
	        for (int i = 0; i < N; i++) {
	            String user[]=br.readLine().split(" ");
	            long startTime=Long.parseLong(user[0]);
	            long travelTime=Long.parseLong(user[1]);
	            userList.add(new User(i, startTime, travelTime));
	        }
	        Collections.sort(userList,User.userTimeComparator);
	        Collections.sort(taxiList,Taxi.taxiIdComparator);
	        long currentTime=0;
	        for (User user : userList){   
	        	currentTime=user.startTime;	  
	        	refreshTaxiList(currentTime);
	        	long result=findTaxi(user);
	        	user.taxiAssigned=result;
	        	      	
	        	
	        }
	        Collections.sort(userList,User.userIdComparator);
	        String output="";
	        for(User user:userList){
	        	output=output+user.taxiAssigned+" ";
	        }
	        System.out.print(output.substring(0, output.length()-1));
	        
	}
	public static void refreshTaxiList(long currentTime){
		allBusy=true;
		Iterator<Taxi> it=busyTaxiSet.iterator();
		while(it.hasNext()){
			Taxi taxi=it.next();
				if(currentTime > taxi.stopTime){
				
				taxiList.get(taxi.id).startTime=0;
				taxiList.get(taxi.id).stopTime=0;
				taxiList.get(taxi.id).isFree=true;
				allBusy=false;
				busyTaxiSet.remove(taxi);
			}
		}
		
	
	}
	public static long findTaxi(User user){
		if(allBusy)
			return -1;
		for(Taxi taxi: taxiList){
			//System.out.println("checking taxi "+taxi.id+" for user "+user.userId);
			if (taxi.isFree){
				taxi.startTime=user.startTime;
				taxi.stopTime=user.startTime+user.duration;
				taxi.isFree=false;
				busyTaxiSet.add(taxi);
		//	System.out.println("giving taxi "+taxi.id+" till "+taxi.stopTime);
				return taxi.id+1;
			}
		}
		
		return -1;
	}

}
class Taxi {
	Integer id;
	boolean isFree;
	long startTime;
	long stopTime;
	public Taxi(int id, boolean isFree,long startTime,long stopTime) {
		super();
		this.id = id;
		this.isFree = isFree;
		this.startTime=startTime;
		this.stopTime=stopTime;
	}
	public static Comparator<Taxi> taxiIdComparator = new Comparator<Taxi>() {

		public int compare(Taxi s1, Taxi s2) {
		  
		   return s1.id.compareTo(s2.id);

		   //descending order
		   //return StudentName2.compareTo(StudentName1);
	    }};
	    @Override
	    public int hashCode() {
	       return id;
	    }
}
class User{
	Long userId;
	Long startTime;
	long duration;
	long taxiAssigned;
	public User(long userId, long startTime, long duration) {
		super();
		this.userId = userId;
		this.startTime = startTime;
		this.duration = duration;
	}
	   public static Comparator<User> userTimeComparator = new Comparator<User>() {

			public int compare(User s1, User s2) {
			  
			   return s1.startTime.compareTo(s2.startTime);

			   //descending order
			   //return StudentName2.compareTo(StudentName1);
		    }};
		    public static Comparator<User> userIdComparator = new Comparator<User>() {

				public int compare(User s1, User s2) {
				  
				   return s1.userId.compareTo(s2.userId);

				   //descending order
				   //return StudentName2.compareTo(StudentName1);
			    }};
}
