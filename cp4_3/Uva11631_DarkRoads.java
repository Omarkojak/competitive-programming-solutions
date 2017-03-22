package cp4_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva11631_DarkRoads {
	static int V;
	static Edge2[] edgeList;

	static int kruskal() {
		int mst = 0;
		Arrays.sort(edgeList);
		UnionFind uf = new UnionFind(V);

		for (Edge2 e : edgeList)
			if (!uf.isSameSet(e.from, e.to)) {
				mst += e.cost;
				uf.unionSet(e.from, e.to);
			}

		return mst;
	}

	static class Edge2 implements Comparable<Edge2> {
		int from, to, cost;

		Edge2(int a, int b, int c) {
			from = a;
			to = b;
			cost = c;
		}

		public int compareTo(Edge2 e) {
			if (cost != e.cost)
				return cost - e.cost;
			if (from != e.from)
				return from - e.from;
			return to - e.to;
		}
	}

	static class UnionFind {
		int[] p, rank, setSize;
		int numSets;

		public UnionFind(int N) {
			p = new int[N];
			rank = new int[N];
			setSize = new int[N];
			numSets = N;
			for (int i = 0; i < N; i++) {
				p[i] = i;
				setSize[i] = 1;
			}
		}

		public int findSet(int i) {
			if (p[i] == i)
				return i;
			else
				return p[i] = findSet(p[i]);
		}

		public Boolean isSameSet(int i, int j) {
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

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		int m = in.nextInt();
		while (n != 0 || m != 0) {
			V = n;
			edgeList = new Edge2[m * 2];
			long totalcost = 0;
			int j = 0;
			for (int i = 0; i < m; i++) {
				int from = in.nextInt();
				int to = in.nextInt();
				int c = in.nextInt();
				totalcost += c;
				edgeList[j++] = new Edge2(from, to, c);
				edgeList[j++] = new Edge2(to, from, c);
			}
			sb.append(totalcost - kruskal() + "\n");
			n = in.nextInt();
			m = in.nextInt();
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
