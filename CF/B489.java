package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B489 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int[] bo = new int[n];
		for (int i = 0; i < n; i++)
			bo[i] = Integer.parseInt(ns.nextToken());

		int m = Integer.parseInt(bf.readLine());
		ns = new StringTokenizer(bf.readLine());
		int[] g = new int[m];
		for (int i = 0; i < m; i++)
			g[i] = Integer.parseInt(ns.nextToken());
		Arrays.sort(bo);
		Arrays.sort(g);
		int res = 0;
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for (int i = 0; i < n; i++) {
			boolean found = false;
			for (int j = 0; j < m; j++) {
				if (Math.abs(bo[i] - g[j]) <= 1 && !ts.contains(j)) {
					found = true;
					ts.add(j);
					break;
				}
			}
			if (found)
				res++;
		}
		out.println(res);
		out.close();
	}

}
