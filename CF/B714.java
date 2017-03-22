package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B714 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		TreeSet<Long> ts = new TreeSet<>();
		while (n-- > 0)
			ts.add(in.nextLong());
		if (ts.size() > 3) {
			System.out.println("NO");
			return;
		}
		boolean flag = true;
		if (ts.size() == 3) {
			long a1 = ts.pollFirst();
			long a2 = ts.pollFirst();
			long a3 = ts.pollFirst();
			if (a2 - a1 != a3 - a2)
				flag = false;
		}
		System.out.println(flag ? "YES" : "NO");
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
