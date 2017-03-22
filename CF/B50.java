package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class B50 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		char[] s = in.nextLine().toCharArray();
		TreeMap<Character, Long> mp = new TreeMap<>();
		TreeSet<Character> ts = new TreeSet<>();
		for (int i = 0; i < s.length; i++) {
			ts.add(s[i]);
			long c = 0;
			if (mp.containsKey(s[i]))
				c = mp.get(s[i]);
			mp.put(s[i], c + 1);
		}
		long ans = 0;
		while (!ts.isEmpty()) {
			long c = mp.get(ts.pollFirst());
			ans += c * c;
		}
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

		public boolean nxtEmpty() throws IOException {
			String line = br.readLine();
			if (line == null || line.isEmpty())
				return true;
			st = new StringTokenizer(line);
			return false;
		}
	}

}
