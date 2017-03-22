package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A611 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int x = Integer.parseInt(ns.nextToken());
		String t = ns.nextToken();
		t = ns.nextToken();
		if (t.equals("month")) {
			if (x == 31)
				out.println(7);
			else {
				if (x > 29)
					out.println(11);
				else

					out.println(12);
			}
		} else {
			if (x == 5 || x == 6)
				out.println(53);
			else
				out.println(52);
		}
		out.close();
	}

}
