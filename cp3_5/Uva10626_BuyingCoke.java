package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva10626_BuyingCoke {
	static int n, sum;
	static final int inf = (int) 1e9;
	static int [][][]dp;
	
	public static int solve(int cokes, int f, int t)
	{
		if(cokes == n)
			return 0;
		
		if(dp[cokes][f][t] != -1)
			return dp[cokes][f][t];
		
		int ones = sum - (cokes * 8 + f * 5 + t * 10); 
		int min = inf;
		if(t >= 1)
			min = Math.min(min, 1 + solve(cokes+1, f, t-1));
		
		if(f >= 2)
			min = Math.min(min, 2 + solve(cokes+1, f-2, t));
		
		if(ones >= 8)
			min = Math.min(min, 8 + solve(cokes+1, f, t));
		
		if(ones >= 3 && f >= 1)
			min = Math.min(min, 4 + solve(cokes+1, f-1, t));
		
		if(ones >= 3 && t>=1)
			min = Math.min(min, 4 + solve(cokes+1, f+1, t-1));
		
		return dp[cokes][f][t] = min;
		
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while(t-->0)
		{
			n = in.nextInt();
			int ones = in.nextInt();
			int fives = in.nextInt();
			int tens = in.nextInt();
			sum = ones + fives * 5 + tens * 10;
			dp = new int [n][155][155];
			for(int i=0;i<n;i++)
				for(int j=0;j<155;j++)
					Arrays.fill(dp[i][j], -1);
			sb.append(solve(0, fives, tens)).append("\n");
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
