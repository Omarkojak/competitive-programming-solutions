package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva11125_ArrangeSomeMarbles {
	static int dp[][][][][][][][];

	public static int solve(int first, int sizef, int last, int sizel, int a1,
			int a2, int a3, int a4) {
		if (a1 == 0 && a2 == 0 && a3 == 0 && a4 == 0) {
			return (first != last && sizef != sizel) ? 1 : 0;
		}

		if (dp[first][sizef][last][sizel][a1][a2][a3][a4] != -1)
			return dp[first][sizef][last][sizel][a1][a2][a3][a4];
		int cnt = 0;
		if (last != 0)
			for (int i = 1; i <= 3; i++)
				if (a1 >= i && i != sizel)
					cnt += solve(first, sizef, 0, i, a1 - i, a2, a3, a4);

		if (last != 1)
			for (int i = 1; i <= 3; i++)
				if (a2 >= i && i != sizel)
					cnt += solve(first, sizef, 1, i, a1, a2 - i, a3, a4);

		if (last != 2)
			for (int i = 1; i <= 3; i++)
				if (a3 >= i && i != sizel)
					cnt += solve(first, sizef, 2, i, a1, a2, a3 - i, a4);

		if (last != 3)
			for (int i = 1; i <= 3; i++)
				if (a4 >= i && i != sizel)
					cnt += solve(first, sizef, 3, i, a1, a2, a3, a4 - i);

		return dp[first][sizef][last][sizel][a1][a2][a3][a4] = cnt;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		dp = new int[4][4][4][4][8][8][8][8];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				for (int k = 0; k < 4; k++)
					for (int r = 0; r < 4; r++)
						for (int x = 0; x < 8; x++)
							for (int y = 0; y < 8; y++)
								for (int z = 0; z < 8; z++)
									for (int w = 0; w < 8; w++)
										dp[i][j][k][r][x][y][z][w] = -1;

		while (t-- > 0) {
			int n = in.nextInt();
			int arr[] = new int[4];
			for (int i = 0; i < n; i++)
				arr[i] = in.nextInt();

			int cnt = 0;
			int ntequalzero = 0;
			int sum = 0;
			for (int i = 0; i < n; i++)
				if (arr[i] != 0) {
					ntequalzero++;
					sum += arr[i];
				}
			if (ntequalzero <= 1 && sum <= 3)
				cnt++;

			for (int j = 1; j <= 3; j++) {
				if (j > arr[0])
					break;
				cnt += solve(0, j, 0, j, arr[0] - j, arr[1], arr[2], arr[3]);
			}
			for (int j = 1; j <= 3; j++) {
				if (j > arr[1])
					break;
				cnt += solve(1, j, 1, j, arr[0], arr[1] - j, arr[2], arr[3]);
			}
			for (int j = 1; j <= 3; j++) {
				if (j > arr[2])
					break;
				cnt += solve(2, j, 2, j, arr[0], arr[1], arr[2] - j, arr[3]);
			}
			for (int j = 1; j <= 3; j++) {
				if (j > arr[3])
					break;
				cnt += solve(3, j, 3, j, arr[0], arr[1], arr[2], arr[3] - j);
			}
			sb.append(cnt).append("\n");
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
