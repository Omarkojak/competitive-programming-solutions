package OfficialContests.NEERC15_16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class H {

	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner(System.in);
		// PrintWriter out = new PrintWriter(System.out);
		Scanner in = new Scanner(new File("hash.in"));
		PrintWriter out = new PrintWriter("hash.out");
		StringBuilder res = new StringBuilder();
		int k = in.nextInt();
		// zero = "ed" one = "fE"
		int upper = (int) (Math.ceil(Math.log(k) / Math.log(2)));
		for (int i = 0; i < (1 << upper) && i < k; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < upper; j++)
				if ((i & (1 << j)) == 0)
					sb.append("ed");
				else
					sb.append("fE");

			res.append(sb).append("\n");
		}
		out.print(res);
		out.flush();
		out.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(File f) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(f));
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
