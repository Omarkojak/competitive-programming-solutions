package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class D246 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] color = new int[n];
		int size = 0;
		int min = 1000000;
		for (int i = 0; i < n; i++) {
			color[i] = in.nextInt();
			size = Math.max(size, color[i]);
			min = Math.min(min, color[i]);
		}
		TreeSet<Integer>[] adjList = new TreeSet[size + 1];
		for (int i = 0; i < size + 1; i++)
			adjList[i] = new TreeSet<Integer>();

		boolean done = false;
		while (m-- > 0) {
			int u1 = in.nextInt() - 1;
			int u2 = in.nextInt() - 1;
			int color1 = color[u1];
			int color2 = color[u2];
			if (color1 != color2) {
				adjList[color1].add(color2);
				adjList[color2].add(color1);
				done = true;
			}

		}
		if (done) {
			int max = -1, maxcolor = -1;
			for (int i = 0; i < size + 1; i++) {
				if (adjList[i].size() > max) {
					max = adjList[i].size();
					maxcolor = i;
				}
			}
			System.out.println(maxcolor);
		} else {
			System.out.println(min);
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
