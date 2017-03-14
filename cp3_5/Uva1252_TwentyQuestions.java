package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva1252_TwentyQuestions {
	static int [][] dp;
	static int n,m;
	static int [] f;
	static final int inf = (int) 1e7;
	
	static int solve(int questions, int answers)
	{
		if(dp[questions][answers] != -1)
			return dp[questions][answers];
		
		int obj = 0;
		for(int i=0;i<n;i++)
			if((questions & f[i]) == answers)
				obj++;
		
		if(obj<=1)
			return dp[questions][answers] = 0;
		
		int min = inf;
		for(int i=0;i<m;i++)
			if((questions & 1<<i) == 0)
				min = Math.min(min, 1 + Math.max(solve(questions | (1<<i), answers | 1<<i), solve(questions | (1<<i), answers)));
		return dp[questions][answers] = min;
	}
	

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			m = in.nextInt();
			n = in.nextInt();
			if(n==0 && m==0)
				break;
			f = new int [n];
			for(int i=0;i<n;i++)
				f[i] = Integer.parseInt(in.next(),2);
			dp = new int [1<<m][1<<m];
			for(int i=0;i< 1<<m; i++)
				Arrays.fill(dp[i], -1);
			sb.append(solve(0, 0)).append("\n");
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
