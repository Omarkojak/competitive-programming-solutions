package cp4_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva10369_ArcticNetworks {
	static Edge[] edgeList;
	static int V, K, xaxis[], yaxis[];

	static double kruskal() {
		double mst = 0;
		Arrays.sort(edgeList);
		UnionFind uf = new UnionFind(V);

		for (Edge e : edgeList) {
			if (!uf.isSameSet(e.from, e.to)) {
				mst = Math.max(mst, e.cost);
				uf.unionSet(e.from, e.to);
				// System.err.println(e.cost + " " + e.from + " " + e.to);
			}
			if (uf.numDisjointSets() == K)
				break;
		}

		return mst;
	}

	public static double dis(int u, int v) {
		return Math.sqrt(sq(xaxis[u] - xaxis[v]) + sq(yaxis[u] - yaxis[v]));
	}

	public static double sq(double x) {
		return x * x;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt();
		while (t-- > 0) {
			K = in.nextInt();
			V = in.nextInt();
			xaxis = new int[V];
			yaxis = new int[V];
			for (int i = 0; i < V; i++) {
				xaxis[i] = in.nextInt();
				yaxis[i] = in.nextInt();
			}
			int idx = 0;
			edgeList = new Edge[(V * (V - 1)) >> 1];
			for (int i = 0; i < V; i++)
				for (int j = i + 1; j < V; j++)
					edgeList[idx++] = new Edge(i, j, dis(i, j));
			out.printf("%.2f\n", kruskal());
		}
		out.flush();
		out.close();
	}

	static class Edge implements Comparable<Edge> {
		int from, to;
		double cost;

		Edge(int a, int b, double c) {
			from = a;
			to = b;
			cost = c;
		}

		public int compareTo(Edge e) {
			int comp = Double.compare(cost, e.cost);
			if (comp != 0)
				return comp;
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
			// rank is used to keep the tree short
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
