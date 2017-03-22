package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Uva11060_Beverages {
	static int[][] adjMatrix;
	static int n;
	static int[] parent;
	static ArrayList<Integer> as;

	public static void Khan() {

		PriorityQueue<Integer> roots = new PriorityQueue<Integer>();
		for (int i = 0; i < n; i++)
			if (parent[i] == 0)
				roots.add(i);

		while (!roots.isEmpty()) {
			int curr = roots.remove();
			as.add(curr);
			for (int i = 0; i < n; i++) {
				if (adjMatrix[curr][i] == 1) {
					parent[i]--;
					if (parent[i] == 0)
						roots.add(i);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int r = 1;
		String s = bf.readLine();
		while (s != null && s.length() != 0) {
			n = Integer.parseInt(s);
			int ind = 0;
			TreeMap<String, Integer> mp = new TreeMap<String, Integer>();

			String[] a = new String[n];
			while (ind < n) {
				s = bf.readLine();
				mp.put(s, ind);
				a[ind++] = s;
			}
			adjMatrix = new int[n][n];
			parent = new int[n];
			as = new ArrayList<Integer>();
			int m = Integer.parseInt(bf.readLine());
			while (m-- > 0) {
				StringTokenizer ns = new StringTokenizer(bf.readLine());
				int u1 = mp.get(ns.nextToken());
				int u2 = mp.get(ns.nextToken());
				if (u1 == u2 | adjMatrix[u1][u2] == 1)
					continue;
				adjMatrix[u1][u2] = 1;
				parent[u2]++;
			}
			Khan();
			String res = a[as.get(0)];
			for (int i = 1; i < as.size(); i++)
				res += " " + a[as.get(i)];

			System.out
					.printf("Case #%d: Dilbert should drink beverages in this order: %s.\n", r++, res);
			s = bf.readLine();
			if (s != null) {
				s = bf.readLine();
			}
			System.out.println();

		}
	}

}
