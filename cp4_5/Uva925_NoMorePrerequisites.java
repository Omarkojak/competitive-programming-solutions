package cp4_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Uva925_NoMorePrerequisites {
	static boolean adjMatrix[][];
	static int V;

	public static boolean[][] transitiveclosure() {
		for (int k = 0; k < V; k++)
			for (int i = 0; i < V; i++)
				for (int j = 0; j < V; j++)
					adjMatrix[i][j] |= (adjMatrix[i][k] && adjMatrix[k][j]);
		boolean ret[][] = new boolean[V][V];
		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++)
				if (adjMatrix[i][j]) {
					boolean f = true;
					for (int k = 0; k < V && f; k++)
						if (adjMatrix[i][k] && adjMatrix[k][j])
							f = false;
					ret[i][j] = f;
				}
		return ret;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			V = in.nextInt();
			TreeMap<String, Integer> mp = new TreeMap<>();
			String[] data = new String[V];
			for (int i = 0; i < V; i++) {
				data[i] = in.nextLine();
				mp.put(data[i], i);
			}

			adjMatrix = new boolean[V][V];
			int m = in.nextInt();
			ArrayList<String> ev = new ArrayList<>();
			while (m-- > 0) {
				String course = in.next();
				ev.add(course);
				int v = mp.get(course);
				int k = in.nextInt();
				while (k-- > 0) {
					int u = mp.get(in.next());
					adjMatrix[u][v] = true;
				}
			}
			boolean[][] graph = transitiveclosure();

			Collections.sort(ev);
			for (String s : ev) {
				ArrayList<String> as = new ArrayList<>();
				int u = mp.get(s);
				for (int i = 0; i < V; i++)
					if (graph[i][u])
						as.add(data[i]);
				Collections.sort(as);
				sb.append(s).append(" " + as.size());
				for (String k : as)
					sb.append(" ").append(k);
				sb.append("\n");
			}
		}
		System.out.print(sb);
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
