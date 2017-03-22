package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Uva11368_NestedDolls {

	static int lis(ArrayList<Doll> as, int n) {
		ArrayList<Integer> L = new ArrayList<Integer>();
		for (int i = 0; i < n; ++i) {
			int h = as.get(i).h;
			int pos = Collections.binarySearch(L, h);
			if (pos < 0)
				pos = -(pos + 1);

			if (pos >= L.size())
				L.add(h);
			else {
				if (L.get(pos) == h) {
					for (; pos < L.size() && L.get(pos) == h; ++pos)
						;
					if (pos < L.size())
						L.set(pos, h);
					else
						L.add(h);
				} else
					L.set(pos, h);
			}
		}
		return L.size();
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			ArrayList<Doll> as = new ArrayList<>();
			for (int i = 0; i < n; i++)
				as.add(new Doll(in.nextInt(), in.nextInt()));
			Collections.sort(as);
			sb.append(lis(as, n)).append("\n");
		}
		System.out.print(sb);
	}

	static class Doll implements Comparable<Doll> {
		int w;
		int h;

		Doll(int a, int b) {
			w = a;
			h = b;
		}

		public int compareTo(Doll o) {
			if (w != o.w)
				return o.w - w;
			return h - o.h;
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
	}
}