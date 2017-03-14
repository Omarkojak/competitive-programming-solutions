package OfficialContests.Syria15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class J {
	static int N, K;
	static ArrayList<Integer>[] adjList;
	static boolean vis[];
	static ArrayList<Integer> output;

	static void dfs(int u) {
		if (vis[u])
			return;
		vis[u] = true;
		output.add(u);
		for (int v : adjList[u])
			if (!vis[v])
				dfs(v);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			N = in.nextInt();
			K = in.nextInt();
			TreeMap<String, Integer> topics = new TreeMap<>();
			String[] arr = new String[N];
			int idx = 0;
			adjList = new ArrayList[N];
			for (int i = 0; i < N; i++)
				adjList[i] = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				String s = in.next();
				int u = -1;
				if (topics.containsKey(s))
					u = topics.get(s);
				else {
					topics.put(s, idx);
					arr[idx] = s;
					u = idx;
					idx++;
				}
				int m = in.nextInt();
				while (m-- > 0) {
					int v = topics.get(in.next());
					adjList[u].add(v);
				}
			}
			output = new ArrayList<Integer>();
			vis = new boolean[N];
			while (K--> 0) {
				dfs(topics.get(in.next()));
			}
			Collections.sort(output);
			for(int u:output)
				sb.append(arr[u]).append("\n");

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

	}
}
