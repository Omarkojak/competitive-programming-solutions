package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A327 {

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
		int max = -1;
		int start = 0;
		for (int i = 0; i < n; i++)
			if (a[i] == 1)
				start++;
		int s = 0;
		for (int i = 0; i < n; i++) {
			s = start;
			for (int j = i; j < n; j++) {
				if (a[j] == 0)
					s++;
				else
					s--;
				if (s > max)
					max = s;

			}
		}
		out.println(max);
		out.close();
	}

}
