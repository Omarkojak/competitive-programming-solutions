package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Uva208_FireTruck {
	static ArrayList<Integer>[] adjList;
	static int dist, routes;
	static ArrayList<Stringmod> paths;
	static boolean vis[], reachable[];

	static void dfs(int k, String s) {
		if (!reachable[k])
			return;
		if (k == dist) {
			routes++;
			paths.add(new Stringmod(s));
		}
		vis[k] = true;

		for (int v : adjList[k]) {
			if (!vis[v]) {
				String space = "";
				if (v != dist)
					space = " ";
				dfs(v, s + (v + 1) + space);
			}
		}

		vis[k] = false;
	}

	static void reach(int u) {
		reachable[u] = true;
		for (int v : adjList[u])
			if (!reachable[v])
				reach(v);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int cse = 1;
		while (s != null && s.length() != 0) {
			dist = Integer.parseInt(s) - 1;
			adjList = new ArrayList[25];
			for (int i = 0; i < 25; i++)
				adjList[i] = new ArrayList<Integer>();

			s = bf.readLine();
			while (!s.equals("0 0")) {
				StringTokenizer ns = new StringTokenizer(s);
				int u1 = Integer.parseInt(ns.nextToken());
				int u2 = Integer.parseInt(ns.nextToken());

				adjList[u1 - 1].add(u2 - 1);
				adjList[u2 - 1].add(u1 - 1);

				s = bf.readLine();
			}
			vis = new boolean[25];
			reachable = new boolean[25];
			routes = 0;
			paths = new ArrayList<Stringmod>();
			System.out.printf("CASE %d:\n", cse++);
			reach(dist);
			dfs(0, "1 ");
			Collections.sort(paths);
			for (Stringmod out : paths)
				System.out.println(out.s);

			System.out
					.printf("There are %d routes from the firestation to streetcorner %d.\n",
							routes, dist + 1);

			s = bf.readLine();
		}
	}

	static class Stringmod implements Comparable<Stringmod> {
		String s;

		Stringmod(String a) {
			s = a;
		}

		public int compareTo(Stringmod o) {
			StringTokenizer ns1 = new StringTokenizer(s);
			StringTokenizer ns2 = new StringTokenizer(o.s);
			while (ns1.hasMoreTokens() && ns2.hasMoreTokens()) {
				int n1 = Integer.parseInt(ns1.nextToken());
				int n2 = Integer.parseInt(ns2.nextToken());
				if (n1 < n2)
					return -1;
				if (n2 < n1)
					return 1;
			}
			return 0;
		}
	}

}
