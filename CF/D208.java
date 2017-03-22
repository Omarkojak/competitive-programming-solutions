package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class D208 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long arr[] = new long[n];
		for (int i = 0; i < n; i++)
			arr[i] = in.nextLong();
		ArrayList<Pair> as = new ArrayList<>();
		for (int i = 0; i < 5; i++)
			as.add(new Pair(i, in.nextLong()));
		Collections.sort(as);

		long quan[] = new long[5];
		long sum = 0;

		for (int i = 0; i < n; i++) {
			sum += arr[i];
			for (int j = 4; j >= 0; j--) {
				Pair p = as.get(j);
				quan[p.idx] += sum / p.val;
				sum -= (sum / p.val) * p.val;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++)
			sb.append(quan[i]).append(i == 4 ? "\n" : " ");
		sb.append(sum);
		System.out.println(sb);

	}

	static class Pair implements Comparable<Pair> {
		int idx;
		long val;

		Pair(int a, long b) {
			idx = a;
			val = b;
		}

		public int compareTo(Pair p) {
			return Long.compare(val, p.val);
		}
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
