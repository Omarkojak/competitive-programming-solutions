package cp5_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Uva11069_AGraphProblem {
	static long[][] memo;
	static int n;

	public static long solve(int node) { // to indicate whether i take a 2dist or not
		if (node == n || node == n - 1)
			return 1;
		if (node > n)
			return 0;
		if (memo[node][n] != -1)
			return memo[node][n];

		long leaveone = solve(node + 2);
		long leavetwo = solve(node + 3);

		return memo[node][n] = leaveone + leavetwo;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		memo = new long[80][80];
		for (int i = 0; i < 80; i++)
			Arrays.fill(memo[i], -1l);

		String s = bf.readLine();
		while (s != null) {
			n = Integer.parseInt(s);
			sb.append(solve(1) + solve(2)).append("\n");
			s = bf.readLine();
		}
		System.out.print(sb);

	}

}
