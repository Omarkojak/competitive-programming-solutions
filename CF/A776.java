package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A776 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String s1 = in.next();
		String s2 = in.next();
		sb.append(s1 + " ").append(s2).append("\n");
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			String k1 = in.next();
			String k2 = in.next();
			if (k1.equals(s1))
				s1 = k2;
			else
				s2 = k2;
			sb.append(s1 + " ").append(s2).append("\n");
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
