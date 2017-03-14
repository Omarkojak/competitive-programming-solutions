package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A377 {
	static int n, m;
	static char[][] grid;
	static int cnt;
	static boolean vis[][];

	public static void dfs(int i, int j)
	{
		if(cnt == 0)
			return;

		vis[i][j] = true;
		cnt--;

		if(valid(i+1, j))
			dfs(i+1, j);
		
		if(valid(i-1, j))
			dfs(i-1, j);
		
		if(valid(i, j+1))
			dfs(i, j+1);
		
		if(valid(i, j-1))
			dfs(i, j-1);

	}
	
	static boolean valid(int i, int j) {
		return i >= 0 && i < n && j >= 0 && j < m && grid[i][j] != '#' && !vis[i][j];
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		int blocked = in.nextInt();
		grid = new char[n][m];
		int x = -1, y = -1;
		int dots = 0;
		for (int i = 0; i < n; i++) {
			String s = in.nextLine();
			for (int j = 0; j < m; j++) {
				grid[i][j] = s.charAt(j);
				if (grid[i][j] == '.') {
					dots++;
					if (x == -1) {
						x = i;
						y = j;
					}
				}
			}
		}

		cnt = dots- blocked;
		vis = new boolean [n][m];
		dfs(x, y);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!vis[i][j] && grid[i][j] == '.') {
					sb.append("X");
				} else
					sb.append(grid[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);

	}

	static class Pair implements Comparable<Pair> {
		int i, j;

		Pair(int x, int y) {
			i = x;
			j = y;
		}

		@Override
		public int compareTo(Pair o) {
			if (i != o.i)
				return i - o.i;
			return j - o.j;
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
