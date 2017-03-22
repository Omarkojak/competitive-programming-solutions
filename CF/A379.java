package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A379 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(ns.nextToken());
		int b = Integer.parseInt(ns.nextToken());
		int h = a;
		while (a >= b) {
			h += a / b;
			int c = a % b;
			a = a / b + c;
		}
		out.println(h);
		out.close();
	}

}
