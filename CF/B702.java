package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class B702 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		long pow[] = new long[35];
		pow[0] = 1;
		for (int i = 1; i < 35; i++)
			pow[i] = pow[i - 1] * 2;
		int n = in.nextInt();
		int[] a = new int[n];
		TreeMap<Long, Integer> mp = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		long ans = 0;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < 35; j++) {
				long val = pow[j] - a[i];
				if (mp.containsKey(val))
					ans += mp.get(val);
			}
			int r = 0;
			if (mp.containsKey((long) a[i]))
				r = mp.get((long) a[i]);
			mp.put((long) a[i], r + 1);
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
