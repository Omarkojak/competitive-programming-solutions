package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A401 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(ns.nextToken());
		int x = Integer.parseInt(ns.nextToken());
		int sum = 0;
		ns = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++)
			sum += Integer.parseInt(ns.nextToken());
		double s = (double) Math.abs(sum);
		double k = (double) (x);
		out.println((int) Math.ceil(s / k));
		out.close();
	}

}
