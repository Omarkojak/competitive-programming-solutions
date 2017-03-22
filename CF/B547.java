package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B547 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		int[] leftsegment = new int[n];
		int[] rightsegment = new int[n];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++)
			arr[i] = in.nextInt();
		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && arr[st.peek() - 1] >= arr[i])
				st.pop();

			if (st.isEmpty())
				leftsegment[i] = 0;
			else
				leftsegment[i] = st.peek();

			st.push(i + 1);
		}
		st = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!st.isEmpty() && arr[st.peek() - 1] >= arr[i])
				st.pop();
			if (st.isEmpty())
				rightsegment[i] = n + 1;
			else
				rightsegment[i] = st.peek();
			st.push(i + 1);
		}

		int[] best = new int[n + 1];// for each size what is the best solution
		for (int i = 0; i < n; i++) {
			int length = rightsegment[i] - leftsegment[i] - 1;
			best[length] = Math.max(best[length], arr[i]);
		}
		int max = 0;
		for (int i = n; i > 0; i--) {
			max = Math.max(max, best[i]);
			best[i] = max;
		}
		System.out.print(best[1]);
		for (int i = 2; i <= n; i++)
			System.out.print(" " + best[i]);
		System.out.println();
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
