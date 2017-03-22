package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A552 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int[][] m = new int[101][101];
		int n = Integer.parseInt(bf.readLine());
		while (n-- > 0) {
			StringTokenizer ns = new StringTokenizer(bf.readLine());
			int x1 = Integer.parseInt(ns.nextToken());
			int y1 = Integer.parseInt(ns.nextToken());
			int x2 = Integer.parseInt(ns.nextToken());
			int y2 = Integer.parseInt(ns.nextToken());
			for (int i = x1; i <= x2; i++)
				for (int j = y1; j <= y2; j++)
					m[i][j]++;

		}
		int r = 0;
		for (int i = 0; i < 101; i++)
			for (int j = 0; j < 101; j++)
				r += m[i][j];
		out.println(r);
		out.close();

	}

}
