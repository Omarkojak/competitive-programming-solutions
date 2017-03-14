package cp4_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Uva11101_MallMania {
	static Boolean[] comp; // true -> 1st mall false -> 2nd mall null neither
							// nor
	static final int cons = 2100;
	static ArrayList<Integer> as;
	static int size;
	static final int inf = (int) 1e9;

	public static int dijkstra() {
		int[] dist = new int[cons * cons];
		Arrays.fill(dist, inf);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < size; i += 2) {
			int x = as.get(i);
			int y = as.get(i + 1);
			dist[conv(x, y)] = 0;
			pq.add(new Edge(x, y, 0));
		}

		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			int node = conv(curr.x, curr.y);
			if (dist[node] < curr.cost)
				continue;
			if (comp[node] != null && comp[node] == false)
				return curr.cost;

			int right = conv(curr.x + 1, curr.y);
			if (dist[right] > curr.cost + 1) {
				dist[right] = curr.cost + 1;
				pq.add(new Edge(curr.x + 1, curr.y, dist[right]));
			}

			int left = conv(curr.x - 1, curr.y);
			if (curr.x - 1 >= 0 && dist[left] > curr.cost + 1) {
				dist[left] = curr.cost + 1;
				pq.add(new Edge(curr.x - 1, curr.y, dist[left]));
			}

			int up = conv(curr.x, curr.y + 1);
			if (dist[up] > curr.cost + 1) {
				dist[up] = curr.cost + 1;
				pq.add(new Edge(curr.x, curr.y + 1, dist[up]));
			}

			int down = conv(curr.x, curr.y - 1);
			if (curr.y - 1 >= 0 && dist[down] > curr.cost + 1) {
				dist[down] = curr.cost + 1;
				pq.add(new Edge(curr.x, curr.y - 1, dist[down]));
			}

		}
		return 0;
	}

	static int conv(int i, int j) {
		return i * cons + j;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			int n = in.nextInt();
			if (n == 0)
				break;
			as = new ArrayList<>();
			comp = new Boolean[cons * cons];
			size = n * 2;
			while (n-- > 0) {
				int x = in.nextInt();
				int y = in.nextInt();
				int node = conv(x, y);
				as.add(x);
				as.add(y);
				comp[node] = true;
			}
			n = in.nextInt();
			while (n-- > 0) {
				int x = in.nextInt();
				int y = in.nextInt();
				int node = conv(x, y);
				comp[node] = false;
			}
			sb.append(dijkstra()).append("\n");
		}
		System.out.print(sb);
	}

	static class Edge implements Comparable<Edge> {
		int x, y, cost;

		Edge(int a, int b, int c) {
			x = a;
			y = b;
			cost = c;
		}

		public int compareTo(Edge e) {
			if (cost != e.cost)
				return cost - e.cost;

			if (x != e.x)
				return x - e.x;
			return y - e.y;
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
