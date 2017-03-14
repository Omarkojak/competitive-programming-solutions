package OfficialContests.Tishreen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class B {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int cse = 1;
		while(true)
		{
			StringTokenizer ns = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(ns.nextToken());
			if(n==0)
				break;
			TreeMap<String, Integer> mp = new TreeMap<>();
			Queue<String> q = new LinkedList<>();
			for(int i=0;i<n;i++)
			{
				String s = ns.nextToken();
				int freq = 0;
				if(mp.containsKey(s))
					freq = mp.get(s);
				else
					q.add(s);
				mp.put(s, freq+1);
			}
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			while(!q.isEmpty())
				pq.add(mp.get(q.poll()) * -1);
			int []arr = new int [pq.peek() * -1];
			arr[0] = 1;
			int size = arr.length; 
			pq.poll();
			while(!pq.isEmpty() && pq.peek() *-1 > 1)
			{
				int x = pq.poll() * -1;
				arr[size - x] += 1;
			}
			StringBuilder sb = new StringBuilder();
			sb.append(arr[0]);
			for(int i=1;i<size;i++)
			{
				arr[i] += arr[i-1];
				sb.append(arr[i]);
			}
			BigInteger ans = new BigInteger(sb.toString());
			ans = ans.add(BigInteger.valueOf(pq.size()));
			out.printf("Case %d: %d\n", cse++, ans);
			
		}
		out.flush();
		out.close();

	}

}
