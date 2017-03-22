package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// idx bugs lines
public class A543 {
	static int[] cbugs;
	static int n, m, b;
	static long cnt;

	static void bfs() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(0, 0, 0));

		while (!q.isEmpty()) {
			Node curr = q.poll();
			int bugsnow = curr.bugs;
			int lines = curr.lines;
			if (curr.idx + 1 == n)
				continue;
			while (bugsnow <= b) {
				if (lines > m)
					break;
				if (curr.idx + 1 == n && lines == m) {
					cnt++;
					break;
				}

				q.add(new Node(curr.idx + 1, bugsnow, lines));
				lines++;
				bugsnow += cbugs[curr.idx];
			}

		}
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		b = in.nextInt();
		int mod = in.nextInt();
		cbugs = new int[n];
		for (int i = 0; i < n; i++)
			cbugs[i] = in.nextInt();

		cnt = 0;
		bfs();
		System.out.println(cnt % mod);
	}

	static class Node {
		int bugs, idx, lines;

		Node(int a, int b, int c) {
			idx = a;
			bugs = b;
			lines = c;

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
