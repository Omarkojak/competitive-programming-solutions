package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva1172_TheBridgesOfKolsberg {
	static int n1;
	static String[] os1;
	static int[] trade1;

	static String[] os2;
	static int[] trade2;
	static int n2;

	static final int inf = Integer.MAX_VALUE;
	static Pair memo[][];

	static Pair solve(int idx1, int idx2) {
		if (idx1 == n1 || idx2 == n2)
			return new Pair(0, 0);

		if (memo[idx1][idx2] != null)
			return memo[idx1][idx2];

		Pair take = new Pair(0, 0);
		if (os1[idx1].equals(os2[idx2])) {
			Pair k = solve(idx1 + 1, idx2 + 1);
			take.num = k.num + 1;
			take.sum = k.sum + trade1[idx1] + trade2[idx2];
		}
		Pair leave1 = solve(idx1 + 1, idx2);
		Pair leave2 = solve(idx1, idx2 + 1);

		memo[idx1][idx2] = max(take, leave1, leave2);
		return memo[idx1][idx2];
	}

	static Pair max(Pair p1, Pair p2, Pair p3) {
		int max = Math.max(p1.sum, Math.max(p2.sum, p3.sum));
		int min = inf;
		if (p1.sum == max)
			min = Math.min(min, p1.num);
		if (p2.sum == max)
			min = Math.min(min, p2.num);
		if (p3.sum == max)
			min = Math.min(min, p3.num);
		return new Pair(max, min);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			n1 = in.nextInt();
			os1 = new String[n1];
			trade1 = new int[n1];
			for (int i = 0; i < n1; i++) {
				in.next();
				os1[i] = in.next();
				trade1[i] = in.nextInt();
			}
			n2 = in.nextInt();
			os2 = new String[n2];
			trade2 = new int[n2];
			for (int i = 0; i < n2; i++) {
				in.next();
				os2[i] = in.next();
				trade2[i] = in.nextInt();
			}
			memo = new Pair[n1][n2];
			Pair res = solve(0, 0);
			sb.append(res.sum + " " + res.num).append("\n");
		}
		System.out.print(sb);
	}

	static class Pair {
		int num;
		int sum;

		Pair(int a, int b) {
			sum = a;
			num = b;
		}

		public String toString() {
			return num + " " + sum;
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
