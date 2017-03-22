package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Uva1196_TilingUpBlocks {
	static int n;
	static ArrayList<Block> list;

	static int bs(ArrayList<Integer> as, int x) {
		int low = 0, high = as.size() - 1;
		while (low <= high) {
			int mid = (low + high) >> 1;
			if (as.get(mid) > x)
				high = mid - 1;
			else {
				low = mid + 1;
			}
		}
		return low;
	}

	static int LIS() {
		int lis = 0;
		ArrayList<Integer> as = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int m = list.get(i).m;
			int pos = bs(as, m);

			if (pos == as.size())
				as.add(m);
			else
				as.set(pos, m);
			if (pos + 1 > lis)
				lis = pos + 1;
		}
		return lis;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			n = in.nextInt();
			if (n == 0)
				break;
			list = new ArrayList<>();
			for (int i = 0; i < n; i++)
				list.add(new Block(in.nextInt(), in.nextInt()));
			Collections.sort(list);
			sb.append(LIS()).append("\n");
		}
		sb.append("*");
		System.out.println(sb);
	}

	static class Block implements Comparable<Block> {
		int l, m;

		Block(int a, int b) {
			l = a;
			m = b;
		}

		public int compareTo(Block b) {
			if (l != b.l)
				return l - b.l;
			return m - b.m;
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
