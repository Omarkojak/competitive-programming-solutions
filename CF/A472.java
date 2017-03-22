package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class A472 {

	public static boolean check(int x) {
		for (int i = 2; i < x; i++)
			if (x % i == 0)
				return true;
		return false;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int n = Integer.parseInt(bf.readLine());
		boolean flag = false;
		int x = 2;
		while (!flag) {
			if (check(x))
				if (check(n - x)) {
					break;
				}
			x++;
		}
		out.println(x + " " + (n - x));
		out.close();
	}

}
