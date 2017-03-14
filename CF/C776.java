package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class C776 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		long k = in.nextInt();
		long cnt = 0;
		long cum[] = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			long x = in.nextLong();
			cum[i] = cum[i - 1] + x;
		}
		ArrayList<Long> nums = new ArrayList<>();
		if(Math.abs(k) == 1){
			nums.add(1L);
			if(k == -1)
				nums.add(-1L);
		}else{
			for(long i=1;i<=(long) 1e15;i*=k)
				nums.add(i);
		}
		
		for(long acc:nums) {
			HashMap<Long, Integer> count = new HashMap();
			count.put(0l, 1);

			for (int i = 1; i <= n; i++) {
				long key = cum[i] - acc;
				if (count.containsKey(key)) {
					cnt += count.get(key);
				}
				int c = 0;
				if (count.containsKey(cum[i]))
					c = count.get(cum[i]);
				count.put(cum[i], c + 1);
			}
			acc *= k;
		}
		System.out.println(cnt);
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
