package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B621 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long diff[] = new long[2005];
		long sum[] = new long[2005];
		while (n-- > 0) {
			int x = in.nextInt();
			int y = in.nextInt();
			diff[x - y + 1000]++;
			sum[x + y]++;
		}
		long ans = 0;
		for (int i = 0; i < 2005; i++) {
			ans += (diff[i] * (diff[i] - 1)) / 2;
			ans += (sum[i] * (sum[i] - 1)) / 2;
		}
		System.out.println(ans);
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
