package OfficialContests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Damscus_2015_C {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		long t = in.nextLong();
		while (t-- > 0) {
			long[] c = new long[1000005];
			long n = in.nextLong();
			long m = in.nextLong();
			long summ = 0l;

			while (n-- > 0) {
				int cx = in.nextInt();
				c[cx]++;
				summ += cx;
			}
			if (summ < m) {
				System.out.println("Impossible");
				continue;
			}

			ArrayList<Num> as = new ArrayList<Num>();
			for (int i = 0; i < 1000005; i++)
				if (c[i] != 0)
					as.add(new Num(c[i] * i, i));
			Collections.sort(as);
			PriorityQueue<Long> pq = new PriorityQueue<Long>();
			long res = 0;
			for (Num curr : as) {
				if (res >= m)
					break;
				res += curr.data;
				pq.add(curr.v);
			}
			while (!pq.isEmpty()) {
				System.out.print(pq.poll());
				if (!pq.isEmpty())
					System.out.print(" ");
			}
			System.out.println();

		}

	}

	static class Num implements Comparable<Num> {
		long data;
		long v;

		Num(long a, long b) {
			data = a;
			v = b;
		}

		@Override
		public int compareTo(Num o) {
			if (data > o.data)
				return -1;
			if (data < o.data)
				return 1;
			if (v > o.v)
				return -1;
			if (o.v > v)
				return 1;
			return 0;
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
