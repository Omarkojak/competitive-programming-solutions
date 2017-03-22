package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class C149 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		PriorityQueue<boy> pq = new PriorityQueue<>();
		for (int i = 1; i <= n; i++)
			pq.add(new boy(in.nextInt(), i));

		StringBuilder team1 = new StringBuilder();
		StringBuilder team2 = new StringBuilder();
		int t1 = 0;
		int t2 = 0;
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 1) {
				team1.append(pq.poll().idx + " ");
				t1++;
			} else {
				team2.append(pq.poll().idx + " ");
				t2++;
			}
		}
		System.out.println(t1);
		System.out.println(team1);
		System.out.println(t2);
		System.out.println(team2);

	}

	static class boy implements Comparable<boy> {
		int ability;
		int idx;

		boy(int a, int i) {
			ability = a;
			idx = i;
		}

		public int compareTo(boy o) {
			if (ability != o.ability)
				return ability - o.ability;

			return idx - o.idx;
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
