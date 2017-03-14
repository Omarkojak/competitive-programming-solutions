package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B760 {
	static long sum[];
	static long idxx;

	public static int binarysearch(long x) {
		int low = 0;
		int high = 100000;
		int ans = -1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (sum[mid] > x)
				high = mid - 1;
			if (sum[mid] <= x) {
				low = mid + 1;
				ans = mid;
			}
		}
		return ans == -1 ? 0 : ans;

	}

	public static long binarysearch2(long m, long n, long k) {
		long low = 0;
		long high = 100000;
		long ans = -1;
		while (low <= high) {
			long mid = (high + low) / 2;
			long end = Math.max(mid - Math.min(n - k + 1, k), 0);
			long sumtaken = mid * (mid + 1) - mid - (end * (end + 1) / 2);
			if (sumtaken > m)
				high = mid - 1;
			if (sumtaken <= m) {
				low = mid + 1;
				ans = sumtaken;
				idxx = mid;
			}
		}
		return ans == -1 ? 0 : ans;

	}

	public static long ceil(long a, long b) {
		long ans = a / b;
		if (a % b != 0)
			ans++;
		return ans;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sum = new long[100000];
		for (int i = 1; i < 100000; i++) {
			sum[i] = ((long) i) * (i + 1) / 2;
			
		}
		long n = in.nextLong();
		long m = in.nextLong();
		long k = in.nextLong();
		m -= n;
		long ans = 1;
		if (k == 1 || k == n) {
			long idx = binarysearch(m);
			if (idx > n) {
				ans += n;
				m -= sum[(int) n];
				ans += m / n;
			} else
				ans += idx;
		} else {
			long maxside = Math.max(n - k + 1, k);
			long num = maxside - Math.min(n - k + 1, k);
			long sumtaken = maxside * (maxside + 1) - maxside
					- (num * (num + 1) / 2);

			if (sumtaken <= m) {
				ans += maxside;
				m -= sumtaken;
				ans += m / n;
			} else {
				idxx = 0;
				long summ = binarysearch2(m, n, k);
				ans += idxx;
				m -= summ;
				ans += m / n;
			}

		}
		System.out.println(ans);
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
