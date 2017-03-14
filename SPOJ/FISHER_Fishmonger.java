package SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FISHER_Fishmonger {
	static int time[][], toll[][];
	static int n;
	static final int inf = (int) 1e9;
	static int min,ti;

	public static void dijkstra(int tim) {
		int dist[][] = new int[n][1005];
		for (int i = 0; i < n; i++)
			Arrays.fill(dist[i], inf);

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[0][0] = 0;
		pq.add(new Edge(0, 0, 0));

		
		min = inf;
		ti = -1;
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if(dist[curr.node][curr.t] < curr.c)
				continue;
			if(curr.node == n-1)
			{
				if(min > curr.c)
				{
					min = Math.min(min, curr.c);
					ti = curr.t;
				}
				else
					if(min == curr.c)
						ti = Math.min(ti, curr.t);
				continue;
			}
			
			for(int i=0;i<n;i++)
			{
				if(i == curr.node)
					continue;
				int timeneed = curr.t + time[curr.node][i];
				if(timeneed <= tim)
					if(dist[i][timeneed] > curr.c + toll[curr.node][i])
					{
						dist[i][timeneed] = curr.c + toll[curr.node][i];
						pq.add(new Edge(i,timeneed,dist[i][timeneed]));
					}
				
			}
			
		}

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			n = in.nextInt();
			int t = in.nextInt();
			if (n == 0 && t == 0)
				break;
			time = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					time[i][j] = in.nextInt();

			toll = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					toll[i][j] = in.nextInt();
			dijkstra(t);
			sb.append(min + " " + ti).append("\n");
		}
		System.out.print(sb);
	}

	static class Edge implements Comparable<Edge> {
		int node, t, c;

		Edge(int a, int b, int d) {
			node = a;
			t = b;
			c = d;
		}

		@Override
		public int compareTo(Edge o) {
			if (c != o.c)
				return c - o.c;
			if (t != o.t)
				return t - o.t;
			return node - o.node;
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
