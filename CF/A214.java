package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A214 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(ns.nextToken());
		int m = Integer.parseInt(ns.nextToken());
		int cnt = 0;
		for (int a = 0; a * a <= n; a++) {
			int b = n - a * a;
			if (m == b * b + a)
				cnt++;
		}
		out.println(cnt);
		out.close();
	}

}
