package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A149 {

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
		int k = Integer.parseInt(bf.readLine());
		int r;
		int[] a = new int[12];
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		for (int i = 0; i < 12; i++)
			a[i] = Integer.parseInt(ns.nextToken());
		shuffle(a);
		Arrays.sort(a);
		if (k == 0)
			out.println(0);
		else {
			r = 1;
			int sum = a[11];
			int i = 10;
			while (k > sum && i >= 0) {
				sum += a[i];
				i--;
				r++;
			}
			out.println(sum < k ? "-1" : r);
		}
		out.close();
	}

}
