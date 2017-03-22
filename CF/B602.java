package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B602 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = in.nextInt();
		int cnt[] = new int[(int) 1e6 + 5];
		TreeSet<Integer> ts = new TreeSet<>();
		cnt[arr[0]]++;
		ts.add(arr[0]);
		int res = 0;
		for (int l = 0, r = 1; l < n; l++) {
			while (r < n) {
				int max = Math.max(arr[r], ts.last());
				int min = Math.min(arr[r], ts.first());
				if (max - min > 1)
					break;
				ts.add(arr[r]);
				cnt[arr[r]]++;
				r++;
			}
			res = Math.max(res, r - l);
			cnt[arr[l]]--;
			if (cnt[arr[l]] == 0)
				ts.remove(arr[l]);
		}
		System.out.println(res);

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
