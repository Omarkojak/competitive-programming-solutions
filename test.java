import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test {
	static final int INF = (int) 1e9;
	static ArrayList<Edge>[] adjList;
	static int V;

	private static boolean Bellmen() {
		long []dist = new long[V];
		Arrays.fill(dist, INF);
		dist[0] = 0;
		for (int i = 0; i < V - 1; i++) {
			for (int u = 0; u < V; u++) {
				for (int z = 0; z < adjList[u].size(); z++) {
					Edge v = adjList[u].get(z);
					dist[v.node] = Math.min(dist[v.node], dist[u] + v.cost);

				}
			}
		}
		for (int u = 0; u < V; u++) {
			for (int j = 0; j < adjList[u].size(); j++) {
				Edge v = adjList[u].get(j);

				if (dist[v.node] > dist[u] + v.cost)
					
				return true;
			}
		}
		return false;
	}

	static class Edge implements Comparable<Edge> {
		int node, cost;

		Edge(int a, int b) {
			node = a;
			cost = b;
		}

		public int compareTo(Edge e) {
			if (cost != e.cost)
				return cost - e.cost;
			return node - e.node;
		}

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		int m = in.nextInt();
		int z = in.nextInt();
		int l = n, r= m;
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		while(n<=z){
			a.add(n);
			n+=l;
		}
		while(m<=z){
			b.add(m);
			m+=r;
		}
		int []x = new int[a.size()];
		for(int i=0;i<a.size();i++)
			x[i] = a.get(i);
		int cnt = 0;
		for(int i=0;i<b.size();i++){
			int v = b.get(i);
			int q = Arrays.binarySearch(x,v);
			if(q>=0)
				cnt++;
		}
		System.out.println(cnt);
		

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
