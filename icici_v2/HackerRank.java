package icici_v2;

import java.util.*;

public class HackerRank {
	public static void main(Integer[] a) {
		// TODO Auto-generated method stub
		TreeMap<Integer,List<Integer>> map=new TreeMap<Integer,List<Integer>>(); 
for(int i=0;i<a.length;i++){
	int count=countOnes(a[i]);
	if(!map.containsKey(count)){
		List<Integer> linkList=new LinkedList<Integer>();
		linkList.add(a[i]);
		map.put(count, linkList);
	}else{
		List<Integer> linkList=map.get(count);
		linkList.add(a[i]);
		map.put(count, linkList);
	}
	//Collections.sort(map);
	
}
List<Integer> sortedKeys=new ArrayList<Integer>(map.keySet());
Collections.sort(sortedKeys);
Collections.reverse(sortedKeys);
for(int i=0;i<sortedKeys.size();i++)
{
	Integer mList=map.get(sortedKeys).get(i);}//wrong code
NavigableMap<Integer,List<Integer>> nMap=map.descendingMap();
for(Map.Entry<Integer,List<Integer>> m: nMap.entrySet()){
	
	List<Integer> list=m.getValue();
	for(Integer i:list){
		System.out.println(i);
	}
	
	
}
	}
   static int countOnes(int num){
	   
	   int result=0;
	   while(num>0){
		   if(num%2 !=0 )
			   result++;
		   num=num>>1;
		   }
	   return result;
   }
}
