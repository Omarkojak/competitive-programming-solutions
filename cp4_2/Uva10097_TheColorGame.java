package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Uva10097_TheColorGame {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int cse = 1;
		while (n != 0) {
			int[][] adjMatrix = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					adjMatrix[i][j] = in.nextInt() - 1;
			Queue<Integer> q = new LinkedList<Integer>();
			int n1 = in.nextInt() - 1;
			int n2 = in.nextInt() - 1;
			int n3 = in.nextInt() - 1;
			q.add(n1);
			q.add(n2);
			q.add(0);

			boolean[][] vis = new boolean[n][n];
			int res = (int) 1e9;

			while (!q.isEmpty()) {
				int a = q.poll();
				int b = q.poll();
				int cost = q.poll();
				if (vis[a][b])
					continue;
				vis[a][b] = true;
				if (a == n3 || b == n3) {
					res = cost;
					break;
				}
				if (adjMatrix[a][b] != -1) {
					q.add(adjMatrix[a][b]);
					q.add(b);
					q.add(cost + 1);
				}
				if (adjMatrix[b][a] != -1) {
					q.add(adjMatrix[b][a]);
					q.add(a);
					q.add(cost + 1);
				}
			}
			System.out.printf("Game #%d\n", cse++);
			if (res == (int) 1e9)
				System.out.println("Destination is Not Reachable !");
			else
				System.out.println("Minimum Number of Moves = " + res);
			System.out.println();
			n = in.nextInt();
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
