package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A612 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(ns.nextToken());
		int p = Integer.parseInt(ns.nextToken());
		int q = Integer.parseInt(ns.nextToken());
		String s = bf.readLine();
		int x = 0;
		int y = 0;
		boolean flag = true;
		for (; x <= n && flag; x++)
			for (y = 0; y <= n && flag; y++)
				if (x * p + y * q == n)
					flag = false;

		if (flag)
			out.println(-1);
		else {
			x--;
			y--;
			out.println(x + y);
			while (x-- > 0) {
				out.println(s.substring(0, p));
				s = s.substring(p);
			}
			while (y-- > 0) {
				out.println(s.substring(0, q));
				s = s.substring(q);
			}
		}

		out.close();
	}

}
