package icici_v2;

import java.io.*;
import java.util.*;

import COM.rsa.jsafe.cu;

public class ViaTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			int N = Integer.parseInt(line);
			String costStr[] = br.readLine().split(" ");
			int cost[] = new int[N];
			for (int i = 0; i < N; i++) {
				cost[i] = Integer.parseInt(costStr[i]);
			}
			line = br.readLine();
			int Q = Integer.parseInt(line);
			for (int i = 0; i < Q; i++) {
				String lrk[] = br.readLine().split(" ");
				int l = Integer.parseInt(lrk[0]) - 1;
				int r = Integer.parseInt(lrk[1]) - 1;
				int k = Integer.parseInt(lrk[2]);
				int result = 0;
				/*
				 * List<Integer> list = new ArrayList<Integer>(); for (int j =
				 * l; j <= r; j++) { if (cost[j] >= k) list.add(cost[j]); }
				 * Collections.sort(list);
				 */
				// result=findResult(cost,l,r,k);

				for (int j = l; j <= r; j++) {
					if (cost[j] < k) {
						continue;
					}
					if (cost[j] % k == 0) {
						result++;
						while(((cost[j]&cost[j+1])==0) && j<r){
							result++;
							j++;
						}
					}
				}

				System.out.println(result);
			}

			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.err.println(e.getMessage());
		}
	}

	public static int findResult(int[] cost, int l, int r, int k) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Set<Integer> set = new TreeSet<Integer>();
		for (int i = l; i <= r; i++) {
			if (cost[i] < k) {
				continue;
			}
			set.add(cost[i]);
			if (map.containsKey(cost[i])) {
				int occurence = map.get(cost[i]);
				map.put(cost[i], occurence + 1);
			} else {
				map.put(cost[i], 1);
			}
		}
		int answer = 0;
		for (Integer i : set) {
			if (i % k == 0) {
				answer = answer + map.get(i);
			}
		}
		return answer;

	}

}
