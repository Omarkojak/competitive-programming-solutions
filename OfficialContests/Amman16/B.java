package OfficialContests.Amman16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
	static int cnt[] = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 };

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			char[] s = in.next().toCharArray();
			int sum = 0;
			for (int i = 0; i < n; i++)
				sum += cnt[s[i] - '0'];

			for (int i = 0; i < n - 1; i++) {
				for (int j = 9; j >= 0; j--) {
					int can = sum - cnt[j];
					if (can <= (n - i - 1) * 7 && can >= (n - i - 1) * 2) {
						sum -= cnt[j];
						sb.append(j);
						break;
					}
				}
			}

			for (int j = 9; j >= 0; j--)
				if (sum == cnt[j]) {
					sb.append(j);
					break;
				}

			sb.append("\n");

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
