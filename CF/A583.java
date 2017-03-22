package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class A583 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int n = Integer.parseInt(bf.readLine());
		TreeSet<Integer> tx = new TreeSet<Integer>();
		TreeSet<Integer> ty = new TreeSet<Integer>();

		String s = "";
		for (int i = 1; i <= (n * n); i++) {
			StringTokenizer ns = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(ns.nextToken());
			int y = Integer.parseInt(ns.nextToken());
			if (!tx.contains(x) && !ty.contains(y)) {
				tx.add(x);
				ty.add(y);
				s += " " + i;
			}

		}
		out.println(s.substring(1));
		out.close();
	}

}
