package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A660 {

	public static int GCD(int a, int b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = in.nextInt();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (i == n - 1)
				sb.append(arr[i]);
			else if (GCD(arr[i], arr[i + 1]) != 1) {
				sb.append(arr[i]).append(" 1 ");
				cnt++;
			} else
				sb.append(arr[i] + " ");

		}
		System.out.println(cnt);
		System.out.println(sb);

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
