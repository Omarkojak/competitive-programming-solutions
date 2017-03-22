package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class A59 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		String s = bf.readLine();
		int l = 0, u = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			String s1 = c + "";
			String s2 = (c + "").toUpperCase();
			if (s1.equals(s2))
				u++;
			else
				l++;
		}
		out.println(l >= u ? s.toLowerCase() : s.toUpperCase());
		out.close();
	}

}
