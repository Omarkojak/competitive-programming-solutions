package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class B114 {
	static int[] rel;
	static int n;
	static int memo[][];

	public static int solve(int idx, int msk) { // 0 => he is out of my team --- 1=> in my team
		if (idx == rel.length)
			return msk;

		if (memo[idx][msk] != -1)
			return memo[idx][msk];

		int and = (1 << n) - 1;
		int leave1 = solve(idx + 2, (and ^ (1 << rel[idx])) & msk);
		int leave2 = solve(idx + 2, (and ^ (1 << rel[idx + 1])) & msk);

		if (ev(leave1) > ev(leave2))
			return memo[idx][msk] = leave1;
		else
			return memo[idx][msk] = leave2;
	}

	public static int ev(int msk) {
		int ans = 0;
		while (msk > 0) {
			if (msk % 2 != 0)
				ans++;
			msk >>= 1;
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int m = in.nextInt();
		String[] names = new String[n];
		TreeMap<String, Integer> mp = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			names[i] = in.nextLine();
			mp.put(names[i], i);
		}
		rel = new int[m * 2];
		for (int i = 0; i < m * 2; i += 2) {
			rel[i] = mp.get(in.next());
			rel[i + 1] = mp.get(in.next());
		}
		memo = new int[m * 2][(1 << n)];
		for (int i = 0; i < m * 2; i++)
			Arrays.fill(memo[i], -1);
		int ans = solve(0, (1 << n) - 1);
		int idx = 0;
		ArrayList<String> as = new ArrayList<>();
		while (ans > 0) {
			if (ans % 2 == 1)
				as.add(names[idx]);
			idx++;
			ans >>= 1;
		}
		Collections.sort(as);
		System.out.println(as.size());
		for (String s : as)
			System.out.println(s);
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
