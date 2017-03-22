package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B195 {
	static double mid;

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int balls = in.nextInt();
		int baskets = in.nextInt();
		mid = (baskets + 1) / 2.0;
		PriorityQueue<Basket> pq = new PriorityQueue<>();
		for (int i = 1; i <= baskets; i++)
			pq.add(new Basket(0, i));
		while (balls-- > 0) {
			Basket curr = pq.poll();
			sb.append(curr.pos).append("\n");
			curr.balls++;
			pq.add(curr);
		}

		System.out.print(sb);
	}

	static class Basket implements Comparable<Basket> {
		int balls, pos;

		Basket(int a, int b) {
			balls = a;
			pos = b;
		}

		public int compareTo(Basket b) {
			if (balls != b.balls)
				return balls - b.balls;
			if (Math.abs(mid - pos) != Math.abs(mid - b.pos))
				return Double.compare(Math.abs(mid - pos),
						Math.abs(mid - b.pos));
			return pos - b.pos;
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
