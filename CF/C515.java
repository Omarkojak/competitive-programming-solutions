package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class C515 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		Integer.parseInt(bf.readLine());
		String s = bf.readLine();
		int[] c = new int[10];
		for (int i = 0; i < s.length(); i++) {
			int x = Integer.parseInt(s.charAt(i) + "");
			c[x]++;
		}
		if (c[9] != 0) {
			c[2] += 1 * c[9];
			c[3] += 2 * c[9];
			c[7] += 1 * c[9];
			c[9] = 0;
		}
		if (c[8] != 0) {
			c[7] += 1 * c[8];
			c[2] += 3 * c[8];
			c[8] = 0;
		}

		if (c[6] != 0) {
			c[5] += 1 * c[6];
			c[3] += 1 * c[6];
			c[6] = 0;
		}
		if (c[4] != 0) {
			c[2] += 2 * c[4];
			c[3] += 1 * c[4];
			c[4] = 0;
		}

		String r = "";
		for (int i = 7; i >= 2; i--)
			while (c[i]-- > 0)
				r += i;
		out.println(r);
		out.close();
	}

}
