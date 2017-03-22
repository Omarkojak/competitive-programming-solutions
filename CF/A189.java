package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A189 {
	static int a, b, c;
	static int n;
	static int inf = 10000;
	static int[] dp;

	public static int max(int l) {
		if (l > n)
			return -inf;
		if (l == n)
			return 0;
		if (dp[l] != 0)
			return dp[l];
		int a1 = 1 + max(l + a);
		int b1 = 1 + max(l + b);
		int c1 = 1 + max(l + c);
		return dp[l] = Math.max(Math.max(a1, b1), c1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(ns.nextToken());
		a = Integer.parseInt(ns.nextToken());
		b = Integer.parseInt(ns.nextToken());
		c = Integer.parseInt(ns.nextToken());
		dp = new int[n + 10];
		out.println(max(0));
		out.close();
	}

}
