package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A494 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		char[] s = in.nextLine().toCharArray();
		int n = s.length, last = -1;
		int[] prefix = new int[n];
		boolean f = true;
		for (int i = 0; i < n; i++) {
			prefix[i] += (s[i] == '(') ? 1 : -1;
			if (s[i] == '#')
				last = i;
			if (i > 0)
				prefix[i] += prefix[i - 1];
			if (prefix[i] < 0)
				f = false;
		}
		int add = prefix[n - 1];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<last;i++){
			if(s[i] == '#')
				sb.append("1\n");
		}
		sb.append((1 + add));
		for (int i = last; i < n; i++) {
			prefix[i] -= add;
			if(prefix[i] < 0)
				f = false;
		}
		System.out.println(f? sb:"-1");

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
