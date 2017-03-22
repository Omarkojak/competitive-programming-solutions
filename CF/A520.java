package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.TreeSet;

public class A520 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int n = Integer.parseInt(bf.readLine());
		String s = bf.readLine();
		TreeSet<String> t = new TreeSet<String>();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			String k = (c + "").toLowerCase();
			t.add(k);
		}
		out.println(t.size() == 26 ? "YES" : "NO");
		out.close();
	}

}
