package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva1238_FreeParentheses {
	static int n;
	static int numbers[];
	static int signs[];
	static boolean vis[][][];
	static boolean used[];
	
	
	public static void solve(int idx, int open, int val)
	{
		if(vis[idx][open][val+3000])
			return;
		
		vis[idx][open][val+3000] = true;
		if(idx == n)
		{
			used[val + 3000] = true;
			return;
		}
		int nextvalue = val + numbers[idx] * signs[idx] * ((open % 2 == 0) ? 1 : -1);
		if(signs[idx] == -1)
			solve(idx+1, open+1, nextvalue);
		if(open > 0)
			solve(idx+1, open-1, nextvalue);
		solve(idx+1, open, nextvalue);
	}
	

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			String s = in.nextLine();
			if(s == null || s.length() == 0)
				break;
			StringTokenizer ns = new StringTokenizer(s);
			
			n = (int)Math.ceil(ns.countTokens()*1.0/2.0);
			numbers = new int [n];	numbers[0] = Integer.parseInt(ns.nextToken());
			signs = new int [n];	signs[0] = 1;
			for(int i=1;i<n;i++)
			{
				signs[i] = (ns.nextToken().charAt(0) == '-')? -1 : 1;
				numbers[i] = Integer.parseInt(ns.nextToken());
			}
			vis = new boolean [n+5][n+5][6000];
			used = new boolean [6000];
			solve(0, 0, 0);
			int res = 0;
			for(int i=0;i<6000;i++)
				if(used[i])
					res++;
			sb.append(res).append("\n");
		}
		System.out.print(sb);
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
	}
}
