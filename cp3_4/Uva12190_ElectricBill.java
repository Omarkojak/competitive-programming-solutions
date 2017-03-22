package cp3_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva12190_ElectricBill {

	public static long binarysearch(long sum, long diff) {
		long low = 0;
		long high = sum;
		long prev = -1l;
		while (low <= high) {
			long mid = (low + high) / 2;
			long b = sum - mid;
			if (mid - b == diff) {
				prev = mid;
				high = mid - 1;
			} else {
				if (mid - b < diff) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}

		return sum - prev;

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		long[] cons = { 100l, 9900l, 990000l };
		long[] rate = { 2l, 3l, 5l };
		long[] prefix = new long[3];
		prefix[0] = 200l;
		for (int i = 1; i < 3; i++) {
			prefix[i] = prefix[i - 1] + rate[i] * cons[i];
		}
		StringBuilder sb = new StringBuilder();
		while (true) {
			long sum = in.nextLong();
			long diff = in.nextLong();
			if (sum == 0 && diff == 0)
				break;
			sb.append(binarysearch(sum, diff) + "\n");

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
