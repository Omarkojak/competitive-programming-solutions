package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class A133 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		String s = bf.readLine();
		boolean flag = false;
		for (int i = 0; i < s.length(); i++) {
			String k = s.charAt(i) + "";
			if (k.equals("H") || k.equals("Q") || k.equals("9")) {
				flag = true;
				break;
			}
		}
		out.print(flag ? "YES" : "NO");
		out.close();
	}

}
