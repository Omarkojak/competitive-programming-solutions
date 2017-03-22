package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D69 {
	static int n, d, vx[], vy[];
	static int dp[][][][];
	static final int offset = 200;

	public static int solve(int id, int x, int y, int msk) {
		if (x * x + y * y > d * d)
			return id;

		if (dp[id][msk][x + offset][y + offset] != -1)
			return dp[id][msk][x + offset][y + offset];

		int next = id ^ 1;
		if ((msk | (1 << id)) == 0) {
			int newy = y > x ? x - (y - x) : x + (x - y);
			next = solve(id ^ 1, x, newy, msk | (1 << id));
		}

		for (int i = 0; i < n && next != id; i++)
			next = solve(id ^ 1, x + vx[i], y + vy[i], msk);

		return dp[id][msk][x + offset][y + offset] = next;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		n = in.nextInt();
		d = in.nextInt();
		vx = new int[n];
		vy = new int[n];
		for (int i = 0; i < n; i++) {
			vx[i] = in.nextInt();
			vy[i] = in.nextInt();
		}
		dp = new int[2][4][405][405];
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 4; j++)
				for (int k = 0; k < 405; k++)
					Arrays.fill(dp[i][j][k], -1);

		System.out.println(solve(0, x, y, 0) == 0 ? "Anton" : "Dasha");
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
