package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class E61 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		ArrayList<Integer> as = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
			as.add(arr[i]);
		}
		Collections.sort(as);
		TreeMap<Integer, Integer> mp = new TreeMap<>();
		for (int i = 0; i < n; i++)
			mp.put(as.get(i), i);

		FenwickTree ft = new FenwickTree(n + 1);
		long[] prev = new long[n];
		long[] forw = new long[n];
		for (int i = 0; i < n; i++) {
			prev[i] = ft.rsq(mp.get(arr[i]) + 1, n);
			ft.point_update(mp.get(arr[i]) + 1, 1);
		}

		ft = new FenwickTree(n + 1);
		for (int i = n - 1; i >= 0; i--) {
			forw[i] = ft.rsq(0, mp.get(arr[i]));
			ft.point_update(mp.get(arr[i]) + 1, 1);
		}

		long ans = 0;
		for (int i = 0; i < n; i++)
			ans += forw[i] * prev[i];
		System.out.println(ans);

	}

	static class FenwickTree {
		int n;
		int[] ft;

		FenwickTree(int size) {
			n = size;
			ft = new int[n + 1];
		}

		int rsq(int b) {
			int sum = 0;
			while (b > 0) {
				sum += ft[b];
				b -= b & -b;
			} // min?
			return sum;
		}

		int rsq(int a, int b) {
			return rsq(b) - rsq(a - 1);
		}

		void point_update(int k, int val) {
			while (k <= n) {
				ft[k] += val;
				k += k & -k;
			}
		}

		int point_query(int idx) {
			int sum = ft[idx];
			if (idx > 0) {
				int z = idx ^ (idx & -idx);
				--idx;
				while (idx != z) {
					sum -= ft[idx];
					idx ^= idx & -idx;
				}
			}
			return sum;
		}

		void scale(int c) {
			for (int i = 1; i <= n; ++i)
				ft[i] *= c;
		}

		int findIndex(int cumFreq) {
			int msk = n;
			while ((msk & (msk - 1)) != 0)
				msk ^= msk & -msk;

			int idx = 0;
			while (msk != 0) {
				int tIdx = idx + msk;
				if (tIdx <= n && cumFreq >= ft[tIdx]) {
					idx = tIdx;
					cumFreq -= ft[tIdx];
				}
				msk >>= 1;
			}
			if (cumFreq != 0)
				return -1;
			return idx;
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

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}
