package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B330_RoadConstruction {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		boolean[] center = new boolean[n + 1];
		Arrays.fill(center, true);
		int m = in.nextInt();
		while (m-- > 0) {
			center[in.nextInt()] = false;
			center[in.nextInt()] = false;
		}

		int cent = -1;
		for (int i = 1; i <= n; i++)
			if (center[i]) {
				cent = i;
				break;
			}
		for (int i = 1; i <= n; i++) {
			if(i != cent)
				sb.append(cent + " " + i).append("\n");
		}
		System.out.println(n - 1);
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
