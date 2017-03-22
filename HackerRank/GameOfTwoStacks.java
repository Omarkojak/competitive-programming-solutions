package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GameOfTwoStacks {

	static int bs(long[] arr, int n, long rem) {
		int low = 0, high = n, ans = 0;

		while (low <= high) {
			int mid = (low + high) >> 1;
			if (arr[mid] <= rem) {
				low = mid + 1;
				ans = mid;
			} else
				high = mid - 1;
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int g = in.nextInt();
		while (g-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			long x = in.nextLong();

			long[] a = new long[n + 1];
			long[] b = new long[m + 1];
			for (int i = 1; i <= n; i++)
				a[i] = in.nextLong() + a[i - 1];
			for (int i = 1; i <= m; i++)
				b[i] = in.nextLong() + b[i - 1];

			int max = 0;
			for (int i = 1; i < n + 1; i++) {
				if (a[i] > x)
					break;
				int pos1 = bs(b, m, x - a[i]);
				max = Math.max(max, pos1 + i);
			}

			for (int i = 1; i < m + 1; i++) {
				if (b[i] > x)
					break;
				int pos2 = bs(a, n, x - b[i]);
				max = Math.max(max, pos2 + i);
			}

			sb.append(max).append("\n");
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
