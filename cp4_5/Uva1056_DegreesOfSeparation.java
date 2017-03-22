package cp4_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Uva1056_DegreesOfSeparation {
	static boolean[][] adjMatrix;
	static int P;
	static final int inf = (int) 1e9;

	public static int APSP() {
		int dist[][] = new int[P][P];
		for (int i = 0; i < P; i++) {
			Arrays.fill(dist[i], inf);
			dist[i][i] = 0;
		}

		for (int i = 0; i < P; i++)
			for (int j = 0; j < P; j++)
				if (adjMatrix[i][j])
					dist[i][j] = 1;
		for (int k = 0; k < P; k++)
			for (int i = 0; i < P; i++)
				for (int j = 0; j < P; j++)
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
		int max = 0;
		for (int i = 0; i < P; i++)
			for (int j = 0; j < P; j++)
				max = Math.max(max, dist[i][j]);
		return max;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cse = 1;
		while (true) {
			P = in.nextInt();
			int m = in.nextInt();
			if (P == 0 && m == 0)
				break;
			adjMatrix = new boolean[P][P];
			TreeMap<String, Integer> mp = new TreeMap<>();
			int k = 0;
			while (m-- > 0) {
				String s1 = in.next();
				String s2 = in.next();
				if (!mp.containsKey(s1))
					mp.put(s1, k++);
				if (!mp.containsKey(s2))
					mp.put(s2, k++);
				int u = mp.get(s1);
				int v = mp.get(s2);
				adjMatrix[u][v] = true;
				adjMatrix[v][u] = true;
			}
			int val = APSP();
			if (val == inf)
				out.printf("Network %d: DISCONNECTED\n", cse++);
			else
				out.printf("Network %d: %d\n", cse++, val);
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
