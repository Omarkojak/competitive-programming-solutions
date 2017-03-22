package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A124 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(ns.nextToken());
		int a = Integer.parseInt(ns.nextToken());
		int b = Integer.parseInt(ns.nextToken());
		out.println(n - Math.max(a + 1, n - b) + 1);
		out.close();
	}

}
