package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A478 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int[] a = new int[5];
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			a[i] = Integer.parseInt(ns.nextToken());
			sum += a[i];
		}

		if (sum % 5 != 0 || sum == 0)
			out.println(-1);
		else {
			int b = sum / 5;
			int r = 0;
			int diff = 0;
			for (int i = 0; i < 5; i++) {
				diff = Math.abs(b - a[i]);
				r += (a[i] > b) ? -diff : diff;

			}
			out.println(r == 0 ? b : -1);

		}
		out.close();
	}

}
