package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A675 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		long a = in.nextLong();
		long b = in.nextLong();
		long c = in.nextLong();
		if (c == 0) {
			if (b == a)
				System.out.println("YES");
			else
				System.out.println("NO");
			return;
		}
		if (c > 0) {
			if (b < a)
				System.out.println("NO");
			else if ((b - a) % c == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
			return;
		}
		if (c < 0) {
			if (b > a)
				System.out.println("NO");
			else if ((a - b) % c == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
			return;
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
	}
}
