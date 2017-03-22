package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C379 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Pair[] arr = new Pair[n];
		for (int i = 0; i < n; i++)
			arr[i] = new Pair(i, in.nextLong());
		Arrays.sort(arr);
		long[] ans = new long[n];
		ans[arr[0].idx] = arr[0].val;
		for (int i = 1; i < n; i++) {
			if (arr[i].val <= arr[i - 1].val)
				arr[i].val = arr[i - 1].val + 1;
			ans[arr[i].idx] = arr[i].val;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			sb.append(ans[i] + " ");
		System.out.println(sb);

	}

	static class Pair implements Comparable<Pair> {
		long val;
		int idx;

		Pair(int x, long y) {
			idx = x;
			val = y;
		}

		@Override
		public int compareTo(Pair o) {
			if (Long.compare(val, o.val) != 0)
				return Long.compare(val, o.val);
			return idx - o.idx;
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
