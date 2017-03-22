package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B609 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(ns.nextToken());
		int m = Integer.parseInt(ns.nextToken());
		int[] a = new int[n];
		int[] c = new int[m + 1];
		ns = new StringTokenizer(bf.readLine());

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(ns.nextToken());
			c[a[i]]++;
		}

		int r = 0;
		for (int i = 1; i < m; i++) {

			if (c[i] == 0)
				continue;

			int k = c[i];
			int w = c[i];
			while (c[i] > 0) {
				r += n - w;
				c[i]--;
			}
			n -= k;
		}
		out.print(r);
		out.close();
	}

}
