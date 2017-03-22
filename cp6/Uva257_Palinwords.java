package cp6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Uva257_Palinwords {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (in.ready()) {
			String t = in.next();
			char[] s = t.toCharArray();
			TreeSet<String> ts = new TreeSet<>();
			for (int i = 0; i < s.length - 2; i++) {
				if (s[i] == s[i + 2])
					ts.add(s[i] + "" + s[i + 1] + "" + s[i + 2]);
				if (i < s.length - 3)
					if (s[i] == s[i + 3] && s[i + 1] == s[i + 2])
						ts.add(s[i] + "" + s[i + 1] + "" + s[i + 2] + ""
								+ s[i + 3]);
			}
			ArrayList<String> as = new ArrayList<>();
			boolean flag = false;
			while (!ts.isEmpty()) {
				String k = ts.pollFirst();
				for (int i = 0; i < as.size(); i++) {
					String w = as.get(i);
					if (w.length() > k.length()) {
						if (!w.contains(k))
							flag = true;
					} else if (!k.contains(w))
						flag = true;

				}
				if (flag)
					break;
				as.add(k);
			}
			if (flag)
				sb.append(t).append("\n");
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
