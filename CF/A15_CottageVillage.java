package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A15_CottageVillage {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		double t = in.nextInt() * 1.0;
		ArrayList<House> as = new ArrayList<>();
		while (n-- > 0)
			as.add(new House(in.nextInt(), in.nextInt()));
		int ans = 2;
		Collections.sort(as);
		for (int i = 1; i < as.size(); i++) {
			double val = as.get(i).c - as.get(i).d/2.0 - (as.get(i - 1).c + as.get(i - 1).d/2.0);
			if(val > t)
				ans+=2;
			if(val == t)
				ans+=1;
		}
		System.out.println(ans);

	}

	static class House implements Comparable<House> {
		int c, d;

		House(int a, int b) {
			c = a;
			d = b;
		}

		public int compareTo(House h) {
			if (c != h.c)
				return c - h.c;
			return d - h.d;
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

	}
}
