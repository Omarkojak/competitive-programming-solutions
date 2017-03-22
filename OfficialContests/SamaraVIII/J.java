package OfficialContests.SamaraVIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		int arr1[] = new int[n];
		int arr2[] = new int[m];

		for (int i = 0; i < n; i++)
			arr1[i] = in.nextInt();
		for (int i = 0; i < m; i++)
			arr2[i] = in.nextInt();
		int p1 = 0, p2 = 0;
		int res = 0;
		boolean first = false;
		while (p1 < n) {
			res++;
			if (first)
				sb.append("\n");

			while (p2 < m && arr1[p1] != arr2[p2])
				p2++;
			int cnt = 0;
			StringBuilder temp = new StringBuilder();
			while (cnt < k && p1 < n && arr1[p1] == arr2[p2]) {
				if (cnt == 0)
					temp.append((p1 + 1));
				else
					temp.append(" " + (p1 + 1));
				p1++;
				p2++;
				cnt++;
			}
			sb.append(cnt).append(" ").append(temp);
			first = true;
		}
		System.out.println(res);
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
