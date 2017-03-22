package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B144 {
	static int[] circ;
	static final double EPS = 1e-9;

	public static double dist(int x, int y) {
		return Math.sqrt(x * x + y * y);
	}

	public static boolean covered(int x, int y) {
		for (int i = 0; i < circ.length; i += 3) {
			double dist = dist(x - circ[i], y - circ[i + 1]);
			// System.out.println(dist);
			if (dist < circ[i + 2] * 1.0 + EPS)
				return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		int x1 = Math.min(a, c);
		int x2 = Math.max(a, c);
		int y1 = Math.min(b, d);
		int y2 = Math.max(b, d);
		int n = in.nextInt();
		circ = new int[n * 3];
		for (int i = 0; i < n * 3; i += 3) {
			circ[i] = in.nextInt();
			circ[i + 1] = in.nextInt();
			circ[i + 2] = in.nextInt();
		}
		int cnt = 0;
		for (int y = y1; y <= y2; y++) {
			if (!covered(x1, y))
				cnt++;
			if (!covered(x2, y))
				cnt++;
		}

		for (int x = x1 + 1; x < x2; x++) {
			if (!covered(x, y1))
				cnt++;
			if (!covered(x, y2))
				cnt++;
		}
		System.out.println(cnt);

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
