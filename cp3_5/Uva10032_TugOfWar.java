package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva10032_TugOfWar {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int[] arr = new int[n];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
				sum += arr[i];
			}
			int[] people = new int[450 * 100 + 5];
			people[0] = 1;
			for (int i = 0; i < n; i++)
				for (int j = sum; j >= 0; j--)
					if (people[j] != 0)
						people[j + arr[i]] |= people[j] << 1;

			int minimal = (int) 1e9;
			int min = -1;
			int max = -1;
			for (int i = 0; i <= sum; i++) {
				if ((people[i] & (1l << (n / 2))) != 0) {
					int diff = Math.abs(sum - i - i);
					if (diff < minimal) {
						minimal = diff;
						min = Math.min(i, sum - i);
						max = Math.max(i, sum - i);
					}
				}
			}
			sb.append(min + " " + max).append("\n");

			if (t != 0)
				sb.append("\n");
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
