package OfficialContests.HIAST16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			long[] arr = new long[n+1];
			for (int i = 0; i < n; i++)
				arr[i] = in.nextLong();
			long[] acc = new long[n + 1];

			while (m-- > 0)
				acc[in.nextInt() - 1] += in.nextLong();

			for (int i = 0; i < n; i++) {
				if(acc[i] > arr[i])
				{
					acc[i+1]+=acc[i]-arr[i];
				}else
					arr[i] = acc[i];
					
				
			}
			sb.append(acc[n]).append("\n");
			for(int i=0;i<n;i++)
			{
				sb.append(arr[i]);
				if(i != n-1)
					sb.append(" ");
			}
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
