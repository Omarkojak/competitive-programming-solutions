package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva11517_ExactChange {
	static int n, coins[];
	static final int INF = (int) 1e9;
	static int [][] dp1, dp2;

	public static int solve1(int idx, int rem){
		if(rem <= 0)
			return -rem;
		if(idx == n)
			return INF;
		if(dp1[idx][rem] != -1)
			return dp1[idx][rem];
		
		return dp1[idx][rem] = Math.min(solve1(idx + 1, rem), solve1(idx + 1, rem - coins[idx]));
			
	}
	
	public static int solve2(int idx, int rem){
		if(rem == 0)
			return 0;
		
		if(idx == n || rem < 0)
			return INF;
		if(dp2[idx][rem] != -1)
			return dp2[idx][rem];
		
		return dp2[idx][rem] = Math.min(1 + solve2(idx + 1, rem - coins[idx]), solve2(idx + 1, rem));
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			int M = in.nextInt();
			n = in.nextInt();
			coins = new int[n];
			for (int i = 0; i < n; i++)
				coins[i] = in.nextInt();
			dp1 = new int [n + 5][M + 5];
			for(int i=0;i<n+5;i++)
				Arrays.fill(dp1[i], -1);
			
			int res1 = solve1(0, M);
			
			dp2 = new int [n + 5][M + res1 + 5];
			for(int i=0;i<n+5;i++)
				Arrays.fill(dp2[i], -1);
			
			int cnt = solve2(0, M + res1);
			
			sb.append((M + res1) + " " + cnt).append("\n");

		}
		System.out.print(sb);
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}
	}
}
