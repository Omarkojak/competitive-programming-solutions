package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class D675_TreeConstruction {
	static final long inf = (long) 1e18;

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		TreeMap<Range, Long> mp = new TreeMap<>();
		TreeSet<Long> ts = new TreeSet<>();

		int n = in.nextInt() - 1;
		long root = in.nextLong();
		mp.put(new Range(-inf, root), root);
		mp.put(new Range(root, inf), root);
		ts.add(root);

		while (n-- > 0) {
			long insert = in.nextLong();
			Long l = ts.lower(insert);
			Long r = ts.higher(insert);
			if (l == null)
				l = -inf;
			if (r == null)
				r = inf;
			//System.err.println(l + " " + r);
			Range curr = new Range(l, r);
			Long ans = mp.get(curr);
			sb.append(ans);
			
			mp.put(new Range(l, insert), insert);
			mp.put(new Range(insert, r), insert);
			ts.add(insert);
			
			
			mp.remove(curr);
			if (n != 0)
				sb.append(" ");
		}

		System.out.println(sb);
	}

	static class Range implements Comparable<Range> {
		long left, right;

		Range(long a, long b) {
			left = a;
			right = b;
		}

		public int compareTo(Range o) {
			int comp = Long.compare(left, o.left);
			if (comp != 0)
				return comp;
			return Long.compare(right, o.right);
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
