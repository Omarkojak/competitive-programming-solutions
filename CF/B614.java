package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B614 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(bf.readLine());
		String res = "1";
		int z = 0;
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		for (int k = 0; k < n; k++) {
			String s = ns.nextToken();
			if (s.length() == 1 && s.charAt(0) == '0') {
				out.println(0);
				out.close();
				return;
			}
			int start = 0;
			for (int i = 0; i < s.length(); i++) {
				int r = s.charAt(i) - '0';
				if (r > 1) {
					res = s;
					start = 0;
					break;
				} else if (r == 1) {

					if (start > 0) {
						start = 0;
						res = s;
						break;
					} else
						start = i + 1;

				}
			}
			if (start > 0) {
				z += (s.length() - start);
			}

		}
		out.print(res);
		// out.print(z);
		while (z-- > 0)
			out.print(0);
		out.println();
		out.close();

	}

}
