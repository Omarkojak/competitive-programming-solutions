package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.TreeMap;

public class C4 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int n = Integer.parseInt(bf.readLine());
		TreeMap<String, Integer> mp = new TreeMap<String, Integer>();
		while (n-- > 0) {
			String s = bf.readLine();
			if (mp.containsKey(s)) {
				int v = mp.get(s);
				mp.put(s, v + 1);
				out.println(s + v);
			} else {
				mp.put(s, 1);
				out.println("OK");
			}
		}
		out.close();
	}

}
