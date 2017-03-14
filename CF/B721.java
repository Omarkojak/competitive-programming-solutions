package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B721 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		int[] length = new int[150];
		for (int i = 0; i < n; i++)
			length[in.nextLine().length()]++;

		int mine = in.nextLine().length();
		long best = 0;
		int trials = 0;
		for (int i = 0; i < mine; i++) {
			while (length[i]-- > 0) {
				if (trials == k) {
					best += 5;
					trials = 0;
				}
				trials++;
				best++;
			}
		}
		long zeft = best;
		if (trials == k) {
			best += 5;
		}
		while (length[mine]-- > 1) {
			if (trials == k) {
				zeft += 5;
				trials = 0;
			}
			trials++;
			zeft++;
		}
		if(trials == k)
			zeft+=5;

		System.out.print((best + 1) + " " + (zeft + 1) );

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
