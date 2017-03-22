package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A707 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			StringTokenizer ns = new StringTokenizer(in.nextLine());
			for (int j = 0; j < m; j++) {
				char c = ns.nextToken().charAt(0);
				if (c != 'W' && c != 'G' && c != 'B')
					flag = false;
			}
		}
		if (flag)
			System.out.println("#Black&White");
		else
			System.out.println("#Color");
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
