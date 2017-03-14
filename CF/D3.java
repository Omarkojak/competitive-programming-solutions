package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class D3 {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		char [] brackets = new char[s.length()];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		long res = 0;
		int open = 0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i) == '(')
				open++;
			else
			{
				if(s.charAt(i) == ')')
					open--;
				else
				{
					int costop = in.nextInt();
					int costcl = in.nextInt();
					pq.add(new Pair(i, costop - costcl));
					brackets[i] = ')';
					res += costcl;
					open--;
				}
			}
			if(open < 0)
			{
				if(pq.isEmpty())
				{
					res = -1;
					break;
				}
				else
				{
					Pair min = pq.poll();
					brackets[min.idx] = '(';
					res+=min.cost;
					open += 2;
				}
			}
		}
		if(open != 0)
			res = -1;
		System.out.println(res);
		if(res!=-1)
		{
			for(int i=0;i<s.length();i++)
				if(s.charAt(i) == '?')
					System.out.print(brackets[i]);
				else
					System.out.print(s.charAt(i));
		}
		System.out.println();
	}
	
	static class Pair implements Comparable<Pair>
	{
		int idx; int cost;
		Pair(int x, int y)
		{
			idx = x;
			cost = y;
		}
		
		public int compareTo(Pair o) {
			if(cost != o.cost)
				return cost - o.cost;
			return idx - o.idx;
		}
	}
	
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;
		
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}
		
		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}
		
		public boolean ready() throws IOException {return br.ready();}


	}

}
