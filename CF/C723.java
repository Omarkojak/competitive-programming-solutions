package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class C723 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int arr[] = new int[n];
		int[] cnt = new int[m + 1];

		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
			if (arr[i] <= m)
				cnt[arr[i]]++;
		}
		int changes = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(
				new Comparator<Integer>() {
					public int compare(Integer o1, Integer o2) {
						return Integer.compare(cnt[o1], cnt[o2]);
					}
				});
		for (int i = 1; i <= m; i++)
			pq.add(i);

		for (int i = 0; i < n; i++) {
			if (arr[i] > m && cnt[pq.peek()] < n / m) {
				arr[i] = pq.poll();
				cnt[arr[i]]++;
				changes++;
				pq.add(arr[i]);
			}
		}
		int limit = (int) Math.ceil(n / m);
		if (cnt[pq.peek()] < n / m) {
			for (int i = 0; i < n; i++)
				if (cnt[pq.peek()] < n / m && cnt[arr[i]] > limit) {
					int curr = pq.poll();
					cnt[curr]++;
					cnt[arr[i]]--;
					arr[i] = curr;
					changes++;
					pq.add(curr);
				}
		}

		System.out.println(n / m + " " + changes);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(arr[i]);
			if (i != n - 1)
				sb.append(" ");
		}
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
