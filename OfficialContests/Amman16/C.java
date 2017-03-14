package OfficialContests.Amman16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class C {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			int N = in.nextInt();
			int Q = in.nextInt();
			Team[] arr = new Team[N];
			TreeSet<Team> ts = new TreeSet<>();
			for (int i = 0; i < N; i++)
				ts.add(arr[i] = new Team(i, 0));
			int ans = 0, winner = 0;
			for (int i = 1; i <= Q; i++) {
				int idx = in.nextInt() - 1;
				int p = in.nextInt();
				Team curr = new Team(idx, arr[idx].score);
				ts.remove(curr);
				curr.score += p;
				arr[idx] = curr;
				ts.add(curr);

				Team first = ts.pollFirst();
				if (first.idx != winner) {
					winner = first.idx;
					ans = i;
				}
				ts.add(first);
			}
			sb.append(ans).append("\n");

		}
		System.out.print(sb);
	}

	static class Team implements Comparable<Team> {
		int idx, score;

		Team(int a, int b) {
			idx = a;
			score = b;
		}

		@Override
		public int compareTo(Team o) {
			if (score != o.score)
				return o.score - score;
			return idx - o.idx;
		}

	}

	static class Scanner {
		BufferedReader bf;
		StringTokenizer ns;

		Scanner(InputStream s) {
			bf = new BufferedReader(new InputStreamReader(s));
		}

		String next() throws IOException {
			while (ns == null || !ns.hasMoreTokens())
				ns = new StringTokenizer(bf.readLine());
			return ns.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		String nextLine() throws IOException {
			return bf.readLine();
		}

	}

}
