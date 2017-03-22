package OfficialContests.ECPC15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class K {
	static int s[], p, n;

	static long solve() {
		int last[] = new int[p];
		long cnt = 0l;
		for (int i = 0; i < n; i++) {
			int[] curr = new int[p];
			curr[s[i] % p]++;
			for (int mod = 0; mod < p; mod++) {
				curr[(mod * 10 + s[i]) % p] += last[mod];
			}
			cnt += curr[0];
			last = curr;
		}

		return cnt;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			long a = in.nextLong();
			long b = in.nextLong();
			n = in.nextInt();
			s = new int[n];
			// String inp = ((a * 1.0) / b) + "";
			BigDecimal ans = BigDecimal.valueOf(a * 1.0);
			ans = ans.divide(BigDecimal.valueOf(b));
			String inp = ans.toPlainString();
			// System.err.println(inp);
			boolean first = true;
			for (int i = 0, j = 0; i < inp.length() && j < n; i++) {
				if (inp.charAt(i) == '.' || (inp.charAt(i) == '0' && first))
					continue;
				first = false;
				s[j] = inp.charAt(i) - '0';
				j++;
			}
			p = in.nextInt();
			sb.append(solve()).append("\n");
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
