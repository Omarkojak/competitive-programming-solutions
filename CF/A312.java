package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class A312 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int n = Integer.parseInt(bf.readLine());
		String s;
		for (int i = 0; i < n; i++) {
			s = bf.readLine();
			String a1 = s.substring(0, 5);
			String a2 = s.substring(s.length() - 5, s.length());
			int r = 0;
			if (a1.equals("miao."))
				r++;
			if (a2.equals("lala."))
				r--;

			out.println(r == 0 ? "OMG>.< I don't know!" : r == -1 ? "Freda's"
					: "Rainbow's");
		}
		out.close();
	}

}
