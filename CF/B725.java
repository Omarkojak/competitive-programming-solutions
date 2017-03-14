package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B725 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String s = in.nextLine();
		int n = s.length();
		char seat = s.charAt(n - 1);
		long row = Long.parseLong(s.substring(0, n - 1));
		long blocks = (row - 1) /4;
		
		long ans = blocks * 12 + blocks * 3 + blocks;
		if(row % 4 == 2 || row % 4 == 0)
			ans+=7;
		
		if(seat == 'f')
			ans++;
		
		if(seat == 'e')
			ans+=2;
		
		if(seat == 'd')
			ans+=3;
		
		if(seat == 'a')
			ans+=4;
		
		if(seat == 'b')
			ans+=5;
		
		if(seat == 'c')
			ans+=6;
		System.out.println(ans);
		

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
