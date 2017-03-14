package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class C276 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		ArrayList<Long> as = new ArrayList<>();
		for (int i = 0; i < n; i++)
			as.add(in.nextLong());
		Collections.sort(as);
		int freq[] = new int[n + 1];
		while (q-- > 0) {
			freq[in.nextInt() - 1]++;
			freq[in.nextInt()]--;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(
				new Comparator<Integer>() {
					public int compare(Integer o1, Integer o2) {
						return o2 - o1;
					}

				});
		for (int i = 0; i < n; i++) {
			if (i > 0)
				freq[i] += freq[i - 1];
			pq.add(freq[i]);
		}
		long sum = 0;
		for (int i = n - 1; i >= 0; i--) {
			sum += as.get(i) * pq.poll();
		}
		System.out.println(sum);

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