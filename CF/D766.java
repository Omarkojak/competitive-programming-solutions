package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class D766 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		int m = in.nextInt();
		int q = in.nextInt();
		TreeMap<String, Integer> mp = new TreeMap<>();
		for (int i = 0; i < n; i++)
			mp.put(in.next(), i);

		UnionFind uf = new UnionFind(n);
		while (m-- > 0) {
			int t = in.nextInt();
			int w1 = uf.findSet(mp.get(in.next()));
			int w2 = uf.findSet(mp.get(in.next()));
			if (t == 1) {
				if (uf.opp[w1] == w2 || uf.opp[w2] == w1) {
					sb.append("NO\n");
					continue;
				}
				sb.append("YES\n");
				uf.unionSet(w1, w2);
				if (uf.opp[w1] != -1 && uf.opp[w2] != -1) {
					uf.unionSet(uf.opp[w1], uf.opp[w2]);
					uf.opp[uf.findSet(uf.opp[w1])] = uf.findSet(w1);
					continue;
				}

				if (uf.opp[w1] != -1) {
					uf.opp[w1] = uf.opp[w2] = uf.findSet(uf.opp[w1]);
					uf.opp[uf.opp[w1]] = uf.findSet(w1);
					continue;
				}
				if (uf.opp[w2] != -1) {
					uf.opp[w1] = uf.opp[w2] = uf.findSet(uf.opp[w2]);
					uf.opp[uf.opp[w1]] = uf.findSet(w1);
				}
				continue;
			}

			if (t == 2) {
				if (uf.isSameSet(w1, w2)) {
					sb.append("NO\n");
					continue;
				}
				sb.append("YES\n");
				if (uf.opp[w1] != -1)
					uf.unionSet(uf.opp[w1], w2);
				if (uf.opp[w2] != -1)
					uf.unionSet(uf.opp[w2], w1);
				w1 = uf.findSet(w1);
				w2 = uf.findSet(w2);
				uf.opp[w1] = w2;
				uf.opp[w2] = w1;
				continue;
			}
		}

		while (q-- > 0) {
			int w1 = uf.findSet(mp.get(in.next()));
			int w2 = uf.findSet(mp.get(in.next()));
			if (uf.isSameSet(w1, w2))
				sb.append("1\n");
			else {
				if (uf.opp[w1] != -1 && uf.opp[w2] != -1) {
					if(uf.isSameSet(w1, uf.opp[w2]) || uf.isSameSet(w2, uf.opp[w1]))
						sb.append("2\n");
					else
						sb.append("3\n");
				}else
					sb.append("3\n");
			}
		}
		System.out.print(sb);

	}

	static class UnionFind {
		int[] p, rank, setSize;
		int numSets;
		int[] opp;

		public UnionFind(int N) {
			p = new int[numSets = N];
			rank = new int[N];
			setSize = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
				setSize[i] = 1;
			}
			opp = new int[N];
			Arrays.fill(opp, -1);
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
