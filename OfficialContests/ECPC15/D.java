package OfficialContests.ECPC15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class D {
	static ArrayList<Edge> adjList[];
	static int V;
	static ArrayList<Edge> leaves;

	public static void dfs(int node, long time) {
		if (adjList[node].size() == 0) {
			leaves.add(new Edge(1, time));
			return;
		}

		long timefirst = adjList[node].get(0).time;
		for (Edge e : adjList[node])
			dfs(e.node, time + timefirst + (e.time - timefirst) * 2);

	}

	public static int bs(long time) {
		int low = 0, high = leaves.size() - 1;
		int ans = 0;
		while (low <= high) {
			int mid = (low + high) >> 1;
			if (leaves.get(mid).time <= time) {
				ans = leaves.get(mid).node;
				low = mid + 1;
			} else
				high = mid - 1;
		}

		return ans;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			V = in.nextInt();
			adjList = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adjList[i] = new ArrayList<>();
			for (int i = 1; i < V; i++)
				adjList[in.nextInt() - 1].add(new Edge(i, in.nextLong()));
			for (int i = 0; i < V; i++)
				Collections.sort(adjList[i]);
			leaves = new ArrayList<>();
			dfs(0, 0l);
			Collections.sort(leaves);
			for (int j = 1; j < leaves.size(); j++)
				leaves.get(j).node += leaves.get(j - 1).node;
			int q = in.nextInt();
			while (q-- > 0)
				sb.append(bs(in.nextLong())).append("\n");

		}
		System.out.print(sb);

	}

	static class Edge implements Comparable<Edge> {
		int node;
		long time;

		Edge(int a, long t) {
			node = a;
			time = t;
		}

		public int compareTo(Edge e) {
			int comp = Long.compare(time, e.time);
			return comp != 0 ? comp : node - e.node;
		}

		public String toString() {
			return  node + " " + time;
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
