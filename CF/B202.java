package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class B202 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		String[] arr = new String[n];
		TreeMap<String, Integer> mp = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			arr[i] = in.next();
			mp.put(arr[i], i);
		}
		int m = in.nextInt();
		boolean neww = true;
		int min = Integer.MAX_VALUE;
		int idxmin = Integer.MAX_VALUE;
		for (int i = 1; i <= m; i++) {
			int k = in.nextInt();
			String[] archive = new String[k];
			int[] cnt = new int[n];
			for (int j = 0; j < k; j++) {
				archive[j] = in.next();
				if (mp.containsKey(archive[j]))
					cnt[mp.get(archive[j])]++;
			}

			if (valid(cnt)) {
				neww = false;
				int inv = ev(arr, archive);
				if (inv == min)
					idxmin = Math.min(idxmin, i);
				if (inv < min) {
					min = inv;
					idxmin = i;
				}
			}

		}

		if (neww)
			sb.append("Brand new problem!");
		else {
			sb.append(idxmin).append("\n");
			sb.append("[:");
			int val = (n * (n - 1)) / 2 - min + 1;
			while (val-- > 0)
				sb.append("|");
			sb.append(":]");
		}

		System.out.println(sb);
	}

	public static boolean nextPermutation(int[] a) {
		int n = a.length;
		int i = n - 1;
		while (i > 0 && a[i - 1] >= a[i])
			i--;
		if (i <= 0)
			return false;

		int j = n - 1;
		while (a[j] <= a[i - 1])
			j--;

		int temp = a[j];
		a[j] = a[i - 1];
		a[i - 1] = temp;
		j = n - 1;
		while (i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		return true;
	}

	static int ev(String[] arr, String[] arch) {
		TreeMap<Integer, String> mp = new TreeMap<>();
		int n = arr.length;
		int m = arch.length;
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = i;
			mp.put(i, arr[i]);
		}
		int inv = Integer.MAX_VALUE;
		do {
			int j = 0;
			for (int k = 0; k < m && j < n; k++) {
				if (mp.get(a[j]).equals(arch[k]))
					j++;
			}
			if (j == n) {
				int cnt = 0;
				for (int i = 0; i < n; i++)
					for (int k = i + 1; k < n; k++)
						if (a[i] > a[k])
							cnt++;

				inv = Math.min(inv, cnt);
			}
		} while (nextPermutation(a));
		return inv;
	}

	static boolean valid(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == 0)
				return false;
		return true;
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
