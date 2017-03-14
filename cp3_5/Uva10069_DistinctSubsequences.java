package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Uva10069_DistinctSubsequences {
	static char[] s1,s2;
	static int n,m;
	static BigInteger dp[][];
	
	static BigInteger solve(int i, int j)
	{
		if(j == m)
			return BigInteger.valueOf(1);
		if(i == n)
			return BigInteger.valueOf(0);
		if(dp[i][j] != null)
			return dp[i][j];
		
		BigInteger take = BigInteger.valueOf(0);
		if(s1[i] == s2[j])
			take = solve(i+1, j+1);
		BigInteger leave = solve(i+1, j);
		return dp[i][j] = take.add(leave);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while(t-->0)
		{
			s1 = in.nextLine().toCharArray();n = s1.length;
			s2 = in.nextLine().toCharArray();m = s2.length;
			dp = new BigInteger [n][m];
			
			sb.append(solve(0,0)).append("\n");
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
