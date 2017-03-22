package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C708 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		char[] s = in.nextLine().toCharArray();
		int cnt = 0;
		boolean flag = false;
		for (int i = 0; i < s.length; i++)
			if (s[i] != 'a' && !flag) {
				s[i] = (char) (s[i] - 1);
				cnt++;
			} else if (cnt > 0)
				flag = true;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length; i++) {
			if (cnt == 0 && i == s.length - 1)
				break;
			sb.append(s[i]);
		}
		if (cnt == 0)
			sb.append("z");
		System.out.println(sb);
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
