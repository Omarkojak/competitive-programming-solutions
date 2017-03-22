package OfficialContests.feglaqualf1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Fegalqualf1_D_Queue {

	public static boolean nextPermutation(int[] a) {
		int n = a.length;
		int i = n - 1;
		while (i > 0 && a[i - 1] >= a[i])
			i--;
		if (i <= 0)
			return false;

		int j = n - 1;
		while (a[j] <= a[i - 1])
			j--;

		int temp = a[j];
		a[j] = a[i - 1];
		a[i - 1] = temp;
		j = n - 1;
		while (i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int[][] hate = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					hate[i][j] = in.nextInt();

			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = i;

			int kick = n - 1;
			do {
				int sum = 0;
				for (int i = 0; i < n - 1; i++) {
					if (hate[a[i]][a[i + 1]] == 0)
						sum++;
					if (sum > kick)
						break;
				}
				kick = Math.min(kick, sum);
				if (kick == 0)
					break;
			} while (nextPermutation(a));

			out.println(kick);
		}
		out.flush();
		out.close();
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

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
