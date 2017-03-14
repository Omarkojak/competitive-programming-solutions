package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BetweenTwoSets {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();

		int[] b = new int[m];
		for (int i = 0; i < m; i++)
			b[i] = in.nextInt();
		int cnt = 0;
		for (int x = 1; x <= 100; x++) {
			boolean f = true;
			for(int i=0;i<n;i++)
				if(x % a[i] != 0)
					f = false;
			
			for(int j=0;j<m;j++)
				if(b[j] % x != 0)
					f = false;
			if(f)
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
