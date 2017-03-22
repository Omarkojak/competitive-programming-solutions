package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B711 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[][] maze = new long[n][n];
		int x = -1, y = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				maze[i][j] = in.nextLong();
				if (maze[i][j] == 0)

				{
					x = i;
					y = j;
				}
			}
		}
		if (n == 1) {
			System.out.println(1);
			return;
		}

		long sumr = 0;
		long sumc = 0;
		long sumd1 = 0;
		long sumd2 = 0;

		for (int i = 0; i < n; i++) {
			if (i == x)
				continue;
			long s = 0;
			for (int j = 0; j < n; j++)
				s += maze[i][j];
			if (s != sumr && sumr != 0) {
				System.out.println(-1);
				return;
			}
			if (sumr == 0)
				sumr = s;
		}

		for (int i = 0; i < n; i++) {
			if (i == y)
				continue;
			long s = 0;
			for (int j = 0; j < n; j++)
				s += maze[j][i];
			if (s != sumc && sumc != 0) {
				System.out.println(-1);
				return;
			}
			if (sumc == 0)
				sumc = s;
		}

		if (sumr != sumc) {
			System.out.println(-1);
			return;
		}
		for (int i = 0; i < n; i++)
			sumd1 += maze[i][i];

		for (int i = 0; i < n; i++)
			sumd2 += maze[i][n - i - 1];

		long sumitsrow = 0;
		long sumitscol = 0;

		for (int i = 0; i < n; i++)
			sumitsrow += maze[x][i];

		for (int i = 0; i < n; i++)
			sumitscol += maze[i][y];

		if (x != y && y != n - x - 1) {

			long val = Math.abs(sumitsrow - sumr);
			if (val + sumitscol == sumc && sumr == sumd1 && sumr == sumd2
					&& val > 0)
				System.out.println(val);
			else
				System.out.println(-1);
			return;
		}

		if (x != y && y == n - x - 1) {
			long val = (long) Math.abs(sumitsrow - sumr);
			if (val + sumitscol == sumr && val + sumd2 == sumr && sumd1 == sumr
					&& sumd1 == sumc && val > 0)
				System.out.println(val);
			else
				System.out.println(-1);
			return;
		}
		if (x == y && y != n - x - 1) {
			long val = (long) Math.abs(sumitsrow - sumr);
			if (val + sumitscol == sumr && val + sumd1 == sumr && sumd2 == sumr
					&& sumd2 == sumc && val > 0)
				System.out.println(val);
			else
				System.out.println(-1);
			return;
		}

		long val = (long) Math.abs(sumitsrow - sumr);

		if (val + sumitscol == sumr && val + sumd2 == sumr
				&& val + sumd1 == sumr && sumd2 + val == sumd1 + val && val > 0)
			System.out.println(val);
		else
			System.out.println(-1);

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
