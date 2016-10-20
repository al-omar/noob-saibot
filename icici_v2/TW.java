package icici_v2;

import java.util.*;

public class TW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer arr[] = new Integer[] { 45,30,45,45,5,60,45,30,30,45,60,45,30,30,30,30};
		List<Integer> list = Arrays.asList(arr);
		Collections.sort(list);
		Collections.reverse(list);
		List<Integer> partial = new ArrayList<Integer>();
		find(list, partial, 180);
		System.out.println("result-"+Arrays.toString(maxList.toArray()));
	}

	static List<Integer> maxList = new ArrayList<Integer>();
	static int maxUsed = 0;
static boolean flag=false;
	private static void find(List<Integer> input, List<Integer> partial, int sum) {
		int total = 0;
		if(flag) return;
		System.out.println("partial list is "+Arrays.toString(partial.toArray()));
		for (Integer i : partial) {
			total += i;
		}
		if(total > 180)
		{
			return;
		}
		if (total == 180) {
			maxList = partial;
			flag = true;
			return;
		}
		if (total > maxUsed) {
			maxList = partial;
			maxUsed=total;
		}
		
		
		for (int i = 0; i < input.size(); i++) {
			int n = input.get(i);
			List<Integer> remain = new ArrayList<Integer>();
			for (int j = i + 1; j < input.size(); j++) {
				remain.add(input.get(j));
			}
			List<Integer> partial_recursive=new ArrayList<Integer>(partial);
			partial_recursive.add(n);
			find(remain,partial_recursive,sum);
		}
	}

}
