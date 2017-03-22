package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Uva10419_SumUpThePrimes {
	static ArrayList<Integer> primes;
	static int size;
	static Boolean dp[][][];
	static StringBuilder sb;

	public static boolean solve(int t, int idx, int n) {
		if (n == 0)
			return t == 0;
		if (idx == size || t == 0)
			return false;

		if (dp[t][idx][n] != null)
			return dp[t][idx][n];

		boolean res = solve(t, idx + 1, n);
		int prime = primes.get(idx);

		if (prime <= n) {
			res |= solve(t - 1, idx + 1, n - prime);
			if (prime != 2 && t > 1 && prime * 2 <= n)
				res |= solve(t - 2, idx + 1, n - prime * 2);
		}

		return dp[t][idx][n] = res;
	}

	public static void print(int t, int idx, int n) {
		if (n == 0)
			return;

		int prime = primes.get(idx);
		if (prime != 2 && t > 1 && prime * 2 <= n
				&& solve(t - 2, idx + 1, n - prime * 2)) {
			if (sb.length() != 0)
				sb.append("+");
			sb.append(prime + "+" + prime);
			print(t - 2, idx + 1, n - primes.get(idx) * 2);
			return;
		}
		if (prime <= n && solve(t - 1, idx + 1, n - prime)) {
			if (sb.length() != 0)
				sb.append("+");
			sb.append(prime);
			print(t - 1, idx + 1, n - prime);
			return;
		}

		print(t, idx + 1, n);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cse = 1;
		primes = new ArrayList<>();
		for (int i = 2; i < 300; i++)
			if (prime(i))
				primes.add(i);
		Collections.sort(primes, new Sorter());
		size = primes.size();
		dp = new Boolean[15][size + 5][1005];
		while (true) {
			int n = in.nextInt();
			int t = in.nextInt();
			if (n == 0 && t == 0)
				break;
			// System.out.println(solve(t,0,n));
			boolean res = solve(t, 0, n);
			out.printf("CASE %d:\n", cse++);
			if (!res) {
				out.println("No Solution.");
				continue;
			}
			sb = new StringBuilder();
			print(t, 0, n);
			out.println(sb);
		}
		out.flush();
		out.close();
	}

	static boolean prime(int x) {
		for (int z = 2; z < x; z++)
			if (x % z == 0)
				return false;
		return true;
	}

	static class Sorter implements Comparator<Integer> {
		public int compare(Integer o1, Integer o2) {
			return o1.toString().compareTo(o2.toString());
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
