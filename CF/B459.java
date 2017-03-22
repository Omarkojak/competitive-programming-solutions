package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B459 {

	public static void shuffle(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * (n - i));
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

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
		shuffle(a);
		Arrays.sort(a);
		if (a[0] == a[a.length - 1]) {
			out.print(0 + " ");
			out.println(n * (long) (n - 1) / 2);
		} else {
			long c1 = 0;
			long c2 = 0;

			for (int i = 0; i < a.length; i++) {
				if (a[i] == a[0])
					c1++;
				if (a[a.length - 1] == a[i])
					c2++;
			}
			out.print(a[a.length - 1] - a[0]);
			out.println(" " + c1 * c2);

		}

		out.close();

	}

}
