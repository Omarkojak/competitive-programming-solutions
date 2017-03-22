package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class A551 {

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
		int[] b = new int[n];
		int[] a = new int[n];
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(ns.nextToken());
			a[i] = x;
			b[i] = x;
		}
		shuffle(b);
		Arrays.sort(b);
		TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();
		int c = 1;
		for (int i = n - 1; i >= 0; i--)
			if (m.containsKey(b[i]))
				c++;
			else {
				m.put(b[i], c);
				c++;
			}

		out.print(m.get(a[0]));
		for (int i = 1; i < n; i++)
			out.print(" " + m.get(a[i]));
		out.close();
	}

}
