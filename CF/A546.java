package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A546 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int k = Integer.parseInt(ns.nextToken());
		int w = Integer.parseInt(ns.nextToken());
		int n = Integer.parseInt(ns.nextToken());
		long sum = 0;

		for (int i = 1; i <= n; i++)
			sum += k * i;

		long result = sum - w;
		out.print(result < 0 ? 0 : result);
		out.close();

	}

}
