package OfficialContests.Syria15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {
	static int[] res;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			int k = in.nextInt();
			String s = in.next();
			res = new int[1005];

			Arrays.fill(res, -1);
			conv(s);
			add(k);
			out();
		}
		System.out.print(sb);
	}

	static void conv(String s) {
		for (int i = s.length() - 1; i >= 0; i--) {
			switch (s.charAt(i)) {
			case 'A':
				res[s.length() - 1 - i] = 0;
				break;
			case 'H':
				res[s.length() - 1 - i] = 1;
				break;
			case 'I':
				res[s.length() - 1 - i] = 2;
				break;
			case 'M':
				res[s.length() - 1 - i] = 3;
				break;
			case 'O':
				res[s.length() - 1 - i] = 4;
				break;
			case 'T':
				res[s.length() - 1 - i] = 5;
				break;
			case 'U':
				res[s.length() - 1 - i] = 6;
				break;
			case 'V':
				res[s.length() - 1 - i] = 7;
				break;
			case 'W':
				res[s.length() - 1 - i] = 8;
				break;
			case 'X':
				res[s.length() - 1 - i] = 9;
				break;
			case 'Y':
				res[s.length() - 1 - i] = 10;
				break;
			}
		}
	}

	static void add(int K) {
		for (int i = 0; K > 0; i++) {
			res[i] = (res[i] + K);

			K = res[i] / 11;

			res[i] %= 11;
		}
	}

	static void out() {
		StringBuilder app = new StringBuilder();
		int start;
		for (start = 0; res[start] == -1; start++)
			;

		for (; start < 1005; start++) {
			switch (res[start]) {
			case 0:
				app.append('A');
				break;
			case 1:
				app.append('H');
				break;
			case 2:
				app.append('I');
				break;
			case 3:
				app.append('M');
				break;
			case 4:
				app.append('O');
				break;
			case 5:
				app.append('T');
				break;
			case 6:
				app.append('U');
				break;
			case 7:
				app.append('V');
				break;
			case 8:
				app.append('W');
				break;
			case 9:
				app.append('X');
				break;
			case 10:
				app.append('Y');
				break;
			}
		}
		app = app.reverse();
		sb.append(app);
		sb.append("\n");
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
