package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C725 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		char[] s = in.nextLine().toCharArray();
		int[] cnt = new int[26];
		int[] pos = new int[26];
		int p1 = 0, p2 = 0;
		char x = ' ';
		for (int i = 0; i < s.length; i++) {
			cnt[s[i] - 'A']++;
			if (cnt[s[i] - 'A'] == 2) {
				p1 = pos[s[i] - 'A'];
				p2 = i;
				x = s[i];
			}
			pos[s[i] - 'A'] = i;
		}
		if (p2 - p1 == 1) {
			System.out.println("Impossible");
			return;
		}
		char[][] res = new char[2][13];
		int start = 12 - ((p2 - p1 - 1) / 2);
		res[0][start] = x;
		for (int j = p1 - 1, r = 0, col = start - 1; j >= 0; j--) {
			if (col == -1) {
				col = 0;
				r = 1;
			}
			if (col == 13) {
				col = 12;
				r = 0;
			}
			res[r][col] = s[j];
			if (r == 0)
				col--;
			else
				col++;
		}

		for (int j = p1 + 1, row = 0, col = start + 1; j < s.length; j++) {
			if (col == 13) {
				col = 12;
				row = 1;
			}
			if (col == -1) {
				col = 0;
				row = 0;
			}
			if(j == p2)
				continue;
			res[row][col] = s[j];
			if (row == 0)
				col++;
			else
				col--;

		}
		System.out.println(new String(res[0]));
		System.out.println(new String(res[1]));

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