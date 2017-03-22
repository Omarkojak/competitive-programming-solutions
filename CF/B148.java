package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B148 {
	static final double EPS = 1e-9;

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int vp = in.nextInt();
		int vd = in.nextInt();
		int t = in.nextInt(); // time until the dragon will move first time
		int f = in.nextInt(); // time until the dragon gets back to the castle
		double c = in.nextInt() * 1.0;
		double distcut = vp * t * 1.0; // initial distance princess moves
		int bijous = 0;
		if (vd <= vp) {
			System.out.println(0);
			return;
		}
		while (distcut < c + EPS) {
			double d2 = (vp * distcut * 1.0) / ((vd - vp) * 1.0);
			distcut += d2; // the dragon catches the princess
			if (distcut + EPS > c)
				break;
			bijous++;
			double t1 = distcut / (vd * 1.0); // time for dragon to return to castle
			distcut += vp * (f + t1);
		}
		System.out.println(bijous);

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
