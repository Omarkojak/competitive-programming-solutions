package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B400 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		TreeSet<Integer> ts = new TreeSet<>();
		boolean valid = true;
		for (int i = 0; i < n; i++) {
			char[] s = in.nextLine().toCharArray();
			int posg = -1, poss = -1;
			for (int j = 0; j < m; j++) {
				if (s[j] == 'G')
					posg = j;
				if (s[j] == 'S')
					poss = j;
			}
			if (poss < posg)
				valid = false;
			ts.add(poss - posg);
		}
		if (valid)
			System.out.println(ts.size());
		else
			System.out.println(-1);

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
