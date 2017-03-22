package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E519 {
	static int[] euler, level, index, size, P[];
	static ArrayList<Integer>[] graph;
	static int idx;

	static void dfs(int u, int p, int d) {
		P[u][0] = p;
		index[u] = idx;
		level[idx] = d;
		euler[idx++] = u;
		size[u]++;
		for (int v : graph[u]) {
			if (p != v) {
				dfs(v, u, d + 1);
				euler[idx] = u;
				level[idx++] = d;
				size[u] += size[v];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		graph = new ArrayList[n];

		for (int i = 0; i < n; i++)
			graph[i] = new ArrayList<>();
		for (int i = 0; i < n - 1; i++) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;
			graph[u].add(v);
			graph[v].add(u);
		}
		int k = (int) Math.floor(Math.log(n) / Math.log(2)) + 1;
		euler = new int[n << 1];
		level = new int[n << 1];
		index = new int[n];
		size = new int[n];
		P = new int[n][k];
		for (int i = 0; i < n; i++)
			Arrays.fill(P[i], -1);
		dfs(0, -1, 0);
		for (int j = 1; 1 << j < n; j++)
			for (int i = 0; i < n; i++)
				if (P[i][j - 1] != -1)
					P[i][j] = P[P[i][j - 1]][j - 1];
		SparseTable st = new SparseTable(level);
		int q = in.nextInt();
		while (q-- > 0) {
			int a = in.nextInt() - 1;
			int b = in.nextInt() - 1;
			if (a == b) {
				System.out.println(n);
				continue;
			}
			if (index[b] < index[a]) {
				int temp = b;
				b = a;
				a = temp;
			}
			int lca = level[index[euler[st.query(index[a], index[b])]]];
			int la = level[index[a]];
			int lb = level[index[b]];
			if (((la + lb - 2 * lca) % 2) != 0) {
				System.out.println(0);
				continue;
			}
			if (la - lca == lb - lca) {
				System.out.println(n - size[query(a, la - lca - 1)]
						- size[query(b, la - lca - 1)]);
				continue;
			}
			int leveln = (la + lb - 2 * lca) / 2;
			int child = leveln - 1;
			if (level[index[a]] < level[index[b]]) {
				int temp = b;
				b = a;
				a = temp;
			}
			int aa = query(a, child);
			int bb = query(a, leveln);
			System.out.println(size[bb] - size[aa]);

		}

	}

	static int query(int u, int k) {
		while (k != 0 && u != -1) {
			int x = (int) Math.floor(Math.log(k) / Math.log(2));
			u = P[u][x];
			k -= (1 << x);
		}
		return u;
	}

	static class SparseTable {
		int A[], SpT[][];

		SparseTable(int[] A) {
			int n = A.length;
			this.A = A;
			int k = (int) Math.floor(Math.log(n) / Math.log(2)) + 1;
			SpT = new int[n][k];

			for (int i = 0; i < n; i++)
				SpT[i][0] = i;

			for (int j = 1; (1 << j) <= n; j++)
				for (int i = 0; i + (1 << j) - 1 < n; i++)

					if (A[SpT[i][j - 1]] < A[SpT[i + (1 << (j - 1))][j - 1]])
						SpT[i][j] = SpT[i][j - 1];
					else
						SpT[i][j] = SpT[i + (1 << (j - 1))][j - 1];
		}

		int query(int i, int j) {

			int k = (int) Math.floor(Math.log(j - i + 1) / Math.log(2));

			if (A[SpT[i][k]] <= A[SpT[j - (1 << k) + 1][k]])
				return SpT[i][k];
			else
				return SpT[j - (1 << k) + 1][k];
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
