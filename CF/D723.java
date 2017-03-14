package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D723 {
	static char[][] grid;
	static boolean[][] ocean;
	static int col, cnt[], floodfill[][];
	static int n, m;

	static void dfs(int i, int j) {
		floodfill[i][j] = col;
		cnt[col]++;
		if (valid(i + 1, j))
			dfs(i + 1, j);

		if (valid(i - 1, j))
			dfs(i - 1, j);

		if (valid(i, j + 1))
			dfs(i, j + 1);

		if (valid(i, j - 1))
			dfs(i, j - 1);

	}

	static boolean valid(int i, int j) {
		return i >= 0 && i < n && j >= 0 && j < m && floodfill[i][j] == -1
				&& grid[i][j] == '.';
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		int k = in.nextInt();
		grid = new char[n][];
		for (int i = 0; i < n; i++) {
			grid[i] = in.nextLine().toCharArray();
		}

		cnt = new int[5001];
		floodfill = new int[n][m];
		for (int i = 0; i < n; i++)
			Arrays.fill(floodfill[i], -1);

		col = 5000;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (i == 0 || j == 0 || i == n - 1 || j == m - 1)
					if (floodfill[i][j] == -1 && grid[i][j] == '.') {
						dfs(i, j);
					}

		PriorityQueue<Integer> pq = new PriorityQueue<>(
				new Comparator<Integer>() {
					public int compare(Integer o1, Integer o2) {
						return Integer.compare(cnt[o1], cnt[o2]);
					}
				});
		col = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (floodfill[i][j] == -1 && grid[i][j] == '.') {
					dfs(i, j);
					pq.add(col);
					col++;
				}
		boolean[] remove = new boolean[5005];
		while (col > k) {
			remove[pq.poll()] = true;
			col--;
		}

		int res = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (floodfill[i][j] != -1 && remove[floodfill[i][j]]) {
					grid[i][j] = '*';
					res++;
				}
				sb.append(grid[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(res);
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
