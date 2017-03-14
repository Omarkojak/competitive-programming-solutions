package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class A727 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int a1 = in.nextInt();
		int a2 = in.nextInt();
		Stack<Integer> st = new Stack<>();
		boolean f = true;
		while (true) {
			st.add(a2);
			if (a2 < a1) {
				f = false;
				break;
			}
			if (a2 == a1)
				break;
			if ((a2 & 1) == 0) {
				a2 >>= 1;
				continue;
			}
			if (a2 % 10 == 1) {
				a2 /= 10;
				continue;
			}
			f = false;
			break;
		}

		StringBuilder sb = new StringBuilder(f ? "YES\n" : "NO\n");
		if (f) {
			sb.append(st.size()).append("\n");
			while(!st.isEmpty())
				sb.append(st.pop() + " ");
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
