package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B577 {
	static int k;
	static int[] a;
	static boolean[][] dp;

	public static boolean ev(int i, long sum) {
		if (sum % k == 0 & sum != 0)
			return true;

		if (i == a.length)
			return false;

		boolean l = ev(i + 1, sum);
		boolean t = ev(i + 1, sum + a[i]);
		return l || t;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(ns.nextToken());
		k = Integer.parseInt(ns.nextToken());
		a = new int[n];
		dp = new boolean[n][n];
		ns = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(ns.nextToken());

		out.println(ev(0, 0) ? "YES" : "NO");
		out.close();
	}

}
