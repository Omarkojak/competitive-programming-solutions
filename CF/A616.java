package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class A616 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		String s1 = bf.readLine();
		String s2 = bf.readLine();
		int i = 0;
		int j = 0;
		while (i < s1.length() && s1.charAt(i) == '0')
			i++;
		while (j < s2.length() && s2.charAt(j) == '0')
			j++;
		// out.println(i+" "+j);
		if (i == s1.length() && j == s2.length())
			out.println("=");
		else if (s1.length() - i > s2.length() - j)
			out.println(">");
		else if (s1.length() - i < s2.length() - j)
			out.println("<");
		else {
			String res = "";
			while (i < s1.length() && j < s2.length()) {
				int a1 = Integer.parseInt(s1.charAt(i) + "");
				int a2 = Integer.parseInt(s2.charAt(j) + "");
				if (a1 < a2) {
					res = "<";
					break;
				}
				if (a1 > a2) {
					res = ">";
					break;
				}
				i++;
				j++;
			}
			if (i == s1.length() && j == s2.length())
				out.println("=");
			else
				out.println(res);
		}
		out.close();
	}

}
