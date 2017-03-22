package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Uva711_DividingUp {
	static int arr[];
	static Boolean[][] dp;

	static boolean solve(int idx, int sum) {
		if (idx == 7)
			return sum == 0;

		if (dp[idx][sum] != null)
			return dp[idx][sum];
		boolean res = false;
		for (int i = 0; i <= arr[idx]; i++) {
			if (res || sum - i * idx < 0)
				break;
			res |= solve(idx + 1, sum - i * idx);
		}
		return dp[idx][sum] = res;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cse = 1;
		while (true) {
			arr = new int[7];
			int sum = 0;
			for (int i = 1; i < 7; i++) {
				arr[i] = in.nextInt();
				sum += arr[i] * i;
			}
			if (sum == 0)
				break;

			out.printf("Collection #%d:\n", cse++);
			if (sum % 2 != 0)
				out.println("Can't be divided.");
			else {
				sum >>= 1;
				dp = new Boolean[7][sum + 5];
				out.println(solve(1, sum) ? "Can be divided."
						: "Can't be divided.");
			}
			out.println();
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
	}
}
