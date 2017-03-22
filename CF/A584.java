package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A584 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(ns.nextToken());
		int t = Integer.parseInt(ns.nextToken());
		String s = "1";
		if (t == 10)
			if (n == 1)
				s = "-1";
			else
				for (int i = 1; i < n; i++)
					s += "0";
		else {
			s = t + "";
			for (int i = 1; i < n; i++)
				s += "0";
		}
		out.println(s);
		out.close();
	}

}
