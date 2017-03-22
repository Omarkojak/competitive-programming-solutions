package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva836_TheLargestSubmatrix {
	static int[][] a;
	static int n;

	static int solve() {
		int max = 0;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				for (int k = i; k < n; k++)
					for (int w = j; w < n; w++) {
						int sum = a[k][w];
						if (i > 0)
							sum -= a[i - 1][w];
						if (j > 0)
							sum -= a[k][j - 1];
						if (i > 0 && j > 0)
							sum += a[i - 1][j - 1];
						if (sum > max && sum == (k - i + 1) * (w - j + 1)) {
							max = sum;
						}
					}

		return max;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			in.nextLine();
			String s = in.nextLine();
			n = s.length();
			a = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = s.charAt(j) - '0';
					if (i > 0)
						a[i][j] += a[i - 1][j];
					if (j > 0)
						a[i][j] += a[i][j - 1];
					if (i > 0 && j > 0)
						a[i][j] -= a[i - 1][j - 1];
				}
				if (i + 1 != n)
					s = in.nextLine();
			}
			sb.append(solve()).append("\n");
			if (t != 0)
				sb.append("\n");
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
