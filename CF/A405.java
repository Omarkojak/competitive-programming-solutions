package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A405 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int n = Integer.parseInt(bf.readLine());
		int[] a = new int[n];
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int max = 0;
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(ns.nextToken());
			max = Math.max(max, a[i]);
		}
		boolean[][] m = new boolean[max + 1][n];

		for (int i = 0; i < n; i++) {
			int v = a[i];
			for (int j = max; v > 0; j--, v--)
				m[j][i] = true;
		}

		for (int i = 0; i < max + 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (!m[i][j])
					continue;
				boolean next = m[i][j + 1];
				int k;
				for (k = j + 2; next && k < n; k++)
					next = m[i][k];
				if (k == n && m[i][n - 1])
					break;

				m[i][k - 1] = true;
				m[i][j] = false;
			}
		}
		int[] r = new int[n];
		for (int i = 0; i < max + 1; i++)
			for (int j = 0; j < n; j++)
				if (m[i][j])
					r[j]++;

		for (int i = 0; i < n - 1; i++)
			out.print(r[i] + " ");
		out.print(r[n - 1]);
		out.close();

	}

}
