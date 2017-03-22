package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A450 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(ns.nextToken());
		int m = Integer.parseInt(ns.nextToken());
		int[] a = new int[n];
		ns = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(ns.nextToken());
		int times = 0;
		int last = -1;
		for (int i = 0; i < n; i++)
			if (a[i] > m) {
				int x = (int) Math.ceil((a[i] - m) / (m * 1.0));
				if (x >= times) {
					times = x;
					last = i + 1;
				}
			}
		out.println(last == -1 ? n : last);
		out.close();
	}

}
