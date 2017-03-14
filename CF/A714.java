package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A714 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		long l1 = in.nextLong();
		long r1 = in.nextLong();
		long l2 = in.nextLong();
		long r2 = in.nextLong();
		long k = in.nextLong();
		if (l2 > r1 || r2 < l1) {
			System.out.println(0);
			return;
		}
		
		long l = -1;
		if(l1 < l2)
			l = l2;
		else
			l = l1;
		
		long r = -1;
		if(r1 < r2)
			r = r1;
		else
			r = r2;
		long ans = r - l + 1;
		if(k >= l && k<= r)
			ans--;
		System.out.println(ans);

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
