package OfficialContests.HIAST16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class I {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			char[] s1 = in.nextLine().toCharArray();
			char[] s2 = in.nextLine().toCharArray();

			int[] cnt1 = new int[26];
			int[] cnt2 = new int[26];

			for (int i = 0; i < s1.length; i++)
				cnt1[s1[i] - 'a']++;

			for (int i = 0; i < s2.length; i++)
				cnt2[s2[i] - 'a']++;

			long cnt = 0;
			for (int i = 0; i < 26; i++)
				cnt += Math.abs(cnt1[i] - cnt2[i]);
			sb.append(cnt).append("\n");
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
