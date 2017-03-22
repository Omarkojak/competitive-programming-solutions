package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class A509 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int n = Integer.parseInt(bf.readLine());
		int[][] m = new int[n][n];
		for (int i = 0; i < n; i++) {
			m[i][0] = 1;
			m[0][i] = 1;
		}
		for (int i = 1; i < n; i++)
			for (int j = 1; j < n; j++)
				m[i][j] = m[i - 1][j] + m[i][j - 1];

		out.println(m[n - 1][n - 1]);
		out.close();
	}

}
