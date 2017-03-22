package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B551 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String a = in.nextLine();
		String b = in.nextLine();
		String c = in.nextLine();
		int[] cnta = new int[26];
		int[] cntb = new int[26];
		int[] cntc = new int[26];

		for (int i = 0; i < a.length(); i++)
			cnta[a.charAt(i) - 'a']++;
		for (int i = 0; i < b.length(); i++)
			cntb[b.charAt(i) - 'a']++;
		for (int i = 0; i < c.length(); i++)
			cntc[c.charAt(i) - 'a']++;

		while (true) {
			int c1 = (int) 1e7;
			for (int i = 0; i < 26; i++)
				if (cntb[i] != 0)
					c1 = Math.min(cnta[i] / cntb[i], c1);

			int c2 = (int) 1e7;
			for (int i = 0; i < 26; i++)
				if (cntc[i] != 0)
					c2 = Math.min(cnta[i] / cntc[i], c2);
			if (c1 == 0 && c2 == 0)
				break;
			if (c1 > c2) {
				for (int i = 0; i < b.length(); i++)
					cnta[b.charAt(i) - 'a']--;
				sb.append(b);
			} else {
				for (int i = 0; i < c.length(); i++)
					cnta[c.charAt(i) - 'a']--;
				sb.append(c);
			}

		}
		for (int i = 0; i < 26; i++) {
			char k = (char) ('a' + i);
			while (cnta[i]-- > 0)
				sb.append(k);
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