package cp4_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva1247_InterStarTransport {
	static int[][] adjMatrix;
	static int[][] p;
	static int V;
	static final int inf = (int) 1e9;
	static String k;

	static void floyd() {
		p = new int[V][V];
		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++)
				p[i][j] = i;

		for (int k = 0; k < V; k++)
			for (int i = 0; i < V; i++)
				for (int j = 0; j < V; j++)
					if (adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
						p[i][j] = p[k][j];
					}
	}

	static void printPath(int i, int j) {
		if (i != j)
			printPath(i, p[i][j]);
		char c = (char) ((int) 'A' + j);
		k += c + " ";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		while (s != null && s.length() != 0) {
			StringTokenizer ns = new StringTokenizer(s);
			V = Integer.parseInt(ns.nextToken());
			int m = Integer.parseInt(ns.nextToken());
			p = new int[V][V];
			adjMatrix = new int[V][V];
			for (int i = 0; i < V; i++) {
				Arrays.fill(adjMatrix[i], inf);
				adjMatrix[i][i] = 0;
			}

			while (m-- > 0) {
				ns = new StringTokenizer(bf.readLine());
				int u1 = (ns.nextToken().charAt(0)) - 'A';
				int u2 = (ns.nextToken().charAt(0)) - 'A';
				int cost = Integer.parseInt(ns.nextToken());
				adjMatrix[u1][u2] = Math.min(adjMatrix[u1][u2], cost);
				adjMatrix[u2][u1] = Math.min(adjMatrix[u2][u1], cost);

			}
			floyd();
			int q = Integer.parseInt(bf.readLine());
			while (q-- > 0) {
				ns = new StringTokenizer(bf.readLine());
				int i = ns.nextToken().charAt(0) - 'A';
				int j = ns.nextToken().charAt(0) - 'A';
				k = "";
				printPath(i, j);
				k = k.substring(0, k.length() - 1);
				System.out.println(k);
			}

			s = bf.readLine();
		}
	}

}
