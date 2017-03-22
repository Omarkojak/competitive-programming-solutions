package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A371 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(ns.nextToken());
		int k = Integer.parseInt(ns.nextToken());
		int[] a = new int[n];
		ns = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(ns.nextToken());
		int r = 0;
		for (int i = 0; i < k; i++) {
			int one = 0;
			int two = 0;
			for (int j = i; j < n; j += k) {
				if (a[j] == 1)
					one++;
				else
					two++;
			}
			r += Math.min(one, two);

		}
		out.println(r);
		out.close();
	}

}
