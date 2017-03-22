package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class A61 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		String s1 = bf.readLine();
		String s2 = bf.readLine();
		String r = "";
		for (int i = 0; i < s1.length(); i++) {
			int x1 = Integer.parseInt(s1.charAt(i) + "");
			int x2 = Integer.parseInt(s2.charAt(i) + "");
			r = r + (x1 ^ x2);
		}
		out.print(r);
		out.close();
	}

}
