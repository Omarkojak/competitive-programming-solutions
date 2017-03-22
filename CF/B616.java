package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B616 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(ns.nextToken());
		int m = Integer.parseInt(ns.nextToken());
		int max = 0;
		for (int i = 0; i < n; i++) {
			ns = new StringTokenizer(bf.readLine());
			int min = Integer.parseInt(ns.nextToken());
			for (int j = 1; j < m; j++)
				min = Math.min(min, Integer.parseInt(ns.nextToken()));
			max = Math.max(max, min);
		}
		out.println(max);
		out.close();
	}

}
