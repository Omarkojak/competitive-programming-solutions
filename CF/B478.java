package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B478 {

	private static long c(long n) {
		return n * (n + 1) / 2;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		long n = Long.parseLong(ns.nextToken());
		long m = Long.parseLong(ns.nextToken());
		if (m == 1)
			out.println(c(n - 1) + " " + c(n - 1));
		else if (m == n)
			out.println(0 + " " + 0);
		else {
			long max = c(n - (m - 1) - 1);
			long k = n / m;
			long rem = n % m;
			long min = c(k - 1) * (m - rem) + c(k) * (rem);

			out.println(min + " " + max);
		}
		out.close();
	}

}
