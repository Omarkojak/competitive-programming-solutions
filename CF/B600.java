package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B600 {
	static int[] a;

	public static void shuffle(int[] b) {
		int n = b.length;
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * (n - i));
			int temp = b[i];
			b[i] = b[r];
			b[r] = temp;
		}
	}

	public static int binarysearch(int found) {
		int low = 0;
		int high = a.length - 1;
		int last = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] > found)
				high = mid - 1;
			else if (a[mid] <= found) {
				low = mid + 1;
				last = low;
			}
		}
		return last;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		a = new int[n];
		int[] b = new int[m];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		for (int j = 0; j < m; j++)
			b[j] = in.nextInt();
		shuffle(a);
		Arrays.sort(a);
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < m; j++) {
			int cnt = binarysearch(b[j]);
			if (cnt == -1)
				cnt = 0;
			sb.append(cnt);
			if (j != m - 1)
				sb.append(" ");
		}
		System.out.println(sb);
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

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
