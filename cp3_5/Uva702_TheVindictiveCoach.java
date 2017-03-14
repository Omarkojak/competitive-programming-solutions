package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva702_TheVindictiveCoach {
	static long dp[][][];
	
	public static long solve(int l, int r, int op)	// op = 0 -> put small  op = 1 -> put large
	{
		if(l == 0 && r == 0)
			return 1;
		if(l <= 0 && op == 0)
			return 0;
		if(r <= 0 && op == 1)
			return 0;
		if(dp[op][l][r] != -1)
			return dp[op][l][r];
		long res = 0;
		if(op == 0)
			for(int i=1;i<=l;i++)
				res += solve(l-i, r+i-1, op^1);
		else
			for(int i=1;i<=r;i++)
				res += solve(l+i-1, r-i, op^1);
		
		return dp[op][l][r] = res;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(in.br.ready())
		{
			int n = in.nextInt();
			int c = in.nextInt();
			dp = new long[2][n + 1][n + 1];
			for (int i = 0; i < 2; i++)
				for (int j = 0; j <= n; j++)
					Arrays.fill(dp[i][j], -1);
			
			if(c == 1)
				sb.append(Math.max(1, solve(0, n-3, 1)));
			else
				sb.append(Math.max(1, solve(c-1, n-c, 0)));
			sb.append("\n");
			
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
