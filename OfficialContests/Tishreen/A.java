package OfficialContests.Tishreen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class A {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(bf.readLine());
		int cse = 1;
		while(t-->0)
		{
			StringTokenizer ns = new StringTokenizer(bf.readLine());
			long ans1 = Long.parseLong(ns.nextToken()) * 3600 + Long.parseLong(ns.nextToken()) * 60+ Long.parseLong(ns.nextToken());		
			ns = new StringTokenizer(bf.readLine());
			long ans2 = Long.parseLong(ns.nextToken()) * 3600 + Long.parseLong(ns.nextToken()) * 60+ Long.parseLong(ns.nextToken());		
			out.printf("Case %d: %s\n", cse++, (ans1 == ans2)? "Yes":"No");
		}
		out.flush();
		out.close();
	}
	

}
