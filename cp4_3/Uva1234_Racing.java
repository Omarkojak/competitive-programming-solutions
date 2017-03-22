package cp4_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Uva1234_Racing {
	static ArrayList<Edge>[] adjList;
	static int V;

	static int prim() {
		int mst = 0;
		boolean[] visited = new boolean[V];
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(0, 0));
		while (!pq.isEmpty()) {
			Edge cur = pq.remove();
			if (visited[cur.to])
				continue;
			visited[cur.to] = true;
			mst += cur.cost;
			for (Edge nxt : adjList[cur.to])
				if (!visited[nxt.to])
					pq.add(nxt);
		}

		return mst;
	}

	static class Edge implements Comparable<Edge> {
		int to, cost;

		Edge(int a, int b) {
			to = a;
			cost = b;
		}

		public int compareTo(Edge e) {
			if (cost != e.cost)
				return e.cost - cost;
			return e.to - to;
		}

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			V = n;
			int m = in.nextInt();
			adjList = new ArrayList[V];
			for (int i = 0; i < n; i++)
				adjList[i] = new ArrayList<Edge>();
			long sum = 0;
			while (m-- > 0) {
				int u1 = in.nextInt() - 1;
				int u2 = in.nextInt() - 1;
				int cost = in.nextInt();
				adjList[u1].add(new Edge(u2, cost));
				adjList[u2].add(new Edge(u1, cost));
				sum += cost;
			}
			System.out.println(sum - prim());
		}
		in.nextInt();

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
