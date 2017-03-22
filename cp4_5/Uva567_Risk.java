package cp4_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Uva567_Risk {
	static boolean[][] adjMatrix;
	static final int inf = (int) 1e9;

	public static int[][] APSP() {
		int ret[][] = new int[20][20];
		for (int i = 0; i < 20; i++)
			for (int j = 0; j < 20; j++)
				if (i != j) {
					if (adjMatrix[i][j])
						ret[i][j] = 1;
					else
						ret[i][j] = inf;
				}

		for (int k = 0; k < 20; k++)
			for (int i = 0; i < 20; i++)
				for (int j = 0; j < 20; j++)
					ret[i][j] = Math.min(ret[i][j], ret[i][k] + ret[k][j]);
		return ret;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cse = 1;
		// int t = 2;
		while (in.br.ready()) {
			adjMatrix = new boolean[20][20];
			for (int i = 0; i < 19; i++) {
				int k = in.nextInt();
				while (k-- > 0) {
					int u = in.nextInt() - 1;
					adjMatrix[i][u] = adjMatrix[u][i] = true;
				}
			}
			int[][] res = APSP();

			out.printf("Test Set #%d\n", cse++);
			int q = in.nextInt();
			while (q-- > 0) {
				int u = in.nextInt();
				int v = in.nextInt();
				int dis = res[u - 1][v - 1];
				out.printf("%2d to %2d: %d\n", u, v, dis);
			}
			out.println();
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

		public boolean nxtEmpty() throws IOException {
			String line = br.readLine();
			if (line == null || line.isEmpty())
				return true;
			st = new StringTokenizer(line);
			return false;
		}
	}
}
