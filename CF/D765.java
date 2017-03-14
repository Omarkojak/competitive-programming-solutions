package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class D765 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		int arr[] = new int[n + 5];
		TreeSet<Integer> ts = new TreeSet<>();
		for (int i = 1; i <= n; i++) {
			arr[i] = in.nextInt();
			ts.add(arr[i]);
		}
		int m_ans = ts.size();
		int h[] = new int[m_ans + 1];
		int number[] = new int[n + 5];
		boolean f = true;
		int cnt = 1;
		while(!ts.isEmpty()){
			int x = ts.pollFirst();
			h[cnt] = x;	//x-> f(x)
			if(arr[x] != x)
				f = false;
			number[x] = cnt;
			cnt++;
		}
		if (!f) {
			System.out.println(-1);
		} else {
			sb.append(m_ans).append("\n");
			for (int i = 1; i <= n; i++) {
				sb.append(number[arr[i]]).append(" ");
			}
			sb.append("\n");
			for (int i = 1; i <= m_ans; i++)
				sb.append(h[i]).append(" ");
			System.out.println(sb);
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
	}

}
