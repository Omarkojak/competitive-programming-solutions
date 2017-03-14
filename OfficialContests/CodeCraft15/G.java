package OfficialContests.CodeCraft15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G {
	static int n, k;
	static long dp[][];

	public static long solve(int last, int msk) {
		int idx = count(msk);
		if (idx == n)
			return 1;
		if (dp[last][msk] != -1)
			return dp[last][msk];

		long ans = 0;
		for (int i = 1; i <= n; i++)
			if ((((1 << i) & msk) == 0) && (Math.abs(last - i) <= k))
				ans += solve(i, msk | (1 << i));
		return dp[last][msk] = ans;

	}

	public static int count(int msk) {
		int cnt = 0;
		while (msk > 0) {
			if (msk % 2 != 0)
				cnt++;
			msk >>= 1;
		}
		return cnt;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			StringTokenizer ns = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(ns.nextToken());
			k = Integer.parseInt(ns.nextToken());
			dp = new long[n + 5][1 << (n + 2)];
			for (int i = 0; i < n + 5; i++)
				Arrays.fill(dp[i], -1);
			long ans = 0;
			for (int i = 1; i <= n; i++)
				ans += solve(i, 1 << i);
			sb.append(ans).append("\n");

		}
		System.out.print(sb);
	}

}
