package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class A82 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int n = Integer.parseInt(bf.readLine());
		String[] s = { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
		int start = 1;
		int adder = 5;
		int v = -1;
		while (true) {
			if (n < start + adder) {
				int c = adder / 5;
				for (int i = 1; i <= 5; i++) {
					if (n < start + i * c) {
						v = i - 1;
						break;
					}
				}
				break;
			} else {
				start += adder;
				adder *= 2;

			}
		}
		out.println(s[v]);
		out.close();

	}

}
