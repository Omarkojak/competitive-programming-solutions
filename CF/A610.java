package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class A610 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int n = Integer.parseInt(bf.readLine());

		if (n <= 4)
			out.println(0);
		else {
			int r = 0;
			if (n % 4 == 0)
				r++;
			if (n % 2 == 0)
				out.print(n / 4 - r);
			else
				out.println(0);

		}
		out.close();

	}

}
