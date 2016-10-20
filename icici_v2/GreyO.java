package icici_v2;

import java.io.BufferedReader;
import java.util.*;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GreyO {

	public static void main(String[] args) throws Exception{
		
		
		String pattern = "\\d+";
		String line="vfsvs wgfesr  errg min";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		if(m.find())
		{
			System.out.println(Integer.parseInt(m.group()));
			System.out.println(line.substring(0, line.indexOf(m.group())).trim());
		}
		else{
			System.out.println(line.substring(0, line.lastIndexOf("min")));
		}
	}
	static int total=0;
	private static void getSum(List<Integer> inArr,List<Integer> partial, int sum)
	{
		int current=0;
		for(Integer i:partial)
		{
			current+=i;
		}
		
		if(current>sum)
			return;
		if(current==sum)
		{
		//	System.out.println("Found sum with elements"+Arrays.toString(partial.toArray()));
			total++;
			return;
		}
		for(int i=0;i<inArr.size();i++)
		{
			ArrayList<Integer> remaining = new ArrayList<Integer>();
			int n = inArr.get(i);
			for (int j = i + 1; j < inArr.size(); j++)
				remaining.add(inArr.get(j));
			ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
			partial_rec.add(n);
			getSum(remaining, partial_rec, sum);
		}
	}
	}


