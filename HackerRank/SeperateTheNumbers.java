package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SeperateTheNumbers {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int q = in.nextInt();
		while (q-- > 0) {
			char[] s = in.nextLine().toCharArray();
			int n = s.length;
			long ans = -1;
			boolean f = false;
			for (int i = 1; i < n; i++) {
				long base = 0;
				for (int j = 0; j < i; j++)
					base = base * 10 + s[j] - '0';
				ans = base;
				int start = i;
				long num = 0;
				while (start < n) {
					if (s[start] - '0' == 0 && num == 0)
						break;
					num = num * 10 + s[start] - '0';
					start++;
					if (num == base + 1) {
						num = 0;
						base++;
						if (start == n)
							f = true;
					}

				}
				if (f)
					break;
			}
			if (f && s[0] - '0' != 0)
				sb.append("YES ").append(ans).append("\n");
			else
				sb.append("NO\n");

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
