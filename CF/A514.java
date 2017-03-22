package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class A514 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringBuilder s = new StringBuilder(bf.readLine());
		int l = s.length();
		for (int i = 0; i < l; i++) {
			int x = Integer.parseInt(s.charAt(i) + "");
			if (x == 9 && i == 0)
				continue;
			if (x > 4)
				x = 9 - x;
			s.replace(i, i + 1, x + "");
		}

		out.println(s);
		out.close();
	}

}
