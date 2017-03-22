package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A599 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int d1 = Integer.parseInt(ns.nextToken());
		int d2 = Integer.parseInt(ns.nextToken());
		int d3 = Integer.parseInt(ns.nextToken());
		int cost1 = d1 * 2 + d2 * 2;
		int cost2 = d1 + d3 + d2;
		int cost3 = d2 * 2 + d3 * 2;
		int cost4 = d1 * 2 + d3 * 2;
		out.println(Math.min(Math.min(cost1, cost2), Math.min(cost3, cost4)));
		out.close();
	}

}
