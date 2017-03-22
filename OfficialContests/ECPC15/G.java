package OfficialContests.ECPC15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G {
	static int V;
	static ArrayList<Edge> adjList[];
	static long cost;
	static final long inf = (long) 1e18;

	public static boolean f(long wis) {
		long dist[] = new long[V];
		Arrays.fill(dist, inf);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[0] = 0;
		pq.add(new Edge(0, 0, 0));
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (curr.node == V - 1 && dist[V - 1] < cost)
				return true;

			if (dist[curr.node] < curr.cost || curr.cost >= cost)
				continue;

			for (Edge e : adjList[curr.node]) {
				if (e.wisdom <= wis && dist[e.node] > curr.cost + e.cost) {
					dist[e.node] = curr.cost + e.cost;
					pq.add(new Edge(e.node, dist[e.node], 0));
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			V = in.nextInt();
			int m = in.nextInt();
			cost = in.nextLong();
			adjList = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjList[i] = new ArrayList<>();
			while (m-- > 0) {
				int u = in.nextInt() - 1;
				int v = in.nextInt() - 1;
				long c = in.nextLong();
				long wis = in.nextLong();
				adjList[u].add(new Edge(v, c, wis));
				adjList[v].add(new Edge(u, c, wis));
			}
			long low = 0l, high = (long) 1e10, ans = -1;
			while (low <= high) {
				long mid = (low + high) >> 1;
				if (f(mid)) {
					ans = mid;
					high = mid - 1;
				} else
					low = mid + 1;
			}

			sb.append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static class Edge implements Comparable<Edge> {
		int node;
		long cost;
		long wisdom;

		Edge(int a, long b, long c) {
			node = a;
			cost = b;
			wisdom = c;
		}

		public int compareTo(Edge e) {
			int comp = Long.compare(cost, e.cost);
			if (comp != 0)
				return comp;
			comp = Long.compare(wisdom, e.wisdom);
			return comp != 0 ? comp : node - e.node;
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
