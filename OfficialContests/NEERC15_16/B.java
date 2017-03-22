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

public class B {

	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner(System.in);
		// PrintWriter out = new PrintWriter(System.out);
		Scanner in = new Scanner(new File("black.in"));
		PrintWriter out = new PrintWriter("black.out");
		int b = in.nextInt();
		int w = in.nextInt();
		if (b == 1 && w == 1) {
			out.println("2 1");
			out.println("@");
			out.println(".");
			out.flush();
			out.close();
			return;
		}
		int cols = (Math.max(b - 1, w - 1) * 2);
		out.println("4 " + cols);
		StringBuilder sb = new StringBuilder();
		for (int i = 0, j = 0; i < cols; i++) {
			if (j == b - 1)
				sb.append(".");
			if (j < b - 1) {
				sb.append(i % 2 == 0 ? '@' : '.');
				if (i % 2 == 0)
					j++;
			}
		}
		out.println(sb);
		sb = new StringBuilder();
		for (int i = 0; i < cols; i++)
			sb.append(".");
		out.println(sb);

		sb = new StringBuilder();
		for (int i = 0; i < cols; i++)
			sb.append("@");
		out.println(sb);
		sb = new StringBuilder();
		for (int i = 0, j = 0; i < cols; i++) {
			if (j == w - 1)
				sb.append("@");
			if (j < w - 1) {
				sb.append(i % 2 == 0 ? '@' : '.');
				if (i % 2 != 0)
					j++;
			}
		}
		out.println(sb);
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
