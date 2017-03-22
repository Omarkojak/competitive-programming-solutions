package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class A556 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int l = Integer.parseInt(bf.readLine());
		String s = bf.readLine();
		int one = 0, zero = 0;
		for (int i = 0; i < l; i++) {
			if (s.charAt(i) == '1')
				one++;
			if (s.charAt(i) == '0')
				zero++;

		}
		out.println(Math.abs(zero - one));
		out.close();
	}

}
