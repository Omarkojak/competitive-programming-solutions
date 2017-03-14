package cp2_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Uva11491_ErasingAndWinning {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			int n = in.nextInt();
			int d = in.nextInt();
			if (n == 0 && d == 0)
				break;
			char[] arr = in.nextLine().toCharArray();
			Stack<Integer> st = new Stack<>();
			for (int i = 0; i < n; i++) {
				if(d != 0)
					while(!st.isEmpty() && st.peek() < (arr[i] - '0') && d > 0)
					{
						st.pop();
						d--;
					}
				st.push(arr[i] - '0');
			}
			while(d-- > 0)
				st.pop();
			Stack<Integer> temp = new Stack<>();
			while(!st.isEmpty())
				temp.add(st.pop());
			while(!temp.isEmpty())
				sb.append(temp.pop());
			sb.append("\n");
		}
		System.out.print(sb);
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
