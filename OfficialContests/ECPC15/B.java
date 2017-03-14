package OfficialContests.ECPC15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			int questions = in.nextInt();
			int n = in.nextInt();

			TreeSet<Character>[] data = new TreeSet[questions];
			for (int i = 0; i < questions; i++) {
				data[i] = new TreeSet<>();
				data[i].add('A');
				data[i].add('B');
				data[i].add('C');
				data[i].add('D');
			}
			while (n-- > 0) {
				for (int i = 0; i < questions; i++) {
					char ans = in.next().charAt(0);
					if (in.next().charAt(0) == 'T') {
						if (ans != 'A' && data[i].contains('A'))
							data[i].remove('A');
						if (ans != 'B' && data[i].contains('B'))
							data[i].remove('B');
						if (ans != 'C' && data[i].contains('C'))
							data[i].remove('C');
						if (ans != 'D' && data[i].contains('D'))
							data[i].remove('D');

					} else if (data[i].contains(ans))
						data[i].remove(ans);

				}
			}
			for (int i = 0; i < questions; i++) {
				sb.append((data[i].size() == 1) ? data[i].pollFirst() : "?");
				if (i != questions - 1)
					sb.append(" ");
			}
			sb.append("\n");
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
