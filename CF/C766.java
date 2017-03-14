package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C766 {
	static int last[], n, dp[];
	static long[] dp1;
	static final int inf = (int) 1e9;
	static final long MOD = (int) 1e9 + 7;

	public static int solve(int idx) {
		if (idx == n)
			return 0;
		if (dp[idx] != -1)
			return dp[idx];
		int min = inf;
		for (int i = idx; i <= last[idx]; i++)
			min = Math.min(min, solve(i + 1) + 1);
		return dp[idx] = min;
	}

	public static long solve1(int idx) {
		if (idx == n)
			return 1l;
		if (dp1[idx] != -1)
			return dp1[idx];
		long ways = 0;
		for (int i = idx; i <= last[idx]; i++) {
			long next = solve1(i + 1) % MOD;
			ways = (ways + next) % MOD;
		}
		return dp1[idx] = ways;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		char[] s = in.nextLine().toCharArray();
		int cnt[] = new int[26];
		for (int i = 0; i < 26; i++)
			cnt[i] = in.nextInt();

		last = new int[n];
		int ans1 = 0, ans2 = 0;
		long ans0 = 0;
		for (int i = 0; i < n; i++) {
			boolean[] exist = new boolean[26];
			int j = i;
			for (; j < n; j++) {
				boolean f = false;
				for(int k=0;k<26;k++)
					if(exist[k] && cnt[k] < j - i + 1)
						f = true;
					
				if(cnt[s[j] - 'a'] < j - i + 1 || f)
					break;
				exist[s[j] - 'a'] = true;
			}
			last[i] = j - 1;
			ans1 = Math.max(ans1, last[i] - i + 1);
		}
		dp = new int[n + 5];
		Arrays.fill(dp, -1);
		dp1 = new long[n + 5];
		Arrays.fill(dp1, -1l);
		ans2 = solve(0);
		ans0 = solve1(0);
		System.out.println(ans0);
		System.out.println(ans1);
		System.out.println(ans2);

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
