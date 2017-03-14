package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class D761 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		int l = in.nextInt();
		int r = in.nextInt();
		int[] a = new int[n];
		ArrayList<Pair> as = new ArrayList<>();
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		for (int i = 0; i < n; i++)
			as.add(new Pair(i, in.nextInt()));

		Collections.sort(as);
		int[] c = new int[n];
		int[] b = new int[n];
		Pair beg = as.get(0);
		b[beg.idx] = l;
		c[beg.idx] = l - a[beg.idx];
		for (int i = 1; i < n; i++) {
			Pair curr = as.get(i);
			Pair prev = as.get(i - 1);
			int mn = l - a[curr.idx]; // l - a <= c <= r - a
			if (mn <= c[prev.idx])
				c[curr.idx] = c[prev.idx] + 1;
			else
				c[curr.idx] = mn;

			b[curr.idx] = c[curr.idx] + a[curr.idx];
		}
		boolean f = true;
		for (int i = 0; i < n; i++) {
			sb.append(b[i] + " ");
			if (b[i] > r)
				f = false;
		}
		System.out.println(f ? sb : -1);

	}

	static class Pair implements Comparable<Pair> {
		int idx;
		int val;

		Pair(int a, int b) {
			idx = a;
			val = b;
		}

		public int compareTo(Pair o) {
			return Integer.compare(val, o.val);
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
