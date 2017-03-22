package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A431 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int[] a = new int[5];
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		for (int i = 1; i < 5; i++)
			a[i] = Integer.parseInt(ns.nextToken());
		String s = bf.readLine();
		long r = 0;
		for (int i = 0; i < s.length(); i++)
			r += a[Integer.parseInt(s.charAt(i) + "")];
		out.println(r);
		out.close();
	}

}
