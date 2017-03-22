package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.TreeMap;

public class A141 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		String s1 = bf.readLine();
		String s2 = bf.readLine();
		String s3 = bf.readLine();
		TreeMap<Character, Integer> m = new TreeMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if (m.containsKey(c)) {
				int v = m.get(c);
				m.replace(c, v + 1);
			} else
				m.put(c, 1);
		}
		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			if (m.containsKey(c)) {
				int v = m.get(c);
				m.replace(c, v + 1);
			} else
				m.put(c, 1);
		}
		boolean flag = true;
		for (int i = 0; i < s3.length(); i++) {
			char c = s3.charAt(i);
			if (!m.containsKey(c)) {
				flag = false;
				break;
			}
			int v = m.get(c);
			if (v - 1 == 0)
				m.remove(c);
			m.replace(c, v - 1);
		}
		out.println((flag && m.isEmpty()) ? "YES" : "NO");
		out.close();
	}

}
