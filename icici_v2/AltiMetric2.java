package icici_v2;

import java.util.*;
import java.io.*;

public class AltiMetric2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        
        for (int i = 0; i < N; i++) {
        	String sValues[]=br.readLine().split(" ");
        	List<Word> list =new ArrayList<Word>();
        	int oNum = Integer.parseInt(sValues[1]);
        	int zNum = Integer.parseInt(sValues[2]);
        	String words[]=br.readLine().split(" ");
        	for(int j=0;j<words.length;j++)
        	{
        		int oCount=0;
        		int zCount=0;
        		for(int k=0;k<words[j].length();k++)
        		{
        			if (words[j].charAt(k)=='O' || words[j].charAt(k)=='o')
        				oCount++;
        			else
        				zCount++;
        		}
        		Word word=new Word(oCount,zCount,oCount+zCount, words[j]);
        		list.add(word);
        	}
        	//sort word by sum
        	Collections.sort(list, new CustomComparator());
        	//iterate each word and apply logic
        	int result1=0;
        	for(Word w:list)
        	{
        		if(w.zCount<=zNum && w.oCount <= oNum)
        		{
        			result1++;
        			zNum-=w.zCount;
        			oNum-=w.oCount;
        		}
        		System.out.println(w.str);
        	}
        	Collections.sort(list, new CustomComparator2());
        	//iterate each word and apply logic
        	int result2=0;
        	for(Word w:list)
        	{
        		if(w.zCount<=zNum && w.oCount <= oNum)
        		{
        			result2++;
        			zNum-=w.zCount;
        			oNum-=w.oCount;
        		}
        	}
        	Collections.sort(list, new CustomComparator3());
        	//iterate each word and apply logic
        	int result3=0;
        	for(Word w:list)
        	{
        		if(w.zCount<=zNum && w.oCount <= oNum)
        		{
        			result3++;
        			zNum-=w.zCount;
        			oNum-=w.oCount;
        		}
        	}
        	int result=0;
        	result=result1>result2?result1:result2;
        	result=result>result3?result:result3;
        	System.out.println(result);
        	
        }
	}

}
class Word{
	public Integer oCount;
	public Integer zCount;
	public Integer sum;
	public String str;
	public Word(int o,int z,int sum, String str)
	{
		this.oCount=o;
		this.zCount=z;
		this.sum=sum;
		this.str=str;
	}
	
}
class CustomComparator implements Comparator<Word> {
    @Override
    public int compare(Word o1, Word o2) {
        return o1.sum.compareTo(o2.sum);
    }
}

class CustomComparator2 implements Comparator<Word> {
    @Override
    public int compare(Word o1, Word o2) {
        return o1.oCount.compareTo(o2.oCount);
    }
}
class CustomComparator3 implements Comparator<Word> {
    @Override
    public int compare(Word o1, Word o2) {
        return o1.zCount.compareTo(o2.zCount);
    }
}