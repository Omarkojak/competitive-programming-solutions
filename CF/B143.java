package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B143 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		boolean neg = false;
		if (s.charAt(0) == '-') {
			neg = true;
			s = s.substring(1);
		}
		StringTokenizer ns = new StringTokenizer(s, ".");
		String integer = ns.nextToken();
		String floating = "00";
		if (ns.hasMoreTokens())
			floating = ns.nextToken() + "0";
		String res = "";
		int k = 1;
		for (int i = integer.length() - 1; i >= 0; i--, k++) {
			res = integer.charAt(i) + res;
			if (k % 3 == 0 && i != 0)
				res = "," + res;
		}
		res = "$" + res + "." + floating.charAt(0) + "" + floating.charAt(1);

		if (neg)
			res = "(" + res + ")";
		System.out.println(res);
	}

}
