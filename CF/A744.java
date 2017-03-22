package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A744 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		UnionFind uf = new UnionFind(n);
		boolean[] gov = new boolean[n];
		boolean[][] edge = new boolean[n][n];

		for (int i = 0; i < k; i++)
			gov[in.nextInt() - 1] = true;

		while (m-- > 0) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;
			edge[u][v] = edge[v][u] = true;
			uf.unionSet(u, v);
		}
		long ans = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				if (!edge[i][j] && uf.isSameSet(i, j)) {
					ans++;
					edge[i][j] = edge[j][i] = true;
				}

		int max = 0;
		int node = -1;
		for (int i = 0; i < n; i++)
			if (gov[i]) {
				int sze = uf.sizeOfSet(i);
				if (sze > max) {
					max = sze;
					node = i;
				}
			}

		for (int i = 0; i < n; i++) {
			boolean f = true;
			for (int j = 0; j < n; j++)
				if (gov[j] && uf.isSameSet(i, j))
					f = false;
			if (f) {
				ans += uf.sizeOfSet(i) * uf.sizeOfSet(node);
				uf.unionSet(i, node);
			}
		}

		System.out.println(ans);

	}

	static class UnionFind {
		int[] p, rank, setSize;
		int numSets;

		public UnionFind(int N) {
			p = new int[numSets = N];
			rank = new int[N];
			setSize = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
				setSize[i] = 1;
			}
		}

		public int findSet(int i) {
			return p[i] == i ? i : (p[i] = findSet(p[i]));
		}

		public boolean isSameSet(int i, int j) {
			return findSet(i) == findSet(j);
		}

		public void unionSet(int i, int j) {
			if (isSameSet(i, j))
				return;
			numSets--;
			int x = findSet(i), y = findSet(j);
			if (rank[x] > rank[y]) {
				p[y] = x;
				setSize[x] += setSize[y];
			} else {
				p[x] = y;
				setSize[y] += setSize[x];
				if (rank[x] == rank[y])
					rank[y]++;
			}
		}

		public int numDisjointSets() {
			return numSets;
		}

		public int sizeOfSet(int i) {
			return setSize[findSet(i)];
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
