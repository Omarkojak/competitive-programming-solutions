package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A368 {

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
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(ns.nextToken());
		int d = Integer.parseInt(ns.nextToken());
		int r = 0;
		ns = new StringTokenizer(bf.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(ns.nextToken());
		int m = Integer.parseInt(bf.readLine());
		shuffle(a);
		Arrays.sort(a);
		for (int i = 1; i <= m; i++) {
			if (i > n)
				r -= d;
			else
				r += a[i - 1];
		}

		out.println(r);
		out.close();
	}

}
