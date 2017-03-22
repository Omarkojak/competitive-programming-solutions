package cp2_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva12028_AGiftFromTheSetter {
	static final long mod = 1000007;

	public static void shuffle(long[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * (n - i));
			long temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt();
		int cse = 1;

		while (t-- > 0) {
			int K = in.nextInt();
			int C = in.nextInt();
			int n = in.nextInt();
			long[] arr = new long[n];
			arr[0] = in.nextLong();
			for (int i = 1; i < n; i++)
				arr[i] = (K * arr[i - 1] + C) % mod;
			shuffle(arr);
			Arrays.sort(arr);
			SegmentTree st = new SegmentTree(arr);
			long ans = 0;
			for (int i = n - 1; i > 0; i--) {
				ans += i * arr[i] - st.query(0, i - 1);
			}

			out.printf("Case %d: %d\n", cse++, ans);
		}
		out.flush();
		out.close();
	}

	static class SegmentTree {
		long arr[], sTree[];
		int N;

		SegmentTree(long[] in) {
			arr = in;
			N = in.length;
			sTree = new long[N << 2];
			build(1, 0, N - 1);
		}

		void build(int node, int b, int e) {

			if (b == e) {
				sTree[node] = arr[b];
			} else {
				build(node << 1, b, (b + e) >> 1);
				build((node << 1) + 1, ((b + e) >> 1) + 1, e);
				sTree[node] = sTree[(node << 1)] + sTree[(node << 1) + 1];
			}
		}

		long query(int i, int j) {
			return query(1, 0, N - 1, i, j);
		}

		long query(int node, int b, int e, int i, int j) {
			if (i > e || j < b)
				return 0;
			if (b >= i && e <= j)
				return sTree[node];

			return query(node << 1, b, (b + e) >> 1, i, j)
					+ query((node << 1) + 1, ((b + e) >> 1) + 1, e, i, j);

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
