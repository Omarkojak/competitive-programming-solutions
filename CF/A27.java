package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A27 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int[] c = new int[3001];
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++)
			c[Integer.parseInt(ns.nextToken())]++;

		int j = 1;
		for (; j < 3001; j++)
			if (c[j] == 0)
				break;
		out.print(j);
		out.close();
	}

}
