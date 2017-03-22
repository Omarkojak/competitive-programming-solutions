package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A231 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int n = Integer.parseInt(bf.readLine());
		int r = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer ns = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(ns.nextToken())
					+ Integer.parseInt(ns.nextToken())
					+ Integer.parseInt(ns.nextToken());
			if (x >= 2)
				r++;
		}
		out.println(r);
		out.close();

	}

}
