package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A25 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int n = Integer.parseInt(bf.readLine());
		int[] a = new int[n];
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(ns.nextToken());
		int indo = -1;
		int inde = -1;
		int o = 0, e = 0;
		for (int i = 0; i < n; i++)
			if (a[i] % 2 == 0) {
				e++;
				if (e > 1)
					inde = -1;
				else
					inde = i + 1;
			} else {
				o++;
				if (o > 1)
					indo = -1;
				else
					indo = i + 1;
			}
		out.println(Math.max(inde, indo));
		out.close();
	}

}
