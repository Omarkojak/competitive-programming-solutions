package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class A492 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int n = Integer.parseInt(bf.readLine());
		int h = 1;
		int used = 1;
		int ls = 1;
		while (used < n) {

			if (ls + h + 1 + used > n)
				break;

			ls += h + 1;
			h++;
			used += ls;
		}
		out.println(h);
		out.close();

	}

}
