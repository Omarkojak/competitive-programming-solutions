package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class C731 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		in.nextInt();
		int color[] = new int[n];
		for (int i = 0; i < n; i++)
			color[i] = in.nextInt();
		UnionFind uf = new UnionFind(n);
		while (m-- > 0)
			uf.unionSet(in.nextInt() - 1, in.nextInt() - 1);

		ArrayList<Integer>[] sets = new ArrayList[n];
		for (int i = 0; i < n; i++)
			sets[i] = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			sets[uf.findSet(i)].add(i);
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (sets[i].size() == 0)
				continue;
			TreeMap<Integer, Integer> cnt = new TreeMap<>();
			for (int u : sets[i]) {
				int c = 0;
				if (cnt.containsKey(color[u]))
					c = cnt.get(color[u]);
				cnt.put(color[u], c + 1);
			}
			int max = 0;
			for (Entry<Integer, Integer> e : cnt.entrySet())
				max = Math.max(max, e.getValue());
			ans += sets[i].size() - max;
		}
		System.out.println(ans);
	}

	static class UnionFind {
		int[] p, rank, setSize;
		int numSets;

		public UnionFind(int N) {
			p = new int[numSets = N];
			rank = new int[N];
			setSize = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
				setSize[i] = 1;
			}
		}

		public int findSet(int i) {
			return p[i] == i ? i : (p[i] = findSet(p[i]));
		}

		public boolean isSameSet(int i, int j) {
			return findSet(i) == findSet(j);
		}

		public void unionSet(int i, int j) {
			if (isSameSet(i, j))
				return;
			numSets--;
			int x = findSet(i), y = findSet(j);
			if (rank[x] > rank[y]) {
				p[y] = x;
				setSize[x] += setSize[y];
			} else {
				p[x] = y;
				setSize[y] += setSize[x];
				if (rank[x] == rank[y])
					rank[y]++;
			}
		}

		public int numDisjointSets() {
			return numSets;
		}

		public int sizeOfSet(int i) {
			return setSize[findSet(i)];
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
