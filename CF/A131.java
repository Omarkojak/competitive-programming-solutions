package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class A131 {

	public static boolean check(String s) {
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			String s1 = c + "";
			String s2 = c + "";
			String s3 = s2.toUpperCase();
			if (!s3.equals(s1))
				return false;

		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		String s = bf.readLine();

		if (check(s)) {
			String r = "";
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				String s2 = c + "";
				String s3 = s2.toUpperCase();
				if (s3.equals(s2))
					r += s2.toLowerCase();
				else
					r += s2.toUpperCase();
			}
			out.println(r);
		} else
			out.print(s);

		out.close();

	}

}
