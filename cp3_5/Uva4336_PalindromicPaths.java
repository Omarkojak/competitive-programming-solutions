package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva4336_PalindromicPaths {
	static int N;
	static char[][]edges;
	static int dp[][];
	static String ans;
	
	public static int solve(int node1, int node2)
	{
		if(node1 == node2)
			return dp[node1][node2] = 0;
		
		if(dp[node1][node2] != -1)
			return dp[node1][node2];
		
		int max = 1;
		for(int i=node1+1;i<N;i++)
			for(int j=node2-1;j>=0;j--)
			{
				if(i>j)
					break;
				if(edges[node1][i] == edges[j][node2] && edges[node1][i] != '*')
					max = Math.max(max, 2 + solve(i, j));
			}
		return dp[node1][node2] = max;
	}
	
	public static void print(int node1, int node2, String s)
	{
		if(node1 == node2)
		{
			if(ans == null || s.compareTo(ans) < 0)
				ans = s;
			return;
		}

		int optimal = dp[node1][node2];
		if(optimal == 1)
		{
			s += edges[node1][node2];
			if(ans == null || s.compareTo(ans) < 0)
				ans = s;
			return;
		}
		for(int i=node1+1;i<N;i++)
			for(int j=node2-1;j>=0;j--)
			{
				if(i>j)
					break;
				if(edges[node1][i] == edges[j][node2] && optimal == 2 + dp[i][j] && edges[node1][i] != '*')
					print(i, j, s+edges[node1][i]);	
			}
		
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while(t-->0)
		{
			N = in.nextInt();
			edges = new char[N][N];
			for(int i=0;i<N;i++)
				edges[i] = in.nextLine().toCharArray();
			dp = new int [N][N];
			for(int i=0;i<N;i++)
				Arrays.fill(dp[i], -1);
			
			ans = null;
			int l = solve(0, N-1);
			print(0, N-1, "");
			if(ans == null || ans.length() == 0)
				sb.append("NO PALINDROMIC PATH");
			else
			{
				StringBuilder k = new StringBuilder(ans.substring(0, l / 2));
				k = k.reverse();
				ans+=k.toString();
				sb.append(ans);
			}
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
