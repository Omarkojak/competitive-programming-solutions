package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A723 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> as = new ArrayList<>();
		as.add(in.nextInt());
		as.add(in.nextInt());
		as.add(in.nextInt());
		Collections.sort(as);
		System.out.println(as.get(1) - as.get(0) + as.get(2) - as.get(1));
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
