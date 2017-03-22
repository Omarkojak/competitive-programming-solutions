package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A427 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int n = Integer.parseInt(bf.readLine());
		int r = 0;
		int av = 0;
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(ns.nextToken());
			if (x == -1) {
				if (av == 0)
					r++;
				else
					av--;
			} else
				av += x;

		}
		out.println(r);
		out.close();
	}

}
