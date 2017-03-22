package cp2_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Uva297_QuadTrees {
	static int idx, c;

	static Node build(String preorder, int lvl) {
		Node res = null;
		int x = idx++;
		if (preorder.charAt(x) == 'e')
			res = new Node(0, lvl);
		else if (preorder.charAt(x) == 'f')
			res = new Node(1, lvl);
		else {
			res = new Node();
			for (int i = 0; i < 4; ++i)
				res.add(build(preorder, lvl + 1));
		}
		return res;
	}

	static int merge(Node r1, Node r2) {

		if (r1 == null && r2 == null)
			return 0;

		if (r1 != null && r1.isLeaf() && r1.val == 1)
			return 1 << (5 - r1.lvl << 1);

		if (r2 != null && r2.isLeaf() && r2.val == 1)
			return 1 << (5 - r2.lvl << 1);

		int ans = 0;
		for (int i = 0; i < 4; ++i)
			ans += merge(r1 == null ? null : r1.children[i], r2 == null ? null
					: r2.children[i]);

		return ans;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		while (n-- > 0) {
			idx = 0;
			Node r1 = build(in.next(), 0);
			idx = 0;
			Node r2 = build(in.next(), 0);
			out.printf("There are %d black pixels.\n", merge(r1, r2));
		}
		out.flush();
		out.close();
	}

	static class Node {
		int val; // -1 not mentiond e is 0 f is 1
		int idx;
		int lvl;
		Node[] children = new Node[4];

		Node() {
			val = -1;
		}

		Node(int x, int y) {
			val = x;
			lvl = y;
		}

		boolean isLeaf() {
			return children[0] == null;
		}

		void add(Node n) {
			children[idx++] = n;
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
