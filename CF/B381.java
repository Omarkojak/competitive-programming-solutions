package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B381 {
	
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		int max = 0;
		int[] cnt = new int[(int) 1e5 + 5];
		for (int i = 0; i < n; i++) {
			int x = in.nextInt();
			cnt[x]++;
			max = Math.max(max, x);
		}
		int c = 0;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < cnt.length; i++) 
			if (cnt[i] > 0) {
				cnt[i]--;
				c++;
				sb.append(i + " ");
				if (cnt[i] > 0 && i != max) {
					c++;
					st.add(i);
				}
			}
		while(!st.isEmpty())
			sb.append(st.pop() + " ");
		System.out.println(c);
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

		public boolean nxtEmpty() throws IOException {
			String line = br.readLine();
			if (line == null || line.isEmpty())
				return true;
			st = new StringTokenizer(line);
			return false;
		}
	}

}
