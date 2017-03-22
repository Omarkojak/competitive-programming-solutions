package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class A550 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = bf.readLine();

		if (!s.contains("AB") || !s.contains("BA"))
			out.println("NO");
		else {
			int ind = -1;
			for (int i = 0; i < s.length() - 1; i++)
				if (s.charAt(i) == 'A' && s.charAt(i + 1) == 'B') {
					ind = i;
					break;
				}

			String k = s.substring(0, ind) + "KK";
			if (ind + 2 < s.length())
				k += s.substring(ind + 2, s.length());
			boolean f1 = false;
			if (k.contains("BA"))
				f1 = true;
			ind = -1;
			for (int i = 0; i < s.length() - 1; i++)
				if (s.charAt(i) == 'B' && s.charAt(i + 1) == 'A') {
					ind = i;
					break;
				}

			String w = s.substring(0, ind) + "KK";
			if (ind + 2 < s.length())
				w += s.substring(ind + 2, s.length());
			boolean f2 = false;
			if (w.contains("AB"))
				f2 = true;

			out.println((f1 || f2) ? "YES" : "No");

		}

		out.flush();
		out.close();
	}

}
