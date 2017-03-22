package cp9_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVa1121_Subsequence {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (in.br.ready()) {
			int n = in.nextInt();
			long S = in.nextLong();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = in.nextInt();
			int minimal = (int) 1e9;
			long sum = 0l;
			for (int l = 0, r = 0; l < n;l++) {
				if (l > r)
					r++;
				while (r < n) {
					if (sum + arr[r] >= S)
						break;
					sum += arr[r];
					r++;
				}
				if (r != n)
					if (sum + arr[r] >= S)
						minimal = Math.min(minimal, r - l + 1);
				if (sum >= S)
					minimal = Math.min(minimal, r - l + 1);
				sum-=arr[l];
			}
			if(minimal == (int) 1e9)
				minimal = 0;
			sb.append(minimal).append("\n");

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
