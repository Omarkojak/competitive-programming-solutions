package cp5_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva10312_ExpressionBracketing {
	static long dp[][];

	static long solve(int left, int n)	//left = 0 false	left = 1 true
	{
		if(n<=1)
			return 1;
		
		if(dp[left][n]!=-1)
			return dp[left][n];
		
		long res = 0;
		for(int k=1;k<n;k++)
			res+=solve(1,k) * solve(0,n-k);
		
		if(left == 0)
			res <<= 1;
		return dp[left][n] = res;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		dp = new long[2][30];
		Arrays.fill(dp[0], -1);
		Arrays.fill(dp[1], -1);
		long [] cat = new long[30];
		cat[0] = 1;
		for(int i=1;i<30;i++)
			cat[i] = cat[i-1] * (i<<1) * ((i<<1) - 1) / (i * (i + 1));
		
		String s = in.nextLine();
		while(s!=null && s.length()!=0)
		{
			int n = Integer.parseInt(s);
			sb.append(solve(1,n) - cat[n-1]).append("\n");
			s = in.nextLine();
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
