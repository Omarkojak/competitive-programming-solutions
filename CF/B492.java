package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B492 {

	public static void shuffle(double[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * (n - i));
			double temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(ns.nextToken());
		int l = Integer.parseInt(ns.nextToken());
		double[] a = new double[n];
		ns = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Double.parseDouble(ns.nextToken());
		shuffle(a);
		Arrays.sort(a);
		double max = Math.max(a[0], l - a[n - 1]);
		for (int i = 0; i < n - 1; i++)
			max = Math.max(max, (a[i + 1] - a[i]) / 2.0);

		out.print(max);
		out.close();

	}

}
