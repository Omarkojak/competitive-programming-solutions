package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B761 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int l = in.nextInt();
		ArrayList<Integer> a1 = new ArrayList<>();
		ArrayList<Integer> a2 = new ArrayList<>();
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		for (int i = 0; i < n; i++)
			arr1[i] = in.nextInt();
		for (int i = 0; i < n; i++)
			arr2[i] = in.nextInt();

		int cum = arr1[0];
		for (int i = 1; i < n; i++) {
			a1.add(arr1[i] - cum);
			cum += arr1[i] - arr1[i - 1];
		}
		a1.add(l - cum + arr1[0]);

		int cum2 = arr2[0];
		for (int i = 1; i < n; i++) {
			a2.add(arr2[i] - cum2);
			cum2 += arr2[i] - arr2[i - 1];
		}
		a2.add(l - cum2 + arr2[0]);

		boolean f = false;
		for (int i = 0; i < n; i++) {
			int k = i;
			int times = n;
			int j = 0;
			boolean w = true;
			while (times-- > 0) {
				if (a1.get(j) != a2.get(k))
					w = false;
				k++;
				j++;
				if (k == n)
					k = 0;
			}
			if (w)
				f = true;
		}
		System.out.println(f ? "YES" : "NO");

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
