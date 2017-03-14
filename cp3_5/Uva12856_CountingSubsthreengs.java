package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva12856_CountingSubsthreengs {
	static char[] s;
	static int n;

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(in.ready())
		{
			s = in.nextLine().toCharArray();
			n = s.length;
			long dp[][] = new long [n+5][5];
			for(int i=1;i<=n;i++)
				if(s[i-1] - '0' >= 0 && s[i-1] - '0' <=9)
					dp[i][(s[i-1] - '0')%3]++;
			for(int i=1;i<=n;i++)
			{
				if(s[i-1] - '0' < 0 || s[i-1] - '0' > 9)
					continue;
				int k = (s[i-1]-'0')%3;
				dp[i][0] += dp[i-1][(3-k)%3];
				if(k <=1)
					dp[i][1] += dp[i-1][k^1];
				else
					dp[i][1] += dp[i-1][2];
				dp[i][2] += dp[i-1][2-k];
				
			}
			long ans = 0;
			for(int i=1;i<=n;i++)
				ans+=dp[i][0];
			
			sb.append(ans).append("\n");
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
