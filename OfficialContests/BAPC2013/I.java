package OfficialContests.BAPC2013;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class I {
	static TreeMap<String, TreeSet<String>> mp;
	static int[] cnt;
	static long[] dp;

	public static long solve(int idx) {
		if (idx == cnt.length)
			return 1;

		if (dp[idx] != -1)
			return dp[idx];
		long take = cnt[idx] * solve(idx + 1);
		long leave = solve(idx + 1);

		return dp[idx] = take + leave;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			mp = new TreeMap<>();
			String[] arr = new String[n];
			int upper = 0;
			for (int i = 0; i < n; i++) {
				String s1 = sc.next();
				String s2 = sc.next();
				if (mp.containsKey(s2)) {
					mp.get(s2).add(s1);
				} else {
					TreeSet<String> tmp = new TreeSet<>();
					tmp.add(s1);
					mp.put(s2, tmp);
					arr[upper++] = s2;
				}
			}
			cnt = new int[upper];
			for (int i = 0; i < upper; i++)
				cnt[i] = mp.get(arr[i]).size();
			dp = new long[upper];
			Arrays.fill(dp, -1);
			out.println(solve(0) - 1);
		}
		out.close();
	}

}