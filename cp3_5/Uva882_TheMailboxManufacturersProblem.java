package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva882_TheMailboxManufacturersProblem {
	static final long inf  = (long) 1e18;
	static long [][][]dp;
	
	public static long solve(int n, int min, int max)
	{
		if(min == max)
			return 0;
		if(n == 0)
			return inf;
		
		if(dp[n][min][max] != -1)
			return dp[n][min][max];
		long res = inf;
		for(int i=min+1;i<=max;i++)
			res = Math.min(res, i + Math.max(solve(n-1, min, i-1), solve(n, i, max)));
		
		return dp[n][min][max] = res;
	}
	
	

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		dp = new long [12][105][105];
		for(int i=0;i<12;i++)
			for(int j=0;j<105;j++)
				Arrays.fill(dp[i][j], -1);
		while(t-->0)
		{
			sb.append(solve(in.nextInt(), 0, in.nextInt())).append("\n");
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
