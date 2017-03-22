package OfficialContests.Amman16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class I {
	static int r, c;
	static String s1, s2;

	static int calc1(int x) {
		int cnt = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == '^')
				x++;
			else
				x--;
			if (x < 1) {
				x = 1;
				cnt++;
			}
			if (x > r) {
				x = r;
				cnt++;
			}
		}
		return cnt;
	}

	static int calc2(int y) {
		int cnt = 0;
		for (int i = 0; i < s2.length(); i++) {
			if (s2.charAt(i) == '>')
				y++;
			else
				y--;
			if (y < 1) {
				y = 1;
				cnt++;
			}
			if (y > c) {
				y = c;
				cnt++;
			}

		}
		return cnt;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			r = in.nextInt();
			c = in.nextInt();

			String s = in.next();
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			int len = s.length();
			for (int i = 0; i < len; i++) {
				char c = s.charAt(i);
				if (c == '^' || c == 'v')
					sb1.append(c);
				else
					sb2.append(c);
			}
			s1 = sb1.toString();
			s2 = sb2.toString();

			int low1 = 1, high1 = r, res1 = Integer.MAX_VALUE;
			while (high1 - low1 > 3) {
				int d = (high1 - low1) / 3;
				int f1 = calc1(low1 + d);
				int f2 = calc1(high1 - d);
				if (f1 > f2)
					low1 = low1 + d;
				else if (f1 < f2)
					high1 = high1 - d;
				else {
					low1 = low1 + d;
					high1 = high1 - d;
				}
			}
			for (int i = low1; i <= high1; i++)
				res1 = Math.min(res1, calc1(i));

			int low2 = 1, high2 = c, res2 = Integer.MAX_VALUE;
			while (high2 - low2 > 3) {
				int d = (high2 - low2) / 3;
				int f1 = calc2(low2 + d);
				int f2 = calc2(high2 - d);
				if (f1 > f2)
					low2 = low2 + d;
				else if (f1 < f2)
					high2 = high2 - d;
				else {
					low2 = low2 + d;
					high2 = high2 - d;
				}
			}
			for (int i = low2; i <= high2; i++)
				res2 = Math.min(res2, calc2(i));

			sb.append(res1 + res2).append("\n");

		}
		System.out.print(sb);

	}

	static class Scanner {
		BufferedReader bf;
		StringTokenizer ns;

		Scanner(InputStream s) {
			bf = new BufferedReader(new InputStreamReader(s));
		}

		String next() throws IOException {
			while (ns == null || !ns.hasMoreTokens())
				ns = new StringTokenizer(bf.readLine());
			return ns.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		String nextLine() throws IOException {
			return bf.readLine();
		}

	}
}