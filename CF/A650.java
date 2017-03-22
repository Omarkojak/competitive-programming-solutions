package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class A650 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		TreeMap<Integer, Integer> dx = new TreeMap<Integer, Integer>();
		TreeMap<Integer, Integer> dy = new TreeMap<Integer, Integer>();
		TreeMap<Pair, Integer> dups = new TreeMap<Pair, Integer>();
		Queue<Pair> q = new LinkedList<Pair>();
		Queue<Pair> dupss = new LinkedList<Pair>();

		for (int i = 0; i < n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			Pair curr = new Pair(x, y);
			if (dups.containsKey(curr)) {
				int v = dups.get(curr);
				dups.put(curr, v + 1);
				if (v == 1)
					dupss.add(curr);
			} else {
				dups.put(curr, 1);
			}
			q.add(curr);
			int v = 0;
			if (dx.containsKey(x))
				v = dx.get(x);
			dx.put(x, v + 1);

			v = 0;
			if (dy.containsKey(y))
				v = dy.get(y);
			dy.put(y, v + 1);

		}
		long res = 0;
		while (!q.isEmpty()) {
			Pair curr = q.poll();
			int k = 1;
			if (dups.containsKey(curr))
				k = dups.get(curr);
			int vx = 0;
			if (dx.containsKey(curr.x))
				vx = dx.get(curr.x) - k;

			int vy = 0;
			if (dy.containsKey(curr.y))
				vy = dy.get(curr.y) - k;
			System.out.println(vx + " " + vy);

			res += (vy + vx);

			System.out.println(" " + res);
		}

		System.out.println(res / 2);

	}

	static class Pair implements Comparable<Pair> {
		int x;
		int y;

		Pair(int a, int b) {
			x = a;
			y = b;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			if (this.x == o.x && this.y == o.y)
				return 0;
			if (this.x != o.x)
				return this.x - o.x;
			return this.y - o.y;
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
