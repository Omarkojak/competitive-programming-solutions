package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A448 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int csum = Integer.parseInt(ns.nextToken())
				+ Integer.parseInt(ns.nextToken())
				+ Integer.parseInt(ns.nextToken());

		ns = new StringTokenizer(bf.readLine());
		int msum = Integer.parseInt(ns.nextToken())
				+ Integer.parseInt(ns.nextToken())
				+ Integer.parseInt(ns.nextToken());

		int k = Integer.parseInt(bf.readLine());
		double s = Math.ceil(csum / 5.0) + Math.ceil(msum / 10.0);
		out.println(((int) s) <= k ? "YES" : "NO");
		out.close();
	}

}
