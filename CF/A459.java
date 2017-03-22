package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A459 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int x1 = Integer.parseInt(ns.nextToken());
		int y1 = Integer.parseInt(ns.nextToken());
		int x2 = Integer.parseInt(ns.nextToken());
		int y2 = Integer.parseInt(ns.nextToken());
		String s = "-1";
		if (Math.abs(x2 - x1) != Math.abs(y2 - y1) && x1 != x2 && y1 != y2)
			s = "-1";
		else if (x2 == x1) {
			int diff = Math.abs(y2 - y1);
			s = (x1 + diff) + " " + y1 + " " + (x2 + diff) + " " + y2;
		} else if (y2 == y1) {
			int diff = Math.abs(x2 - x1);
			s = x1 + " " + (y1 + diff) + " " + x2 + " " + (y2 + diff);
		} else {
			int diff = Math.abs(x2 - x1);
			if (x2 > x1)
				s = (x1 + diff) + " " + y1 + " " + x1 + " " + y2;
			else
				s = (x2 + diff) + " " + y2 + " " + x2 + " " + y1;

		}
		out.println(s);
		out.close();
	}

}
