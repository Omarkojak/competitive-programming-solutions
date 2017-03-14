package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B766 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> as = new ArrayList<>();
		for(int i=0;i<n;i++)
			as.add(in.nextInt());
		Collections.sort(as);
		int idx = 0;
		while(idx<n - 2){
			if(as.get(idx) + as.get(idx + 1) > as.get(idx + 2))
				break;
			idx++;
		}
		if(idx == n - 2)
			System.out.println("NO");
		else
			System.out.println("YES");
		
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
