package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class D519 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		long[] val = new long[26];
		for (int i = 0; i < 26; i++)
			val[i] = in.nextLong();

		char[] s = in.nextLine().toCharArray();
		int n = s.length;
		long[] sum = new long[n + 1];
		long res = 0;
		TreeMap<Long, Long>[] arr = new TreeMap[26];
		for (int i = 0; i < 26; i++)
			arr[i] = new TreeMap<>();
		for (int i = 1; i <= n; i++) {
			Long cnt1 = arr[s[i - 1] - 'a'].get(sum[i - 1] - val[s[i - 1] - 'a']);
			res += cnt1 == null? 0: cnt1;
			long cnt = 0;
			if (arr[s[i - 1] - 'a'].containsKey(sum[i - 1]))
				cnt = arr[s[i - 1] - 'a'].get(sum[i - 1]);
			arr[s[i - 1] - 'a'].put(sum[i - 1], cnt + 1);
			sum[i] = sum[i - 1] + val[s[i - 1] - 'a'];
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
