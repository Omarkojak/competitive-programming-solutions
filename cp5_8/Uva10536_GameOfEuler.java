package cp5_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva10536_GameOfEuler {
	static int[][] win;

	public static int solve(int id, int msk) {
		if (Integer.bitCount(msk) == 15)
			return id ^ 1;

		if (win[id][msk] != -1)
			return win[id][msk];

		int next = id ^ 1;
		boolean[][] biton = new boolean[4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				biton[i][j] = (msk & (1 << conv(i, j))) == 0 ? false : true;
				if (!biton[i][j])
					next = solve(id ^ 1, msk | (1 << conv(i, j)));
				if (next == id)
					return win[id][msk] = id;
			}

		for (int i = 0; i < 4; i++) {
			if (!biton[i][0]) {
				next = solve(id ^ 1, msk | (1 << conv(i, 0)));
				if (next == id)
					return win[id][msk] = id;
				if (!biton[i][1]) {
					next = solve(id ^ 1,
							msk | (1 << conv(i, 0) | (1 << conv(i, 1))));
					if (next == id)
						return win[id][msk] = id;
					if (!biton[i][2])
						next = solve(
								id ^ 1,
								msk
										| (1 << conv(i, 0) | (1 << conv(i, 1) | (1 << conv(
												i, 2)))));
					if (next == id)
						return win[id][msk] = id;
				}
			}

			if (!biton[i][3]) {
				next = solve(id ^ 1, msk | (1 << conv(i, 3)));
				if (next == id)
					return win[id][msk] = id;
				if (!biton[i][2]) {
					next = solve(id ^ 1,
							msk | (1 << conv(i, 3) | (1 << conv(i, 2))));
					if (next == id)
						return win[id][msk] = id;
					if (!biton[i][1])
						next = solve(
								id ^ 1,
								msk
										| (1 << conv(i, 3) | (1 << conv(i, 2) | (1 << conv(
												i, 1)))));
					if (next == id)
						return win[id][msk] = id;
				}
			}

		}

		for (int j = 0; j < 4; j++) {
			if (!biton[0][j]) {
				next = solve(id ^ 1, msk | (1 << conv(0, j)));
				if (next == id)
					return win[id][msk] = id;
				if (!biton[1][j]) {
					next = solve(id ^ 1,
							msk | (1 << conv(0, j) | (1 << conv(1, j))));
					if (next == id)
						return win[id][msk] = id;
					if (!biton[2][j])
						next = solve(
								id ^ 1,
								msk
										| (1 << conv(0, j) | (1 << conv(1, j) | (1 << conv(
												2, j)))));
					if (next == id)
						return win[id][msk] = id;
				}
			}

			if (!biton[3][j]) {
				next = solve(id ^ 1, msk | (1 << conv(3, j)));
				if (next == id)
					return win[id][msk] = id;
				if (!biton[2][j]) {
					next = solve(id ^ 1,
							msk | (1 << conv(3, j) | (1 << conv(2, j))));
					if (next == id)
						return win[id][msk] = id;
					if (!biton[1][j])
						next = solve(
								id ^ 1,
								msk
										| (1 << conv(3, j) | (1 << conv(2, j) | (1 << conv(
												1, j)))));
					if (next == id)
						return win[id][msk] = id;
				}
			}

		}
		return win[id][msk] = next;

	}

	public static int conv(int i, int j) {
		return i * 4 + j;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		boolean first = true;
		win = new int[2][(1 << 16) + 5];
		Arrays.fill(win[0], -1);
		Arrays.fill(win[1], -1);
		while (t-- > 0) {
			if (first)
				in.nextLine();
			int msk = 0;
			first = false;
			for (int i = 0; i < 4; i++) {
				char[] s = in.nextLine().toCharArray();
				for (int j = 0; j < 4; j++)
					if (s[j] == 'X')
						msk |= (1 << conv(i, j));
			}

			sb.append(solve(0, msk) == 0 ? "WINNING\n" : "LOSING\n");
			in.nextLine();
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
