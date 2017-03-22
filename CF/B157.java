package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B157 {

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
		int n = Integer.parseInt(bf.readLine());
		int[] a = new int[n];
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(ns.nextToken());
		shuffle(a);
		Arrays.sort(a);
		int radius = 0;
		int r = 1;
		for (int i = n - 1; i >= 0; i--) {
			if (r == 1) {
				if (i == 0)
					radius += a[i] * a[i];
				else
					radius += (a[i] * a[i] - a[i - 1] * a[i - 1]);
			}
			r ^= 1;
		}
		double res = radius * Math.PI;
		System.out.println(res);
	}

}
