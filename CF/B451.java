package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class B451 {

	public static void shuffle(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * (n - i));
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	public static void rev(int[] a, int idx1, int idx2) {
		for (; idx1 < idx2; idx1++, idx2--) {
			int temp = a[idx1];
			a[idx1] = a[idx2];
			a[idx2] = temp;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		TreeMap<Integer, Integer> mp = new TreeMap<Integer, Integer>();
		for (int i = 0; i < n; i++)
			a[i] = b[i] = in.nextInt();
		shuffle(b);
		Arrays.sort(b);

		for (int i = 0; i < n; i++)
			mp.put(b[i], i);

		int idx1 = -1;
		int idx2 = -1;
		for (int i = 0; i < n; i++) {
			int v = mp.get(a[i]);
			if (v == i && idx1 == -1) {
				continue;
			}
			if (v != i && idx1 == -1)
				idx1 = i;
			if (v != i && idx1 != -1)
				idx2 = i;

		}
		if (idx1 == -1 && idx2 == -1) {
			System.out.println("yes");
			System.out.println("1 1");
			return;
		}
		if (idx2 == -1)
			idx2 = n - 1;
		rev(a, idx1, idx2);
		// System.out.println(idx1+" "+idx2);
		boolean flag = true;
		for (int i = 0; i < n && flag; i++)
			if (mp.get(a[i]) != i)
				flag = false;
		if (flag) {
			System.out.println("yes");
			System.out.println(idx1 + 1 + " " + (idx2 + 1));
		} else
			System.out.println("no");
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
