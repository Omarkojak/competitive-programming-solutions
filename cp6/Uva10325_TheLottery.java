package cp6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva10325_TheLottery {

	public static long GCD(long a, long b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}

	public static long LCM(long a, long b) {
		return a * (b / GCD(a, b));
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			String s = in.nextLine();
			if (s == null || s.length() == 0)
				break;
			
			StringTokenizer ns =new StringTokenizer(s);
			Long N = Long.parseLong(ns.nextToken());
			int m = Integer.parseInt(ns.nextToken());
			int[] arr = new int[m];
			for (int i = 0; i < m; i++)
				arr[i] = in.nextInt();
			long divis = 0;
			for (int i = 1; i < (1 << m); i++) {
				long lcm = 1;
				for(int j=0;j<m;j++)
					if(((1<<j) & i) != 0)
						lcm = LCM(lcm, arr[j]);
				
				if((Integer.bitCount(i) & 1) == 0)
					divis -= (N/lcm);
				else
					divis += (N/lcm);
			//	System.err.println(lcm + "  " + divis + "  " + i);
			}
			sb.append(N - divis).append("\n");

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
