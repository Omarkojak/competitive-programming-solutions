package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva10081_TightWords {
	static int n,k;
	static double dp[][];
	
	public static double solve(int i, int j)
	{
		if(i == n)
			return 1;
		
		if(dp[i][j] != -1)
			return dp[i][j];
		dp[i][j] = 0;
		if(j>0)
			dp[i][j] += solve(i+1, j-1);
		if(j<k)
			dp[i][j] += solve(i+1, j+1);
		dp[i][j] += solve(i+1, j);
		return dp[i][j];
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while(in.ready())
		{
			k = in.nextInt();
			n = in.nextInt();
			dp = new double [n][k+1];
			for(int i=0;i<n;i++)
				Arrays.fill(dp[i], -1);
			double cnt = 0.0;
			for(int i=0;i<=k;i++)
				cnt+=solve(1, i);
		/*	BigDecimal ans = BigDecimal.valueOf(cnt);
			ans = ans.multiply(BigDecimal.valueOf(100));
			BigDecimal div = BigDecimal.valueOf(k+1).pow(n);
			ans = ans.divide(div, 5, RoundingMode.HALF_DOWN);
			out.println(ans);*/
			out.printf("%.5f\n", (cnt * 100.0) / Math.pow(k+1, n));
		}
		out.flush();
		out.close();
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
