package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class A384 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int n = Integer.parseInt(bf.readLine());
		int r = 0;
		char m[][] = new char[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				m[i][j] = '.';
		for (int i = 0; i < n; i++) {
			int j;
			if (i % 2 == 0)
				j = 0;
			else
				j = 1;
			for (; j < n; j += 2) {
				m[i][j] = 'C';
				r++;
			}

		}
		out.println(r);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				out.print(m[i][j]);
			out.println();
		}
		out.close();
	}

}
