package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A515 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int x = Math.abs(Integer.parseInt(ns.nextToken()));
		int y = Math.abs(Integer.parseInt(ns.nextToken()));
		int steps = Integer.parseInt(ns.nextToken());
		boolean flag = true;
		if (steps < x + y)
			flag = false;
		if ((x + y) % 2 != steps % 2)
			flag = false;
		out.println(flag ? "YES" : "NO");
		out.close();
	}

}
