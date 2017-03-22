package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A116 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int n = Integer.parseInt(bf.readLine());
		int sum = 0;
		int t = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer ns = new StringTokenizer(bf.readLine());
			int l = Integer.parseInt(ns.nextToken());
			int e = Integer.parseInt(ns.nextToken());
			if (i == 0) {
				t += e;
				sum = t;
				continue;
			}
			if (i == n - 1)
				continue;

			t = t - l + e;
			if (sum < t)
				sum = t;
		}
		out.print(sum);
		out.close();

	}

}
