package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D732 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int days = in.nextInt();
		int subjects = in.nextInt();
		int[] exams = new int[days];
		int[] needed = new int[subjects + 1];

		for (int i = 0; i < days; i++)
			exams[i] = in.nextInt();

		for (int j = 0; j < subjects; j++)
			needed[j] = in.nextInt();

		int ans = -1, low = 0, high = days - 1;
		while (low <= high) {
			int mid = (low + high) >> 1;
			boolean taken[] = new boolean[subjects + 1];
			boolean examhere[] = new boolean[days];
			int cnt = 0;
			for (int i = mid; i >= 0; i--) {
				if (exams[i] != 0 && !taken[exams[i]]) {
					cnt++;
					taken[exams[i]] = true;
					examhere[i] = true;
				}
			}
			if (cnt != subjects) {
				low = mid + 1;
				continue;
			}
			boolean f = true;
			int cntt = 0;
			for (int i = 0; i <= mid; i++) {
				if (examhere[i]) {
					cntt -= needed[exams[i] - 1];
				} else
					cntt++;
				if (cntt < 0)
					f = false;
			}

			if (f) {
				high = mid - 1;
				ans = mid;
			} else
				low = mid + 1;

		}
		System.out.println(ans == -1 ? -1 : ans + 1);

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
