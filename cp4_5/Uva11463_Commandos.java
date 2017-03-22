package cp4_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva11463_Commandos {
	static int N, adjMatrix[][];
	static final int inf = (int) 1e9;

	public static void APSP() {
		for (int k = 0; k < N; k++)
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k]
							+ adjMatrix[k][j]);

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt(), cse = 1;
		while (t-- > 0) {
			N = in.nextInt();
			adjMatrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(adjMatrix[i], inf);
				adjMatrix[i][i] = 0;
			}
			int m = in.nextInt();
			while (m-- > 0) {
				int u = in.nextInt();
				int v = in.nextInt();
				adjMatrix[u][v] = adjMatrix[v][u] = 1;
			}
			APSP();
			int max = 0;
			int source = in.nextInt();
			int sink = in.nextInt();
			for (int k = 0; k < N; k++)
				max = Math.max(max, adjMatrix[source][k] + adjMatrix[k][sink]);
			out.printf("Case %d: %d\n", cse++, max);
		}
		out.flush();
		out.close();
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
