package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D725 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long ballons = in.nextLong();
		long weight = in.nextLong();
		PriorityQueue<Team> better = new PriorityQueue<>(
				new Comparator<Team>() {
					public int compare(Team t1, Team t2) {
						return Long.compare(t1.w - t1.t, t2.w - t2.t);
					}
				});

		PriorityQueue<Team> worse = new PriorityQueue<>(new Comparator<Team>() {
			public int compare(Team t1, Team t2) {
				return Long.compare(t2.t, t1.t);
			}
		});

		for (int i = 1; i < n; i++) {
			long t = in.nextLong();
			long w = in.nextLong();
			if (t > w)
				continue;
			if (t > ballons)
				better.add(new Team(t, w));
			else
				worse.add(new Team(t, w));
		}

		int place = better.size() + 1;
		while (ballons > 0) {
			if (better.size() > 0 && better.peek().w - better.peek().t + 1 <= ballons) {
				Team fly = better.poll();
				ballons -= (fly.w - fly.t + 1);
				while(worse.size() > 0 && worse.peek().t > ballons){
					better.add(worse.poll());
				}
			} else {
				break;
			}

			place = Math.min(place, better.size() + 1);
		}
		System.out.println(place);
	}

	static class Team {
		long t, w;

		Team(long a, long b) {
			t = a;
			w = b;
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
