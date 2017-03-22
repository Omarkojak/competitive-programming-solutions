package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C702 {

	public static int bs(ArrayList<Integer> as, int num) {
		int res = as.size();
		int low = 0;
		int high = as.size() - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (as.get(mid) >= num) {
				res = mid;
				high = mid - 1;
			} else
				low = mid + 1;
		}

		return res;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] cities = new int[n];
		for (int i = 0; i < n; i++)
			cities[i] = in.nextInt();
		ArrayList<Integer> as = new ArrayList<>();
		for (int i = 0; i < m; i++)
			as.add(in.nextInt());
		long ans = 0;
		for (int i = 0; i < n; i++) {
			int pos = bs(as, cities[i]);
			if (pos == m)
				pos--;
			long min = Math.abs((as.get(pos) - cities[i]));
			if (pos > 0)
				min = Math.min(min, Math.abs((as.get(pos - 1) - cities[i])));

			ans = Math.max(ans, min);
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
