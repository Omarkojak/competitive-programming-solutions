package cp4_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Uva10187_FromDuskTillDawn {
	static ArrayList<Edge> adjList[]; // first = dep. second = arrival
	static final int inf = (int) 1e9;

	public static int dijkstra(int source, int sink) {
		int[][] dist = new int[150][50];
		for (int i = 0; i < 150; i++)
			Arrays.fill(dist[i], inf);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(source, 0, 18));// first = days second = time
		dist[source][18] = 0;
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (curr.node == sink)
				return curr.first;

			if (dist[curr.node][curr.second] < curr.first)
				continue;

			for (Edge e : adjList[curr.node]) {
				if (e.first < curr.second) {
					if (dist[e.node][e.second] > curr.first + 1)
						pq.add(new Edge(e.node,
								(dist[e.node][e.second] = curr.first + 1),
								e.second));
				} else if (dist[e.node][e.second] > curr.first)
					pq.add(new Edge(e.node,
							(dist[e.node][e.second] = curr.first), e.second));

			}

		}
		return inf;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt(), cse = 1;
		while (t-- > 0) {
			adjList = new ArrayList[105];
			for (int i = 0; i < 105; i++)
				adjList[i] = new ArrayList<>();

			TreeMap<String, Integer> mp = new TreeMap<>();
			int m = in.nextInt(), cnt = 0;
			int k = 1;
			while (m-- > 0) {
				String s1 = in.next();
				String s2 = in.next();

				if (!mp.containsKey(s1))
					mp.put(s1, cnt++);

				if (!mp.containsKey(s2))
					mp.put(s2, cnt++);
				int u = mp.get(s1);
				int v = mp.get(s2);
				int dep = in.nextInt();
				if(dep <= 6)
					dep += 24;
				int arrival = in.nextInt() + dep;
				if (dep >= 18 && arrival <= 30 && dep <= 30 && arrival >= 18) {
					adjList[u].add(new Edge(v, dep, arrival));
					// System.err.println(s1 + " " + k);
				}
				k++;
			}
			out.printf("Test Case %d.\n", cse++);
			String s1 = in.next();
			String s2 = in.next();
			if (s1.equals(s2)) {
				out.printf("Vladimir needs %d litre(s) of blood.\n", 0);
				continue;
			}
			
			if (!mp.containsKey(s1) || !mp.containsKey(s2)) {
				out.println("There is no route Vladimir can take.");
				continue;
			}
			

			int val = dijkstra(mp.get(s1), mp.get(s2));
			if (val == inf)
				out.println("There is no route Vladimir can take.");
			else
				out.printf("Vladimir needs %d litre(s) of blood.\n", val);

		}
		out.flush();
		out.close();
	}

	static class Edge implements Comparable<Edge> {
		int node;
		int first, second;

		Edge(int a, int b, int c) {
			node = a;
			first = b;
			second = c;
		}

		public int compareTo(Edge e) {
			if (first != e.first)
				return first - e.first;

			if (second != e.second)
				return second - e.second;

			return node - e.node;

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
