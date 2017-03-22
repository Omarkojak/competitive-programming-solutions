package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D339 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		int m = in.nextInt();
		n = 1 << n;
		int[] a = new int[n + 1];
		for (int i = 1; i <= n; i++)
			a[i] = in.nextInt();
		SegmentTree st = new SegmentTree(a);
		while (m-- > 0) {
			st.update_point(in.nextInt(), in.nextInt());
			sb.append(st.query()).append("\n");
		}
		System.out.print(sb);
	}

	static class Pair {
		int num;
		char operation;

		Pair(int x, char c) {
			num = x;
			operation = c;
		}
	}

	static class SegmentTree {
		int N;
		int[] array;
		Pair[] sTree;

		SegmentTree(int[] in) {
			array = in;
			N = in.length - 1;
			sTree = new Pair[N << 1]; 
			build(1, 1, N, 0);
		}

		void build(int node, int b, int e, int l) {
			if (b == e)
				sTree[node] = new Pair(array[b], 'O');
			else {
				build(node << 1, b, (b + e) / 2, l + 1);
				build((node << 1) + 1, (b + e) / 2 + 1, e, l + 1);
				sTree[node] = generate(sTree[node << 1], sTree[(node << 1) + 1]);
			}
		}

		Pair generate(Pair p1, Pair p2) {
			if (p1.operation == 'O') {
				return new Pair(p1.num | p2.num, 'X');
			}
			return new Pair(p1.num ^ p2.num, 'O');
		}

		void update_point(int index, int val) {
			index += N - 1;
			sTree[index] = new Pair(val, 'O');
			while (index > 1) {
				index >>= 1;
				sTree[index] = generate(sTree[index << 1],
						sTree[(index << 1) + 1]);
			}
		}

		int query() {
			return sTree[1].num;
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
