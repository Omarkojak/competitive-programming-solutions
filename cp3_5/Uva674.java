package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva674 {
	static long dp[][];
	static int []coins={1,5,10,25,50};
	
	static long solve(int curr,int rem){
		if(curr==5)
			return rem==0? 1:0;
		if(rem<0)
			return 0;
		if(dp[curr][rem]!=-1)
			return dp[curr][rem];
		return dp[curr][rem]=solve(curr,rem-coins[curr])+solve(curr+1, rem);

	}

	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(System.in);
		String s=in.nextLine();
		StringBuilder sb=new StringBuilder();
		dp=new long [7][100000];
		for(int i=0;i<7;i++)
			Arrays.fill(dp[i],-1);
		while(s!=null&&s.length()!=0){
			int n=Integer.parseInt(s);
			sb.append(solve(0,n)+"\n");
			s=in.nextLine();
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
