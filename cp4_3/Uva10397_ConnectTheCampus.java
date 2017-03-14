package cp4_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Uva10397_ConnectTheCampus {
	static int N, xaxis[], yaxis[];
	static Scanner in;
	static boolean exist[][];

	public static double mss() throws IOException {
		boolean vis[] = new boolean[N];
		exist = new boolean[N][N];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int m = in.nextInt();
		while (m-- > 0) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;
			exist[u][v] = true;
			exist[v][u] = true;
		}
		pq.add(new Edge(0, 0.0));
		double res = 0.0;
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (vis[curr.node])
				continue;
			vis[curr.node] = true;
			res += curr.cost;
			for (int i = 0; i < N; i++)
				if (i != curr.node && !vis[i])
					pq.add(new Edge(i, exist[curr.node][i]? 0:dis(curr.node, i)));
		}

		return res;
	}

	public static double dis(int u, int v) {
		return Math.sqrt(sq(xaxis[u] - xaxis[v]) + sq(yaxis[u] - yaxis[v]));
	}

	public static double sq(double x) {
		return x * x;
	}

	public static void main(String[] args) throws IOException {
		in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		//int t = 2;
		while (in.br.ready()) {
			if (in.nextEmpty())
				continue;
			N = in.nextInt();
			xaxis = new int[N];
			yaxis = new int[N];
			for (int i = 0; i < N; i++) {
				xaxis[i] = in.nextInt();
				yaxis[i] = in.nextInt();
			}
			out.printf("%.2f\n", mss());
		}
		out.flush();
		out.close();
	}

	static class Edge implements Comparable<Edge> {
		int node;
		double cost;

		Edge(int a, double c) {
			node = a;
			cost = c;
		}

		public int compareTo(Edge e) {
			int comp = Double.compare(cost, e.cost);
			if (comp != 0)
				return comp;
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

		public boolean nextEmpty() throws IOException {
			String s = nextLine();
			st = new StringTokenizer(s);
			return s.isEmpty();
		}
	}

}
