package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B733 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int left[] = new int[n];
		int right[] = new int[n];
		int suml = 0, sumr = 0;
		for (int i = 0; i < n; i++) {
			suml += left[i] = in.nextInt();
			sumr += right[i] = in.nextInt();
		}
		int k = 0, max = Math.abs(suml - sumr);
		for (int i = 0; i < n; i++) {
			int sumll = suml - left[i] + right[i];
			int sumrr = sumr - right[i] + left[i];
			if (Math.abs(sumll - sumrr) > max) {
				k = i + 1;
				max = Math.abs(sumll - sumrr);
			}
		}
		System.out.println(k);

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
