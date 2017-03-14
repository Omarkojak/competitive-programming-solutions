package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C732 {
	static long a1, a2, a3;

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		a1 = in.nextLong();
		a2 = in.nextLong();
		a3 = in.nextLong();
		long min = Long.MAX_VALUE;
		if (a1 >= a2 && a2 >= a3) {
			long val = 0;
			if (a1 - 1 - a2 > 0)
				val += a1 - 1 - a2;
			if ((a1 - 1) - a3 > 0)
				val += (a1 - 1) - a3;

			min = Math.min(min, val);
		}

		if (a1 >= a2 && a2 <= a3) {
			if (a1 > a3) {
				long val = 0;
				if ((a1 - 1) - a2 > 0)
					val += (a1 - 1) - a2;
				if ((a1 - 1) - a3 > 0)
					val += (a1 - 1) - a3;
				min = Math.min(min, val);
			} else {
				long val = 0;
				if ((a3 - 1) - a2 > 0)
					val += (a3 - 1) - a2;
				if((a3 - 1) - a1 > 0)
					val+= (a3 - 1) - a1;

				min = Math.min(min, val);
			}
		}

		if (a2 >= a1 && a2 >= a3) {
			long val = 0;
			if((a2 - 1) - a3 > 0)
				val+=(a2 - 1) - a3;
			if((a2 - 1) - a1 > 0)
				val+=(a2 - 1) - a1;
			min = Math.min(min, val);
		}

		if (a1 <= a2 && a2 <= a3) {
			long val = 0;
			if((a3 - 1) - a2 > 0)
				val+=(a3 - 1) - a2;
			if((a3 - 1) - a1 > 0)
				val+=(a3 - 1) - a1;
			min = Math.min(min, val);
		}
		System.out.println(min);
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
