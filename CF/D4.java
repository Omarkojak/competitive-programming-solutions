package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class D4 {
	static Stack<Integer> st;
	static ArrayList<Envelope> as2;
	static int m;

	static int lis() {
		int[] dp = new int[m + 5];
		int[] p = new int[m + 5];
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[0] = 0;
		p[0] = -1;
		for (int i = 1; i < m; i++) {
			Envelope e1 = as2.get(i);
			for (int j = 0; j < i; j++) {
				Envelope e2 = as2.get(j);
				if (e1.w > e2.w && e1.h > e2.h)
					if (dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
						p[i] = j;
					}
			}
		}
		int max = Integer.MIN_VALUE;
		int k = -1;
		for (int i = 0; i < m; i++) {
			if (dp[i] > max) {
				max = dp[i];
				k = i;
			}
		}
		while (k != 0) {
			st.add(as2.get(k).idx);
			k = p[k];
		}

		return max;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Envelope mine = new Envelope(-1, in.nextInt(), in.nextInt());
		ArrayList<Envelope> as1 = new ArrayList<>();
		for (int i = 0; i < n; i++)
			as1.add(new Envelope(i, in.nextInt(), in.nextInt()));
		Collections.sort(as1);
		as2 = new ArrayList<>();
		as2.add(mine);
		for (Envelope curr : as1) {
			if (curr.w > mine.w && curr.h > mine.h) {
				as2.add(curr);
			}
		}
		m = as2.size();
		st = new Stack<>();
		System.out.println(lis());
		if (st.size() > 0) {
			StringBuilder sb = new StringBuilder();
			while (!st.isEmpty())
				sb.append(st.pop() + 1).append((st.size() == 0) ? "\n" : " ");
			System.out.print(sb);
		}

	}

	static class Envelope implements Comparable<Envelope> {
		int w, h, idx;

		Envelope(int a, int b, int c) {
			idx = a;
			w = b;
			h = c;
		}

		public int compareTo(Envelope e) {
			return w - e.w;
		}
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
