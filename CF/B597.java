package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B597 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int n = Integer.parseInt(bf.readLine());
		int start[] = new int[n];
		int max = 0;
		int[] end = new int[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer ns = new StringTokenizer(bf.readLine());
			start[i] = Integer.parseInt(ns.nextToken());
			end[i] = Integer.parseInt(ns.nextToken());
			max = Math.max(max, Math.max(start[i], end[i]));
		}
		int[] ends = new int[max + 1];
		for (int i = 0; i < n; i++) {
			if (ends[start[i]] == 0)
				ends[start[i]] = end[i];
			else
				ends[start[i]] = Math.min(end[i], ends[start[i]]);
		}
		int r = 0;
		for (int i = 0; i <= max;)
			if (ends[i] != 0) {
				r++;
				i = ends[i] + 1;
			} else
				i++;
		out.println(r);
		out.close();
	}

}
