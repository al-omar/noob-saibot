package icici_v2;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Amazon {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        long N = Long.parseLong(line);
        for(long z=0;z<N;z++)
        {
        	Map<Long,Map> map=new HashMap<Long,Map>();
        	Long n = Long.parseLong(br.readLine());
        	for(long i=0;i<n;i++)
        	{
        		String weights[]=br.readLine().split(" ");
        		if(map.containsKey(Long.parseLong(weights[0]))){
        			Map<Long,Long> localMap=map.get(Long.parseLong(weights[0]));
        			localMap.put(Long.parseLong(weights[1]), Long.parseLong(weights[2]));
        			map.put(Long.parseLong(weights[0]), localMap);
        		}else{
        			Map<Long,Long> localMap=new HashMap<Long,Long>();
        			localMap.put(Long.parseLong(weights[1]), Long.parseLong(weights[2]));
        			map.put(Long.parseLong(weights[0]), localMap);
        		}
        		if(map.containsKey(Long.parseLong(weights[1]))){
        			Map<Long,Long> localMap=map.get(Long.parseLong(weights[1]));
        			localMap.put(Long.parseLong(weights[0]), Long.parseLong(weights[2]));
        			map.put(Long.parseLong(weights[1]), localMap);
        		}else{
        			Map<Long,Long> localMap=new HashMap<Long,Long>();
        			localMap.put(Long.parseLong(weights[0]), Long.parseLong(weights[2]));
        			map.put(Long.parseLong(weights[1]), localMap);
        		}
        	}
        	long sum=0;
        	for(long i=0;i<n;i++){
        		for (long j=i+1;j<n;j++){
        			Map copyMap = new HashMap(map);
        			sum = sum + calculateMax(copyMap,i,j,new Long(0));
        		}
        	}
        	System.out.println(sum);
        		
        }
	}
	public static Long calculateMax(Map<Long,Map> map, Long src, Long dest, Long sum){
		
		
		Map<Long,Long> localMap=(Map<Long, Long>) map.get(src);
		if(localMap.size()==0){
			return sum;
		}
		if(localMap.containsKey(dest)){
			return sum+localMap.get(dest);
		}
		else{
			Map<Long,Long> sortedMap = sortByComparator(localMap);
			for(Map.Entry<Long,Long> e : sortedMap.entrySet())
			{
				sortedMap.remove(e.getKey());
				return calculateMax(map,e.getKey(),dest, sum+e.getValue());
			}
		}
		return sum;
		
		
		
		
		
	}
	/*public static Long recursiveDest(Map<Long,Map> map, Long src, Long dest){
		Map<Long,Long> localMap=(Map<Long, Long>) map.get(src);
	}*/
	private static Map<Long, Long> sortByComparator(Map<Long, Long> unsortMap)
    {

        List<Entry<Long, Long>> list = new LinkedList<Entry<Long, Long>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<Long, Long>>()
        {
            public int compare(Entry<Long, Long> o1,
                    Entry<Long, Long> o2)
            {
               
                    return o2.getValue().compareTo(o1.getValue());

               
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<Long, Long> sortedMap = new LinkedHashMap<Long, Long>();
        for (Entry<Long, Long> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
